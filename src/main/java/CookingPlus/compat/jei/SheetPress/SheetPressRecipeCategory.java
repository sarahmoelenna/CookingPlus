package CookingPlus.compat.jei.SheetPress;

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

public class SheetPressRecipeCategory implements IRecipeCategory<SheetPressRecipeWrapper> {

	public static final String UID = "cookingplus.sheetpress";
	private final IDrawableStatic background;
	private final String localizedName;
	
	private static final int topSlot = 0;
	private static final int bottomSlot = 1;
	private static final int outputSlot = 3;
	
	public SheetPressRecipeCategory(IGuiHelper guiHelper) {
		ResourceLocation location = new ResourceLocation("agriculturalrevolution", "textures/gui/jeisheetpressgui.png");
		background = guiHelper.createDrawable(location, 0, 0, 64, 64, 0, 0, 0, 0);
		localizedName = I18n.format("cookingplus.jei.sheetpress");
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
	public void setRecipe(IRecipeLayout recipeLayout,SheetPressRecipeWrapper recipeWrapper) {
		// TODO Auto-generated method stub
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
		
		guiItemStacks.init(topSlot, true, 8, 2);
		guiItemStacks.init(bottomSlot, true, 8, 45);
		guiItemStacks.init(outputSlot, false, 40, 23);
	
		guiItemStacks.setFromRecipe(topSlot, recipeWrapper.getInputs().get(bottomSlot));
		guiItemStacks.setFromRecipe(bottomSlot, recipeWrapper.getInputs().get(topSlot));
		guiItemStacks.setFromRecipe(outputSlot, recipeWrapper.getOutputs());
	}

}
