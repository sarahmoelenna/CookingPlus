package CookingPlus.compat.jei.IceBox;

import CookingPlus.recipes.CookingPlusBaseRecipe;
import CookingPlus.recipes.CookingPlusSheetPressRecipes;
import CookingPlus.recipes.SheetPressBaseRecipe;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class IceBoxRecipeHandler implements IRecipeHandler<IceBoxRecipeWrapper> {

	@Override
	public Class<IceBoxRecipeWrapper> getRecipeClass() {
		return IceBoxRecipeWrapper.class;
	}

	@Override
	public String getRecipeCategoryUid() {
		return "cookingplus.icebox";
	}

	@Override
	public String getRecipeCategoryUid(IceBoxRecipeWrapper recipe) {
		return getRecipeCategoryUid();
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(IceBoxRecipeWrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(IceBoxRecipeWrapper recipe) {
		//System.out.println(recipe.getInputs().size() > 0);
		return recipe.getInputs().size() > 0;
	}

}
