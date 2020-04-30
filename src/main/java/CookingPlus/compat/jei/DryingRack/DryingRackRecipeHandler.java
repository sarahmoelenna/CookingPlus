package CookingPlus.compat.jei.DryingRack;

import CookingPlus.recipes.CookingPlusBaseRecipe;
import CookingPlus.recipes.CookingPlusSheetPressRecipes;
import CookingPlus.recipes.SheetPressBaseRecipe;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class DryingRackRecipeHandler implements IRecipeHandler<DryingRackRecipeWrapper> {

	@Override
	public Class<DryingRackRecipeWrapper> getRecipeClass() {
		return DryingRackRecipeWrapper.class;
	}

	@Override
	public String getRecipeCategoryUid() {
		return "cookingplus.dryingrack";
	}

	@Override
	public String getRecipeCategoryUid(DryingRackRecipeWrapper recipe) {
		return getRecipeCategoryUid();
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(DryingRackRecipeWrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(DryingRackRecipeWrapper recipe) {
		//System.out.println(recipe.getInputs().size() > 0);
		return recipe.getInputs().size() > 0;
	}

}
