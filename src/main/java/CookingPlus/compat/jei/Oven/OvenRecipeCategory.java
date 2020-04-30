package CookingPlus.compat.jei.Oven;

import javax.annotation.Nonnull;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;

public class OvenRecipeCategory implements IRecipeCategory<OvenRecipeWrapper> {

	public static final String UID = "cookingplus.brickoven";
	private final IDrawableStatic background;
	private final String localizedName;
	
	private static final int inputSlot = 0;
	private static final int outputSlot = 1;
	private static final int outputSlotB = 2;
	
	public OvenRecipeCategory(IGuiHelper guiHelper) {
		ResourceLocation location = new ResourceLocation("agriculturalrevolution", "textures/gui/jeibrickovengui.png");
		background = guiHelper.createDrawable(location, 0, 0, 64, 64, 0, 0, 0, 0);
		localizedName = I18n.format("cookingplus.jei.brickoven");
	}
	
	@Override
	public String getUid() {
		return UID;
	}

	@Override
	public String getTitle() {
		return localizedName;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public void drawExtras(Minecraft minecraft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawAnimations(Minecraft minecraft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout,OvenRecipeWrapper recipeWrapper) {
		// TODO Auto-generated method stub
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
		
		guiItemStacks.init(inputSlot, true, 3, 21);
		guiItemStacks.init(outputSlot, false, 44, 11);
		guiItemStacks.init(outputSlotB, false, 44, 31);
	
		guiItemStacks.setFromRecipe(inputSlot, recipeWrapper.getInputs());
		guiItemStacks.setFromRecipe(outputSlot, recipeWrapper.getOutputs().get(0));
		guiItemStacks.setFromRecipe(outputSlotB, recipeWrapper.getOutputs().get(1));
	}

}
