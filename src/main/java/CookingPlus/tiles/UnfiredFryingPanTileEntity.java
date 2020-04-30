package CookingPlus.tiles;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.CookingPlusMain;
import CookingPlus.recipes.CookingPlusFryingPanRecipes;

public class UnfiredFryingPanTileEntity extends CookingPlusCustomTileEntity implements IInventory, ITickable {

	private int EntityDirection;
	private ItemStack[] inv;
	private boolean canBoil;
	private int LiquidAmount;
	private int BoilAmount;
	
	public UnfiredFryingPanTileEntity() {
		EntityDirection = 0;
		inv = new ItemStack[3];
		canBoil = false;
		LiquidAmount = 0;
		BoilAmount = 0;
	}

	public void processActivate(EntityPlayer Player) {
		
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
		if(this.getWorld().isRemote == false){

		if(inv[0] != null){
			if(inv[0].getItem() == CookingPlusMain.vegetableoil){
				if(LiquidAmount < 10){
					LiquidAmount++;
					inv[0] = new ItemStack(Items.GLASS_BOTTLE, 1);
				}
			}
		}
		
		if(this.getWorld().getBlockState(this.getPos().down().down()) != null){
    		if(this.getWorld().getBlockState(this.getPos().down()).getBlock() == CookingPlusMain.blockHeater){
    			canBoil = ((HeaterTileEntity)this.getWorld().getTileEntity(this.getPos().down())).isServerBurning();
    			//canBoil = true;
    		}
    		else{
    			canBoil = false;
    		}
		}
		
		if(canBoil && ShouldCook()){
			BoilAmount++;
			if(BoilAmount > 200){
				BoilAmount = 200;
				ProcessSlot();
			}
		}
		else{
			BoilAmount = 0;
		}
		
		
		
		UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
		}
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
		if(oldState.getBlock().equals(CookingPlusMain.blockUnfiredFryingPan) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockUnfiredFryingPan) == false){
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
		canBoil = nbt.getBoolean("CB");
		LiquidAmount = nbt.getInteger("LA");
		BoilAmount = nbt.getInteger("BA");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		

		//nbt.setInteger("MyMoveState", MoveState);
		//nbt.setFloat("MyMovement", MovementTimer);
		//nbt.setInteger("MyButterState", ButterState);
		nbt.setInteger("MyDirection", EntityDirection);
		nbt.setBoolean("CB", canBoil);
		nbt.setInteger("LA", LiquidAmount);
		nbt.setInteger("BA", BoilAmount);
		
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
	
	protected void ProcessSlot(){
		System.out.println(inv[1].getItem().getUnlocalizedName());
		//System.out.println(CookingPlusOvenRecipes.instance().getOvenResult(inv[1]).getItem().getUnlocalizedName());
		if(fillSlot(2, CookingPlusFryingPanRecipes.instance().getFryingPanResult(inv[1]))){
			LiquidAmount--;
			if(replaceWithBowl(inv[1]) == false){
				if(inv[1].stackSize == 1){
					inv[1] = null;
				}
				else{
					inv[1] = decrStackSize(1,inv[1].stackSize--);
				}
			}
			else{
				inv[1] = new ItemStack(Items.BOWL);
			}
			
			BoilAmount = 0;
		}

	}

	public void SetCanBoil(boolean In){
		canBoil = In;
	}
	
	@SideOnly(Side.CLIENT)
	 public int getBoilAmount(int scale)
	    {
		 //System.out.println(this.CookTimer[slotNum] * scale / 100);
	        return (int) (this.BoilAmount * scale / 200);
	        // 0;
	    }
	
	@SideOnly(Side.CLIENT)
	public int getLiquidAmount(){
		return LiquidAmount;
	}

	public boolean fillSlot(int slotNum, ItemStack MyStack){
		
		if(inv[slotNum] == null){
			System.out.println(MyStack.getItem().getUnlocalizedName());
			inv[slotNum] = MyStack.copy();
			return true;
		}
		else if(inv[slotNum].getItem().equals(MyStack.getItem()) && inv[slotNum].stackSize < 64 - (MyStack.stackSize - 1)){
			inv[slotNum].stackSize += MyStack.stackSize;
			return true;
		}
		else{
			return false;
		}
	}
	
	 public boolean replaceWithBowl(ItemStack myStack){
		 if(myStack.getItem().equals(CookingPlusMain.pancakemix)){
			 return true;
		 }
		 else{
			 return false;
		 }
	 }

	 public boolean ShouldCook(){
		 if(inv[1] == null){
			 return false;
		 }
		 else{
			 if(CookingPlusFryingPanRecipes.instance().getFryingPanResult(inv[1]) != null && LiquidAmount > 0){
				 return true;
			 }
		 }
		 return false;
	 }
}
