package CookingPlus.tiles;

import java.util.List;

import CookingPlus.CookingPlusLootHelper;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomCrops;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
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
		inv = new ItemStack[1];
		EntityDirection = 0;
		myFace = 2;
		prevFace = 2;
		timer = 0;
		myEntityType = 0;
		HarvestTimer = 0;
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
		prevFace = myFace;
		HarvestTimer++;
		
		if(hasChest()){
			if(hasWorkable()){
				if(HarvestTimer > 30){
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
		 HydrophonicTileEntity myEntity = (HydrophonicTileEntity)this.getWorld().getTileEntity(myPos);
		 if(myEntity.getCurrentCrop() == null){
			 TileEntityChest myChest = (TileEntityChest) this.getWorld().getTileEntity(getChestPos());
			 boolean done = false;
			 for(int i = 0; i < 27 && done == false; i++){
				 if(myChest.getStackInSlot(i) != null){
					 if(HydrophonicTileEntity.isItemAcceptableInput(myChest.getStackInSlot(i).getItem())){
						 myEntity.processAutoActivate(myChest.getStackInSlot(i).getItem());
						 if(myChest.getStackInSlot(i).stackSize > 1){
							 myChest.setInventorySlotContents(i, new ItemStack(myChest.getStackInSlot(i).getItem(), myChest.getStackInSlot(i).stackSize - 1));
						 }
						 else{
							 myChest.setInventorySlotContents(i, null);
						 }
						 done = true;
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
							 TileEntityChest myChest = (TileEntityChest) this.getWorld().getTileEntity(getChestPos());
							 ItemStack TempStack = CookingPlusLootHelper.instance().PutItemStackInChest(myChest, myStack);
							 if(TempStack != null){
								 Block.spawnAsEntity(this.getWorld(), pos, TempStack);
								 SetFace(2);
								 ChestProblems = true;
							 }
							 else{
								 ChestProblems = false;
							 }
						 }
				 
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
							 TileEntityChest myChest = (TileEntityChest) this.getWorld().getTileEntity(getChestPos());
							 ItemStack TempStack = CookingPlusLootHelper.instance().PutItemStackInChest(myChest, myStack);
							 if(TempStack != null){
								 Block.spawnAsEntity(this.getWorld(), pos, TempStack);
								 SetFace(2);
								 ChestProblems = true;
							 }
							 else{
								 ChestProblems = false;
							 }
						 }
						
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

	
}
