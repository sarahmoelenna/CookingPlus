package CookingPlus.Renderers;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderFallingBlock;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomCrops;
import CookingPlus.models.CookingPlusHydrophonic;
import CookingPlus.models.CookingPlusIceBox;
import CookingPlus.tiles.HydrophonicTileEntity;

public class HydrophonicRenderer extends TileEntitySpecialRenderer {
	
	ResourceLocation texture = new ResourceLocation("cookingplus:textures/blocks/hydrophonicmap.png");
	EntityItem entItem;
	
	private CookingPlusHydrophonic model;
	
	public HydrophonicRenderer(){
		this.model = new CookingPlusHydrophonic();
		entItem = null;
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f, int dunno) {
		
		GL11.glPushMatrix();
		if(entity.hasWorldObj()){
			HydrophonicTileEntity MyHy = (HydrophonicTileEntity) entity;
			if(MyHy.getCurrentCrop() != null){
				IBlockState myBlock = Blocks.wheat.getDefaultState();
				if(MyHy.getCurrentCrop() instanceof CookingPlusCustomCrops){
				  myBlock = MyHy.getCurrentCrop().getDefaultState().withProperty(CookingPlusCustomCrops.AGE, MyHy.GetAge());
				}
				else if(MyHy.getCurrentCrop() == Blocks.wheat || MyHy.getCurrentCrop() == Blocks.potatoes || MyHy.getCurrentCrop() == Blocks.carrots){
					myBlock = MyHy.getCurrentCrop().getDefaultState().withProperty(BlockCrops.AGE, MyHy.GetAge());
				}
				 this.bindTexture(TextureMap.locationBlocksTexture);
				 GlStateManager.pushMatrix();
                 GlStateManager.translate((float)x, (float)y, (float)z);
                 GlStateManager.enableLighting();
                 Tessellator tessellator = Tessellator.getInstance();
                 WorldRenderer worldrenderer = tessellator.getWorldRenderer();
                 worldrenderer.startDrawingQuads();
                 worldrenderer.setVertexFormat(DefaultVertexFormats.BLOCK);
                 int i = entity.getPos().getX();
                 int j = entity.getPos().getY();
                 int k = entity.getPos().getZ();
                 worldrenderer.setTranslation((double)((float)(-i)), (double)(-j), (double)((float)(-k)));
                 BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
                 IBakedModel ibakedmodel = blockrendererdispatcher.getModelFromBlockState(myBlock, this.getWorld(), (BlockPos)null);
                 blockrendererdispatcher.getBlockModelRenderer().renderModel(this.getWorld(), ibakedmodel, myBlock, entity.getPos(), worldrenderer, false);
                 worldrenderer.setTranslation(0.0D, 0.0D, 0.0D);
                 tessellator.draw();
                 GlStateManager.popMatrix();
			}
		}
		GL11.glPopMatrix();
		
		
		
		GL11.glPushMatrix();
		GL11.glTranslated((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		
		HydrophonicTileEntity MyOven = (HydrophonicTileEntity) entity;
		GL11.glRotatef(90, 0, 1, 0);
		if(MyOven.getDirection() == 3){
			GL11.glRotatef(90, 0, 1, 0);
		}
		else if(MyOven.getDirection() == 4){
			GL11.glRotatef(180, 0, 1, 0);
		}
		else if(MyOven.getDirection() == 2){ //correct
			GL11.glRotatef(270, 0, 1, 0);
		}
		else if(MyOven.getDirection() == 5){
			GL11.glRotatef(0, 0, 1, 0);
		}
		
		this.bindTexture(texture);
		GL11.glPushMatrix();
		this.model.RenderModel(0.0625f, MyOven.getRotation());
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		

	}
	
}
