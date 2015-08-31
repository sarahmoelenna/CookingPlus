package CookingPlus.tiles;

import java.util.Random;

import CookingPlus.CookingPlusMain;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class NetBlockTileEntity extends TileEntity implements IInventory, IUpdatePlayerListBox {

	private int EntityDirection;
	private ItemStack[] inv;
	
	public NetBlockTileEntity() {
		EntityDirection = 0;
		inv = new ItemStack[1];
		
	}

	public void processActivate(EntityPlayer Player) {
		if(Player.isSneaking()){
			if(inv[0] != null){
				Player.dropPlayerItemWithRandomChoice(inv[0], false);
				inv[0] = null;
			}
		}
		else{
			if(Player.getCurrentEquippedItem() != null){
				if(Player.getCurrentEquippedItem().getItem() == Item.getItemFromBlock(CookingPlusMain.blockKelpCrop)){
					if(inv[0] == null){
						setInventorySlotContents(0, new ItemStack(Player.getCurrentEquippedItem().getItem(), 1));
						if(Player.getCurrentEquippedItem().stackSize == 1){
							Player.setCurrentItemOrArmor(0, null);
						}
						else{
							ItemStack myStack = Player.getCurrentEquippedItem();
							myStack.stackSize--;
							Player.setCurrentItemOrArmor(0, myStack);
						}
					}
				}
			}
		}
		this.worldObj.markBlockForUpdate(pos);
	}
	
	public void setDirection(int Direction) {
		EntityDirection = Direction;
		//System.out.println(EntityDirection  + " set");
	}

	@SideOnly(Side.CLIENT)
	public int getDirection() {
		//System.out.println(EntityDirection + " get");
		return EntityDirection;
	}

	@Override
    public void update(){
		Random myRand = new Random();
		if(isValidPlace(this.worldObj, this.pos)){
			if(BiomeDictionary.isBiomeOfType(this.worldObj.getBiomeGenForCoords(pos), Type.OCEAN)){
				if(myRand.nextInt(5000) == 0){
					if(inv[0] != null){
						if(getPossibleOceanItem(inv[0].getItem(), myRand) != null){
							inv[0] = getPossibleOceanItem(inv[0].getItem(), myRand);
						}
					}
				}
			}
		}
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
		if(oldState.getBlock().equals(CookingPlusMain.blockNetBlock) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockNetBlock) == false){
				world.removeTileEntity(pos);
			}
		}
        return false;
    }

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);

		//MoveState = nbt.getInteger("MyMoveState");
		//MovementTimer = nbt.getFloat("MyMovement");
		//ButterState = nbt.getInteger("MyButterState");
		NBTTagList nbttaglist = nbt.getTagList("Items", 10);
		inv = new ItemStack[getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbtTagCompound = nbttaglist.getCompoundTagAt(i);
			byte b0 = nbtTagCompound.getByte("Slot");

			if (b0 >= 0 && b0 < inv.length) {
				inv[b0] = ItemStack.loadItemStackFromNBT(nbtTagCompound);
			}
		}
		
		EntityDirection = nbt.getInteger("MyDirection");


	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);

		//nbt.setInteger("MyMoveState", MoveState);
		//nbt.setFloat("MyMovement", MovementTimer);
		//nbt.setInteger("MyButterState", ButterState);
		nbt.setInteger("MyDirection", EntityDirection);
		
		
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < inv.length; ++i) {
			if (inv[i] != null) {
				NBTTagCompound nbtTagCompound = new NBTTagCompound();
				nbtTagCompound.setByte("Slot", (byte) i);
				inv[i].writeToNBT(nbtTagCompound);
				nbttaglist.appendTag(nbtTagCompound);
			}
		}

		nbt.setTag("Items", nbttaglist);


	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);
		return new S35PacketUpdateTileEntity(this.getPos(), 1, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net,S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.getNbtCompound());
	}

	@Override
	public int getSizeInventory() {
		return inv.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return inv[slot];
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		inv[slot] = stack;
		if (stack != null && stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public ItemStack decrStackSize(int slot, int amt) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			if (stack.stackSize <= amt) {
				setInventorySlotContents(slot, null);
			} else {
				stack = stack.splitStack(amt);
				if (stack.stackSize == 0) {
					setInventorySlotContents(slot, null);
				}
			}
		}
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			setInventorySlotContents(slot, null);
		}
		return stack;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCustomName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IChatComponent getDisplayName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getTileEntity(this.getPos()) == this
				&& player.getDistanceSq(this.getPos().getX() + 0.5, this.getPos().getY() + 0.5,
						this.getPos().getZ() + 0.5) < 64;
	}

	@Override
	public void openInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	public ItemStack[] GetItems(){
		return inv;
	 }

	public ItemStack getPossibleOceanItem(Item currentItem, Random myRand){
		if(currentItem != null){
			if(currentItem == Item.getItemFromBlock(CookingPlusMain.blockKelpCrop)){
				int Which = myRand.nextInt(2);
				if(Which == 0){
					return new ItemStack(CookingPlusMain.shelledcrab);
				}
				else if(Which == 1){
					return new ItemStack(CookingPlusMain.shelledlobster);
				}
			}
		}
		return null;
	}
	
	public boolean isValidPlace(World parWorld, BlockPos myPos)
    {
		if(parWorld.getBlockState(myPos.east()).getBlock().getMaterial() == Material.water){
			if(parWorld.getBlockState(myPos.west()).getBlock().getMaterial() == Material.water){
				if(parWorld.getBlockState(myPos.north()).getBlock().getMaterial() == Material.water){
					if(parWorld.getBlockState(myPos.south()).getBlock().getMaterial() == Material.water){
						if(parWorld.getBlockState(myPos.up()).getBlock().getMaterial() == Material.water){
							return true;
						}
					}
				}
			}
		}
		return false;
    }
}
