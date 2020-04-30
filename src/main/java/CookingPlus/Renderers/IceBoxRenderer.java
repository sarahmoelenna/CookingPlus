package CookingPlus.Renderers;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import CookingPlus.models.CookingPlusIceBox;
import CookingPlus.tiles.IceBoxTileEntity;

public class IceBoxRenderer extends TileEntitySpecialRenderer {
	
	ResourceLocation texture = new ResourceLocation("agriculturalrevolution:textures/blocks/iceboxmap.png");
	EntityItem entItem;
	
	private CookingPlusIceBox model;
	
	public IceBoxRenderer(){
		this.model = new CookingPlusIceBox();
		entItem = null;
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f, int dunno) {
		GL11.glPushMatrix();
		GL11.glTranslated((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		
		IceBoxTileEntity MyOven = (IceBoxTileEntity) entity;//change
		GL11.glRotatef(90, 0, 1, 0);
		if(MyOven != null){
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
		}
		this.bindTexture(texture);
		
		GL11.glPushMatrix();
		this.model.RenderModel(0.0625f);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		/*
		if(entity.hasWorldObj()){		
		GlStateManager.enableBlend();
		
			GL11.glPopMatrix();
		
				IBlockState myBlock = CookingPlusMain.blockBlueCoralBlock.getDefaultState();
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
                 worldrenderer.setTranslation((double)((float)(-i)), (double)(-j) + 0.5f, (double)((float)(-k)));
                 BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
                 IBakedModel ibakedmodel = blockrendererdispatcher.getModelFromBlockState(myBlock, this.getWorld(), (BlockPos)null);
                 blockrendererdispatcher.getBlockModelRenderer().renderModel(this.getWorld(), ibakedmodel, myBlock, entity.getPos(), worldrenderer, false);
                 worldrenderer.setTranslation(0.0D, 0.0D, 0.0D);
                 tessellator.draw();
                 GlStateManager.popMatrix();
         
         GlStateManager.disableBlend();
		}*/
		
		
	}
	
	
	
	
}
