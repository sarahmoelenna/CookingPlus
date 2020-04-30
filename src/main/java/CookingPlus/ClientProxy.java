package CookingPlus;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import CookingPlus.Renderers.AnalyserRenderer;
import CookingPlus.Renderers.BotRenderer;
import CookingPlus.Renderers.ButterChurnRenderer;
import CookingPlus.Renderers.CookingPlusFermenterRenderer;
import CookingPlus.Renderers.CookingPlusInscriberRenderer;
import CookingPlus.Renderers.CookingPlusRender;
import CookingPlus.Renderers.CrystalRenderer;
import CookingPlus.Renderers.DesalinatorRenderer;
import CookingPlus.Renderers.DiamondBotRenderer;
import CookingPlus.Renderers.DiamondRangeBlockRenderer;
import CookingPlus.Renderers.DiamondSpeedBlockRenderer;
import CookingPlus.Renderers.DryingRackRenderer;
import CookingPlus.Renderers.FishTankRenderer;
import CookingPlus.Renderers.FisherRenderer;
import CookingPlus.Renderers.FryingPanRenderer;
import CookingPlus.Renderers.GathererRenderer;
import CookingPlus.Renderers.GoldBotRenderer;
import CookingPlus.Renderers.GoldenRangeBlockRenderer;
import CookingPlus.Renderers.GoldenSpeedBlockRenderer;
import CookingPlus.Renderers.GrabberRenderer;
import CookingPlus.Renderers.HeaterRenderer;
import CookingPlus.Renderers.HydrophonicRenderer;
import CookingPlus.Renderers.IceBoxRenderer;
import CookingPlus.Renderers.LaserDroneBayRenderer;
import CookingPlus.Renderers.LeyDesynthRenderer;
import CookingPlus.Renderers.LeyLineGeneratorRenderer;
import CookingPlus.Renderers.LeyLineReceiverRenderer;
import CookingPlus.Renderers.LiquidBarrelRenderer;
import CookingPlus.Renderers.Loggerrenderer;
import CookingPlus.Renderers.MarketBoxRender;
import CookingPlus.Renderers.MutationStationRenderer;
import CookingPlus.Renderers.NetBlockRenderer;
import CookingPlus.Renderers.OilPressRenderer;
import CookingPlus.Renderers.OrnateChestRenderer;
import CookingPlus.Renderers.PlanterRenderer;
import CookingPlus.Renderers.PlateRenderer;
import CookingPlus.Renderers.RangeBlockRenderer;
import CookingPlus.Renderers.ResearchRenderer;
import CookingPlus.Renderers.SaucepanRenderer;
import CookingPlus.Renderers.SheetPressRenderer;
import CookingPlus.Renderers.SpeedBlockRenderer;
import CookingPlus.Renderers.SpongeRenderer;
import CookingPlus.Renderers.TeapotRenderer;
import CookingPlus.Renderers.UnfiredFryingPanRenderer;
import CookingPlus.Renderers.UnfiredPlateRenderer;
import CookingPlus.Renderers.UnfiredSaucepanRenderer;
import CookingPlus.Renderers.UnfiredTeapotRenderer;
import CookingPlus.Renderers.VanillaRenderer;
import CookingPlus.Renderers.VatRenderer;
import CookingPlus.tiles.AnalyserTileEntity;
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

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		OBJLoader.INSTANCE.addDomain(CookingPlusMain.MODID.toLowerCase());
		ModelLoaderRegistry.registerLoader(new CookingPlusModelLoader());
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
		

		ClientRegistry.bindTileEntitySpecialRenderer(ButterChurnTileEntity.class, new ButterChurnRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(OilPressTileEntity.class, new OilPressRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(BrickOvenTileEntity.class, new CookingPlusRender());
		ClientRegistry.bindTileEntitySpecialRenderer(FermenterTileEntity.class, new CookingPlusFermenterRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(MarketBoxTileEntity.class, new MarketBoxRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TeapotTileEntity.class, new TeapotRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(UnfiredTeapotTileEntity.class, new UnfiredTeapotRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(HeaterTileEntity.class, new HeaterRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(OrnateChestTileEntity.class, new OrnateChestRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(PlateTileEntity.class, new PlateRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(UnfiredPlateTileEntity.class, new UnfiredPlateRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(FryingPanTileEntity.class, new FryingPanRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(UnfiredFryingPanTileEntity.class, new UnfiredFryingPanRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(SheetPressTileEntity.class, new SheetPressRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(SpongeTileEntity.class, new SpongeRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(VanillaTileEntity.class, new VanillaRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(NetBlockTileEntity.class, new NetBlockRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(DryingRackTileEntity.class, new DryingRackRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(LiquidBarrelTileEntity.class, new LiquidBarrelRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(SaucepanTileEntity.class, new SaucepanRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(UnfiredSaucepanTileEntity.class, new UnfiredSaucepanRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(IceBoxTileEntity.class, new IceBoxRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(HydrophonicTileEntity.class, new HydrophonicRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(VatTileEntity.class, new VatRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(BotTileEntity.class, new BotRenderer());
		TileEntitySpecialRenderer myCrystalRender = new CrystalRenderer();
		ClientRegistry.bindTileEntitySpecialRenderer(CookingPlusGrowthCrystalTileEntity.class, myCrystalRender);
		ClientRegistry.bindTileEntitySpecialRenderer(CookingPlusWaterCrystalTileEntity.class, myCrystalRender);
		ClientRegistry.bindTileEntitySpecialRenderer(CookingPlusLightCrystalTileEntity.class, myCrystalRender);
		ClientRegistry.bindTileEntitySpecialRenderer(CookingPlusSkyCrystalTileEntity.class, myCrystalRender);
		ClientRegistry.bindTileEntitySpecialRenderer(GrabberTileEntity.class, new GrabberRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(FisherTileEntity.class, new FisherRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(CookingPlusGathererTileEntity.class, new GathererRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(DesalinatorTileEntity.class, new DesalinatorRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(LoggerTileEntity.class, new Loggerrenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(PlanterTileEntity.class, new PlanterRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(GoldBotTileEntity.class, new GoldBotRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(LaserDroneBayTileEntity.class, new LaserDroneBayRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(CookingPlusSpeedBlockTileEntity.class, new SpeedBlockRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(CookingPlusRangeBlockTileEntity.class, new RangeBlockRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(CookingPlusGoldenSpeedBlockTileEntity.class, new GoldenSpeedBlockRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(CookingPlusGoldenRangeBlockTileEntity.class, new GoldenRangeBlockRenderer());
		
		ClientRegistry.bindTileEntitySpecialRenderer(LeyLineReceiverTileEntity.class, new LeyLineReceiverRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(LeyLineGeneratorTileEntity.class, new LeyLineGeneratorRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(LeyLinePropagatorTileEntity.class, new LeyLineGeneratorRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(LeyDesynthTileEntity.class, new LeyDesynthRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(DiamondBotTileEntity.class, new DiamondBotRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(CookingPlusDiamondSpeedBlockTileEntity.class, new DiamondSpeedBlockRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(CookingPlusDiamondRangeBlockTileEntity.class, new DiamondRangeBlockRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(MutationStationTileEntity.class, new MutationStationRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(FishTankTileEntity.class, new FishTankRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(AnalyserTileEntity.class, new AnalyserRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(InscriberTileEntity.class, new CookingPlusInscriberRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(ResearchLabTileEntity.class, new ResearchRenderer());
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
		 
	}
	

	
	
}