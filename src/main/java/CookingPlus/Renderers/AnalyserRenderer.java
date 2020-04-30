package CookingPlus.Renderers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import CookingPlus.models.CookingPlusAnalyserBase;
import CookingPlus.models.CookingPlusAnalyserLayerOne;
import CookingPlus.models.CookingPlusAnalyserLayerTwo;
import CookingPlus.tiles.AnalyserTileEntity;
import CookingPlus.tiles.InscriberTileEntity;

public class AnalyserRenderer extends TileEntitySpecialRenderer {
	
	ResourceLocation texture = new ResourceLocation("agriculturalrevolution:textures/blocks/analyser.png");
	
	private CookingPlusAnalyserBase model;
	private CookingPlusAnalyserLayerOne model1;
	private CookingPlusAnalyserLayerTwo model2;
	
	public AnalyserRenderer(){
		this.model = new CookingPlusAnalyserBase();
		this.model1 = new CookingPlusAnalyserLayerOne();
		this.model2 = new CookingPlusAnalyserLayerTwo();
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f, int dunno) {
		GL11.glPushMatrix();
		GL11.glTranslated((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		
		AnalyserTileEntity myEntity = (AnalyserTileEntity) entity;
		
		this.bindTexture(texture);
		
		GL11.glPushMatrix();
		this.model.RenderModel(0.0625f);
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glRotatef(myEntity.layeronerotation, 0, 1, 0);
		this.model1.RenderModel(0.0625f);
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glRotatef(myEntity.layertworotation, 0, 1, 0);
		this.model2.RenderModel(0.0625f);
		GL11.glPopMatrix();
		
		GL11.glPopMatrix();
		
		if(entity instanceof AnalyserTileEntity){
			GL11.glPushMatrix();
			GL11.glTranslated((float)x + 0.5f, (float)y, (float)z + 0.5f);
			//GL11.glTranslatef((float)x + 0.5f, (float)y, (float)z + 0.5f);
			 
			 RenderHelper.disableStandardItemLighting();
			 if(((AnalyserTileEntity) entity).getStackInSlot(0) != null){
			 if(((AnalyserTileEntity) entity).getStackInSlot(0).stackSize > 0){
				 	GL11.glPushMatrix();//item two
				 	GL11.glTranslatef(0f, 0.7f, 0F);
				 	GL11.glScalef(0.12f, 0.12f, 0.12f);
				 	Minecraft.getMinecraft().getRenderItem().renderItem(((AnalyserTileEntity) entity).getStackInSlot(0), ItemCameraTransforms.TransformType.NONE);
				 	GL11.glPopMatrix();
			 }
			 }
			 RenderHelper.enableStandardItemLighting();
			 GL11.glPopMatrix();
		}
		
	}

}
