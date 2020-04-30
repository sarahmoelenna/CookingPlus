package CookingPlus.Renderers;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import CookingPlus.models.CookingPlusLeyCrystal;
import CookingPlus.models.CookingPlusVanilla;
import CookingPlus.tiles.LeyDesynthTileEntity;

public class LeyDesynthRenderer extends TileEntitySpecialRenderer {
	
	ResourceLocation earthtexture = new ResourceLocation("agriculturalrevolution:textures/blocks/earthcrystal.png");
	ResourceLocation firetexture = new ResourceLocation("agriculturalrevolution:textures/blocks/firecrystal.png");
	ResourceLocation airtexture = new ResourceLocation("agriculturalrevolution:textures/blocks/aircrystal.png");
	ResourceLocation watertexture = new ResourceLocation("agriculturalrevolution:textures/blocks/watercrystal.png");
	
	private CookingPlusLeyCrystal model;
	
	public LeyDesynthRenderer(){
		this.model = new CookingPlusLeyCrystal();
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f, int dunno) {
		GL11.glPushMatrix();
		GL11.glTranslated((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		LeyDesynthTileEntity myEntity = (LeyDesynthTileEntity)entity;
		GL11.glTranslated(0, (myEntity.getBobbing() - 0.5)/6, 0);
		GL11.glRotatef(myEntity.getRotation(), 0, 1, 0);
		
		if(myEntity.getCrystalType() > 0){
			if(myEntity.getCrystalType() == 1){
				this.bindTexture(airtexture);
			}
			else if(myEntity.getCrystalType() == 2){
				this.bindTexture(earthtexture);
			}
			else if(myEntity.getCrystalType() == 3){
				this.bindTexture(firetexture);
			}
			else if(myEntity.getCrystalType() == 4){
				this.bindTexture(watertexture);
			}
		
			GL11.glPushMatrix();
		
			GL11.glEnable(GL11.GL_BLEND); 
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			this.model.RenderModel(0.0625f);
			GL11.glDisable(GL11.GL_BLEND); 
		
		GL11.glPopMatrix();
		}
		GL11.glPopMatrix();
	}

}
