package CookingPlus.compat.jei.DryingRack;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import CookingPlus.recipes.CookingPlusDryingRackRecipe;
import CookingPlus.recipes.CookingPlusSheetPressRecipes;
import CookingPlus.recipes.DryingRackBaseRecipe;
import CookingPlus.recipes.SheetPressBaseRecipe;


public class DryingRackRecipeMaker {

	private DryingRackRecipeMaker() {
	}
	
	public static List<DryingRackRecipeWrapper> getDryingRackRecipes() {
		List<DryingRackRecipeWrapper> recipes = new ArrayList();
		for (int i = 0; i < CookingPlusDryingRackRecipe.instance().recipeList.size(); i += 2) {
			List<ItemStack> mySingleRecipe = new ArrayList();
			mySingleRecipe.add(CookingPlusDryingRackRecipe.instance().recipeList.get(i));
			mySingleRecipe.add(CookingPlusDryingRackRecipe.instance().recipeList.get(i + 1));
			recipes.add(new DryingRackRecipeWrapper(new DryingRackBaseRecipe(mySingleRecipe)));
		}
		return recipes;
	}
	
}