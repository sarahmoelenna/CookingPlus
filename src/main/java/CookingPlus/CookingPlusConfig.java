package CookingPlus;

import CookingPlus.recipes.CookingPlusOvenRecipes;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CookingPlusConfig {

	public static int OrchardSpawnWeight;
	public static int BambooGroveSpawnWeight;
	public static int KelpForestSpawnWeight;
	public static int CoralReefSpawnWeight;
	public static int TropicalSpawnWeight;
	public static int DeepReefSpawnWeight;
	
	public static int AbandonedFarmHouseSpawnRate;
	public static int BushSpawnRate;
	public static int FruitTreeSpawnRate;
	public static int HerbSpawnRate;
	public static int CornucopiaSpawnRate;
	public static int ShipWreckSpawnRate;
	public static int SeaweedSpawnRate;
	public static int TempleSpawnRate;
	public static int TropicalHutSpawnRate;
	public static int UnderwaterVentSpawnRate;
	public static int GiantCoralDensity;
	public static int NetherTangleSpawnRate;
	public static int InlandHydrothermalVeinSpawnRate;
	public static int AbandonedLabSpawnRate;
	
	public static int CoralReefID;
	public static int BambooGroveID;
	public static int OrchardID;
	public static int KelpForestID;
	public static int TropicalID;
	public static int DeepReefID;
	public static int EdenDimensionID;
	
	public static boolean vanillarecipes;
	public static boolean SpawnedHerbSpreading;
	public static boolean PlayerHerbSpreading;
	public static boolean CoralSpreading;
	public static boolean SjinBot;
	public static boolean OverwriteMushroomBiomes;
	public static boolean AllowGuideCopy;
	public static boolean EnableBotNetwork;
	public static boolean MoveModFoodRecipesToBrickOven;
	public static int PreGeneratedIslandCount;
	
	public static int FruitDropRate;
	public static int CoralSpreadRate;
	public static int HerbSpreadRate;
	
	public static int HydrophonicGrowthRate;
	public static int HHBHarvestRate;
	public static int HHBPickRate;
	public static int HHBFishRate;
	public static int HHBGatherRate;
	public static int HHBDesalinationRate;
	public static int HHBLoggerRate;
	public static int HHBPlanterRate;
	public static int HHBFishTankExtractionRate;
	public static float HHBGoldSpeedModifier;
	public static float HHBDiamondSpeedModifier;
	public static int GrowthCrystalGrowRate;
	
	public static boolean disableSaltSpawn;
	public static boolean disableCopperSpawn;
	public static boolean disableZincSpawn;
	public static boolean disableCrystalSpawn;
	public static boolean disableUraniumSpawn;
	public static boolean disableCrystalDecay;
	public static boolean disableEnergyRequirement;
	
	public static boolean enableSaltBlockOreDictionaryCrafting;
	public static boolean enableBrickOvenRecipeTransferDebug;
	public static boolean enableHydrophonicBlockSeedDebug;
	public static boolean enableAutoDetectSeedEligibilityForHydrophonicBlock;
	
	public static boolean removeCraftedItemsFromChestLoot;
	public static boolean addSeedsToGrassLoot;
	
	public void PreInt(FMLPreInitializationEvent e){
		
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		
		config.load();

		
		OrchardSpawnWeight = config.getInt("orchardSpawnWeight", "SpawnRates", 2, 0, 1000, "");
		BambooGroveSpawnWeight = config.getInt("bambooGroveSpawnWeight", "SpawnRates", 10, 0, 1000, "");
		KelpForestSpawnWeight = config.getInt("kelpForestSpawnWeight", "SpawnRates", 10, 0, 1000, "");
		CoralReefSpawnWeight = config.getInt("coralReefSpawnWeight", "SpawnRates", 10, 0, 1000, "");
		TropicalSpawnWeight = config.getInt("TropicalSpawnWeight", "SpawnRates", 10, 0, 1000, "");
		DeepReefSpawnWeight = config.getInt("DeepReefSpawnWeight", "SpawnRates", 10, 0, 1000, "");
			
		AbandonedFarmHouseSpawnRate = config.getInt("AbandonedFarmHouseSpawnRate", "SpawnRates", 192, 0, 1000, "0 prevents these from spawning");
		BushSpawnRate = config.getInt("BushSpawnRate", "SpawnRates", 10, 0, 1000, "0 prevents these from spawning");
		HerbSpawnRate = config.getInt("HerbSpawnRate", "SpawnRates", 15, 0, 1000, "0 prevents these from spawning");
		FruitTreeSpawnRate = config.getInt("FruitTreeSpawnRate", "SpawnRates", 35, 0, 1000, "0 prevents these from spawning");
		CornucopiaSpawnRate = config.getInt("CornucopiaSpawnRate", "SpawnRates", 85, 0, 1000, "0 prevents these from spawning");
		ShipWreckSpawnRate = config.getInt("ShipWreckSpawnRate", "SpawnRates", 30, 0, 1000, "0 prevents these from spawning");
		SeaweedSpawnRate = config.getInt("SeaweedSpawnRate", "SpawnRates", 6, 0, 1000, "0 prevents these from spawning");
		TempleSpawnRate = config.getInt("TempleSpawnRate", "SpawnRates", 30, 0, 1000, "0 prevents these from spawning");
		TropicalHutSpawnRate = config.getInt("TropicalHutSpawnRate", "SpawnRates", 40, 0, 1000, "0 prevents these from spawning");
		UnderwaterVentSpawnRate = config.getInt("UnderwaterVentSpawnRate", "SpawnRates", 20, 0, 1000, "0 prevents these from spawning");
		GiantCoralDensity = config.getInt("GiantCoralDensity", "SpawnRates", 5, 0, 1000, "Number of attempts made to spawn a giant coral");
		NetherTangleSpawnRate = config.getInt("NetherTangleSpawnRate", "SpawnRates", 20, 0, 100, "0 prevents these from spawning");
		InlandHydrothermalVeinSpawnRate = config.getInt("InlandHydrothermalVeinSpawnRate", "SpawnRates", 200, 0, 1000, "0 prevents these from spawning");
		AbandonedLabSpawnRate = config.getInt("AbandonedLabSpawnRate", "SpawnRates", 200, 0, 1000, "0 prevents these from spawning");
		
		CoralReefID = config.getInt("CoralReefID", "Mod IDs", 53, 0, 1000, "");
		BambooGroveID = config.getInt("BambooGroveID", "Mod IDs", 51, 0, 1000, "");
		OrchardID = config.getInt("OrchardID", "Mod IDs", 50, 0, 1000, "");
		KelpForestID = config.getInt("KelpForestID", "Mod IDs", 52, 0, 1000, "");
		TropicalID = config.getInt("TropicalID", "Mod IDs", 54, 0, 1000, "");
		DeepReefID = config.getInt("DeepReefID", "Mod IDs", 55, 0, 1000, "");
		
		vanillarecipes = config.getBoolean("DisableVanillaFoodRecipes", "Options", true, "");
		SpawnedHerbSpreading = config.getBoolean("HerbSpreading", "Options", false, "This Determines whether naturally spawned herbs are allowed to spread");
		PlayerHerbSpreading = config.getBoolean("PlayerHerbSpreading", "Options", true, "This Determines whether player placed herbs are allowed to spread");
		CoralSpreading = config.getBoolean("CoralSpreading", "Options", true, "");
		SjinBot = config.getBoolean("SjinBot", "Options", false, "");
		OverwriteMushroomBiomes = config.getBoolean("OverwriteMushroomBiomes", "Options", false, "");
		AllowGuideCopy = config.getBoolean("AllowGuideCopying", "Options", true, "");
		EnableBotNetwork = config.getBoolean("EnableBotNetwork", "Options", true, "");
		PreGeneratedIslandCount = config.getInt("PreGeneratedIslandCount", "Options", 15, 1, 1000, "");
		
		FruitDropRate = config.getInt("FruitDropRate", "GrowthRate", 50, 0, 100, "The rate is a percentage");
		CoralSpreadRate = config.getInt("CoralSpreadRate", "GrowthRate", 25, 0, 100, "The rate is a percentage");
		HerbSpreadRate = config.getInt("HerbSpreadRate", "GrowthRate", 25, 0, 100, "The rate is a percentage");
		
		HydrophonicGrowthRate = config.getInt("HydrophonicGrowthRate", "BlockRates", 200, 0, 10000, "Ticks till growth");
		HHBHarvestRate = config.getInt("HappyHarvetBotHarvestRate", "BlockRates", 30, 0, 10000, "Ticks till harvest");
		HHBFishRate = config.getInt("HappyHarvetBotFishRate", "BlockRates", 300, 0, 10000, "Ticks till fish");
		HHBPickRate = config.getInt("HappyHarvetBotPickRate", "BlockRates", 30, 0, 10000, "Ticks till attempt to harvest");
		HHBGatherRate = config.getInt("HappyHarvetBotGatherRate", "BlockRates", 30, 0, 10000, "Ticks till attempt to gather");
		HHBDesalinationRate = config.getInt("HappyHarvetBotDesalinatorRate", "BlockRates", 500, 0, 10000, "Ticks till salt creation in desalinator");
		GrowthCrystalGrowRate = config.getInt("GrowthCrystalGrowRate", "BlockRates", 50, 0, 10000, "Ticks till attempt to grow");
		HHBLoggerRate = config.getInt("HappyHarvetBotLoggerRate", "BlockRates", 30, 0, 10000, "Ticks till attempt to chop wood");
		HHBPlanterRate = config.getInt("HappyHarvetBotPlanterRate", "BlockRates", 30, 0, 10000, "Ticks till attempt to plant sapling");
		HHBGoldSpeedModifier = config.getFloat("HappyHarvetBotGoldSpeedModifier", "BlockRates", 0.66f, 0, 1000, "Speed Modifier for the Golden Happy Harvest Bot");
		HHBDiamondSpeedModifier = config.getFloat("HappyHarvetBotDiamondSpeedModifier", "BlockRates", 0.33f, 0, 1000, "Speed Modifier for the Golden Happy Harvest Bot");
		HHBFishTankExtractionRate = config.getInt("HHBFishTankExtractionRate", "BlockRates", 100, 0, 10000, "Ticks till attempt to harvest");
		
		disableSaltSpawn = config.getBoolean("DisableSaltSpawn", "Options", false, "Set to true to disable salt ore spawning");
		disableCopperSpawn = config.getBoolean("DisableCopperSpawn", "Options", false, "Set to true to disable copper ore spawning");
		disableZincSpawn = config.getBoolean("DisableZincSpawn", "Options", false, "Set to true to disable zinc ore spawning");
		disableCrystalSpawn = config.getBoolean("DisableCrystalSpawn", "Options", false, "Set to true to disable crystal cluster spawning");
		disableCrystalDecay = config.getBoolean("DisableCrystalDecay", "Options", false, "Set to true to disable crystal from decaying while in a Ley Desynthesiser");
		disableUraniumSpawn = config.getBoolean("DisableUraniumSpawn", "Options", false, "Set to true to disable uranium ore spawning");
		disableEnergyRequirement = config.getBoolean("disableEnergyRequirement", "Options", false, "Set to true to disable machines from using needing energy");
		
		MoveModFoodRecipesToBrickOven = config.getBoolean("MoveModFoodRecipesToBrickOven", "Options", true, "Set to true to force mod food recipes to use brickoven instead of furnace");
		enableSaltBlockOreDictionaryCrafting = config.getBoolean("enableSaltBlockOreDictionaryCrafting", "Options", false, "set to true to let the Salt Block be crafted using other mods 'dustSalt'");
		enableAutoDetectSeedEligibilityForHydrophonicBlock = config.getBoolean("enableAutoDetectSeedEligibilityForHydrophonicBlock", "Options", true, "set this to true to allow the hydrophonic block to automatically attempt to identify valid seed/crops. WARNING this may cause crashes if it is wrong, in that case, stick to using the white lists.");
		enableBrickOvenRecipeTransferDebug = config.getBoolean("enableBrickOvenRecipeTransferDebug", "Debug", false, "set to true to output ore dictionary names and unlocalised names to the console log when the brick oven attempts to transfer modded items");
		enableHydrophonicBlockSeedDebug = config.getBoolean("enableHydrophonicBlockSeedDebug", "Debug", false, "set to true to output ore dictionary names and unlocalised names to the console log when the player attempts to place items in the hydrophonics block");
		
		removeCraftedItemsFromChestLoot = config.getBoolean("removeCraftedItemsFromChestLoot", "Options", false, "Set to true to remove crafted items from chest spawns, e.g. processors, guides, teapots etc");
		addSeedsToGrassLoot = config.getBoolean("addSeedsToGrassLoot", "Options", false, "Set to true to add all seeds to drops from grass");
		
		//white lists
		//WhiteList of Unlocalised name - brick oven
		String tempInputString = config.get(Configuration.CATEGORY_GENERAL, "modForceToOvenUnlocalisedNameWhiteList", "item.examplename", "when MoveModFoodRecipesToBrickOven is true, items with an unlocalised name that matches one of the input here are put into the brick oven recipes if they are the RESULT of a furnace recipe. Seperate strings with a comma.").getString();
		String[] toStringArray = tempInputString.split(",");
		for(int i = 0; i < toStringArray.length; i++) 
		{
			CookingPlusOvenRecipes.instance().whiteListedUnlocalisedName.add(toStringArray[i]);
		}
		
		//WhiteList of ore dictionary - brick oven
		tempInputString = config.get(Configuration.CATEGORY_GENERAL, "modForceToOvenOreDictionaryWhiteList", "exampleName", "when MoveModFoodRecipesToBrickOven is true, items with an ore dictionary name that matches one of the input here are put into the brick oven recipes if they are the RESULT of a furnace recipe. Seperate strings with a comma.").getString();
		toStringArray = tempInputString.split(",");
		for(int i = 0; i < toStringArray.length; i++) 
		{
			CookingPlusOvenRecipes.instance().whiteListedOreDictionary.add(toStringArray[i]);
		}
		
		//WhiteList of Unlocalised name - hydrophonic
		tempInputString = config.get(Configuration.CATEGORY_GENERAL, "HydrophonicBlockUnlocalisedNameWhiteList", "item.examplename", "Items with an unlocalised name that is in this list are allowed to be placed in a hydrophonic block. Seperate strings with a comma. WARNING some seeds can cause crashes if thier crops dont extend the vanilla BlockCrops").getString();
		toStringArray = tempInputString.split(",");
		for(int i = 0; i < toStringArray.length; i++) 
		{
			System.out.println(toStringArray[i]);
			CookingPlusLootHelper.instance().whiteListedHydrohonicUnlocalisedName.add(toStringArray[i]);
		}
				
		//WhiteList of ore dictionary - hydrophonic
		tempInputString = config.get(Configuration.CATEGORY_GENERAL, "HydrophonicBlockOreDictionaryWhiteList", "exampleName", "Items with an ore dictionary name that is in this list are allowed to be placed in a hydrophonic block. Seperate strings with a comma. WARNING some seeds can cause crashes if thier crops dont extend the vanilla BlockCrops").getString();
		toStringArray = tempInputString.split(",");
		for(int i = 0; i < toStringArray.length; i++) 
		{
			CookingPlusLootHelper.instance().whiteListedHydrohonicOreDictionary.add(toStringArray[i]);
		}
		
		config.save();
		
	}
	
}
