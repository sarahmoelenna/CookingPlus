package CookingPlus.compat.jei.FryingPan;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import CookingPlus.CookingPlusMain;
import CookingPlus.recipes.CookingPlusFryingPanRecipes;
import CookingPlus.recipes.FryingPanBaseRecipe;


public class FryingPanRecipeMaker {

	private FryingPanRecipeMaker() {
	}
	
	public static List<FryingPanRecipeWrapper> getFryingPanRecipes() {
		List<FryingPanRecipeWrapper> recipes = new ArrayList();
		for (int i = 0; i < CookingPlusFryingPanRecipes.instance().recipeList.size(); i += 2) {
			List<ItemStack> mySingleRecipe = new ArrayList();
			mySingleRecipe.add(new ItemStack(CookingPlusMain.vegetableoil));
			mySingleRecipe.add(CookingPlusFryingPanRecipes.instance().recipeList.get(i));
			mySingleRecipe.add(CookingPlusFryingPanRecipes.instance().recipeList.get(i + 1));
			recipes.add(new FryingPanRecipeWrapper(new FryingPanBaseRecipe(mySingleRecipe)));
		}
		return recipes;
	}
	
}