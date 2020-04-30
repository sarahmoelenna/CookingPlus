package CookingPlus.compat.jei.Fermenter;

import CookingPlus.recipes.CookingPlusBaseRecipe;
import CookingPlus.recipes.CookingPlusSheetPressRecipes;
import CookingPlus.recipes.SheetPressBaseRecipe;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class FermenterRecipeHandler implements IRecipeHandler<FermenterRecipeWrapper> {

	@Override
	public Class<FermenterRecipeWrapper> getRecipeClass() {
		return FermenterRecipeWrapper.class;
	}

	@Override
	public String getRecipeCategoryUid() {
		return "cookingplus.fermenter";
	}

	@Override
	public String getRecipeCategoryUid(FermenterRecipeWrapper recipe) {
		return getRecipeCategoryUid();
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(FermenterRecipeWrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(FermenterRecipeWrapper recipe) {
		//System.out.println(recipe.getInputs().size() > 0);
		return recipe.getInputs().size() > 0;
	}

}
