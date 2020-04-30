package CookingPlus.compat.jei.FishHatch;

import java.util.ArrayList;
import java.util.List;

import CookingPlus.CookingPlusMain;
import CookingPlus.recipes.FishHatchBaseRecipe;
import CookingPlus.recipes.MutationStationRecipeHandler;
import net.minecraft.item.ItemStack;


public class FishHatchRecipeMaker {

	private FishHatchRecipeMaker() {
	}
	
	public static List<FishHatchRecipeWrapper> getFishHatchRecipes() {
		List<FishHatchRecipeWrapper> recipes = new ArrayList();
		for (int i = 0; i < MutationStationRecipeHandler.instance().fishEggList.size(); i ++) {
			List<ItemStack> mySingleRecipe = new ArrayList();
			mySingleRecipe.add(new ItemStack(MutationStationRecipeHandler.instance().fishEggList.get(i).getFish()));
			mySingleRecipe.add(new ItemStack(MutationStationRecipeHandler.instance().fishEggList.get(i).getEgg()));
			recipes.add(new FishHatchRecipeWrapper(new FishHatchBaseRecipe(mySingleRecipe)));
		}
		
		//Mutation Eggs
		//one
		List<ItemStack> mySingleRecipe = new ArrayList();
		for (int i = 0; i < MutationStationRecipeHandler.instance().TierOneFishList.size(); i++){
			mySingleRecipe.add(new ItemStack(MutationStationRecipeHandler.instance().TierOneFishList.get(i)));
		}
		mySingleRecipe.add(new ItemStack(CookingPlusMain.onemutantfishegg));
		recipes.add(new FishHatchRecipeWrapper(new FishHatchBaseRecipe(mySingleRecipe)));
		//two
		mySingleRecipe = new ArrayList();
		for (int i = 0; i < MutationStationRecipeHandler.instance().TierTwoFishList.size(); i++){
			mySingleRecipe.add(new ItemStack(MutationStationRecipeHandler.instance().TierTwoFishList.get(i)));
		}
		mySingleRecipe.add(new ItemStack(CookingPlusMain.twomutantfishegg));
		recipes.add(new FishHatchRecipeWrapper(new FishHatchBaseRecipe(mySingleRecipe)));
		//three
		mySingleRecipe = new ArrayList();
		for (int i = 0; i < MutationStationRecipeHandler.instance().TierThreeFishList.size(); i++){
			mySingleRecipe.add(new ItemStack(MutationStationRecipeHandler.instance().TierThreeFishList.get(i)));
		}
		mySingleRecipe.add(new ItemStack(CookingPlusMain.threemutantfishegg));
		recipes.add(new FishHatchRecipeWrapper(new FishHatchBaseRecipe(mySingleRecipe)));
		//four
		mySingleRecipe = new ArrayList();
		for (int i = 0; i < MutationStationRecipeHandler.instance().TierFourFishList.size(); i++){
			mySingleRecipe.add(new ItemStack(MutationStationRecipeHandler.instance().TierFourFishList.get(i)));
		}
		mySingleRecipe.add(new ItemStack(CookingPlusMain.fourmutantfishegg));
		recipes.add(new FishHatchRecipeWrapper(new FishHatchBaseRecipe(mySingleRecipe)));
		//five
		mySingleRecipe = new ArrayList();
		for (int i = 0; i < MutationStationRecipeHandler.instance().TierFiveFishList.size(); i++){
			mySingleRecipe.add(new ItemStack(MutationStationRecipeHandler.instance().TierFiveFishList.get(i)));
		}
		mySingleRecipe.add(new ItemStack(CookingPlusMain.fivemutantfishegg));
		recipes.add(new FishHatchRecipeWrapper(new FishHatchBaseRecipe(mySingleRecipe)));
		
		return recipes;
	}
	
}