package CookingPlus.compat.jei.OilPress;

import CookingPlus.recipes.CookingPlusBaseRecipe;
import CookingPlus.recipes.CookingPlusSheetPressRecipes;
import CookingPlus.recipes.SheetPressBaseRecipe;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class OilPressRecipeHandler implements IRecipeHandler<OilPressRecipeWrapper> {

	@Override
	public Class<OilPressRecipeWrapper> getRecipeClass() {
		return OilPressRecipeWrapper.class;
	}

	@Override
	public String getRecipeCategoryUid() {
		return "cookingplus.oilpress";
	}

	@Override
	public String getRecipeCategoryUid(OilPressRecipeWrapper recipe) {
		return getRecipeCategoryUid();
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(OilPressRecipeWrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(OilPressRecipeWrapper recipe) {
		//System.out.println(recipe.getInputs().size() > 0);
		return recipe.getInputs().size() > 0;
	}

}
