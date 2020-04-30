package CookingPlus.compat.jei.Oven;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import CookingPlus.recipes.CookingPlusOvenRecipes;
import CookingPlus.recipes.CookingPlusSheetPressRecipes;
import CookingPlus.recipes.OvenBaseRecipe;
import CookingPlus.recipes.SheetPressBaseRecipe;
import CookingPlus.tiles.BrickOvenTileEntity;


public class OvenRecipeMaker {

	private OvenRecipeMaker() {
	}
	
	public static List<OvenRecipeWrapper> getOvenRecipes() {
		BrickOvenTileEntity myTempOven = new BrickOvenTileEntity();
		List<OvenRecipeWrapper> recipes = new ArrayList();
		for (int i = 0; i < CookingPlusOvenRecipes.instance().recipeList.size(); i += 2) {
			List<ItemStack> mySingleRecipe = new ArrayList();
			mySingleRecipe.add(CookingPlusOvenRecipes.instance().recipeList.get(i));
			mySingleRecipe.add(CookingPlusOvenRecipes.instance().recipeList.get(i + 1));
			mySingleRecipe.add(myTempOven.GetReplaceItem(CookingPlusOvenRecipes.instance().recipeList.get(i)));
			recipes.add(new OvenRecipeWrapper(new OvenBaseRecipe(mySingleRecipe)));
		}
		return recipes;
	}
	
}