package CookingPlus.compat.jei.SheetPress;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import CookingPlus.recipes.CookingPlusSheetPressRecipes;
import CookingPlus.recipes.SheetPressBaseRecipe;


public class SheetPressRecipeMaker {

	private SheetPressRecipeMaker() {
	}
	
	public static List<SheetPressRecipeWrapper> getSheetPressRecipes() {
		List<SheetPressRecipeWrapper> recipes = new ArrayList();
		for (int i = 0; i < CookingPlusSheetPressRecipes.instance().recipeList.size(); i += 3) {
			List<ItemStack> mySingleRecipe = new ArrayList();
			mySingleRecipe.add(CookingPlusSheetPressRecipes.instance().recipeList.get(i));
			mySingleRecipe.add(CookingPlusSheetPressRecipes.instance().recipeList.get(i + 1));
			mySingleRecipe.add(CookingPlusSheetPressRecipes.instance().recipeList.get(i + 2));
			recipes.add(new SheetPressRecipeWrapper(new SheetPressBaseRecipe(mySingleRecipe)));
		}
		return recipes;
	}
	
}