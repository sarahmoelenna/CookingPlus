package CookingPlus.tiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBeetroot;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockMelon;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.block.BlockReed;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.material.Material;
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
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import CookingPlus.CookingPlusConfig;
import CookingPlus.CookingPlusGenericHelper;
import CookingPlus.CookingPlusLootHelper;
import CookingPlus.CookingPlusMain;
import CookingPlus.Interfaces.ILeyPoweredEntity;
import CookingPlus.blocks.CookingPlusCustomCrops;
import CookingPlus.blocks.CookingPlusCustomGrowingBush;
import CookingPlus.blocks.CookingPlusCustomRopeCrop;
import CookingPlus.blocks.CookingPlusCustomSapling;
import CookingPlus.blocks.CookingPlusCustomSpreadingCoral;
import CookingPlus.blocks.CookingPlusCustomSpreadingHerb;
import CookingPlus.blocks.CookingPlusCustomUnderwaterCrop;
import CookingPlus.blocks.bushes.CookingPlusPlainBush;

public class BotTileEntity extends CookingPlusCustomTileEntity implements IInventory, ITickable, ILeyPoweredEntity {

	private ItemStack[] inv;
	private int EntityDirection;
	private int myFace;
	private int timer;
	private int myEntityType;
	private int HarvestTimer;
	private int prevFace;
	private boolean ChestProblems;
	protected float speedMultiplier;
	
	public BotTileEntity() {
		Random TempRand = new Random();
		inv = new ItemStack[1];
		EntityDirection = 0;
		myFace = 3;
		prevFace = 3;
		timer = 0;
		myEntityType = 0;
		HarvestTimer = TempRand.nextInt(30);
		ChestProblems = false;
		speedMultiplier = 1;
	}
	
	public void setDirection(int Direction) {
		EntityDirection = Direction;
	}

	public int getDirection() {
		return EntityDirection;
	}

	@Override
    public void update(){
		
		if(getWorld().isRemote == false){
			int myMode = GetMode();
			
			if(beganEnergyDrainFromNetwork(myMode) == false && CookingPlusConfig.disableEnergyRequirement == false){
				prevFace = myFace;
				SetFace(3);
				HarvestTimer = 0;
				if(prevFace != myFace){
					UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
				}
			}
			else{
				if(myMode == 0){
					DefaultMode();
				}else if(myMode == 1){
					PickerMode();
				}else if(myMode == 2){
					FisherMode();
				}else if(myMode == 3){
					GatherMode();
				}else if(myMode == 4){
					DesalinatorMode();
				}else if(myMode == 5){
					LoggerMode();
				}else if(myMode == 6){
					PlanterMode();
				}else if(myMode == 7){
					LaserDroneBayMode();
				}else if(myMode == 8){
					MutationStationMode();
				}else if(myMode == 9){
					FishTankMode();
				}else if(myMode == 10){
					AnalyserMode();
				}else if(myMode == 11){
					InscriberMode();
				}else if(myMode == 12){
					ResearchMode();
				}
				
			}
		}
	}
	
	public boolean shouldDestroyExcess(){
		return false;
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
		if(oldState.getBlock().equals(CookingPlusMain.blockBot) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockBot) == false){
				world.removeTileEntity(pos);
				//return true;
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
		//System.out.println(EntityDirection + " read");
		myFace = nbt.getInteger("Age");
		timer = nbt.getInteger("time");
		myEntityType = nbt.getInteger("type");
		
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
		
		nbt.setInteger("MyDirection", EntityDirection);
		//System.out.println(EntityDirection  + " write");
		nbt.setInteger("Age", myFace);
		nbt.setInteger("time", timer);
		nbt.setInteger("type", myEntityType);
		
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
	
	public void FillSlot(ItemStack myItem, int slot){
			if(!this.getWorld().isRemote){
			inv[slot] = myItem;
			UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
			}
		}
	 
	 public int getFace(){
		 return myFace;
	 }
	 
	 public void SetFace(int newamount){
			if(!this.getWorld().isRemote){
				if(newamount != myFace){
					myFace = newamount;
				}
			}
		}
	 
	 public boolean hasChest(){
			if(this.getDirection() == 2){
				if(this.getWorld().getBlockState(this.getPos().south()).getBlock() == Blocks.CHEST){
					return true;
				}
			}
			else if(this.getDirection() == 3){
				if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == Blocks.CHEST){
					return true;
				}
			}
			else if(this.getDirection() == 4){
				if(this.getWorld().getBlockState(this.getPos().east()).getBlock() == Blocks.CHEST){
					return true;
				}
			}
			else if(this.getDirection() == 5){
				if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == Blocks.CHEST){
					return true;
				}
			}
			
			return false;
	}
	 
	 public boolean hasTopChest(){
		 if(this.getWorld().getBlockState(this.getPos().up()).getBlock() == Blocks.CHEST){
				return true;
		}
		return false;
	 }
	 
	 public boolean hasSideChest(){
			
			if(this.getDirection() == 2){
				if(this.getWorld().getBlockState(this.getPos().east()).getBlock() == Blocks.CHEST){
					return true;
				}
				if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == Blocks.CHEST){
					return true;
				}
			}
			else if(this.getDirection() == 3){
				if(this.getWorld().getBlockState(this.getPos().east()).getBlock() == Blocks.CHEST){
					return true;
				}
				if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == Blocks.CHEST){
					return true;
				}
			}
			else if(this.getDirection() == 4){
				if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == Blocks.CHEST){
					return true;
				}
				if(this.getWorld().getBlockState(this.getPos().south()).getBlock() == Blocks.CHEST){
					return true;
				}
			}
			else if(this.getDirection() == 5){
				if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == Blocks.CHEST){
					return true;
				}
				if(this.getWorld().getBlockState(this.getPos().south()).getBlock() == Blocks.CHEST){
					return true;
				}
			}
			
			return false;
	}
	 
	 public boolean hasWorkable(){
			
			if(this.getDirection() == 2 || this.getDirection() == 3){
				if(isBlockWorkable(getPos().east()) || isBlockWorkable(getPos().west()) || isBlockWorkable(getPos().east().up()) || isBlockWorkable(getPos().west().up()) || isBlockWorkable(getPos().east().down()) || isBlockWorkable(getPos().west().down()) || isBlockWorkable(getPos().down()) || isBlockWorkable(getPos().up())){
					return true;
				}
			}
			else if(this.getDirection() == 5 || this.getDirection() == 4){
				if(isBlockWorkable(getPos().north()) || isBlockWorkable(getPos().south()) || isBlockWorkable(getPos().north().up()) || isBlockWorkable(getPos().south().up()) || isBlockWorkable(getPos().north().down()) || isBlockWorkable(getPos().south().down()) || isBlockWorkable(getPos().down()) || isBlockWorkable(getPos().up())){
					return true;
				}
			}
			
			return false;
	}
	 
	 public boolean isBlockWorkable(BlockPos myPos){
		 if(this.getWorld().getBlockState(myPos).getBlock() == CookingPlusMain.blockHydrophonic){
				return true;
			}
		 return false;
	 }
	 
	 public boolean WorkBlocks(){
		 boolean WorkOncePerHarvestTick = false;
		 if(isBlockWorkable(this.getPos().up()) && !WorkOncePerHarvestTick){
			 if(workBlock(this.getPos().up())){
				 WorkOncePerHarvestTick = true;
			 }
		 }
		 if(isBlockWorkable(this.getPos().down())  && !WorkOncePerHarvestTick){
			 if(workBlock(this.getPos().down())){
				 WorkOncePerHarvestTick = true;
			 }
		 }
		 
		 if(this.getDirection() == 2 || this.getDirection() == 3){
		 if(isBlockWorkable(this.getPos().east())  && !WorkOncePerHarvestTick){
			 if(workBlock(this.getPos().east())){
				 WorkOncePerHarvestTick = true;
			 }
		 }
		 if(isBlockWorkable(this.getPos().west())  && !WorkOncePerHarvestTick){
			 if(workBlock(this.getPos().west())){
				 WorkOncePerHarvestTick = true;
			 }
		 }
		 if(isBlockWorkable(this.getPos().east().down())  && !WorkOncePerHarvestTick){
			 if(workBlock(this.getPos().east().down())){
				 WorkOncePerHarvestTick = true;
			 }
		 }
		 if(isBlockWorkable(this.getPos().west().down())  && !WorkOncePerHarvestTick){
			 if(workBlock(this.getPos().west().down())){
				 WorkOncePerHarvestTick = true;
			 }
		 }
		 if(isBlockWorkable(this.getPos().east().up())  && !WorkOncePerHarvestTick){
			 if(workBlock(this.getPos().east().up())){
				 WorkOncePerHarvestTick = true;
			 }
		 }
		 if(isBlockWorkable(this.getPos().west().up())  && !WorkOncePerHarvestTick){
			 if(workBlock(this.getPos().west().up())){
				 WorkOncePerHarvestTick = true;
			 }
		 }
		 }
		 
		 if(this.getDirection() == 4 || this.getDirection() == 5){
			 if(isBlockWorkable(this.getPos().north())  && !WorkOncePerHarvestTick){
				 if(workBlock(this.getPos().north())){
					 WorkOncePerHarvestTick = true;
				 }
			 }
			 if(isBlockWorkable(this.getPos().south())  && !WorkOncePerHarvestTick){
				 if(workBlock(this.getPos().south())){
					 WorkOncePerHarvestTick = true;
				 }
			 }
			 if(isBlockWorkable(this.getPos().north().down())  && !WorkOncePerHarvestTick){
				 if(workBlock(this.getPos().north().down())){
					 WorkOncePerHarvestTick = true;
				 }
			 }
			 if(isBlockWorkable(this.getPos().south().down())  && !WorkOncePerHarvestTick){
				 if(workBlock(this.getPos().south().down())){
					 WorkOncePerHarvestTick = true;
				 }
			 }
			 if(isBlockWorkable(this.getPos().north().up())  && !WorkOncePerHarvestTick){
				 if(workBlock(this.getPos().north().up())){
					 WorkOncePerHarvestTick = true;
				 }
			 }
			 if(isBlockWorkable(this.getPos().south().up())  && !WorkOncePerHarvestTick){
				 if(workBlock(this.getPos().south().up())){
					 WorkOncePerHarvestTick = true;
				 }
			 }
			 }
		 
		 if(WorkOncePerHarvestTick){
			 return true;
		 }
		 else{
			 return false;
		 }
	 }
	 
	 public boolean workBlock(BlockPos myPos){
		 
		 List<BlockPos> ChestList = GetChestPosList();
		 
		 HydrophonicTileEntity myEntity = (HydrophonicTileEntity)this.getWorld().getTileEntity(myPos);
		 if(myEntity.getCurrentCrop() == null){
			 //TileEntityChest myChest = (TileEntityChest) this.getWorld().getTileEntity(getChestPos());
			 boolean done = false;
			 for(int c = 0; c < ChestList.size()  && done == false; c++){
				TileEntityLockable myChest = (TileEntityLockable) this.getWorld().getTileEntity(ChestList.get(c));
			 	for(int i = 0; i < myChest.getSizeInventory() && done == false; i++){
					 if(myChest.getStackInSlot(i) != null){
						 if(myEntity.isItemAcceptableInput(myChest.getStackInSlot(i).getItem())){
							 myEntity.processAutoActivate(myChest.getStackInSlot(i).getItem());
							 if(((TileEntityLockable) (this.getWorld().getTileEntity(ChestList.get(c)))).getStackInSlot(i).stackSize > 1){
								 ((TileEntityLockable) (this.getWorld().getTileEntity(ChestList.get(c)))).setInventorySlotContents(i, new ItemStack(myChest.getStackInSlot(i).getItem(), myChest.getStackInSlot(i).stackSize - 1));
							 }
							 else{
								 ((TileEntityLockable) (this.getWorld().getTileEntity(ChestList.get(c)))).setInventorySlotContents(i, null);
							 }
							 done = true;
					 	}
					 }
			 	}
			 }
			 return done;
		 }
		 else if(myEntity.GetAge() == 7){
			 
			 if(myEntity.getCurrentCrop() != null){
				 Block myBlock = myEntity.getCurrentCrop();
				 
				 if(myBlock instanceof CookingPlusCustomCrops){
						 List<ItemStack> myItemList = myEntity.getCurrentCrop().getDrops(this.getWorld(), this.getPos(), myBlock.getDefaultState().withProperty(CookingPlusCustomCrops.AGE, 7), 0);
					
						 boolean SearchDone = false;
						 for(ItemStack myStack : myItemList){
							 if(!SearchDone){
							 	if(myEntity.isItemAcceptableInput(myStack.getItem())){
								 	--myStack.stackSize;
								 	inv[0] = new ItemStack(myStack.getItem(), 1);
								 	SearchDone = true;
							 	}
						 	}
						 }
						 DepositItemStackListIntoChestList(myItemList);
				 
				 }
					else if(myBlock == Blocks.WHEAT || myBlock == Blocks.POTATOES || myBlock == Blocks.CARROTS  || ((BlockCrops)myBlock).getMaxAge() == 7){
						List<ItemStack> myItemList = myEntity.getCurrentCrop().getDrops(this.getWorld(), this.getPos(), myBlock.getDefaultState().withProperty(BlockCrops.AGE, 7), 0);
						
						 boolean SearchDone = false;
						 for(ItemStack myStack : myItemList){
							 if(!SearchDone){
							 	if(myEntity.isItemAcceptableInput(myStack.getItem())){
								 	--myStack.stackSize;
								 	inv[0] = new ItemStack(myStack.getItem(), 1);
								 	SearchDone = true;
							 	}
						 	}
						 }
						 DepositItemStackListIntoChestList(myItemList);
						
					}
					else if(myBlock == Blocks.BEETROOTS  || ((BlockCrops)myBlock).getMaxAge() == 3){
						List<ItemStack> myItemList = myEntity.getCurrentCrop().getDrops(this.getWorld(), this.getPos(), myBlock.getDefaultState().withProperty(BlockBeetroot.BEETROOT_AGE, 3), 0);
						
						 boolean SearchDone = false;
						 for(ItemStack myStack : myItemList){
							 if(!SearchDone){
							 	if(myEntity.isItemAcceptableInput(myStack.getItem())){
								 	--myStack.stackSize;
								 	inv[0] = new ItemStack(myStack.getItem(), 1);
								 	SearchDone = true;
							 	}
						 	}
						 }
						 DepositItemStackListIntoChestList(myItemList);
						
					}
			 }
			 myEntity.processAutoActivate(null);
			 
			 if(inv[0] != null){
				 myEntity.processAutoActivate(inv[0].getItem());
				 inv[0] = null;
			 }
			 
			 return true;
		 }
		 else{
			 return false;
		 }
		 
	 }
	 
	 public boolean WorkVines(){
		 
		 ArrayList<BlockPos> PosList;
		 PosList = ContrustVineList();
		 //System.out.println(PosList.size());
		 boolean harvest = false;
		 
		 for(int i = 0; i < PosList.size() && harvest == false; i++){
			 if(this.getWorld().getBlockState(PosList.get(i)).getBlock() instanceof CookingPlusCustomRopeCrop){
				 if(WorkVine(PosList.get(i))){
					 harvest = true;
			 	}
			 }
			 else if(this.getWorld().getBlockState(PosList.get(i)).getBlock() instanceof CookingPlusCustomGrowingBush && !(this.getWorld().getBlockState(PosList.get(i)).getBlock() instanceof CookingPlusPlainBush)){
				 if(WorkBush(PosList.get(i))){
					 harvest = true;
			 	}
			 }
		 }
		 
		 return true;
	 }
	 
	 private boolean WorkVine(BlockPos MyPos){
		 IBlockState myBlock = this.getWorld().getBlockState(MyPos);
		 int MyAge = (Integer) myBlock.getValue(CookingPlusCustomRopeCrop.AGE);
		 if(MyAge == 3){
			((CookingPlusCustomRopeCrop) myBlock.getBlock()).growCropUp(this.getWorld(), MyPos.up());
			 
			List<ItemStack> myItemList = new java.util.ArrayList<ItemStack>();
			myItemList.add(new ItemStack(((CookingPlusCustomRopeCrop) myBlock.getBlock()).GetCropItem()));
			Random myRand = new Random();
			if(myRand.nextFloat() > 0.8f){
				myItemList.add(new ItemStack(((CookingPlusCustomRopeCrop) myBlock.getBlock()).GetSeedItem()));
			}
			DepositItemStackListIntoChestList(myItemList);
			 /*ArrayList<BlockPos> PosList;
			 PosList = GetChestPosList();
			 
			 for(int i = 0; i < PosList.size() && myItemList.size() > 0; i++){
				 for(int y = 0; y < myItemList.size(); y++){
					 if(myItemList.get(y).stackSize > 0){
					 ItemStack TempStack = CookingPlusLootHelper.instance().PutItemStackInChest((TileEntityChest)this.worldObj.getTileEntity(PosList.get(i)), myItemList.get(y));
					 	if(TempStack != null){
					 		myItemList.get(y).stackSize = TempStack.stackSize;
					 	}
					 	else{
					 		myItemList.get(y).stackSize = 0;
					 	}
					 }
				 }
			 }
			 ChestProblems = false;
			 
			 for(int y = 0; y < myItemList.size(); y++){
				 if(myItemList.get(y).stackSize > 0){
					 Block.spawnAsEntity(this.getWorld(), pos, myItemList.get(y));
				 	SetFace(2);
				 	ChestProblems = true;
				 }
			 }		 */
			 
			 
			this.getWorld().setBlockState(MyPos, myBlock.withProperty(CookingPlusCustomRopeCrop.AGE, 2));
			return true;
		 }
		 
		 return false;
	 }
	 
	 private boolean WorkBush(BlockPos MyPos){
		 IBlockState myBlock = this.getWorld().getBlockState(MyPos);
		 int MyAge = (Integer) myBlock.getValue(CookingPlusCustomGrowingBush.AGE);
		 if(MyAge >= 6){
			 Random myRand = new Random();
			((CookingPlusCustomGrowingBush) myBlock.getBlock()).growBush(this.getWorld(), myRand, MyPos.getX(), MyPos.getY(), MyPos.getZ(), this.getWorld().getBlockState(MyPos));
			 
			List<ItemStack> myItemList = new java.util.ArrayList<ItemStack>();
			myItemList.add(new ItemStack(((CookingPlusCustomGrowingBush) myBlock.getBlock()).getBushDrop()));
			DepositItemStackListIntoChestList(myItemList);
			 /*ArrayList<BlockPos> PosList;
			 PosList = GetChestPosList();
			 
			 for(int i = 0; i < PosList.size() && myItemList.size() > 0; i++){
				 for(int y = 0; y < myItemList.size(); y++){
					 if(myItemList.get(y).stackSize > 0){
					 ItemStack TempStack = CookingPlusLootHelper.instance().PutItemStackInChest((TileEntityChest)this.worldObj.getTileEntity(PosList.get(i)), myItemList.get(y));
					 	if(TempStack != null){
					 		myItemList.get(y).stackSize = TempStack.stackSize;
					 	}
					 	else{
					 		myItemList.get(y).stackSize = 0;
					 	}
					 }
				 }
			 }
			 ChestProblems = false;
			 
			 for(int y = 0; y < myItemList.size(); y++){
				 if(myItemList.get(y).stackSize > 0){
					 Block.spawnAsEntity(this.getWorld(), pos, myItemList.get(y));
				 	SetFace(2);
				 	ChestProblems = true;
				 }
			 }		 */
			 
		 
			this.getWorld().setBlockState(MyPos, myBlock.withProperty(CookingPlusCustomGrowingBush.AGE, 5));
			return true;
		 }
		 
		 return false;
	 }
	 
	 private boolean WorkFisher(){
		 	List<ItemStack> myItemList = new java.util.ArrayList<ItemStack>();
		 	Random myRand = new Random();
			myItemList.add(new ItemStack(CookingPlusLootHelper.instance().GetRandomFish(myRand)));
			DepositItemStackListIntoChestList(myItemList);
			/*ArrayList<BlockPos> PosList;
			PosList = GetChestPosList();
			 
				for(int y = 0; y < myItemList.size(); y++){
					if(myItemList.get(y).stackSize > 0){
					ItemStack TempStack = CookingPlusLootHelper.instance().PutItemStackInChest((TileEntityChest)this.worldObj.getTileEntity(this.getPos().up()), myItemList.get(y));
					 	if(TempStack != null){
					 		myItemList.get(y).stackSize = TempStack.stackSize;
					 	}
					 	else{
					 		myItemList.get(y).stackSize = 0;
					 	}
					}
				}
			ChestProblems = false;
			 
			for(int y = 0; y < myItemList.size(); y++){
				if(myItemList.get(y).stackSize > 0){
					Block.spawnAsEntity(this.getWorld(), pos, myItemList.get(y));
				 	SetFace(2);
				 	ChestProblems = true;
				}
			}	*/
			
			return true;
	 }
	 
	 private boolean WorkGather(){

		 BlockPos WorkPos = null;
		 if(this.getWorld().getBlockState(getPos().down().north()).getBlock() != Blocks.AIR){
			 if(isGatherableBlock(this.getWorld().getBlockState(getPos().down().north()).getBlock())){
				 WorkPos = getPos().down().north();
			 }
		 }
		 if(this.getWorld().getBlockState(getPos().down().south()).getBlock() != Blocks.AIR){
			 if(isGatherableBlock(this.getWorld().getBlockState(getPos().down().south()).getBlock())){
				 WorkPos = getPos().down().south();
			 }
		 }
		 if(this.getWorld().getBlockState(getPos().down().east()).getBlock() != Blocks.AIR){
			 if(isGatherableBlock(this.getWorld().getBlockState(getPos().down().east()).getBlock())){
				 WorkPos = getPos().down().east();
			 }
		 }
		 if(this.getWorld().getBlockState(getPos().down().west()).getBlock() != Blocks.AIR){
			 if(isGatherableBlock(this.getWorld().getBlockState(getPos().down().west()).getBlock())){
				 WorkPos = getPos().down().west();
			 }
		 }
		 
		 if(WorkPos != null){
			 if(GetDropList(WorkPos).size() > 0){
				 DepositItemStackListIntoChestList(GetDropList(WorkPos));
				 if(this.getWorld().getBlockState(WorkPos.up()).getBlock() == Blocks.WATER){
					 this.getWorld().setBlockState(WorkPos, Blocks.WATER.getDefaultState());
				 }
				 else{
					 this.getWorld().setBlockState(WorkPos, Blocks.AIR.getDefaultState());
				 }
			 }
		 }
		 
		return false;
	 }
	 
	 private boolean WorkDesalinator(){
		 
		 int Workable = 0;
		 if(this.getWorld().getBlockState(getPos().down().north()).getBlock() != Blocks.AIR){
			 if(this.getWorld().getBlockState(getPos().down().north()).getBlock() == Blocks.WATER){
				 Workable++;
			 }
		 }
		 if(this.getWorld().getBlockState(getPos().down().south()).getBlock() != Blocks.AIR){
			 if(this.getWorld().getBlockState(getPos().down().south()).getBlock() == Blocks.WATER){
				 Workable++;
			 }
		 }
		 if(this.getWorld().getBlockState(getPos().down().east()).getBlock() != Blocks.AIR){
			 if(this.getWorld().getBlockState(getPos().down().east()).getBlock() == Blocks.WATER){
				 Workable++;
			 }
		 }
		 if(this.getWorld().getBlockState(getPos().down().west()).getBlock() != Blocks.AIR){
			 if(this.getWorld().getBlockState(getPos().down().west()).getBlock() == Blocks.WATER){
				 Workable++;
			 }
		 }
		 if(this.getWorld().getBlockState(getPos().down().down()).getBlock() != Blocks.AIR){
			 if(this.getWorld().getBlockState(getPos().down().down()).getBlock() == Blocks.WATER){
				 Workable++;
			 }
		 }
		 
		 if(Workable == 5){
				 DepositItemStackListIntoChestList(MakeDropList(new ItemStack(CookingPlusMain.saltpile)));
				 return true;
		 }
		 
		return false;
	 }
	 
	 private boolean WorkLogger(){
		 
		 boolean isDone = false;
		 int myX = this.getPos().getX();
		 int myY = this.getPos().getY();
		 int myZ = this.getPos().getZ();
		 
		 for(int ty = 0; ty <= 10 + getRangeBoost()*2  && isDone == false; ty++){
			 for(int tx = 0; tx <= 8 + getRangeBoost()*2 && isDone == false; tx++){
				 for(int tz = 0; tz <= 8 + getRangeBoost()*2  && isDone == false; tz++){
					 Vec3d myVec = new Vec3d(myX + tx - 4 - getRangeBoost() , myY - ty + 8 - getRangeBoost(), myZ + tz - 4 - getRangeBoost());
					 Block myBlock = this.getWorld().getBlockState(new BlockPos(myVec)).getBlock();
					 if(myBlock != Blocks.AIR){
						 if(CookingPlusGenericHelper.isLoggerPriorityBlock(myBlock)){
						 	DepositItemStackListIntoChestList(GetDropList(new BlockPos(myVec)));
						 	this.getWorld().setBlockState(new BlockPos(myVec), Blocks.AIR.getDefaultState());
						 	isDone = true;
					 	}
					 }
				 }
			 }
		 }
		 
		 for(int ty = 0; ty <= 10 + getRangeBoost()*2  && isDone == false; ty++){
			 for(int tx = 0; tx <= 8 + getRangeBoost()*2 && isDone == false; tx++){
				 for(int tz = 0; tz <= 8 + getRangeBoost()*2  && isDone == false; tz++){
					 Vec3d myVec = new Vec3d(myX + tx - 4 - getRangeBoost() , myY - ty + 8 - getRangeBoost(), myZ + tz - 4 - getRangeBoost());
					 Block myBlock = this.getWorld().getBlockState(new BlockPos(myVec)).getBlock();
					 if(myBlock.canSustainLeaves(this.getWorld().getBlockState(new BlockPos(myVec)), this.getWorld(), new BlockPos(myVec)) || myBlock instanceof BlockLeaves){
						 DepositItemStackListIntoChestList(GetDropList(new BlockPos(myVec)));
						 this.getWorld().setBlockState(new BlockPos(myVec), Blocks.AIR.getDefaultState());
						 isDone = true;
					 }
				 }
			 }
		 }
		 if(isDone == true){
			 return true;
		 }
		 
		 return false;
	 }
	 
	 private boolean WorkPlanter(){
		 
		 int myX = this.getPos().down().getX();
		 int myY = this.getPos().down().getY();
		 int myZ = this.getPos().down().getZ();

		 
		 //So we have our list of blocks we can plant on
		 //now we need to find a suitable sapling
		 List<BlockPos> ChestList = GetChestPosList();
		 List<Item> SaplingList = new java.util.ArrayList<Item>();
		 
			 //TileEntityChest myChest = (TileEntityChest) this.getWorld().getTileEntity(getChestPos());
			 boolean done = false;
			 TileEntityLockable myChest;
			 for(int c = 0; c < ChestList.size()  && done == false; c++){
				myChest = (TileEntityLockable) this.getWorld().getTileEntity(ChestList.get(c));
			 	for(int i = 0; i < myChest.getSizeInventory() && done == false; i++){
					 if(myChest.getStackInSlot(i) != null){
						 if(Block.getBlockFromItem(myChest.getStackInSlot(i).getItem()) != null){
							 Block mySaplingBlock = Block.getBlockFromItem(myChest.getStackInSlot(i).getItem());
							 if(mySaplingBlock instanceof CookingPlusCustomSapling || mySaplingBlock instanceof BlockSapling){
							 for(int tx = 0; tx <= 8 + getRangeBoost() * 2; tx++){
								for(int tz = 0; tz <= 8  + getRangeBoost() * 2; tz++){
									BlockPos myPos = new BlockPos(new Vec3d(myX + tx - 4 - getRangeBoost(), myY, myZ +tz - 4 - getRangeBoost()));
									if(this.getWorld().getBlockState(myPos).getBlock() == Blocks.AIR){
										if(mySaplingBlock.canPlaceBlockAt(this.getWorld(), myPos)){
											//Take the item and such
											 this.getWorld().setBlockState(myPos, mySaplingBlock.getDefaultState());
											 if(((TileEntityLockable) (this.getWorld().getTileEntity(ChestList.get(c)))).getStackInSlot(i).stackSize > 1){
												 ((TileEntityLockable) (this.getWorld().getTileEntity(ChestList.get(c)))).setInventorySlotContents(i, new ItemStack(myChest.getStackInSlot(i).getItem(), myChest.getStackInSlot(i).stackSize - 1));
											 }
											 else{
												 ((TileEntityLockable) (this.getWorld().getTileEntity(ChestList.get(c)))).setInventorySlotContents(i, null);
											 }
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
		 
		 return false;
	 }
	 
	 public List<ItemStack> GetDropList(BlockPos myBlockPos){
		 List<ItemStack> myList = new java.util.ArrayList<ItemStack>();
		
		IBlockState myState = this.getWorld().getBlockState(myBlockPos);
		Block myBlock = myState.getBlock();
		myList = myBlock.getDrops(getWorld(), myBlockPos, myState, 0);
		return myList;
	 }
	 
	 public List<ItemStack> MakeDropList(ItemStack myItemStack){
		 List<ItemStack> myList = new java.util.ArrayList<ItemStack>();
		 myList.add(myItemStack);
		return myList;
	 }
	 
	 private boolean isGatherableBlock(Block myBlock){
		 
		 if(myBlock instanceof CookingPlusCustomSpreadingHerb){
			 return true;
		 }
		 if(myBlock instanceof CookingPlusCustomSpreadingCoral){
			 return true;
		 }
		 if(myBlock instanceof CookingPlusCustomUnderwaterCrop){
			 return true;
		 }
		 if(myBlock instanceof BlockBush){
			 return true;
		 }
		 if(myBlock instanceof BlockPumpkin){
			 return true;
		 }
		 if(myBlock instanceof BlockMelon){
			 return true;
		 }
		 if(myBlock instanceof BlockReed){
			 return true;
		 }
		 
		 return false;
	 }
	 
	 public ArrayList<BlockPos> ContrustVineList(){
		
		 ArrayList<BlockPos> PosList = new ArrayList<BlockPos>();
		 
		 if(this.getDirection() == 2){
				if(this.getWorld().getBlockState(this.getPos().south()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().south());
				}
				if(this.getWorld().getBlockState(this.getPos().south().east()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().south().east());
				}
				if(this.getWorld().getBlockState(this.getPos().south().west()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().south().west());
				}
				
				if(this.getWorld().getBlockState(this.getPos().south().up()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().south().up());
				}
				if(this.getWorld().getBlockState(this.getPos().south().east().up()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().south().east().up());
				}
				if(this.getWorld().getBlockState(this.getPos().south().west().up()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().south().west().up());
				}
				
				if(this.getWorld().getBlockState(this.getPos().south().up().up()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().south().up().up());
				}
				if(this.getWorld().getBlockState(this.getPos().south().east().up().up()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().south().east().up().up());
				}
				if(this.getWorld().getBlockState(this.getPos().south().west().up().up()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().south().west().up().up());
				}
			}
			else if(this.getDirection() == 3){
				if(this.getWorld().getBlockState(this.getPos().north()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().north());
				}
				if(this.getWorld().getBlockState(this.getPos().north().east()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().north().east());
				}
				if(this.getWorld().getBlockState(this.getPos().north().west()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().north().west());
				}
				
				if(this.getWorld().getBlockState(this.getPos().north().up()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().north().up());
				}
				if(this.getWorld().getBlockState(this.getPos().north().east().up()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().north().east().up());
				}
				if(this.getWorld().getBlockState(this.getPos().north().west().up()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().north().west().up());
				}
				
				if(this.getWorld().getBlockState(this.getPos().north().up().up()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().north().up().up());
				}
				if(this.getWorld().getBlockState(this.getPos().north().east().up().up()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().north().east().up().up());
				}
				if(this.getWorld().getBlockState(this.getPos().north().west().up().up()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().north().west().up().up());
				}
			}
			else if(this.getDirection() == 4){
				if(this.getWorld().getBlockState(this.getPos().east()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().east());
				}
				if(this.getWorld().getBlockState(this.getPos().east().north()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().east().north());
				}
				if(this.getWorld().getBlockState(this.getPos().east().south()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().east().south());
				}
				
				if(this.getWorld().getBlockState(this.getPos().east().up()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().east().up());
				}
				if(this.getWorld().getBlockState(this.getPos().east().north().up()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().east().north().up());
				}
				if(this.getWorld().getBlockState(this.getPos().east().south().up()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().east().south().up());
				}
				
				if(this.getWorld().getBlockState(this.getPos().east().up().up()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().east().up().up());
				}
				if(this.getWorld().getBlockState(this.getPos().east().north().up().up()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().east().north().up().up());
				}
				if(this.getWorld().getBlockState(this.getPos().east().south().up().up()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().east().south().up().up());
				}
			}
			else if(this.getDirection() == 5){
				if(this.getWorld().getBlockState(this.getPos().west()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().west());
				}
				if(this.getWorld().getBlockState(this.getPos().west().north()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().west().north());
				}
				if(this.getWorld().getBlockState(this.getPos().west().south()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().west().south());
				}
				
				if(this.getWorld().getBlockState(this.getPos().west().up()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().west().up());
				}
				if(this.getWorld().getBlockState(this.getPos().west().north().up()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().west().north().up());
				}
				if(this.getWorld().getBlockState(this.getPos().west().south().up()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().west().south().up());
				}
				
				if(this.getWorld().getBlockState(this.getPos().west().up().up()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().west().up().up());
				}
				if(this.getWorld().getBlockState(this.getPos().west().north().up().up()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().west().north().up().up());
				}
				if(this.getWorld().getBlockState(this.getPos().west().south().up().up()).getBlock() instanceof CookingPlusCustomRopeCrop){
					PosList.add(this.getPos().west().south().up().up());
				}
			}
		 
		 
		 
		 if(this.getDirection() == 2){
				if(this.getWorld().getBlockState(this.getPos().south()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().south());
				}
				if(this.getWorld().getBlockState(this.getPos().south().east()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().south().east());
				}
				if(this.getWorld().getBlockState(this.getPos().south().west()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().south().west());
				}
				
				if(this.getWorld().getBlockState(this.getPos().south().up()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().south().up());
				}
				if(this.getWorld().getBlockState(this.getPos().south().east().up()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().south().east().up());
				}
				if(this.getWorld().getBlockState(this.getPos().south().west().up()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().south().west().up());
				}
				
				if(this.getWorld().getBlockState(this.getPos().south().up().up()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().south().up().up());
				}
				if(this.getWorld().getBlockState(this.getPos().south().east().up().up()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().south().east().up().up());
				}
				if(this.getWorld().getBlockState(this.getPos().south().west().up().up()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().south().west().up().up());
				}
			}
			else if(this.getDirection() == 3){
				if(this.getWorld().getBlockState(this.getPos().north()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().north());
				}
				if(this.getWorld().getBlockState(this.getPos().north().east()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().north().east());
				}
				if(this.getWorld().getBlockState(this.getPos().north().west()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().north().west());
				}
				
				if(this.getWorld().getBlockState(this.getPos().north().up()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().north().up());
				}
				if(this.getWorld().getBlockState(this.getPos().north().east().up()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().north().east().up());
				}
				if(this.getWorld().getBlockState(this.getPos().north().west().up()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().north().west().up());
				}
				
				if(this.getWorld().getBlockState(this.getPos().north().up().up()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().north().up().up());
				}
				if(this.getWorld().getBlockState(this.getPos().north().east().up().up()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().north().east().up().up());
				}
				if(this.getWorld().getBlockState(this.getPos().north().west().up().up()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().north().west().up().up());
				}
			}
			else if(this.getDirection() == 4){
				if(this.getWorld().getBlockState(this.getPos().east()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().east());
				}
				if(this.getWorld().getBlockState(this.getPos().east().north()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().east().north());
				}
				if(this.getWorld().getBlockState(this.getPos().east().south()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().east().south());
				}
				
				if(this.getWorld().getBlockState(this.getPos().east().up()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().east().up());
				}
				if(this.getWorld().getBlockState(this.getPos().east().north().up()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().east().north().up());
				}
				if(this.getWorld().getBlockState(this.getPos().east().south().up()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().east().south().up());
				}
				
				if(this.getWorld().getBlockState(this.getPos().east().up().up()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().east().up().up());
				}
				if(this.getWorld().getBlockState(this.getPos().east().north().up().up()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().east().north().up().up());
				}
				if(this.getWorld().getBlockState(this.getPos().east().south().up().up()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().east().south().up().up());
				}
			}
			else if(this.getDirection() == 5){
				if(this.getWorld().getBlockState(this.getPos().west()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().west());
				}
				if(this.getWorld().getBlockState(this.getPos().west().north()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().west().north());
				}
				if(this.getWorld().getBlockState(this.getPos().west().south()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().west().south());
				}
				
				if(this.getWorld().getBlockState(this.getPos().west().up()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().west().up());
				}
				if(this.getWorld().getBlockState(this.getPos().west().north().up()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().west().north().up());
				}
				if(this.getWorld().getBlockState(this.getPos().west().south().up()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().west().south().up());
				}
				
				if(this.getWorld().getBlockState(this.getPos().west().up().up()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().west().up().up());
				}
				if(this.getWorld().getBlockState(this.getPos().west().north().up().up()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().west().north().up().up());
				}
				if(this.getWorld().getBlockState(this.getPos().west().south().up().up()).getBlock() instanceof CookingPlusCustomGrowingBush){
					PosList.add(this.getPos().west().south().up().up());
				}
			}
		 
		 return PosList; 
	 }
	 
	 public ArrayList<BlockPos> GetNetworkedChestList(ArrayList<BlockPos> ExistingChestList){
		 ArrayList<BlockPos> NetworkList = new ArrayList<BlockPos>();
		 ArrayList<BlockPos> ChestList = new ArrayList<BlockPos>();
		 Block NetworkBlock = CookingPlusMain.blockNetworkBlock;
		 
		 Block NorthBlock  = this.getWorld().getBlockState(this.getPos().north()).getBlock();
		 Block SouthBlock = this.getWorld().getBlockState(this.getPos().south()).getBlock();
		 Block EastBlock = this.getWorld().getBlockState(this.getPos().east()).getBlock();
		 Block WestBlock  = this.getWorld().getBlockState(this.getPos().west()).getBlock();
		 Block UpBlock  = this.getWorld().getBlockState(this.getPos().up()).getBlock();
		 Block DownBlock  = this.getWorld().getBlockState(this.getPos().down()).getBlock();
		 if(this.getDirection() == 2){
				if(this.getWorld().getBlockState(this.getPos().east()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().east());
				}
				if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().west());
				}
				if(this.getWorld().getBlockState(this.getPos().south()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().south());
				}
				if(this.getWorld().getBlockState(this.getPos().up()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().up());
				}
				if(this.getWorld().getBlockState(this.getPos().down()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().down());
				}		
			}
		 	else if(this.getDirection() == 3){
				if(this.getWorld().getBlockState(this.getPos().east()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().east());
				}
				if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().west());
				}
				if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().north());
				}
				if(this.getWorld().getBlockState(this.getPos().up()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().up());
				}
				if(this.getWorld().getBlockState(this.getPos().down()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().down());
				}
			}
		 	else if(this.getDirection() == 4){
				if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().north());
				}
				if(this.getWorld().getBlockState(this.getPos().south()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().south());
				}
				if(this.getWorld().getBlockState(this.getPos().east()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().east());
				}
				if(this.getWorld().getBlockState(this.getPos().up()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().up());
				}
				if(this.getWorld().getBlockState(this.getPos().down()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().down());
				}
			}
		 	else if(this.getDirection() == 5){
				if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().north());
				}
				if(this.getWorld().getBlockState(this.getPos().south()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().south());
				}
				if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().west());
				}
				if(this.getWorld().getBlockState(this.getPos().up()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().up());
				}
				if(this.getWorld().getBlockState(this.getPos().down()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().down());
				}
			}
		 
		 for(int i = 0; i < NetworkList.size(); i++){
			 BlockPos myCurrentPos = NetworkList.get(i);
			  
			 	if(this.getWorld().getBlockState(myCurrentPos.north()).getBlock() == NetworkBlock && !NetworkList.contains(myCurrentPos.north())){
					NetworkList.add(myCurrentPos.north());
				}
				if(this.getWorld().getBlockState(myCurrentPos.south()).getBlock() == NetworkBlock && !NetworkList.contains(myCurrentPos.south())){
					NetworkList.add(myCurrentPos.south());
				}
				if(this.getWorld().getBlockState(myCurrentPos.west()).getBlock() == NetworkBlock && !NetworkList.contains(myCurrentPos.west())){
					NetworkList.add(myCurrentPos.west());
				}
				if(this.getWorld().getBlockState(myCurrentPos.east()).getBlock() == NetworkBlock && !NetworkList.contains(myCurrentPos.east())){
					NetworkList.add(myCurrentPos.east());
				}
				if(this.getWorld().getBlockState(myCurrentPos.up()).getBlock() == NetworkBlock && !NetworkList.contains(myCurrentPos.up())){
					NetworkList.add(myCurrentPos.up());
				}
				if(this.getWorld().getBlockState(myCurrentPos.down()).getBlock() == NetworkBlock && !NetworkList.contains(myCurrentPos.down())){
					NetworkList.add(myCurrentPos.down());
				}
		 }
		 
		 for(int i = 0; i < NetworkList.size(); i++){
			 BlockPos myCurrentPos = NetworkList.get(i);
			 
			 NorthBlock  = this.getWorld().getBlockState(myCurrentPos.north()).getBlock();
			 SouthBlock = this.getWorld().getBlockState(myCurrentPos.south()).getBlock();
			 EastBlock = this.getWorld().getBlockState(myCurrentPos.east()).getBlock();
			 WestBlock  = this.getWorld().getBlockState(myCurrentPos.west()).getBlock();
			 UpBlock  = this.getWorld().getBlockState(myCurrentPos.up()).getBlock();
			 DownBlock  = this.getWorld().getBlockState(myCurrentPos.down()).getBlock();
			 
			 	if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(NorthBlock, getWorld(), myCurrentPos.north()) && !ExistingChestList.contains(myCurrentPos.north()) && !ChestList.contains(myCurrentPos.north())){
					ChestList.add(myCurrentPos.north());
				}
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(SouthBlock, getWorld(), myCurrentPos.south()) && !ExistingChestList.contains(myCurrentPos.south()) && !ChestList.contains(myCurrentPos.south())){
					ChestList.add(myCurrentPos.south());
				}
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(WestBlock, getWorld(), myCurrentPos.west()) && !ExistingChestList.contains(myCurrentPos.west()) && !ChestList.contains(myCurrentPos.west())){
					ChestList.add(myCurrentPos.west());
				}
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(EastBlock, getWorld(), myCurrentPos.east()) && !ExistingChestList.contains(myCurrentPos.east()) && !ChestList.contains(myCurrentPos.east())){
					ChestList.add(myCurrentPos.east());
				}
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(UpBlock, getWorld(), myCurrentPos.up()) && !ExistingChestList.contains(myCurrentPos.up()) && !ChestList.contains(myCurrentPos.up())){
					ChestList.add(myCurrentPos.up());
				}
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(DownBlock, getWorld(), myCurrentPos.down()) && !ExistingChestList.contains(myCurrentPos.down()) && !ChestList.contains(myCurrentPos.down())){
					ChestList.add(myCurrentPos.down());
				}
		 }
		 ChestList.addAll(ExistingChestList);
		return ChestList;
	 }
	 
	 public boolean CheckListforPos(ArrayList<BlockPos> myList, BlockPos CheckPos){
		 for(int i = 0; i < myList.size(); i++){
			 if(myList.get(i).getX() == CheckPos.getX() && myList.get(i).getY() == CheckPos.getY() && myList.get(i).getZ() == CheckPos.getZ()){
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 public ArrayList<BlockPos> GetChestPosList(){
		 ArrayList<BlockPos> PosList = new ArrayList<BlockPos>();
		 Block NorthBlock  = this.getWorld().getBlockState(this.getPos().north()).getBlock();
		 Block SouthBlock = this.getWorld().getBlockState(this.getPos().south()).getBlock();
		 Block EastBlock = this.getWorld().getBlockState(this.getPos().east()).getBlock();
		 Block WestBlock  = this.getWorld().getBlockState(this.getPos().west()).getBlock();
		 Block UpBlock  = this.getWorld().getBlockState(this.getPos().up()).getBlock();
		 Block DownBlock  = this.getWorld().getBlockState(this.getPos().down()).getBlock();
		 if(this.getDirection() == 2){//Exclude North
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(SouthBlock, getWorld(), getPos().south())){
					PosList.add(this.getPos().south());
				}
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(EastBlock, getWorld(), getPos().east())){
					PosList.add(this.getPos().east());
				}
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(WestBlock, getWorld(), getPos().west())){
					PosList.add(this.getPos().west());
				}
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(UpBlock, getWorld(), getPos().up())){
					PosList.add(this.getPos().up());
				}
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(DownBlock, getWorld(), getPos().down())){
					PosList.add(this.getPos().down());
				}
			}
			else if(this.getDirection() == 3){//Exclude South
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(NorthBlock, getWorld(), getPos().north())){
					PosList.add(this.getPos().north());
				}
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(EastBlock, getWorld(), getPos().east())){
					PosList.add(this.getPos().east());
				}
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(WestBlock, getWorld(), getPos().west())){
					PosList.add(this.getPos().west());
				}
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(UpBlock, getWorld(), getPos().up())){
					PosList.add(this.getPos().up());
				}
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(DownBlock, getWorld(), getPos().down())){
					PosList.add(this.getPos().down());
				}
				
			}
			else if(this.getDirection() == 4){//Exclude West
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(SouthBlock, getWorld(), getPos().south())){
					PosList.add(this.getPos().south());
				}
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(NorthBlock, getWorld(), getPos().north())){
					PosList.add(this.getPos().north());
				}
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(EastBlock, getWorld(), getPos().east())){
					PosList.add(this.getPos().east());
				}
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(UpBlock, getWorld(), getPos().up())){
					PosList.add(this.getPos().up());
				}
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(DownBlock, getWorld(), getPos().down())){
					PosList.add(this.getPos().down());
				}
			}
			else if(this.getDirection() == 5){//Exclude East
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(SouthBlock, getWorld(), getPos().south())){
					PosList.add(this.getPos().south());
				}
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(NorthBlock, getWorld(), getPos().north())){
					PosList.add(this.getPos().north());
				}
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(WestBlock, getWorld(), getPos().west())){
					PosList.add(this.getPos().west());
				}
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(UpBlock, getWorld(), getPos().up())){
					PosList.add(this.getPos().up());
				}
				if(CookingPlusGenericHelper.isValidAttachmentNetworkInventoryBlock(DownBlock, getWorld(), getPos().down())){
					PosList.add(this.getPos().down());
				}
			}
		 
		 if(CookingPlusConfig.EnableBotNetwork == true){
			 return GetNetworkedChestList(PosList);
		 }
		 else{
			 return PosList;
		 }
	 }
	 
	 public BlockPos getChestPos(){
		 	if(this.getDirection() == 2){
				if(this.getWorld().getBlockState(this.getPos().south()).getBlock() == Blocks.CHEST){
					return this.getPos().south();
				}
			}
			else if(this.getDirection() == 3){
				if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == Blocks.CHEST){
					return this.getPos().north();
				}
			}
			else if(this.getDirection() == 4){
				if(this.getWorld().getBlockState(this.getPos().east()).getBlock() == Blocks.CHEST){
					return this.getPos().east();
				}
			}
			else if(this.getDirection() == 5){
				if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == Blocks.CHEST){
					return this.getPos().west();
				}
			}
			return null;
	 }
	
	 public boolean DepositItemStackListIntoChestList(List<ItemStack> myItemList){
		 
		 ArrayList<BlockPos> PosList;
		 PosList = GetChestPosList();
		 
		 for(int i = 0; i < PosList.size() && myItemList.size() > 0; i++){
			 for(int y = 0; y < myItemList.size(); y++){
				 if(myItemList.get(y).stackSize > 0 && myItemList.get(y).getItem() != null){
				 ItemStack TempStack = CookingPlusLootHelper.instance().PutItemStackInChest((TileEntityLockable)this.worldObj.getTileEntity(PosList.get(i)), myItemList.get(y));
				 	if(TempStack != null){
				 		myItemList.get(y).stackSize = TempStack.stackSize;
				 	}
				 	else{
				 		myItemList.get(y).stackSize = 0;
				 	}
				 }
			 }
		 }
		 ChestProblems = false;
		 
		 for(int y = 0; y < myItemList.size(); y++){
			 if(myItemList.get(y).stackSize > 0 && myItemList.get(y).getItem() != null){
				if(shouldDestroyExcess() == false){
					Block.spawnAsEntity(this.getWorld(), pos, myItemList.get(y));
				}
			 	SetFace(2);
			 	ChestProblems = true;
			 }
		 }		 
		 
		return false;
	 }
	 
	 public boolean hasWorkableVines(){
		 
		 if(this.getDirection() == 2){
				if(this.getWorld().getBlockState(this.getPos().south()).getBlock() instanceof CookingPlusCustomRopeCrop || this.getWorld().getBlockState(this.getPos().south()).getBlock() instanceof CookingPlusCustomGrowingBush){
					return true;
				}
				if(this.getWorld().getBlockState(this.getPos().south().east()).getBlock() instanceof CookingPlusCustomRopeCrop || this.getWorld().getBlockState(this.getPos().south().east()).getBlock() instanceof CookingPlusCustomGrowingBush){
					return true;
				}
				if(this.getWorld().getBlockState(this.getPos().south().west()).getBlock() instanceof CookingPlusCustomRopeCrop || this.getWorld().getBlockState(this.getPos().south().west()).getBlock() instanceof CookingPlusCustomGrowingBush){
					return true;
				}
			}
			else if(this.getDirection() == 3){
				if(this.getWorld().getBlockState(this.getPos().north()).getBlock() instanceof CookingPlusCustomRopeCrop || this.getWorld().getBlockState(this.getPos().north()).getBlock() instanceof CookingPlusCustomGrowingBush){
					return true;
				}
				if(this.getWorld().getBlockState(this.getPos().north().east()).getBlock() instanceof CookingPlusCustomRopeCrop || this.getWorld().getBlockState(this.getPos().north().east()).getBlock() instanceof CookingPlusCustomGrowingBush){
					return true;
				}
				if(this.getWorld().getBlockState(this.getPos().north().west()).getBlock() instanceof CookingPlusCustomRopeCrop  || this.getWorld().getBlockState(this.getPos().north().west()).getBlock() instanceof CookingPlusCustomGrowingBush){
					return true;
				}
			}
			else if(this.getDirection() == 4){
				if(this.getWorld().getBlockState(this.getPos().east()).getBlock() instanceof CookingPlusCustomRopeCrop || this.getWorld().getBlockState(this.getPos().east()).getBlock() instanceof CookingPlusCustomGrowingBush){
					return true;
				}
				if(this.getWorld().getBlockState(this.getPos().east().north()).getBlock() instanceof CookingPlusCustomRopeCrop || this.getWorld().getBlockState(this.getPos().east().north()).getBlock() instanceof CookingPlusCustomGrowingBush){
					return true;
				}
				if(this.getWorld().getBlockState(this.getPos().east().south()).getBlock() instanceof CookingPlusCustomRopeCrop || this.getWorld().getBlockState(this.getPos().east().south()).getBlock() instanceof CookingPlusCustomGrowingBush){
					return true;
				}
			}
			else if(this.getDirection() == 5){
				if(this.getWorld().getBlockState(this.getPos().west()).getBlock() instanceof CookingPlusCustomRopeCrop || this.getWorld().getBlockState(this.getPos().west()).getBlock() instanceof CookingPlusCustomGrowingBush){
					return true;
				}
				if(this.getWorld().getBlockState(this.getPos().west().north()).getBlock() instanceof CookingPlusCustomRopeCrop || this.getWorld().getBlockState(this.getPos().west().north()).getBlock() instanceof CookingPlusCustomGrowingBush){
					return true;
				}
				if(this.getWorld().getBlockState(this.getPos().west().south()).getBlock() instanceof CookingPlusCustomRopeCrop || this.getWorld().getBlockState(this.getPos().west().south()).getBlock() instanceof CookingPlusCustomGrowingBush){
					return true;
				}
			}
		 
		 return false;
	 }
	 
	public void processActivate(EntityPlayer playerIn) {
		if(myFace == 2){
			playerIn.addChatMessage(new TextComponentTranslation("msg.botchest.txt"));
		}
		else if(myFace == 1){
			playerIn.addChatMessage(new TextComponentTranslation("msg.botwork.txt"));
		}
		else if(myFace == 0){
			playerIn.addChatMessage(new TextComponentTranslation("msg.botgood.txt"));
		}
		else if(myFace == 3){
			playerIn.addChatMessage(new TextComponentTranslation("msg.botnopower.txt"));
		}
		
	}

	private int GetMode(){
		if(this.getWorld().getBlockState(this.getPos().up()).getBlock() == CookingPlusMain.blockGrabber){
			return 1;
		}
		else if(this.getWorld().getBlockState(this.getPos().down()).getBlock() == CookingPlusMain.blockFisher){
			return 2;
		}
		else if(this.getWorld().getBlockState(this.getPos().down()).getBlock() == CookingPlusMain.blockGatherer){
			return 3;
		}
		else if(this.getWorld().getBlockState(this.getPos().down()).getBlock() == CookingPlusMain.blockDesalinator){
			return 4;
		}
		else if(this.getWorld().getBlockState(this.getPos().up()).getBlock() == CookingPlusMain.blockLogger){
			return 5;
		}
		else if(this.getWorld().getBlockState(this.getPos().down()).getBlock() == CookingPlusMain.blockPlanter){
			return 6;
		}
		else if(this.getWorld().getBlockState(this.getPos().up()).getBlock() == CookingPlusMain.blockLaserDroneBay){
			return 7;
		}
		else if(this.getWorld().getBlockState(this.getPos().up()).getBlock() == CookingPlusMain.blockMutationStation){
			return 8;
		}
		else if(this.getWorld().getBlockState(this.getPos().up()).getBlock() == CookingPlusMain.blockFishTank){
			return 9;
		}
		else if(this.getWorld().getBlockState(this.getPos().up()).getBlock() == CookingPlusMain.blockAnalyser){
			return 10;
		}
		else if(this.getWorld().getBlockState(this.getPos().up()).getBlock() == CookingPlusMain.blockInscriber){
			return 11;
		}
		else if(this.getWorld().getBlockState(this.getPos().up()).getBlock() == CookingPlusMain.blockResearch){
			return 12;
		}
		else return 0;
	}
	
	public void DefaultMode(){
		prevFace = myFace;
		HarvestTimer++;
		if(GetChestPosList().size() > 0){
			if(hasWorkable()){
				if(HarvestTimer > ((float)CookingPlusConfig.HHBHarvestRate) * getSpeedMultiplier()){
					if(ChestProblems == false){
						SetFace(0);
					}
					if(WorkBlocks()){
						HarvestTimer = 0;
					}
				}
			}
			else{
				SetFace(1);
			}
		}
		else{
			SetFace(2);
		}
		
		if(prevFace != myFace){
			UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
		}
	}
	
	public void PickerMode(){
		prevFace = myFace;
		HarvestTimer++;
		
		if(GetChestPosList().size() > 0){
			if(hasWorkableVines()){
				if(HarvestTimer > ((float)CookingPlusConfig.HHBPickRate) * getSpeedMultiplier()){
					if(ChestProblems == false){
						SetFace(0);
					}
					if(WorkVines()){
						HarvestTimer = 0;
					}
				}
			}
			else{
				SetFace(1);
			}
		}
		else{
			SetFace(2);
		}
		
		if(prevFace != myFace){
			UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
		}
	}

	public void FisherMode(){
		prevFace = myFace;
		HarvestTimer++;
		
		if(GetChestPosList().size() > 0){
			if(this.getWorld().getBlockState(getPos().down()).getBlock() == CookingPlusMain.blockFisher){
				if(HarvestTimer > ((float)CookingPlusConfig.HHBFishRate) * getSpeedMultiplier()){
					if(ChestProblems == false){
						SetFace(0);
					}
					if(WorkFisher()){
						HarvestTimer = 0;
					}
				}
			}
			else{
				SetFace(1);
			}
		}
		else{
			SetFace(2);
		}
		
		if(prevFace != myFace){
			UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
		}
	}

	public void GatherMode(){
		prevFace = myFace;
		HarvestTimer++;
		
		if(GetChestPosList().size() > 0){
			if(this.getWorld().getBlockState(getPos().down()).getBlock() == CookingPlusMain.blockGatherer){
				if(HarvestTimer > ((float)CookingPlusConfig.HHBGatherRate) * getSpeedMultiplier()){
					if(ChestProblems == false){
						SetFace(0);
					}
					if(WorkGather()){
						HarvestTimer = 0;
					}
				}
			}
			else{
				SetFace(1);
			}
		}
		else{
			SetFace(2);
		}
		
		if(prevFace != myFace){
			UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
		}
	}

	public void DesalinatorMode(){
		prevFace = myFace;
		HarvestTimer++;
		
		if(GetChestPosList().size() > 0){
			if(this.getWorld().getBlockState(getPos().down()).getBlock() == CookingPlusMain.blockDesalinator){
				if(HarvestTimer > ((float)CookingPlusConfig.HHBDesalinationRate) * getSpeedMultiplier()){
					if(ChestProblems == false){
						SetFace(0);
					}
					if(WorkDesalinator()){
						HarvestTimer = 0;
					}
				}
			}
			else{
				SetFace(1);
			}
		}
		else{
			SetFace(2);
		}
		
		if(prevFace != myFace){
			UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
		}
	}

	public void LoggerMode(){
		prevFace = myFace;
		HarvestTimer++;
		
		if(GetChestPosList().size() > 0){
			if(this.getWorld().getBlockState(getPos().up()).getBlock() == CookingPlusMain.blockLogger){
				if(HarvestTimer > ((float)CookingPlusConfig.HHBLoggerRate) * getSpeedMultiplier()){
					if(ChestProblems == false){
						SetFace(0);
					}
					if(WorkLogger()){
						HarvestTimer = 0;
					}
				}
			}
			else{
				SetFace(1);
			}
		}
		else{
			SetFace(2);
		}
		
		if(prevFace != myFace){
			UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
		}
	}

	public void PlanterMode(){
		prevFace = myFace;
		HarvestTimer++;
		
		if(GetChestPosList().size() > 0){
			if(this.getWorld().getBlockState(getPos().down()).getBlock() == CookingPlusMain.blockPlanter){
				if(HarvestTimer > ((float)CookingPlusConfig.HHBPlanterRate) * getSpeedMultiplier()){
					if(ChestProblems == false){
						SetFace(0);
					}
					if(WorkPlanter()){
						HarvestTimer = 0;
					}
				}
			}
			else{
				SetFace(1);
			}
		}
		else{
			SetFace(2);
		}
		
		if(prevFace != myFace){
			UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
		}
	}

	public void LaserDroneBayMode(){
		prevFace = myFace;
		
		
		if(GetChestPosList().size() > 0){
			if(this.getWorld().getBlockState(getPos().up()).getBlock() == CookingPlusMain.blockLaserDroneBay){
				LaserDroneBayTileEntity myLaserDroneBay = (LaserDroneBayTileEntity) this.getWorld().getTileEntity(getPos().up());
				if(ChestProblems == false){
					SetFace(0);
				}
				if(myLaserDroneBay.updateLaserDrone(getPos().up(), getSpeedMultiplier(), this, getRangeBoost())){
					SetFace(0);
				}
				else{
					SetFace(1);
				}
			}
			else{
				SetFace(1);
			}
		}
		else{
			SetFace(2);
		}
		
		if(prevFace != myFace){
			UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
		}
	}

	public void MutationStationMode(){
		prevFace = myFace;
		if(this.getWorld().getBlockState(getPos().up()).getBlock() == CookingPlusMain.blockMutationStation){
			MutationStationTileEntity myStation = (MutationStationTileEntity) this.getWorld().getTileEntity(getPos().up());
			myStation.updateByBot(getSpeedMultiplier());
			SetFace(0);
		}
		if(prevFace != myFace){
			UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
		}
	}
	
	public void AnalyserMode(){
		prevFace = myFace;
		if(this.getWorld().getBlockState(getPos().up()).getBlock() == CookingPlusMain.blockAnalyser){
			AnalyserTileEntity myStation = (AnalyserTileEntity) this.getWorld().getTileEntity(getPos().up());
			myStation.updateByBot(getSpeedMultiplier());
			SetFace(0);
		}
		if(prevFace != myFace){
			UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
		}
	}
	
	public void InscriberMode(){
		prevFace = myFace;
		if(this.getWorld().getBlockState(getPos().up()).getBlock() == CookingPlusMain.blockInscriber){
			InscriberTileEntity myStation = (InscriberTileEntity) this.getWorld().getTileEntity(getPos().up());
			myStation.updateByBot(getSpeedMultiplier());
			SetFace(0);
		}
		if(prevFace != myFace){
			UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
		}
	}
	
	public void ResearchMode(){
		prevFace = myFace;
		if(this.getWorld().getBlockState(getPos().up()).getBlock() == CookingPlusMain.blockResearch){
			ResearchLabTileEntity myStation = (ResearchLabTileEntity) this.getWorld().getTileEntity(getPos().up());
			myStation.updateByBot(getSpeedMultiplier());
			SetFace(0);
		}
		if(prevFace != myFace){
			UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
		}
	}
	
	public void FishTankMode(){
		prevFace = myFace;
		HarvestTimer++;
		
		if(GetChestPosList().size() > 0){
			if(this.getWorld().getBlockState(getPos().up()).getBlock() == CookingPlusMain.blockFishTank){
				FishTankTileEntity myTank = (FishTankTileEntity) this.getWorld().getTileEntity(getPos().up());
				if(HarvestTimer > ((float)CookingPlusConfig.HHBFishTankExtractionRate) * getSpeedMultiplier()){
					if(ChestProblems == false){
						SetFace(0);
					}
					ItemStack myStack = myTank.getHappyHarvestBotItemStack();
					if(myStack != null){
						List<ItemStack> myItemList = new ArrayList();
						myItemList.add(myStack);
						HarvestTimer = 0;
						DepositItemStackListIntoChestList(myItemList);
					}
				}
			}
			else{
				SetFace(1);
			}
		}
		else{
			SetFace(2);
		}
		
		if(prevFace != myFace){
			UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
		}

	}
	
	public void DepositBlockPositionIntoChest(BlockPos myPos){
		DepositItemStackListIntoChestList(GetDropList(new BlockPos(myPos)));
	}
	
	public float getSpeedMultiplier(){
		
		float myTotalSpeedMultiplier = speedMultiplier;
		Block mySpeedBlock = CookingPlusMain.blockSpeedBlock;
		//Facing North
		if(this.getDirection() == 2){
			myTotalSpeedMultiplier = getSpeedBoostValue(getWorld().getBlockState(this.getPos().south()).getBlock(), myTotalSpeedMultiplier);
			myTotalSpeedMultiplier = getSpeedBoostValue(getWorld().getBlockState(this.getPos().east()).getBlock(), myTotalSpeedMultiplier);
			myTotalSpeedMultiplier = getSpeedBoostValue(getWorld().getBlockState(this.getPos().west()).getBlock(), myTotalSpeedMultiplier);
		}
		//Facing South
		else if(this.getDirection() == 3){
			myTotalSpeedMultiplier = getSpeedBoostValue(getWorld().getBlockState(this.getPos().north()).getBlock(), myTotalSpeedMultiplier);
			myTotalSpeedMultiplier = getSpeedBoostValue(getWorld().getBlockState(this.getPos().east()).getBlock(), myTotalSpeedMultiplier);
			myTotalSpeedMultiplier = getSpeedBoostValue(getWorld().getBlockState(this.getPos().west()).getBlock(), myTotalSpeedMultiplier);
		
		}
		//Facing West
		else if(this.getDirection() == 4){
			myTotalSpeedMultiplier = getSpeedBoostValue(getWorld().getBlockState(this.getPos().south()).getBlock(), myTotalSpeedMultiplier);
			myTotalSpeedMultiplier = getSpeedBoostValue(getWorld().getBlockState(this.getPos().east()).getBlock(), myTotalSpeedMultiplier);
			myTotalSpeedMultiplier = getSpeedBoostValue(getWorld().getBlockState(this.getPos().north()).getBlock(), myTotalSpeedMultiplier);
		
		}
		//Facing East
		else if(this.getDirection() == 5){
			myTotalSpeedMultiplier = getSpeedBoostValue(getWorld().getBlockState(this.getPos().south()).getBlock(), myTotalSpeedMultiplier);
			myTotalSpeedMultiplier = getSpeedBoostValue(getWorld().getBlockState(this.getPos().north()).getBlock(), myTotalSpeedMultiplier);
			myTotalSpeedMultiplier = getSpeedBoostValue(getWorld().getBlockState(this.getPos().west()).getBlock(), myTotalSpeedMultiplier);
		
		}
		//System.out.println(myTotalSpeedMultiplier);
		return myTotalSpeedMultiplier;
	}
	
	public int getRangeBoost(){
		
		int mySingularRangeBoost = 0;
		Block mySpeedBlock = CookingPlusMain.blockRangeBlock;
		//Facing North
		if(this.getDirection() == 2){
			mySingularRangeBoost = getRangeBoostValue(getWorld().getBlockState(this.getPos().south()).getBlock(), mySingularRangeBoost);
			mySingularRangeBoost = getRangeBoostValue(getWorld().getBlockState(this.getPos().east()).getBlock(), mySingularRangeBoost);
			mySingularRangeBoost = getRangeBoostValue(getWorld().getBlockState(this.getPos().west()).getBlock(), mySingularRangeBoost);

		}
		//Facing South
		else if(this.getDirection() == 3){
			mySingularRangeBoost = getRangeBoostValue(getWorld().getBlockState(this.getPos().north()).getBlock(), mySingularRangeBoost);
			mySingularRangeBoost = getRangeBoostValue(getWorld().getBlockState(this.getPos().east()).getBlock(), mySingularRangeBoost);
			mySingularRangeBoost = getRangeBoostValue(getWorld().getBlockState(this.getPos().west()).getBlock(), mySingularRangeBoost);

		}
		//Facing West
		else if(this.getDirection() == 4){
			mySingularRangeBoost = getRangeBoostValue(getWorld().getBlockState(this.getPos().south()).getBlock(), mySingularRangeBoost);
			mySingularRangeBoost = getRangeBoostValue(getWorld().getBlockState(this.getPos().east()).getBlock(), mySingularRangeBoost);
			mySingularRangeBoost = getRangeBoostValue(getWorld().getBlockState(this.getPos().north()).getBlock(), mySingularRangeBoost);

		}
		//Facing East
		else if(this.getDirection() == 5){
			mySingularRangeBoost = getRangeBoostValue(getWorld().getBlockState(this.getPos().south()).getBlock(), mySingularRangeBoost);
			mySingularRangeBoost = getRangeBoostValue(getWorld().getBlockState(this.getPos().north()).getBlock(), mySingularRangeBoost);
			mySingularRangeBoost = getRangeBoostValue(getWorld().getBlockState(this.getPos().west()).getBlock(), mySingularRangeBoost);

		}
		//System.out.println(myTotalSpeedMultiplier);
		return mySingularRangeBoost;
	}
	
	public int getRangeBoostValue(Block myBlock, int myRangeBoost){
			if(myBlock == CookingPlusMain.blockRangeBlock){
				myRangeBoost += 1;
			}
			if(myBlock == CookingPlusMain.blockGoldenRangeBlock){
				myRangeBoost += 2;
			}
			if(myBlock == CookingPlusMain.blockDiamondRangeBlock){
				myRangeBoost += 3;
			}
		return myRangeBoost;
	}
	
	public float getSpeedBoostValue(Block myBlock, float mySpeedValue){
		
			if(myBlock == CookingPlusMain.blockSpeedBlock){
				mySpeedValue = mySpeedValue * 0.8f;
			}
			if(myBlock == CookingPlusMain.blockGoldenSpeedBlock){
				mySpeedValue = mySpeedValue * 0.6f;
			}
			if(myBlock == CookingPlusMain.blockDiamondSpeedBlock){
				mySpeedValue = mySpeedValue * 0.4f;
			}
		return mySpeedValue;
	}

	public ArrayList<BlockPos> getPowerPosList(){
		 ArrayList<BlockPos> PosList = new ArrayList<BlockPos>();
		 Block NorthBlock  = this.getWorld().getBlockState(this.getPos().north()).getBlock();
		 Block SouthBlock = this.getWorld().getBlockState(this.getPos().south()).getBlock();
		 Block EastBlock = this.getWorld().getBlockState(this.getPos().east()).getBlock();
		 Block WestBlock  = this.getWorld().getBlockState(this.getPos().west()).getBlock();
		 Block UpBlock  = this.getWorld().getBlockState(this.getPos().up()).getBlock();
		 Block DownBlock  = this.getWorld().getBlockState(this.getPos().down()).getBlock();
		 if(this.getDirection() == 2){//Exclude North
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(SouthBlock, getWorld(), getPos().south())){
					PosList.add(this.getPos().south());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(EastBlock, getWorld(), getPos().east())){
					PosList.add(this.getPos().east());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(WestBlock, getWorld(), getPos().west())){
					PosList.add(this.getPos().west());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(UpBlock, getWorld(), getPos().up())){
					PosList.add(this.getPos().up());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(DownBlock, getWorld(), getPos().down())){
					PosList.add(this.getPos().down());
				}
			}
			else if(this.getDirection() == 3){//Exclude South
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(NorthBlock, getWorld(), getPos().north())){
					PosList.add(this.getPos().north());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(EastBlock, getWorld(), getPos().east())){
					PosList.add(this.getPos().east());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(WestBlock, getWorld(), getPos().west())){
					PosList.add(this.getPos().west());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(UpBlock, getWorld(), getPos().up())){
					PosList.add(this.getPos().up());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(DownBlock, getWorld(), getPos().down())){
					PosList.add(this.getPos().down());
				}
				
			}
			else if(this.getDirection() == 4){//Exclude West
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(SouthBlock, getWorld(), getPos().south())){
					PosList.add(this.getPos().south());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(NorthBlock, getWorld(), getPos().north())){
					PosList.add(this.getPos().north());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(EastBlock, getWorld(), getPos().east())){
					PosList.add(this.getPos().east());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(UpBlock, getWorld(), getPos().up())){
					PosList.add(this.getPos().up());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(DownBlock, getWorld(), getPos().down())){
					PosList.add(this.getPos().down());
				}
			}
			else if(this.getDirection() == 5){//Exclude East
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(SouthBlock, getWorld(), getPos().south())){
					PosList.add(this.getPos().south());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(NorthBlock, getWorld(), getPos().north())){
					PosList.add(this.getPos().north());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(WestBlock, getWorld(), getPos().west())){
					PosList.add(this.getPos().west());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(UpBlock, getWorld(), getPos().up())){
					PosList.add(this.getPos().up());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(DownBlock, getWorld(), getPos().down())){
					PosList.add(this.getPos().down());
				}
			}
		 
		 if(CookingPlusConfig.EnableBotNetwork == true){
			 return GetNetworkedpowerPosList(PosList);
		 }
		 else{
			 return PosList;
		 }
	 }
	 
	public ArrayList<BlockPos> GetNetworkedpowerPosList(ArrayList<BlockPos> ExistingChestList){
		 ArrayList<BlockPos> NetworkList = new ArrayList<BlockPos>();
		 ArrayList<BlockPos> ChestList = new ArrayList<BlockPos>();
		 Block NetworkBlock = CookingPlusMain.blockNetworkBlock;
		 
		 Block NorthBlock  = this.getWorld().getBlockState(this.getPos().north()).getBlock();
		 Block SouthBlock = this.getWorld().getBlockState(this.getPos().south()).getBlock();
		 Block EastBlock = this.getWorld().getBlockState(this.getPos().east()).getBlock();
		 Block WestBlock  = this.getWorld().getBlockState(this.getPos().west()).getBlock();
		 Block UpBlock  = this.getWorld().getBlockState(this.getPos().up()).getBlock();
		 Block DownBlock  = this.getWorld().getBlockState(this.getPos().down()).getBlock();
		 if(this.getDirection() == 2){
				if(this.getWorld().getBlockState(this.getPos().east()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().east());
				}
				if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().west());
				}
				if(this.getWorld().getBlockState(this.getPos().south()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().south());
				}
				if(this.getWorld().getBlockState(this.getPos().up()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().up());
				}
				if(this.getWorld().getBlockState(this.getPos().down()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().down());
				}		
			}
		 	else if(this.getDirection() == 3){
				if(this.getWorld().getBlockState(this.getPos().east()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().east());
				}
				if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().west());
				}
				if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().north());
				}
				if(this.getWorld().getBlockState(this.getPos().up()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().up());
				}
				if(this.getWorld().getBlockState(this.getPos().down()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().down());
				}
			}
		 	else if(this.getDirection() == 4){
				if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().north());
				}
				if(this.getWorld().getBlockState(this.getPos().south()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().south());
				}
				if(this.getWorld().getBlockState(this.getPos().east()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().east());
				}
				if(this.getWorld().getBlockState(this.getPos().up()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().up());
				}
				if(this.getWorld().getBlockState(this.getPos().down()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().down());
				}
			}
		 	else if(this.getDirection() == 5){
				if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().north());
				}
				if(this.getWorld().getBlockState(this.getPos().south()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().south());
				}
				if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().west());
				}
				if(this.getWorld().getBlockState(this.getPos().up()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().up());
				}
				if(this.getWorld().getBlockState(this.getPos().down()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().down());
				}
			}
		 
		 for(int i = 0; i < NetworkList.size(); i++){
			 BlockPos myCurrentPos = NetworkList.get(i);
			  
			 	if(this.getWorld().getBlockState(myCurrentPos.north()).getBlock() == NetworkBlock && !NetworkList.contains(myCurrentPos.north())){
					NetworkList.add(myCurrentPos.north());
				}
				if(this.getWorld().getBlockState(myCurrentPos.south()).getBlock() == NetworkBlock && !NetworkList.contains(myCurrentPos.south())){
					NetworkList.add(myCurrentPos.south());
				}
				if(this.getWorld().getBlockState(myCurrentPos.west()).getBlock() == NetworkBlock && !NetworkList.contains(myCurrentPos.west())){
					NetworkList.add(myCurrentPos.west());
				}
				if(this.getWorld().getBlockState(myCurrentPos.east()).getBlock() == NetworkBlock && !NetworkList.contains(myCurrentPos.east())){
					NetworkList.add(myCurrentPos.east());
				}
				if(this.getWorld().getBlockState(myCurrentPos.up()).getBlock() == NetworkBlock && !NetworkList.contains(myCurrentPos.up())){
					NetworkList.add(myCurrentPos.up());
				}
				if(this.getWorld().getBlockState(myCurrentPos.down()).getBlock() == NetworkBlock && !NetworkList.contains(myCurrentPos.down())){
					NetworkList.add(myCurrentPos.down());
				}
		 }
		 
		 for(int i = 0; i < NetworkList.size(); i++){
			 BlockPos myCurrentPos = NetworkList.get(i);
			 
			 NorthBlock  = this.getWorld().getBlockState(myCurrentPos.north()).getBlock();
			 SouthBlock = this.getWorld().getBlockState(myCurrentPos.south()).getBlock();
			 EastBlock = this.getWorld().getBlockState(myCurrentPos.east()).getBlock();
			 WestBlock  = this.getWorld().getBlockState(myCurrentPos.west()).getBlock();
			 UpBlock  = this.getWorld().getBlockState(myCurrentPos.up()).getBlock();
			 DownBlock  = this.getWorld().getBlockState(myCurrentPos.down()).getBlock();
			 
			 	if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(NorthBlock, getWorld(), myCurrentPos.north()) && !ExistingChestList.contains(myCurrentPos.north()) && !ChestList.contains(myCurrentPos.north())){
					ChestList.add(myCurrentPos.north());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(SouthBlock, getWorld(), myCurrentPos.south()) && !ExistingChestList.contains(myCurrentPos.south()) && !ChestList.contains(myCurrentPos.south())){
					ChestList.add(myCurrentPos.south());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(WestBlock, getWorld(), myCurrentPos.west()) && !ExistingChestList.contains(myCurrentPos.west()) && !ChestList.contains(myCurrentPos.west())){
					ChestList.add(myCurrentPos.west());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(EastBlock, getWorld(), myCurrentPos.east()) && !ExistingChestList.contains(myCurrentPos.east()) && !ChestList.contains(myCurrentPos.east())){
					ChestList.add(myCurrentPos.east());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(UpBlock, getWorld(), myCurrentPos.up()) && !ExistingChestList.contains(myCurrentPos.up()) && !ChestList.contains(myCurrentPos.up())){
					ChestList.add(myCurrentPos.up());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(DownBlock, getWorld(), myCurrentPos.down()) && !ExistingChestList.contains(myCurrentPos.down()) && !ChestList.contains(myCurrentPos.down())){
					ChestList.add(myCurrentPos.down());
				}
		 }
		 ChestList.addAll(ExistingChestList);
		return ChestList;
	 }
	 
	public boolean beganEnergyDrainFromNetwork(int mode){
		boolean EnergyRequestSuccessful = false;
		int EnergyRequired = getLeyRequirementPerTick(mode);
		
		ArrayList<BlockPos> myPowerList = getPowerPosList();
		
		for(int i = 0; i < myPowerList.size() && EnergyRequestSuccessful == false; i++){
			 ILeyPoweredEntity myEntity = (ILeyPoweredEntity) this.getWorld().getTileEntity(myPowerList.get(i));
			 if(myEntity.canRequestLeyAmount(EnergyRequired)){
				 myEntity.drainLeyEnergy(EnergyRequired);
				 EnergyRequestSuccessful = true;
			 }
		}
		
		return EnergyRequestSuccessful;
	}
	
	@Override
	public boolean hasLeyStorage() {
		return false;
	}

	@Override
	public boolean canRequestLeyAmount(int amount) {
		return false;
	}

	@Override
	public void drainLeyEnergy(int amount) {
		
	}

	public int getLeyRequirementPerTick(int mode){
		int myEnergyCost = getBaseEnergyCost();
		
		myEnergyCost += getModeEnergyCost(mode);
		
		myEnergyCost += getEnergyCostOfEnhancers();
		
		return myEnergyCost;
	}
	
	public int getBaseEnergyCost(){
		return 4;
	}
	
	public int getModeEnergyCost(int myMode){
		if(myMode == 0){
			return 2;
		}else if(myMode == 1){
			return 4;
		}else if(myMode == 2){
			return 4;
		}else if(myMode == 3){
			return 4;
		}else if(myMode == 4){
			return 8;
		}else if(myMode == 5){
			return 4;
		}else if(myMode == 6){
			return 4;
		}else if(myMode == 7){
			return 12;
		}else if(myMode == 8){
			return 6;
		}else if(myMode == 9){
			return 4;
		}else if(myMode == 10){
			return 24;
		}else if(myMode == 11){
			return 12;
		}else if(myMode == 12){
			return 48;
		}
		return 0;
	}
	
	public int getEnergyCostOfEnhancers(){
		int myCost = 0;
		
		if(this.getDirection() == 2){
			myCost += getEnergyCostForEnhancer(getWorld().getBlockState(this.getPos().south()).getBlock());
			myCost += getEnergyCostForEnhancer(getWorld().getBlockState(this.getPos().east()).getBlock());
			myCost += getEnergyCostForEnhancer(getWorld().getBlockState(this.getPos().west()).getBlock());
		}
		//Facing South
		else if(this.getDirection() == 3){
			myCost += getEnergyCostForEnhancer(getWorld().getBlockState(this.getPos().north()).getBlock());
			myCost += getEnergyCostForEnhancer(getWorld().getBlockState(this.getPos().east()).getBlock());
			myCost += getEnergyCostForEnhancer(getWorld().getBlockState(this.getPos().west()).getBlock());
		
		}
		//Facing West
		else if(this.getDirection() == 4){
			myCost += getEnergyCostForEnhancer(getWorld().getBlockState(this.getPos().south()).getBlock());
			myCost += getEnergyCostForEnhancer(getWorld().getBlockState(this.getPos().east()).getBlock());
			myCost += getEnergyCostForEnhancer(getWorld().getBlockState(this.getPos().north()).getBlock());
		
		}
		//Facing East
		else if(this.getDirection() == 5){
			myCost += getEnergyCostForEnhancer(getWorld().getBlockState(this.getPos().south()).getBlock());
			myCost += getEnergyCostForEnhancer(getWorld().getBlockState(this.getPos().north()).getBlock());
			myCost += getEnergyCostForEnhancer(getWorld().getBlockState(this.getPos().west()).getBlock());
		
		}
		
		return myCost;
	}

	public int getEnergyCostForEnhancer(Block myBlock){
		if(myBlock == CookingPlusMain.blockGoldenRangeBlock){
			return 8;
		}
		if(myBlock == CookingPlusMain.blockGoldenSpeedBlock){
			return 8;
		}
		if(myBlock == CookingPlusMain.blockRangeBlock){
			return 4;
		}
		if(myBlock == CookingPlusMain.blockSpeedBlock){
			return 4;
		}
		if(myBlock == CookingPlusMain.blockDiamondSpeedBlock){
			return 12;
		}
		if(myBlock == CookingPlusMain.blockDiamondSpeedBlock){
			return 12;
		}
		return 0;
	}
	
	@Override
	public int getmaxStorageAmount() {
		return 0;
	}

	@Override
	public int getCurrentStorageAmount() {
		return 0;
	}

	@Override
	public int transfertEnergyToStorage(int amount) {
		return amount;
	}
}
