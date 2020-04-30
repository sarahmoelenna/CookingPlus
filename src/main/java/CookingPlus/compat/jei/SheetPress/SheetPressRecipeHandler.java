package CookingPlus.compat.jei.SheetPress;

import CookingPlus.recipes.CookingPlusBaseRecipe;
import CookingPlus.recipes.CookingPlusSheetPressRecipes;
import CookingPlus.recipes.SheetPressBaseRecipe;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class SheetPressRecipeHandler implements IRecipeHandler<SheetPressRecipeWrapper> {

	@Override
	public Class<SheetPressRecipeWrapper> getRecipeClass() {
		return SheetPressRecipeWrapper.class;
	}

	@Override
	public String getRecipeCategoryUid() {
		return "cookingplus.sheetpress";
	}

	@Override
	public String getRecipeCategoryUid(SheetPressRecipeWrapper recipe) {
		return getRecipeCategoryUid();
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(SheetPressRecipeWrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(SheetPressRecipeWrapper recipe) {
		//System.out.println(recipe.getInputs().size() > 0);
		return recipe.getInputs().size() > 0;
	}

}
