package CookingPlus.compat.jei.Teapot;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import CookingPlus.CookingPlusMain;
import CookingPlus.compat.jei.SheetPress.SheetPressRecipeWrapper;
import CookingPlus.recipes.CookingPlusSheetPressRecipes;
import CookingPlus.recipes.SheetPressBaseRecipe;
import CookingPlus.recipes.TeapotBaseRecipe;

public class TeapotRecipeMaker {

	private TeapotRecipeMaker() {
	}
	
	public static List<TeapotRecipeWrapper> getTeapotRecipes() {
		List<TeapotRecipeWrapper> recipes = new ArrayList();
		
		List<ItemStack> mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(Items.WATER_BUCKET));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.mug));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.tealeaf));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.chamomileflower));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.chamomiletea));
		recipes.add(new TeapotRecipeWrapper(new TeapotBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(Items.WATER_BUCKET));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.mug));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.tealeaf));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.buchuleaf));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.buchutea));
		recipes.add(new TeapotRecipeWrapper(new TeapotBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(Items.WATER_BUCKET));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.mug));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.tealeaf));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.licoriceleaf));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.licoricetea));
		recipes.add(new TeapotRecipeWrapper(new TeapotBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(Items.WATER_BUCKET));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.mug));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.tealeaf));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.sageleaf));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.sagetea));
		recipes.add(new TeapotRecipeWrapper(new TeapotBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(Items.WATER_BUCKET));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.mug));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.tealeaf));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.rosemaryleaf));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.rosemarytea));
		recipes.add(new TeapotRecipeWrapper(new TeapotBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(Items.WATER_BUCKET));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.mug));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.tealeaf));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.mintleaf));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.minttea));
		recipes.add(new TeapotRecipeWrapper(new TeapotBaseRecipe(mySingleRecipe)));
		
		return recipes;
	}
}
	
