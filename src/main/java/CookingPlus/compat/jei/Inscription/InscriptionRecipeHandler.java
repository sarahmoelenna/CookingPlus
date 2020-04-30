package CookingPlus.compat.jei.Inscription;

import CookingPlus.recipes.CookingPlusBaseRecipe;
import CookingPlus.recipes.CookingPlusSheetPressRecipes;
import CookingPlus.recipes.SheetPressBaseRecipe;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

public class InscriptionRecipeHandler implements IRecipeHandler<InscriptionRecipeWrapper> {

	@Override
	public Class<InscriptionRecipeWrapper> getRecipeClass() {
		return InscriptionRecipeWrapper.class;
	}

	@Override
	public String getRecipeCategoryUid() {
		return "cookingplus.inscription";
	}

	@Override
	public String getRecipeCategoryUid(InscriptionRecipeWrapper recipe) {
		return getRecipeCategoryUid();
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(InscriptionRecipeWrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(InscriptionRecipeWrapper recipe) {
		//System.out.println(recipe.getInputs().size() > 0);
		return recipe.getInputs().size() > 0;
	}

}
