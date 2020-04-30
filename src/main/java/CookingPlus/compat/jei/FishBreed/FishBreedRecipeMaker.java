package CookingPlus.compat.jei.FishBreed;

import java.util.ArrayList;
import java.util.List;

import CookingPlus.compat.jei.IceBox.IceBoxRecipeWrapper;
import CookingPlus.recipes.CookingPlusIceBoxRecipes;
import CookingPlus.recipes.FishBreedBaseRecipe;
import CookingPlus.recipes.IceBoxBaseRecipe;
import CookingPlus.recipes.MutationStationRecipeHandler;
import net.minecraft.item.ItemStack;


public class FishBreedRecipeMaker {

	private FishBreedRecipeMaker() {
	}
	
	public static List<FishBreedRecipeWrapper> getFishBreedRecipes() {
		List<FishBreedRecipeWrapper> recipes = new ArrayList();
		for (int i = 0; i < MutationStationRecipeHandler.instance().fishEggList.size(); i ++) {
			List<ItemStack> mySingleRecipe = new ArrayList();
			mySingleRecipe.add(new ItemStack(MutationStationRecipeHandler.instance().fishEggList.get(i).getFish()));
			mySingleRecipe.add(new ItemStack(MutationStationRecipeHandler.instance().fishEggList.get(i).getEgg()));
			recipes.add(new FishBreedRecipeWrapper(new FishBreedBaseRecipe(mySingleRecipe)));
		}
		return recipes;
	}
	
}