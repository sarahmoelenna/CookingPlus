package CookingPlus.tiles;

import java.util.Random;

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
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.CookingPlusMain;

public class LiquidBarrelTileEntity extends TileEntity implements IInventory, IUpdatePlayerListBox {

	private int EntityDirection;
	private ItemStack[] inv;
	private String myLiquid;
	private int age;
	
	public LiquidBarrelTileEntity() {
		EntityDirection = 0;
		inv = new ItemStack[1];
		myLiquid = "empty";
		age = 0;
	}

	public void processActivate(EntityPlayer Player) {
		if(Player.isSneaking()){
			
		}
		else{
			if(Player.getCurrentEquippedItem() != null){
				Item playerItem = Player.getCurrentEquippedItem().getItem();
				if(myLiquid.equals("empty")){
					if(playerItem == Items.water_bucket){
						Player.setCurrentItemOrArmor(0, new ItemStack(Items.bucket, 1));
						SetLiquid("water");
					}
					if(playerItem == CookingPlusMain.creambucket){
						Player.setCurrentItemOrArmor(0, new ItemStack(Items.bucket, 1));
						SetLiquid("cream");
					}
				}
				if(playerItem == Items.bucket){
					if(myLiquid.equals("water")){
						if(Player.getCurrentEquippedItem().stackSize > 1){
							ItemStack mystack = new ItemStack(Player.getCurrentEquippedItem().getItem(), Player.getCurrentEquippedItem().stackSize - 1);
							Player.setCurrentItemOrArmor(0, mystack);
						}
						else{
							Player.setCurrentItemOrArmor(0, null);
						}
						if(Player.inventory.addItemStackToInventory(new ItemStack(Items.water_bucket)) == false){
							Player.dropPlayerItemWithRandomChoice(new ItemStack(Items.water_bucket), false);
						}
						SetLiquid("empty");
					}
				}
			}
			else{
				if(!myLiquid.equals("empty")){
					if(myLiquid.equals("cheddar")){
						//if(Player.inventory.addItemStackToInventory(new ItemStack(CookingPlusMain.cheddarwedge, 4)) == false){
							Player.dropPlayerItemWithRandomChoice(new ItemStack(CookingPlusMain.cheddarwedge, 4), false);
						//}
						SetLiquid("empty");
					}
					if(myLiquid.equals("cc")){
						//if(Player.inventory.addItemStackToInventory(new ItemStack(CookingPlusMain.creamwedge , 4)) == false){
							Player.dropPlayerItemWithRandomChoice(new ItemStack(CookingPlusMain.creamwedge, 4), false);
						//}
						SetLiquid("empty");
					}
					if(myLiquid.equals("blue")){
						//if(Player.inventory.addItemStackToInventory(new ItemStack(CookingPlusMain.bluewedge, 4)) == false){
							Player.dropPlayerItemWithRandomChoice(new ItemStack(CookingPlusMain.bluewedge, 4), false);
						//}
						SetLiquid("empty");
					}
					if(myLiquid.equals("halloumi")){
						//if(Player.inventory.addItemStackToInventory(new ItemStack(CookingPlusMain.halloumiwedge, 4)) == false){
							Player.dropPlayerItemWithRandomChoice(new ItemStack(CookingPlusMain.halloumiwedge, 4), false);
						//}
						SetLiquid("empty");
					}
					
				}
			}
		}
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
		
		if(canAge()){
			age += myRand.nextInt(2);
		}
		if(age > 200){
			processLiquid();
		}
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
		if(oldState.getBlock().equals(CookingPlusMain.blockLiquidBarrel) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockLiquidBarrel) == false){
				world.removeTileEntity(pos);
			}
		}
        return false;
    }

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);

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
		myLiquid = nbt.getString("LI");


	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);

		//nbt.setInteger("MyMoveState", MoveState);
		//nbt.setFloat("MyMovement", MovementTimer);
		//nbt.setInteger("MyButterState", ButterState);
		nbt.setInteger("MyDirection", EntityDirection);
		nbt.setString("LI", myLiquid);
		
		
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

	public boolean canAge(){
		if(myLiquid.equals("cream")){
			return true;
		}
		else{
			return false;
		}
	}

	public void SetLiquid(String newLiquid){
		if(!this.getWorld().isRemote){
			if(newLiquid != myLiquid){
				myLiquid = newLiquid;
				UpdateBlock();
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	public String getLiquid(){
		return myLiquid;
	}
	
	public void processLiquid(){
		if(myLiquid.equals("cream")){
			BiomeGenBase myBiome = this.worldObj.getBiomeGenForCoords(getPos());
			if(BiomeDictionary.isBiomeOfType(myBiome, Type.SWAMP)){
				SetLiquid("blue");
				age = 0;
			}
			else if(BiomeDictionary.isBiomeOfType(myBiome, Type.SANDY)){
				SetLiquid("halloumi");
				age = 0;
			}
			else if(this.worldObj.getLightFromNeighbors(getPos().up()) <5){
				SetLiquid("cheddar");
				age = 0;
			}
			else{
				SetLiquid("cc");
				age = 0;
			}
		}
	}
	
	public void UpdateBlock(){
		//System.out.println("update tile entity for client");
		this.worldObj.markBlockForUpdate(this.getPos());
	}
}
