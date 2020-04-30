package CookingPlus.compat.jei.FishBreed;

import CookingPlus.recipes.CookingPlusBaseRecipe;
import CookingPlus.recipes.CookingPlusSheetPressRecipes;
import CookingPlus.recipes.SheetPressBaseRecipe;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class FishBreedRecipeHandler implements IRecipeHandler<FishBreedRecipeWrapper> {

	@Override
	public Class<FishBreedRecipeWrapper> getRecipeClass() {
		return FishBreedRecipeWrapper.class;
	}

	@Override 
	public String getRecipeCategoryUid() {
		return "cookingplus.fishbreed";
	}

	@Override
	public String getRecipeCategoryUid(FishBreedRecipeWrapper recipe) {
		return getRecipeCategoryUid();
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(FishBreedRecipeWrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(FishBreedRecipeWrapper recipe) {
		//System.out.println(recipe.getInputs().size() > 0);
		return recipe.getInputs().size() > 0;
	}

}
