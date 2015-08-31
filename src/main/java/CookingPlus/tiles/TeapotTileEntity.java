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

public class TeapotTileEntity extends TileEntity implements IInventory, IUpdatePlayerListBox {

	private int EntityDirection;
	private ItemStack[] inv;
	private int LiquidAmount;
	private boolean canBoil;
	private int boilAmount;
	
	public TeapotTileEntity() {
		EntityDirection = 0;
		inv = new ItemStack[5];
		LiquidAmount = 0;
		canBoil = false;
		boilAmount = 0;
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
			if(inv[0].getItem().equals(Items.water_bucket)){
				if(LiquidAmount < 10){
					SetLiquidAmount(LiquidAmount + 1);
					FillSlot(new ItemStack(Items.bucket), 0);
					//this.worldObj.markBlockForUpdate(this.getPos());
				}
			}
		}
		
		if(this.getWorld().getBlockState(this.getPos().down().down()) != null){
			if(this.getWorld().getBlockState(this.getPos().down().down()).getBlock() == Blocks.fire){
    			canBoil = true;
    		}
    		else if(this.getWorld().getBlockState(this.getPos().down().down()).getBlock() == Blocks.lava){
    			canBoil = true;
    		}
    		else if(this.getWorld().getBlockState(this.getPos().down()).getBlock() == CookingPlusMain.blockHeater){
    			canBoil = ((HeaterTileEntity)this.getWorld().getTileEntity(this.getPos().down())).isServerBurning();
    			//canBoil = true;
    		}
    		else{
    			canBoil = false;
    		}
		}
		
		if(boilAmount > 200){
			boilAmount = 0;
		}
		
		if(canBoil == true && shouldBoil() && LiquidAmount > 0 && tryToBoil()){
			boilAmount++;
			ProcessTea();
			//this.worldObj.markBlockForUpdate(this.getPos());
		}
		else{
			boilAmount = 0;
		}
		
		
		//}
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
		if(oldState.getBlock().equals(CookingPlusMain.blockTeapot) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockTeapot) == false){
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
		LiquidAmount = nbt.getInteger("LA");
		canBoil = nbt.getBoolean("CB");
		boilAmount = nbt.getInteger("BA");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);

		//nbt.setInteger("MyMoveState", MoveState);
		//nbt.setFloat("MyMovement", MovementTimer);
		//nbt.setInteger("MyButterState", ButterState);
		nbt.setInteger("MyDirection", EntityDirection);
		nbt.setInteger("LA", LiquidAmount);
		nbt.setBoolean("CB", canBoil);
		nbt.setInteger("BA", boilAmount);
		
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
	public int getLiquidAmount() {
		//System.out.println(EntityDirection + " get");
		return LiquidAmount;
	}

	public void SetCanBoil(boolean In){
		canBoil = In;
	}
	
	@SideOnly(Side.CLIENT)
	 public int getBoilAmount(int scale)
	    {
		 //System.out.println(this.CookTimer[slotNum] * scale / 100);
	        return (int) (this.boilAmount * scale / 200);
	    }

	private boolean shouldBoil(){
		
		if(inv[1] != null){
			if(inv[1].getItem() == CookingPlusMain.mug){
				if(inv[2] != null){
					if(inv[2].getItem() == CookingPlusMain.tealeaf){
						if(inv[3] != null){
							if(isHerbalIngredient(inv[3].getItem())){
								return true;
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean isHerbalIngredient(Item myItem){
		if(myItem == CookingPlusMain.buchuleaf){
			return true;
		}
		if(myItem == CookingPlusMain.sageleaf){
			return true;
		}
		if(myItem == CookingPlusMain.licoriceleaf){
			return true;
		}
		if(myItem == CookingPlusMain.mintleaf){
			return true;
		}
		if(myItem == CookingPlusMain.rosemaryleaf){
			return true;
		}
		if(myItem == CookingPlusMain.chamomileflower){
			return true;
		}
		return false;
	}

	private void ProcessTea(){
		if(boilAmount >= 200){
			if(inv[1].getItem() != null){
				if(inv[1].getItem() == CookingPlusMain.mug){
					if(inv[2].getItem() != null){
						if(inv[2].getItem() == CookingPlusMain.tealeaf){
							if(isHerbalIngredient(inv[3].getItem())){
								if(inv[4] == null){
									inv[4] = new ItemStack(GetTeaItem(inv[3].getItem()));
									if(inv[1].stackSize > 1){
										DecreaseSlot(1);
									}
									else{
										FillSlot(null, 1);
									}
									if(inv[2].stackSize > 1){
										DecreaseSlot(2);
									}
									else{
										FillSlot(null, 2);
									}
									if(inv[3].stackSize > 1){
										DecreaseSlot(3);
									}
									else{
										FillSlot(null, 3);
									}
									boilAmount = 0;
									SetLiquidAmount(LiquidAmount - 1);
									//UpdateBlock();
									
								}
								else if(inv[4].getItem() == GetTeaItem(inv[3].getItem())){
									if(inv[4].stackSize < 16){
										inv[4].stackSize++;
										if(inv[1].stackSize > 1){
											DecreaseSlot(1);
										}
										else{
											FillSlot(null, 1);
										}
										if(inv[2].stackSize > 1){
											DecreaseSlot(2);
										}
										else{
											FillSlot(null, 2);
										}
										if(inv[3].stackSize > 1){
											DecreaseSlot(3);
										}
										else{
											FillSlot(null, 3);
										}
										boilAmount = 0;
										//SetLiquidAmount(LiquidAmount - 1);
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	private Item GetTeaItem(Item myItem){
			if(myItem == CookingPlusMain.buchuleaf){
				return CookingPlusMain.buchutea;
			}
			if(myItem == CookingPlusMain.sageleaf){
				return CookingPlusMain.sagetea;
			}
			if(myItem == CookingPlusMain.licoriceleaf){
				return CookingPlusMain.licoricetea;
			}
			if(myItem == CookingPlusMain.mintleaf){
				return CookingPlusMain.minttea;
			}
			if(myItem == CookingPlusMain.rosemaryleaf){
				return CookingPlusMain.rosemarytea;
			}
			if(myItem == CookingPlusMain.chamomileflower){
				return CookingPlusMain.chamomiletea;
			}
			return null;
	}

	private boolean tryToBoil(){
		if(inv[3] != null){
			if(isHerbalIngredient(inv[3].getItem())){
				if(inv[4] == null){
					return true;
				}
				else if(inv[4].getItem() == GetTeaItem(inv[3].getItem())){
					return true;
				}
			}
		}
		return false;
	}

	public void SetLiquidAmount(int newamount){
		if(!this.getWorld().isRemote){
			if(newamount != LiquidAmount){
				LiquidAmount = newamount;
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
