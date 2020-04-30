package CookingPlus.compat.jei.Teapot;

import CookingPlus.recipes.CookingPlusBaseRecipe;
import CookingPlus.recipes.CookingPlusSheetPressRecipes;
import CookingPlus.recipes.SheetPressBaseRecipe;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class TeapotRecipeHandler implements IRecipeHandler<TeapotRecipeWrapper> {

	@Override
	public Class<TeapotRecipeWrapper> getRecipeClass() {
		return TeapotRecipeWrapper.class;
	}

	@Override
	public String getRecipeCategoryUid() {
		return "cookingplus.teapot";
	}

	@Override
	public String getRecipeCategoryUid(TeapotRecipeWrapper recipe) {
		return getRecipeCategoryUid();
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(TeapotRecipeWrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(TeapotRecipeWrapper recipe) {
		//System.out.println(recipe.getInputs().size() > 0);
		return recipe.getInputs().size() > 0;
	}

}
