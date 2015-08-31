package CookingPlus.Renderers;

import org.lwjgl.opengl.GL11;

import CookingPlus.models.CookingPlusBrickOven;
import CookingPlus.models.CookingPlusChurn;
import CookingPlus.tiles.BrickOvenTileEntity;
import CookingPlus.tiles.ButterChurnTileEntity;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class ButterChurnRenderer extends TileEntitySpecialRenderer {
	
	ResourceLocation texture = new ResourceLocation("cookingplus:textures/blocks/churn.png");
	
	private CookingPlusChurn model;
	
	public ButterChurnRenderer(){
		this.model = new CookingPlusChurn();
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f, int dunno) {
		GL11.glPushMatrix();
		GL11.glTranslated((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		
		ButterChurnTileEntity MyChurn = (ButterChurnTileEntity) entity;
		//System.out.println(MyChurn.getMovement()/500.0f);

		
		this.bindTexture(texture);
		
		GL11.glPushMatrix();
		this.model.RenderModel(0.0625f, MyChurn.getMovement()/500.0f);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
