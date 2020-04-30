package CookingPlus.compat.jei.ButterChurn;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import CookingPlus.CookingPlusMain;
import CookingPlus.recipes.ButterChurnBaseRecipe;


public class ButterChurnRecipeMaker {

	private ButterChurnRecipeMaker() {
	}
	
	public static List<ButterChurnRecipeWrapper> getButterChurnRecipes() {
		List<ButterChurnRecipeWrapper> recipes = new ArrayList();
		
		List<ItemStack> mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(CookingPlusMain.creambucket));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.blockButter));
		recipes.add(new ButterChurnRecipeWrapper(new ButterChurnBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(Items.MILK_BUCKET));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.creambucket));
		recipes.add(new ButterChurnRecipeWrapper(new ButterChurnBaseRecipe(mySingleRecipe)));

		return recipes;
	}
	
}