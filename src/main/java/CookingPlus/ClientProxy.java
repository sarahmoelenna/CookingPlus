package CookingPlus;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import CookingPlus.Renderers.ButterChurnRenderer;
import CookingPlus.Renderers.CookingPlusFermenterRenderer;
import CookingPlus.Renderers.CookingPlusItemRender;
import CookingPlus.Renderers.CookingPlusRender;
import CookingPlus.Renderers.DryingRackRenderer;
import CookingPlus.Renderers.FryingPanRenderer;
import CookingPlus.Renderers.HeaterRenderer;
import CookingPlus.Renderers.HydrophonicRenderer;
import CookingPlus.Renderers.IceBoxRenderer;
import CookingPlus.Renderers.LiquidBarrelRenderer;
import CookingPlus.Renderers.MarketBoxRender;
import CookingPlus.Renderers.NetBlockRenderer;
import CookingPlus.Renderers.OilPressRenderer;
import CookingPlus.Renderers.OrnateChestRenderer;
import CookingPlus.Renderers.PlateRenderer;
import CookingPlus.Renderers.SaucepanRenderer;
import CookingPlus.Renderers.SheetPressRenderer;
import CookingPlus.Renderers.SpongeRenderer;
import CookingPlus.Renderers.TeapotRenderer;
import CookingPlus.Renderers.UnfiredFryingPanRenderer;
import CookingPlus.Renderers.UnfiredPlateRenderer;
import CookingPlus.Renderers.UnfiredSaucepanRenderer;
import CookingPlus.Renderers.UnfiredTeapotRenderer;
import CookingPlus.Renderers.VanillaRenderer;
import CookingPlus.Renderers.VatRenderer;
import CookingPlus.tiles.BrickOvenTileEntity;
import CookingPlus.tiles.ButterChurnTileEntity;
import CookingPlus.tiles.DryingRackTileEntity;
import CookingPlus.tiles.FermenterTileEntity;
import CookingPlus.tiles.FryingPanTileEntity;
import CookingPlus.tiles.HeaterTileEntity;
import CookingPlus.tiles.HydrophonicTileEntity;
import CookingPlus.tiles.IceBoxTileEntity;
import CookingPlus.tiles.LiquidBarrelTileEntity;
import CookingPlus.tiles.MarketBoxTileEntity;
import CookingPlus.tiles.NetBlockTileEntity;
import CookingPlus.tiles.OilPressTileEntity;
import CookingPlus.tiles.OrnateChestTileEntity;
import CookingPlus.tiles.PlateTileEntity;
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
		
		TileEntityItemStackRenderer.instance = new CookingPlusItemRender();
		
		
		//register model loader
		// StateMapperBase ignoreState = new StateMapperBase() {
		//      @Override
		//      protected ModelResourceLocation getModelResourceLocation(IBlockState iBlockState) {
		//        return new ModelResourceLocation("cookingplus:grapecrop");
		//      }
		//    };
		//ModelLoader.setCustomStateMapper(CookingPlusMain.blockGrapeCrop, ignoreState);
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
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
		 
	}
	

	
	
}