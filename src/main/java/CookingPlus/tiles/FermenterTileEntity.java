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

public class FermenterTileEntity extends TileEntity implements IInventory, IUpdatePlayerListBox {

	private int EntityDirection;
	private ItemStack[] inv;
	protected String LiquidIn;
	protected String LiquidOut;
	protected int LiquidInAmount;
	protected int LiquidOutAmount;
	protected float FermentTimer;
	
	public FermenterTileEntity() {
		EntityDirection = 0;
		inv = new ItemStack[2];
		
		LiquidIn = "blank";
		LiquidOut = "blank";
		LiquidInAmount = 0;
		LiquidOutAmount = 0;
		FermentTimer = 0;
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
		if(inv[0] != null){
			//grape
			if(inv[0].getItem().equals(CookingPlusMain.grapejuice)){
				if(LiquidIn.equals("blank") == false && LiquidInAmount < 10){
					if(LiquidIn.equals("grape")){
						SetLiquidInAmount(LiquidInAmount + 1);
						FillSlot(new ItemStack(Items.glass_bottle), 0);
					}
				}
				else if(LiquidInAmount == 0){
					SetLiquidInAmount(LiquidInAmount + 1);
					SetLiquidIn("grape");
					FillSlot(new ItemStack(Items.glass_bottle), 0);
				}
			}
			//apple
			if(inv[0].getItem().equals(CookingPlusMain.applejuice)){
				if(LiquidIn.equals("blank") == false && LiquidInAmount < 10){
					if(LiquidIn.equals("apple")){
						SetLiquidInAmount(LiquidInAmount + 1);
						FillSlot(new ItemStack(Items.glass_bottle), 0);
					}
				}
				else if(LiquidInAmount == 0){
					SetLiquidInAmount(LiquidInAmount + 1);
					SetLiquidIn("apple");
					FillSlot(new ItemStack(Items.glass_bottle), 0);
				}
			}
			//hops
			if(inv[0].getItem().equals(CookingPlusMain.hops)){
				if(LiquidIn.equals("blank") == false && LiquidInAmount < 10){
					if(LiquidIn.equals("hops")){
						SetLiquidInAmount(LiquidInAmount + 1);
						FillSlot(null, 0);
					}
				}
				else if(LiquidInAmount == 0){
					SetLiquidInAmount(LiquidInAmount + 1);
					SetLiquidIn("hops");
					FillSlot(null, 0);
				}
			}
		}
		
		if(inv[1] != null){
			if(inv[1].getItem().equals(Items.glass_bottle)){
				if(LiquidOut.equals("wine")){
					if(LiquidOutAmount > 1){
						SetLiquidOutAmount(LiquidOutAmount - 1);
						FillSlot(new ItemStack(CookingPlusMain.wine), 1 );
					}
					else if(LiquidOutAmount == 1){
						SetLiquidOutAmount(LiquidOutAmount - 1);	
						SetLiquidOut("blank");
						FillSlot(new ItemStack(CookingPlusMain.wine), 1);
					}
				}
				
				if(LiquidOut.equals("cider")){
					if(LiquidOutAmount > 1){
						SetLiquidOutAmount(LiquidOutAmount - 1);
						FillSlot(new ItemStack(CookingPlusMain.cider), 1);
					}
					else if(LiquidOutAmount == 1){
						SetLiquidOutAmount(LiquidOutAmount - 1);
						SetLiquidOut("blank");
						FillSlot(new ItemStack(CookingPlusMain.cider), 1);
					}
				}
				
				if(LiquidOut.equals("beer")){
					if(LiquidOutAmount > 1){
						SetLiquidOutAmount(LiquidOutAmount - 1);
						FillSlot(new ItemStack(CookingPlusMain.beer), 1);
					}
					else if(LiquidOutAmount == 1){
						SetLiquidOutAmount(LiquidOutAmount - 1);
						SetLiquidOut("blank");
						FillSlot(new ItemStack(CookingPlusMain.beer), 1);
					}
				}
				
			}
		}
		
		
		if(LiquidInAmount <= 0)
		{
			SetLiquidInAmount(0);
			SetLiquidIn("blank");
		}
		if(LiquidOutAmount <= 0)
		{
			SetLiquidOutAmount(0);
			SetLiquidOut("blank");
		}
		ProcessLiquid();
		
		//}
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
		if(oldState.getBlock().equals(CookingPlusMain.blockFermenter) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockFermenter) == false){
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
		
		String Direction;
		EntityDirection = nbt.getInteger("MyDirection");
		LiquidIn = nbt.getString("LI");
		LiquidOut = nbt.getString("LO");
		LiquidInAmount = nbt.getInteger("LIA");
		LiquidOutAmount = nbt.getInteger("LOA");
		FermentTimer = nbt.getInteger("FT");

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);

		//nbt.setInteger("MyMoveState", MoveState);
		//nbt.setFloat("MyMovement", MovementTimer);
		//nbt.setInteger("MyButterState", ButterState);
		nbt.setInteger("MyDirection", EntityDirection);
		
		nbt.setInteger("LIA", LiquidInAmount);
		nbt.setInteger("LOA", LiquidOutAmount);
		nbt.setString("LI", LiquidIn);
		nbt.setString("LO", LiquidOut);
		nbt.setInteger("FT", (int) FermentTimer);
		
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
	}

	@Override
	public void closeInventory(EntityPlayer player) {
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

	//GUI GET STUFF
	
	@SideOnly(Side.CLIENT)
	 public int getLiquidInAmount()
	 {
		return LiquidInAmount;
	 }
	
	@SideOnly(Side.CLIENT)
	 public int getLiquidOutAmount()
	 {
		return LiquidOutAmount;
	 }
	
	@SideOnly(Side.CLIENT)
	public String getLiquidIn(){
		return LiquidIn;
	}
	
	@SideOnly(Side.CLIENT)
	public String getLiquidOut(){
		return LiquidOut;
	}

	protected void ProcessLiquid(){
		if(canFerment()){
			FermentTimer++;
			//UpdateBlock();
		}
		else{
			FermentTimer = 0;
		}
		if(FermentTimer > 400){
			//grape
			if(LiquidIn.equals("grape")){
				if(LiquidOut.equals("wine") || (LiquidOut.equals("blank") && LiquidOutAmount == 0)){
					if(LiquidOutAmount < 10){
						SetLiquidOutAmount(LiquidOutAmount + 1);
						SetLiquidInAmount(LiquidInAmount - 1);
						FermentTimer = 0;
						SetLiquidOut("wine");
						if(LiquidInAmount == 0){
							SetLiquidIn("blank");
						}
						//UpdateBlock();
					}
				}
			}
			//apple
			if(LiquidIn.equals("apple")){
				if(LiquidOut.equals("cider") || (LiquidOut.equals("blank") && LiquidOutAmount == 0)){
					if(LiquidOutAmount < 10){
						SetLiquidOutAmount(LiquidOutAmount + 1);
						SetLiquidInAmount(LiquidInAmount - 1);
						FermentTimer = 0;
						SetLiquidOut("cider");
						if(LiquidInAmount == 0){
							SetLiquidIn("blank");
						}
						//UpdateBlock();
					}
				}
			}
			//hops
			if(LiquidIn.equals("hops")){
				if(LiquidOut.equals("beer") || (LiquidOut.equals("blank") && LiquidOutAmount == 0)){
					if(LiquidOutAmount < 10){
						SetLiquidOutAmount(LiquidOutAmount + 1);
						SetLiquidInAmount(LiquidInAmount - 1);
						FermentTimer = 0;
						SetLiquidOut("beer");
						if(LiquidInAmount == 0){
							SetLiquidIn("blank");
						}
						//UpdateBlock();
					}
				}
			}
		}
	}

	protected boolean canFerment(){
		if(LiquidOutAmount >= 10){
			return false;
		}
		if(LiquidIn.equals("grape") && LiquidOut.equals("wine")){
			return true;
		}
		if(LiquidIn.equals("apple") && LiquidOut.equals("cider")){
			return true;
		}
		if(LiquidIn.equals("hops") && LiquidOut.equals("beer")){
			return true;
		}
		if(LiquidIn.equals("blank") == false && LiquidOut.equals("blank")){
			return true;
		}
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	 public int getFermenter(int scale)
	    {
		 //System.out.println(this.CookTimer[slotNum] * scale / 100);
	        return (int) (this.FermentTimer * scale / 400);
	    }
	
	public ItemStack[] GetItems(){
		return inv;
	 }

	public void SetLiquidInAmount(int newamount){
		if(!this.getWorld().isRemote){
			if(newamount != LiquidInAmount){
				LiquidInAmount = newamount;
				UpdateBlock();
			}
		}
	}
	
	public void SetLiquidOutAmount(int newamount){
		if(!this.getWorld().isRemote){
		if(newamount != LiquidOutAmount){
			LiquidOutAmount = newamount;
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
	
	public void SetLiquidIn(String newType){
		if(!this.getWorld().isRemote){
		if(newType != LiquidIn){
			LiquidIn = newType;
			UpdateBlock();
		}
		}
	}
	
	public void SetLiquidOut(String newType){
		if(!this.getWorld().isRemote){
		if(newType != LiquidOut){
			LiquidOut = newType;
			UpdateBlock();
		}
		}
	}
	
	public void UpdateBlock(){
		//System.out.println("update tile entity for client");
		this.worldObj.markBlockForUpdate(this.getPos());
	}
}
