package CookingPlus.recipes;

import java.util.List;

import net.minecraft.item.ItemStack;

public class CookingPlusBaseRecipe {

	public List<ItemStack> myRecipe;
	
	public CookingPlusBaseRecipe(List<ItemStack> myRecipeList){
		myRecipe = myRecipeList;
	}
	
}
