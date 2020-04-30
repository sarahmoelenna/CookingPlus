package CookingPlus.compat.jei.SaucePan;

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

public class SaucePanRecipeCategory implements IRecipeCategory<SaucePanRecipeWrapper> {

	public static final String UID = "cookingplus.saucepan";
	private final IDrawableStatic background;
	private final String localizedName;
	
	private static final int topSlot = 0;
	private static final int bottomSlot = 1;
	private static final int outputSlot = 3;
	
	public SaucePanRecipeCategory(IGuiHelper guiHelper) {
		ResourceLocation location = new ResourceLocation("agriculturalrevolution", "textures/gui/jeifrysaucegui.png");
		background = guiHelper.createDrawable(location, 0, 0, 83, 77, 0, 0, 0, 0);
		localizedName = I18n.format("cookingplus.jei.saucepan");
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
	public void setRecipe(IRecipeLayout recipeLayout,SaucePanRecipeWrapper recipeWrapper) {
		// TODO Auto-generated method stub
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
		
		guiItemStacks.init(topSlot, true, 6, 33);
		guiItemStacks.init(bottomSlot, true, 6, 54);
		guiItemStacks.init(outputSlot, false, 54, 44);
	
		guiItemStacks.setFromRecipe(topSlot, recipeWrapper.getInputs().get(topSlot));
		guiItemStacks.setFromRecipe(bottomSlot, recipeWrapper.getInputs().get(bottomSlot));
		guiItemStacks.setFromRecipe(outputSlot, recipeWrapper.getOutputs());
	}

}
