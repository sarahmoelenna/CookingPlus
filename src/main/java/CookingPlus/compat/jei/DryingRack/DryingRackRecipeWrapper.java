package CookingPlus.compat.jei.DryingRack;

import java.util.ArrayList;
import java.util.List;

import CookingPlus.recipes.CookingPlusBaseRecipe;
import CookingPlus.recipes.CookingPlusSheetPressRecipes;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import mezz.jei.api.recipe.IRecipeWrapper;

public class DryingRackRecipeWrapper implements IRecipeWrapper {

	private final List input;
	private final List output;
	
	public DryingRackRecipeWrapper(CookingPlusBaseRecipe recipe) {
		
		
		input = new ArrayList<ItemStack>();
		output = new ArrayList<ItemStack>();
		input.add(recipe.myRecipe.get(0));
		output.add(recipe.myRecipe.get(1));
		
	}
	
	@Override
	public List getInputs() {
		return input;
	}

	@Override
	public List getOutputs() {
		return output;
	}

	@Override
	public List<FluidStack> getFluidInputs() {
		return null;
	}

	@Override
	public List<FluidStack> getFluidOutputs() {
		return null;
	}

	@Override
	public void drawInfo(Minecraft minecraft, int recipeWidth,int recipeHeight, int mouseX, int mouseY) {
		
	}

	@Override
	public void drawAnimations(Minecraft minecraft, int recipeWidth,int recipeHeight) {
		
	}

	@Override
	public List<String> getTooltipStrings(int mouseX, int mouseY) {
		return null;
	}

	@Override
	public boolean handleClick(Minecraft minecraft, int mouseX, int mouseY,int mouseButton) {
		return false;
	}

}
