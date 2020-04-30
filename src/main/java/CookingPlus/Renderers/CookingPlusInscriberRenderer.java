package CookingPlus.Renderers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import CookingPlus.blocks.tileentity.InscriberBlock;
import CookingPlus.models.CookingPlusInscriberBase;
import CookingPlus.models.CookingPlusInscriberRod;
import CookingPlus.models.CookingPlusInscriberTool;
import CookingPlus.tiles.InscriberTileEntity;

public class CookingPlusInscriberRenderer extends TileEntitySpecialRenderer {
	
	ResourceLocation texture = new ResourceLocation("agriculturalrevolution:textures/blocks/inscriber.png");
	
	private CookingPlusInscriberBase model;
	private CookingPlusInscriberRod model1;
	private CookingPlusInscriberTool model2;
	
	public CookingPlusInscriberRenderer(){
		this.model = new CookingPlusInscriberBase();
		this.model1 = new CookingPlusInscriberRod();
		this.model2 = new CookingPlusInscriberTool();
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f, int dunno) {
		GL11.glPushMatrix();
		GL11.glTranslated((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		int myDirection = 0;
		float rod = 0;
		float tool = 0;
		if(entity instanceof InscriberTileEntity){
			myDirection = entity.getWorld().getBlockState(entity.getPos()).getValue(InscriberBlock.FACING).getIndex();
			rod = ((InscriberTileEntity)entity).rodMovement;
			tool = ((InscriberTileEntity)entity).toolMovement;
		}
		int rotation = 0;
		if(myDirection == 2){
			rotation = 0;
		}
		else if(myDirection == 4){
			rotation = 90;
		}
		else if(myDirection == 3){ //correct
			rotation = 180;
		}
		else if(myDirection == 5){
			rotation = 270;
		}
		//InscriberTileEntity myEntity = (InscriberTileEntity) entity;
		
		this.bindTexture(texture);
		
		GL11.glPushMatrix();
		GL11.glRotatef(rotation, 0, 1, 0);
		this.model.RenderModel(0.0625f);
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glRotatef(rotation, 0, 1, 0);
		GL11.glTranslated(0, 0, rod - 0.2f);
		this.model1.RenderModel(0.0625f);
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glRotatef(rotation, 0, 1, 0);
		GL11.glTranslated(tool - 0.1f, 0, rod - 0.2f);
		this.model2.RenderModel(0.0625f);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		if(entity instanceof InscriberTileEntity){
			GL11.glPushMatrix();
			GL11.glTranslated((float)x + 0.5f, (float)y, (float)z + 0.5f);
			GL11.glRotatef(rotation, 0, 1, 0);
			//GL11.glTranslatef((float)x + 0.5f, (float)y, (float)z + 0.5f);
			 
			 RenderHelper.disableStandardItemLighting();
			 if(((InscriberTileEntity) entity).getStackInSlot(0) != null){
			 if(((InscriberTileEntity) entity).getStackInSlot(0).stackSize > 0){
				 	GL11.glPushMatrix();//item two
				 	GL11.glTranslatef(0f, 0.2f, 0F);
				 	GL11.glRotatef(90, 1, 0, 0);
				 	//GL11.glScalef(0.18f, 0.18f, 0.18f);
				 	Minecraft.getMinecraft().getRenderItem().renderItem(((InscriberTileEntity) entity).getStackInSlot(0), ItemCameraTransforms.TransformType.NONE);
				 	GL11.glPopMatrix();
			 }
			 }
			 RenderHelper.enableStandardItemLighting();
			 GL11.glPopMatrix();
		}
		
		
		
	}

}
