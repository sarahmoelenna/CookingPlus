package CookingPlus.compat.jei;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;
import CookingPlus.CookingPlusMain;
import CookingPlus.compat.jei.ButterChurn.ButterChurnRecipeCategory;
import CookingPlus.compat.jei.ButterChurn.ButterChurnRecipeHandler;
import CookingPlus.compat.jei.ButterChurn.ButterChurnRecipeMaker;
import CookingPlus.compat.jei.DryingRack.DryingRackRecipeCategory;
import CookingPlus.compat.jei.DryingRack.DryingRackRecipeHandler;
import CookingPlus.compat.jei.DryingRack.DryingRackRecipeMaker;
import CookingPlus.compat.jei.Fermenter.FermenterRecipeCategory;
import CookingPlus.compat.jei.Fermenter.FermenterRecipeHandler;
import CookingPlus.compat.jei.Fermenter.FermenterRecipeMaker;
import CookingPlus.compat.jei.FishBreed.FishBreedRecipeCategory;
import CookingPlus.compat.jei.FishBreed.FishBreedRecipeHandler;
import CookingPlus.compat.jei.FishBreed.FishBreedRecipeMaker;
import CookingPlus.compat.jei.FishHatch.FishHatchRecipeCategory;
import CookingPlus.compat.jei.FishHatch.FishHatchRecipeHandler;
import CookingPlus.compat.jei.FishHatch.FishHatchRecipeMaker;
import CookingPlus.compat.jei.FryingPan.FryingPanRecipeCategory;
import CookingPlus.compat.jei.FryingPan.FryingPanRecipeHandler;
import CookingPlus.compat.jei.FryingPan.FryingPanRecipeMaker;
import CookingPlus.compat.jei.IceBox.IceBoxRecipeCategory;
import CookingPlus.compat.jei.IceBox.IceBoxRecipeHandler;
import CookingPlus.compat.jei.IceBox.IceBoxRecipeMaker;
import CookingPlus.compat.jei.Inscription.InscriptionRecipeCategory;
import CookingPlus.compat.jei.Inscription.InscriptionRecipeHandler;
import CookingPlus.compat.jei.Inscription.InscriptionRecipeMaker;
import CookingPlus.compat.jei.MutationStation.JEIMutationStationRecipeHandler;
import CookingPlus.compat.jei.MutationStation.MutationStationRecipeCategory;
import CookingPlus.compat.jei.MutationStation.MutationStationRecipeMaker;
import CookingPlus.compat.jei.OilPress.OilPressRecipeCategory;
import CookingPlus.compat.jei.OilPress.OilPressRecipeHandler;
import CookingPlus.compat.jei.OilPress.OilPressRecipeMaker;
import CookingPlus.compat.jei.Oven.OvenRecipeCategory;
import CookingPlus.compat.jei.Oven.OvenRecipeHandler;
import CookingPlus.compat.jei.Oven.OvenRecipeMaker;
import CookingPlus.compat.jei.SaucePan.SaucePanRecipeCategory;
import CookingPlus.compat.jei.SaucePan.SaucePanRecipeHandler;
import CookingPlus.compat.jei.SaucePan.SaucePanRecipeMaker;
import CookingPlus.compat.jei.SheetPress.SheetPressRecipeCategory;
import CookingPlus.compat.jei.SheetPress.SheetPressRecipeHandler;
import CookingPlus.compat.jei.SheetPress.SheetPressRecipeMaker;
import CookingPlus.compat.jei.Teapot.TeapotRecipeCategory;
import CookingPlus.compat.jei.Teapot.TeapotRecipeHandler;
import CookingPlus.compat.jei.Teapot.TeapotRecipeMaker;
import CookingPlus.recipes.CookingPlusSheetPressRecipes;
import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;

@JEIPlugin
public class CookingPlusJEIPlugin extends BlankModPlugin {
	@Override
	public void register(@Nonnull IModRegistry registry) {
		IJeiHelpers jeiHelpers = registry.getJeiHelpers();

		registry.addRecipeCategories(
				new SheetPressRecipeCategory(jeiHelpers.getGuiHelper()),
				new TeapotRecipeCategory(jeiHelpers.getGuiHelper()),
				new IceBoxRecipeCategory(jeiHelpers.getGuiHelper()),
				new OvenRecipeCategory(jeiHelpers.getGuiHelper()),
				new ButterChurnRecipeCategory(jeiHelpers.getGuiHelper()),
				new OilPressRecipeCategory(jeiHelpers.getGuiHelper()),
				new FermenterRecipeCategory(jeiHelpers.getGuiHelper()),
				new FryingPanRecipeCategory(jeiHelpers.getGuiHelper()),
				new SaucePanRecipeCategory(jeiHelpers.getGuiHelper()),
				new MutationStationRecipeCategory(jeiHelpers.getGuiHelper()),
				new FishBreedRecipeCategory(jeiHelpers.getGuiHelper()),
				new FishHatchRecipeCategory(jeiHelpers.getGuiHelper()),
				new DryingRackRecipeCategory(jeiHelpers.getGuiHelper()),
				new InscriptionRecipeCategory(jeiHelpers.getGuiHelper())
		);
		
		registry.addRecipeHandlers(
				new SheetPressRecipeHandler(),
				new DryingRackRecipeHandler(),
				new IceBoxRecipeHandler(),
				new OvenRecipeHandler(),
				new ButterChurnRecipeHandler(),
				new OilPressRecipeHandler(),
				new FermenterRecipeHandler(),
				new FryingPanRecipeHandler(),
				new SaucePanRecipeHandler(),
				new FishBreedRecipeHandler(),
				new FishHatchRecipeHandler(),
				new JEIMutationStationRecipeHandler(),
				new InscriptionRecipeHandler(),
				new TeapotRecipeHandler()
		);
		
		
		registry.addRecipes(SheetPressRecipeMaker.getSheetPressRecipes());
		registry.addRecipes(TeapotRecipeMaker.getTeapotRecipes());
		registry.addRecipes(DryingRackRecipeMaker.getDryingRackRecipes());
		registry.addRecipes(IceBoxRecipeMaker.getIceBoxRecipes());
		registry.addRecipes(OvenRecipeMaker.getOvenRecipes());
		registry.addRecipes(ButterChurnRecipeMaker.getButterChurnRecipes());
		registry.addRecipes(OilPressRecipeMaker.getOilPressRecipes());
		registry.addRecipes(FermenterRecipeMaker.getFermenterRecipes());
		registry.addRecipes(FryingPanRecipeMaker.getFryingPanRecipes());
		registry.addRecipes(SaucePanRecipeMaker.getSaucePanRecipes());
		registry.addRecipes(FishBreedRecipeMaker.getFishBreedRecipes());
		registry.addRecipes(FishHatchRecipeMaker.getFishHatchRecipes());
		registry.addRecipes(MutationStationRecipeMaker.getMutationStationRecipes());
		registry.addRecipes(InscriptionRecipeMaker.getInscriptionRecipes());
		
		registry.addRecipeCategoryCraftingItem(new ItemStack(CookingPlusMain.blockSheetPress), SheetPressRecipeCategory.UID);
		registry.addRecipeCategoryCraftingItem(new ItemStack(CookingPlusMain.blockTeapot), TeapotRecipeCategory.UID);
		registry.addRecipeCategoryCraftingItem(new ItemStack(CookingPlusMain.blockDryingRack), DryingRackRecipeCategory.UID);
		registry.addRecipeCategoryCraftingItem(new ItemStack(CookingPlusMain.blockIceBox), IceBoxRecipeCategory.UID);
		registry.addRecipeCategoryCraftingItem(new ItemStack(CookingPlusMain.blockBrickOven), OvenRecipeCategory.UID);
		registry.addRecipeCategoryCraftingItem(new ItemStack(CookingPlusMain.blockOilPress), OilPressRecipeCategory.UID);
		registry.addRecipeCategoryCraftingItem(new ItemStack(CookingPlusMain.blockButterChurn), ButterChurnRecipeCategory.UID);
		registry.addRecipeCategoryCraftingItem(new ItemStack(CookingPlusMain.blockFermenter), FermenterRecipeCategory.UID);
		registry.addRecipeCategoryCraftingItem(new ItemStack(CookingPlusMain.blockFryingPan), FryingPanRecipeCategory.UID);
		registry.addRecipeCategoryCraftingItem(new ItemStack(CookingPlusMain.blockSaucePan), SaucePanRecipeCategory.UID);
		registry.addRecipeCategoryCraftingItem(new ItemStack(CookingPlusMain.blockMutationStation), MutationStationRecipeCategory.UID);
		registry.addRecipeCategoryCraftingItem(new ItemStack(CookingPlusMain.blockFishTank), FishBreedRecipeCategory.UID);
		registry.addRecipeCategoryCraftingItem(new ItemStack(CookingPlusMain.blockFishTank), FishHatchRecipeCategory.UID);
		registry.addRecipeCategoryCraftingItem(new ItemStack(CookingPlusMain.blockInscriber), InscriptionRecipeCategory.UID);
		
	}
}
