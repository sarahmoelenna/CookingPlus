package CookingPlus.compat.jei.Oven;

import CookingPlus.recipes.CookingPlusBaseRecipe;
import CookingPlus.recipes.CookingPlusSheetPressRecipes;
import CookingPlus.recipes.SheetPressBaseRecipe;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class OvenRecipeHandler implements IRecipeHandler<OvenRecipeWrapper> {

	@Override
	public Class<OvenRecipeWrapper> getRecipeClass() {
		return OvenRecipeWrapper.class;
	}

	@Override
	public String getRecipeCategoryUid() {
		return "cookingplus.brickoven";
	}

	@Override
	public String getRecipeCategoryUid(OvenRecipeWrapper recipe) {
		return getRecipeCategoryUid();
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(OvenRecipeWrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(OvenRecipeWrapper recipe) {
		//System.out.println(recipe.getInputs().size() > 0);
		return recipe.getInputs().size() > 0;
	}

}
