package CookingPlus.Renderers;

import org.lwjgl.opengl.GL11;

import CookingPlus.models.CookingPlusGatherer;
import CookingPlus.tiles.CookingPlusGathererTileEntity;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class GathererRenderer extends TileEntitySpecialRenderer {
	
	ResourceLocation texture = new ResourceLocation("cookingplus:textures/blocks/gatherermap.png");
	
	private CookingPlusGatherer model;
	
	public GathererRenderer(){
		this.model = new CookingPlusGatherer();
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f, int dunno) {
		GL11.glPushMatrix();
		GL11.glTranslated((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		CookingPlusGathererTileEntity myentity = (CookingPlusGathererTileEntity) entity;
		this.bindTexture(texture);
		
		GL11.glPushMatrix();
		this.model.RenderModel(0.0625f, myentity.getType());
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
