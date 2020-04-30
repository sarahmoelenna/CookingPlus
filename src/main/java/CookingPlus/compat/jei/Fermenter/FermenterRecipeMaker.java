package CookingPlus.compat.jei.Fermenter;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import CookingPlus.CookingPlusMain;
import CookingPlus.recipes.FermenterBaseRecipe;


public class FermenterRecipeMaker {

	private FermenterRecipeMaker() {
	}
	
	public static List<FermenterRecipeWrapper> getFermenterRecipes() {
		List<FermenterRecipeWrapper> recipes = new ArrayList();
		
		List<ItemStack> mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(CookingPlusMain.hops));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.beer));
		recipes.add(new FermenterRecipeWrapper(new FermenterBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(CookingPlusMain.applejuice));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.cider));
		recipes.add(new FermenterRecipeWrapper(new FermenterBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(CookingPlusMain.grapejuice));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.wine));
		recipes.add(new FermenterRecipeWrapper(new FermenterBaseRecipe(mySingleRecipe)));

		return recipes;
	}
	
}