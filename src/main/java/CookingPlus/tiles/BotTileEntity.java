package CookingPlus.tiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import CookingPlus.CookingPlusConfig;
import CookingPlus.CookingPlusLootHelper;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomCrops;
import CookingPlus.blocks.CookingPlusCustomGrowingBush;
import CookingPlus.blocks.CookingPlusCustomRopeCrop;
import CookingPlus.blocks.CookingPlusCustomSpreadingCoral;
import CookingPlus.blocks.CookingPlusCustomSpreadingHerb;
import CookingPlus.blocks.CookingPlusCustomUnderwaterCrop;
import CookingPlus.blocks.bushes.CookingPlusPlainBush;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
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
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BotTileEntity extends TileEntity implements IInventory, IUpdatePlayerListBox {

	private ItemStack[] inv;
	private int EntityDirection;
	private int myFace;
	private int timer;
	private int myEntityType;
	private int HarvestTimer;
	private int prevFace;
	private boolean ChestProblems;
	
	public BotTileEntity() {
		Random TempRand = new Random();
		inv = new ItemStack[1];
		EntityDirection = 0;
		myFace = 2;
		prevFace = 2;
		timer = 0;
		myEntityType = 0;
		HarvestTimer = TempRand.nextInt(30);
		ChestProblems = false;
	}
	
	public void setDirection(int Direction) {
		EntityDirection = Direction;
		//System.out.println(EntityDirection  + " set");
	}

	public int getDirection() {
		//System.out.println(EntityDirection + " get");
		return EntityDirection;
	}

	@Override
    public void update(){
		int myMode = GetMode();
		if(myMode == 0){
			DefaultMode();
		}
		else if(myMode == 1){
			PickerMode();
		}
		else if(myMode == 2){
			FisherMode();
		}
		else if(myMode == 3){
			GatherMode();
		}
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
		if(oldState.getBlock().equals(CookingPlusMain.blockBot) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockBot) == false){
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
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		
		NBTTagList nbttaglist = new NBTTagList();
		
		nbt.setInteger("MyDirection", EntityDirection);
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
			UpdateBlock();
			}
		}
	 
	 public void UpdateBlock(){
			this.worldObj.markBlockForUpdate(this.getPos());
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
				if(this.getWorld().getBlockState(this.getPos().south()).getBlock() == Blocks.chest){
					return true;
				}
			}
			else if(this.getDirection() == 3){
				if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == Blocks.chest){
					return true;
				}
			}
			else if(this.getDirection() == 4){
				if(this.getWorld().getBlockState(this.getPos().east()).getBlock() == Blocks.chest){
					return true;
				}
			}
			else if(this.getDirection() == 5){
				if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == Blocks.chest){
					return true;
				}
			}
			
			return false;
	}
	 
	 public boolean hasTopChest(){
		 if(this.getWorld().getBlockState(this.getPos().up()).getBlock() == Blocks.chest){
				return true;
		}
		return false;
	 }
	 
	 public boolean hasSideChest(){
			
			if(this.getDirection() == 2){
				if(this.getWorld().getBlockState(this.getPos().east()).getBlock() == Blocks.chest){
					return true;
				}
				if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == Blocks.chest){
					return true;
				}
			}
			else if(this.getDirection() == 3){
				if(this.getWorld().getBlockState(this.getPos().east()).getBlock() == Blocks.chest){
					return true;
				}
				if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == Blocks.chest){
					return true;
				}
			}
			else if(this.getDirection() == 4){
				if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == Blocks.chest){
					return true;
				}
				if(this.getWorld().getBlockState(this.getPos().south()).getBlock() == Blocks.chest){
					return true;
				}
			}
			else if(this.getDirection() == 5){
				if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == Blocks.chest){
					return true;
				}
				if(this.getWorld().getBlockState(this.getPos().south()).getBlock() == Blocks.chest){
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
			 	for(int i = 0; i < 27 && done == false; i++){
			 		TileEntityChest myChest = (TileEntityChest) this.getWorld().getTileEntity(ChestList.get(c));
					 if(myChest.getStackInSlot(i) != null){
						 if(HydrophonicTileEntity.isItemAcceptableInput(myChest.getStackInSlot(i).getItem())){
							 myEntity.processAutoActivate(myChest.getStackInSlot(i).getItem());
							 if(((TileEntityChest) (this.getWorld().getTileEntity(ChestList.get(c)))).getStackInSlot(i).stackSize > 1){
								 ((TileEntityChest) (this.getWorld().getTileEntity(ChestList.get(c)))).setInventorySlotContents(i, new ItemStack(myChest.getStackInSlot(i).getItem(), myChest.getStackInSlot(i).stackSize - 1));
							 }
							 else{
								 ((TileEntityChest) (this.getWorld().getTileEntity(ChestList.get(c)))).setInventorySlotContents(i, null);
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
							 	if(HydrophonicTileEntity.isItemAcceptableInput(myStack.getItem())){
								 	--myStack.stackSize;
								 	inv[0] = new ItemStack(myStack.getItem(), 1);
								 	SearchDone = true;
							 	}
						 	}
						 }
						 DepositItemStackListIntoChestList(myItemList);
				 
				 }
					else if(myBlock == Blocks.wheat || myBlock == Blocks.potatoes || myBlock == Blocks.carrots){
						List<ItemStack> myItemList = myEntity.getCurrentCrop().getDrops(this.getWorld(), this.getPos(), myBlock.getDefaultState().withProperty(BlockCrops.AGE, 7), 0);
						
						 boolean SearchDone = false;
						 for(ItemStack myStack : myItemList){
							 if(!SearchDone){
							 	if(HydrophonicTileEntity.isItemAcceptableInput(myStack.getItem())){
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
		 if(this.getWorld().getBlockState(getPos().down().north()).getBlock() != Blocks.air){
			 if(isGatherableBlock(this.getWorld().getBlockState(getPos().down().north()).getBlock())){
				 WorkPos = getPos().down().north();
			 }
		 }
		 if(this.getWorld().getBlockState(getPos().down().south()).getBlock() != Blocks.air){
			 if(isGatherableBlock(this.getWorld().getBlockState(getPos().down().south()).getBlock())){
				 WorkPos = getPos().down().south();
			 }
		 }
		 if(this.getWorld().getBlockState(getPos().down().east()).getBlock() != Blocks.air){
			 if(isGatherableBlock(this.getWorld().getBlockState(getPos().down().east()).getBlock())){
				 WorkPos = getPos().down().east();
			 }
		 }
		 if(this.getWorld().getBlockState(getPos().down().west()).getBlock() != Blocks.air){
			 if(isGatherableBlock(this.getWorld().getBlockState(getPos().down().west()).getBlock())){
				 WorkPos = getPos().down().west();
			 }
		 }
		 
		 if(WorkPos != null){
			 if(GetDropList(WorkPos).size() > 0){
				 DepositItemStackListIntoChestList(GetDropList(WorkPos));
				 if(this.getWorld().getBlockState(WorkPos.up()).getBlock() == Blocks.water){
					 this.getWorld().setBlockState(WorkPos, Blocks.water.getDefaultState());
				 }
				 else{
					 this.getWorld().setBlockState(WorkPos, Blocks.air.getDefaultState());
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
			 	if(this.getWorld().getBlockState(myCurrentPos.north()).getBlock() == Blocks.chest && !ExistingChestList.contains(myCurrentPos.north()) && !ChestList.contains(myCurrentPos.north())){
					ChestList.add(myCurrentPos.north());
				}
				if(this.getWorld().getBlockState(myCurrentPos.south()).getBlock() == Blocks.chest && !ExistingChestList.contains(myCurrentPos.south()) && !ChestList.contains(myCurrentPos.south())){
					ChestList.add(myCurrentPos.south());
				}
				if(this.getWorld().getBlockState(myCurrentPos.west()).getBlock() == Blocks.chest && !ExistingChestList.contains(myCurrentPos.west()) && !ChestList.contains(myCurrentPos.west())){
					ChestList.add(myCurrentPos.west());
				}
				if(this.getWorld().getBlockState(myCurrentPos.east()).getBlock() == Blocks.chest && !ExistingChestList.contains(myCurrentPos.east()) && !ChestList.contains(myCurrentPos.east())){
					ChestList.add(myCurrentPos.east());
				}
				if(this.getWorld().getBlockState(myCurrentPos.up()).getBlock() == Blocks.chest && !ExistingChestList.contains(myCurrentPos.up()) && !ChestList.contains(myCurrentPos.up())){
					ChestList.add(myCurrentPos.up());
				}
				if(this.getWorld().getBlockState(myCurrentPos.down()).getBlock() == Blocks.chest && !ExistingChestList.contains(myCurrentPos.down()) && !ChestList.contains(myCurrentPos.down())){
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
		 if(this.getDirection() == 2){
				if(this.getWorld().getBlockState(this.getPos().east()).getBlock() == Blocks.chest){
					PosList.add(this.getPos().east());
				}
				if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == Blocks.chest){
					PosList.add(this.getPos().west());
				}
				if(this.getWorld().getBlockState(this.getPos().south()).getBlock() == Blocks.chest){
					PosList.add(this.getPos().south());
				}
				if(this.getWorld().getBlockState(this.getPos().up()).getBlock() == Blocks.chest){
					PosList.add(this.getPos().up());
				}
				if(this.getWorld().getBlockState(this.getPos().down()).getBlock() == Blocks.chest){
					PosList.add(this.getPos().down());
				}		
			}
			else if(this.getDirection() == 3){
				if(this.getWorld().getBlockState(this.getPos().east()).getBlock() == Blocks.chest){
					PosList.add(this.getPos().east());
				}
				if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == Blocks.chest){
					PosList.add(this.getPos().west());
				}
				if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == Blocks.chest){
					PosList.add(this.getPos().north());
				}
				if(this.getWorld().getBlockState(this.getPos().up()).getBlock() == Blocks.chest){
					PosList.add(this.getPos().up());
				}
				if(this.getWorld().getBlockState(this.getPos().down()).getBlock() == Blocks.chest){
					PosList.add(this.getPos().down());
				}
				
			}
			else if(this.getDirection() == 4){
				if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == Blocks.chest){
					PosList.add(this.getPos().north());
				}
				if(this.getWorld().getBlockState(this.getPos().south()).getBlock() == Blocks.chest){
					PosList.add(this.getPos().south());
				}
				if(this.getWorld().getBlockState(this.getPos().east()).getBlock() == Blocks.chest){
					PosList.add(this.getPos().east());
				}
				if(this.getWorld().getBlockState(this.getPos().up()).getBlock() == Blocks.chest){
					PosList.add(this.getPos().up());
				}
				if(this.getWorld().getBlockState(this.getPos().down()).getBlock() == Blocks.chest){
					PosList.add(this.getPos().down());
				}
			}
			else if(this.getDirection() == 5){
				if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == Blocks.chest){
					PosList.add(this.getPos().north());
				}
				if(this.getWorld().getBlockState(this.getPos().south()).getBlock() == Blocks.chest){
					PosList.add(this.getPos().south());
				}
				if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == Blocks.chest){
					PosList.add(this.getPos().west());
				}
				if(this.getWorld().getBlockState(this.getPos().up()).getBlock() == Blocks.chest){
					PosList.add(this.getPos().up());
				}
				if(this.getWorld().getBlockState(this.getPos().down()).getBlock() == Blocks.chest){
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
				if(this.getWorld().getBlockState(this.getPos().south()).getBlock() == Blocks.chest){
					return this.getPos().south();
				}
			}
			else if(this.getDirection() == 3){
				if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == Blocks.chest){
					return this.getPos().north();
				}
			}
			else if(this.getDirection() == 4){
				if(this.getWorld().getBlockState(this.getPos().east()).getBlock() == Blocks.chest){
					return this.getPos().east();
				}
			}
			else if(this.getDirection() == 5){
				if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == Blocks.chest){
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
			playerIn.addChatMessage(new ChatComponentTranslation("msg.botchest.txt"));
		}
		else if(myFace == 1){
			playerIn.addChatMessage(new ChatComponentTranslation("msg.botwork.txt"));
		}
		else if(myFace == 0){
			playerIn.addChatMessage(new ChatComponentTranslation("msg.botgood.txt"));
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
		else return 0;
	}
	
	public void DefaultMode(){
		prevFace = myFace;
		HarvestTimer++;
		if(GetChestPosList().size() > 0){
			if(hasWorkable()){
				if(HarvestTimer > CookingPlusConfig.HHBHarvestRate){
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
			UpdateBlock();
		}
	}
	
	public void PickerMode(){
		prevFace = myFace;
		HarvestTimer++;
		
		if(GetChestPosList().size() > 0){
			if(hasWorkableVines()){
				if(HarvestTimer > CookingPlusConfig.HHBPickRate){
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
			UpdateBlock();
		}
	}

	public void FisherMode(){
		prevFace = myFace;
		HarvestTimer++;
		
		if(GetChestPosList().size() > 0){
			if(this.getWorld().getBlockState(getPos().down()).getBlock() == CookingPlusMain.blockFisher){
				if(HarvestTimer > CookingPlusConfig.HHBPickRate){
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
			UpdateBlock();
		}
	}

	public void GatherMode(){
		prevFace = myFace;
		HarvestTimer++;
		
		if(GetChestPosList().size() > 0){
			if(this.getWorld().getBlockState(getPos().down()).getBlock() == CookingPlusMain.blockGatherer){
				if(HarvestTimer > CookingPlusConfig.HHBGatherRate){
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
			UpdateBlock();
		}
	}
}
