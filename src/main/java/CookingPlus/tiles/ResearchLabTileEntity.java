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

public class ResearchLabTileEntity extends CookingPlusCustomTileEntity implements ITickable, IInventory {

	private ItemStack[] inv;
	protected float speed;	
	protected boolean usedByBot;
	protected int UsedByBotTimer;
	protected float analysisTimer;
	
	public float toolMovement;
	public float rodMovement;
	protected boolean toolState;
	protected boolean rodState;
	
	public ResearchLabTileEntity(){
		inv = new ItemStack[1];
		Random myRand = new Random();
		toolMovement = 0;
		rodMovement = 0;
		toolState = true;
		rodState = true;
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
		if(usedByBot == true){
			moveModel();
		}
	}
	
	public void moveModel(){
		if(rodState == true){
			rodMovement += 0.001f / speed;
		}
		else{
			rodMovement -= 0.001f / speed;
		}
		
		if(toolState == true){
			toolMovement += 0.01f / speed;
		}
		else{
			toolMovement -= 0.01f / speed;
		}
		
		if(toolMovement > 0.7){
			toolState = false;
		}
		if(toolMovement < 0){
			toolState = true;
		}
		
		if(rodMovement > 0.2){
			rodState = false;
		}
		if(rodMovement < 0){
			rodState = true;
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
	
	public void updateRodState(boolean value){
		if(rodState != value){
			if(this.getWorld().isRemote == false){
				rodState = value;
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
		if(oldState.getBlock().equals(CookingPlusMain.blockResearch) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockResearch) == false){
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
		rodState = nbt.getBoolean("RS");
		rodMovement = nbt.getFloat("RM");
		
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
		nbt.setBoolean("RS", rodState);
		nbt.setFloat("RM", rodMovement);
		
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
