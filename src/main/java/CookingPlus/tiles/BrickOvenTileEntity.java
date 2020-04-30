package CookingPlus.tiles;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.CookingPlusMain;
import CookingPlus.recipes.CookingPlusOvenRecipes;

public class BrickOvenTileEntity extends CookingPlusCustomTileEntity implements IInventory, ITickable, ISidedInventory {

	private int EntityDirection;
	private ItemStack[] inv;
	private int[] CookTimer;
	private int FuelTimer;

	public BrickOvenTileEntity() {
		inv = new ItemStack[19];
		CookTimer = new int [9];
		for(int i = 0; i < 9; i++){
			CookTimer[i] = 0;
		}
		FuelTimer = 0;
		EntityDirection = 0;
		//System.out.println(EntityDirection  + " created");
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


		String Direction;
		// Direction = nbt.getString("MyDirection");
		// System.out.println(Direction);
		EntityDirection = nbt.getInteger("MyDirection");
		//System.out.println(EntityDirection + " read");
		// System.out.println(EntityDirection);

	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {

		nbt.setInteger("MyDirection", EntityDirection);
		//System.out.println(EntityDirection + " write");

		// compound.setShort("GrindTime", (short)timeCanGrind);
		// compound.setShort("CookTime", (short)ticksGrindingItemSoFar);
		// compound.setShort("CookTimeTotal", (short)ticksPerItem);
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

		// if (hasCustomName())
		// {
		// compound.setString("CustomName", grinderCustomName);
		// }
		
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
		if(slot < 9){
			CookTimer[slot] = 0;
		}
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

	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
		if(oldState.getBlock().equals(CookingPlusMain.blockBrickOven) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockBrickOven) == false){
				world.removeTileEntity(pos);
			}
		}
        return false;
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
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		if(slot < 9){
			if(itemstack.getItem().equals(Item.getItemFromBlock(Blocks.LOG))){
				return false;
			}
			else if(itemstack.getItem().equals(Item.getItemFromBlock(Blocks.LOG2))){
				return false;
			}
			else if(itemstack.getItem().equals(Item.getItemFromBlock(Blocks.PLANKS))){
				return false;
			}
			else if(itemstack.getItem().equals(Items.COAL)){
				return false;
			}
			else if(itemstack.getItem().equals(Items.LAVA_BUCKET)){
				return false;
			}
			else{
				return true;
			}
		}
		else if(slot == 9){
			//System.out.println(itemstack.getDisplayName());
			if(itemstack.getItem().equals(Item.getItemFromBlock(Blocks.LOG))){
				return true;
			}
			if(itemstack.getItem().equals(Item.getItemFromBlock(Blocks.LOG2))){
				return true;
			}
			if(itemstack.getItem().equals(Item.getItemFromBlock(Blocks.PLANKS))){
				return true;
			}
			if(itemstack.getItem().equals(Items.COAL)){
				return true;
			}
			if(itemstack.getItem().equals(Items.LAVA_BUCKET)){
				return true;
			}
		}
		else if(slot >= 10){
			return false;
		}
		return false;
	}

	@Override
    public void update()
    {
		//System.out.println(EntityDirection  + " update");
		if(FuelTimer > 0){
			FuelTimer --;
		}
		else{
			Refuel();
		}
		
		if(FuelTimer > 0){
			for(int i = 0; i < 9; i++){
				if(inv[i] == null){
					CookTimer[i] = 0;
				}
				if(CookingPlusOvenRecipes.instance().getOvenResult(inv[i]) != null){
					ProcessSlot(i);
				}
			}
		}
		else{
			if(inv[9] == null){
				for(int i = 0; i < 9; i++){
					CookTimer[i] = 0;
				}
			}
			else if(isItemValidForSlot(9, inv[9]) == false){
				for(int i = 0; i < 9; i++){
					CookTimer[i] = 0;
				}
			}
		}
    }
	
	public boolean fillSlot(int slotNum, ItemStack MyStack){
		
		if(inv[slotNum] == null){
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
	
	protected void ProcessSlot(int i){
		
		if(CookTimer[i] > 100){
			if(fillSlot(i + 10, CookingPlusOvenRecipes.instance().getOvenResult(inv[i]))){
			
				if(GetReplaceItem(inv[i]) == null){
					if(inv[i].stackSize == 1){
						inv[i] = null;
					}
					else{
						inv[i] = decrStackSize(i,inv[i].stackSize--);
					}
				}
				else{
					inv[i] = GetReplaceItem(inv[i]);
				}
				
				CookTimer[i] = 0;
			}
		}
		else{
			CookTimer[i]++;
		}

	}

	public int getBurnTimeRemainingScaled(int p_145955_1_)
    {
        //if (this.FuelTimer == 0)
        //{
        //    this.FuelTimer = 200;
        //}

        return this.FuelTimer * p_145955_1_ / 320;
    }
	 
	 @SideOnly(Side.CLIENT)
	 public int getBurnTimeRemainingScaled()
	 {
	     return 10;
	 }
	 
	 @SideOnly(Side.CLIENT)
	 public boolean isBurning()
	 {
		 if(FuelTimer > 0){
			 return true;
		 }
		 else return false;
	 }

	 public void Refuel(){
		 if(needRefuel()){
			 if(inv[9] != null){
				 if(isItemValidForSlot(9, inv[9]) == true){
					 FuelTimer = getItemBurnTime(inv[9]);
					 if(inv[9].stackSize == 1){
						 inv[9] = null;
					 }
					 else{
						 inv[9] = decrStackSize(9,inv[9].stackSize--);
					 }
				 }
			 }
		 }
	 }

	 public boolean needRefuel(){
		 boolean refuel = false;
		 
		 for(int i = 0; i < 9; i++){
			 if(inv[i] != null){
				 if(CookingPlusOvenRecipes.instance().getOvenResult(inv[i]) != null){
					 if(canSlotBeCooked(i) == true){
						 return true;
					 }
				 }
			 }
		 }
		 return false;
		 
	 }

	 public boolean canSlotBeCooked(int slotNum){
		 if(inv[slotNum] != null){
			 if(inv[slotNum + 10] == null){
				 return true;
			 }
			 else if(inv[slotNum + 10].stackSize < 64){
				 if(inv[slotNum + 10].getItem().equals(CookingPlusOvenRecipes.instance().getOvenResult(inv[slotNum]).getItem())){
					 if(inv[slotNum + 10].stackSize < inv[slotNum + 10].getItem().getItemStackLimit(inv[slotNum + 10])){
						 return true;
					 }
				 }
			}
		 }
		 return false;
	 }

	 public int getItemBurnTime(ItemStack myStack){
		 	if(myStack.getItem().equals(Item.getItemFromBlock(Blocks.LOG))){
				return 80;
			}
			if(myStack.getItem().equals(Item.getItemFromBlock(Blocks.LOG2))){
				return 80;
			}
			if(myStack.getItem().equals(Item.getItemFromBlock(Blocks.PLANKS))){
				return 80;
			}
			if(myStack.getItem().equals(Items.COAL)){
				return 160;
			}
			if(myStack.getItem().equals(Items.LAVA_BUCKET)){
				return 320;
			}
		 return 0;
	 }

	 @SideOnly(Side.CLIENT)
	 public int getItemCook(int slotNum, int scale)
	    {
		 //System.out.println(this.CookTimer[slotNum] * scale / 100);
	        return this.CookTimer[slotNum]* scale / 100;
	    }

	 public ItemStack GetReplaceItem(ItemStack myStack){
		 if(myStack.getItem().equals(CookingPlusMain.cakebatter)){
			 return new ItemStack(CookingPlusMain.caketin);
		 }
		 else if(myStack.getItem().equals(CookingPlusMain.dough)){
			 return new ItemStack(CookingPlusMain.breadtin);
		 }
		 else if(myStack.getItem().equals(CookingPlusMain.bananadough)){
			 return new ItemStack(CookingPlusMain.breadtin);
		 }
		 else if(myStack.getItem().equals(CookingPlusMain.cookiebatter)){
			 return new ItemStack(Items.BOWL);
		 }else if(myStack.getItem().equals(CookingPlusMain.pancakemix)){
			 return new ItemStack(Items.BOWL);
		 }else if(myStack.getItem().equals(CookingPlusMain.traysponge)){
			 return new ItemStack(CookingPlusMain.cupcaketray);
		 }else if(myStack.getItem().equals(CookingPlusMain.traychocolate)){
			 return new ItemStack(CookingPlusMain.cupcaketray);
		 }else if(myStack.getItem().equals(CookingPlusMain.trayvelvet)){
			 return new ItemStack(CookingPlusMain.cupcaketray);
		 }else if(myStack.getItem().equals(CookingPlusMain.traylargesponge)){
			 return new ItemStack(CookingPlusMain.largecupcaketray);
		 }
		 else{
			 return null;
		 }
	 }

	 public ItemStack[] GetItems(){
		return inv;
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

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		int[] mySlotForFace = new int[19];
		mySlotForFace[0] = 0;
		mySlotForFace[1] = 1;
		mySlotForFace[2] = 2;
		mySlotForFace[3] = 3;
		mySlotForFace[4] = 4;
		mySlotForFace[5] = 5;
		mySlotForFace[6] = 6;
		mySlotForFace[7] = 7;
		mySlotForFace[8] = 8;
		mySlotForFace[9] = 9;
		mySlotForFace[10] = 10;
		mySlotForFace[11] = 11;
		mySlotForFace[12] = 12;
		mySlotForFace[13] = 13;
		mySlotForFace[14] = 14;
		mySlotForFace[15] = 15;
		mySlotForFace[16] = 16;
		mySlotForFace[17] = 17;
		mySlotForFace[18] = 18;
		return mySlotForFace;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn,
			EnumFacing direction) {
		if(index < 9){
			if(CookingPlusOvenRecipes.instance().isItemInput(itemStackIn)){
				if(index == findBestSlotForItem(itemStackIn)){
					return true;
				}
				else{
					return false;
				}
			}
		}
		if(isItemValidForSlot(index, itemStackIn)){
			return true;
		}
		return false;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack,EnumFacing direction) {
		if(index < 9){
			if(CookingPlusOvenRecipes.instance().isItemInput(stack) == false){
				return true;
			}
		}
		if(index > 9){
			return true;
		}
		return false;
	}

	public int findBestSlotForItem(ItemStack myStack){
		
		//first lets get rid of slots we cant use
		boolean[] canSmelt = new boolean[9];
		for(int i = 0; i < 9; i++){
			if(inv[i] == null || inv[i].getItem() == myStack.getItem()){
				ItemStack outputItem = CookingPlusOvenRecipes.instance().getOvenResult(myStack);
				if(inv[i + 10] == null || inv[i + 10].getItem() == outputItem.getItem()){
					canSmelt[i] = true;
				}
				else{
					canSmelt[i] = false;
				}
			}
			else{
				canSmelt[i] = false;
			}
		}
		//now lets find the best from what we have left
		int smallestSize = 65;
		int smallestSlot = -1;
		for(int i = 0; i < 9 && smallestSize != 0; i++){
			if(canSmelt[i] == true){
				if(inv[i] == null){
					smallestSize = 0;
					smallestSlot = i;
				}
				else{
					if(inv[i].stackSize < smallestSize){
						smallestSize = inv[i].stackSize;
						smallestSlot = i;
					}
				}
			}
		}
		
		return smallestSlot;
	}
	
}
