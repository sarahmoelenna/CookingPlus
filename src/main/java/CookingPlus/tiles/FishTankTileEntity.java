package CookingPlus.tiles;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
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
import CookingPlus.recipes.MutationStationRecipeHandler;

public class FishTankTileEntity extends CookingPlusCustomTileEntity implements IInventory, ITickable {

	private ItemStack[] inv;
	public float[] movementX;
	public float[] movementY;
	public float[] movementZ;
	
	private float[] directionX;
	private float[] directionY;
	private float[] directionZ;
	
	public boolean validForProcess;
	
	public FishTankTileEntity() {
		inv = new ItemStack[9];
		movementX = new float[9];
		movementY = new float[9];
		movementZ = new float[9];
		directionX = new float[9];
		directionY = new float[9];
		directionZ = new float[9];
		validForProcess = false;
		
		for(int i = 0; i < 9; i++){
			movementX[i] = 0.5f;
			movementY[i] = 0.5f;
			movementZ[i] = 0.5f;
		}
	}

	@Override
    public void update(){
		if(this.getWorld().isRemote == false){
			ProcessSlot();
		}
		
		Random myRand = new Random();
		for(int i = 0; i < 9; i++){
			
			if(myRand.nextInt(100) < 2){
				directionX[i] = myRand.nextInt(3) - 1;
				directionY[i] = myRand.nextInt(3) - 1;
				directionZ[i] = myRand.nextInt(3) - 1;
			}
			
			movementX[i] = movementX[i] + ((float)myRand.nextInt(2))/300f * directionX[i];
			movementY[i] = movementY[i] + ((float)myRand.nextInt(2))/300f * directionY[i];
			movementZ[i] = movementZ[i] + ((float)myRand.nextInt(2))/300f * directionZ[i];
			if(movementX[i] < 0){movementX[i] = 0;}
			if(movementY[i] < 0){movementY[i] = 0;}
			if(movementZ[i] < 0){movementZ[i] = 0;}
			if(movementX[i] > 1){movementX[i] = 1;}
			if(movementY[i] > 1){movementY[i] = 1;}
			if(movementZ[i] > 1){movementZ[i] = 1;}
		}
		
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
		if(oldState.getBlock().equals(CookingPlusMain.blockFishTank) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockFishTank) == false){
				world.removeTileEntity(pos);
			}
		}
        return false;
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


	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		
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
		boolean EmptySlots = false;
		updateCanProccess(canProcess());
		Random myRand = new Random();
		//Hatch Eggs
		for(int i = 0; i < 9; i++){
			if(inv[i] == null){
				EmptySlots = true;
			}
			else{
				if(myRand.nextInt(800) == 0){
					if(isMutatedEgg(inv[i].getItem()) > 0){
						FillSlot(new ItemStack(MutationStationRecipeHandler.instance().getRandomEgg(isMutatedEgg(inv[i].getItem()), myRand)),i);
					}
					else if(MutationStationRecipeHandler.instance().getFishForEgg(inv[i].getItem()) != null){
						FillSlot(new ItemStack(MutationStationRecipeHandler.instance().getFishForEgg(inv[i].getItem())), i);
					}
				}
			}
		}
		//Breed Fish
		if(EmptySlots == true){
			ArrayList<Item> myDupList = getListOfDuplicateItems();
			if(myDupList != null){
				ProcessFishList(myDupList);
			}
		}
	}
	
	public void ProcessFishList(ArrayList<Item> myDupList){
		Random myRand = new Random();
		for(int i = 0; i < myDupList.size(); i++){
			if(MutationStationRecipeHandler.instance().getEggForFish(myDupList.get(i)) != null){
				Item myNewEgg = MutationStationRecipeHandler.instance().getEggForFish(myDupList.get(i));
				boolean Done = false;
				if(myRand.nextInt(250) == 0){
					for(int x = 0; x < inv.length && Done == false; x++){
						if(inv[x] == null){
							inv[x] = new ItemStack(myNewEgg);
							Done = true;
						}
					}
				}
			}
		}
	}
	
	public ArrayList<Item> getListOfDuplicateItems(){
		
		ArrayList<Item> myDupList = new ArrayList();
		ArrayList<Item> myTempList = new ArrayList();
		
		for(int i = 0; i < inv.length; i++){
			if(inv[i] != null){
				if(myTempList.contains(inv[i].getItem())){
					if(myDupList.contains(inv[i].getItem()) == false){
						myDupList.add(inv[i].getItem());
					}
				}
				myTempList.add(inv[i].getItem());
			}
		}
		
		if(myDupList.size() > 0){
			return myDupList;
		}
		
		return null;
	}
	
	public boolean canProcess(){
		Boolean SolidTrue = false;
		if(isSolidBlock(getPos().east())){
			if(isSolidBlock(getPos().west())){
				if(isSolidBlock(getPos().north())){
					if(isSolidBlock(getPos().south())){
						if(isSolidBlock(getPos().east().north())){
							if(isSolidBlock(getPos().east().south())){
								if(isSolidBlock(getPos().west().north())){
									if(isSolidBlock(getPos().west().south())){
										SolidTrue = true;
									}
								}
							}
						}
					}
				}
			}
		}
		if(SolidTrue == true){
			if(isWaterBlock(getPos().east().up())){
				if(isWaterBlock(getPos().west().up())){
					if(isWaterBlock(getPos().north().up())){
						if(isWaterBlock(getPos().south().up())){
							if(isWaterBlock(getPos().east().north().up())){
								if(isWaterBlock(getPos().east().south().up())){
									if(isWaterBlock(getPos().west().north().up())){
										if(isWaterBlock(getPos().west().south().up())){
											if(isWaterBlock(getPos().up())){
												return true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		return false;
	}

	public Block getBlock(BlockPos myPos){
		return this.getWorld().getBlockState(myPos).getBlock();
	}
	
	public boolean isWaterBlock(BlockPos myPos){
		if(getBlock(myPos) == Blocks.WATER){
			//System.out.println(getBlockState(myPos).getValue(BlockLiquid.LEVEL).intValue());
			if(((Integer)getBlockState(myPos).getValue(BlockLiquid.LEVEL).intValue()) == 0){
					return true;
			}
		}
		return false;
	}
	
	public boolean isSolidBlock(BlockPos myPos){
		if(getBlock(myPos).isFullBlock(getBlockState(myPos))){
			return true;
		}
		else{
			return false;
		}
	}
	
	public IBlockState getBlockState(BlockPos myPos){
		return this.getWorld().getBlockState(myPos);
	}
		
	public int isMutatedEgg(Item myItem){
		if(myItem == CookingPlusMain.onemutantfishegg){
			return 1;
		}else if(myItem == CookingPlusMain.twomutantfishegg){
			return 2;
		}else if(myItem == CookingPlusMain.threemutantfishegg){
			return 3;
		}else if(myItem == CookingPlusMain.fourmutantfishegg){
			return 4;
		}else if(myItem == CookingPlusMain.fivemutantfishegg){
			return 5;
		} else { return 0; }
	}
	
	 public void FillSlot(ItemStack myItem, int slot){
		if(!this.getWorld().isRemote){
			inv[slot] = myItem;
			UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
		}
	}
	 
	 public ItemStack[] getInventory(){
		 return inv;
	 }
	 
	 public void updateCanProccess(boolean value){
			if(!this.getWorld().isRemote){
				if(validForProcess != value){
					validForProcess = value;
					UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
				}
			}
		}
	 
	 public boolean getIsProcessValid(){
		 return validForProcess;
	 }
	 
	 public ItemStack getRenderItem(int slot){
		 if(inv[slot] != null){
			 if(MutationStationRecipeHandler.instance().getEggForFish(inv[slot].getItem()) != null){
				 return inv[slot];
			 }
		 }
		 return null;
	 }
	 
	 public ItemStack getHappyHarvestBotItemStack(){
		ArrayList<Item> myOneFishItemList = new ArrayList();
		ArrayList<Item> myTwoFishItemList = new ArrayList();
		for(int i = 0; i < inv.length; i++){
			if(inv[i] != null){
			Item myItem = inv[i].getItem();
			if(MutationStationRecipeHandler.instance().getEggForFish(inv[i].getItem()) != null){
				if(myOneFishItemList.contains(myItem)){
					if(myTwoFishItemList.contains(myItem)){
						//inv[i] = null;
						FillSlot(null, i);
						return new ItemStack(myItem);
					}
					else{
						myTwoFishItemList.add(myItem);
					}
				}
				else{
					myOneFishItemList.add(myItem);
				}
			}
			}
		}
		 
		return null;
	 }
}
