package CookingPlus.compat.jei.Teapot;

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

public class TeapotRecipeCategory implements IRecipeCategory<TeapotRecipeWrapper> {

	public static final String UID = "cookingplus.teapot";
	private final IDrawableStatic background;
	private final String localizedName;
	
	private static final int waterSlot = 0;
	private static final int inputSlotA = 1;
	private static final int inputSlotB = 2;
	private static final int inputSlotC = 3;
	private static final int outputSlot = 4;
	
	public TeapotRecipeCategory(IGuiHelper guiHelper) {
		ResourceLocation location = new ResourceLocation("agriculturalrevolution", "textures/gui/jeiteapotgui.png");
		background = guiHelper.createDrawable(location, 0, 0, 106, 76, 0, 0, 0, 0);
		localizedName = I18n.format("cookingplus.jei.teapot");
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
	public void setRecipe(IRecipeLayout recipeLayout,TeapotRecipeWrapper recipeWrapper) {
		// TODO Auto-generated method stub
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
		
		guiItemStacks.init(waterSlot, true, 5, 34);
		guiItemStacks.init(inputSlotA, true, 5, 55);
		guiItemStacks.init(inputSlotB, true, 23, 55);
		guiItemStacks.init(inputSlotC, true, 41, 55);
		guiItemStacks.init(outputSlot, false, 82, 34);
	
		guiItemStacks.setFromRecipe(waterSlot, recipeWrapper.getInputs().get(waterSlot));
		guiItemStacks.setFromRecipe(inputSlotA, recipeWrapper.getInputs().get(inputSlotA));
		guiItemStacks.setFromRecipe(inputSlotB, recipeWrapper.getInputs().get(inputSlotB));
		guiItemStacks.setFromRecipe(inputSlotC, recipeWrapper.getInputs().get(inputSlotC));
		guiItemStacks.setFromRecipe(outputSlot, recipeWrapper.getOutputs());
	}

}
