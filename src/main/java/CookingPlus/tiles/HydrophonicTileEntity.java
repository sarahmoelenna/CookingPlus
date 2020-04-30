package CookingPlus.tiles;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBeetroot;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
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
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import CookingPlus.CookingPlusConfig;
import CookingPlus.CookingPlusLootHelper;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomCrops;
import CookingPlus.blocks.crops.TierFiveMutantCrops;
import CookingPlus.blocks.crops.TierFourMutantCrops;
import CookingPlus.blocks.crops.TierOneMutantCrop;
import CookingPlus.blocks.crops.TierThreeMutantCrops;
import CookingPlus.blocks.crops.TierTwoMutantCrop;
import CookingPlus.recipes.MutationStationRecipeHandler;

public class HydrophonicTileEntity extends CookingPlusCustomTileEntity implements IInventory, ITickable {

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
		int prevAge = myAge;
		if(myAge < 7){
			timer++;
		}
		if(timer > CookingPlusConfig.HydrophonicGrowthRate){
			SetAge(myAge + 1);
			timer = 0;
		}
		
		if(rotation > 360){
			rotation = 0;
		}
		if(this.getWorld().isRemote == false){
			if(myAge != prevAge && myAge == 7){
				ProcessMutantCrops();
			}
		}
	}
	
	public void ProcessMutantCrops(){
		Random myRand = new Random();
		if(myBlock instanceof TierOneMutantCrop){
			if(myRand.nextInt(2) > 0){
				myBlock = MutationStationRecipeHandler.instance().getRandomCrop(1, myRand);
				UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
			}
		}
		if(myBlock instanceof TierTwoMutantCrop){
			if(myRand.nextInt(100) > 45){
				myBlock = MutationStationRecipeHandler.instance().getRandomCrop(2, myRand);
				UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
			}
		}
		if(myBlock instanceof TierThreeMutantCrops){
			if(myRand.nextInt(100) > 40){
				myBlock = MutationStationRecipeHandler.instance().getRandomCrop(3, myRand);
				UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
			}
		}
		if(myBlock instanceof TierFourMutantCrops){
			if(myRand.nextInt(100) > 35){
				myBlock = MutationStationRecipeHandler.instance().getRandomCrop(4, myRand);
				UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
			}
		}
		if(myBlock instanceof TierFiveMutantCrops){
			if(myRand.nextInt(100) > 30){
				myBlock = MutationStationRecipeHandler.instance().getRandomCrop(5, myRand);
				UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
			}
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
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		
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
			UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
			}
		}

	public void processAutoActivate(Item myItem){
				if(myItem != null){
					if(myBlock == null){
					if(myItem instanceof IPlantable){
						if(((IPlantable)myItem).getPlant(null, null) != null){
							Block TempBlock = ((IPlantable)myItem).getPlant(null, null).getBlock();
							if(TempBlock instanceof CookingPlusCustomCrops
									|| TempBlock == Blocks.BEETROOTS 
									|| TempBlock == Blocks.WHEAT 
									|| TempBlock == Blocks.POTATOES 
									|| TempBlock == Blocks.CARROTS
									|| CookingPlusLootHelper.instance().whiteListedHydrohonicUnlocalisedName.contains(myItem.getUnlocalizedName())
									|| CookingPlusLootHelper.instance().whiteListedHydrohonicOreDictionary.contains(OreDictionary.getOreName(myItem.getIdFromItem(myItem)))
									|| SmartInterpretSeed(myItem) == true){
								myBlock = TempBlock;
								UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
								SetAge(0);
							}
						}
					}
					}
				}
				else{
					myBlock = null;
					UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
					SetAge(0);
				}
	}
	 
	 public void processActivate(EntityPlayer playerIn) {
		if(playerIn.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND) != null){
			Item myItem = playerIn.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).getItem();
			
			if(CookingPlusConfig.enableHydrophonicBlockSeedDebug == true){
    			System.out.println("output item unlocalised name " + myItem.getUnlocalizedName());
    			System.out.println("input item ore dictionary name " + OreDictionary.getOreName(myItem.getIdFromItem(myItem)));
    		}
			
			if(myBlock == null){
				//System.out.println(myItem.getUnlocalizedName());
			if(myItem instanceof IPlantable){
				//System.out.println("A");
				if(((IPlantable)myItem).getPlant(null, null) != null){
					//System.out.println("B");
					Block TempBlock = ((IPlantable)myItem).getPlant(null, null).getBlock();
					if(TempBlock instanceof CookingPlusCustomCrops 
							|| TempBlock == Blocks.BEETROOTS 
							|| TempBlock == Blocks.WHEAT 
							|| TempBlock == Blocks.POTATOES 
							|| TempBlock == Blocks.CARROTS
							|| CookingPlusLootHelper.instance().whiteListedHydrohonicUnlocalisedName.contains(myItem.getUnlocalizedName())
							|| CookingPlusLootHelper.instance().whiteListedHydrohonicOreDictionary.contains(OreDictionary.getOreName(myItem.getIdFromItem(myItem)))
							|| SmartInterpretSeed(myItem) == true){
						//System.out.println("C");
						myBlock = TempBlock;
						UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
						SetAge(0);
						
						if(playerIn.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).stackSize > 1){
							playerIn.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(myItem, playerIn.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).stackSize - 1));
						}
						else{
							playerIn.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, null);
						}
					}
				}
			}
			}
		}
		else{
			if(playerIn.isSneaking()){
				if(myBlock instanceof CookingPlusCustomCrops){
					myBlock.dropBlockAsItem(this.getWorld(), playerIn.getPosition(), myBlock.getDefaultState().withProperty(CookingPlusCustomCrops.AGE, myAge), 0);
					myBlock = null;
					UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
					SetAge(0);
				}
				else if(myBlock == Blocks.WHEAT || myBlock == Blocks.POTATOES || myBlock == Blocks.CARROTS  || ((BlockCrops)myBlock).getMaxAge() == 3){
					myBlock.dropBlockAsItem(this.getWorld(), playerIn.getPosition(), myBlock.getDefaultState().withProperty(BlockCrops.AGE, myAge), 0);
					myBlock = null;
					UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
					SetAge(0);
				}else if(myBlock == Blocks.BEETROOTS  || ((BlockCrops)myBlock).getMaxAge() == 3){
					int age = myAge;
					if(age == 0 || age == 1 || age == 2){
						age = 0;
					}
					else if(age == 3 || age == 4){
						age = 1;
					}
					else if(age == 5 || age == 6){
						age = 2;
					}
					else if(age == 7){
						age = 3;
					}
					myBlock.dropBlockAsItem(this.getWorld(), playerIn.getPosition(), myBlock.getDefaultState().withProperty(BlockBeetroot.BEETROOT_AGE, age), 0);
					myBlock = null;
					UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
					SetAge(0);
				}
				else{
					myBlock.dropBlockAsItem(this.getWorld(), playerIn.getPosition(), myBlock.getDefaultState().withProperty(BlockCrops.AGE, myAge), 0);
					myBlock = null;
					UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
					SetAge(0);
				}
			}
		}
		
	}

	 public void SetAge(int newamount){
			if(!this.getWorld().isRemote){
				if(newamount != myAge){
					myAge = newamount;
					UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
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
	
	public boolean isItemAcceptableInput(Item myItem){
		if(myItem != null){
			if(myItem instanceof IPlantable){
				if(((IPlantable)myItem).getPlant(null, null) != null){
					Block TempBlock = ((IPlantable)myItem).getPlant(null, null).getBlock();
					if(TempBlock instanceof CookingPlusCustomCrops 
							|| TempBlock == Blocks.BEETROOTS 
							|| TempBlock == Blocks.WHEAT 
							|| TempBlock == Blocks.POTATOES 
							|| TempBlock == Blocks.CARROTS
							|| CookingPlusLootHelper.instance().whiteListedHydrohonicUnlocalisedName.contains(myItem.getUnlocalizedName())
							|| CookingPlusLootHelper.instance().whiteListedHydrohonicOreDictionary.contains(OreDictionary.getOreName(myItem.getIdFromItem(myItem)))){
						return true;
					}
					if(SmartInterpretSeed(myItem) == true){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean SmartInterpretSeed(Item myItem){
		
		if(CookingPlusConfig.enableAutoDetectSeedEligibilityForHydrophonicBlock == true){
		if(myItem != null){
			if(myItem instanceof IPlantable){
				if(((IPlantable)myItem).getPlant(null, null) != null){
					Block TempBlock = ((IPlantable)myItem).getPlant(null, null).getBlock();
						if(TempBlock instanceof BlockCrops){
							if(((BlockCrops)TempBlock).getMaxAge() == 7){
								if(TempBlock.getDrops(getWorld(), getPos(), TempBlock.getDefaultState().withProperty(BlockCrops.AGE, 7), 0) != null){
									if(TempBlock.getDrops(getWorld(), getPos(), TempBlock.getDefaultState().withProperty(BlockCrops.AGE, 7), 0).size() > 1){
										return true;
									}
								}
							}
							if(((BlockCrops)TempBlock).getMaxAge() == 3){
								if(TempBlock.getDrops(getWorld(), getPos(), TempBlock.getDefaultState().withProperty(BlockBeetroot.BEETROOT_AGE, 3), 0) != null){
									if(TempBlock.getDrops(getWorld(), getPos(), TempBlock.getDefaultState().withProperty(BlockBeetroot.BEETROOT_AGE, 3), 0).size() > 1){
										return true;
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
}
