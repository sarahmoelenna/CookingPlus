package CookingPlus.tiles;

import net.minecraft.block.state.IBlockState;
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
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.CookingPlusMain;
import CookingPlus.recipes.CookingPlusOvenRecipes;

public class BrickOvenTileEntity extends TileEntity implements IInventory, IUpdatePlayerListBox {

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
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);

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
	public ItemStack getStackInSlotOnClosing(int slot) {
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
			if(itemstack.getItem().equals(Item.getItemFromBlock(Blocks.log))){
				return false;
			}
			else if(itemstack.getItem().equals(Item.getItemFromBlock(Blocks.log2))){
				return false;
			}
			else if(itemstack.getItem().equals(Item.getItemFromBlock(Blocks.planks))){
				return false;
			}
			else if(itemstack.getItem().equals(Items.coal)){
				return false;
			}
			else if(itemstack.getItem().equals(Items.lava_bucket)){
				return false;
			}
			else{
				return true;
			}
		}
		else if(slot == 9){
			//System.out.println(itemstack.getDisplayName());
			if(itemstack.getItem().equals(Item.getItemFromBlock(Blocks.log))){
				return true;
			}
			if(itemstack.getItem().equals(Item.getItemFromBlock(Blocks.log2))){
				return true;
			}
			if(itemstack.getItem().equals(Item.getItemFromBlock(Blocks.planks))){
				return true;
			}
			if(itemstack.getItem().equals(Items.coal)){
				return true;
			}
			if(itemstack.getItem().equals(Items.lava_bucket)){
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

        return this.FuelTimer * p_145955_1_ / 200;
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
					 return true;
				 }
			}
		 }
		 return false;
	 }

	 public int getItemBurnTime(ItemStack myStack){
		 	if(myStack.getItem().equals(Item.getItemFromBlock(Blocks.log))){
				return 40;
			}
			if(myStack.getItem().equals(Item.getItemFromBlock(Blocks.log2))){
				return 40;
			}
			if(myStack.getItem().equals(Item.getItemFromBlock(Blocks.planks))){
				return 40;
			}
			if(myStack.getItem().equals(Items.coal)){
				return 100;
			}
			if(myStack.getItem().equals(Items.lava_bucket)){
				return 200;
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
			 return new ItemStack(Items.bowl);
		 }else if(myStack.getItem().equals(CookingPlusMain.pancakemix)){
			 return new ItemStack(Items.bowl);
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
	public IChatComponent getDisplayName() {
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
	 
}
