package CookingPlus.compat.jei.OilPress;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import CookingPlus.CookingPlusMain;
import CookingPlus.recipes.OilPressBaseRecipe;


public class OilPressRecipeMaker {

	private OilPressRecipeMaker() {
	}
	
	public static List<OilPressRecipeWrapper> getOilPressRecipes() {
		List<OilPressRecipeWrapper> recipes = new ArrayList();

		
		List<ItemStack> mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(CookingPlusMain.grapeseed));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.vegetableoil));
		recipes.add(new OilPressRecipeWrapper(new OilPressBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(CookingPlusMain.vanillaseed));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.vegetableoil));
		recipes.add(new OilPressRecipeWrapper(new OilPressBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(CookingPlusMain.leekseeds));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.vegetableoil));
		recipes.add(new OilPressRecipeWrapper(new OilPressBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(CookingPlusMain.coffeeseeds));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.vegetableoil));
		recipes.add(new OilPressRecipeWrapper(new OilPressBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(CookingPlusMain.pricklypearseeds));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.vegetableoil));
		recipes.add(new OilPressRecipeWrapper(new OilPressBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(CookingPlusMain.pineappleseed));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.vegetableoil));
		recipes.add(new OilPressRecipeWrapper(new OilPressBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(CookingPlusMain.chilliseed));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.vegetableoil));
		recipes.add(new OilPressRecipeWrapper(new OilPressBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(CookingPlusMain.onionseed));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.vegetableoil));
		recipes.add(new OilPressRecipeWrapper(new OilPressBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(CookingPlusMain.cottonseed));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.vegetableoil));
		recipes.add(new OilPressRecipeWrapper(new OilPressBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(CookingPlusMain.hopseed));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.vegetableoil));
		recipes.add(new OilPressRecipeWrapper(new OilPressBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(CookingPlusMain.cornseeds));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.vegetableoil));
		recipes.add(new OilPressRecipeWrapper(new OilPressBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(CookingPlusMain.lettuceseeds));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.vegetableoil));
		recipes.add(new OilPressRecipeWrapper(new OilPressBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(CookingPlusMain.riceSeed));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.vegetableoil));
		recipes.add(new OilPressRecipeWrapper(new OilPressBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(CookingPlusMain.teaseed));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.vegetableoil));
		recipes.add(new OilPressRecipeWrapper(new OilPressBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(Items.BEETROOT_SEEDS));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.vegetableoil));
		recipes.add(new OilPressRecipeWrapper(new OilPressBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(Items.PUMPKIN_SEEDS));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.vegetableoil));
		recipes.add(new OilPressRecipeWrapper(new OilPressBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(Items.MELON_SEEDS));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.vegetableoil));
		recipes.add(new OilPressRecipeWrapper(new OilPressBaseRecipe(mySingleRecipe)));
		
		mySingleRecipe = new ArrayList();
		mySingleRecipe.add(new ItemStack(Items.WHEAT_SEEDS));
		mySingleRecipe.add(new ItemStack(CookingPlusMain.vegetableoil));
		recipes.add(new OilPressRecipeWrapper(new OilPressBaseRecipe(mySingleRecipe)));
		
		return recipes;
	}
	
}