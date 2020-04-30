package CookingPlus.compat.jei.ButterChurn;

import CookingPlus.recipes.CookingPlusBaseRecipe;
import CookingPlus.recipes.CookingPlusSheetPressRecipes;
import CookingPlus.recipes.SheetPressBaseRecipe;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class ButterChurnRecipeHandler implements IRecipeHandler<ButterChurnRecipeWrapper> {

	@Override
	public Class<ButterChurnRecipeWrapper> getRecipeClass() {
		return ButterChurnRecipeWrapper.class;
	}

	@Override
	public String getRecipeCategoryUid() {
		return "cookingplus.butterchurn";
	}

	@Override
	public String getRecipeCategoryUid(ButterChurnRecipeWrapper recipe) {
		return getRecipeCategoryUid();
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(ButterChurnRecipeWrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(ButterChurnRecipeWrapper recipe) {
		//System.out.println(recipe.getInputs().size() > 0);
		return recipe.getInputs().size() > 0;
	}

}
