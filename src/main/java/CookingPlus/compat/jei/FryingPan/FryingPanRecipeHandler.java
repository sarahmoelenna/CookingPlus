package CookingPlus.compat.jei.FryingPan;

import CookingPlus.recipes.CookingPlusBaseRecipe;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class FryingPanRecipeHandler implements IRecipeHandler<FryingPanRecipeWrapper> {

	@Override
	public Class<FryingPanRecipeWrapper> getRecipeClass() {
		return FryingPanRecipeWrapper.class;
	}

	@Override
	public String getRecipeCategoryUid() {
		return "cookingplus.fryingpan";
	}

	@Override
	public String getRecipeCategoryUid(FryingPanRecipeWrapper recipe) {
		return getRecipeCategoryUid();
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(FryingPanRecipeWrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(FryingPanRecipeWrapper recipe) {
		//System.out.println(recipe.getInputs().size() > 0);
		return recipe.getInputs().size() > 0;
	}

}
