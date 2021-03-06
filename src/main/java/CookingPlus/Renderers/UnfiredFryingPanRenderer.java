package CookingPlus.Renderers;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import CookingPlus.models.CookingPlusFryingPan;
import CookingPlus.tiles.UnfiredFryingPanTileEntity;

public class UnfiredFryingPanRenderer extends TileEntitySpecialRenderer {
	
	ResourceLocation texture = new ResourceLocation("agriculturalrevolution:textures/blocks/unfiredfryingpanmap.png");
	EntityItem entItem;
	
	private CookingPlusFryingPan model;
	
	public UnfiredFryingPanRenderer(){
		this.model = new CookingPlusFryingPan();
		entItem = null;
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f, int dunno) {
		GL11.glPushMatrix();
		GL11.glTranslated((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		
		UnfiredFryingPanTileEntity MyOven = (UnfiredFryingPanTileEntity) entity;//change
		//System.out.println(MyOven.getDirection());
		//System.out.println(MyOven.getDirection());
		GL11.glRotatef(90, 0, 1, 0);
		if(MyOven != null){
		if(MyOven.getDirection() == 3){
			GL11.glRotatef(0, 0, 1, 0);
		}
		else if(MyOven.getDirection() == 4){
			GL11.glRotatef(90, 0, 1, 0);
		}
		else if(MyOven.getDirection() == 2){ //correct
			GL11.glRotatef(180, 0, 1, 0);
		}
		else if(MyOven.getDirection() == 5){
			GL11.glRotatef(270, 0, 1, 0);
		}
		}
		
		this.bindTexture(texture);
		
		GL11.glPushMatrix();
		this.model.RenderModel(0.0625f);
		GL11.glPopMatrix();
		GL11.glPopMatrix();

			
	}

}
