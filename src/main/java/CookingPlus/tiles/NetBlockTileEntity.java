package CookingPlus.tiles;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.CookingPlusMain;

public class NetBlockTileEntity extends CookingPlusCustomTileEntity implements IInventory, ITickable {

	private int EntityDirection;
	private ItemStack[] inv;
	
	public NetBlockTileEntity() {
		EntityDirection = 0;
		inv = new ItemStack[1];
		
	}

	public void processActivate(EntityPlayer Player) {
		if(Player.isSneaking()){
			if(inv[0] != null){
				Player.dropItem(inv[0], false);
				inv[0] = null;
			}
		}
		else{
			if(Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND) != null){
				if(Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).getItem() == Item.getItemFromBlock(CookingPlusMain.blockKelpCrop)){
					if(inv[0] == null){
						setInventorySlotContents(0, new ItemStack(Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).getItem(), 1));
						if(Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).stackSize == 1){
							Player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, null);
						}
						else{
							ItemStack myStack = Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND);
							myStack.stackSize--;
							Player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, myStack);
						}
					}
				}
			}
		}
		UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
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
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		

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

		return super.writeToNBT(nbt);
	}

	@Override
    public SPacketUpdateTileEntity getUpdatePacket()
    {
		NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);
		return new SPacketUpdateTileEntity(this.getPos(), 1, tag);
    }

	@Override
	public void onDataPacket(NetworkManager net,SPacketUpdateTileEntity packet) {
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
	public ItemStack removeStackFromSlot(int slot) {
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
	public ITextComponent getDisplayName() {
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
		if(parWorld.getBlockState(myPos.east()).getBlock().getMaterial(parWorld.getBlockState(myPos.east())) == Material.WATER){
			if(parWorld.getBlockState(myPos.west()).getBlock().getMaterial(parWorld.getBlockState(myPos.west())) == Material.WATER){
				if(parWorld.getBlockState(myPos.north()).getBlock().getMaterial(parWorld.getBlockState(myPos.north())) == Material.WATER){
					if(parWorld.getBlockState(myPos.south()).getBlock().getMaterial(parWorld.getBlockState(myPos.south())) == Material.WATER){
						if(parWorld.getBlockState(myPos.up()).getBlock().getMaterial(parWorld.getBlockState(myPos.up())) == Material.WATER){
							return true;
						}
					}
				}
			}
		}
		return false;
    }
}
