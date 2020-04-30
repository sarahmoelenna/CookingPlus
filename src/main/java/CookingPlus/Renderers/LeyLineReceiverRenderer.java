package CookingPlus.Renderers;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import CookingPlus.models.CookingPlusGatherer;
import CookingPlus.models.CookingPlusLeyMachineCore;
import CookingPlus.models.CookingPlusLeyMachineSide;
import CookingPlus.tiles.DesalinatorTileEntity;
import CookingPlus.tiles.LeyLineReceiverTileEntity;

public class LeyLineReceiverRenderer extends TileEntitySpecialRenderer {
	
	ResourceLocation texture = new ResourceLocation("agriculturalrevolution:textures/blocks/machine_simple.png");
	ResourceLocation coreTexture = new ResourceLocation("agriculturalrevolution:textures/blocks/watercrystal.png");
	private CookingPlusLeyMachineSide model;
	private CookingPlusLeyMachineCore coremodel;
	
	public LeyLineReceiverRenderer(){
		this.model = new CookingPlusLeyMachineSide();
		this.coremodel = new CookingPlusLeyMachineCore();
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f, int dunno) {
		GL11.glPushMatrix();
		GL11.glTranslated((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		LeyLineReceiverTileEntity myentity = (LeyLineReceiverTileEntity) entity;
		this.bindTexture(texture);
		if(myentity.east == true){
			GL11.glPushMatrix();
			model.RenderModel(0.0625f);
			GL11.glPopMatrix();
		}
		if(myentity.west == true){
			GL11.glPushMatrix();
			GL11.glRotatef(180,0,1,0);
			model.RenderModel(0.0625f);
			GL11.glPopMatrix();
		}
		if(myentity.north == true){
			GL11.glPushMatrix();
			GL11.glRotatef(270,0,1,0);
			model.RenderModel(0.0625f);
			GL11.glPopMatrix();
		}
		if(myentity.south == true){
			GL11.glPushMatrix();
			GL11.glRotatef(90,0,1,0);
			model.RenderModel(0.0625f);
			GL11.glPopMatrix();
		}
		if(myentity.up == true){
			GL11.glPushMatrix();
			GL11.glTranslated(1, 1, 0);
			GL11.glRotatef(90,0,0,1);
			model.RenderModel(0.0625f);
			GL11.glPopMatrix();
		}
		if(myentity.down == true){
			GL11.glPushMatrix();
			GL11.glTranslated(-1, 1, 0);
			GL11.glRotatef(270,0,0,1);
			model.RenderModel(0.0625f);
			GL11.glPopMatrix();
		}
		
		
		GL11.glEnable(GL11.GL_BLEND); 
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		this.bindTexture(coreTexture);
		GL11.glPushMatrix();
		GL11.glRotatef(myentity.rotation, 0, 1, 0);
		coremodel.RenderModel(0.0625f);
		GL11.glPopMatrix();
		GL11.glDisable(GL11.GL_BLEND);
		
		GL11.glPopMatrix();
	}

}
