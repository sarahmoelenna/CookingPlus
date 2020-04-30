package CookingPlus.Renderers;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import CookingPlus.models.CookingPlusOilPress;
import CookingPlus.tiles.OilPressTileEntity;

public class OilPressRenderer extends TileEntitySpecialRenderer {
	
	ResourceLocation texture = new ResourceLocation("agriculturalrevolution:textures/blocks/oilpress.png");
	
	private CookingPlusOilPress model;
	
	public OilPressRenderer(){
		this.model = new CookingPlusOilPress();
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f, int dunno) {
		GL11.glPushMatrix();
		GL11.glTranslated((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		
		OilPressTileEntity MyChurn = (OilPressTileEntity) entity;
		//System.out.println(MyChurn.getMovement()/500.0f);

		
		this.bindTexture(texture);
		
		GL11.glPushMatrix();
		if(MyChurn != null){
		GL11.glRotatef((float) (MyChurn.getMovement() * 180/Math.PI), 0f, 1f, 0f);
		this.model.RenderModel(0.0625f, MyChurn.getMovement());
		}
		else{
			this.model.RenderModel(0.0625f, 0);
		}
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}


}
