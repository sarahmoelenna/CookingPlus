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
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.CookingPlusMain;
import CookingPlus.recipes.CookingPlusSheetPressRecipes;

public class SheetPressTileEntity extends TileEntity implements IInventory, IUpdatePlayerListBox {

	private int EntityDirection;
	private ItemStack[] inv;
	private int PressAmount;
	private int PressState;
	
	public SheetPressTileEntity() {
		EntityDirection = 0;
		inv = new ItemStack[2];
		PressAmount = 0;
		PressState = 0;
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
		//if(this.getWorld().isRemote == false){

		if(PressState == 0){
			if(ShouldProcess()){
				if(PressAmount < 101){
					PressAmount++;
				}
				//this.worldObj.markBlockForUpdate(this.getPos());
			}
			else{
				if(PressAmount > 0){
					SetPressState(1);
				}
			}
		}
		if(PressAmount > 100){
			ProcessSlots();
			SetPressState(1);
			//this.worldObj.markBlockForUpdate(this.getPos());
		}
		if(PressState == 1){
			if(PressAmount > 0){
				PressAmount--;
				//this.worldObj.markBlockForUpdate(this.getPos());
			}
		}
		if(PressAmount <= 0){
			PressAmount = 0;
			SetPressState(0);
		}
		
		//ProcessSlots();
		
		//this.worldObj.markBlockForUpdate(this.getPos());
		//}
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
		if(oldState.getBlock().equals(CookingPlusMain.blockSheetPress) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockSheetPress) == false){
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
		PressAmount = nbt.getInteger("PA");
		PressState = nbt.getInteger("PS");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);

		//nbt.setInteger("MyMoveState", MoveState);
		//nbt.setFloat("MyMovement", MovementTimer);
		//nbt.setInteger("MyButterState", ButterState);
		nbt.setInteger("MyDirection", EntityDirection);
		nbt.setInteger("PA", PressAmount);
		nbt.setInteger("PS", PressState);
		
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

	@SideOnly(Side.CLIENT)
	 public float getPressAmount()
	    {
		 //System.out.println(this.CookTimer[slotNum] * scale / 100);
	        return PressAmount;
	        //return 0;
	        // 0;
	    }

	@SideOnly(Side.CLIENT)
	 public int getPressAmountScaled(int scale)
	    {
		 //System.out.println(this.CookTimer[slotNum] * scale / 100);
	        return this.PressAmount * scale / 100;
	        // 0;
	    }

	public void ProcessSlots(){
		if(inv[0] != null && inv[1] != null){
			if(CookingPlusSheetPressRecipes.instance().getPressSheetResult(inv[1]) != null){
				ItemStack resultItemStack = CookingPlusSheetPressRecipes.instance().getPressSheetResult(inv[1]);
				if(CookingPlusSheetPressRecipes.instance().getPressSheetItem(resultItemStack) != null){
					ItemStack SheetItem = CookingPlusSheetPressRecipes.instance().getPressSheetItem(resultItemStack);
					if(CookingPlusSheetPressRecipes.instance().getGrindingExperience(resultItemStack) == 0.5f){
						FillSlot(new ItemStack(resultItemStack.getItem(), 1), 1);
						FillSlot(null, 0);
					}
					else{
						FillSlot(new ItemStack(resultItemStack.getItem(), 1), 0);
					}
				}
			}
		}
	}
	
	public boolean ShouldProcess(){
		if(inv[0] != null && inv[1] != null){
			if(CookingPlusSheetPressRecipes.instance().getPressSheetResult(inv[1]) != null){
				ItemStack resultItemStack = CookingPlusSheetPressRecipes.instance().getPressSheetResult(inv[1]);
				//System.out.println(resultItemStack.getItem().getUnlocalizedName());
				if(CookingPlusSheetPressRecipes.instance().getPressSheetItem(resultItemStack) != null){
					ItemStack SheetItem = CookingPlusSheetPressRecipes.instance().getPressSheetItem(resultItemStack);
					//System.out.println(SheetItem.getItem().getUnlocalizedName());
					if(inv[0].getItem() == SheetItem.getItem()){
						return true;
					}
				}
			}
		}	
		return false;
	}
	
	public void SetPressState(int newamount){
		if(!this.getWorld().isRemote){
			if(newamount != PressState){
				PressState = newamount;
				UpdateBlock();
			}
		}
	}
	
	public void FillSlot(ItemStack myItem, int slot){
		if(!this.getWorld().isRemote){
		inv[slot] = myItem;
		UpdateBlock();
		}
	}
	
	public void DecreaseSlot(int slot){
		if(!this.getWorld().isRemote){
		inv[slot].stackSize--;
		UpdateBlock();
		}
	}
 
	public void UpdateBlock(){
		//System.out.println("update tile entity for client");
		this.worldObj.markBlockForUpdate(this.getPos());
	}
}
