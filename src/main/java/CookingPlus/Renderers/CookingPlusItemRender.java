package CookingPlus.Renderers;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;

import org.lwjgl.opengl.GL11;

import CookingPlus.CookingPlusMain;
import CookingPlus.tiles.BrickOvenTileEntity;
import CookingPlus.tiles.ButterChurnTileEntity;
import CookingPlus.tiles.DryingRackTileEntity;
import CookingPlus.tiles.FermenterTileEntity;
import CookingPlus.tiles.FryingPanTileEntity;
import CookingPlus.tiles.HeaterTileEntity;
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

public class CookingPlusItemRender extends TileEntityItemStackRenderer {
	
	//the Tile enitty you want to render
    private BrickOvenTileEntity ovenRender = new BrickOvenTileEntity();
    private OilPressTileEntity oilRender = new OilPressTileEntity();
    private ButterChurnTileEntity butterRender = new ButterChurnTileEntity();
    private FermenterTileEntity fermenterRender = new FermenterTileEntity();
    private MarketBoxTileEntity marketboxRender = new MarketBoxTileEntity();
    private TeapotTileEntity teapotRender = new TeapotTileEntity();
    private UnfiredTeapotTileEntity unfiredteapotRender = new UnfiredTeapotTileEntity();
    private HeaterTileEntity heaterRender = new HeaterTileEntity();
    private OrnateChestTileEntity ornatechestRender = new OrnateChestTileEntity();
    private PlateTileEntity plateRender = new PlateTileEntity();
    private UnfiredPlateTileEntity unfiredplateRender = new UnfiredPlateTileEntity();
    private FryingPanTileEntity fryingpanRender = new FryingPanTileEntity();
    private UnfiredFryingPanTileEntity unfiredfryingpanRender = new UnfiredFryingPanTileEntity();
    private SheetPressTileEntity sheetpressRender = new SheetPressTileEntity();
    private SpongeTileEntity spongeRender = new SpongeTileEntity();
    private VanillaTileEntity vanillaRender = new VanillaTileEntity();
    private NetBlockTileEntity netblockRender = new NetBlockTileEntity();
    private DryingRackTileEntity dryingrackRender = new DryingRackTileEntity();
    private LiquidBarrelTileEntity liquidbarrelRender = new LiquidBarrelTileEntity();
    private SaucepanTileEntity saucepanRender = new SaucepanTileEntity();
    private UnfiredSaucepanTileEntity unfiredsaucepanRender = new UnfiredSaucepanTileEntity();
    private IceBoxTileEntity iceboxRender = new IceBoxTileEntity();
    
    @Override
    public void renderByItem(ItemStack itemStack) {
        Block block = Block.getBlockFromItem(itemStack.getItem());
        if (block == CookingPlusMain.blockBrickOven) {
        	//System.out.println("B");
        	GL11.glTranslatef(0.2f, -0.25f, 0);
			GL11.glScalef(0.65f,  0.65f,  0.65f);
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.ovenRender, 0.0D, 0.0D, 0.0D, 0.0F);
        }else if (block == CookingPlusMain.blockButterChurn) {
        	//System.out.println("B");
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.butterRender, 0.0D, 0.0D, 0.0D, 0.0F);
        }else if (block == CookingPlusMain.blockOilPress) {
        	//System.out.println("B");
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.oilRender, 0.0D, 0.0D, 0.0D, 0.0F);
        }else if (block == CookingPlusMain.blockFermenter) {
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.fermenterRender, 0.0D, 0.0D, 0.0D, 0.0F);
        }else if (block == CookingPlusMain.blockMarketBox) {
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.marketboxRender, 0.0D, 0.0D, 0.0D, 0.0F);
        }else if (block == CookingPlusMain.blockTeapot) {
        	GL11.glTranslatef(-1f, 0.4f, 0);
        	GL11.glScalef(2.0f,  2.0f,  2.0f);
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.teapotRender, 0.0D, 0.0D, 0.0D, 0.0F);
        }else if (block == CookingPlusMain.blockUnfiredTeapot) {
        	GL11.glTranslatef(-1f, 0.4f, 0);
        	GL11.glScalef(2.0f,  2.0f,  2.0f);
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.unfiredteapotRender, 0.0D, 0.0D, 0.0D, 0.0F);
        }else if (block == CookingPlusMain.blockHeater) {
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.heaterRender, 0.0D, 0.0D, 0.0D, 0.0F);
        }else if (block == CookingPlusMain.blockOrnateChest) {
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.ornatechestRender, 0.0D, 0.0D, 0.0D, 0.0F);
        }else if (block == CookingPlusMain.blockPlate) {
        	GL11.glTranslatef(-1f, 0.4f, 0);
        	GL11.glScalef(2.0f,  2.0f,  2.0f);
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.plateRender, 0.0D, 0.0D, 0.0D, 0.0F);
        }else if (block == CookingPlusMain.blockUnfiredPlate) {
        	GL11.glTranslatef(-1f, 0.4f, 0);
        	GL11.glScalef(2.0f,  2.0f,  2.0f);
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.unfiredplateRender, 0.0D, 0.0D, 0.0D, 0.0F);
        }else if (block == CookingPlusMain.blockFryingPan) {
        	GL11.glTranslatef(-1f, 0.45f, 0);
        	GL11.glScalef(1.7f,  1.7f,  1.7f);
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.fryingpanRender, 0.0D, 0.0D, 0.0D, 0.0F);
        }else if (block == CookingPlusMain.blockUnfiredFryingPan) {
        	GL11.glTranslatef(-1f, 0.45f, 0);;
        	GL11.glScalef(1.7f,  1.7f,  1.7f);
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.unfiredfryingpanRender, 0.0D, 0.0D, 0.0D, 0.0F);
        }else if (block == CookingPlusMain.blockSheetPress) {
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.sheetpressRender, 0.0D, 0.0D, 0.0D, 0.0F);
        }else if (block == CookingPlusMain.blockSponge) {
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.spongeRender, 0.0D, 0.0D, 0.0D, 0.0F);
        }else if (block == CookingPlusMain.blockVanilla) {
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.vanillaRender, 0.0D, 0.0D, 0.0D, 0.0F);
        }else if (block == CookingPlusMain.blockNetBlock) {
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.netblockRender, 0.0D, 0.0D, 0.0D, 0.0F);
        }else if (block == CookingPlusMain.blockDryingRack) {
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.dryingrackRender, 0.0D, 0.0D, 0.0D, 0.0F);
        }else if (block == CookingPlusMain.blockLiquidBarrel) {
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.liquidbarrelRender, 0.0D, 0.0D, 0.0D, 0.0F);
        }else if (block == CookingPlusMain.blockSaucePan) {
        	GL11.glTranslatef(-1f, 0.45f, 0);
        	GL11.glScalef(1.7f,  1.7f,  1.7f);
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.saucepanRender, 0.0D, 0.0D, 0.0D, 0.0F);
        }else if (block == CookingPlusMain.blockUnfiredSaucePan) {
        	GL11.glTranslatef(-1f, 0.45f, 0);
        	GL11.glScalef(1.7f,  1.7f,  1.7f);
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.unfiredsaucepanRender, 0.0D, 0.0D, 0.0D, 0.0F);
        }else if (block == CookingPlusMain.blockIceBox) {
            TileEntityRendererDispatcher.instance.renderTileEntityAt(this.iceboxRender, 0.0D, 0.0D, 0.0D, 0.0F);
        }else {
            super.renderByItem(itemStack);
        }
    }
}
