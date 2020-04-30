package CookingPlus.compat.jei.SaucePan;

import CookingPlus.recipes.CookingPlusBaseRecipe;
import CookingPlus.recipes.CookingPlusSaucePanRecipe;
import CookingPlus.recipes.SaucePanBaseRecipe;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class SaucePanRecipeHandler implements IRecipeHandler<SaucePanRecipeWrapper> {

	@Override
	public Class<SaucePanRecipeWrapper> getRecipeClass() {
		return SaucePanRecipeWrapper.class;
	}

	@Override
	public String getRecipeCategoryUid() {
		return "cookingplus.saucepan";
	}

	@Override
	public String getRecipeCategoryUid(SaucePanRecipeWrapper recipe) {
		return getRecipeCategoryUid();
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(SaucePanRecipeWrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(SaucePanRecipeWrapper recipe) {
		//System.out.println(recipe.getInputs().size() > 0);
		return recipe.getInputs().size() > 0;
	}

}
