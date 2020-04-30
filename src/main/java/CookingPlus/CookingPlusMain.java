package CookingPlus;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.potion.Potion;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeOcean;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import CookingPlus.Dimension.CookingPlusEdenDimension;
import CookingPlus.blocks.AirCrystalClusterBlock;
import CookingPlus.blocks.CookingPlusBamboo;
import CookingPlus.blocks.CookingPlusBambooBlock;
import CookingPlus.blocks.CookingPlusBananaBlock;
import CookingPlus.blocks.CookingPlusBasalt;
import CookingPlus.blocks.CookingPlusBasaltSmooth;
import CookingPlus.blocks.CookingPlusBasicBlock;
import CookingPlus.blocks.CookingPlusBlackCoralBlock;
import CookingPlus.blocks.CookingPlusBlueCoralBlock;
import CookingPlus.blocks.CookingPlusButterBlock;
import CookingPlus.blocks.CookingPlusCoconutBlock;
import CookingPlus.blocks.CookingPlusCoralRockBlock;
import CookingPlus.blocks.CookingPlusCoralRockBrick;
import CookingPlus.blocks.CookingPlusCoralRockBrickMossy;
import CookingPlus.blocks.CookingPlusCoralRockCarved;
import CookingPlus.blocks.CookingPlusCoralRockSmooth;
import CookingPlus.blocks.CookingPlusCustomBlock;
import CookingPlus.blocks.CookingPlusCustomCrops;
import CookingPlus.blocks.CookingPlusCustomGrowingBush;
import CookingPlus.blocks.CookingPlusCustomLeaves;
import CookingPlus.blocks.CookingPlusCustomRenderedBlock;
import CookingPlus.blocks.CookingPlusCustomSapling;
import CookingPlus.blocks.CookingPlusCustomSpreadingCoral;
import CookingPlus.blocks.CookingPlusCustomTranslucentCoral;
import CookingPlus.blocks.CookingPlusCustomUnderwaterCrop;
import CookingPlus.blocks.CookingPlusCustomUnderwaterPlant;
import CookingPlus.blocks.CookingPlusEasyScaffolding;
import CookingPlus.blocks.CookingPlusGreenCoralBlock;
import CookingPlus.blocks.CookingPlusHydrothermalBlock;
import CookingPlus.blocks.CookingPlusInfusedGlass;
import CookingPlus.blocks.CookingPlusLightAirBlock;
import CookingPlus.blocks.CookingPlusNetworkBlock;
import CookingPlus.blocks.CookingPlusNullBlock;
import CookingPlus.blocks.CookingPlusOrangeCoralBlock;
import CookingPlus.blocks.CookingPlusPalmLog;
import CookingPlus.blocks.CookingPlusPalmPlanks;
import CookingPlus.blocks.CookingPlusRedCoralBlock;
import CookingPlus.blocks.CookingPlusRopeBlock;
import CookingPlus.blocks.CookingPlusRotatedRustedMachine;
import CookingPlus.blocks.CookingPlusRustedPipe;
import CookingPlus.blocks.CookingPlusSaltBlock;
import CookingPlus.blocks.CookingPlusSimpleRustedMachine;
import CookingPlus.blocks.CookingPlusTangleHeart;
import CookingPlus.blocks.CookingPlusTangleLog;
import CookingPlus.blocks.CookingPlusWhiteCoralBlock;
import CookingPlus.blocks.CookingPlusYellowCoralBlock;
import CookingPlus.blocks.EarthCrystalClusterBlock;
import CookingPlus.blocks.FireCrystalClusterBlock;
import CookingPlus.blocks.SaltOreBlock;
import CookingPlus.blocks.UraniumOreBlock;
import CookingPlus.blocks.WaterCrystalClusterBlock;
import CookingPlus.blocks.bushes.CookingPlusBlueBerryBush;
import CookingPlus.blocks.bushes.CookingPlusGooseBerryBush;
import CookingPlus.blocks.bushes.CookingPlusPlainBush;
import CookingPlus.blocks.bushes.CookingPlusStrawBerryBush;
import CookingPlus.blocks.crops.CookingPlusBeetrootPlant;
import CookingPlus.blocks.crops.CookingPlusBlackCoral;
import CookingPlus.blocks.crops.CookingPlusBlueCoral;
import CookingPlus.blocks.crops.CookingPlusBuchuPlant;
import CookingPlus.blocks.crops.CookingPlusChamomilePlant;
import CookingPlus.blocks.crops.CookingPlusChilliPlant;
import CookingPlus.blocks.crops.CookingPlusCottonPlant;
import CookingPlus.blocks.crops.CookingPlusEasyCrop;
import CookingPlus.blocks.crops.CookingPlusEasyMutantCrop;
import CookingPlus.blocks.crops.CookingPlusGrapeCrop;
import CookingPlus.blocks.crops.CookingPlusGreenCoral;
import CookingPlus.blocks.crops.CookingPlusHopsCrop;
import CookingPlus.blocks.crops.CookingPlusKelpCrop;
import CookingPlus.blocks.crops.CookingPlusLicoricePlant;
import CookingPlus.blocks.crops.CookingPlusMintPlant;
import CookingPlus.blocks.crops.CookingPlusOnionPlant;
import CookingPlus.blocks.crops.CookingPlusOrangeCoral;
import CookingPlus.blocks.crops.CookingPlusPineappleCrop;
import CookingPlus.blocks.crops.CookingPlusRedCoral;
import CookingPlus.blocks.crops.CookingPlusRosemaryPlant;
import CookingPlus.blocks.crops.CookingPlusSagePlant;
import CookingPlus.blocks.crops.CookingPlusSeaweedCrop;
import CookingPlus.blocks.crops.CookingPlusTeaPlant;
import CookingPlus.blocks.crops.CookingPlusVanillaCrop;
import CookingPlus.blocks.crops.CookingPlusWhiteCoral;
import CookingPlus.blocks.crops.CookingPlusYellowCoral;
import CookingPlus.blocks.crops.TierFiveMutantCrops;
import CookingPlus.blocks.crops.TierFourMutantCrops;
import CookingPlus.blocks.crops.TierOneMutantCrop;
import CookingPlus.blocks.crops.TierThreeMutantCrops;
import CookingPlus.blocks.crops.TierTwoMutantCrop;
import CookingPlus.blocks.leaves.CookingPlusAppleLeaves;
import CookingPlus.blocks.leaves.CookingPlusBambooLeaves;
import CookingPlus.blocks.leaves.CookingPlusBananaLeaves;
import CookingPlus.blocks.leaves.CookingPlusCherryLeaves;
import CookingPlus.blocks.leaves.CookingPlusCoconutLeaves;
import CookingPlus.blocks.leaves.CookingPlusEasyLeaf;
import CookingPlus.blocks.leaves.CookingPlusLemonLeaves;
import CookingPlus.blocks.leaves.CookingPlusLimeLeaves;
import CookingPlus.blocks.leaves.CookingPlusOrangeLeaves;
import CookingPlus.blocks.leaves.CookingPlusPalmLeaves;
import CookingPlus.blocks.leaves.CookingPlusPeachLeaves;
import CookingPlus.blocks.leaves.CookingPlusTangleLeaves;
import CookingPlus.blocks.saplings.CookingPlusAppleSapling;
import CookingPlus.blocks.saplings.CookingPlusBambooSprout;
import CookingPlus.blocks.saplings.CookingPlusBananaSapling;
import CookingPlus.blocks.saplings.CookingPlusCherrySapling;
import CookingPlus.blocks.saplings.CookingPlusCoconutSapling;
import CookingPlus.blocks.saplings.CookingPlusEasySapling;
import CookingPlus.blocks.saplings.CookingPlusLemonSapling;
import CookingPlus.blocks.saplings.CookingPlusLimeSapling;
import CookingPlus.blocks.saplings.CookingPlusOrangeSapling;
import CookingPlus.blocks.saplings.CookingPlusPalmSapling;
import CookingPlus.blocks.saplings.CookingPlusPeachSapling;
import CookingPlus.blocks.tileentity.AnalyserBlock;
import CookingPlus.blocks.tileentity.CookingPlusBatteryBlock;
import CookingPlus.blocks.tileentity.CookingPlusBotBlock;
import CookingPlus.blocks.tileentity.CookingPlusBrickOvenBlock;
import CookingPlus.blocks.tileentity.CookingPlusButterChurnBlock;
import CookingPlus.blocks.tileentity.CookingPlusCustomTileEntityBlock;
import CookingPlus.blocks.tileentity.CookingPlusDesalinator;
import CookingPlus.blocks.tileentity.CookingPlusDiamondBotBlock;
import CookingPlus.blocks.tileentity.CookingPlusDiamondRangeBlock;
import CookingPlus.blocks.tileentity.CookingPlusDiamondSpeedBlock;
import CookingPlus.blocks.tileentity.CookingPlusDryingRackBlock;
import CookingPlus.blocks.tileentity.CookingPlusFermenterBlock;
import CookingPlus.blocks.tileentity.CookingPlusFisherBlock;
import CookingPlus.blocks.tileentity.CookingPlusFryingPanBlock;
import CookingPlus.blocks.tileentity.CookingPlusGathererBlock;
import CookingPlus.blocks.tileentity.CookingPlusGoldBotBlock;
import CookingPlus.blocks.tileentity.CookingPlusGoldenRangeBlock;
import CookingPlus.blocks.tileentity.CookingPlusGoldenSpeedBlock;
import CookingPlus.blocks.tileentity.CookingPlusGrabberBlock;
import CookingPlus.blocks.tileentity.CookingPlusGrowthCrystalTileEntityBlock;
import CookingPlus.blocks.tileentity.CookingPlusHeaterBlock;
import CookingPlus.blocks.tileentity.CookingPlusHydrophonicBlock;
import CookingPlus.blocks.tileentity.CookingPlusIceBoxBlock;
import CookingPlus.blocks.tileentity.CookingPlusLaserDroneBayBlock;
import CookingPlus.blocks.tileentity.CookingPlusLeyLineGeneratorBlock;
import CookingPlus.blocks.tileentity.CookingPlusLeyLinePropagatorBlock;
import CookingPlus.blocks.tileentity.CookingPlusLeyLineReceiverBlock;
import CookingPlus.blocks.tileentity.CookingPlusLightCrystalBlock;
import CookingPlus.blocks.tileentity.CookingPlusLiquidBarrelBlock;
import CookingPlus.blocks.tileentity.CookingPlusLoggerBlock;
import CookingPlus.blocks.tileentity.CookingPlusMarketBoxBlock;
import CookingPlus.blocks.tileentity.CookingPlusNetBlock;
import CookingPlus.blocks.tileentity.CookingPlusOilPressBlock;
import CookingPlus.blocks.tileentity.CookingPlusOrnateChestBlock;
import CookingPlus.blocks.tileentity.CookingPlusPlanterBlock;
import CookingPlus.blocks.tileentity.CookingPlusPlateBlock;
import CookingPlus.blocks.tileentity.CookingPlusRangeBlock;
import CookingPlus.blocks.tileentity.CookingPlusSaucePanBlock;
import CookingPlus.blocks.tileentity.CookingPlusSheetPressBlock;
import CookingPlus.blocks.tileentity.CookingPlusSkyCrystalBlock;
import CookingPlus.blocks.tileentity.CookingPlusSpeedBlock;
import CookingPlus.blocks.tileentity.CookingPlusSpongeBlock;
import CookingPlus.blocks.tileentity.CookingPlusTeapotBlock;
import CookingPlus.blocks.tileentity.CookingPlusUnfiredFryingPanBlock;
import CookingPlus.blocks.tileentity.CookingPlusUnfiredPlateBlock;
import CookingPlus.blocks.tileentity.CookingPlusUnfiredSaucepanBlock;
import CookingPlus.blocks.tileentity.CookingPlusUnfiredTeapotBlock;
import CookingPlus.blocks.tileentity.CookingPlusVanillaBlock;
import CookingPlus.blocks.tileentity.CookingPlusVatBlock;
import CookingPlus.blocks.tileentity.CookingPlusWaterCrystalBlock;
import CookingPlus.blocks.tileentity.FishTankBlock;
import CookingPlus.blocks.tileentity.InscriberBlock;
import CookingPlus.blocks.tileentity.LeyDesynthBlock;
import CookingPlus.blocks.tileentity.MutationStationBlock;
import CookingPlus.blocks.tileentity.ResearchLabBlock;
import CookingPlus.generation.CookingPlusBambooBiome;
import CookingPlus.generation.CookingPlusCoralReefBiome;
import CookingPlus.generation.CookingPlusDeepReefBiome;
import CookingPlus.generation.CookingPlusKelpForestBiome;
import CookingPlus.generation.CookingPlusOrchardBiome;
import CookingPlus.generation.CookingPlusTropicalBiome;
import CookingPlus.generation.CookingPlusWorldGen;
import CookingPlus.items.CookingPlusBreadCrumbs;
import CookingPlus.items.CookingPlusBreadDough;
import CookingPlus.items.CookingPlusButterIngot;
import CookingPlus.items.CookingPlusButterNugget;
import CookingPlus.items.CookingPlusCakeBatter;
import CookingPlus.items.CookingPlusCircleCutter;
import CookingPlus.items.CookingPlusCircleUncooked;
import CookingPlus.items.CookingPlusCocoaPowder;
import CookingPlus.items.CookingPlusCookieBatter;
import CookingPlus.items.CookingPlusCreamBucket;
import CookingPlus.items.CookingPlusCreamCheeseWedge;
import CookingPlus.items.CookingPlusCupcakeTrayChocolate;
import CookingPlus.items.CookingPlusCupcakeTraySponge;
import CookingPlus.items.CookingPlusCupcakeTrayVelvet;
import CookingPlus.items.CookingPlusCustomEdibleFood;
import CookingPlus.items.CookingPlusCustomEdibleRopeCropSeed;
import CookingPlus.items.CookingPlusCustomEdibleSeed;
import CookingPlus.items.CookingPlusCustomItem;
import CookingPlus.items.CookingPlusCustomScythe;
import CookingPlus.items.CookingPlusDriedSeaweed;
import CookingPlus.items.CookingPlusEasyStageThreeFood;
import CookingPlus.items.CookingPlusEasyStageTwoFood;
import CookingPlus.items.CookingPlusFishingNet;
import CookingPlus.items.CookingPlusFlour;
import CookingPlus.items.CookingPlusHeartCutter;
import CookingPlus.items.CookingPlusHeartUncooked;
import CookingPlus.items.CookingPlusIceBowlItem;
import CookingPlus.items.CookingPlusIceCreamBaseItem;
import CookingPlus.items.CookingPlusIronSheet;
import CookingPlus.items.CookingPlusJuicer;
import CookingPlus.items.CookingPlusKnife;
import CookingPlus.items.CookingPlusLargeCupcakeTraySponge;
import CookingPlus.items.CookingPlusMintEssence;
import CookingPlus.items.CookingPlusMoonCutter;
import CookingPlus.items.CookingPlusMoonUncooked;
import CookingPlus.items.CookingPlusMultiStackItem;
import CookingPlus.items.CookingPlusNeedle;
import CookingPlus.items.CookingPlusPancakeMix;
import CookingPlus.items.CookingPlusPestle;
import CookingPlus.items.CookingPlusRack;
import CookingPlus.items.CookingPlusRawCrab;
import CookingPlus.items.CookingPlusRawLobster;
import CookingPlus.items.CookingPlusRawOyster;
import CookingPlus.items.CookingPlusRawPrawn;
import CookingPlus.items.CookingPlusRawSquid;
import CookingPlus.items.CookingPlusShelledCrab;
import CookingPlus.items.CookingPlusShelledLobster;
import CookingPlus.items.CookingPlusShelledOyster;
import CookingPlus.items.CookingPlusShelledPrawn;
import CookingPlus.items.CookingPlusSingleStackItem;
import CookingPlus.items.CookingPlusStarCutter;
import CookingPlus.items.CookingPlusStarUncooked;
import CookingPlus.items.CookingPlusTeleportCrystal;
import CookingPlus.items.CookingPlusUncookedCrabCake;
import CookingPlus.items.CookingPlusVanillaButterCream;
import CookingPlus.items.CookingPlusVanillaEssence;
import CookingPlus.items.CookingPlusVegetableOil;
import CookingPlus.items.CookingPlusWaterOrb;
import CookingPlus.items.Drinks.CookingPlusAppleJuice;
import CookingPlus.items.Drinks.CookingPlusBeer;
import CookingPlus.items.Drinks.CookingPlusBlueBerryJuice;
import CookingPlus.items.Drinks.CookingPlusBuchuTea;
import CookingPlus.items.Drinks.CookingPlusChamomileTea;
import CookingPlus.items.Drinks.CookingPlusCider;
import CookingPlus.items.Drinks.CookingPlusEasyJuice;
import CookingPlus.items.Drinks.CookingPlusGooseBerryJuice;
import CookingPlus.items.Drinks.CookingPlusGrapeJuice;
import CookingPlus.items.Drinks.CookingPlusLemonJuice;
import CookingPlus.items.Drinks.CookingPlusLicoriceTea;
import CookingPlus.items.Drinks.CookingPlusLimeJuice;
import CookingPlus.items.Drinks.CookingPlusMintTea;
import CookingPlus.items.Drinks.CookingPlusOrangeJuice;
import CookingPlus.items.Drinks.CookingPlusPeachJuice;
import CookingPlus.items.Drinks.CookingPlusPineappleJuice;
import CookingPlus.items.Drinks.CookingPlusRosemaryTea;
import CookingPlus.items.Drinks.CookingPlusSageTea;
import CookingPlus.items.Drinks.CookingPlusStrawBerryJuice;
import CookingPlus.items.Drinks.CookingPlusWine;
import CookingPlus.items.Harvest.CookingPlusBanana;
import CookingPlus.items.Harvest.CookingPlusBeetroot;
import CookingPlus.items.Harvest.CookingPlusBlueBerry;
import CookingPlus.items.Harvest.CookingPlusBuchuLeaf;
import CookingPlus.items.Harvest.CookingPlusChamomileFlower;
import CookingPlus.items.Harvest.CookingPlusCherry;
import CookingPlus.items.Harvest.CookingPlusChilli;
import CookingPlus.items.Harvest.CookingPlusCottonBud;
import CookingPlus.items.Harvest.CookingPlusEasyHarvest;
import CookingPlus.items.Harvest.CookingPlusGooseBerry;
import CookingPlus.items.Harvest.CookingPlusGrape;
import CookingPlus.items.Harvest.CookingPlusHop;
import CookingPlus.items.Harvest.CookingPlusLemon;
import CookingPlus.items.Harvest.CookingPlusLicoriceLeaf;
import CookingPlus.items.Harvest.CookingPlusLime;
import CookingPlus.items.Harvest.CookingPlusMintLeaf;
import CookingPlus.items.Harvest.CookingPlusOnion;
import CookingPlus.items.Harvest.CookingPlusOrange;
import CookingPlus.items.Harvest.CookingPlusPeach;
import CookingPlus.items.Harvest.CookingPlusPineapple;
import CookingPlus.items.Harvest.CookingPlusRosemaryLeaf;
import CookingPlus.items.Harvest.CookingPlusSageLeaf;
import CookingPlus.items.Harvest.CookingPlusSaltPile;
import CookingPlus.items.Harvest.CookingPlusStrawBerry;
import CookingPlus.items.Harvest.CookingPlusTeaLeaf;
import CookingPlus.items.Harvest.CookingPlusVanillaPod;
import CookingPlus.items.PotteryStuff.CookingPlusCupcakeTray;
import CookingPlus.items.PotteryStuff.CookingPlusCupcakeTrayMold;
import CookingPlus.items.PotteryStuff.CookingPlusCupcakeTrayUnfiredMold;
import CookingPlus.items.PotteryStuff.CookingPlusLargeCupcakeTray;
import CookingPlus.items.PotteryStuff.CookingPlusLargeCupcakeTrayMold;
import CookingPlus.items.PotteryStuff.CookingPlusLargeCupcakeTrayUnfiredMold;
import CookingPlus.items.PotteryStuff.CookingPlusMug;
import CookingPlus.items.PotteryStuff.CookingPlusPotterGuideJuicer;
import CookingPlus.items.PotteryStuff.CookingPlusPotteryGuideCupcakeTrayMold;
import CookingPlus.items.PotteryStuff.CookingPlusPotteryGuideFryingPan;
import CookingPlus.items.PotteryStuff.CookingPlusPotteryGuideLargeCupcakeTrayMold;
import CookingPlus.items.PotteryStuff.CookingPlusPotteryGuideMug;
import CookingPlus.items.PotteryStuff.CookingPlusPotteryGuidePlate;
import CookingPlus.items.PotteryStuff.CookingPlusPotteryGuideSaucepan;
import CookingPlus.items.PotteryStuff.CookingPlusPotteryGuideTeapot;
import CookingPlus.items.PotteryStuff.CookingPlusSoakedBook;
import CookingPlus.items.PotteryStuff.CookingPlusUnfiredJuicer;
import CookingPlus.items.PotteryStuff.CookingPlusUnfiredMug;
import CookingPlus.items.Seeds.CookingPlusBeetrootSeed;
import CookingPlus.items.Seeds.CookingPlusChilliSeed;
import CookingPlus.items.Seeds.CookingPlusCottonSeed;
import CookingPlus.items.Seeds.CookingPlusEasySeed;
import CookingPlus.items.Seeds.CookingPlusGrapeSeed;
import CookingPlus.items.Seeds.CookingPlusHopSeed;
import CookingPlus.items.Seeds.CookingPlusOnionSeed;
import CookingPlus.items.Seeds.CookingPlusPineappleSeed;
import CookingPlus.items.Seeds.CookingPlusRiceSeed;
import CookingPlus.items.Seeds.CookingPlusTeaSeed;
import CookingPlus.items.Seeds.CookingPlusVanillaSeed;
import CookingPlus.items.foods.CookingPlusBeefJerky;
import CookingPlus.items.foods.CookingPlusBeetrootSoup;
import CookingPlus.items.foods.CookingPlusBlueCheeseWedge;
import CookingPlus.items.foods.CookingPlusCheddarWedge;
import CookingPlus.items.foods.CookingPlusChocolate;
import CookingPlus.items.foods.CookingPlusChocolatePancake;
import CookingPlus.items.foods.CookingPlusCircleCookie;
import CookingPlus.items.foods.CookingPlusCookedCrab;
import CookingPlus.items.foods.CookingPlusCookedCrabCake;
import CookingPlus.items.foods.CookingPlusCookedLobster;
import CookingPlus.items.foods.CookingPlusCookedOyster;
import CookingPlus.items.foods.CookingPlusCookedPrawn;
import CookingPlus.items.foods.CookingPlusCookedSquid;
import CookingPlus.items.foods.CookingPlusCreamPancake;
import CookingPlus.items.foods.CookingPlusHalloumiWedge;
import CookingPlus.items.foods.CookingPlusHeartCookie;
import CookingPlus.items.foods.CookingPlusLemonPancake;
import CookingPlus.items.foods.CookingPlusMoonCookie;
import CookingPlus.items.foods.CookingPlusPancake;
import CookingPlus.items.foods.CookingPlusPlainChocolateCupcake;
import CookingPlus.items.foods.CookingPlusPlainRedVelvetCupcake;
import CookingPlus.items.foods.CookingPlusPlainSpongeCupcake;
import CookingPlus.items.foods.CookingPlusPorkJerky;
import CookingPlus.items.foods.CookingPlusRabbitJerky;
import CookingPlus.items.foods.CookingPlusSaltedBeef;
import CookingPlus.items.foods.CookingPlusSaltedChicken;
import CookingPlus.items.foods.CookingPlusSaltedCrab;
import CookingPlus.items.foods.CookingPlusSaltedLobster;
import CookingPlus.items.foods.CookingPlusSaltedMutton;
import CookingPlus.items.foods.CookingPlusSaltedOyster;
import CookingPlus.items.foods.CookingPlusSaltedPork;
import CookingPlus.items.foods.CookingPlusSaltedPrawn;
import CookingPlus.items.foods.CookingPlusSaltedRabbit;
import CookingPlus.items.foods.CookingPlusSaltedSquid;
import CookingPlus.items.foods.CookingPlusSeafoodPlatter;
import CookingPlus.items.foods.CookingPlusSheepJerky;
import CookingPlus.items.foods.CookingPlusStarCookie;
import CookingPlus.items.foods.CookingPlusSugarPancake;
import CookingPlus.items.foods.CookingPlusVanillaChocolateCupcake;
import CookingPlus.items.foods.CookingPlusVanillaRedVelvetCupcake;
import CookingPlus.items.foods.CookingPlusVanillaSpongeCupcake;
import CookingPlus.items.foods.CookingPlusZombieJerky;
import CookingPlus.recipes.CookingPlusDryingRackRecipe;
import CookingPlus.recipes.CookingPlusFryingPanRecipes;
import CookingPlus.recipes.CookingPlusIceBoxRecipes;
import CookingPlus.recipes.CookingPlusOvenRecipes;
import CookingPlus.recipes.CookingPlusSaucePanRecipe;
import CookingPlus.recipes.CookingPlusSheetPressRecipes;
import CookingPlus.recipes.InscriptionRecipeHelper;
import CookingPlus.recipes.MutationStationRecipeHandler;
import CookingPlus.tiles.AnalyserTileEntity;
import CookingPlus.tiles.BatteryBlockTileEntity;
import CookingPlus.tiles.BotTileEntity;
import CookingPlus.tiles.BrickOvenTileEntity;
import CookingPlus.tiles.ButterChurnTileEntity;
import CookingPlus.tiles.CookingPlusDiamondRangeBlockTileEntity;
import CookingPlus.tiles.CookingPlusDiamondSpeedBlockTileEntity;
import CookingPlus.tiles.CookingPlusGathererTileEntity;
import CookingPlus.tiles.CookingPlusGoldenRangeBlockTileEntity;
import CookingPlus.tiles.CookingPlusGoldenSpeedBlockTileEntity;
import CookingPlus.tiles.CookingPlusGrowthCrystalTileEntity;
import CookingPlus.tiles.CookingPlusLightCrystalTileEntity;
import CookingPlus.tiles.CookingPlusRangeBlockTileEntity;
import CookingPlus.tiles.CookingPlusSkyCrystalTileEntity;
import CookingPlus.tiles.CookingPlusSpeedBlockTileEntity;
import CookingPlus.tiles.CookingPlusWaterCrystalTileEntity;
import CookingPlus.tiles.DesalinatorTileEntity;
import CookingPlus.tiles.DiamondBotTileEntity;
import CookingPlus.tiles.DryingRackTileEntity;
import CookingPlus.tiles.FermenterTileEntity;
import CookingPlus.tiles.FishTankTileEntity;
import CookingPlus.tiles.FisherTileEntity;
import CookingPlus.tiles.FryingPanTileEntity;
import CookingPlus.tiles.GoldBotTileEntity;
import CookingPlus.tiles.GrabberTileEntity;
import CookingPlus.tiles.HeaterTileEntity;
import CookingPlus.tiles.HydrophonicTileEntity;
import CookingPlus.tiles.IceBoxTileEntity;
import CookingPlus.tiles.InscriberTileEntity;
import CookingPlus.tiles.LaserDroneBayTileEntity;
import CookingPlus.tiles.LeyDesynthTileEntity;
import CookingPlus.tiles.LeyLineGeneratorTileEntity;
import CookingPlus.tiles.LeyLinePropagatorTileEntity;
import CookingPlus.tiles.LeyLineReceiverTileEntity;
import CookingPlus.tiles.LiquidBarrelTileEntity;
import CookingPlus.tiles.LoggerTileEntity;
import CookingPlus.tiles.MarketBoxTileEntity;
import CookingPlus.tiles.MutationStationTileEntity;
import CookingPlus.tiles.NetBlockTileEntity;
import CookingPlus.tiles.OilPressTileEntity;
import CookingPlus.tiles.OrnateChestTileEntity;
import CookingPlus.tiles.PlanterTileEntity;
import CookingPlus.tiles.PlateTileEntity;
import CookingPlus.tiles.ResearchLabTileEntity;
import CookingPlus.tiles.SaucepanTileEntity;
import CookingPlus.tiles.SheetPressTileEntity;
import CookingPlus.tiles.SpongeTileEntity;
import CookingPlus.tiles.TeapotTileEntity;
import CookingPlus.tiles.UnfiredFryingPanTileEntity;
import CookingPlus.tiles.UnfiredPlateTileEntity;
import CookingPlus.tiles.UnfiredSaucepanTileEntity;
import CookingPlus.tiles.UnfiredTeapotTileEntity;
import CookingPlus.tiles.VanillaTileEntity;
import CookingPlus.tiles.VatTileEntity;

@Mod(modid = CookingPlusMain.MODID, name = CookingPlusMain.MODNAME, version = CookingPlusMain.VERSION)


public class CookingPlusMain {
	
	public static final String MODID = "agriculturalrevolution";
    public static final String MODNAME = "The Agricultural Revolution";
    public static final String VERSION = "0.9.1";
    
    public static WorldProvider dimensionEden = new CookingPlusEdenDimension();
    
    //recipe declarations
    public final static CookingPlusOvenRecipes OvenRecipes = new CookingPlusOvenRecipes();
    public final static CookingPlusFryingPanRecipes FryingPanRecipes = new CookingPlusFryingPanRecipes();
    public final static CookingPlusSheetPressRecipes SheetPressRecipes = new CookingPlusSheetPressRecipes();
    public final static CookingPlusSheetPressRecipes DryingRackRecipes = new CookingPlusSheetPressRecipes();
    public final static CookingPlusSaucePanRecipe SaucePanRecipes = new CookingPlusSaucePanRecipe();
    public final static CookingPlusIceBoxRecipes IceBoxRecipes = new CookingPlusIceBoxRecipes();
    public final static CookingPlusLootHelper MyLootHelper = new CookingPlusLootHelper();
    public final static CookingPlusGenericHelper MyGenericHelper = new CookingPlusGenericHelper();
    public final static MutationStationRecipeHandler MutationStationRecipes = new MutationStationRecipeHandler();
    public final static InscriptionRecipeHelper InscriptionRecipes = new InscriptionRecipeHelper();
    
    //block declarations
    public final static Block blockChilliCrop = new CookingPlusChilliPlant();
    public final static Block blockOnionCrop = new CookingPlusOnionPlant();
    public final static Block blockPineappleCrop = new CookingPlusPineappleCrop();
    public final static Block blockSalt = new CookingPlusSaltBlock();
    public final static Block blockBrickOven = new CookingPlusBrickOvenBlock();
    public final static Block blockNull = new CookingPlusNullBlock();
    public final static Block blockButterChurn = new CookingPlusButterChurnBlock();
    public final static Block blockButter = new CookingPlusButterBlock();
    public final static Block blockOilPress = new CookingPlusOilPressBlock();
    public final static Block blockFermenter = new CookingPlusFermenterBlock();
    public final static Block blockMarketBox = new CookingPlusMarketBoxBlock();
    public final static Block blockTeapot = new CookingPlusTeapotBlock();
    public final static Block blockUnfiredTeapot = new CookingPlusUnfiredTeapotBlock();
    public final static Block blockHeater = new CookingPlusHeaterBlock();
    public final static Block blockOrnateChest = new CookingPlusOrnateChestBlock();
    public final static Block blockCottonCrop = new CookingPlusCottonPlant();
    public final static Block blockBamboo = new CookingPlusBamboo();
    public final static Block blockBambooBlock = new CookingPlusBambooBlock();
    public final static Block blockTeaCrop = new CookingPlusTeaPlant();
    
    public final static Block blockUnfiredPlate = new CookingPlusUnfiredPlateBlock();
    public final static Block blockPlate = new CookingPlusPlateBlock();
    public final static Block blockFryingPan = new CookingPlusFryingPanBlock();
    public final static Block blockUnfiredFryingPan = new CookingPlusUnfiredFryingPanBlock();
    public final static Block blockSheetPress = new CookingPlusSheetPressBlock();
    public final static Block blockSponge = new CookingPlusSpongeBlock();
    public final static Block blockVanilla = new CookingPlusVanillaBlock();
    
    public final static Block blockAppleLeaves = new CookingPlusAppleLeaves();
    public final static Block blockLemonLeaves = new CookingPlusLemonLeaves();
    public final static Block blockPeachLeaves = new CookingPlusPeachLeaves();
    public final static Block blockLimeLeaves = new CookingPlusLimeLeaves();
    public final static Block blockOrangeLeaves = new CookingPlusOrangeLeaves();
    public final static Block blockCherryLeaves = new CookingPlusCherryLeaves();
    public final static Block blockAppleSapling = new CookingPlusAppleSapling();
    public final static Block blockLemonSapling = new CookingPlusLemonSapling();
    public final static Block blockPeachSapling = new CookingPlusPeachSapling();
    public final static Block blockLimeSapling = new CookingPlusLimeSapling();
    public final static Block blockOrangeSapling = new CookingPlusOrangeSapling();
    public final static Block blockCherrySapling = new CookingPlusCherrySapling();
    public final static Block blockBambooLeaves = new CookingPlusBambooLeaves();
    public final static Block blockBambooSprout = new CookingPlusBambooSprout();
    
    public final static Block blockBlueBerryBush = new CookingPlusBlueBerryBush();
    public final static Block blockGooseBerryBush = new CookingPlusGooseBerryBush();
    public final static Block blockStrawBerryBush = new CookingPlusStrawBerryBush();
    public final static Block blockBush = new CookingPlusPlainBush();
    
    //herbs
    public final static Block blockSage = new CookingPlusSagePlant();
    public final static Block blockMint = new CookingPlusMintPlant();
    public final static Block blockBuchu = new CookingPlusBuchuPlant();
    public final static Block blockRosemary = new CookingPlusRosemaryPlant();
    public final static Block blockLicorice = new CookingPlusLicoricePlant();
    public final static Block blockChamomile = new CookingPlusChamomilePlant();
    
    public final static Item mintleaf = new CookingPlusMintLeaf();
    public final static Item sageleaf = new CookingPlusSageLeaf();
    public final static Item rosemaryleaf = new CookingPlusRosemaryLeaf();
    public final static Item licoriceleaf = new CookingPlusLicoriceLeaf();
    public final static Item buchuleaf = new CookingPlusBuchuLeaf();
    public final static Item chamomileflower = new CookingPlusChamomileFlower();
    
    public final static Item chamomiletea = new CookingPlusChamomileTea();
    public final static Item minttea = new CookingPlusMintTea();
    public final static Item sagetea = new CookingPlusSageTea();
    public final static Item rosemarytea = new CookingPlusRosemaryTea();
    public final static Item licoricetea = new CookingPlusLicoriceTea();
    public final static Item buchutea = new CookingPlusBuchuTea();
    
    //sweetie stuff
    public final static Item circlecutter = new CookingPlusCircleCutter();
    public final static Item heartcutter = new CookingPlusHeartCutter();
    public final static Item starcutter = new CookingPlusStarCutter();
    public final static Item mooncutter = new CookingPlusMoonCutter();
    public final static Item circleuncooked = new CookingPlusCircleUncooked();
    public final static Item heartuncooked = new CookingPlusHeartUncooked();
    public final static Item staruncooked = new CookingPlusStarUncooked();
    public final static Item moonuncooked = new CookingPlusMoonUncooked();
    public final static Item circlecookie = new CookingPlusCircleCookie();
    public final static Item heartcookie = new CookingPlusHeartCookie();
    public final static Item starcookie = new CookingPlusStarCookie();
    public final static Item mooncookie = new CookingPlusMoonCookie();
    public final static Item chocolate = new CookingPlusChocolate();
    public final static Item cocoapowder = new CookingPlusCocoaPowder();
    public final static Item pancakemix = new CookingPlusPancakeMix();
    public final static Item pancake = new CookingPlusPancake();
    public final static Item chocolatepancake = new CookingPlusChocolatePancake();
    public final static Item sugarpancake = new CookingPlusSugarPancake();
    public final static Item lemonpancake = new CookingPlusLemonPancake();
    public final static Item creampancake = new CookingPlusCreamPancake();
    public final static Item vanillapod = new CookingPlusVanillaPod();
    
    public final static Item cupcaketrayunfiredmold = new CookingPlusCupcakeTrayUnfiredMold();
    public final static Item cupcaketraymold = new CookingPlusCupcakeTrayMold();
    public final static Item cupcaketray = new CookingPlusCupcakeTray();
    public final static Item largecupcaketrayunfiredmold = new CookingPlusLargeCupcakeTrayUnfiredMold();
    public final static Item largecupcaketraymold = new CookingPlusLargeCupcakeTrayMold();
    public final static Item largecupcaketray = new CookingPlusLargeCupcakeTray();
    
    public final static Item traysponge = new CookingPlusCupcakeTraySponge();
    public final static Item traychocolate = new CookingPlusCupcakeTrayChocolate();
    public final static Item trayvelvet = new CookingPlusCupcakeTrayVelvet();
    public final static Item traylargesponge = new CookingPlusLargeCupcakeTraySponge();
    public final static Item plainspongecupcake = new CookingPlusPlainSpongeCupcake();
    public final static Item plainchocolatecupcake = new CookingPlusPlainChocolateCupcake();
    public final static Item plainredvelvetcupcake = new CookingPlusPlainRedVelvetCupcake();
    public final static Item ironsheet = new CookingPlusIronSheet();
    public final static Item vanillaessence = new CookingPlusVanillaEssence();
    public final static Item creambucket = new CookingPlusCreamBucket();
    public final static Item vanillasponge = new CookingPlusVanillaSpongeCupcake();
    public final static Item vanillachocolate = new CookingPlusVanillaChocolateCupcake();
    public final static Item vanillavelvet = new CookingPlusVanillaRedVelvetCupcake();
    public final static Item vanillabuttercream = new CookingPlusVanillaButterCream();
    
    public final static Block blockRope = new CookingPlusRopeBlock();
    
    //item declaration
    public final static Item chilliseed = new CookingPlusChilliSeed();
    public final static Item chilli = new CookingPlusChilli();
    public final static Item onionseed = new CookingPlusOnionSeed();
    public final static Item onion = new CookingPlusOnion();
    public final static Item grapeseed = new CookingPlusGrapeSeed();
    public final static Item grape = new CookingPlusGrape();
    public final static Item hopseed = new CookingPlusHopSeed();
    public final static Item hops = new CookingPlusHop();
    public final static Item cottonseed = new CookingPlusCottonSeed();
    public final static Item cottonbud = new CookingPlusCottonBud();
    public final static Item teaseed = new CookingPlusTeaSeed();
    public final static Item tealeaf = new CookingPlusTeaLeaf();
    public final static Item vanillaseed = new CookingPlusVanillaSeed();
    
    public final static Item shelledprawn = new CookingPlusShelledPrawn();
    public final static Item rawprawn = new CookingPlusRawPrawn();
    public final static Item cookedprawn = new CookingPlusCookedPrawn();
    public final static Item saltpile = new CookingPlusSaltPile();
    
    public final static Item fishingnet = new CookingPlusFishingNet();
    public final static Item flour = new CookingPlusFlour();
    public final static Item pestle = new CookingPlusPestle();
    public final static Item cakebatter = new CookingPlusCakeBatter();
    public final static Item cookiebatter = new CookingPlusCookieBatter();
    public final static Item rack = new CookingPlusRack();
    public final static Item knife = new CookingPlusKnife();
    public final static Item dough = new CookingPlusBreadDough();
    
    public final static Item butteringot = new CookingPlusButterIngot();
    public final static Item butternugget = new CookingPlusButterNugget();
    public final static Item vegetableoil = new CookingPlusVegetableOil();
    
    public final static Item pineappleseed = new CookingPlusPineappleSeed();
    public final static Item pineapple = new CookingPlusPineapple();
    public final static Item lemon = new CookingPlusLemon();
    public final static Item peach = new CookingPlusPeach();
    public final static Item lime = new CookingPlusLime();
    public final static Item blueberry = new CookingPlusBlueBerry();
    public final static Item gooseberry = new CookingPlusGooseBerry();
    public final static Item strawberry = new CookingPlusStrawBerry();
    public final static Item orange = new CookingPlusOrange();
    public final static Item cherry = new CookingPlusCherry();
    
    //juices
    public final static Item applejuice = new CookingPlusAppleJuice();
    public final static Item lemonjuice = new CookingPlusLemonJuice();
    public final static Item limejuice = new CookingPlusLimeJuice();
    public final static Item peachjuice = new CookingPlusPeachJuice();
    public final static Item blueberryjuice = new CookingPlusBlueBerryJuice();
    public final static Item gooseberryjuice = new CookingPlusGooseBerryJuice();
    public final static Item strawberryjuice = new CookingPlusStrawBerryJuice();
    public final static Item orangejuice = new CookingPlusOrangeJuice();
    public final static Item grapejuice = new CookingPlusGrapeJuice();
    public final static Item pineapplejuice = new CookingPlusPineappleJuice();
    public final static Item wine = new CookingPlusWine();
    public final static Item cider = new CookingPlusCider();
    public final static Item beer = new CookingPlusBeer();
    
    //pottery
    public final static Item juicerguide = new CookingPlusPotterGuideJuicer();
    public final static Item mugguide = new CookingPlusPotteryGuideMug();
    public final static Item teapotguide = new CookingPlusPotteryGuideTeapot();
    public final static Item plateguide = new CookingPlusPotteryGuidePlate();
    public final static Item fryingpanguide = new CookingPlusPotteryGuideFryingPan();
    public final static Item cuptrayguide = new CookingPlusPotteryGuideCupcakeTrayMold();
    public final static Item largecuptrayguide = new CookingPlusPotteryGuideLargeCupcakeTrayMold();
    public final static Item unfiredjuicer = new CookingPlusUnfiredJuicer();
    public final static Item unfiredmug = new CookingPlusUnfiredMug();
    public final static Item juicer = new CookingPlusJuicer();
    public final static Item mug = new CookingPlusMug();
    
    public final static Item saltedbeef = new CookingPlusSaltedBeef();
    public final static Item saltedpork = new CookingPlusSaltedPork();
    public final static Item saltedprawn = new CookingPlusSaltedPrawn();
    public final static Item saltedmutton = new CookingPlusSaltedMutton();
    public final static Item saltedchicken = new CookingPlusSaltedChicken();
    public final static Item saltedrabbit = new CookingPlusSaltedRabbit();
    
    //water crops
    public final static Block blockSeaweedCrop = new CookingPlusSeaweedCrop();
    public final static Block blockKelpCrop = new CookingPlusKelpCrop();
    public final static Block blockWhiteCoral = new CookingPlusWhiteCoral();
    public final static Block blockGreenCoral = new CookingPlusGreenCoral();
    public final static Block blockBlueCoral = new CookingPlusBlueCoral();
    public final static Block blockRedCoral = new CookingPlusRedCoral();
    public final static Block blockBlackCoral = new CookingPlusBlackCoral();
    public final static Block blockYellowCoral = new CookingPlusYellowCoral();
    public final static Block blockOrangeCoral = new CookingPlusOrangeCoral();
    public final static Block blockCoralRock = new CookingPlusCoralRockBlock();
    public final static Block blockCoralRockSmooth = new CookingPlusCoralRockSmooth();
    public final static Block blockCoralRockBrick = new CookingPlusCoralRockBrick();
    public final static Block blockCoralRockBrickMossy = new CookingPlusCoralRockBrickMossy();
    public final static Block blockCoralRockCarved = new CookingPlusCoralRockCarved();
    public final static Block blockNetBlock = new CookingPlusNetBlock();
    public final static Block blockDryingRack = new CookingPlusDryingRackBlock();
    public final static Block blockLiquidBarrel = new CookingPlusLiquidBarrelBlock();
    
    public final static Item shelledcrab = new CookingPlusShelledCrab();
    public final static Item shelledlobster = new CookingPlusShelledLobster();
    public final static Item shelledoyster = new CookingPlusShelledOyster();
    public final static Item driedseaweed = new CookingPlusDriedSeaweed();
    public final static Item soakedbook = new CookingPlusSoakedBook();
    public final static Item beefjerky = new CookingPlusBeefJerky();
    public final static Item porkjerky = new CookingPlusPorkJerky();
    public final static Item sheepjerky = new CookingPlusSheepJerky();
    public final static Item rabbitjerky = new CookingPlusRabbitJerky();
    public final static Item rawcrab = new CookingPlusRawCrab();
    public final static Item rawsquid = new CookingPlusRawSquid();
    public final static Item rawlobster = new CookingPlusRawLobster();
    public final static Item rawoyster = new CookingPlusRawOyster();
    public final static Item cookedcrab = new CookingPlusCookedCrab();
    public final static Item cookedsquid = new CookingPlusCookedSquid();
    public final static Item cookedlobster = new CookingPlusCookedLobster();
    public final static Item cookedoyster = new CookingPlusCookedOyster();
    public final static Item saltedcrab = new CookingPlusSaltedCrab();
    public final static Item saltedsquid = new CookingPlusSaltedSquid();
    public final static Item saltedlobster = new CookingPlusSaltedLobster();
    public final static Item saltedoyster = new CookingPlusSaltedOyster();
    
    public final static Item cheddarwedge = new CookingPlusCheddarWedge();
    public final static Item bluewedge = new CookingPlusBlueCheeseWedge();
    public final static Item halloumiwedge = new CookingPlusHalloumiWedge();
    public final static Item creamwedge = new CookingPlusCreamCheeseWedge();
    public final static Item breadcrumbs = new CookingPlusBreadCrumbs();
    public final static Item uncookedcrabcake = new CookingPlusUncookedCrabCake();
    public final static Item cookedcrabcake = new CookingPlusCookedCrabCake();
    public final static Item seafoodplatter = new CookingPlusSeafoodPlatter();
    
    public final static Block blockPalmSapling = new CookingPlusPalmSapling();
    public final static Block blockBananaSapling = new CookingPlusBananaSapling();
    public final static Block blockCoconutSapling = new CookingPlusCoconutSapling();
    public final static Block blockPalmLog = new CookingPlusPalmLog();
    public final static Block blockPalmPlanks = new CookingPlusPalmPlanks();
    public final static Block blockPalmLeaves = new CookingPlusPalmLeaves();
    public final static Block blockCoconutLeaves = new CookingPlusCoconutLeaves();
    public final static Block blockCoconutBlock = new CookingPlusCoconutBlock();
    public final static Block blockBananaLeaves = new CookingPlusBananaLeaves();
    public final static Block blockBananaBlock = new CookingPlusBananaBlock();
    public final static Block blockSaucePan = new CookingPlusSaucePanBlock();
    public final static Block blockUnfiredSaucePan = new CookingPlusUnfiredSaucepanBlock();
    public final static Block blockBasalt = new CookingPlusBasalt();
    public final static Block blockBasaltSmooth = new CookingPlusBasaltSmooth();
    public final static Block blockHydrothermal = new CookingPlusHydrothermalBlock();
    public final static Block blockYellowCoralBlock = new CookingPlusYellowCoralBlock();
    public final static Block blockBlueCoralBlock = new CookingPlusBlueCoralBlock();
    public final static Block blockBlackCoralBlock = new CookingPlusBlackCoralBlock();
    public final static Block blockRedCoralBlock = new CookingPlusRedCoralBlock();
    public final static Block blockGreenCoralBlock = new CookingPlusGreenCoralBlock();
    public final static Block blockWhiteCoralBlock = new CookingPlusWhiteCoralBlock();
    public final static Block blockOrangeCoralBlock = new CookingPlusOrangeCoralBlock();
    public final static Block blockIceBox = new CookingPlusIceBoxBlock();
    public final static Block blockMangoLeaf = new CookingPlusEasyLeaf("mangoleaves");
    public final static Block blockKiwiLeaf = new CookingPlusEasyLeaf("kiwileaves");
    public final static Block blockMangoSapling = new CookingPlusEasySapling("mangosapling");
    public final static Block blockKiwiSapling = new CookingPlusEasySapling("kiwisapling");
    
    public final static Item zombiejerky = new CookingPlusZombieJerky();
    public final static Item saucepanguide = new CookingPlusPotteryGuideSaucepan();
    public final static Item banana = new CookingPlusBanana();
    public final static Item vanillaboiled = new CookingPlusIceCreamBaseItem("vanillaboiled");
    public final static Item lemonboiled = new CookingPlusIceCreamBaseItem("lemonboiled");
    public final static Item chocolateboiled = new CookingPlusIceCreamBaseItem("chocolateboiled");
    public final static Item mintboiled = new CookingPlusIceCreamBaseItem("mintboiled");
    public final static Item strawberryboiled = new CookingPlusIceCreamBaseItem("strawberryboiled");
    public final static Item vanillaicecreammix = new CookingPlusIceCreamBaseItem("vanillaicecreammix");
    public final static Item strawberryicecreammix = new CookingPlusIceCreamBaseItem("strawberryicecreammix");
    public final static Item chocolateicecreammix = new CookingPlusIceCreamBaseItem("chocolateicecreammix");
    public final static Item minticecreammix = new CookingPlusIceCreamBaseItem("minticecreammix");
    public final static Item lemonicecreammix = new CookingPlusIceCreamBaseItem("lemonicecreammix");
    public final static Item vanillaicecream = new CookingPlusIceBowlItem("vanillaicecream");
    public final static Item lemonicecream = new CookingPlusIceBowlItem("lemonicecream");
    public final static Item chocolateicecream = new CookingPlusIceBowlItem("chocolateicecream");
    public final static Item minticecream = new CookingPlusIceBowlItem("minticecream");
    public final static Item strawberryicecream = new CookingPlusIceBowlItem("strawberryicecream");
    public final static Item mintessence = new CookingPlusMintEssence();
    
    public final static Item breadtinguide = new CookingPlusSingleStackItem("potteryguidebreadtinmold");
    public final static Item caketinguide = new CookingPlusSingleStackItem("potteryguidecaketinmold");
    public final static Item caketin = new CookingPlusSingleStackItem("caketin");
    public final static Item caketinmold = new CookingPlusSingleStackItem("caketinmold");
    public final static Item unfiredcaketinmold = new CookingPlusSingleStackItem("unfiredcaketinmold");
    public final static Item breadtin = new CookingPlusSingleStackItem("breadtin");
    public final static Item breadtinmold = new CookingPlusSingleStackItem("breadtinmold");
    public final static Item unfiredbreadtinmold = new CookingPlusSingleStackItem("unfiredbreadtinmold");
    public final static Item mysteriousorb = new CookingPlusSingleStackItem("mysteriousorb");
    public final static Item giftofthesea = new CookingPlusSingleStackItem("giftofthesea");
    public final static Item giftofthesoil = new CookingPlusSingleStackItem("giftofthesoil");
    public final static Item giftofthesun = new CookingPlusSingleStackItem("giftofthesun");
    public final static Item giftofthesky = new CookingPlusSingleStackItem("giftofthesky");
    public final static Item mango = new CookingPlusEasyHarvest("mango");
    public final static Item kiwi = new CookingPlusEasyHarvest("kiwi");
    public final static Item mangojuice = new CookingPlusEasyJuice("mangojuice");
    public final static Item kiwijuice = new CookingPlusEasyJuice("kiwijuice");
    public final static Item bananaslice = new CookingPlusEasyHarvest("bananaslice");
    public final static Item bananabread = new CookingPlusEasyHarvest("bananabread");
    public final static Item bananadough = new CookingPlusSingleStackItem("bananadough");
    
    public final static Block blockHydrophonic = new CookingPlusHydrophonicBlock();
    public final static Block blockRiceCrop = new CookingPlusEasyCrop("ricecrop");
    public final static Block blockPricklyPearCrop = new CookingPlusEasyCrop("pricklypearcrop");
    public final static Block blockVat = new CookingPlusVatBlock();
    public final static Block blockBot = new CookingPlusBotBlock();
    public final static Block blockAvocadoLeaf = new CookingPlusEasyLeaf("avocadoleaves");
    public final static Block blockAvocadoSapling = new CookingPlusEasySapling("avocadosapling");
    
    public final static Block blockGrowthCrystal = new CookingPlusGrowthCrystalTileEntityBlock();
    public final static Block blockWaterCrystal = new CookingPlusWaterCrystalBlock();
    public final static Block blockLightCrystal = new CookingPlusLightCrystalBlock();
    public final static Block blockSkyCrystal = new CookingPlusSkyCrystalBlock();
    
    public final static Block blockGrabber = new CookingPlusGrabberBlock();
    public final static Block blockFisher = new CookingPlusFisherBlock();
    public final static Block blockTangleLog = new CookingPlusTangleLog();
    public final static Block blockTangleLeaves = new CookingPlusTangleLeaves();
    public final static Block blockTangleHeart = new CookingPlusTangleHeart();
    public final static Block blockLightAir = new CookingPlusLightAirBlock();
    public final static Block blockInfusedGlass = new CookingPlusInfusedGlass();
    public final static Block blockNetworkBlock = new CookingPlusNetworkBlock();
    public final static Block blockGatherer = new CookingPlusGathererBlock();
    
    public final static Block blockDesalinator = new CookingPlusDesalinator();
    public final static Block blockLogger = new CookingPlusLoggerBlock();
    public final static Block blockPlanter = new CookingPlusPlanterBlock();
    public final static Block blockGoldBot = new CookingPlusGoldBotBlock();
    public final static Block blockCopperOre = new CookingPlusBasicBlock(Material.ROCK, CreativeTabs.BUILDING_BLOCKS, "orecopper", 1, 1, SoundType.STONE);
    public final static Block blockZincOre = new CookingPlusBasicBlock(Material.ROCK, CreativeTabs.BUILDING_BLOCKS, "orezinc", 1, 1, SoundType.STONE);
    public final static Block blockLaserDroneBay = new CookingPlusLaserDroneBayBlock();
    public final static Block blockRangeBlock = new CookingPlusRangeBlock();
    public final static Block blockSpeedBlock = new CookingPlusSpeedBlock();
    public final static Block blockGoldenRangeBlock = new CookingPlusGoldenRangeBlock();
    public final static Block blockGoldenSpeedBlock = new CookingPlusGoldenSpeedBlock();
    
    public final static Item riceSeed = new CookingPlusRiceSeed();
    public final static Item rice = new CookingPlusEasyHarvest("rice");
    public final static Item pricklypearseeds = new CookingPlusEasySeed("pricklypearseeds", blockPricklyPearCrop, Blocks.SAND);
    public final static Item pricklypearpeeled = new CookingPlusEasyHarvest("pricklypearpeeled");
    public final static Item pricklypear = new CookingPlusMultiStackItem("pricklypear");
    public final static Item woodenscythe = new CookingPlusCustomScythe("wooden_scythe", 59);
    public final static Item stonescythe = new CookingPlusCustomScythe("stone_scythe", 131);
    public final static Item ironscythe = new CookingPlusCustomScythe("iron_scythe", 250);
    public final static Item goldscythe = new CookingPlusCustomScythe("gold_scythe", 131);
    public final static Item diamondscythe = new CookingPlusCustomScythe("diamond_scythe", 1561);
    
    public final static Item sheepneedle = new CookingPlusSingleStackItem("sheepneedle");
    public final static Item pigneedle = new CookingPlusSingleStackItem("pigneedle");
    public final static Item chickenneedle = new CookingPlusSingleStackItem("chickenneedle");
    public final static Item cowneedle = new CookingPlusSingleStackItem("cowneedle");
    public final static Item rabbitneedle = new CookingPlusSingleStackItem("rabbitneedle");
    public final static Item needle = new CookingPlusNeedle();
    public final static Item dirtyneedle = new CookingPlusSingleStackItem("dirtyneedle");
    public final static Item avocado = new CookingPlusEasyHarvest("avocado");
    public final static Item redstoneprocessor = new CookingPlusMultiStackItem("redstoneprocessor");
    public final static Item ironprocessor = new CookingPlusMultiStackItem("ironprocessor");
    public final static Item diamondprocessor = new CookingPlusMultiStackItem("diamondprocessor");
    public final static Item onigiri = new CookingPlusEasyStageTwoFood("onigiri");
    public final static Item prawnsushi = new CookingPlusEasyStageThreeFood("prawnsushi");
    public final static Item sushiroll = new CookingPlusEasyStageThreeFood("sushiroll");
    public final static Item californiaroll = new CookingPlusEasyStageTwoFood("californiaroll");
    
    public final static Item silicondust = new CookingPlusMultiStackItem("silicondust");
    public final static Item siliconsheet = new CookingPlusMultiStackItem("siliconsheet");
    public final static Item redstonesheet = new CookingPlusMultiStackItem("redstonesheet");
    public final static Item diamondsheet = new CookingPlusMultiStackItem("diamondsheet");
    public final static Item goldwire = new CookingPlusMultiStackItem("goldwire");
    public final static Item siliconchip = new CookingPlusMultiStackItem("siliconchip");
    public final static Item chipmold = new CookingPlusMultiStackItem("chipmold");
    public final static Item uncasedchip = new CookingPlusMultiStackItem("uncasedchip");
    
    public final static Item crystalcore = new CookingPlusSingleStackItem("crystalcore");
    public final static Item waterorb = new CookingPlusWaterOrb();
    
    public final static Item basicschematic = new CookingPlusMultiStackItem("basicschematic");
    public final static Item advancedschematic = new CookingPlusMultiStackItem("advancedschematic");
    public final static Item complexschematic = new CookingPlusMultiStackItem("complexschematic");
    public final static Item teleportcrystal = new CookingPlusTeleportCrystal();
    public final static Item tangleheartshard = new CookingPlusMultiStackItem("tangleheartshard");
    public final static Item moltenglass = new CookingPlusSingleStackItem("moltenglass");
    public final static Item moltenorb = new CookingPlusSingleStackItem("moltenorb");
    public final static Item sphereguide = new CookingPlusSingleStackItem("sphereguide");
    public final static Item spheremold = new CookingPlusSingleStackItem("spheremold");
    public final static Item unfiredsphere = new CookingPlusSingleStackItem("unfiredsphere");
    public final static Item chipguide = new CookingPlusSingleStackItem("chipguide");
    public final static Item chipmoldmold = new CookingPlusSingleStackItem("chipmoldmold");
    public final static Item unfiredchipmoldmold = new CookingPlusSingleStackItem("unfiredchipmoldmold");
    
    //crop and dimension update stuff
    public final static Block blockLeekCrop = new CookingPlusEasyCrop("leekcrop");
    public final static Item leek = new CookingPlusEasyHarvest("leek");
    public final static Item leekseeds = new CookingPlusEasySeed("leekseeds", blockLeekCrop, Blocks.FARMLAND);
    
    public final static Block blockLettuceCrop = new CookingPlusEasyCrop("lettucecrop");
    public final static Item lettuce = new CookingPlusEasyHarvest("lettuce");
    public final static Item lettuceseeds = new CookingPlusEasySeed("lettuceseeds", blockLettuceCrop, Blocks.FARMLAND);
    
    public final static Block blockCornCrop = new CookingPlusEasyCrop("corncrop");
    public final static Item corn = new CookingPlusEasyHarvest("corn");
    public final static Item cornseeds = new CookingPlusEasySeed("cornseeds", blockCornCrop, Blocks.FARMLAND);
    
    public final static Block blockCoffeeCrop = new CookingPlusEasyCrop("coffeecrop");
    public final static Item coffeebean = new CookingPlusEasyHarvest("coffeebean");
    public final static Item coffeeseeds = new CookingPlusEasySeed("coffeeseeds", blockCoffeeCrop, Blocks.FARMLAND);
    
    public final static Item copperingot = new CookingPlusMultiStackItem("ingotcopper");
    public final static Item zincingot = new CookingPlusMultiStackItem("ingotzinc");
    public final static Item copperwire = new CookingPlusMultiStackItem("copperwire");
    public final static Item zincwire = new CookingPlusMultiStackItem("zincwire");
    public final static Item coppersheet = new CookingPlusMultiStackItem("coppersheet");
    public final static Item zincsheet = new CookingPlusMultiStackItem("zincsheet");
    public final static Item vinegar = new CookingPlusMultiStackItem("vinegar", 16);
    public final static Item battery = new CookingPlusMultiStackItem("battery");
    public final static Item goldsheet = new CookingPlusMultiStackItem("goldsheet");
    public final static Item goldprocessor = new CookingPlusMultiStackItem("goldprocessor");
    
    //1.9 stuff
    public final static Block blockBeetrootCrop = new CookingPlusBeetrootPlant();
    public final static Item beetroot = new CookingPlusBeetroot();
    public final static Item beetrootseed = new CookingPlusBeetrootSeed();
    public final static Item beetrootsoup = new CookingPlusBeetrootSoup();
    
    //0.9 stuff
    public final static Block blockBattery = new CookingPlusBatteryBlock();
    public final static Block blockLeyReceiver = new CookingPlusLeyLineReceiverBlock();
    public final static Block blockLeyGenerator = new CookingPlusLeyLineGeneratorBlock();
    public final static Block blockLeyPropagator = new CookingPlusLeyLinePropagatorBlock();
    public final static Block blockEarthCrystalCluster = new EarthCrystalClusterBlock();
    public final static Block blockWaterCrystalCluster = new WaterCrystalClusterBlock();
    public final static Block blockAirCrystalCluster = new AirCrystalClusterBlock();
    public final static Block blockFireCrystalCluster = new FireCrystalClusterBlock();
    public final static Block blockLeyDesynth = new LeyDesynthBlock();
    public final static Block blockMutationStation = new MutationStationBlock();
    public final static Block blockUraniumOre = new UraniumOreBlock();
    public final static Block blockDiamondBot = new CookingPlusDiamondBotBlock();
    public final static Block blockFishTank = new FishTankBlock();
    public final static Block blockAnalyser = new AnalyserBlock();
    public final static Block blockInscriber = new InscriberBlock();
    public final static Block blockResearch = new ResearchLabBlock();
    
    public final static Block blockRustedAnalyser = new CookingPlusSimpleRustedMachine("rustedanalyser", BlockRenderLayer.SOLID);
    public final static Block blockRustedBot = new CookingPlusRotatedRustedMachine("rustedbot", BlockRenderLayer.SOLID);
    public final static Block blockRustedMutationStation = new CookingPlusRotatedRustedMachine("rustedmutationstation", BlockRenderLayer.SOLID);
    public final static Block blockRustedInscriber = new CookingPlusRotatedRustedMachine("rustedinscriber", BlockRenderLayer.SOLID);
    public final static Block blockRustedHydrophonic = new CookingPlusRotatedRustedMachine("rustedhydrophonic", BlockRenderLayer.CUTOUT);
    public final static Block blockRustedResearch = new CookingPlusRotatedRustedMachine("rustedresearch", BlockRenderLayer.SOLID);
    public final static Block blockRustedPipe = new CookingPlusRustedPipe();
    
    public final static Block blockDiamondRangeBlock = new CookingPlusDiamondRangeBlock();
    public final static Block blockDiamondSpeedBlock = new CookingPlusDiamondSpeedBlock();
    
    public final static Item inscribedironsheet = new CookingPlusMultiStackItem("inscribedironsheet");
    public final static Item inscribedgoldsheet = new CookingPlusMultiStackItem("inscribedgoldsheet");
    public final static Item inscribedzincsheet = new CookingPlusMultiStackItem("inscribedzincsheet");
    public final static Item inscribedredstonesheet = new CookingPlusMultiStackItem("inscribedredstonesheet");
    public final static Item inscribedsiliconsheet = new CookingPlusMultiStackItem("inscribedsiliconsheet");
    public final static Item inscribedcoppersheet = new CookingPlusMultiStackItem("inscribedcoppersheet");
    public final static Item inscribeddiamondsheet = new CookingPlusMultiStackItem("inscribeddiamondsheet");
    
    public final static Item inscribedgoldprocessor = new CookingPlusMultiStackItem("inscribedgoldprocessor");
    public final static Item inscribeddiamondprocessor = new CookingPlusMultiStackItem("inscribeddiamondprocessor");
    public final static Item inscribedredstoneprocessor = new CookingPlusMultiStackItem("inscribedredstoneprocessor");
    public final static Item inscribedironprocessor = new CookingPlusMultiStackItem("inscribedironprocessor");
    
    public final static Item fishegg = new CookingPlusMultiStackItem("fishegg");
    public final static Item failedfishegg = new CookingPlusMultiStackItem("failedfishegg");
    public final static Item onemutantfishegg = new CookingPlusMultiStackItem("onemutantfishegg");
    public final static Item twomutantfishegg = new CookingPlusMultiStackItem("twomutantfishegg");
    public final static Item threemutantfishegg = new CookingPlusMultiStackItem("threemutantfishegg");
    public final static Item fourmutantfishegg = new CookingPlusMultiStackItem("fourmutantfishegg");
    public final static Item fivemutantfishegg = new CookingPlusMultiStackItem("fivemutantfishegg");
    
    public final static Item bonefishegg = new CookingPlusMultiStackItem("bonefishegg");
    public final static Item blazefishegg = new CookingPlusMultiStackItem("blazefishegg");
    public final static Item magmafishegg = new CookingPlusMultiStackItem("magmafishegg");
    public final static Item slimefishegg = new CookingPlusMultiStackItem("slimefishegg");
    public final static Item leatherfishegg = new CookingPlusMultiStackItem("leatherfishegg");
    public final static Item ghastfishegg = new CookingPlusMultiStackItem("ghastfishegg");
    public final static Item crystalfishegg = new CookingPlusMultiStackItem("crystalfishegg");
    public final static Item shardfishegg = new CookingPlusMultiStackItem("shardfishegg");
    public final static Item inkfishegg = new CookingPlusMultiStackItem("inkfishegg");
    public final static Item eyefishegg = new CookingPlusMultiStackItem("eyefishegg");
    public final static Item rottenfishegg = new CookingPlusMultiStackItem("rottenfishegg");
    public final static Item gunpowderfishegg = new CookingPlusMultiStackItem("gunpowderfishegg");
    public final static Item enderfishegg = new CookingPlusMultiStackItem("enderfishegg");
    public final static Item netherfishegg = new CookingPlusMultiStackItem("netherfishegg");
    
    public final static Item bonefish = new CookingPlusMultiStackItem("bonefish");
    public final static Item blazefish = new CookingPlusMultiStackItem("blazefish");
    public final static Item magmafish = new CookingPlusMultiStackItem("magmafish");
    public final static Item slimefish = new CookingPlusMultiStackItem("slimefish");
    public final static Item leatherfish = new CookingPlusMultiStackItem("leatherfish");
    public final static Item ghastfish = new CookingPlusMultiStackItem("ghastfish");
    public final static Item crystalfish = new CookingPlusMultiStackItem("crystalfish");
    public final static Item shardfish = new CookingPlusMultiStackItem("shardfish");
    public final static Item inkfish = new CookingPlusMultiStackItem("inkfish");
    public final static Item eyefish = new CookingPlusMultiStackItem("eyefish");
    public final static Item rottenfish = new CookingPlusMultiStackItem("rottenfish");
    public final static Item gunpowderfish = new CookingPlusMultiStackItem("gunpowderfish");
    public final static Item enderfish = new CookingPlusMultiStackItem("enderfish");
    public final static Item netherfish = new CookingPlusMultiStackItem("netherfish");
    
    public final static Item boneessence = new CookingPlusMultiStackItem("boneessence");
    public final static Item blazeessence = new CookingPlusMultiStackItem("blazeessence");
    public final static Item magmaessence = new CookingPlusMultiStackItem("magmaessence");
    public final static Item slimeessence = new CookingPlusMultiStackItem("slimeessence");
    public final static Item leatheressence = new CookingPlusMultiStackItem("leatheressence");
    public final static Item ghastessence = new CookingPlusMultiStackItem("ghastessence");
    public final static Item crystalessence = new CookingPlusMultiStackItem("crystalessence");
    public final static Item shardessence = new CookingPlusMultiStackItem("shardessence");
    public final static Item inkessence = new CookingPlusMultiStackItem("inkessence");
    public final static Item eyeessence = new CookingPlusMultiStackItem("eyeessence");
    public final static Item rottenessence = new CookingPlusMultiStackItem("rottenessence");
    public final static Item gunpowderessence = new CookingPlusMultiStackItem("gunpowderessence");
    public final static Item enderessence = new CookingPlusMultiStackItem("enderessence");
    public final static Item netheressence = new CookingPlusMultiStackItem("netheressence");
    
    public final static Block blockRedstoneCrop = new CookingPlusEasyMutantCrop("redstonecrop");
    public final static Item redstoneLeaf = new CookingPlusMultiStackItem("redstoneleaf");
    public final static Item redstoneSeeds = new CookingPlusEasySeed("redstoneseeds", blockRedstoneCrop, Blocks.FARMLAND);
    public final static Block blockCoalCrop = new CookingPlusEasyMutantCrop("coalcrop");
    public final static Item coalLeaf = new CookingPlusMultiStackItem("coalleaf");
    public final static Item coalSeeds = new CookingPlusEasySeed("coalseeds", blockCoalCrop, Blocks.FARMLAND);
    public final static Block blockQuartzCrop = new CookingPlusEasyMutantCrop("quartzcrop");
    public final static Item quartzLeaf = new CookingPlusMultiStackItem("quartzleaf");
    public final static Item quartzSeeds = new CookingPlusEasySeed("quartzseeds", blockQuartzCrop, Blocks.FARMLAND);
    public final static Block blockLapisCrop = new CookingPlusEasyMutantCrop("lapiscrop");
    public final static Item lapisLeaf = new CookingPlusMultiStackItem("lapisleaf");
    public final static Item lapisSeeds = new CookingPlusEasySeed("lapisseeds", blockLapisCrop, Blocks.FARMLAND);
    public final static Block blockZincCrop = new CookingPlusEasyMutantCrop("zinccrop");
    public final static Item zincLeaf = new CookingPlusMultiStackItem("zincleaf");
    public final static Item zincSeeds = new CookingPlusEasySeed("zincseeds", blockZincCrop, Blocks.FARMLAND);
    public final static Block blockGlowstoneCrop = new CookingPlusEasyMutantCrop("glowstonecrop");
    public final static Item glowstoneLeaf = new CookingPlusMultiStackItem("glowstoneleaf");
    public final static Item glowstoneSeeds = new CookingPlusEasySeed("glowstoneseeds", blockGlowstoneCrop, Blocks.FARMLAND);
    public final static Block blockCopperCrop = new CookingPlusEasyMutantCrop("coppercrop");
    public final static Item copperLeaf = new CookingPlusMultiStackItem("copperleaf");
    public final static Item copperSeeds = new CookingPlusEasySeed("copperseeds", blockCopperCrop, Blocks.FARMLAND);
    public final static Block blockIronCrop = new CookingPlusEasyMutantCrop("ironcrop");
    public final static Item ironLeaf = new CookingPlusMultiStackItem("ironleaf");
    public final static Item ironSeeds = new CookingPlusEasySeed("ironseeds", blockIronCrop, Blocks.FARMLAND);
    public final static Block blockGoldCrop = new CookingPlusEasyMutantCrop("goldcrop");
    public final static Item goldLeaf = new CookingPlusMultiStackItem("goldleaf");
    public final static Item goldSeeds = new CookingPlusEasySeed("goldseeds", blockGoldCrop, Blocks.FARMLAND);
    public final static Block blockUraniumCrop = new CookingPlusEasyMutantCrop("uraniumcrop");
    public final static Item uraniumLeaf = new CookingPlusMultiStackItem("uraniumleaf");
    public final static Item uraniumSeeds = new CookingPlusEasySeed("uraniumseeds", blockUraniumCrop, Blocks.FARMLAND);
    public final static Block blockSiliconCrop = new CookingPlusEasyMutantCrop("siliconcrop");
    public final static Item siliconLeaf = new CookingPlusMultiStackItem("siliconleaf");
    public final static Item siliconSeeds = new CookingPlusEasySeed("siliconseeds", blockSiliconCrop, Blocks.FARMLAND);
    
    public final static Block blockSaltOre = new SaltOreBlock();
    public final static Block blockZincScaff = new CookingPlusEasyScaffolding(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "zincscaff", 1, 1, SoundType.METAL);
    public final static Block blockCopperScaff = new CookingPlusEasyScaffolding(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "copperscaff", 1, 1, SoundType.METAL);
    public final static Block blockIronScaff = new CookingPlusEasyScaffolding(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "ironscaff", 1, 1, SoundType.METAL);
    public final static Block blockDiamondScaff = new CookingPlusEasyScaffolding(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "diamondscaff", 1, 1, SoundType.METAL);
    public final static Block blockRedstoneScaff = new CookingPlusEasyScaffolding(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "redstonescaff", 1, 1, SoundType.METAL);
    public final static Block blockSiliconScaff = new CookingPlusEasyScaffolding(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "siliconscaff", 1, 1, SoundType.METAL);
    public final static Block blockGoldScaff = new CookingPlusEasyScaffolding(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "goldscaff", 1, 1, SoundType.METAL);
    public final static Block blockRustedIronScaff = new CookingPlusEasyScaffolding(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "rustedironscaff", 1, 1, SoundType.METAL);
    
    public final static Block blockCopperSheetBlock = new CookingPlusBasicBlock(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "coppersheetblock", 1, 1, SoundType.METAL);
    public final static Block blockDiamondSheetBlock = new CookingPlusBasicBlock(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "diamondsheetblock", 1, 1, SoundType.METAL);
    public final static Block blockRedstoneSheetBlock = new CookingPlusBasicBlock(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "redstonesheetblock", 1, 1, SoundType.METAL);
    public final static Block blockZincSheetBlock = new CookingPlusBasicBlock(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "zincsheetblock", 1, 1, SoundType.METAL);
    public final static Block blockSiliconSheetBlock = new CookingPlusBasicBlock(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "siliconsheetblock", 1, 1, SoundType.METAL);
    public final static Block blockIronSheetBlock = new CookingPlusBasicBlock(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "ironsheetblock", 1, 1, SoundType.METAL);
    public final static Block blockGoldSheetBlock = new CookingPlusBasicBlock(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "goldsheetblock", 1, 1, SoundType.METAL);
    public final static Block blockRustedIronSheetBlock = new CookingPlusBasicBlock(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "rustedironsheetblock", 1, 1, SoundType.METAL);
    public final static Block blockRustedCopperSheetBlock = new CookingPlusBasicBlock(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "rustedcoppersheetblock", 1, 1, SoundType.METAL);
    
    public final static Block blockRustedCopperTileSheetBlock = new CookingPlusBasicBlock(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "rustedcoppertile", 1, 1, SoundType.METAL);
    public final static Block blockIronTileSheetBlock = new CookingPlusBasicBlock(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "irontile", 1, 1, SoundType.METAL);
    public final static Block blockDiamondTileSheetBlock = new CookingPlusBasicBlock(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "diamondtile", 1, 1, SoundType.METAL);
    public final static Block blockRustedIronTileSheetBlock = new CookingPlusBasicBlock(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "rustedirontile", 1, 1, SoundType.METAL);
    public final static Block blockSiliconTileSheetBlock = new CookingPlusBasicBlock(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "silicontile", 1, 1, SoundType.METAL);
    public final static Block blockRedstoneTileSheetBlock = new CookingPlusBasicBlock(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "redstonetile", 1, 1, SoundType.METAL);
    public final static Block blockZincTileSheetBlock = new CookingPlusBasicBlock(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "zinctile", 1, 1, SoundType.METAL);
    public final static Block blockGoldTileSheetBlock = new CookingPlusBasicBlock(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "goldtile", 1, 1, SoundType.METAL);
    public final static Block blockCopperTileSheetBlock = new CookingPlusBasicBlock(Material.IRON, CreativeTabs.BUILDING_BLOCKS, "coppertile", 1, 1, SoundType.METAL);
    
    public final static Block blockDiamondCrop = new CookingPlusEasyMutantCrop("diamondcrop");
    public final static Item diamondLeaf = new CookingPlusMultiStackItem("diamondleaf");
    public final static Item diamondSeeds = new CookingPlusEasySeed("diamondseeds", blockDiamondCrop, Blocks.FARMLAND);
    public final static Block blockEmeraldCrop = new CookingPlusEasyMutantCrop("emeraldcrop");
    public final static Item emeraldLeaf = new CookingPlusMultiStackItem("emeraldleaf");
    public final static Item emeraldSeeds = new CookingPlusEasySeed("emeraldseeds", blockEmeraldCrop, Blocks.FARMLAND);
    public final static Block blockAirCrop = new CookingPlusEasyMutantCrop("aircrop");
    public final static Item airLeaf = new CookingPlusMultiStackItem("airleaf");
    public final static Item airSeeds = new CookingPlusEasySeed("airseeds", blockAirCrop, Blocks.FARMLAND);
    public final static Block blockEarthCrop = new CookingPlusEasyMutantCrop("earthcrop");
    public final static Item earthLeaf = new CookingPlusMultiStackItem("earthleaf");
    public final static Item earthSeeds = new CookingPlusEasySeed("earthseeds", blockEarthCrop, Blocks.FARMLAND);
    public final static Block blockFireCrop = new CookingPlusEasyMutantCrop("firecrop");
    public final static Item fireLeaf = new CookingPlusMultiStackItem("fireleaf");
    public final static Item fireSeeds = new CookingPlusEasySeed("fireseeds", blockFireCrop, Blocks.FARMLAND);
    public final static Block blockWaterCrop = new CookingPlusEasyMutantCrop("watercrop");
    public final static Item waterLeaf = new CookingPlusMultiStackItem("waterleaf");
    public final static Item waterSeeds = new CookingPlusEasySeed("waterseeds", blockWaterCrop, Blocks.FARMLAND);
    
    public final static Block blockOneMutantCrop = new TierOneMutantCrop();
    public final static Item onemutantSeeds = new CookingPlusEasySeed("onemutantseeds", blockOneMutantCrop, Blocks.FARMLAND);
    public final static Block blockTwoMutantCrop = new TierTwoMutantCrop();
    public final static Item twomutantSeeds = new CookingPlusEasySeed("twomutantseeds", blockTwoMutantCrop, Blocks.FARMLAND);
    public final static Block blockThreeMutantCrop = new TierThreeMutantCrops();
    public final static Item threemutantSeeds = new CookingPlusEasySeed("threemutantseeds", blockThreeMutantCrop, Blocks.FARMLAND);
    public final static Block blockFourMutantCrop = new TierFourMutantCrops();
    public final static Item fourmutantSeeds = new CookingPlusEasySeed("fourmutantseeds", blockFourMutantCrop, Blocks.FARMLAND);
    public final static Block blockFiveMutantCrop = new TierFiveMutantCrops();
    public final static Item fivemutantSeeds = new CookingPlusEasySeed("fivemutantseeds", blockFiveMutantCrop, Blocks.FARMLAND);
    
    public final static Item aircrystalshards = new CookingPlusMultiStackItem("aircrystalshards");
    public final static Item watercrystalshards = new CookingPlusMultiStackItem("watercrystalshards");
    public final static Item earthcrystalshards = new CookingPlusMultiStackItem("earthcrystalshards");
    public final static Item firecrystalshards = new CookingPlusMultiStackItem("firecrystalshards");
    public final static Item pristineaircrystal = new CookingPlusMultiStackItem("pristineaircrystal");
    public final static Item pristineearthcrystal = new CookingPlusMultiStackItem("pristineearthcrystal");
    public final static Item pristinefirecrystal = new CookingPlusMultiStackItem("pristinefirecrystal");
    public final static Item pristinewatercrystal = new CookingPlusMultiStackItem("pristinewatercrystal");
    public final static Item uraniumchunk = new CookingPlusMultiStackItem("uraniumchunk");
    
    public static Potion myTestPotion;
    
    //custom rendered blocks?
    public final static Block blockGrapeCrop = new CookingPlusGrapeCrop();
    public final static Block blockHopCrop = new CookingPlusHopsCrop();
    public final static Block blockVanillaCrop = new CookingPlusVanillaCrop();
    
    //biome declarations
    public static Biome orchardBiome;
    public static Biome bambooBiome;
    public static Biome kelpBiome;
    public static Biome coralBiome;
    public static Biome tropicalBiome;
    public static Biome deepreefbiome;
    
    public static Biome myOceanA;
    public static Biome myOceanB;
    
  //Use a custom item as an icon (assuming it is instantiated in a class called ModItems)
    public static CreativeTabs tabCustom = new CreativeTabs("tabAgriculturalRevolution") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return cookedprawn;
        }
    };
    
    CookingPlusEventHandler events = new CookingPlusEventHandler();
    
    @Instance
    public static CookingPlusMain instance = new CookingPlusMain();
    
    @SidedProxy(clientSide="CookingPlus.ClientProxy", serverSide="CookingPlus.ServerProxy")
	public static CommonProxy proxy;
	
    @EventHandler
	public void preInit(FMLPreInitializationEvent e) {
    	
    	FMLCommonHandler.instance().bus().register(events);
        MinecraftForge.EVENT_BUS.register(events);
        
        
        CookingPlusConfig myConfig = new CookingPlusConfig();
        myConfig.PreInt(e);
        CookingPlusLootHelper.instance().CookingPlusLootHelperInit();
        //System.out.println("Pre-Generating Floating Islands");
        //CookingPlusIslandHelper.PregenerateIslands();
        
        //Orchard Biome
        Biome.BiomeProperties properties = new Biome.BiomeProperties("Orchard").setRainfall(0.3f).setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(0.8F);
        orchardBiome = new CookingPlusOrchardBiome(properties);
        if(CookingPlusConfig.OrchardSpawnWeight > 0){
        	Biome.registerBiome(CookingPlusConfig.OrchardID, "orchard", orchardBiome);
        }
        //BambooBiome
        properties = new Biome.BiomeProperties("Bamboo Grove").setRainfall(0.6f).setBaseHeight(0.45F).setHeightVariation(0.3F).setTemperature(0.6F);
        bambooBiome = new CookingPlusBambooBiome(properties);
        if(CookingPlusConfig.BambooGroveSpawnWeight > 0){
        	Biome.registerBiome(CookingPlusConfig.BambooGroveID, "bamboo_grove", bambooBiome);
        }
        //Kelp Biome
        properties = new Biome.BiomeProperties("Kelp Forest").setRainfall(0.6f).setBaseHeight(-1.0F).setHeightVariation(0.1F).setTemperature(0.6F);
        kelpBiome = new CookingPlusKelpForestBiome(properties);
        if(CookingPlusConfig.KelpForestSpawnWeight > 0){
        	Biome.registerBiome(CookingPlusConfig.KelpForestID, "kelp_forest", kelpBiome);
        }
        //Coral Biome
        properties = new Biome.BiomeProperties("Coral Reef").setRainfall(0.6f).setBaseHeight(-1.2F).setHeightVariation(0.1F).setTemperature(0.6F);
        coralBiome = new CookingPlusCoralReefBiome(properties);
        if(CookingPlusConfig.CoralReefSpawnWeight > 0){
        	Biome.registerBiome(CookingPlusConfig.CoralReefID, "coral_reef", coralBiome);
        }
        //tropical biome
        properties = new Biome.BiomeProperties("Tropical Hills").setRainfall(0.1f).setBaseHeight(0.45F).setHeightVariation(0.3F).setTemperature(0.8F);
        tropicalBiome = new CookingPlusTropicalBiome(properties);
        if(CookingPlusConfig.TropicalSpawnWeight > 0){
        	Biome.registerBiome(CookingPlusConfig.TropicalID, "tropical_hills", tropicalBiome);
        }
        //deep reef biome
        properties = new Biome.BiomeProperties("Deep Reef").setRainfall(0.6f).setBaseHeight(-1.97F).setHeightVariation(0.01F).setTemperature(0.6F);
        deepreefbiome = new CookingPlusDeepReefBiome(properties);
        if(CookingPlusConfig.DeepReefSpawnWeight > 0){
        	Biome.registerBiome(CookingPlusConfig.DeepReefID, "deep_reef", deepreefbiome);
        }
        
        if(CookingPlusConfig.OverwriteMushroomBiomes){
        	myOceanA = new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(-1.0F).setHeightVariation(0.1F));
        	myOceanB = new BiomeOcean((new Biome.BiomeProperties("Ocean")).setBaseHeight(-1.0F).setHeightVariation(0.1F));
        	Biome.registerBiome(14, "oceanA", myOceanA);
        	Biome.registerBiome(15, "oceanB", myOceanB);
        }
      	GameRegistry.registerBlock(blockGrapeCrop, null, "grapecrop");
      	GameRegistry.registerBlock(blockHopCrop, null, "hopcrop");
      	GameRegistry.registerBlock(blockVanillaCrop, null, "vanillacrop");
      	
    	//entities
    	GameRegistry.registerTileEntity(BrickOvenTileEntity.class, MODID+"brickoven");
    	GameRegistry.registerTileEntity(ButterChurnTileEntity.class, MODID+"butterchurn");
    	GameRegistry.registerTileEntity(OilPressTileEntity.class, MODID+"oilpress");
    	GameRegistry.registerTileEntity(FermenterTileEntity.class, MODID+"fermenter");
    	GameRegistry.registerTileEntity(MarketBoxTileEntity.class, MODID+"marketbox");
    	GameRegistry.registerTileEntity(TeapotTileEntity.class, MODID+"teapot");
    	GameRegistry.registerTileEntity(UnfiredTeapotTileEntity.class, MODID+"unfiredteapot");
    	GameRegistry.registerTileEntity(HeaterTileEntity.class, MODID+"heater");
    	GameRegistry.registerTileEntity(OrnateChestTileEntity.class, MODID+"ornatechest");
    	GameRegistry.registerTileEntity(PlateTileEntity.class, MODID+"plate");
    	GameRegistry.registerTileEntity(UnfiredPlateTileEntity.class, MODID+"unfiredplate");
    	GameRegistry.registerTileEntity(FryingPanTileEntity.class, MODID+"fryingpan");
    	GameRegistry.registerTileEntity(UnfiredFryingPanTileEntity.class, MODID+"unfiredfryingpan");
    	GameRegistry.registerTileEntity(SheetPressTileEntity.class, MODID+"sheetpress");
    	GameRegistry.registerTileEntity(SpongeTileEntity.class, MODID+"vanillablock");
    	GameRegistry.registerTileEntity(VanillaTileEntity.class, MODID+"spongeblock");
    	GameRegistry.registerTileEntity(NetBlockTileEntity.class, MODID+"netblock");
    	GameRegistry.registerTileEntity(DryingRackTileEntity.class, MODID+"dryingrack");
    	GameRegistry.registerTileEntity(LiquidBarrelTileEntity.class, MODID+"liquidbarrel");
    	GameRegistry.registerTileEntity(SaucepanTileEntity.class, MODID+"saucepan");
    	GameRegistry.registerTileEntity(UnfiredSaucepanTileEntity.class, MODID+"unfiredsaucepan");
    	GameRegistry.registerTileEntity(IceBoxTileEntity.class, MODID+"icebox");
    	GameRegistry.registerTileEntity(HydrophonicTileEntity.class, MODID+"hydrophonic");
    	GameRegistry.registerTileEntity(VatTileEntity.class, MODID+"vat");
    	GameRegistry.registerTileEntity(BotTileEntity.class, MODID+"bot");
    	GameRegistry.registerTileEntity(CookingPlusGrowthCrystalTileEntity.class, MODID+"growthcrystal");
    	GameRegistry.registerTileEntity(CookingPlusWaterCrystalTileEntity.class, MODID+"watercrystal");
    	GameRegistry.registerTileEntity(CookingPlusLightCrystalTileEntity.class, MODID+"lightcrystal");
    	GameRegistry.registerTileEntity(CookingPlusSkyCrystalTileEntity.class, MODID+"skycrystal");
    	GameRegistry.registerTileEntity(GrabberTileEntity.class, MODID+"grabber");
    	GameRegistry.registerTileEntity(FisherTileEntity.class, MODID+"fisher");
    	GameRegistry.registerTileEntity(CookingPlusGathererTileEntity.class, MODID+"gatherer");
    	
    	GameRegistry.registerTileEntity(LoggerTileEntity.class, MODID+"logger");
    	GameRegistry.registerTileEntity(DesalinatorTileEntity.class, MODID+"desalinator");
    	GameRegistry.registerTileEntity(PlanterTileEntity.class, MODID+"planter");
    	GameRegistry.registerTileEntity(GoldBotTileEntity.class, MODID+"goldbot");
    	GameRegistry.registerTileEntity(LaserDroneBayTileEntity.class, MODID+"laserdronebay");
    	GameRegistry.registerTileEntity(CookingPlusSpeedBlockTileEntity.class, MODID+"speedblock");
    	GameRegistry.registerTileEntity(CookingPlusRangeBlockTileEntity.class, MODID+"rangeblock");
    	GameRegistry.registerTileEntity(CookingPlusGoldenSpeedBlockTileEntity.class, MODID+"goldenspeedblock");
    	GameRegistry.registerTileEntity(CookingPlusGoldenRangeBlockTileEntity.class, MODID+"goldenrangeblock");
    	
    	GameRegistry.registerTileEntity(BatteryBlockTileEntity.class, MODID+"batteryblock");
    	GameRegistry.registerTileEntity(LeyLineReceiverTileEntity.class, MODID+"leylinereceiver");
    	GameRegistry.registerTileEntity(LeyLineGeneratorTileEntity.class, MODID+"leylinegenerator");
    	GameRegistry.registerTileEntity(LeyLinePropagatorTileEntity.class, MODID+"leylinepropagator");
    	GameRegistry.registerTileEntity(LeyDesynthTileEntity.class, MODID+"leydesynth");
    	GameRegistry.registerTileEntity(MutationStationTileEntity.class, MODID+"mutationstation");
    	GameRegistry.registerTileEntity(DiamondBotTileEntity.class, MODID+"diamondbot");
    	GameRegistry.registerTileEntity(FishTankTileEntity.class, MODID+"fishtank");
    	GameRegistry.registerTileEntity(CookingPlusDiamondSpeedBlockTileEntity.class, MODID+"diamondspeedblock");
    	GameRegistry.registerTileEntity(CookingPlusDiamondRangeBlockTileEntity.class, MODID+"diamondrangeblock");
    	GameRegistry.registerTileEntity(AnalyserTileEntity.class, MODID+"analyser");
    	GameRegistry.registerTileEntity(InscriberTileEntity.class, MODID+"inscriber");
    	GameRegistry.registerTileEntity(ResearchLabTileEntity.class, MODID+"researchlab");
		
    	addPotions();
    	RegisterDimensions();
		this.proxy.preInit(e);
	}
    
    @EventHandler
	public void init(FMLInitializationEvent e) {
		System.out.println("The Agricultural Revolution Intialised");
		
		//biomes
		if(CookingPlusConfig.OrchardSpawnWeight > 0){
      	BiomeDictionary.registerBiomeType(orchardBiome, Type.FOREST, Type.LUSH);
      	BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(orchardBiome,CookingPlusConfig.OrchardSpawnWeight));
		}
      	
      	if(CookingPlusConfig.BambooGroveSpawnWeight > 0){
      	BiomeDictionary.registerBiomeType(bambooBiome, Type.FOREST, Type.LUSH);
      	BiomeManager.addSpawnBiome(bambooBiome);
      	BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(bambooBiome,CookingPlusConfig.BambooGroveSpawnWeight));
      	}
      	
      	if(CookingPlusConfig.TropicalSpawnWeight > 0){
      	BiomeDictionary.registerBiomeType(tropicalBiome, Type.HOT, Type.DRY);
      	BiomeManager.addSpawnBiome(tropicalBiome);
      	BiomeManager.addBiome(BiomeType.DESERT, new BiomeEntry(tropicalBiome,CookingPlusConfig.TropicalSpawnWeight));
      	}
      	
      	if(CookingPlusConfig.KelpForestSpawnWeight > 0){
      	BiomeDictionary.registerBiomeType(kelpBiome, Type.OCEAN);
      	BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(kelpBiome,CookingPlusConfig.KelpForestSpawnWeight));
      	}
      	
      	if(CookingPlusConfig.CoralReefSpawnWeight > 0){
      	BiomeDictionary.registerBiomeType(coralBiome, Type.OCEAN);
      	BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(coralBiome,CookingPlusConfig.CoralReefSpawnWeight));
      	}
      	
      	if(CookingPlusConfig.DeepReefSpawnWeight > 0){
      	BiomeDictionary.registerBiomeType(deepreefbiome, Type.OCEAN);
      	BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(deepreefbiome, CookingPlusConfig.DeepReefSpawnWeight));
      	}
      	
      	
		
		AddExtraBlockData();
		RegisterDictionary();
		if(CookingPlusConfig.vanillarecipes == true){
			removeCraftingRecipe(Items.BREAD);
			removeCraftingRecipe(Items.CAKE);
			removeCraftingRecipe(Items.COOKIE);
		
			removeFurnaceRecipe(new ItemStack(Items.COOKED_CHICKEN));
			removeFurnaceRecipe(new ItemStack(Items.COOKED_BEEF));
			removeFurnaceRecipe(new ItemStack(Items.COOKED_FISH));
			removeFurnaceRecipe(new ItemStack(Items.COOKED_PORKCHOP));
			removeFurnaceRecipe(new ItemStack(Items.BAKED_POTATO));
			removeFurnaceRecipe(new ItemStack(Items.COOKED_MUTTON));
			removeFurnaceRecipe(new ItemStack(Items.COOKED_RABBIT));
		}
		
		//recipes
		GameRegistry.addShapelessRecipe(new ItemStack(chilliseed, 2), new Object[] {new ItemStack(chilli)});
		GameRegistry.addShapelessRecipe(new ItemStack(onionseed, 2), new Object[] {new ItemStack(onion)});
		GameRegistry.addShapelessRecipe(new ItemStack(grapeseed, 2), new Object[] {new ItemStack(grape)});
		GameRegistry.addShapelessRecipe(new ItemStack(rawprawn), new Object[] {new ItemStack(shelledprawn)});
		GameRegistry.addShapelessRecipe(new ItemStack(flour), new Object[] {new ItemStack(pestle), new ItemStack(Items.WHEAT)});
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(cakebatter), new Object[] {new ItemStack(caketin), new ItemStack(Items.MILK_BUCKET), new ItemStack(Items.EGG), "materialFlour", new ItemStack(Items.SUGAR)}));
		//this need to be ore dic for salt 
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(dough), new Object[] {new ItemStack(breadtin), new ItemStack(Items.MILK_BUCKET), "dustSalt", "materialFlour", new ItemStack(Items.SUGAR), new ItemStack(butternugget)}));
		GameRegistry.addShapelessRecipe(new ItemStack(butternugget, 9), new Object[] {new ItemStack(butteringot)});
		GameRegistry.addShapelessRecipe(new ItemStack(butteringot, 9), new Object[] {new ItemStack(Item.getItemFromBlock(blockButter))});
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(cookiebatter), new Object[] {new ItemStack(Items.BOWL), new ItemStack(Items.MILK_BUCKET), new ItemStack(chocolate), "materialFlour", new ItemStack(Items.SUGAR), new ItemStack(butternugget)}));
		GameRegistry.addShapelessRecipe(new ItemStack(vanillabuttercream), new Object[] {new ItemStack(Items.BOWL), new ItemStack(vanillaessence), new ItemStack(Items.SUGAR), new ItemStack(butternugget)});
		GameRegistry.addShapelessRecipe(new ItemStack(rawoyster), new Object[] {new ItemStack(shelledoyster)});
		GameRegistry.addShapelessRecipe(new ItemStack(rawcrab), new Object[] {new ItemStack(shelledcrab)});
		GameRegistry.addShapelessRecipe(new ItemStack(rawlobster), new Object[] {new ItemStack(shelledlobster)});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.getItemFromBlock(blockPalmPlanks), 4), new Object[] {new ItemStack(Item.getItemFromBlock(blockPalmLog))});
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(bananadough), new Object[] {new ItemStack(breadtin), new ItemStack(Items.EGG), new ItemStack(bananaslice), "materialFlour", new ItemStack(Items.SUGAR), new ItemStack(butternugget)}));
		
		GameRegistry.addShapelessRecipe(new ItemStack(vanillaicecreammix), new Object[] {new ItemStack(Items.BOWL), new ItemStack(Items.MILK_BUCKET), new ItemStack(creambucket), new ItemStack(vanillaessence), new ItemStack(Items.SUGAR)});
		GameRegistry.addShapelessRecipe(new ItemStack(minticecreammix), new Object[] {new ItemStack(Items.BOWL), new ItemStack(Items.MILK_BUCKET), new ItemStack(creambucket), new ItemStack(mintessence), new ItemStack(Items.SUGAR)});
		GameRegistry.addShapelessRecipe(new ItemStack(strawberryicecreammix), new Object[] {new ItemStack(Items.BOWL), new ItemStack(Items.MILK_BUCKET), new ItemStack(creambucket), new ItemStack(strawberryjuice), new ItemStack(Items.SUGAR)});
		GameRegistry.addShapelessRecipe(new ItemStack(chocolateicecreammix), new Object[] {new ItemStack(Items.BOWL), new ItemStack(Items.MILK_BUCKET), new ItemStack(creambucket), new ItemStack(chocolate), new ItemStack(Items.SUGAR)});
		GameRegistry.addShapelessRecipe(new ItemStack(lemonicecreammix), new Object[] {new ItemStack(Items.BOWL), new ItemStack(Items.MILK_BUCKET), new ItemStack(creambucket), new ItemStack(lemonjuice), new ItemStack(Items.SUGAR)});
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(bananaslice, 3), new Object[] {new ItemStack(knife), "foodBanana"}));
		
		
		//juices
		GameRegistry.addShapelessRecipe(new ItemStack(applejuice, 1), new Object[] {new ItemStack(juicer), new ItemStack(Items.APPLE), new ItemStack(Items.GLASS_BOTTLE)});
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(lemonjuice, 1), new Object[] {new ItemStack(juicer), "foodLemon", new ItemStack(Items.GLASS_BOTTLE)}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(limejuice, 1), new Object[] {new ItemStack(juicer), "foodLime", 	new ItemStack(Items.GLASS_BOTTLE)}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(peachjuice, 1), new Object[] {new ItemStack(juicer), "foodPeach", new ItemStack(Items.GLASS_BOTTLE)}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(blueberryjuice, 1), new Object[] {new ItemStack(juicer), "foodBlueberry", new ItemStack(Items.GLASS_BOTTLE)}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(gooseberryjuice, 1), new Object[] {new ItemStack(juicer), "foodGooseberry", new ItemStack(Items.GLASS_BOTTLE)}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(strawberryjuice, 1), new Object[] {new ItemStack(juicer), "foodStrawberry", new ItemStack(Items.GLASS_BOTTLE)}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(orangejuice, 1), new Object[] {new ItemStack(juicer), "foodOrange", new ItemStack(Items.GLASS_BOTTLE)}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(grapejuice, 1), new Object[] {new ItemStack(juicer), "foodGrape", new ItemStack(Items.GLASS_BOTTLE)}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(vanillaessence, 1), new Object[] {new ItemStack(pestle), "foodVanilla", new ItemStack(Items.GLASS_BOTTLE)}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(pineapplejuice, 1), new Object[] {new ItemStack(juicer), "foodPineapple", new ItemStack(Items.GLASS_BOTTLE)}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(kiwijuice, 1), new Object[] {new ItemStack(juicer), "foodKiwi", new ItemStack(Items.GLASS_BOTTLE)}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(mangojuice, 1), new Object[] {new ItemStack(juicer), "foodMango", new ItemStack(Items.GLASS_BOTTLE)}));
		GameRegistry.addShapelessRecipe(new ItemStack(mintessence, 1), new Object[] {new ItemStack(pestle), new ItemStack(mintleaf), new ItemStack(Items.GLASS_BOTTLE)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(unfiredjuicer, 1), new Object[] {new ItemStack(juicerguide), new ItemStack(Items.CLAY_BALL)});
		GameRegistry.addShapelessRecipe(new ItemStack(unfiredmug, 1), new Object[] {new ItemStack(mugguide), new ItemStack(Items.CLAY_BALL)});
		GameRegistry.addShapelessRecipe(new ItemStack(blockUnfiredPlate, 1), new Object[] {new ItemStack(plateguide), new ItemStack(Items.CLAY_BALL)});
		
		GameRegistry.addShapelessRecipe(new ItemStack(circleuncooked, 10), new Object[] {new ItemStack(circlecutter), new ItemStack(cookiebatter)});
		GameRegistry.addShapelessRecipe(new ItemStack(staruncooked, 10), new Object[] {new ItemStack(starcutter), new ItemStack(cookiebatter)});
		GameRegistry.addShapelessRecipe(new ItemStack(heartuncooked, 10), new Object[] {new ItemStack(heartcutter), new ItemStack(cookiebatter)});
		GameRegistry.addShapelessRecipe(new ItemStack(moonuncooked, 10), new Object[] {new ItemStack(mooncutter), new ItemStack(cookiebatter)});
		GameRegistry.addShapelessRecipe(new ItemStack(chocolate, 1), new Object[] {new ItemStack(cocoapowder), new ItemStack(Items.MILK_BUCKET), new ItemStack(Items.SUGAR), new ItemStack(butternugget)});
		GameRegistry.addShapelessRecipe(new ItemStack(cocoapowder, 1), new Object[] {new ItemStack(Items.DYE, 1, 3), new ItemStack(pestle)});
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(pancakemix), new Object[] {new ItemStack(Items.BOWL), new ItemStack(Items.MILK_BUCKET), "materialFlour", new ItemStack(Items.EGG), new ItemStack(vegetableoil)}));
		GameRegistry.addShapelessRecipe(new ItemStack(chocolatepancake, 1), new Object[] {new ItemStack(pancake), new ItemStack(chocolate)});
		GameRegistry.addShapelessRecipe(new ItemStack(sugarpancake, 1), new Object[] {new ItemStack(pancake), new ItemStack(Items.SUGAR)});
		GameRegistry.addShapelessRecipe(new ItemStack(lemonpancake, 1), new Object[] {new ItemStack(pancake), new ItemStack(lemonjuice)});
		GameRegistry.addShapelessRecipe(new ItemStack(creampancake, 1), new Object[] {new ItemStack(pancake), new ItemStack(creambucket)});
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(traysponge), new Object[] {new ItemStack(cupcaketray), new ItemStack(Items.MILK_BUCKET), "materialFlour", new ItemStack(Items.EGG), new ItemStack(Items.SUGAR), new ItemStack(vanillaessence)}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(traychocolate), new Object[] {new ItemStack(cupcaketray), new ItemStack(Items.MILK_BUCKET), "materialFlour", new ItemStack(Items.EGG), new ItemStack(Items.SUGAR), new ItemStack(chocolate)}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(trayvelvet), new Object[] {new ItemStack(cupcaketray), new ItemStack(Items.MILK_BUCKET), "materialFlour", new ItemStack(Items.EGG), new ItemStack(Items.SUGAR), new ItemStack(chocolate), new ItemStack(Items.DYE, 1, 1)}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(traylargesponge), new Object[] {new ItemStack(largecupcaketray), new ItemStack(Items.MILK_BUCKET), "materialFlour", new ItemStack(Items.EGG), new ItemStack(Items.SUGAR), new ItemStack(vanillaessence)}));
		
		GameRegistry.addShapelessRecipe(new ItemStack(vanillasponge, 1), new Object[] {new ItemStack(vanillabuttercream), new ItemStack(cherry), new ItemStack(plainspongecupcake)});
		GameRegistry.addShapelessRecipe(new ItemStack(vanillachocolate, 1), new Object[] {new ItemStack(vanillabuttercream), new ItemStack(cherry), new ItemStack(plainchocolatecupcake)});
		GameRegistry.addShapelessRecipe(new ItemStack(vanillavelvet, 1), new Object[] {new ItemStack(vanillabuttercream), new ItemStack(cherry), new ItemStack(plainredvelvetcupcake)});
		GameRegistry.addShapelessRecipe(new ItemStack(blockVanilla, 1), new Object[] {new ItemStack(vanillabuttercream), new ItemStack(cherry), new ItemStack(Item.getItemFromBlock(blockSponge))});
		
		GameRegistry.addShapelessRecipe(new ItemStack(seafoodplatter, 1), new Object[] {new ItemStack(driedseaweed), new ItemStack(cookedcrab), new ItemStack(cookedlobster), new ItemStack(cookedprawn)});
		GameRegistry.addShapelessRecipe(new ItemStack(breadcrumbs), new Object[] {new ItemStack(pestle), new ItemStack(Items.BREAD)});
		GameRegistry.addShapelessRecipe(new ItemStack(uncookedcrabcake), new Object[] {new ItemStack(cookedcrab), new ItemStack(Items.EGG), new ItemStack(breadcrumbs)});
		
		//salted
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(saltedpork, 1), new Object[] {new ItemStack(Items.COOKED_PORKCHOP), "dustSalt"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(saltedbeef, 1), new Object[] {new ItemStack(Items.COOKED_BEEF), "dustSalt"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(saltedprawn, 1), new Object[] {new ItemStack(cookedprawn), "dustSalt"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(saltedmutton, 1), new Object[] {new ItemStack(Items.COOKED_MUTTON), "dustSalt"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(saltedchicken, 1), new Object[] {new ItemStack(Items.COOKED_CHICKEN), "dustSalt"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(saltedrabbit, 1), new Object[] {new ItemStack(Items.COOKED_RABBIT), "dustSalt"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(saltedsquid, 1), new Object[] {new ItemStack(cookedsquid), "dustSalt"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(saltedoyster, 1), new Object[] {new ItemStack(cookedoyster), "dustSalt"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(saltedcrab, 1), new Object[] {new ItemStack(cookedcrab), "dustSalt"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(saltedlobster, 1), new Object[] {new ItemStack(cookedlobster), "dustSalt"}));
		
		GameRegistry.addRecipe(new ItemStack(fishingnet), new Object[] {"~#~", "###", "~#~", '#', new ItemStack(Items.STRING), '~', new ItemStack(Items.STICK)});
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(pestle), new Object[] {" ~ ", "#@#", " # ", '#', new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE)), '~', new ItemStack(Items.STICK), '@', "plankWood"}));
		GameRegistry.addRecipe(new ItemStack(rack), new Object[] {" # ", " # ", " # ", '#', new ItemStack(Item.getItemFromBlock(Blocks.IRON_BARS))});
		GameRegistry.addRecipe(new ItemStack(blockBrickOven), new Object[] {"~~~", "~#~", "~~~", '#', new ItemStack(rack), '~', new ItemStack(Items.BRICK)});
		GameRegistry.addRecipe(new ItemStack(knife), new Object[] {" #", "~ ", '#', new ItemStack(ironsheet), '~', new ItemStack(Items.STICK)});
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockButterChurn), new Object[] {" # ", "~#~", "~~~", '~', "plankWood", '#', new ItemStack(Items.STICK)}));
		GameRegistry.addRecipe(new ItemStack(blockButter), new Object[] {"###", "###", "###", '#', new ItemStack(butteringot)});
		GameRegistry.addRecipe(new ItemStack(butteringot), new Object[] {"###", "###", "###", '#', new ItemStack(butternugget)});
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockOilPress), new Object[] {"#~#", " ~ ", "###", '~', "plankWood", '#', Item.getItemFromBlock(Blocks.STONE)}));
		GameRegistry.addRecipe(new ItemStack(blockRope), new Object[] {" ~ ", " ~ ", " ~ ", '~', new ItemStack(Items.STRING)});
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockFermenter), new Object[] {"#~#", "#~#", "@_@", '~', new ItemStack(Items.GLASS_BOTTLE), '@', "plankWood", '_', new ItemStack(Item.getItemFromBlock(Blocks.IRON_BLOCK)), '#', new ItemStack(Items.IRON_INGOT)}));
		GameRegistry.addRecipe(new ItemStack(Items.STRING), new Object[] {" ~ ", " ~ ", " ~ ", '~', new ItemStack(cottonbud)});
		GameRegistry.addRecipe(new ItemStack(blockBambooBlock), new Object[] {"##", "##", '#', new ItemStack(Item.getItemFromBlock(blockBamboo))});
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockMarketBox), new Object[] {"   ", "~~~", "#~#", '#', "plankWood",'~', new ItemStack(Items.STICK)}));
		GameRegistry.addRecipe(new ItemStack(blockUnfiredTeapot), new Object[] {"###", "#~#", "###", '#', new ItemStack(Items.CLAY_BALL),  '~', new ItemStack(teapotguide)});
		GameRegistry.addRecipe(new ItemStack(blockHeater), new Object[] {"#~#", "###", '#', new ItemStack(Items.IRON_INGOT),  '~', new ItemStack(Item.getItemFromBlock(Blocks.FURNACE))});
		GameRegistry.addRecipe(new ItemStack(blockUnfiredFryingPan), new Object[] {"###", "#~#", "###", '#', new ItemStack(Items.CLAY_BALL),  '~', new ItemStack(fryingpanguide)});
		GameRegistry.addRecipe(new ItemStack(cupcaketrayunfiredmold), new Object[] {"#~#", '#', new ItemStack(Items.CLAY_BALL),  '~', new ItemStack(cuptrayguide)});
		GameRegistry.addRecipe(new ItemStack(largecupcaketrayunfiredmold), new Object[] {"###", "#~#", "###", '#', new ItemStack(Items.CLAY_BALL),  '~', new ItemStack(largecuptrayguide)});
		GameRegistry.addRecipe(new ItemStack(blockSheetPress), new Object[] {"#@#", "~ ~", "#@#", '#', new ItemStack(Items.GOLD_INGOT),  '~', new ItemStack(Items.IRON_INGOT), '@', new ItemStack(Item.getItemFromBlock(Blocks.IRON_BLOCK))});
		GameRegistry.addRecipe(new ItemStack(ironsheet, 4), new Object[] {"##", "##", '#', new ItemStack(Items.IRON_INGOT)});
		GameRegistry.addRecipe(new ItemStack(blockCoralRockSmooth, 4), new Object[] {"##", "##", '#', new ItemStack(Item.getItemFromBlock(blockCoralRock))});
		GameRegistry.addRecipe(new ItemStack(blockCoralRockBrick, 4), new Object[] {"##", "##", '#', new ItemStack(Item.getItemFromBlock(blockCoralRockSmooth))});
		GameRegistry.addRecipe(new ItemStack(blockNetBlock), new Object[] {"#~#", "~#~", "#~#", '#', new ItemStack(fishingnet),  '~', new ItemStack(Items.STRING)});
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockDryingRack), new Object[] {" ~#", " ##", "~##", '#', "plankWood",  '~', new ItemStack(Items.STICK)}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockLiquidBarrel), new Object[] {"# #", "# #", "~#~", '~', "plankWood",  '#', new ItemStack(Items.STICK)}));
		
		GameRegistry.addRecipe(new ItemStack(blockUnfiredSaucePan), new Object[] {"###", "#~#", "###", '#', new ItemStack(Items.CLAY_BALL),  '~', new ItemStack(saucepanguide)});
		GameRegistry.addRecipe(new ItemStack(blockBasaltSmooth, 4), new Object[] {"##", "##", '#', new ItemStack(Item.getItemFromBlock(blockBasalt))});
		GameRegistry.addRecipe(new ItemStack(unfiredbreadtinmold), new Object[] {"#~#", '#', new ItemStack(Items.CLAY_BALL),  '~', new ItemStack(breadtinguide)});
		GameRegistry.addRecipe(new ItemStack(unfiredcaketinmold), new Object[] {"#~#", '#', new ItemStack(Items.CLAY_BALL),  '~', new ItemStack(caketinguide)});
		GameRegistry.addRecipe(new ItemStack(blockIceBox), new Object[] {"~~~", "~#~", "~~~", '#', new ItemStack(Item.getItemFromBlock(Blocks.CHEST)), '~', new ItemStack(Item.getItemFromBlock(Blocks.SNOW))});
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(woodenscythe), new Object[] {"~~#", " # ", "#  ", '#', new ItemStack(Items.STICK), '~', "plankWood"}));
		GameRegistry.addRecipe(new ItemStack(stonescythe), new Object[] {"~~#", " # ", "#  ", '#', new ItemStack(Items.STICK), '~', new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE))});
		GameRegistry.addRecipe(new ItemStack(ironscythe), new Object[] {"~~#", " # ", "#  ", '#', new ItemStack(Items.STICK), '~', new ItemStack(Items.IRON_INGOT)});
		GameRegistry.addRecipe(new ItemStack(goldscythe), new Object[] {"~~#", " # ", "#  ", '#', new ItemStack(Items.STICK), '~', new ItemStack(Items.GOLD_INGOT)});
		GameRegistry.addRecipe(new ItemStack(diamondscythe), new Object[] {"~~#", " # ", "#  ", '#', new ItemStack(Items.STICK), '~', new ItemStack(Items.DIAMOND)});
		GameRegistry.addShapelessRecipe(new ItemStack(pricklypearpeeled), new Object[] {new ItemStack(pricklypear)});
		GameRegistry.addShapelessRecipe(new ItemStack(onigiri), new Object[] {new ItemStack(rice), new ItemStack(driedseaweed)});
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(sushiroll), new Object[] {"A", "B", "C", 'A', new ItemStack(Items.COOKED_FISH), 'B', "foodRice", 'C', new ItemStack(driedseaweed)}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(prawnsushi), new Object[] {"A", "B", 'A', new ItemStack(cookedprawn), 'B', "foodRice"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(californiaroll), new Object[] {"A", "B", 'A', "foodAvocado", 'B', "foodRice"}));
		
		//science
		GameRegistry.addRecipe(new ItemStack(blockHydrophonic), new Object[] {"ABA", "CDC", "CEC", 'B', new ItemStack(Item.getItemFromBlock(Blocks.DAYLIGHT_DETECTOR)), 'A', new ItemStack(Item.getItemFromBlock(Blocks.REDSTONE_LAMP)), 'C', new ItemStack(ironsheet), 'D', new ItemStack(redstoneprocessor), 'E', new ItemStack(Item.getItemFromBlock(Blocks.DIRT))});
		GameRegistry.addRecipe(new ItemStack(blockBot), new Object[] {"ABA", "CDC", "AEA", 'B', new ItemStack(battery), 'A', new ItemStack(ironsheet), 'C', new ItemStack(redstoneprocessor), 'D', new ItemStack(diamondprocessor), 'E', new ItemStack(ironprocessor)});
		GameRegistry.addRecipe(new ItemStack(blockVat), new Object[] {"ABA", "CDC", "AEA", 'B', new ItemStack(Item.getItemFromBlock(Blocks.GLASS)), 'A', new ItemStack(ironsheet), 'C', new ItemStack(redstoneprocessor), 'D', new ItemStack(ironprocessor), 'E', new ItemStack(Item.getItemFromBlock(Blocks.IRON_BLOCK))});
		GameRegistry.addRecipe(new ItemStack(redstonesheet, 4), new Object[] {"##", "##", '#', new ItemStack(Items.REDSTONE)});
		GameRegistry.addRecipe(new ItemStack(siliconsheet, 4), new Object[] {"##", "##", '#', new ItemStack(silicondust)});
		GameRegistry.addRecipe(new ItemStack(diamondsheet, 4), new Object[] {"##", "##", '#', new ItemStack(Items.DIAMOND)});
		GameRegistry.addRecipe(new ItemStack(goldsheet, 4), new Object[] {"##", "##", '#', new ItemStack(Items.GOLD_INGOT)});
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(goldwire, 6), new Object[] {"###", '#', "ingotGold"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(copperwire, 6), new Object[] {"###", '#', "ingotCopper"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(zincwire, 6), new Object[] {"###", '#', "ingotZinc"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(zincsheet, 4), new Object[] {"##", "##", '#', "ingotZinc"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(coppersheet, 4), new Object[] {"##", "##", '#', "ingotCopper"}));
		GameRegistry.addRecipe(new ItemStack(uncasedchip, 1), new Object[] {"#~", '#', new ItemStack(goldwire), '~', new ItemStack(siliconchip)});
		GameRegistry.addRecipe(new ItemStack(needle), new Object[] {"  C", " B ", "A  ", 'C', new ItemStack(Items.IRON_INGOT), 'A', new ItemStack(Items.STICK), 'B', new ItemStack(Item.getItemFromBlock(Blocks.GLASS))});
		GameRegistry.addRecipe(new ItemStack(blockGrabber), new Object[] {"DBD", "CEC", "ADA", 'B', new ItemStack(Item.getItemFromBlock(Blocks.REDSTONE_TORCH)), 'A', new ItemStack(ironsheet), 'C', new ItemStack(redstoneprocessor), 'D', new ItemStack(Item.getItemFromBlock(Blocks.PISTON)), 'E', new ItemStack(ironprocessor)});
		GameRegistry.addRecipe(new ItemStack(blockFisher), new Object[] {"DBD", "CEC", "ADA", 'B', new ItemStack(Item.getItemFromBlock(Blocks.REDSTONE_TORCH)), 'A', new ItemStack(ironsheet), 'C', new ItemStack(redstoneprocessor), 'D', new ItemStack(fishingnet), 'E', new ItemStack(ironprocessor)});
		GameRegistry.addRecipe(new ItemStack(blockNetworkBlock, 3), new Object[] {"ACA", "BCB", "ADA", 'A', new ItemStack(ironsheet), 'B', new ItemStack(goldwire), 'C', new ItemStack(copperwire), 'D', new ItemStack(Items.COMPARATOR)});
		GameRegistry.addRecipe(new ItemStack(blockGatherer), new Object[] {"DBD", "BCB", "DAD", 'B', new ItemStack(ironscythe), 'A', new ItemStack(ironprocessor), 'C', new ItemStack(redstoneprocessor), 'D', new ItemStack(ironsheet)});
		GameRegistry.addRecipe(new ItemStack(unfiredchipmoldmold), new Object[] {"###", "#~#", "###", '#', new ItemStack(Items.CLAY_BALL),  '~', new ItemStack(chipguide)});
		//0.8 Tech Things
		GameRegistry.addRecipe(new ItemStack(blockPlanter), new Object[] {"DBD", "BCB", "DAD", 'B', new ItemStack(Item.getItemFromBlock(Blocks.DROPPER)), 'A', new ItemStack(ironprocessor), 'C', new ItemStack(redstoneprocessor), 'D', new ItemStack(ironsheet)});
		GameRegistry.addRecipe(new ItemStack(blockLogger), new Object[] {"DBD", "BCB", "DAD", 'B', new ItemStack(Items.IRON_AXE), 'A', new ItemStack(ironprocessor), 'C', new ItemStack(redstoneprocessor), 'D', new ItemStack(ironsheet)});
		GameRegistry.addRecipe(new ItemStack(blockDesalinator), new Object[] {"DED", "BCF", "DAD", 'B', new ItemStack(zincsheet), 'A', new ItemStack(ironprocessor), 'C', new ItemStack(redstoneprocessor), 'D', new ItemStack(ironsheet), 'E', new ItemStack(battery), 'F', new ItemStack(coppersheet)});
		GameRegistry.addRecipe(new ItemStack(battery), new Object[] {"ABA", "C #", '#', new ItemStack(zincwire), 'A', new ItemStack(ironsheet), 'B', new ItemStack(vinegar), 'C', new ItemStack(copperwire)});
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(vinegar, 1), new Object[] {new ItemStack(wine)}));
		GameRegistry.addRecipe(new ItemStack(blockGoldBot), new Object[] {"ABA", "CDC", "BAB", 'B', new ItemStack(goldsheet), 'A', new ItemStack(goldprocessor), 'C', new ItemStack(battery), 'D', new ItemStack(Item.getItemFromBlock(blockBot)), 'E', new ItemStack(battery)});
		GameRegistry.addRecipe(new ItemStack(blockLaserDroneBay), new Object[] {"ABA", "CDC", "EBE", 'B', new ItemStack(Item.getItemFromBlock(blockBot)), 'A', new ItemStack(ironsheet), 'C', new ItemStack(ironprocessor), 'D', new ItemStack(diamondprocessor)});
		GameRegistry.addRecipe(new ItemStack(blockGoldenRangeBlock), new Object[] {"ABA", "CDC", "BAB", 'B', new ItemStack(goldsheet), 'A', new ItemStack(goldprocessor), 'C', new ItemStack(battery), 'D', new ItemStack(Item.getItemFromBlock(blockRangeBlock))});
		GameRegistry.addRecipe(new ItemStack(blockGoldenSpeedBlock), new Object[] {"ABA", "CDC", "BAB", 'B', new ItemStack(goldsheet), 'A', new ItemStack(goldprocessor), 'C', new ItemStack(battery), 'D', new ItemStack(Item.getItemFromBlock(blockSpeedBlock))});
		GameRegistry.addRecipe(new ItemStack(blockSpeedBlock), new Object[] {"ABA", "CDC", "ABA", 'B', new ItemStack(goldprocessor), 'A', new ItemStack(ironsheet), 'C', new ItemStack(battery), 'D', new ItemStack(Item.getItemFromBlock(Blocks.GOLDEN_RAIL))});
		GameRegistry.addRecipe(new ItemStack(blockRangeBlock), new Object[] {"ABA", "CDC", "ABA", 'B', new ItemStack(goldprocessor), 'A', new ItemStack(ironsheet), 'C', new ItemStack(battery), 'D', new ItemStack(Item.getItemFromBlock(Blocks.HOPPER))});
		//0.9 things
		GameRegistry.addRecipe(new ItemStack(pristineaircrystal), new Object[] {"###", "#A#", "###", '#', new ItemStack(aircrystalshards),  'A', new ItemStack(Items.QUARTZ)});
		GameRegistry.addRecipe(new ItemStack(pristineearthcrystal), new Object[] {"###", "#A#", "###", '#', new ItemStack(earthcrystalshards),  'A', new ItemStack(Items.QUARTZ)});
		GameRegistry.addRecipe(new ItemStack(pristinefirecrystal), new Object[] {"###", "#A#", "###", '#', new ItemStack(firecrystalshards),  'A', new ItemStack(Items.QUARTZ)});
		GameRegistry.addRecipe(new ItemStack(pristinewatercrystal), new Object[] {"###", "#A#", "###", '#', new ItemStack(watercrystalshards),  'A', new ItemStack(Items.QUARTZ)});
		GameRegistry.addRecipe(new ItemStack(blockDiamondBot), new Object[] {"ABA", "CDC", "BAB", 'B', new ItemStack(diamondsheet), 'A', new ItemStack(diamondprocessor), 'C', new ItemStack(battery), 'D', new ItemStack(Item.getItemFromBlock(blockGoldBot)), 'E', new ItemStack(battery)});
		GameRegistry.addRecipe(new ItemStack(blockMutationStation), new Object[] {"#~~", "IPI", "III", '#', new ItemStack(Items.IRON_INGOT), '~', new ItemStack(Items.GLASS_BOTTLE), 'I', new ItemStack(ironsheet), 'P', new ItemStack(diamondprocessor)});
		GameRegistry.addRecipe(new ItemStack(blockFishTank), new Object[] {"ICI", "IGI", "ICI", 'I', new ItemStack(ironsheet), 'C', new ItemStack(coppersheet), 'G', new ItemStack(Item.getItemFromBlock(Blocks.GLASS))});
		GameRegistry.addRecipe(new ItemStack(blockDiamondRangeBlock), new Object[] {"ABA", "CDC", "BAB", 'B', new ItemStack(diamondsheet), 'A', new ItemStack(diamondprocessor), 'C', new ItemStack(battery), 'D', new ItemStack(Item.getItemFromBlock(blockGoldenRangeBlock))});
		GameRegistry.addRecipe(new ItemStack(blockDiamondSpeedBlock), new Object[] {"ABA", "CDC", "BAB", 'B', new ItemStack(diamondsheet), 'A', new ItemStack(diamondprocessor), 'C', new ItemStack(battery), 'D', new ItemStack(Item.getItemFromBlock(blockGoldenSpeedBlock))});
		
		//ley Things
		GameRegistry.addRecipe(new ItemStack(blockLeyGenerator), new Object[] {"#@#", "@~@", "#@#", '#', new ItemStack(ironsheet), '~', new ItemStack(mysteriousorb), '@', new ItemStack(firecrystalshards)});
		GameRegistry.addRecipe(new ItemStack(blockLeyPropagator), new Object[] {"#@#", "@~@", "#@#", '#', new ItemStack(ironsheet), '~', new ItemStack(mysteriousorb), '@', new ItemStack(aircrystalshards)});
		GameRegistry.addRecipe(new ItemStack(blockLeyReceiver), new Object[] {"#@#", "@~@", "#@#", '#', new ItemStack(ironsheet), '~', new ItemStack(mysteriousorb), '@', new ItemStack(watercrystalshards)});
		GameRegistry.addRecipe(new ItemStack(blockBattery), new Object[] {"#@#", "@~@", "#@#", '#', new ItemStack(ironsheet), '~', new ItemStack(ironprocessor), '@', new ItemStack(battery)});
		GameRegistry.addRecipe(new ItemStack(blockLeyDesynth), new Object[] {"Z~Z", "#S#", "#~#", '#', new ItemStack(ironsheet), 'Z', new ItemStack(zincsheet), 'S', new ItemStack(Item.getItemFromBlock(blockIronSheetBlock)), '~', new ItemStack(redstoneprocessor) });
		
		//magic recipes
		GameRegistry.addRecipe(new ItemStack(giftofthesea), new Object[] {"ABA", "CDC", "EFE", 'A', new ItemStack(seafoodplatter), 'B', new ItemStack(Items.DIAMOND), 'C', new ItemStack(cookedcrabcake), 'D', new ItemStack(mysteriousorb),'E', new ItemStack(Items.COOKED_FISH), 'F', new ItemStack(Items.WATER_BUCKET)});
		GameRegistry.addRecipe(new ItemStack(giftofthesoil), new Object[] {"ABA", "CDC", "EFE", 'A', new ItemStack(Item.getItemFromBlock(blockVanilla)), 'B', new ItemStack(Items.DIAMOND), 'C', new ItemStack(Items.CAKE), 'D', new ItemStack(mysteriousorb),'E', new ItemStack(Items.BREAD), 'F', new ItemStack(Item.getItemFromBlock(Blocks.GRASS))});
		GameRegistry.addRecipe(new ItemStack(giftofthesky), new Object[] {"GBA", "HDC", "IFE", 'A', new ItemStack(avocado), 'B', new ItemStack(Items.DIAMOND), 'C', new ItemStack(Item.getItemFromBlock(blockCoconutBlock)), 'D', new ItemStack(mysteriousorb),'E', new ItemStack(orange), 'F', new ItemStack(kiwi),  'G', new ItemStack(peach),  'H', new ItemStack(banana),  'I', new ItemStack(cherry)});
		GameRegistry.addRecipe(new ItemStack(giftofthesun), new Object[] {"ABA", "BDB", "EBE",'A', new ItemStack(Items.GLOWSTONE_DUST), 'B', new ItemStack(Item.getItemFromBlock(blockTangleHeart)), 'D', new ItemStack(mysteriousorb),'E', new ItemStack(Item.getItemFromBlock(Blocks.REDSTONE_LAMP))});
		GameRegistry.addRecipe(new ItemStack(crystalcore), new Object[] {"ABA", "BCB", "ABA", 'A', new ItemStack(Items.GOLD_NUGGET), 'B', new ItemStack(Items.DIAMOND), 'C', new ItemStack(Items.QUARTZ)});
		GameRegistry.addRecipe(new ItemStack(blockGrowthCrystal), new Object[] {"ABA", "ACA", "ABA", 'B', new ItemStack(giftofthesoil), 'A', new ItemStack(Item.getItemFromBlock(Blocks.QUARTZ_BLOCK)), 'C', new ItemStack(crystalcore)});
		GameRegistry.addRecipe(new ItemStack(blockWaterCrystal), new Object[] {"ABA", "ACA", "ABA", 'B', new ItemStack(giftofthesea), 'A', new ItemStack(Item.getItemFromBlock(Blocks.QUARTZ_BLOCK)), 'C', new ItemStack(crystalcore)});
		GameRegistry.addRecipe(new ItemStack(blockLightCrystal), new Object[] {"ABA", "ACA", "ABA", 'B', new ItemStack(giftofthesun), 'A', new ItemStack(Item.getItemFromBlock(Blocks.QUARTZ_BLOCK)), 'C', new ItemStack(crystalcore)});
		GameRegistry.addRecipe(new ItemStack(blockSkyCrystal), new Object[] {"ABA", "ACA", "ABA", 'B', new ItemStack(giftofthesky), 'A', new ItemStack(Item.getItemFromBlock(Blocks.QUARTZ_BLOCK)), 'C', new ItemStack(crystalcore)});
		GameRegistry.addRecipe(new ItemStack(teleportcrystal), new Object[] {"ADA", "BCB", "ADA", 'A', new ItemStack(Items.GOLD_NUGGET), 'B', new ItemStack(Items.REDSTONE), 'C', new ItemStack(Items.ENDER_EYE), 'D', new ItemStack(crystalcore)});
		GameRegistry.addRecipe(new ItemStack(blockTangleHeart), new Object[] {"AA", "AA", 'A', new ItemStack(tangleheartshard)});
		GameRegistry.addRecipe(new ItemStack(unfiredsphere), new Object[] {"###", "#~#", "###", '#', new ItemStack(Items.CLAY_BALL),  '~', new ItemStack(sphereguide)});
		GameRegistry.addRecipe(new ItemStack(blockInfusedGlass), new Object[] {"#B#", "B~B", "#B#", '#', new ItemStack(Items.REDSTONE),  '~', new ItemStack(Items.DIAMOND),  'B', new ItemStack(Item.getItemFromBlock(Blocks.GLASS))});
		
		//pottery guide recipe
		GameRegistry.addRecipe(new ItemStack(advancedschematic), new Object[] {"AA", "AA", 'A', new ItemStack(basicschematic)});
		GameRegistry.addRecipe(new ItemStack(complexschematic), new Object[] {"AA", "AA", 'A', new ItemStack(advancedschematic)});
		GameRegistry.addRecipe(new ItemStack(mugguide), new Object[] {" C ", "ABA", " C ", 'A', new ItemStack(basicschematic), 'B', new ItemStack(Items.BOOK), 'C', new ItemStack(Items.PAPER)});
		GameRegistry.addRecipe(new ItemStack(plateguide), new Object[] {" C ", " B ", "ACA", 'A', new ItemStack(basicschematic), 'B', new ItemStack(Items.BOOK), 'C', new ItemStack(Items.PAPER)});
		GameRegistry.addRecipe(new ItemStack(juicerguide), new Object[] {"ACA", "ABA", "ACA", 'A', new ItemStack(basicschematic), 'B', new ItemStack(Items.BOOK), 'C', new ItemStack(Items.PAPER)});
		GameRegistry.addRecipe(new ItemStack(fryingpanguide), new Object[] {"C C", "ABA", "AAA", 'A', new ItemStack(advancedschematic), 'B', new ItemStack(Items.BOOK), 'C', new ItemStack(Items.PAPER)});
		GameRegistry.addRecipe(new ItemStack(saucepanguide), new Object[] {"ACA", "ABA", "ACA", 'A', new ItemStack(advancedschematic), 'B', new ItemStack(Items.BOOK), 'C', new ItemStack(Items.PAPER)});
		GameRegistry.addRecipe(new ItemStack(cuptrayguide), new Object[] {" C ", " B ", "ACA", 'A', new ItemStack(advancedschematic), 'B', new ItemStack(Items.BOOK), 'C', new ItemStack(Items.PAPER)});
		GameRegistry.addRecipe(new ItemStack(breadtinguide), new Object[] {" C ", "ABA", "ACA", 'A', new ItemStack(advancedschematic), 'B', new ItemStack(Items.BOOK), 'C', new ItemStack(Items.PAPER)});
		GameRegistry.addRecipe(new ItemStack(largecuptrayguide), new Object[] {" C ", " B ", "ACA", 'A', new ItemStack(complexschematic), 'B', new ItemStack(Items.BOOK), 'C', new ItemStack(Items.PAPER)});
		GameRegistry.addRecipe(new ItemStack(caketinguide), new Object[] {" C ", "ABA", "ACA", 'A', new ItemStack(complexschematic), 'B', new ItemStack(Items.BOOK), 'C', new ItemStack(Items.PAPER)});
		GameRegistry.addRecipe(new ItemStack(teapotguide), new Object[] {"ACA", "ABA", "ACA", 'A', new ItemStack(complexschematic), 'B', new ItemStack(Items.BOOK), 'C', new ItemStack(Items.PAPER)});
		GameRegistry.addRecipe(new ItemStack(sphereguide), new Object[] {"ACA", "ABA", "AAA", 'A', new ItemStack(complexschematic), 'B', new ItemStack(Items.BOOK), 'C', new ItemStack(Items.PAPER)});
		GameRegistry.addRecipe(new ItemStack(chipguide), new Object[] {"AAA", "ABA", "AAA", 'A', new ItemStack(complexschematic), 'B', new ItemStack(Items.BOOK), 'C', new ItemStack(Items.PAPER)});
		
		//Blocks made from sheets
		GameRegistry.addRecipe(new ItemStack(blockSiliconSheetBlock), new Object[] {"##", "##", '#', new ItemStack(siliconsheet)});
		GameRegistry.addRecipe(new ItemStack(blockGoldSheetBlock), new Object[] {"##", "##", '#', new ItemStack(goldsheet)});
		GameRegistry.addRecipe(new ItemStack(blockDiamondSheetBlock), new Object[] {"##", "##", '#', new ItemStack(diamondsheet)});
		GameRegistry.addRecipe(new ItemStack(blockRedstoneSheetBlock), new Object[] {"##", "##", '#', new ItemStack(redstonesheet)});
		GameRegistry.addRecipe(new ItemStack(blockCopperSheetBlock), new Object[] {"##", "##", '#', new ItemStack(coppersheet)});
		GameRegistry.addRecipe(new ItemStack(blockZincSheetBlock), new Object[] {"##", "##", '#', new ItemStack(zincsheet)});
		GameRegistry.addRecipe(new ItemStack(blockIronSheetBlock), new Object[] {"##", "##", '#', new ItemStack(ironsheet)});
		
		GameRegistry.addRecipe(new ItemStack(blockSiliconScaff), new Object[] {"#~", "~#", '#', new ItemStack(siliconsheet), '~', new ItemStack(Items.STICK)});
		GameRegistry.addRecipe(new ItemStack(blockGoldScaff), new Object[] {"#~", "~#", '#', new ItemStack(goldsheet), '~', new ItemStack(Items.STICK)});
		GameRegistry.addRecipe(new ItemStack(blockDiamondScaff), new Object[] {"#~", "~#", '#', new ItemStack(diamondsheet), '~', new ItemStack(Items.STICK)});
		GameRegistry.addRecipe(new ItemStack(blockRedstoneScaff), new Object[] {"#~", "~#", '#', new ItemStack(redstonesheet), '~', new ItemStack(Items.STICK)});
		GameRegistry.addRecipe(new ItemStack(blockCopperScaff), new Object[] {"#~", "~#", '#', new ItemStack(coppersheet), '~', new ItemStack(Items.STICK)});
		GameRegistry.addRecipe(new ItemStack(blockZincScaff), new Object[] {"#~", "~#", '#', new ItemStack(zincsheet), '~', new ItemStack(Items.STICK)});
		GameRegistry.addRecipe(new ItemStack(blockIronScaff), new Object[] {"#~", "~#", '#', new ItemStack(ironsheet), '~', new ItemStack(Items.STICK)});
		
		//trapdoor recipe
		GameRegistry.addRecipe(new ItemStack(Blocks.IRON_TRAPDOOR), new Object[] {" B ", "BAB", " B ", 'B', new ItemStack(Items.IRON_INGOT), 'A', new ItemStack(Item.getItemFromBlock(Blocks.TRAPDOOR))});	
		
		//Config Recipes
		if(CookingPlusConfig.enableSaltBlockOreDictionaryCrafting == false){
			GameRegistry.addRecipe(new ItemStack(blockSalt), new Object[] {"##", "##", '#', new ItemStack(saltpile)});
		}
		else{
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockSalt), new Object[] {"##", "##", '#', "dustSalt"}));
		}
		
		//pottery guide copying
		if(CookingPlusConfig.AllowGuideCopy == true){
			GameRegistry.addShapelessRecipe(new ItemStack(mugguide, 1), new Object[] {new ItemStack(Items.BOOK), new ItemStack(mugguide)});
			GameRegistry.addShapelessRecipe(new ItemStack(plateguide, 1), new Object[] {new ItemStack(Items.BOOK), new ItemStack(plateguide)});
			GameRegistry.addShapelessRecipe(new ItemStack(juicerguide, 1), new Object[] {new ItemStack(Items.BOOK), new ItemStack(juicerguide)});
			GameRegistry.addShapelessRecipe(new ItemStack(fryingpanguide, 1), new Object[] {new ItemStack(Items.BOOK), new ItemStack(fryingpanguide)});
			GameRegistry.addShapelessRecipe(new ItemStack(saucepanguide, 1), new Object[] {new ItemStack(Items.BOOK), new ItemStack(saucepanguide)});
			GameRegistry.addShapelessRecipe(new ItemStack(cuptrayguide, 1), new Object[] {new ItemStack(Items.BOOK), new ItemStack(cuptrayguide)});
			GameRegistry.addShapelessRecipe(new ItemStack(breadtinguide, 1), new Object[] {new ItemStack(Items.BOOK), new ItemStack(breadtinguide)});
			GameRegistry.addShapelessRecipe(new ItemStack(caketinguide, 1), new Object[] {new ItemStack(Items.BOOK), new ItemStack(caketinguide)});
			GameRegistry.addShapelessRecipe(new ItemStack(largecuptrayguide, 1), new Object[] {new ItemStack(Items.BOOK), new ItemStack(largecuptrayguide)});
			GameRegistry.addShapelessRecipe(new ItemStack(teapotguide, 1), new Object[] {new ItemStack(Items.BOOK), new ItemStack(teapotguide)});
			GameRegistry.addShapelessRecipe(new ItemStack(sphereguide, 1), new Object[] {new ItemStack(Items.BOOK), new ItemStack(sphereguide)});
			GameRegistry.addShapelessRecipe(new ItemStack(chipguide, 1), new Object[] {new ItemStack(Items.BOOK), new ItemStack(chipguide)});
			
		}
		
		//oven recipes
		CookingPlusOvenRecipes.instance().addOvenRecipe(new ItemStack(rawprawn), new ItemStack(cookedprawn), 0.7f);
		CookingPlusOvenRecipes.instance().addOvenRecipe(new ItemStack(cakebatter), new ItemStack(Items.CAKE), 0.7f);
		CookingPlusOvenRecipes.instance().addOvenRecipe(new ItemStack(dough), new ItemStack(Items.BREAD), 0.7f);
		CookingPlusOvenRecipes.instance().addOvenRecipe(new ItemStack(circleuncooked), new ItemStack(circlecookie), 0.7f);
		CookingPlusOvenRecipes.instance().addOvenRecipe(new ItemStack(staruncooked), new ItemStack(starcookie), 0.7f);
		CookingPlusOvenRecipes.instance().addOvenRecipe(new ItemStack(heartuncooked), new ItemStack(heartcookie), 0.7f);
		CookingPlusOvenRecipes.instance().addOvenRecipe(new ItemStack(moonuncooked), new ItemStack(mooncookie), 0.7f);
		CookingPlusOvenRecipes.instance().addOvenRecipe(new ItemStack(traysponge), new ItemStack(plainspongecupcake, 6), 0.7f);
		CookingPlusOvenRecipes.instance().addOvenRecipe(new ItemStack(traychocolate), new ItemStack(plainchocolatecupcake, 6), 0.7f);
		CookingPlusOvenRecipes.instance().addOvenRecipe(new ItemStack(trayvelvet), new ItemStack(plainredvelvetcupcake, 6), 0.7f);
		CookingPlusOvenRecipes.instance().addOvenRecipe(new ItemStack(traylargesponge), new ItemStack(blockSponge, 1), 0.7f);
		CookingPlusOvenRecipes.instance().addOvenRecipe(new ItemStack(rawsquid), new ItemStack(cookedsquid, 1), 0.7f);
		CookingPlusOvenRecipes.instance().addOvenRecipe(new ItemStack(rawcrab), new ItemStack(cookedcrab, 1), 0.7f);
		CookingPlusOvenRecipes.instance().addOvenRecipe(new ItemStack(rawlobster), new ItemStack(cookedlobster, 1), 0.7f);
		CookingPlusOvenRecipes.instance().addOvenRecipe(new ItemStack(rawoyster), new ItemStack(cookedoyster, 1), 0.7f);
		CookingPlusOvenRecipes.instance().addOvenRecipe(new ItemStack(bananadough), new ItemStack(bananabread), 0.7f);
		
		//inscription recipes
		InscriptionRecipeHelper.instance().addInscriptionRecipe(new ItemStack(redstonesheet), new ItemStack(inscribedredstonesheet));
		InscriptionRecipeHelper.instance().addInscriptionRecipe(new ItemStack(goldsheet), new ItemStack(inscribedgoldsheet));
		InscriptionRecipeHelper.instance().addInscriptionRecipe(new ItemStack(zincsheet), new ItemStack(inscribedzincsheet));
		InscriptionRecipeHelper.instance().addInscriptionRecipe(new ItemStack(ironsheet), new ItemStack(inscribedironsheet));
		InscriptionRecipeHelper.instance().addInscriptionRecipe(new ItemStack(coppersheet), new ItemStack(inscribedcoppersheet));
		InscriptionRecipeHelper.instance().addInscriptionRecipe(new ItemStack(diamondsheet), new ItemStack(inscribeddiamondsheet));
		InscriptionRecipeHelper.instance().addInscriptionRecipe(new ItemStack(siliconsheet), new ItemStack(inscribedsiliconsheet));
		
		//frying pan recipe
		CookingPlusFryingPanRecipes.instance().addFryingPanRecipe(new ItemStack(pancakemix), new ItemStack(pancake), 0.7f);
		CookingPlusFryingPanRecipes.instance().addFryingPanRecipe(new ItemStack(uncookedcrabcake), new ItemStack(cookedcrabcake), 0.7f);
		
		//sheet press recipe
		CookingPlusSheetPressRecipes.instance().addSheetPressRecipe(new ItemStack(cupcaketraymold), new ItemStack(ironsheet), new ItemStack(cupcaketray), 0.7f);
		CookingPlusSheetPressRecipes.instance().addSheetPressRecipe(new ItemStack(largecupcaketraymold), new ItemStack(ironsheet), new ItemStack(largecupcaketray), 0.7f);
		CookingPlusSheetPressRecipes.instance().addSheetPressRecipe(new ItemStack(breadtinmold), new ItemStack(ironsheet), new ItemStack(breadtin), 0.7f);
		CookingPlusSheetPressRecipes.instance().addSheetPressRecipe(new ItemStack(caketinmold), new ItemStack(ironsheet), new ItemStack(caketin), 0.7f);
		CookingPlusSheetPressRecipes.instance().addSheetPressRecipe(new ItemStack(chipmold), new ItemStack(siliconsheet), new ItemStack(siliconchip), 0.7f);
		CookingPlusSheetPressRecipes.instance().addSheetPressRecipe(new ItemStack(diamondsheet), new ItemStack(uncasedchip), new ItemStack(diamondprocessor), 0.5f);
		CookingPlusSheetPressRecipes.instance().addSheetPressRecipe(new ItemStack(ironsheet), new ItemStack(uncasedchip), new ItemStack(ironprocessor), 0.5f);
		CookingPlusSheetPressRecipes.instance().addSheetPressRecipe(new ItemStack(redstonesheet), new ItemStack(uncasedchip), new ItemStack(redstoneprocessor), 0.5f);
		CookingPlusSheetPressRecipes.instance().addSheetPressRecipe(new ItemStack(goldsheet), new ItemStack(uncasedchip), new ItemStack(goldprocessor), 0.5f);
		CookingPlusSheetPressRecipes.instance().addSheetPressRecipe(new ItemStack(spheremold), new ItemStack(moltenglass), new ItemStack(moltenorb), 0.5f);
		CookingPlusSheetPressRecipes.instance().addSheetPressRecipe(new ItemStack(chipmoldmold), new ItemStack(ironsheet), new ItemStack(chipmold), 0.7f);
		
		CookingPlusSheetPressRecipes.instance().addSheetPressRecipe(new ItemStack(inscribedgoldsheet), new ItemStack(uncasedchip), new ItemStack(inscribedgoldprocessor), 0.5f);
		CookingPlusSheetPressRecipes.instance().addSheetPressRecipe(new ItemStack(inscribedironsheet), new ItemStack(uncasedchip), new ItemStack(inscribedironprocessor), 0.5f);
		CookingPlusSheetPressRecipes.instance().addSheetPressRecipe(new ItemStack(inscribeddiamondsheet), new ItemStack(uncasedchip), new ItemStack(inscribeddiamondprocessor), 0.5f);
		CookingPlusSheetPressRecipes.instance().addSheetPressRecipe(new ItemStack(inscribedredstonesheet), new ItemStack(uncasedchip), new ItemStack(inscribedredstoneprocessor), 0.5f);
		
		
		//drying rack recipe
		CookingPlusDryingRackRecipe.instance().addDryingRackRecipe(new ItemStack(Item.getItemFromBlock(blockSeaweedCrop)), new ItemStack(driedseaweed), 0.7f);
		CookingPlusDryingRackRecipe.instance().addDryingRackRecipe(new ItemStack(Items.BEEF), new ItemStack(beefjerky), 0.7f);
		CookingPlusDryingRackRecipe.instance().addDryingRackRecipe(new ItemStack(Items.PORKCHOP), new ItemStack(porkjerky), 0.7f);
		CookingPlusDryingRackRecipe.instance().addDryingRackRecipe(new ItemStack(Items.MUTTON), new ItemStack(sheepjerky), 0.7f);
		CookingPlusDryingRackRecipe.instance().addDryingRackRecipe(new ItemStack(Items.RABBIT), new ItemStack(rabbitjerky), 0.7f);
		CookingPlusDryingRackRecipe.instance().addDryingRackRecipe(new ItemStack(Items.ROTTEN_FLESH), new ItemStack(zombiejerky), 0.7f);
		
		//saucepan recipe
		CookingPlusSaucePanRecipe.instance().addSaucePanRecipe(new ItemStack(vanillaicecreammix), null, new ItemStack(vanillaboiled), 0.7f);
		CookingPlusSaucePanRecipe.instance().addSaucePanRecipe(new ItemStack(minticecreammix), null, new ItemStack(mintboiled), 0.7f);
		CookingPlusSaucePanRecipe.instance().addSaucePanRecipe(new ItemStack(lemonicecreammix), null, new ItemStack(lemonboiled), 0.7f);
		CookingPlusSaucePanRecipe.instance().addSaucePanRecipe(new ItemStack(strawberryicecreammix), null, new ItemStack(strawberryboiled), 0.7f);
		CookingPlusSaucePanRecipe.instance().addSaucePanRecipe(new ItemStack(chocolateicecreammix), null, new ItemStack(chocolateboiled), 0.7f);
		
		//furnaces
		GameRegistry.addSmelting(unfiredjuicer,new ItemStack(juicer), 5);
		GameRegistry.addSmelting(unfiredmug,new ItemStack(mug), 5);
		GameRegistry.addSmelting(blockUnfiredTeapot,new ItemStack(Item.getItemFromBlock(blockTeapot)), 5);
		GameRegistry.addSmelting(blockUnfiredPlate,new ItemStack(Item.getItemFromBlock(blockPlate)), 5);
		GameRegistry.addSmelting(blockUnfiredFryingPan,new ItemStack(Item.getItemFromBlock(blockFryingPan)), 5);
		GameRegistry.addSmelting(cupcaketrayunfiredmold,new ItemStack(cupcaketraymold), 5);
		GameRegistry.addSmelting(largecupcaketrayunfiredmold,new ItemStack(largecupcaketraymold), 5);
		GameRegistry.addSmelting(blockUnfiredSaucePan,new ItemStack(Item.getItemFromBlock(blockSaucePan)), 5);
		GameRegistry.addSmelting(unfiredcaketinmold,new ItemStack(caketinmold), 5);
		GameRegistry.addSmelting(unfiredbreadtinmold,new ItemStack(breadtinmold), 5);
		GameRegistry.addSmelting(unfiredsphere,new ItemStack(spheremold), 5);
		GameRegistry.addSmelting(blockInfusedGlass,new ItemStack(moltenglass), 5);
		GameRegistry.addSmelting(unfiredchipmoldmold,new ItemStack(chipmoldmold), 5);
		GameRegistry.addSmelting(Item.getItemFromBlock(blockCopperOre),new ItemStack(copperingot), 5);
		GameRegistry.addSmelting(Item.getItemFromBlock(blockZincOre),new ItemStack(zincingot), 5);
		
		//ice box recipes
		CookingPlusIceBoxRecipes.instance().addIceBoxRecipe(new ItemStack(vanillaboiled), new ItemStack(vanillaicecream), 0.7f);
		CookingPlusIceBoxRecipes.instance().addIceBoxRecipe(new ItemStack(chocolateboiled), new ItemStack(chocolateicecream), 0.7f);
		CookingPlusIceBoxRecipes.instance().addIceBoxRecipe(new ItemStack(strawberryboiled), new ItemStack(strawberryicecream), 0.7f);
		CookingPlusIceBoxRecipes.instance().addIceBoxRecipe(new ItemStack(lemonboiled), new ItemStack(lemonicecream), 0.7f);
		CookingPlusIceBoxRecipes.instance().addIceBoxRecipe(new ItemStack(mintboiled), new ItemStack(minticecream), 0.7f);
		CookingPlusIceBoxRecipes.instance().addIceBoxRecipe(new ItemStack(moltenorb), new ItemStack(mysteriousorb), 0.7f);
		
		//1.9 stuff
		//GameRegistry.addRecipe(new ItemStack(beetrootsoup), new Object[] {"###", "###", " ~ ", '~', new ItemStack(Items.BOWL), '#', new ItemStack(beetroot)});
		itemRender(e);
		AddLatestStuff(e);
		MutationStationRecipeHandler.instance().addCrops(e);
		this.proxy.init(e);
		
	}

    @EventHandler
	public void postInit(FMLPostInitializationEvent e) {
    	NetworkRegistry.INSTANCE.registerGuiHandler(CookingPlusMain.instance, new GUIHandler());
    	if(CookingPlusConfig.MoveModFoodRecipesToBrickOven){
    		CookingPlusOvenRecipes.instance().switchModFoodFurnaceRecipestoBrickOven();
    	}
    	GameRegistry.registerWorldGenerator(new CookingPlusWorldGen(), 1);
    	MutationStationRecipeHandler.instance().setUpRecipes();
    	SetCreativeTab();
    	AddLoot();
    	this.proxy.postInit(e);

	}
    
    public static void removeFurnaceRecipe (ItemStack resultItem)
    {
    	Map<ItemStack, ItemStack> recipes = FurnaceRecipes.instance().getSmeltingList();
    	for (Iterator<Map.Entry<ItemStack,ItemStack>> entries = recipes.entrySet().iterator(); entries.hasNext(); ){
    		Map.Entry<ItemStack,ItemStack> entry = entries.next();
    		ItemStack result = entry.getValue();
    		if (ItemStack.areItemStacksEqual(result, resultItem)){ // If the output matches the specified ItemStack,
    			entries.remove(); // Remove the recipe
    		}
    	}
    }
    
    public static void removeCraftingRecipe (Item resultItem)
    {
    	//remove existing recipes for food
    			List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
    			Iterator<IRecipe> Leash = recipes.iterator();	          
    			while (Leash.hasNext()) {
    				ItemStack is = Leash.next().getRecipeOutput();
    				if (is != null && is.getItem() == resultItem){Leash.remove();}
    			};
    }

    private void SetCreativeTab(){
    	rack.setCreativeTab(this.tabCustom);
    	cookedprawn.setCreativeTab(this.tabCustom);
    	shelledprawn.setCreativeTab(this.tabCustom);
    	rawprawn.setCreativeTab(this.tabCustom);
    	cakebatter.setCreativeTab(this.tabCustom);
    	flour.setCreativeTab(this.tabCustom);
    	pestle.setCreativeTab(this.tabCustom);
    	blockSalt.setCreativeTab(this.tabCustom);
    	blockBrickOven.setCreativeTab(this.tabCustom);
    	saltpile.setCreativeTab(this.tabCustom);
    	onion.setCreativeTab(this.tabCustom);
    	onionseed.setCreativeTab(this.tabCustom);
    	chilli.setCreativeTab(this.tabCustom);
    	chilliseed.setCreativeTab(this.tabCustom);
    	fishingnet.setCreativeTab(this.tabCustom);
    	knife.setCreativeTab(this.tabCustom);
    	dough.setCreativeTab(this.tabCustom);
    	blockButterChurn.setCreativeTab(this.tabCustom);
    	blockButter.setCreativeTab(this.tabCustom);
    	butteringot.setCreativeTab(this.tabCustom);
    	butternugget.setCreativeTab(this.tabCustom);
    	blockOilPress.setCreativeTab(this.tabCustom);
    	vegetableoil.setCreativeTab(this.tabCustom);
    	grapeseed.setCreativeTab(this.tabCustom);
    	grape.setCreativeTab(this.tabCustom);
    	cookiebatter.setCreativeTab(this.tabCustom);
    	blockFermenter.setCreativeTab(this.tabCustom);
    	blockMarketBox.setCreativeTab(this.tabCustom);
    	blockTeapot.setCreativeTab(this.tabCustom);
    	blockUnfiredTeapot.setCreativeTab(this.tabCustom);
    	blockHeater.setCreativeTab(this.tabCustom);
    	blockOrnateChest.setCreativeTab(this.tabCustom);
    	hopseed.setCreativeTab(this.tabCustom);
    	hops.setCreativeTab(this.tabCustom);
    	cottonseed.setCreativeTab(this.tabCustom);
    	cottonbud.setCreativeTab(this.tabCustom);
    	blockBamboo.setCreativeTab(this.tabCustom);
    	blockBambooBlock.setCreativeTab(this.tabCustom);
    	teaseed.setCreativeTab(this.tabCustom);
    	tealeaf.setCreativeTab(this.tabCustom);
    	blockPlate.setCreativeTab(this.tabCustom);
    	blockUnfiredPlate.setCreativeTab(this.tabCustom);
    	blockFryingPan.setCreativeTab(this.tabCustom);
    	blockUnfiredFryingPan.setCreativeTab(this.tabCustom);
    	vanillaseed.setCreativeTab(this.tabCustom);
    	lemonpancake.setCreativeTab(this.tabCustom);
    	creampancake.setCreativeTab(this.tabCustom);
    	vanillapod.setCreativeTab(this.tabCustom);
    	blockSheetPress.setCreativeTab(this.tabCustom);
    	
    	blockBambooLeaves.setCreativeTab(this.tabCustom);
    	blockBambooSprout.setCreativeTab(this.tabCustom);
    	blockAppleLeaves.setCreativeTab(this.tabCustom);
    	blockLemonLeaves.setCreativeTab(this.tabCustom);
    	blockPeachLeaves.setCreativeTab(this.tabCustom);
    	blockLimeLeaves.setCreativeTab(this.tabCustom);
    	blockOrangeLeaves.setCreativeTab(this.tabCustom);
    	blockAppleSapling.setCreativeTab(this.tabCustom);
    	blockLemonSapling.setCreativeTab(this.tabCustom);
    	blockPeachSapling.setCreativeTab(this.tabCustom);
    	blockLimeSapling.setCreativeTab(this.tabCustom);
    	blockOrangeSapling.setCreativeTab(this.tabCustom);
    	
    	peach.setCreativeTab(this.tabCustom);
    	lemon.setCreativeTab(this.tabCustom);
    	lime.setCreativeTab(this.tabCustom);
    	orange.setCreativeTab(this.tabCustom);
    	
    	blockBlueBerryBush.setCreativeTab(this.tabCustom);
    	blueberry.setCreativeTab(this.tabCustom);
    	blockGooseBerryBush.setCreativeTab(this.tabCustom);
    	gooseberry.setCreativeTab(this.tabCustom);
    	blockStrawBerryBush.setCreativeTab(this.tabCustom);
    	strawberry.setCreativeTab(this.tabCustom);
    	blockBush.setCreativeTab(this.tabCustom);
    	
    	//herbs
    	blockSage.setCreativeTab(this.tabCustom);
    	blockMint.setCreativeTab(this.tabCustom);
    	blockRosemary.setCreativeTab(this.tabCustom);
    	blockChamomile.setCreativeTab(this.tabCustom);
    	blockBuchu.setCreativeTab(this.tabCustom);
    	blockLicorice.setCreativeTab(this.tabCustom);
    	sageleaf.setCreativeTab(this.tabCustom);
    	mintleaf.setCreativeTab(this.tabCustom);
    	rosemaryleaf.setCreativeTab(this.tabCustom);
    	buchuleaf.setCreativeTab(this.tabCustom);
    	licoriceleaf.setCreativeTab(this.tabCustom);
    	chamomileflower.setCreativeTab(this.tabCustom);
    	chamomiletea.setCreativeTab(this.tabCustom);
    	sagetea.setCreativeTab(this.tabCustom);
    	minttea.setCreativeTab(this.tabCustom);
    	buchutea.setCreativeTab(this.tabCustom);
    	licoricetea.setCreativeTab(this.tabCustom);
    	rosemarytea.setCreativeTab(this.tabCustom);
    	
    	//sweetie stuff
    	circlecutter.setCreativeTab(this.tabCustom);
    	heartcutter.setCreativeTab(this.tabCustom);
    	starcutter.setCreativeTab(this.tabCustom);
    	mooncutter.setCreativeTab(this.tabCustom);
    	circleuncooked.setCreativeTab(this.tabCustom);
    	heartuncooked.setCreativeTab(this.tabCustom);
    	staruncooked.setCreativeTab(this.tabCustom);
    	moonuncooked.setCreativeTab(this.tabCustom);
    	circlecookie.setCreativeTab(this.tabCustom);
    	heartcookie.setCreativeTab(this.tabCustom);
    	starcookie.setCreativeTab(this.tabCustom);
    	mooncookie.setCreativeTab(this.tabCustom);
    	cocoapowder.setCreativeTab(this.tabCustom);
    	chocolate.setCreativeTab(this.tabCustom);
    	pancakemix.setCreativeTab(this.tabCustom);
    	pancake.setCreativeTab(this.tabCustom);
    	sugarpancake.setCreativeTab(this.tabCustom);
    	chocolatepancake.setCreativeTab(this.tabCustom);
    	cupcaketrayunfiredmold.setCreativeTab(this.tabCustom);
    	cupcaketraymold.setCreativeTab(this.tabCustom);
    	cupcaketray.setCreativeTab(this.tabCustom);
    	largecupcaketrayunfiredmold.setCreativeTab(this.tabCustom);
    	largecupcaketraymold.setCreativeTab(this.tabCustom);
    	largecupcaketray.setCreativeTab(this.tabCustom);
    	cuptrayguide.setCreativeTab(this.tabCustom);
    	largecuptrayguide.setCreativeTab(this.tabCustom);
    	traysponge.setCreativeTab(this.tabCustom);
    	traychocolate.setCreativeTab(this.tabCustom);
    	trayvelvet.setCreativeTab(this.tabCustom);
    	plainspongecupcake.setCreativeTab(this.tabCustom);
    	plainchocolatecupcake.setCreativeTab(this.tabCustom);
    	plainredvelvetcupcake.setCreativeTab(this.tabCustom);
    	
    	juicer.setCreativeTab(this.tabCustom);
    	unfiredjuicer.setCreativeTab(this.tabCustom);
    	mug.setCreativeTab(this.tabCustom);
    	unfiredmug.setCreativeTab(this.tabCustom);
    	applejuice.setCreativeTab(this.tabCustom);
    	lemonjuice.setCreativeTab(this.tabCustom);
    	limejuice.setCreativeTab(this.tabCustom);
    	peachjuice.setCreativeTab(this.tabCustom);
    	blueberryjuice.setCreativeTab(this.tabCustom);
    	gooseberryjuice.setCreativeTab(this.tabCustom);
    	strawberryjuice.setCreativeTab(this.tabCustom);
    	orangejuice.setCreativeTab(this.tabCustom);
    	grapejuice.setCreativeTab(this.tabCustom);
    	wine.setCreativeTab(this.tabCustom);
    	cider.setCreativeTab(this.tabCustom);
    	beer.setCreativeTab(this.tabCustom);
    	
    	juicerguide.setCreativeTab(this.tabCustom);
    	mugguide.setCreativeTab(this.tabCustom);
    	teapotguide.setCreativeTab(this.tabCustom);
    	plateguide.setCreativeTab(this.tabCustom);
    	fryingpanguide.setCreativeTab(this.tabCustom);
    	
    	saltedbeef.setCreativeTab(this.tabCustom);
    	saltedpork.setCreativeTab(this.tabCustom);
    	saltedprawn.setCreativeTab(this.tabCustom);
    	saltedmutton.setCreativeTab(this.tabCustom);
    	saltedrabbit.setCreativeTab(this.tabCustom);
    	saltedchicken.setCreativeTab(this.tabCustom);
    	
    	blockRope.setCreativeTab(this.tabCustom);
    	
    	//1.9 stuff
    	beetroot.setCreativeTab(this.tabCustom);
    	beetrootseed.setCreativeTab(this.tabCustom);
    	beetrootsoup.setCreativeTab(this.tabCustom);
    	
    	//custom rendered blocks
    	//blockGrapeCrop.setCreativeTab(this.tabCustom);
    }

    private void addPotions(){
		Potion[] potionTypes = null;

		for (Field f : Potion.class.getDeclaredFields()) {
			f.setAccessible(true);
			try {
				if (f.getName().equals("potionTypes")|| f.getName().equals("field_76425_a")) {
					Field modfield = Field.class.getDeclaredField("modifiers");
					modfield.setAccessible(true);
					modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);

					potionTypes = (Potion[]) f.get(null);
					final Potion[] newPotionTypes = new Potion[256];
					System.arraycopy(potionTypes, 0, newPotionTypes, 0,potionTypes.length);
					f.set(null, newPotionTypes);
				}
			} catch (Exception e) {
				System.err
						.println("Severe error, please report this to the mod author:");
				System.err.println(e);
			}
		}
        
        myTestPotion = (new CookingPlusPotion(32, false, 0)).setIconIndex(0, 0).setPotionName("potion.myTestPotion");
        
    }

    private void itemRender(FMLInitializationEvent event){
    	if(event.getSide() == Side.CLIENT)
    	{
    		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
    	    
    		//edible food
        	renderItem.getItemModelMesher().register(blueberry, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) blueberry).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(gooseberry, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) gooseberry).getName(), "inventory"));	
        	renderItem.getItemModelMesher().register(lemon, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) lemon).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(lime, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) lime).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(chilli, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) chilli).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(onion, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) onion).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(peach, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) peach).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(cookedprawn, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) cookedprawn).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(butteringot, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) butteringot).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(rawprawn, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) rawprawn).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(strawberry, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) strawberry).getName(), "inventory"));	
        	renderItem.getItemModelMesher().register(orange, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) orange).getName(), "inventory"));	
        	renderItem.getItemModelMesher().register(saltedbeef, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) saltedbeef).getName(), "inventory"));	
        	renderItem.getItemModelMesher().register(saltedpork, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) saltedpork).getName(), "inventory"));	
        	renderItem.getItemModelMesher().register(saltedprawn, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) saltedprawn).getName(), "inventory"));	
        	renderItem.getItemModelMesher().register(saltedmutton, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) saltedmutton).getName(), "inventory"));	
        	renderItem.getItemModelMesher().register(saltedchicken, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) saltedchicken).getName(), "inventory"));	
        	renderItem.getItemModelMesher().register(saltedrabbit, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) saltedrabbit).getName(), "inventory"));	
        	renderItem.getItemModelMesher().register(grape, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) grape).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(hops, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) hops).getName(), "inventory"));
        	
        	renderItem.getItemModelMesher().register(circlecookie, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) circlecookie).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(starcookie, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) starcookie).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(heartcookie, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) heartcookie).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(chocolate, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) chocolate).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(pancake, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) pancake).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(sugarpancake, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) sugarpancake).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(chocolatepancake, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) chocolatepancake).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(mooncookie, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) mooncookie).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(creampancake, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) creampancake).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(lemonpancake, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) lemonpancake).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(plainspongecupcake, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) plainspongecupcake).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(plainchocolatecupcake, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) plainchocolatecupcake).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(plainredvelvetcupcake, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) plainredvelvetcupcake).getName(), "inventory"));
        	
        	//juices
        	renderItem.getItemModelMesher().register(applejuice, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) applejuice).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(lemonjuice, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) lemonjuice).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(limejuice, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) limejuice).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(peachjuice, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) peachjuice).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(blueberryjuice, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) blueberryjuice).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(gooseberryjuice, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) gooseberryjuice).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(strawberryjuice, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) strawberryjuice).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(orangejuice, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) orangejuice).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(grapejuice, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) grapejuice).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(wine, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) wine).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(cider, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) cider).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(beer, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) cider).getName(), "inventory"));
        	
        	//teas
        	renderItem.getItemModelMesher().register(sagetea, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) sagetea).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(minttea, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) minttea).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(buchutea, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) buchutea).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(rosemarytea, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) rosemarytea).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(licoricetea, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) licoricetea).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(chamomiletea, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) chamomiletea).getName(), "inventory"));
        	
        	//edible seeds
        	renderItem.getItemModelMesher().register(onionseed, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleSeed) onionseed).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(chilliseed, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleSeed) chilliseed).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(cottonseed, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleSeed) cottonseed).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(teaseed, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleSeed) teaseed).getName(), "inventory"));
        	
        	//rope seeds
        	renderItem.getItemModelMesher().register(grapeseed, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleRopeCropSeed) grapeseed).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(hopseed, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleRopeCropSeed) hopseed).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(vanillaseed, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleRopeCropSeed) vanillaseed).getName(), "inventory"));
        	
        	//custom items
        	renderItem.getItemModelMesher().register(knife, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) knife).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(rack, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) rack).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(fishingnet, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) fishingnet).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(shelledprawn, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) shelledprawn).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(pestle, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) pestle).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(dough, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) dough).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(cakebatter, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) cakebatter).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(vegetableoil, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) vegetableoil).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(flour, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) flour).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(saltpile, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) saltpile).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(butternugget, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) butternugget).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(juicer, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) juicer).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(unfiredjuicer, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) unfiredjuicer).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(juicerguide, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) juicerguide).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(cookiebatter, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) cookiebatter).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(cottonbud, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) cottonbud).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(tealeaf, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) tealeaf).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(sageleaf, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) sageleaf).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(mintleaf, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) mintleaf).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(licoriceleaf, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) licoriceleaf).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(rosemaryleaf, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) rosemaryleaf).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(buchuleaf, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) buchuleaf).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(chamomileflower, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) chamomileflower).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(mugguide, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) mugguide).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(unfiredmug, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) unfiredmug).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(mug, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) mug).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(teapotguide, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) teapotguide).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(plateguide, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) plateguide).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(fryingpanguide, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) fryingpanguide).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(vanillapod, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) vanillapod).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(traysponge, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) traysponge).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(traychocolate, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) traychocolate).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(trayvelvet, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) trayvelvet).getName(), "inventory"));
        	
        	renderItem.getItemModelMesher().register(circlecutter, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) circlecutter).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(starcutter, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) starcutter).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(heartcutter, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) heartcutter).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(circleuncooked, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) circleuncooked).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(staruncooked, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) staruncooked).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(heartuncooked, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) heartuncooked).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(cocoapowder, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) cocoapowder).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(pancakemix, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) pancakemix).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(mooncutter, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) mooncutter).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(moonuncooked, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) moonuncooked).getName(), "inventory"));
        	
        	renderItem.getItemModelMesher().register(cuptrayguide, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) cuptrayguide).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(largecuptrayguide, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) largecuptrayguide).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(cupcaketrayunfiredmold, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) cupcaketrayunfiredmold).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(cupcaketraymold, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) cupcaketraymold).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(cupcaketray, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) cupcaketray).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(largecupcaketrayunfiredmold, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) largecupcaketrayunfiredmold).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(largecupcaketraymold, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) largecupcaketraymold).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(largecupcaketray, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) largecupcaketray).getName(), "inventory"));
        	
        	//blocks
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockSalt), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomBlock) blockSalt).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockButter), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomBlock) blockButter).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockRope), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomBlock) blockRope).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockNull), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomBlock) blockNull).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockBamboo), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomBlock) blockBamboo).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockBambooBlock), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomBlock) blockBambooBlock).getName(), "inventory"));
            
        	//leaves
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockAppleLeaves), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomLeaves) blockAppleLeaves).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockPeachLeaves), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomLeaves) blockPeachLeaves).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockLimeLeaves), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomLeaves) blockLimeLeaves).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockLemonLeaves), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomLeaves) blockLemonLeaves).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockOrangeLeaves), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomLeaves) blockOrangeLeaves).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockBambooLeaves), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomLeaves) blockBambooLeaves).getName(), "inventory"));
            
        	//crops
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockChilliCrop), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomCrops) blockChilliCrop).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockOnionCrop), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomCrops) blockOnionCrop).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockCottonCrop), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomCrops) blockCottonCrop).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockTeaCrop), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomCrops) blockTeaCrop).getName(), "inventory"));
            
        	//bushes
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockBlueBerryBush), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomGrowingBush) blockBlueBerryBush).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockGooseBerryBush), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomGrowingBush) blockGooseBerryBush).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockBush), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomGrowingBush) blockBush).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockStrawBerryBush), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomGrowingBush) blockStrawBerryBush).getName(), "inventory"));
            
        	//herbs
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockSage), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomBlock) blockSage).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockMint), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomBlock) blockMint).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockBuchu), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomBlock) blockBuchu).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockLicorice), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomBlock) blockLicorice).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockRosemary), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomBlock) blockRosemary).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockChamomile), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomBlock) blockChamomile).getName(), "inventory"));
        	
        	//saplings
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockLimeSapling), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomSapling) blockLimeSapling).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockAppleSapling), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomSapling) blockAppleSapling).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockLemonSapling), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomSapling) blockLemonSapling).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockPeachSapling), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomSapling) blockPeachSapling).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockOrangeSapling), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomSapling) blockOrangeSapling).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockBambooSprout), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomSapling) blockBambooSprout).getName(), "inventory"));
            
        	//tile entities
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockButterChurn), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusButterChurnBlock) blockButterChurn).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockOilPress), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusOilPressBlock) blockOilPress).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockBrickOven), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusBrickOvenBlock) blockBrickOven).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockFermenter), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusFermenterBlock) blockFermenter).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockMarketBox), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusMarketBoxBlock) blockMarketBox).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockTeapot), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusTeapotBlock) blockTeapot).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockUnfiredTeapot), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusUnfiredTeapotBlock) blockUnfiredTeapot).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockHeater), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusHeaterBlock) blockHeater).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockOrnateChest), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusOrnateChestBlock) blockOrnateChest).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockPlate), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusPlateBlock) blockPlate).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockUnfiredPlate), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusUnfiredPlateBlock) blockUnfiredPlate).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockFryingPan), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusFryingPanBlock) blockFryingPan).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockUnfiredFryingPan), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusUnfiredFryingPanBlock) blockUnfiredFryingPan).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockSheetPress), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusSheetPressBlock) blockSheetPress).getName(), "inventory"));
        	
        	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getModelManager().getBlockModelShapes().registerBuiltInBlocks(CookingPlusMain.blockBrickOven);
        	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getModelManager().getBlockModelShapes().registerBuiltInBlocks(CookingPlusMain.blockOilPress);
        	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getModelManager().getBlockModelShapes().registerBuiltInBlocks(CookingPlusMain.blockButterChurn);
        	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getModelManager().getBlockModelShapes().registerBuiltInBlocks(CookingPlusMain.blockFermenter);
        	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getModelManager().getBlockModelShapes().registerBuiltInBlocks(CookingPlusMain.blockMarketBox);
        	
        	//1.9 stuff
        	renderItem.getItemModelMesher().register(beetroot, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) beetroot).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(beetrootseed, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleSeed) beetrootseed).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(beetrootsoup, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) beetrootsoup).getName(), "inventory"));
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockBeetrootCrop), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomCrops) blockBeetrootCrop).getName(), "inventory"));
            
        	
        	//customrenderedblock
        	renderItem.getItemModelMesher().register(Item.getItemFromBlock(blockGrapeCrop), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomRenderedBlock) blockGrapeCrop).getName(), "inventory"));
            
    	}
    }

    public void Additem(FMLInitializationEvent event, Item myItem){	
    	myItem.setCreativeTab(this.tabCustom);
    	if(event.getSide() == Side.CLIENT)
    	{
    		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
    		if(myItem instanceof CookingPlusCustomEdibleFood){
    			renderItem.getItemModelMesher().register(myItem, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleFood) myItem).getName(), "inventory"));	
    		}
    		else if(myItem instanceof CookingPlusCustomEdibleSeed){
    			renderItem.getItemModelMesher().register(myItem, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleSeed) myItem).getName(), "inventory"));
    		}
    		else if(myItem instanceof CookingPlusCustomEdibleRopeCropSeed){
    			renderItem.getItemModelMesher().register(myItem, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomEdibleRopeCropSeed) myItem).getName(), "inventory"));
    		}
    		else if(myItem instanceof CookingPlusCustomItem){
    			renderItem.getItemModelMesher().register(myItem, 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomItem) myItem).getName(), "inventory"));
    		}
    		else{
    			System.out.println("Unable to Add Item " + myItem.getUnlocalizedName());
    		}
    	}
    }
    
    public void Addblock(FMLInitializationEvent event, Block myItem){	
    	
    	if(myItem instanceof CookingPlusCustomBlock || myItem instanceof CookingPlusCustomLeaves || myItem instanceof CookingPlusCustomGrowingBush || myItem instanceof CookingPlusCustomSapling || myItem instanceof CookingPlusCustomTileEntityBlock || myItem instanceof CookingPlusCustomSpreadingCoral || myItem instanceof CookingPlusCustomUnderwaterCrop || myItem instanceof CookingPlusCustomTranslucentCoral)
    	{
    		myItem.setCreativeTab(this.tabCustom);
    	}
    	
    	if(event.getSide() == Side.CLIENT)
    	{
    		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
    		if(myItem instanceof CookingPlusCustomBlock){
    			renderItem.getItemModelMesher().register(Item.getItemFromBlock(myItem), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomBlock) myItem).getName(), "inventory"));
            }
    		else if(myItem instanceof CookingPlusCustomSapling){
    			renderItem.getItemModelMesher().register(Item.getItemFromBlock(myItem), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomSapling) myItem).getName(), "inventory"));
            }
    		else if(myItem instanceof CookingPlusCustomLeaves){
    			renderItem.getItemModelMesher().register(Item.getItemFromBlock(myItem), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomLeaves) myItem).getName(), "inventory"));
            }
    		else if(myItem instanceof CookingPlusCustomGrowingBush){
    			renderItem.getItemModelMesher().register(Item.getItemFromBlock(myItem), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomGrowingBush) myItem).getName(), "inventory"));
            }
    		else if(myItem instanceof CookingPlusCustomCrops){
    			renderItem.getItemModelMesher().register(Item.getItemFromBlock(myItem), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomCrops) myItem).getName(), "inventory"));
            }
    		else if(myItem instanceof CookingPlusCustomUnderwaterPlant){
    			renderItem.getItemModelMesher().register(Item.getItemFromBlock(myItem), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomUnderwaterPlant) myItem).getName(), "inventory"));
            }
    		else if(myItem instanceof CookingPlusCustomTileEntityBlock){
    			renderItem.getItemModelMesher().register(Item.getItemFromBlock(myItem), 0, new ModelResourceLocation(this.MODID + ":" + ((CookingPlusCustomTileEntityBlock) myItem).GetName(), "inventory"));
            }
    		else{
    			System.out.println("Unable to Add Block " + myItem.getUnlocalizedName());
    		}
    	}
    }

    private void AddLatestStuff(FMLInitializationEvent event){
    	Additem(event, ironsheet);
    	Additem(event, vanillaessence);
    	Additem(event, creambucket);
    	Additem(event, cherry);
    	Additem(event, vanillasponge);
    	Additem(event, vanillachocolate);
    	Additem(event, vanillavelvet);
    	Additem(event, vanillabuttercream);
    	Additem(event, traylargesponge);
    	
    	Addblock(event, blockCherrySapling);
    	Addblock(event, blockCherryLeaves);
    	Addblock(event, blockSponge);
    	Addblock(event, blockVanilla);
    	
    	Additem(event, shelledcrab);
    	Additem(event, shelledlobster);
    	Additem(event, shelledoyster);
    	Additem(event, driedseaweed);
    	Additem(event, soakedbook);
    	Additem(event, beefjerky);
    	Additem(event, porkjerky);
    	Additem(event, sheepjerky);
    	Additem(event, rabbitjerky);
    	Additem(event, rawsquid);
    	Additem(event, rawcrab);
    	Additem(event, rawlobster);
    	Additem(event, rawoyster);
    	Additem(event, cookedsquid);
    	Additem(event, cookedcrab);
    	Additem(event, cookedlobster);
    	Additem(event, cookedoyster);
    	Additem(event, saltedsquid);
    	Additem(event, saltedcrab);
    	Additem(event, saltedlobster);
    	Additem(event, saltedoyster);
    	Additem(event, pineappleseed);
    	Additem(event, pineapple);
    	Additem(event, cheddarwedge);
    	Additem(event, bluewedge);
    	Additem(event, halloumiwedge);
    	Additem(event, creamwedge);
    	Additem(event, breadcrumbs);
    	Additem(event, uncookedcrabcake);
    	Additem(event, cookedcrabcake);
    	Additem(event, seafoodplatter);
    	Additem(event, pineapplejuice);
    	
    	//0.8
    	Additem(event, copperingot);
    	Additem(event, zincingot);
    	Additem(event, copperwire);
    	Additem(event, zincwire);
    	Additem(event, coppersheet);
    	Additem(event, zincsheet);
    	Additem(event, vinegar);
    	Additem(event, battery);
    	Additem(event, goldsheet);
    	Additem(event, goldprocessor);
    	
    	Addblock(event, blockCopperOre);
    	Addblock(event, blockZincOre);
    	Addblock(event, blockDesalinator);
    	Addblock(event, blockLogger);
    	Addblock(event, blockPlanter);
    	Addblock(event, blockGoldBot);
    	Addblock(event, blockLaserDroneBay);
    	Addblock(event, blockSpeedBlock);
    	Addblock(event, blockRangeBlock);
    	Addblock(event, blockGoldenSpeedBlock);
    	Addblock(event, blockGoldenRangeBlock);
    	//end of 0.8
    	
    	//start of 0.9
    	Addblock(event, blockBattery);
    	Addblock(event, blockLeyReceiver);
    	Addblock(event, blockLeyGenerator);
    	Addblock(event, blockLeyPropagator);
    	Addblock(event, blockEarthCrystalCluster);
    	Addblock(event, blockWaterCrystalCluster);
    	Addblock(event, blockAirCrystalCluster);
    	Addblock(event, blockFireCrystalCluster);
    	Addblock(event, blockLeyDesynth);
    	Addblock(event, blockMutationStation);
    	Addblock(event, blockUraniumOre);
    	Addblock(event, blockSaltOre);
    	Addblock(event, blockCopperScaff);
    	Addblock(event, blockZincScaff);
    	Addblock(event, blockDiamondScaff);
    	Addblock(event, blockRedstoneScaff);
    	Addblock(event, blockIronScaff);
    	Addblock(event, blockGoldScaff);
    	Addblock(event, blockSiliconScaff);
    	Addblock(event, blockRustedIronScaff);
    	Addblock(event, blockDiamondBot);
    	Addblock(event, blockFishTank);
    	Addblock(event, blockDiamondSpeedBlock);
    	Addblock(event, blockDiamondRangeBlock);
    	Addblock(event, blockAnalyser);
    	Addblock(event, blockInscriber);
    	Addblock(event, blockResearch);
    	
    	Addblock(event, blockRustedAnalyser);
    	Addblock(event, blockRustedBot);
    	Addblock(event, blockRustedHydrophonic);
    	Addblock(event, blockRustedMutationStation);
    	Addblock(event, blockRustedInscriber);
    	Addblock(event, blockRustedResearch);
    	
    	Addblock(event, blockCopperSheetBlock);
    	Addblock(event, blockZincSheetBlock);
    	Addblock(event, blockDiamondSheetBlock);
    	Addblock(event, blockRedstoneSheetBlock);
    	Addblock(event, blockIronSheetBlock);
    	Addblock(event, blockGoldSheetBlock);
    	Addblock(event, blockSiliconSheetBlock);
    	Addblock(event, blockRustedIronSheetBlock);
    	Addblock(event, blockRustedCopperSheetBlock);
    	
    	Addblock(event, blockRustedCopperTileSheetBlock);
    	Addblock(event, blockRustedIronTileSheetBlock);
    	Addblock(event, blockCopperTileSheetBlock);
    	Addblock(event, blockIronTileSheetBlock);
    	Addblock(event, blockDiamondTileSheetBlock);
    	Addblock(event, blockSiliconTileSheetBlock);
    	Addblock(event, blockZincTileSheetBlock);
    	Addblock(event, blockRedstoneTileSheetBlock);
    	Addblock(event, blockGoldTileSheetBlock);
    	
    	Addblock(event, blockRustedPipe);
    	
    	Additem(event, inscribedironsheet);
    	Additem(event, inscribedredstonesheet);
    	Additem(event, inscribedcoppersheet);
    	Additem(event, inscribeddiamondsheet);
    	Additem(event, inscribedsiliconsheet);
    	Additem(event, inscribedzincsheet);
    	Additem(event, inscribedgoldsheet);
    	
    	Additem(event, inscribedironprocessor);
    	Additem(event, inscribeddiamondprocessor);
    	Additem(event, inscribedgoldprocessor);
    	Additem(event, inscribedredstoneprocessor);
    	
    	Additem(event, aircrystalshards);
    	Additem(event, watercrystalshards);
    	Additem(event, firecrystalshards);
    	Additem(event, earthcrystalshards);
    	Additem(event, pristineaircrystal);
    	Additem(event, pristineearthcrystal);
    	Additem(event, pristinefirecrystal);
    	Additem(event, pristinewatercrystal);
    	Additem(event, uraniumchunk);
    	//end of 0.9
    	
    	Addblock(event, blockSeaweedCrop);
    	Addblock(event, blockKelpCrop);
    	Addblock(event, blockCoralRock);
    	Addblock(event, blockCoralRockSmooth);
    	Addblock(event, blockCoralRockBrick);
    	Addblock(event, blockCoralRockBrickMossy);
    	Addblock(event, blockCoralRockCarved);
    	Addblock(event, blockNetBlock);
    	Addblock(event, blockDryingRack);
    	Addblock(event, blockLiquidBarrel);
    	
    	Addblock(event, blockWhiteCoral);
    	Addblock(event, blockRedCoral);
    	Addblock(event, blockGreenCoral);
    	Addblock(event, blockBlueCoral);
    	Addblock(event, blockBlackCoral);
    	Addblock(event, blockYellowCoral);
    	Addblock(event, blockOrangeCoral);
    	
    	Additem(event, zombiejerky);
    	Additem(event, saucepanguide);
    	Additem(event, banana);
    	Additem(event, vanillaboiled);
    	Additem(event, strawberryboiled);
    	Additem(event, mintboiled);
    	Additem(event, chocolateboiled);
    	Additem(event, lemonboiled);
    	Additem(event, vanillaicecreammix);
    	Additem(event, strawberryicecreammix);
    	Additem(event, minticecreammix);
    	Additem(event, chocolateicecreammix);
    	Additem(event, lemonicecreammix);
    	Additem(event, mintessence);
    	Additem(event, vanillaicecream);
    	Additem(event, lemonicecream);
    	Additem(event, strawberryicecream);
    	Additem(event, chocolateicecream);
    	Additem(event, minticecream);
    	
    	Additem(event, breadtinguide);
    	Additem(event, caketinguide);
    	Additem(event, breadtin);
    	Additem(event, caketin);
    	Additem(event, breadtinmold);
    	Additem(event, caketinmold);
    	Additem(event, unfiredbreadtinmold);
    	Additem(event, unfiredcaketinmold);
    	Additem(event, kiwi);
    	Additem(event, mango);
    	Additem(event, kiwijuice);
    	Additem(event, mangojuice);
    	Additem(event, bananaslice);
    	Additem(event, bananadough);
    	Additem(event, bananabread);
    	
    	Additem(event, mysteriousorb);
    	Additem(event, giftofthesea);
    	Additem(event, giftofthesun);
    	Additem(event, giftofthesky);
    	Additem(event, giftofthesoil);
    	
    	Addblock(event, blockPalmSapling);
    	Addblock(event, blockBananaSapling);
    	Addblock(event, blockCoconutSapling);
    	Addblock(event, blockPalmLog);
    	Addblock(event, blockPalmLeaves);
    	Addblock(event, blockCoconutLeaves);
    	Addblock(event, blockCoconutBlock);
    	Addblock(event, blockBananaLeaves);
    	Addblock(event, blockBananaBlock);
    	Addblock(event, blockSaucePan);
    	Addblock(event, blockUnfiredSaucePan);
    	Addblock(event, blockBasalt);
    	Addblock(event, blockBasaltSmooth);
    	Addblock(event, blockHydrothermal);
    	Addblock(event, blockYellowCoralBlock);
    	Addblock(event, blockBlueCoralBlock);
    	Addblock(event, blockBlackCoralBlock);
    	Addblock(event, blockRedCoralBlock);
    	Addblock(event, blockGreenCoralBlock);
    	Addblock(event, blockOrangeCoralBlock);
    	Addblock(event, blockWhiteCoralBlock);
    	Addblock(event, blockPalmPlanks);
    	Addblock(event, blockIceBox);
    	Addblock(event, blockMangoLeaf);
    	Addblock(event, blockKiwiLeaf);
    	Addblock(event, blockMangoSapling);
    	Addblock(event, blockKiwiSapling);
    	
    	Additem(event, riceSeed);
    	Additem(event, rice);
    	Additem(event, woodenscythe);
    	Additem(event, stonescythe);
    	Additem(event, ironscythe);
    	Additem(event, goldscythe);
    	Additem(event, diamondscythe);
    	Additem(event, needle);
    	Additem(event, pigneedle);
    	Additem(event, cowneedle);
    	Additem(event, sheepneedle);
    	Additem(event, chickenneedle);
    	Additem(event, rabbitneedle);
    	Additem(event, dirtyneedle);
    	Additem(event, avocado);
    	Additem(event, onigiri);
    	Additem(event, redstoneprocessor);
    	Additem(event, ironprocessor);
    	Additem(event, diamondprocessor);
    	Additem(event, diamondsheet);
    	Additem(event, redstonesheet);
    	Additem(event, siliconsheet);
    	Additem(event, silicondust);
    	Additem(event, siliconchip);
    	Additem(event, goldwire);
    	Additem(event, uncasedchip);
    	Additem(event, chipmold);
    	Additem(event, pricklypearseeds);
    	Additem(event, pricklypear);
    	Additem(event, pricklypearpeeled);
    	Additem(event, crystalcore);
    	Additem(event, waterorb);
    	Additem(event, californiaroll);
    	Additem(event, sushiroll);
    	Additem(event, prawnsushi);
    	
    	Addblock(event, blockRiceCrop);
    	Addblock(event, blockPricklyPearCrop);
    	Addblock(event, blockHydrophonic);
    	Addblock(event, blockVat);
    	Addblock(event, blockBot);
    	Addblock(event, blockAvocadoSapling);
    	Addblock(event, blockAvocadoLeaf);
    	Addblock(event, blockGrowthCrystal);
    	Addblock(event, blockWaterCrystal);
    	
    	Additem(event, basicschematic);
    	Additem(event, advancedschematic);
    	Additem(event, complexschematic);
    	Additem(event, teleportcrystal);
    	Additem(event, tangleheartshard);
    	Additem(event, unfiredsphere);
    	Additem(event, spheremold);
    	Additem(event, sphereguide);
    	Additem(event, moltenglass);
    	Additem(event, moltenorb);
    	Additem(event, chipguide);
    	Additem(event, unfiredchipmoldmold);
    	Additem(event, chipmoldmold);
    	
    	Addblock(event, blockGrabber);
    	Addblock(event, blockFisher);
    	Addblock(event, blockTangleLog);
    	Addblock(event, blockTangleLeaves);
    	Addblock(event, blockLightCrystal);
    	Addblock(event, blockSkyCrystal);
    	Addblock(event, blockTangleHeart);
    	Addblock(event, blockLightAir);
    	Addblock(event, blockInfusedGlass);
    	Addblock(event, blockNetworkBlock);
    	Addblock(event, blockGatherer);
    	
    	
    	
    	Additem(event, leek);
    	Additem(event, leekseeds);
    	Additem(event, lettuce);
    	Additem(event, lettuceseeds);
    	Additem(event, coffeebean);
    	Additem(event, coffeeseeds);
    	Additem(event, corn);
    	Additem(event, cornseeds);
    	
    	Addblock(event, blockLeekCrop);
    	Addblock(event, blockLettuceCrop);
    	Addblock(event, blockCoffeeCrop);
    	Addblock(event, blockCornCrop);
    	
    }

    private void AddHerbPestleRecipes(){
    	
    	GameRegistry.addShapelessRecipe(new ItemStack(buchuleaf, 1), new Object[] {new ItemStack(Item.getItemFromBlock(blockBuchu)), new ItemStack(pestle)});
    	GameRegistry.addShapelessRecipe(new ItemStack(licoriceleaf, 1), new Object[] {new ItemStack(Item.getItemFromBlock(blockLicorice)), new ItemStack(pestle)});
    	GameRegistry.addShapelessRecipe(new ItemStack(sageleaf, 1), new Object[] {new ItemStack(Item.getItemFromBlock(blockSage)), new ItemStack(pestle)});
    	GameRegistry.addShapelessRecipe(new ItemStack(mintleaf, 1), new Object[] {new ItemStack(Item.getItemFromBlock(blockMint)), new ItemStack(pestle)});
    	GameRegistry.addShapelessRecipe(new ItemStack(rosemaryleaf, 1), new Object[] {new ItemStack(Item.getItemFromBlock(blockRosemary)), new ItemStack(pestle)});
    	GameRegistry.addShapelessRecipe(new ItemStack(chamomileflower, 1), new Object[] {new ItemStack(Item.getItemFromBlock(blockChamomile)), new ItemStack(pestle)});
    	
    }

    private void AddLoot(){
    	CookingPlusLootHelper.instance().AddPotteryGuide(cuptrayguide, false); //advanced
    	CookingPlusLootHelper.instance().AddPotteryGuide(mugguide, false); //basic
    	CookingPlusLootHelper.instance().AddPotteryGuide(teapotguide, false); //complex
    	CookingPlusLootHelper.instance().AddPotteryGuide(plateguide, false); //basic
    	CookingPlusLootHelper.instance().AddPotteryGuide(fryingpanguide, false); //advanced
    	CookingPlusLootHelper.instance().AddPotteryGuide(juicerguide, false); // basic
    	CookingPlusLootHelper.instance().AddPotteryGuide(saucepanguide, false); //advanced
    	CookingPlusLootHelper.instance().AddPotteryGuide(breadtinguide, false); //advanced
    	
    	CookingPlusLootHelper.instance().AddPotteryGuide(caketinguide, true); //complex
    	CookingPlusLootHelper.instance().AddPotteryGuide(largecuptrayguide, true); //complex
    	CookingPlusLootHelper.instance().AddPotteryGuide(sphereguide, true); //complex
    	CookingPlusLootHelper.instance().AddPotteryGuide(chipguide, true); //complex
    	
    	CookingPlusLootHelper.instance().AddFish(Items.FISH, false);
    	CookingPlusLootHelper.instance().AddFish(shelledprawn, false);
    	CookingPlusLootHelper.instance().AddFish(shelledoyster, false);
    	CookingPlusLootHelper.instance().AddFish(shelledcrab, false);
    	CookingPlusLootHelper.instance().AddFish(shelledlobster, true);
    	
    	CookingPlusLootHelper.instance().AddSeed(grapeseed);
    	CookingPlusLootHelper.instance().AddSeed(vanillaseed);
    	CookingPlusLootHelper.instance().AddSeed(hopseed);
    	CookingPlusLootHelper.instance().AddSeed(chilliseed);
    	CookingPlusLootHelper.instance().AddSeed(onionseed);
    	CookingPlusLootHelper.instance().AddSeed(coffeeseeds);
    	CookingPlusLootHelper.instance().AddSeed(leekseeds);
    	CookingPlusLootHelper.instance().AddSeed(lettuceseeds);
    	CookingPlusLootHelper.instance().AddSeed(cornseeds);
    	CookingPlusLootHelper.instance().AddSeed(pineappleseed);
    	CookingPlusLootHelper.instance().AddSeed(riceSeed);
    	CookingPlusLootHelper.instance().AddSeed(pricklypearseeds);
    	CookingPlusLootHelper.instance().AddSeed(cottonseed);
    	
    	CookingPlusLootHelper.instance().AddGenericItem(circlecutter);
    	CookingPlusLootHelper.instance().AddGenericItem(starcutter);
    	CookingPlusLootHelper.instance().AddGenericItem(heartcutter);
    	if(CookingPlusConfig.removeCraftedItemsFromChestLoot == false){
    		CookingPlusLootHelper.instance().AddGenericItem(woodenscythe);
    		CookingPlusLootHelper.instance().AddGenericItem(fishingnet);
    		CookingPlusLootHelper.instance().AddGenericItem(Item.getItemFromBlock(blockRope));
    		CookingPlusLootHelper.instance().AddGenericItem(mug);
    		CookingPlusLootHelper.instance().AddGenericItem(mysteriousorb);
    		CookingPlusLootHelper.instance().AddGenericItem(chipmold);
    	}
    }

    private void AddExtraBlockData(){
    	((CookingPlusEasyLeaf)blockMangoLeaf).SetDrops(blockMangoLeaf, blockMangoSapling, mango);
    	((CookingPlusEasyLeaf)blockKiwiLeaf).SetDrops(blockKiwiLeaf, blockKiwiSapling, kiwi);
    	((CookingPlusEasyLeaf)blockAvocadoLeaf).SetDrops(blockAvocadoLeaf, blockAvocadoSapling, avocado);
    	
    	((CookingPlusEasySapling)blockMangoSapling).SetBlocks(blockMangoLeaf, blockMangoSapling, Blocks.LOG);
    	((CookingPlusEasySapling)blockKiwiSapling).SetBlocks(blockKiwiLeaf, blockKiwiSapling, Blocks.LOG);
    	((CookingPlusEasySapling)blockAvocadoSapling).SetBlocks(blockAvocadoLeaf, blockAvocadoSapling, Blocks.LOG);
    	
    	((CookingPlusEasyCrop)blockRiceCrop).SetData(Blocks.WATER, rice, riceSeed);
    	((CookingPlusEasyCrop)blockPricklyPearCrop).SetData(Blocks.SAND, pricklypear, pricklypearseeds);
    	((CookingPlusEasyCrop)blockLeekCrop).SetData(Blocks.FARMLAND, leek, leekseeds);
    	((CookingPlusEasyCrop)blockLettuceCrop).SetData(Blocks.FARMLAND, lettuce, lettuceseeds);
    	((CookingPlusEasyCrop)blockCoffeeCrop).SetData(Blocks.FARMLAND, coffeebean, coffeeseeds);
    	((CookingPlusEasyCrop)blockCornCrop).SetData(Blocks.FARMLAND, corn, cornseeds);
    	
    	
    	//0.9 mutant crops
    	((CookingPlusEasyCrop)blockCoalCrop).SetData(Blocks.FARMLAND, coalLeaf, coalSeeds);
    	((CookingPlusEasyCrop)blockRedstoneCrop).SetData(Blocks.FARMLAND, redstoneLeaf, redstoneSeeds);
    	((CookingPlusEasyCrop)blockQuartzCrop).SetData(Blocks.FARMLAND, quartzLeaf, quartzSeeds);
    	((CookingPlusEasyCrop)blockLapisCrop).SetData(Blocks.FARMLAND, lapisLeaf, lapisSeeds);
    	((CookingPlusEasyCrop)blockIronCrop).SetData(Blocks.FARMLAND, ironLeaf, ironSeeds);
    	((CookingPlusEasyCrop)blockDiamondCrop).SetData(Blocks.FARMLAND, diamondLeaf, diamondSeeds);
    	((CookingPlusEasyCrop)blockEmeraldCrop).SetData(Blocks.FARMLAND, emeraldLeaf, emeraldSeeds);
    	((CookingPlusEasyCrop)blockGoldCrop).SetData(Blocks.FARMLAND, goldLeaf, goldSeeds);
    	((CookingPlusEasyCrop)blockGlowstoneCrop).SetData(Blocks.FARMLAND, glowstoneLeaf, glowstoneSeeds);
    	((CookingPlusEasyCrop)blockUraniumCrop).SetData(Blocks.FARMLAND, uraniumLeaf, uraniumSeeds);
    	((CookingPlusEasyCrop)blockCopperCrop).SetData(Blocks.FARMLAND, copperLeaf, copperSeeds);
    	((CookingPlusEasyCrop)blockZincCrop).SetData(Blocks.FARMLAND, zincLeaf, zincSeeds);
    	((CookingPlusEasyCrop)blockSiliconCrop).SetData(Blocks.FARMLAND, siliconLeaf, siliconSeeds);
    	((CookingPlusEasyCrop)blockAirCrop).SetData(Blocks.FARMLAND, airLeaf, airSeeds);
    	((CookingPlusEasyCrop)blockEarthCrop).SetData(Blocks.FARMLAND, earthLeaf, earthSeeds);
    	((CookingPlusEasyCrop)blockWaterCrop).SetData(Blocks.FARMLAND, waterLeaf, waterSeeds);
    	((CookingPlusEasyCrop)blockFireCrop).SetData(Blocks.FARMLAND, fireLeaf, fireSeeds);
    }

    private void RegisterBlockDictionary(String name, Block myBlock){
    	OreDictionary.registerOre(name, myBlock);
    }
    
    private void RegisterItemDictionary(String name, Item myItem){
    	OreDictionary.registerOre(name, myItem);
    }

    private void RegisterDimensions(){
    	//CookingPlusConfig.EdenDimensionID = DimensionManager.getNextFreeDimId();
    	//DimensionType.register("EDEN", "agricultural_revolution", CookingPlusConfig.EdenDimensionID, CookingPlusEdenDimension.class, false);
    	//DimensionManager.registerDimension(CookingPlusConfig.EdenDimensionID, DimensionType.getById(CookingPlusConfig.EdenDimensionID));
    	//DimensionManager.registerProviderType(CookingPlusConfig.EdenDimensionID, CookingPlusEdenDimension.class, false);
    	//DimensionManager.registerDimension(CookingPlusConfig.EdenDimensionID, CookingPlusConfig.EdenDimensionID);
    }
     
    public void RegisterDictionary(){
    	RegisterBlockDictionary("plankWood", blockBambooBlock);
    	RegisterBlockDictionary("plankWood", blockPalmPlanks);
    	RegisterBlockDictionary("logWood", blockBamboo);
    	RegisterBlockDictionary("logWood", blockPalmLog);
    	RegisterBlockDictionary("logWood", blockTangleLog);
    	RegisterBlockDictionary("foodCoconut", blockCoconutBlock);
    	RegisterBlockDictionary("oreSalt", blockSaltOre);
    	RegisterBlockDictionary("oreUranium", blockUraniumOre);
    	RegisterBlockDictionary("blockSalt", blockSalt);
    	RegisterBlockDictionary("oreCopper", blockCopperOre);
    	RegisterBlockDictionary("oreZinc", blockZincOre);
    	
    	RegisterBlockDictionary("cropPineapple", blockPineappleCrop);
    	RegisterBlockDictionary("cropRice", blockRiceCrop);
    	RegisterBlockDictionary("cropChilli", blockChilliCrop);
    	RegisterBlockDictionary("cropOnion", blockOnionCrop);
    	RegisterBlockDictionary("cropCotton", blockCottonCrop);
    	RegisterBlockDictionary("cropPricklyPear", blockPricklyPearCrop);
    	RegisterBlockDictionary("cropTea", blockTeaCrop);
    	
    	RegisterBlockDictionary("dyeYellow", blockYellowCoral);
    	RegisterBlockDictionary("dyeBlue", blockBlueCoral);
    	RegisterBlockDictionary("dyeBlack", blockBlackCoral);
    	RegisterBlockDictionary("dyeWhite", blockWhiteCoral);
    	RegisterBlockDictionary("dyeOrange", blockOrangeCoral);
    	RegisterBlockDictionary("dyeRed", blockRedCoral);
    	RegisterBlockDictionary("dyeGreen", blockGreenCoral);
    	
    	RegisterItemDictionary("dustSalt", saltpile);
    	
    	RegisterItemDictionary("listAllseed", grapeseed);
    	RegisterItemDictionary("listAllseed", vanillaseed);
    	RegisterItemDictionary("listAllseed", hopseed);
    	RegisterItemDictionary("listAllseed", chilliseed);
    	RegisterItemDictionary("listAllseed", onionseed);
    	RegisterItemDictionary("listAllseed", coffeeseeds);
    	RegisterItemDictionary("listAllseed", leekseeds);
    	RegisterItemDictionary("listAllseed", lettuceseeds);
    	RegisterItemDictionary("listAllseed", cornseeds);
    	RegisterItemDictionary("listAllseed", pineappleseed);
    	RegisterItemDictionary("listAllseed", riceSeed);
    	RegisterItemDictionary("listAllseed", pricklypearseeds);
    	RegisterItemDictionary("listAllseed", cottonseed);
    	
    	RegisterItemDictionary("foodCherry", cherry);
    	RegisterItemDictionary("foodLime", lime);
    	RegisterItemDictionary("foodLemon", lemon);
    	RegisterItemDictionary("foodPeach", peach);
    	RegisterItemDictionary("foodAvocado", avocado);
    	RegisterItemDictionary("foodMango", mango);
    	RegisterItemDictionary("foodKiwi", kiwi);
    	RegisterItemDictionary("foodBanana", banana);
    	RegisterItemDictionary("foodVanilla", vanillapod);
    	RegisterItemDictionary("foodHop", hops);
    	RegisterItemDictionary("foodGrape", grape);
    	RegisterItemDictionary("foodBlueberry", blueberry);
    	RegisterItemDictionary("foodGooseberry", gooseberry);
    	RegisterItemDictionary("foodStrawberry", strawberry);
    	RegisterItemDictionary("foodRice", rice);
    	RegisterItemDictionary("foodChilli", chilli);
    	RegisterItemDictionary("foodBeetroot", beetroot);
    	RegisterItemDictionary("foodOnion", onion);
    	RegisterItemDictionary("foodPineapple", pineapple);
    	RegisterItemDictionary("foodOrange", orange);
    	RegisterItemDictionary("foodLeek", leek);
    	RegisterItemDictionary("foodCoffeeBean", coffeebean);
    	RegisterItemDictionary("foodLettuce", lettuce);
    	RegisterItemDictionary("foodCorn", corn);
    	
    	RegisterItemDictionary("materialCotton", cottonbud);
    	RegisterItemDictionary("materialFlour", flour);
    	
    	RegisterItemDictionary("ingotCopper", copperingot);
    	RegisterItemDictionary("ingotZinc", zincingot);
    }
}
