package CookingPlus.Renderers;

import org.lwjgl.opengl.GL11;

import CookingPlus.models.CookingPlusCrystal;
import CookingPlus.models.CookingPlusSponge;
import CookingPlus.tiles.CookingPlusGrowthCrystalTileEntity;
import CookingPlus.tiles.CookingPlusLightCrystalTileEntity;
import CookingPlus.tiles.CookingPlusSkyCrystalTileEntity;
import CookingPlus.tiles.CookingPlusWaterCrystalTileEntity;
import CookingPlus.tiles.CystalBaseTileEntity;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class CrystalRenderer extends TileEntitySpecialRenderer {
	
	ResourceLocation texture = new ResourceLocation("cookingplus:textures/blocks/crystalmap.png");
	
	private CookingPlusCrystal model;
	
	public CrystalRenderer(){
		this.model = new CookingPlusCrystal();
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f, int dunno) {
		GL11.glPushMatrix();
		GL11.glTranslated((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		CystalBaseTileEntity myentity = (CystalBaseTileEntity) entity;
		GL11.glRotatef(myentity.getRotation(), 0, 1, 0);
		GL11.glTranslated(0, (myentity.getBobbing() - 0.5f)/10, 0);
		this.bindTexture(texture);
		
		GL11.glPushMatrix();
		if(entity instanceof CookingPlusGrowthCrystalTileEntity){
			this.model.RenderModel(0.0625f, 2);
		}
		else if(entity instanceof CookingPlusWaterCrystalTileEntity){
			this.model.RenderModel(0.0625f, 0);
		}
		else if(entity instanceof CookingPlusLightCrystalTileEntity){
			this.model.RenderModel(0.0625f, 4);
		}
		else if(entity instanceof CookingPlusSkyCrystalTileEntity){
			this.model.RenderModel(0.0625f, 1);
		}
		else{
			this.model.RenderModel(0.0625f, 0);
		}
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
