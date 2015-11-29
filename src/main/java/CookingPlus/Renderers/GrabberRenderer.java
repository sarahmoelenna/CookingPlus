package CookingPlus.Renderers;

import org.lwjgl.opengl.GL11;

import CookingPlus.models.CookingPlusGrabber;
import CookingPlus.models.CookingPlusVanilla;
import CookingPlus.tiles.GrabberTileEntity;
import CookingPlus.tiles.OilPressTileEntity;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class GrabberRenderer extends TileEntitySpecialRenderer {
	
	ResourceLocation texture = new ResourceLocation("cookingplus:textures/blocks/grabberarmmap.png");
	
	private CookingPlusGrabber model;
	
	public GrabberRenderer(){
		this.model = new CookingPlusGrabber();
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f, int dunno) {
		GL11.glPushMatrix();
		GL11.glTranslated((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		
		this.bindTexture(texture);
		GrabberTileEntity MyGrabber = (GrabberTileEntity) entity;
		
		GL11.glPushMatrix();
		GL11.glRotatef((float) (MyGrabber.getMovement() * 180/Math.PI), 0f, 1f, 0f);
		this.model.RenderModel(0.0625f);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
