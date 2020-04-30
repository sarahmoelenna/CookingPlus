package CookingPlus.compat.jei.FishHatch;

import java.util.ArrayList;
import java.util.List;

import CookingPlus.CookingPlusMain;
import CookingPlus.recipes.CookingPlusBaseRecipe;
import CookingPlus.recipes.CookingPlusSheetPressRecipes;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import mezz.jei.api.recipe.IRecipeWrapper;

public class FishHatchRecipeWrapper implements IRecipeWrapper {

	private final List input;
	private final List output;
	
	public FishHatchRecipeWrapper(CookingPlusBaseRecipe recipe) {
		
		
		input = new ArrayList<ItemStack>();
		output = new ArrayList<ItemStack>();
		for(int i = 0; i < recipe.myRecipe.size(); i++){
			if(i < recipe.myRecipe.size() - 1){
				output.add(recipe.myRecipe.get(i));
			}
			else{
				input.add(recipe.myRecipe.get(i));
			}
		}
		
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
