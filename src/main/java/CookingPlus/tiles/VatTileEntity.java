package CookingPlus.tiles;

import CookingPlus.CookingPlusMain;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class VatTileEntity extends TileEntity implements IInventory, IUpdatePlayerListBox {

	private ItemStack[] inv;
	private int EntityDirection;
	private int myAge;
	private int timer;
	private int myEntityType;
	
	public VatTileEntity() {
		inv = new ItemStack[1];
		EntityDirection = 0;
		myAge = 0;
		timer = 0;
		myEntityType = 0;
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
		if(myAge < 7 && myEntityType != 0){
			timer++;
		}
		else{
			timer = 0;
		}
		if(timer > 200){
			SetAge(myAge + 1);
			timer = 0;
		}
		
		if(!this.getWorld().isRemote){
			if(myAge >= 7){
				this.SpawnEntity();
			}
		}
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
		if(oldState.getBlock().equals(CookingPlusMain.blockVat) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockVat) == false){
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

		EntityDirection = nbt.getInteger("MyDirection");
		myAge = nbt.getInteger("Age");
		timer = nbt.getInteger("time");
		myEntityType = nbt.getInteger("type");
		
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbtTagCompound = nbttaglist.getCompoundTagAt(i);
			byte b0 = nbtTagCompound.getByte("Slot");

			if (b0 >= 0 && b0 < inv.length) {
				inv[b0] = ItemStack.loadItemStackFromNBT(nbtTagCompound);
			}
		}


	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		
		NBTTagList nbttaglist = new NBTTagList();
		
		nbt.setInteger("MyDirection", EntityDirection);
		nbt.setInteger("Age", myAge);
		nbt.setInteger("time", timer);
		nbt.setInteger("type", myEntityType);
		
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
	
	public void FillSlot(ItemStack myItem, int slot){
			if(!this.getWorld().isRemote){
			inv[slot] = myItem;
			UpdateBlock();
			}
		}
	 
	 public void UpdateBlock(){
			this.worldObj.markBlockForUpdate(this.getPos());
	}

	 public void processActivate(EntityPlayer playerIn) {
		if(playerIn.getCurrentEquippedItem() != null){
			if(myEntityType == 0){
				Item myItem = playerIn.getCurrentEquippedItem().getItem();
				if(myItem == CookingPlusMain.cowneedle){
					SetType(4);
					playerIn.setCurrentItemOrArmor(0, new ItemStack(CookingPlusMain.dirtyneedle));
				}
				else if(myItem == CookingPlusMain.chickenneedle){
					SetType(3);
					playerIn.setCurrentItemOrArmor(0, new ItemStack(CookingPlusMain.dirtyneedle));
				}
				else if(myItem == CookingPlusMain.sheepneedle){
					SetType(1);
					playerIn.setCurrentItemOrArmor(0, new ItemStack(CookingPlusMain.dirtyneedle));
				}
				else if(myItem == CookingPlusMain.pigneedle){
					SetType(2);
					playerIn.setCurrentItemOrArmor(0, new ItemStack(CookingPlusMain.dirtyneedle));
				}
				else if(myItem == CookingPlusMain.rabbitneedle){
					SetType(5);
					playerIn.setCurrentItemOrArmor(0, new ItemStack(CookingPlusMain.dirtyneedle));
				}
			}
		}	
	}

	 public void SetAge(int newamount){
			if(!this.getWorld().isRemote){
				if(newamount != myAge){
					myAge = newamount;
					UpdateBlock();
				}
			}
		}
	 
	 public void SetType(int newamount){
			if(!this.getWorld().isRemote){
				if(newamount != myEntityType){
					myEntityType = newamount;
					UpdateBlock();
				}
			}
		}

	public int GetAge(){
		return myAge;
	}
	
	public int GetType(){
		return myEntityType;
	}
	
	protected void SpawnEntity(){
		EntityAgeable myPig = new EntitySheep(this.getWorld());
		if(this.GetType() == 1){
			myPig = new EntitySheep(this.getWorld());
		}
		else if(this.GetType() == 2){
			myPig = new EntityPig(this.getWorld());
		}
		else if(this.GetType() == 3){
			myPig = new EntityChicken(this.getWorld());
		}
		else if(this.GetType() == 4){
			myPig = new EntityCow(this.getWorld());
		}
		else if(this.GetType() == 5){
			myPig = new EntityRabbit(this.getWorld());
		}
		myPig.setGrowingAge(-8);
		float offsetX = 0.5f;
		float offsetZ = 0.5f;
		if(this.getDirection() == 3){
			myPig.rotationYaw = 0 % 360.0F;
			myPig.prevRenderYawOffset = 0 % 360.0F;
			myPig.rotationYawHead = 0 % 360.0F;
			myPig.prevRotationYawHead = 0 % 360.0F;
			offsetX = 0.5f;
			offsetZ = 0.33f;
		}
		else if(this.getDirection() == 4){
			myPig.rotationYaw = 90 % 360.0F;
			myPig.prevRenderYawOffset = 90 % 360.0F;
			myPig.rotationYawHead = 90 % 360.0F;
			myPig.prevRotationYawHead = 90 % 360.0F;
			offsetZ = 0.5f;
			offsetX = 0.67f;
		}
		else if(this.getDirection() == 2){
			myPig.rotationYaw = 180 % 360.0F;
			myPig.prevRenderYawOffset = 180 % 360.0F;
			myPig.rotationYawHead = 180 % 360.0F;
			myPig.prevRotationYawHead = 180 % 360.0F;
			offsetX = 0.5f;
			offsetZ = 0.67f;
		}
		else if(this.getDirection() == 5){
			myPig.rotationYaw = 270 % 360.0F;
			myPig.prevRenderYawOffset = 270 % 360.0F;
			myPig.rotationYawHead = 270 % 360.0F;
			myPig.prevRotationYawHead = 270 % 360.0F;
			offsetZ = 0.5f;
			offsetX = 0.33f;
		}
		myPig.setGrowingAge(-500);
		if(getBestPosition() != null){
			myPig.setPosition(getBestPosition().getX() + 0.5f, getBestPosition().getY() + 0.5f, getBestPosition().getZ() + 0.5f);
			if(this.getWorld().spawnEntityInWorld(myPig)){
				SetAge(0);
				SetType(0);
			}
		}
	}
	
	protected BlockPos getBestPosition(){
		
		if(this.getWorld().getBlockState(getPos().west()).getBlock() == Blocks.air){
			return getPos().west();
		}
		if(this.getWorld().getBlockState(getPos().east()).getBlock() == Blocks.air){
			return getPos().east();
		}
		if(this.getWorld().getBlockState(getPos().north()).getBlock() == Blocks.air){
			return getPos().north();
		}
		if(this.getWorld().getBlockState(getPos().south()).getBlock() == Blocks.air){
			return getPos().south();
		}
		return null;
	}
}
