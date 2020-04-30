package CookingPlus.compat.jei.SaucePan;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import CookingPlus.recipes.CookingPlusSaucePanRecipe;
import CookingPlus.recipes.SaucePanBaseRecipe;


public class SaucePanRecipeMaker {

	private SaucePanRecipeMaker() {
	}
	
	public static List<SaucePanRecipeWrapper> getSaucePanRecipes() {
		List<SaucePanRecipeWrapper> recipes = new ArrayList();
		for (int i = 0; i < CookingPlusSaucePanRecipe.instance().recipeList.size(); i += 3) {
			List<ItemStack> mySingleRecipe = new ArrayList();
			mySingleRecipe.add(CookingPlusSaucePanRecipe.instance().recipeList.get(i));
			mySingleRecipe.add(CookingPlusSaucePanRecipe.instance().recipeList.get(i + 1));
			mySingleRecipe.add(CookingPlusSaucePanRecipe.instance().recipeList.get(i + 2));
			recipes.add(new SaucePanRecipeWrapper(new SaucePanBaseRecipe(mySingleRecipe)));
		}
		return recipes;
	}
	
}