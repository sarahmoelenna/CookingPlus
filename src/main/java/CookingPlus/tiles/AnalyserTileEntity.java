package CookingPlus.tiles;

import scala.util.Random;
import CookingPlus.CookingPlusMain;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

public class AnalyserTileEntity extends CookingPlusCustomTileEntity implements ITickable, IInventory {

	private ItemStack[] inv;
	public float layeronerotation;
	public float layertworotation;
	public boolean layerOneState;
	public boolean layerTwoState;
	protected float speed;	
	protected boolean usedByBot;
	protected int UsedByBotTimer;
	protected float analysisTimer;
	
	public AnalyserTileEntity(){
		inv = new ItemStack[2];
		Random myRand = new Random();
		layeronerotation = myRand.nextInt(138) - 69;
		layertworotation = myRand.nextInt(138) - 69;
		layerOneState = myRand.nextBoolean();
		layerTwoState = myRand.nextBoolean();
		UsedByBotTimer = 0;
		usedByBot = false;
		speed = 0;
		analysisTimer = 0;
	}
	
	@Override
    public void update(){
		if(this.getWorld().isRemote == false){
			
			if(usedByBot == true){
				UsedByBotTimer++;
			}
			if(UsedByBotTimer >= 5){
				updateBeingUsed(false);
				updateSpeed(1);
			}
		}
		else{
			if(usedByBot == true){
				moveModel();
			}
		}
	}
	
	public void moveModel(){
		if(layerOneState == true){
			layeronerotation+= 1 /speed;
		}
		else{
			layeronerotation-= 1 /speed;
		}
		
		if(layerTwoState == true){
			layertworotation+= 0.5f/speed;
		}
		else{
			layertworotation-= 0.5f/speed;
		}
		
		if(layeronerotation > 70){
			layerOneState = false;
		}
		if(layeronerotation < -70){
			layerOneState = true;
		}
		
		if(layertworotation > 70){
			layerTwoState = false;
		}
		if(layertworotation < -70){
			layerTwoState = true;
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

	
	@Override
	public String getName() {
		return null;
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
	public ItemStack getStackInSlot(int index) {
		return inv[index];
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
	public void openInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return false;
	}

	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		
	}

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public void clear() {
		
	}
	
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
		if(oldState.getBlock().equals(CookingPlusMain.blockAnalyser) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockAnalyser) == false){
				world.removeTileEntity(pos);
			}
		}
        return false;
    }

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);

		
		usedByBot = nbt.getBoolean("UB");
		analysisTimer = nbt.getFloat("AT");
		speed = nbt.getFloat("SP");
		
		NBTTagList nbttaglist = nbt.getTagList("Items", 10);
		
		inv = new ItemStack[getSizeInventory()];
		
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
		nbt.setFloat("SP", speed);
		nbt.setFloat("AT", analysisTimer);
		
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


	

}
