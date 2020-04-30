package CookingPlus.compat.jei.MutationStation;

import CookingPlus.recipes.CookingPlusBaseRecipe;
import CookingPlus.recipes.CookingPlusSheetPressRecipes;
import CookingPlus.recipes.SheetPressBaseRecipe;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class JEIMutationStationRecipeHandler implements IRecipeHandler<MutationStationRecipeWrapper> {

	@Override
	public Class<MutationStationRecipeWrapper> getRecipeClass() {
		return MutationStationRecipeWrapper.class;
	}

	@Override
	public String getRecipeCategoryUid() {
		return "cookingplus.mutationstation";
	}

	@Override
	public String getRecipeCategoryUid(MutationStationRecipeWrapper recipe) {
		return getRecipeCategoryUid();
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(MutationStationRecipeWrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(MutationStationRecipeWrapper recipe) {
		return recipe.getInputs().size() > 0;
	}

}
