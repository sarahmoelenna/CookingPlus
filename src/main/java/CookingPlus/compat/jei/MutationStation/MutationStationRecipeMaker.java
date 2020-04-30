package CookingPlus.compat.jei.MutationStation;

import java.util.ArrayList;
import java.util.List;

import CookingPlus.recipes.MutationStationBaseRecipe;
import CookingPlus.recipes.MutationStationRecipeHandler;
import net.minecraft.item.ItemStack;


public class MutationStationRecipeMaker {

	private MutationStationRecipeMaker() {
	}
	
	public static List<MutationStationRecipeWrapper> getMutationStationRecipes() {
		List<MutationStationRecipeWrapper> recipes = new ArrayList();
		for (int i = 0; i < MutationStationRecipeHandler.instance().seedTierList.size(); i++) {
			List<ItemStack> mySingleRecipe = MutationStationRecipeHandler.instance().seedTierList.get(i).getListForJEI();
			recipes.add(new MutationStationRecipeWrapper(new MutationStationBaseRecipe(mySingleRecipe)));
		}
		return recipes;
	}
	
}