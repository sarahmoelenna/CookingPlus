package CookingPlus.compat.jei.IceBox;

import java.util.ArrayList;
import java.util.List;

import CookingPlus.recipes.CookingPlusIceBoxRecipes;
import CookingPlus.recipes.IceBoxBaseRecipe;
import net.minecraft.item.ItemStack;


public class IceBoxRecipeMaker {

	private IceBoxRecipeMaker() {
	}
	
	public static List<IceBoxRecipeWrapper> getIceBoxRecipes() {
		List<IceBoxRecipeWrapper> recipes = new ArrayList();
		for (int i = 0; i < CookingPlusIceBoxRecipes.instance().recipeList.size(); i += 2) {
			List<ItemStack> mySingleRecipe = new ArrayList();
			mySingleRecipe.add(CookingPlusIceBoxRecipes.instance().recipeList.get(i));
			mySingleRecipe.add(CookingPlusIceBoxRecipes.instance().recipeList.get(i + 1));
			recipes.add(new IceBoxRecipeWrapper(new IceBoxBaseRecipe(mySingleRecipe)));
		}
		return recipes;
	}
	
}