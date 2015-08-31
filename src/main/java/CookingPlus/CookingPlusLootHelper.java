package CookingPlus;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.item.Item;
import CookingPlus.recipes.CookingPlusDryingRackRecipe;

public class CookingPlusLootHelper {

	 private static final CookingPlusLootHelper LootHelper = new CookingPlusLootHelper();
	 private final ArrayList<Item> PotteryGuideList = new ArrayList<Item>();
	 private final ArrayList<Item> PotteryGuideCommonList = new ArrayList<Item>();
	 private final ArrayList<Item> PotteryGuideRareList = new ArrayList<Item>();
	
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
	
	public Item GetRandomCommonGuide(Random myRand){
		int which = myRand.nextInt(PotteryGuideCommonList.size());
		return PotteryGuideCommonList.get(which);
	}
	
	public Item GetRandomRareGuide(Random myRand){
		int which = myRand.nextInt(PotteryGuideRareList.size());
		return PotteryGuideRareList.get(which);
	}
	
	public Item GetRandomGuide(Random myRand){
		int which = myRand.nextInt(PotteryGuideList.size());
		return PotteryGuideList.get(which);
	}
	
}
