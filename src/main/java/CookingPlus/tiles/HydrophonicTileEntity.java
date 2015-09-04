package CookingPlus.tiles;

import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomCrops;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
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
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HydrophonicTileEntity extends TileEntity implements IInventory, IUpdatePlayerListBox {

	private ItemStack[] inv;
	private int EntityDirection;
	private int[] CoolTime;
	private Block myBlock;
	private int myAge;
	private int timer;
	private float rotation;
	
	public HydrophonicTileEntity() {
		inv = new ItemStack[1];
		EntityDirection = 0;
		CoolTime = new int[1];
		myAge = 0;
		timer = 0;
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
		rotation+=0.1f;
		if(myAge < 7){
			timer++;
		}
		if(timer > 200){
			SetAge(myAge + 1);
			timer = 0;
		}
		
		if(rotation > 360){
			rotation = 0;
		}
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
		if(oldState.getBlock().equals(CookingPlusMain.blockHydrophonic) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockHydrophonic) == false){
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
		int tempInt = nbt.getInteger("blockID");
		if(tempInt == 0){
			myBlock = null;
		}
		else{
			myBlock = Block.getBlockById(nbt.getInteger("blockID"));
		}
		
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
		if(myBlock == null){
			nbt.setInteger("blockID", 0);
		}
		else{
			nbt.setInteger("blockID", Block.getIdFromBlock(myBlock));
		}
		
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
			CoolTime[slot] = 0;
			UpdateBlock();
			}
		}
	 
	 public void UpdateBlock(){
			this.worldObj.markBlockForUpdate(this.getPos());
	}

	
	 public void processActivate(EntityPlayer playerIn) {
		if(playerIn.getCurrentEquippedItem() != null){
			Item myItem = playerIn.getCurrentEquippedItem().getItem();
			if(myBlock == null){
			if(myItem instanceof IPlantable){
				if(((IPlantable)myItem).getPlant(null, null) != null){
					Block TempBlock = ((IPlantable)myItem).getPlant(null, null).getBlock();
					if(TempBlock instanceof CookingPlusCustomCrops || TempBlock == Blocks.wheat || TempBlock == Blocks.potatoes || TempBlock == Blocks.carrots){
						myBlock = TempBlock;
						UpdateBlock();
						SetAge(0);
						
						if(playerIn.getCurrentEquippedItem().stackSize > 1){
							playerIn.setCurrentItemOrArmor(0, new ItemStack(myItem, playerIn.getCurrentEquippedItem().stackSize - 1));
						}
						else{
							playerIn.setCurrentItemOrArmor(0, null);
						}
					}
				}
			}
			}
		}
		else{
			if(playerIn.isSneaking()){
				if(myBlock instanceof CookingPlusCustomCrops){
					myBlock.dropBlockAsItem(this.getWorld(), this.getPos(), myBlock.getDefaultState().withProperty(CookingPlusCustomCrops.AGE, myAge), 0);
					myBlock = null;
					UpdateBlock();
					SetAge(0);
				}
				else if(myBlock == Blocks.wheat || myBlock == Blocks.potatoes || myBlock == Blocks.carrots){
					myBlock.dropBlockAsItem(this.getWorld(), this.getPos(), myBlock.getDefaultState().withProperty(BlockCrops.AGE, myAge), 0);
					myBlock = null;
					UpdateBlock();
					SetAge(0);
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
	 
	public Block getCurrentCrop(){
		return myBlock;
	}
	
	public float getRotation(){
		return rotation;
	}

	public int GetAge(){
		return myAge;
	}
}
