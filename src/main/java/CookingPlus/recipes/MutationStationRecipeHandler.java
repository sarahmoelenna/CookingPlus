package CookingPlus.recipes;

import java.util.ArrayList;
import java.util.Random;

import CookingPlus.CookingPlusMain;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MutationStationRecipeHandler {

	private static final MutationStationRecipeHandler MutStatBase = new MutationStationRecipeHandler();
	public final ArrayList<MutationStationSeedTier> seedTierList = new ArrayList();
	public final ArrayList<FishEggRecipe> fishEggList = new ArrayList();
	
	public final ArrayList<Block> TierOneCropList = new ArrayList();
	public final ArrayList<Block> TierTwoCropList = new ArrayList();
	public final ArrayList<Block> TierThreeCropList = new ArrayList();
	public final ArrayList<Block> TierFourCropList = new ArrayList();
	public final ArrayList<Block> TierFiveCropList = new ArrayList();
	
	public final ArrayList<Item> TierOneFishList = new ArrayList();
	public final ArrayList<Item> TierTwoFishList = new ArrayList();
	public final ArrayList<Item> TierThreeFishList = new ArrayList();
	public final ArrayList<Item> TierFourFishList = new ArrayList();
	public final ArrayList<Item> TierFiveFishList = new ArrayList();
	
	public MutationStationRecipeHandler(){
	}
	
	public static MutationStationRecipeHandler instance()
    {
        return MutStatBase;
    }
	
	public void setUpRecipes(){
		
		MutationStationSeedTier myTempTier = new MutationStationSeedTier(CookingPlusMain.onemutantSeeds, null, 0);
		myTempTier.addInputSeed(CookingPlusMain.vanillaseed);
		myTempTier.addInputSeed(CookingPlusMain.hopseed);
		myTempTier.addInputSeed(CookingPlusMain.grapeseed);
		myTempTier.addInputSeed(CookingPlusMain.chilliseed);
		myTempTier.addInputSeed(CookingPlusMain.coffeeseeds);
		myTempTier.addInputSeed(CookingPlusMain.leekseeds);
		myTempTier.addInputSeed(CookingPlusMain.cornseeds);
		myTempTier.addInputSeed(CookingPlusMain.onionseed);
		myTempTier.addInputSeed(CookingPlusMain.riceSeed);
		myTempTier.addInputSeed(CookingPlusMain.pineappleseed);
		myTempTier.addInputSeed(CookingPlusMain.pricklypearseeds);
		myTempTier.addInputSeed(CookingPlusMain.cottonseed);
		myTempTier.addInputSeed(CookingPlusMain.teaseed);
		myTempTier.addInputSeed(Items.WHEAT_SEEDS);
		myTempTier.addInputSeed(Items.BEETROOT_SEEDS);
		myTempTier.addInputSeed(Items.MELON_SEEDS);
		myTempTier.addInputSeed(Items.PUMPKIN_SEEDS);
		seedTierList.add(myTempTier);
		
		myTempTier = new MutationStationSeedTier(CookingPlusMain.twomutantSeeds, null, 0);
		myTempTier.addInputSeed(CookingPlusMain.redstoneSeeds);
		myTempTier.addInputSeed(CookingPlusMain.lapisSeeds);
		myTempTier.addInputSeed(CookingPlusMain.coalSeeds);
		myTempTier.addInputSeed(CookingPlusMain.quartzSeeds);
		seedTierList.add(myTempTier);
		
		myTempTier = new MutationStationSeedTier(CookingPlusMain.threemutantSeeds, null, 0);
		myTempTier.addInputSeed(CookingPlusMain.zincSeeds);
		myTempTier.addInputSeed(CookingPlusMain.glowstoneSeeds);
		seedTierList.add(myTempTier);
		
		myTempTier = new MutationStationSeedTier(CookingPlusMain.fourmutantSeeds, null, 0);
		myTempTier.addInputSeed(CookingPlusMain.copperSeeds);
		myTempTier.addInputSeed(CookingPlusMain.ironSeeds);
		seedTierList.add(myTempTier);
		
		myTempTier = new MutationStationSeedTier(CookingPlusMain.fivemutantSeeds, null, 0);
		myTempTier.addInputSeed(CookingPlusMain.goldSeeds);
		myTempTier.addInputSeed(CookingPlusMain.uraniumSeeds);
		myTempTier.addInputSeed(CookingPlusMain.siliconSeeds);
		seedTierList.add(myTempTier);
		
		myTempTier = new MutationStationSeedTier(CookingPlusMain.onemutantfishegg, CookingPlusMain.failedfishegg, 75);
		myTempTier.addInputSeed(CookingPlusMain.fishegg);
		seedTierList.add(myTempTier);
		
		myTempTier = new MutationStationSeedTier(CookingPlusMain.twomutantfishegg, CookingPlusMain.failedfishegg, 60);
		myTempTier.addInputSeed(CookingPlusMain.bonefishegg);
		myTempTier.addInputSeed(CookingPlusMain.leatherfishegg);
		myTempTier.addInputSeed(CookingPlusMain.rottenfishegg);
		seedTierList.add(myTempTier);
		
		myTempTier = new MutationStationSeedTier(CookingPlusMain.threemutantfishegg, CookingPlusMain.failedfishegg, 50);
		myTempTier.addInputSeed(CookingPlusMain.inkfishegg);
		myTempTier.addInputSeed(CookingPlusMain.eyefishegg);
		myTempTier.addInputSeed(CookingPlusMain.gunpowderfishegg);
		seedTierList.add(myTempTier);
		
		myTempTier = new MutationStationSeedTier(CookingPlusMain.fourmutantfishegg, CookingPlusMain.failedfishegg, 35);
		myTempTier.addInputSeed(CookingPlusMain.slimefishegg);
		myTempTier.addInputSeed(CookingPlusMain.enderfishegg);
		myTempTier.addInputSeed(CookingPlusMain.blazefishegg);
		seedTierList.add(myTempTier);
		
		myTempTier = new MutationStationSeedTier(CookingPlusMain.fivemutantfishegg, CookingPlusMain.failedfishegg, 20);
		myTempTier.addInputSeed(CookingPlusMain.magmafishegg);
		myTempTier.addInputSeed(CookingPlusMain.ghastfishegg);
		myTempTier.addInputSeed(CookingPlusMain.shardfishegg);
		seedTierList.add(myTempTier);
		
		TierOneCropList.add(CookingPlusMain.blockCoalCrop);
		TierOneCropList.add(CookingPlusMain.blockRedstoneCrop);
		TierOneCropList.add(CookingPlusMain.blockLapisCrop);
		TierOneCropList.add(CookingPlusMain.blockQuartzCrop);
		
		TierTwoCropList.add(CookingPlusMain.blockZincCrop);
		TierTwoCropList.add(CookingPlusMain.blockGlowstoneCrop);
		
		TierThreeCropList.add(CookingPlusMain.blockCopperCrop);
		TierThreeCropList.add(CookingPlusMain.blockIronCrop);
		
		TierFourCropList.add(CookingPlusMain.blockGoldCrop);
		TierFourCropList.add(CookingPlusMain.blockUraniumCrop);
		TierFourCropList.add(CookingPlusMain.blockSiliconCrop);
		
		TierFiveCropList.add(CookingPlusMain.blockDiamondCrop);
		TierFiveCropList.add(CookingPlusMain.blockEmeraldCrop);
		TierFiveCropList.add(CookingPlusMain.blockAirCrop);
		TierFiveCropList.add(CookingPlusMain.blockWaterCrop);
		TierFiveCropList.add(CookingPlusMain.blockEarthCrop);
		TierFiveCropList.add(CookingPlusMain.blockFireCrop);
		
		TierOneFishList.add(CookingPlusMain.rottenfish);
		TierOneFishList.add(CookingPlusMain.bonefish);
		TierOneFishList.add(CookingPlusMain.leatherfish);
		
		TierTwoFishList.add(CookingPlusMain.inkfish);
		TierTwoFishList.add(CookingPlusMain.eyefish);
		TierTwoFishList.add(CookingPlusMain.gunpowderfish);
		
		TierThreeFishList.add(CookingPlusMain.slimefish);
		TierThreeFishList.add(CookingPlusMain.enderfish);
		TierThreeFishList.add(CookingPlusMain.blazefish);
		
		TierFourFishList.add(CookingPlusMain.magmafish);
		TierFourFishList.add(CookingPlusMain.shardfish);
		TierFourFishList.add(CookingPlusMain.ghastfish);
		
		TierFiveFishList.add(CookingPlusMain.netherfish);
		TierFiveFishList.add(CookingPlusMain.crystalfish);
		
		fishEggList.add(new FishEggRecipe(CookingPlusMain.blazefish, CookingPlusMain.blazefishegg));
		fishEggList.add(new FishEggRecipe(CookingPlusMain.eyefish, CookingPlusMain.eyefishegg));
		fishEggList.add(new FishEggRecipe(CookingPlusMain.bonefish, CookingPlusMain.bonefishegg));
		fishEggList.add(new FishEggRecipe(CookingPlusMain.enderfish, CookingPlusMain.enderfishegg));
		fishEggList.add(new FishEggRecipe(CookingPlusMain.magmafish, CookingPlusMain.magmafishegg));
		fishEggList.add(new FishEggRecipe(CookingPlusMain.leatherfish, CookingPlusMain.leatherfishegg));
		fishEggList.add(new FishEggRecipe(CookingPlusMain.crystalfish, CookingPlusMain.crystalfishegg));
		fishEggList.add(new FishEggRecipe(CookingPlusMain.shardfish, CookingPlusMain.shardfishegg));
		fishEggList.add(new FishEggRecipe(CookingPlusMain.netherfish, CookingPlusMain.netherfishegg));
		fishEggList.add(new FishEggRecipe(CookingPlusMain.inkfish, CookingPlusMain.inkfishegg));
		fishEggList.add(new FishEggRecipe(CookingPlusMain.gunpowderfish, CookingPlusMain.gunpowderfishegg));
		fishEggList.add(new FishEggRecipe(CookingPlusMain.ghastfish, CookingPlusMain.ghastfishegg));
		fishEggList.add(new FishEggRecipe(CookingPlusMain.rottenfish, CookingPlusMain.rottenfishegg));
		fishEggList.add(new FishEggRecipe(CookingPlusMain.slimefish, CookingPlusMain.slimefishegg));
	}
	
	public boolean canItemMutate(Item myItem){
		for(int i = 0; i < seedTierList.size(); i++){
			if(seedTierList.get(i).doesContainSeed(myItem)){
				return true;
			}
		}
		return false;
	}
	
	public Item getOutputForItem(Item myItem){
		for(int i = 0; i < seedTierList.size(); i++){
			if(seedTierList.get(i).doesContainSeed(myItem)){
				if(seedTierList.get(i).getFailSeed() == null){
					return seedTierList.get(i).getOutputSeed();
				}
				else{
					Random myRand = new Random();
					if(myRand.nextInt(100) <= seedTierList.get(i).getSuccessChance()){
						return seedTierList.get(i).getOutputSeed();
					}
					else{
						return seedTierList.get(i).getFailSeed();
					}
				}
			}
		}
		return null;
	}
	
	public void addCrops(FMLInitializationEvent e){
		
		GameRegistry.addShapelessRecipe(new ItemStack(CookingPlusMain.silicondust, 1), new Object[] {new ItemStack(CookingPlusMain.pestle), new ItemStack(CookingPlusMain.siliconLeaf)});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.GLOWSTONE_DUST, 1), new Object[] {new ItemStack(CookingPlusMain.pestle), new ItemStack(CookingPlusMain.glowstoneLeaf)});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.REDSTONE, 1), new Object[] {new ItemStack(CookingPlusMain.pestle), new ItemStack(CookingPlusMain.redstoneLeaf)});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.DIAMOND, 1), new Object[] {new ItemStack(CookingPlusMain.pestle), new ItemStack(CookingPlusMain.diamondLeaf)});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.EMERALD, 1), new Object[] {new ItemStack(CookingPlusMain.pestle), new ItemStack(CookingPlusMain.emeraldLeaf)});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.COAL, 1), new Object[] {new ItemStack(CookingPlusMain.pestle), new ItemStack(CookingPlusMain.coalLeaf)});
		GameRegistry.addShapelessRecipe(new ItemStack(CookingPlusMain.aircrystalshards, 1), new Object[] {new ItemStack(CookingPlusMain.pestle), new ItemStack(CookingPlusMain.airLeaf)});
		GameRegistry.addShapelessRecipe(new ItemStack(CookingPlusMain.earthcrystalshards, 1), new Object[] {new ItemStack(CookingPlusMain.pestle), new ItemStack(CookingPlusMain.earthLeaf)});
		GameRegistry.addShapelessRecipe(new ItemStack(CookingPlusMain.watercrystalshards, 1), new Object[] {new ItemStack(CookingPlusMain.pestle), new ItemStack(CookingPlusMain.waterLeaf)});
		GameRegistry.addShapelessRecipe(new ItemStack(CookingPlusMain.firecrystalshards, 1), new Object[] {new ItemStack(CookingPlusMain.pestle), new ItemStack(CookingPlusMain.fireLeaf)});
		
		GameRegistry.addSmelting(CookingPlusMain.ironLeaf,new ItemStack(Items.IRON_INGOT), 5);
		GameRegistry.addSmelting(CookingPlusMain.copperLeaf,new ItemStack(CookingPlusMain.copperingot), 5);
		GameRegistry.addSmelting(CookingPlusMain.zincLeaf,new ItemStack(CookingPlusMain.zincLeaf), 5);
		GameRegistry.addSmelting(CookingPlusMain.goldLeaf,new ItemStack(Items.GOLD_INGOT), 5);
		GameRegistry.addSmelting(CookingPlusMain.lapisLeaf,new ItemStack(Items.DYE, 1, 4), 5);
		GameRegistry.addSmelting(CookingPlusMain.quartzLeaf,new ItemStack(Items.QUARTZ), 5);
		GameRegistry.addSmelting(CookingPlusMain.uraniumLeaf,new ItemStack(CookingPlusMain.uraniumchunk), 5);
		
		GameRegistry.addShapelessRecipe(new ItemStack(CookingPlusMain.boneessence, 2), new Object[] {new ItemStack(CookingPlusMain.knife), new ItemStack(CookingPlusMain.bonefish)});
		GameRegistry.addShapelessRecipe(new ItemStack(CookingPlusMain.eyeessence, 2), new Object[] {new ItemStack(CookingPlusMain.knife), new ItemStack(CookingPlusMain.eyefish)});
		GameRegistry.addShapelessRecipe(new ItemStack(CookingPlusMain.leatheressence, 2), new Object[] {new ItemStack(CookingPlusMain.knife), new ItemStack(CookingPlusMain.leatherfish)});
		GameRegistry.addShapelessRecipe(new ItemStack(CookingPlusMain.netheressence, 2), new Object[] {new ItemStack(CookingPlusMain.knife), new ItemStack(CookingPlusMain.netherfish)});
		GameRegistry.addShapelessRecipe(new ItemStack(CookingPlusMain.ghastessence, 2), new Object[] {new ItemStack(CookingPlusMain.knife), new ItemStack(CookingPlusMain.ghastfish)});
		GameRegistry.addShapelessRecipe(new ItemStack(CookingPlusMain.enderessence, 2), new Object[] {new ItemStack(CookingPlusMain.knife), new ItemStack(CookingPlusMain.enderfish)});
		GameRegistry.addShapelessRecipe(new ItemStack(CookingPlusMain.blazeessence, 2), new Object[] {new ItemStack(CookingPlusMain.knife), new ItemStack(CookingPlusMain.blazefish)});
		GameRegistry.addShapelessRecipe(new ItemStack(CookingPlusMain.magmaessence, 2), new Object[] {new ItemStack(CookingPlusMain.knife), new ItemStack(CookingPlusMain.magmafish)});
		GameRegistry.addShapelessRecipe(new ItemStack(CookingPlusMain.crystalessence, 2), new Object[] {new ItemStack(CookingPlusMain.knife), new ItemStack(CookingPlusMain.crystalfish)});
		GameRegistry.addShapelessRecipe(new ItemStack(CookingPlusMain.shardessence, 2), new Object[] {new ItemStack(CookingPlusMain.knife), new ItemStack(CookingPlusMain.shardfish)});
		GameRegistry.addShapelessRecipe(new ItemStack(CookingPlusMain.slimeessence, 2), new Object[] {new ItemStack(CookingPlusMain.knife), new ItemStack(CookingPlusMain.slimefish)});
		GameRegistry.addShapelessRecipe(new ItemStack(CookingPlusMain.gunpowderessence, 2), new Object[] {new ItemStack(CookingPlusMain.knife), new ItemStack(CookingPlusMain.gunpowderfish)});
		GameRegistry.addShapelessRecipe(new ItemStack(CookingPlusMain.rottenessence, 2), new Object[] {new ItemStack(CookingPlusMain.knife), new ItemStack(CookingPlusMain.rottenfish)});
		GameRegistry.addShapelessRecipe(new ItemStack(CookingPlusMain.inkessence, 2), new Object[] {new ItemStack(CookingPlusMain.knife), new ItemStack(CookingPlusMain.inkfish)});
		
		GameRegistry.addRecipe(new ItemStack(Items.MAGMA_CREAM), new Object[] {"###", "###", "###", '#', new ItemStack(CookingPlusMain.magmaessence)});
		GameRegistry.addRecipe(new ItemStack(Items.BONE), new Object[] {"###", "###", "###", '#', new ItemStack(CookingPlusMain.boneessence)});
		GameRegistry.addRecipe(new ItemStack(Items.DYE, 4), new Object[] {"###", "###", "###", '#', new ItemStack(CookingPlusMain.inkessence)});
		GameRegistry.addRecipe(new ItemStack(Items.GUNPOWDER), new Object[] {"###", "###", "###", '#', new ItemStack(CookingPlusMain.gunpowderessence)});
		GameRegistry.addRecipe(new ItemStack(Items.ROTTEN_FLESH), new Object[] {"###", "###", "###", '#', new ItemStack(CookingPlusMain.rottenessence)});
		GameRegistry.addRecipe(new ItemStack(Items.PRISMARINE_CRYSTALS), new Object[] {"###", "###", "###", '#', new ItemStack(CookingPlusMain.crystalessence)});
		GameRegistry.addRecipe(new ItemStack(Items.PRISMARINE_SHARD), new Object[] {"###", "###", "###", '#', new ItemStack(CookingPlusMain.shardessence)});
		GameRegistry.addRecipe(new ItemStack(Items.SLIME_BALL), new Object[] {"###", "###", "###", '#', new ItemStack(CookingPlusMain.slimeessence)});
		GameRegistry.addRecipe(new ItemStack(Items.ENDER_PEARL), new Object[] {"###", "###", "###", '#', new ItemStack(CookingPlusMain.enderessence)});
		GameRegistry.addRecipe(new ItemStack(Items.BLAZE_ROD), new Object[] {"###", "###", "###", '#', new ItemStack(CookingPlusMain.blazeessence)});
		GameRegistry.addRecipe(new ItemStack(Items.GHAST_TEAR), new Object[] {"###", "###", "###", '#', new ItemStack(CookingPlusMain.ghastessence)});
		GameRegistry.addRecipe(new ItemStack(Items.LEATHER), new Object[] {"###", "###", "###", '#', new ItemStack(CookingPlusMain.leatheressence)});
		GameRegistry.addRecipe(new ItemStack(Items.SPIDER_EYE), new Object[] {"###", "###", "###", '#', new ItemStack(CookingPlusMain.eyeessence)});
		GameRegistry.addRecipe(new ItemStack(Items.NETHER_STAR), new Object[] {"###", "###", "###", '#', new ItemStack(CookingPlusMain.netheressence)});
		
		CookingPlusMain.instance.Additem(e, CookingPlusMain.redstoneLeaf);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.coalLeaf);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.quartzLeaf);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.lapisLeaf);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.ironLeaf);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.goldLeaf);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.diamondLeaf);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.emeraldLeaf);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.glowstoneLeaf);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.uraniumLeaf);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.zincLeaf);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.copperLeaf);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.siliconLeaf);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.airLeaf);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.earthLeaf);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.fireLeaf);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.waterLeaf);
		
		CookingPlusMain.instance.Additem(e, CookingPlusMain.redstoneSeeds);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.coalSeeds);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.quartzSeeds);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.lapisSeeds);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.ironSeeds);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.goldSeeds);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.diamondSeeds);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.emeraldSeeds);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.glowstoneSeeds);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.uraniumSeeds);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.copperSeeds);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.zincSeeds);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.siliconSeeds);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.airSeeds);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.earthSeeds);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.fireSeeds);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.waterSeeds);
		
		CookingPlusMain.instance.Additem(e, CookingPlusMain.onemutantSeeds);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.twomutantSeeds);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.threemutantSeeds);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.fourmutantSeeds);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.fivemutantSeeds);
		
		CookingPlusMain.instance.Additem(e, CookingPlusMain.blazefishegg);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.magmafishegg);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.bonefishegg);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.enderfishegg);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.netherfishegg);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.leatherfishegg);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.gunpowderfishegg);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.crystalfishegg);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.shardfishegg);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.eyefishegg);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.ghastfishegg);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.inkfishegg);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.slimefishegg);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.rottenfishegg);
		
		CookingPlusMain.instance.Additem(e, CookingPlusMain.fishegg);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.failedfishegg);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.onemutantfishegg);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.twomutantfishegg);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.threemutantfishegg);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.fourmutantfishegg);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.fivemutantfishegg);
		
		CookingPlusMain.instance.Additem(e, CookingPlusMain.blazefish);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.magmafish);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.bonefish);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.enderfish);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.netherfish);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.leatherfish);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.gunpowderfish);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.crystalfish);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.shardfish);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.eyefish);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.ghastfish);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.inkfish);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.slimefish);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.rottenfish);
		
		CookingPlusMain.instance.Additem(e, CookingPlusMain.blazeessence);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.magmaessence);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.boneessence);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.enderessence);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.netheressence);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.leatheressence);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.gunpowderessence);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.crystalessence);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.shardessence);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.eyeessence);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.ghastessence);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.inkessence);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.slimeessence);
		CookingPlusMain.instance.Additem(e, CookingPlusMain.rottenessence);
		
		CookingPlusMain.instance.Addblock(e, CookingPlusMain.blockOneMutantCrop);
		CookingPlusMain.instance.Addblock(e, CookingPlusMain.blockTwoMutantCrop);
		CookingPlusMain.instance.Addblock(e, CookingPlusMain.blockThreeMutantCrop);
		CookingPlusMain.instance.Addblock(e, CookingPlusMain.blockFourMutantCrop);
		CookingPlusMain.instance.Addblock(e, CookingPlusMain.blockFiveMutantCrop);
		CookingPlusMain.instance.Addblock(e, CookingPlusMain.blockRedstoneCrop);
		CookingPlusMain.instance.Addblock(e, CookingPlusMain.blockCoalCrop);
		CookingPlusMain.instance.Addblock(e, CookingPlusMain.blockLapisCrop);
		CookingPlusMain.instance.Addblock(e, CookingPlusMain.blockQuartzCrop);
		
		CookingPlusMain.instance.Addblock(e, CookingPlusMain.blockIronCrop);
		CookingPlusMain.instance.Addblock(e, CookingPlusMain.blockGoldCrop);
		CookingPlusMain.instance.Addblock(e, CookingPlusMain.blockDiamondCrop);
		CookingPlusMain.instance.Addblock(e, CookingPlusMain.blockEmeraldCrop);
		CookingPlusMain.instance.Addblock(e, CookingPlusMain.blockGlowstoneCrop);
		CookingPlusMain.instance.Addblock(e, CookingPlusMain.blockUraniumCrop);
		CookingPlusMain.instance.Addblock(e, CookingPlusMain.blockSiliconCrop);
		CookingPlusMain.instance.Addblock(e, CookingPlusMain.blockCopperCrop);
		CookingPlusMain.instance.Addblock(e, CookingPlusMain.blockZincCrop);
		CookingPlusMain.instance.Addblock(e, CookingPlusMain.blockAirCrop);
		CookingPlusMain.instance.Addblock(e, CookingPlusMain.blockWaterCrop);
		CookingPlusMain.instance.Addblock(e, CookingPlusMain.blockEarthCrop);
		CookingPlusMain.instance.Addblock(e, CookingPlusMain.blockFireCrop);
	}
	
	public Block getRandomCrop(int Tier, Random myRand){
		if(Tier == 1){
			return TierOneCropList.get(myRand.nextInt(TierOneCropList.size()));
		}else if(Tier == 2){
			return TierTwoCropList.get(myRand.nextInt(TierTwoCropList.size()));
		}else if(Tier == 3){
			return TierThreeCropList.get(myRand.nextInt(TierThreeCropList.size()));
		}else if(Tier == 4){
			return TierFourCropList.get(myRand.nextInt(TierFourCropList.size()));
		}else if(Tier == 5){
			return TierFiveCropList.get(myRand.nextInt(TierFiveCropList.size()));
		}
		
		return null;
	}
	
	public Item getRandomEgg(int Tier, Random myRand){
		if(Tier == 1){
			return TierOneFishList.get(myRand.nextInt(TierOneFishList.size()));
		}else if(Tier == 2){
			return TierTwoFishList.get(myRand.nextInt(TierTwoFishList.size()));
		}else if(Tier == 3){
			return TierThreeFishList.get(myRand.nextInt(TierThreeFishList.size()));
		}else if(Tier == 4){
			return TierFourFishList.get(myRand.nextInt(TierFourFishList.size()));
		}else if(Tier == 5){
			return TierFiveFishList.get(myRand.nextInt(TierFiveFishList.size()));
		}
		
		return null;
	}

	public Item getEggForFish(Item myFish){
		for(int i = 0; i < fishEggList.size(); i++){
			if(fishEggList.get(i).getFish() == myFish){
				return fishEggList.get(i).getEgg();
			}
		}
		return null;
	}
	
	public Item getFishForEgg(Item myEgg){
		for(int i = 0; i < fishEggList.size(); i++){
			if(fishEggList.get(i).getEgg() == myEgg){
				return fishEggList.get(i).getFish();
			}
		}
		return null;
	}
}
