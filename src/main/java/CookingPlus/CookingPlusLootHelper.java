package CookingPlus;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityLockable;

public class CookingPlusLootHelper {

	 private static final CookingPlusLootHelper LootHelper = new CookingPlusLootHelper();
	 private final ArrayList<Item> PotteryGuideList = new ArrayList<Item>();
	 private final ArrayList<Item> GenericLootItemList = new ArrayList<Item>();
	 private final ArrayList<Item> PotteryGuideCommonList = new ArrayList<Item>();
	 private final ArrayList<Item> PotteryGuideRareList = new ArrayList<Item>();
	 private final ArrayList<Item> FisherList = new ArrayList<Item>();
	 private final ArrayList<Item> FisherRareList = new ArrayList<Item>();
	 private final ArrayList<Item> SeedList = new ArrayList<Item>();
	 
	 public final ArrayList<String> whiteListedHydrohonicUnlocalisedName = new ArrayList();
	 public final ArrayList<String> whiteListedHydrohonicOreDictionary = new ArrayList();
	
	public static CookingPlusLootHelper instance()
    {
        return LootHelper;
    }

	
	public void CookingPlusLootHelperInit()
    {
		ArrayList<Item> PotteryGuideList = new ArrayList<Item>();
		ArrayList<Item> PotteryGuideCommonList = new ArrayList<Item>();
		ArrayList<Item> PotteryGuideRareList = new ArrayList<Item>();
    }
	
	public void AddPotteryGuide(Item myGuide, boolean isRare){
		if(isRare){
			PotteryGuideRareList.add(myGuide);
		}
		else{
			PotteryGuideCommonList.add(myGuide);
		}
		PotteryGuideList.add(myGuide);
	}
	
	public void AddSeed(Item myGuide){
		SeedList.add(myGuide);
	}
	
	
	public void AddGenericItem(Item myGuide){
		GenericLootItemList.add(myGuide);
	}
	
	public void AddFish(Item myItem, boolean Rarity)
	{
		if(Rarity == false){
			FisherList.add(myItem);
		}
		else{
			FisherRareList.add(myItem);
		}
	}
	
	public Item GetRandomCommonGuide(Random myRand){
		int which = myRand.nextInt(PotteryGuideCommonList.size());
		return PotteryGuideCommonList.get(which);
	}
	
	public Item GetRandomGenericItem(Random myRand){
		int which = myRand.nextInt(GenericLootItemList.size());
		return GenericLootItemList.get(which);
	}
	
	public Item GetRandomSeed(Random myRand){
		int which = myRand.nextInt(SeedList.size());
		return SeedList.get(which);
	}
	
	public Item GetRandomRareGuide(Random myRand){
		int which = myRand.nextInt(PotteryGuideRareList.size());
		return PotteryGuideRareList.get(which);
	}
	
	public Item GetRandomGuide(Random myRand){
		int which = myRand.nextInt(PotteryGuideList.size());
		return PotteryGuideList.get(which);
	}
	
	public Item GetRandomFish(Random myRand){
		if(myRand.nextInt(10) > 1){
			int which = myRand.nextInt(FisherList.size());
			return FisherList.get(which);
		}
		else{
			if(myRand.nextFloat() > 0.995f){
				return Items.LEATHER_BOOTS;
			}
			else{
				int which = myRand.nextInt(FisherRareList.size());
				return FisherRareList.get(which);
			}
		}
	}
	
	public ItemStack GetRandomProcessor(Random myRand){
		int which = myRand.nextInt(10);
		if(which <= 4){
			return new ItemStack(CookingPlusMain.redstoneprocessor, myRand.nextInt(5) + 1);
		}
		else if(which > 4 && which < 8){
			return new ItemStack(CookingPlusMain.ironprocessor, myRand.nextInt(3) + 1);
		}
		else{
			return new ItemStack(CookingPlusMain.diamondprocessor, myRand.nextInt(2) + 1);
		}
	}
	
	public ItemStack PutItemStackInChest(TileEntityLockable myChest, ItemStack myStack){
		boolean done = false;
		 if(myStack.stackSize == 0 || myStack == null){
			 done = true;
		 }
		 for(int i = 0; i < myChest.getSizeInventory() && done == false; i++){
			 if(myChest.getStackInSlot(i) != null && myChest.getStackInSlot(i).getItem() != null){
				 if(myChest.getStackInSlot(i).getItem() == myStack.getItem() && myChest.getStackInSlot(i).getMetadata() == myStack.getMetadata()){
				 	if(myChest.getStackInSlot(i).stackSize < myChest.getStackInSlot(i).getItem().getItemStackLimit() - myStack.stackSize){
					 	myChest.setInventorySlotContents(i, new ItemStack(myStack.getItem(), myChest.getStackInSlot(i).stackSize + myStack.stackSize, myStack.getMetadata()));
					 	done = true;
				 	}
				 	else if(myChest.getStackInSlot(i).stackSize < myChest.getStackInSlot(i).getItem().getItemStackLimit()){
				 		myStack.stackSize -=  (myChest.getStackInSlot(i).getItem().getItemStackLimit() - myChest.getStackInSlot(i).stackSize);
				 		myChest.setInventorySlotContents(i, new ItemStack(myStack.getItem(), myChest.getStackInSlot(i).getItem().getItemStackLimit(), myStack.getMetadata()));
				 		ItemStack TempStack = PutItemStackInChest(myChest, myStack);
				 		if(TempStack == null){
				 			done = true;
				 		}
				 		else{
				 			myStack = TempStack;
				 		}
				 	}
			 	}
			 }
		 }
		 for(int i = 0; i < myChest.getSizeInventory() && done == false; i++){
			 if(myChest.getStackInSlot(i) == null){
				myChest.setInventorySlotContents(i, new ItemStack(myStack.getItem(), myStack.stackSize, myStack.getMetadata()));
				done = true;
			 }
		 }
		 if(done == true){
			 return null;
		 }
		 else{
			 if(myChest instanceof TileEntityChest){
			 if(((TileEntityChest)myChest).adjacentChestXNeg != null && !((TileEntityChest)myChest).adjacentChestXNeg.isInvalid()){
				 ItemStack TempStack = PutItemStackInSecondChest(((TileEntityChest)myChest).adjacentChestXNeg, myStack);
				 if(TempStack != null){
					 myStack = TempStack;
				 }
				 else{
					 return null;
				 }
			 }
			 if(((TileEntityChest)myChest).adjacentChestXPos != null && !((TileEntityChest)myChest).adjacentChestXPos.isInvalid()){
				 ItemStack TempStack = PutItemStackInSecondChest(((TileEntityChest)myChest).adjacentChestXPos, myStack);
				 if(TempStack != null){
					 myStack = TempStack;
				 }
				 else{
					 return null;
				 }
			 }
			 if(((TileEntityChest)myChest).adjacentChestZNeg != null && !((TileEntityChest)myChest).adjacentChestZNeg.isInvalid()){
				 ItemStack TempStack = PutItemStackInSecondChest(((TileEntityChest)myChest).adjacentChestZNeg, myStack);
				 if(TempStack != null){
					 myStack = TempStack;
				 }
				 else{
					 return null;
				 }
			 }
			 if(((TileEntityChest)myChest).adjacentChestZPos != null && !((TileEntityChest)myChest).adjacentChestZPos.isInvalid()){
				 ItemStack TempStack = PutItemStackInSecondChest(((TileEntityChest)myChest).adjacentChestZPos, myStack);
				 if(TempStack != null){
					 myStack = TempStack;
				 }
				 else{
					 return null;
				 }
			 }
			 }
			 
			 return myStack;
		 }
	}
	
	private ItemStack PutItemStackInSecondChest(TileEntityChest myChest, ItemStack myStack){
		boolean done = false;
		 if(myStack.stackSize == 0 || myStack == null){
			 done = true;
		 }
		 for(int i = 0; i < myChest.getSizeInventory() && done == false; i++){
			 if(myChest.getStackInSlot(i) != null && myChest.getStackInSlot(i).getItem() != null){
				 if(myChest.getStackInSlot(i).getItem() == myStack.getItem()){
				 	if(myChest.getStackInSlot(i).stackSize < myChest.getStackInSlot(i).getItem().getItemStackLimit() - myStack.stackSize){
					 	myChest.setInventorySlotContents(i, new ItemStack(myStack.getItem(), myChest.getStackInSlot(i).stackSize + myStack.stackSize));
					 	done = true;
				 	}
				 	else if(myChest.getStackInSlot(i).stackSize < myChest.getStackInSlot(i).getItem().getItemStackLimit()){
				 		myStack.stackSize -=  (myChest.getStackInSlot(i).getItem().getItemStackLimit() - myChest.getStackInSlot(i).stackSize);
				 		myChest.setInventorySlotContents(i, new ItemStack(myStack.getItem(), myChest.getStackInSlot(i).getItem().getItemStackLimit()));
				 		ItemStack TempStack = PutItemStackInChest(myChest, myStack);
				 		if(TempStack == null){
				 			done = true;
				 		}
				 		else{
				 			myStack = TempStack;
				 		}
				 	}
			 	}
			 }
		 }
		 for(int i = 0; i < myChest.getSizeInventory() && done == false; i++){
			 if(myChest.getStackInSlot(i) == null){
				myChest.setInventorySlotContents(i, new ItemStack(myStack.getItem(), myStack.stackSize));
				done = true;
			 }
		 }
		 if(done == true){
			 return null;
		 }
		 else{
			 
			 return myStack;
		 }
	}
	
}
