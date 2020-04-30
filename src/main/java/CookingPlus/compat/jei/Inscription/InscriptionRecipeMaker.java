package CookingPlus.compat.jei.Inscription;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import CookingPlus.recipes.InscriptionBaseRecipe;
import CookingPlus.recipes.InscriptionRecipeHelper;


public class InscriptionRecipeMaker {

	private InscriptionRecipeMaker() {
	}
	
	public static List<InscriptionRecipeWrapper> getInscriptionRecipes() {
		List<InscriptionRecipeWrapper> recipes = new ArrayList();
		for (int i = 0; i < InscriptionRecipeHelper.instance().recipeList.size(); i += 2) {
			List<ItemStack> mySingleRecipe = new ArrayList();
			mySingleRecipe.add(InscriptionRecipeHelper.instance().recipeList.get(i));
			mySingleRecipe.add(InscriptionRecipeHelper.instance().recipeList.get(i + 1));
			recipes.add(new InscriptionRecipeWrapper(new InscriptionBaseRecipe(mySingleRecipe)));
		}
		return recipes;
	}
	
}