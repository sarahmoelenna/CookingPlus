package CookingPlus.Renderers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import CookingPlus.blocks.tileentity.ResearchLabBlock;
import CookingPlus.models.CookingPlusResearchRod;
import CookingPlus.models.CookingPlusResearchTool;
import CookingPlus.tiles.ResearchLabTileEntity;

public class ResearchRenderer extends TileEntitySpecialRenderer {
	
	ResourceLocation texture = new ResourceLocation("agriculturalrevolution:textures/blocks/researchmap.png");
	
	private CookingPlusResearchRod model;
	private CookingPlusResearchTool model1;
	
	public ResearchRenderer(){
		this.model = new CookingPlusResearchRod();
		this.model1 = new CookingPlusResearchTool();
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f, int dunno) {
		GL11.glPushMatrix();
		GL11.glTranslated((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		int myDirection = 0;
		float rod = 0;
		float tool = 0;
		if(entity instanceof ResearchLabTileEntity){
			myDirection = entity.getWorld().getBlockState(entity.getPos()).getValue(ResearchLabBlock.FACING).getIndex();
			rod = ((ResearchLabTileEntity)entity).rodMovement;
			tool = ((ResearchLabTileEntity)entity).toolMovement;
		}
		int rotation = 0;
		if(myDirection == 2){
			rotation = 0;
		}
		else if(myDirection == 4){
			rotation = 270;
		}
		else if(myDirection == 3){ //correct
			rotation = 180;
		}
		else if(myDirection == 5){
			rotation = 90;
		}
		//InscriberTileEntity myEntity = (InscriberTileEntity) entity;
		
		this.bindTexture(texture);
		//rod
		GL11.glPushMatrix();
		GL11.glRotatef(rotation + 90, 0, 1, 0);
		GL11.glTranslated(0, 0, -rod);
		this.model.RenderModel(0.0625f);
		GL11.glPopMatrix();
		
		//tool
		GL11.glPushMatrix();
		GL11.glRotatef(rotation + 90, 0, 1, 0);
		GL11.glTranslated(-tool, 0, -rod);
		this.model1.RenderModel(0.0625f);
		GL11.glPopMatrix();
		
		GL11.glPopMatrix();

		
	}

}
