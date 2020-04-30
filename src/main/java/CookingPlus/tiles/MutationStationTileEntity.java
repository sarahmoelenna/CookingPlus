package CookingPlus.tiles;

import CookingPlus.CookingPlusMain;
import CookingPlus.recipes.MutationStationRecipeHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MutationStationTileEntity extends CookingPlusCustomTileEntity implements IInventory, ITickable {

	private ItemStack[] inv;
	private int chargesRemaing;
	private int mutateTimer;
	private boolean usedByBot;
	private int UsedByBotTimer;
	private float speed;
	
	public MutationStationTileEntity(){
		inv = new ItemStack[2];
		chargesRemaing = 0;
		mutateTimer = 0;
		usedByBot = false;
		UsedByBotTimer = 0;
		speed = 1;
	}
	
	@Override
	public void update() {
		if(chargesRemaing > 0 && usedByBot == true){
			if(validMutationItem() == true){
				//System.out.println(1 / speed);
				mutateTimer+= 1 / speed;
			}
			else{
				mutateTimer = 0;
			}
			if(mutateTimer > 2000){
				mutateTimer = 2000;
			}
		}
		else{
			mutateTimer = 0;
		}
		if(this.getWorld().isRemote == false){
			if(usedByBot == true){
				UsedByBotTimer++;
			}
			if(UsedByBotTimer >= 5){
				updateBeingUsed(false);
				updateSpeed(1);
			}
		}
		
	}
	
	public void updateByBot(float mySpeed) {
		
		if(this.getWorld().isRemote == false){
			updateBeingUsed(true);
			updateSpeed(mySpeed);
			processSlots();
		}
		
	}
	
	public void processSlots(){
		if(inv[0] != null && chargesRemaing == 0){
			if(inv[0].getItem() == CookingPlusMain.uraniumchunk){
				inv[0] = null;
				setChargesRemaining(5);
			}
		}
		if(inv[1] != null && mutateTimer == 2000){
			inv[1] = new ItemStack(MutationStationRecipeHandler.instance().getOutputForItem(inv[1].getItem()));
			setChargesRemaining(chargesRemaing - 1);
		}
	}
	
	public boolean validMutationItem(){
		if(inv[1] != null){
			if(MutationStationRecipeHandler.instance().canItemMutate(inv[1].getItem())){
				return true;
			}
		}
		return false;
	}

	public String getName() {
		return "Mutation Station";
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}

	@Override
	public ITextComponent getDisplayName() {
		return null;
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
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getTileEntity(this.getPos()) == this
				&& player.getDistanceSq(this.getPos().getX() + 0.5, this.getPos().getY() + 0.5,
						this.getPos().getZ() + 0.5) < 64;
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		if(slot < 0){
			
		}
		else if(slot == 1){
			
		}
		return false;
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

	public int getCharges(){
		return chargesRemaing;
	}
	
	public int getMutationTime(){
		return mutateTimer;
	}

	public void setChargesRemaining(int value){
		if(chargesRemaing != value){
			if(this.getWorld().isRemote==false){
				chargesRemaing = value;
				UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
			}
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);

		NBTTagList nbttaglist = nbt.getTagList("Items", 10);
		inv = new ItemStack[getSizeInventory()];

		usedByBot = nbt.getBoolean("UB");
		chargesRemaing = nbt.getInteger("C");
		mutateTimer = nbt.getInteger("MT");
		speed = nbt.getFloat("SP");
		
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbtTagCompound = nbttaglist.getCompoundTagAt(i);
			byte b0 = nbtTagCompound.getByte("Slot");

			if (b0 >= 0 && b0 < inv.length) {
				inv[b0] = ItemStack.loadItemStackFromNBT(nbtTagCompound);
			}
		}


	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		
		super.writeToNBT(nbt);
		
		NBTTagList nbttaglist = new NBTTagList();
		
		nbt.setBoolean("UB", usedByBot);
		nbt.setInteger("C", chargesRemaing);
		nbt.setInteger("MT", mutateTimer);
		nbt.setFloat("SP", speed);
		
		for (int i = 0; i < inv.length; ++i) {
			if (inv[i] != null) {
				NBTTagCompound nbtTagCompound = new NBTTagCompound();
				nbtTagCompound.setByte("Slot", (byte) i);
				inv[i].writeToNBT(nbtTagCompound);
				nbttaglist.appendTag(nbtTagCompound);
			}
		}

		nbt.setTag("Items", nbttaglist);

		return nbt;
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

	public void updateBeingUsed(boolean value){
		UsedByBotTimer = 0;
		if(usedByBot != value){
			if(this.getWorld().isRemote == false){
				usedByBot = value;
				UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
			}
		}
	}
	
	public void updateSpeed(float value){
		if(speed != value){
			if(this.getWorld().isRemote == false){
				speed = value;
				UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public int getTimeScaled(int scale)
	{
		return this.mutateTimer * scale / 2000;
	}
}
