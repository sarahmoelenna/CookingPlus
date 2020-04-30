package CookingPlus.compat.jei.FishHatch;

import CookingPlus.recipes.CookingPlusBaseRecipe;
import CookingPlus.recipes.CookingPlusSheetPressRecipes;
import CookingPlus.recipes.SheetPressBaseRecipe;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class FishHatchRecipeHandler implements IRecipeHandler<FishHatchRecipeWrapper> {

	@Override
	public Class<FishHatchRecipeWrapper> getRecipeClass() {
		return FishHatchRecipeWrapper.class;
	}

	@Override 
	public String getRecipeCategoryUid() {
		return "cookingplus.fishhatch";
	}

	@Override
	public String getRecipeCategoryUid(FishHatchRecipeWrapper recipe) {
		return getRecipeCategoryUid();
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(FishHatchRecipeWrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(FishHatchRecipeWrapper recipe) {
		//System.out.println(recipe.getInputs().size() > 0);
		return recipe.getInputs().size() > 0;
	}

}
