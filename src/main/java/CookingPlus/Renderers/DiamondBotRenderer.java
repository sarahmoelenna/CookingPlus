package CookingPlus.Renderers;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import CookingPlus.CookingPlusConfig;
import CookingPlus.models.CookingPlusBot;
import CookingPlus.tiles.DiamondBotTileEntity;

public class DiamondBotRenderer extends TileEntitySpecialRenderer {
	
	ResourceLocation texture = new ResourceLocation("agriculturalrevolution:textures/blocks/diamondbotmap.png");
	ResourceLocation sjintexture = new ResourceLocation("agriculturalrevolution:textures/blocks/diamondsjinbotmap.png");
	
	private CookingPlusBot model;
	
	public DiamondBotRenderer(){
		this.model = new CookingPlusBot();
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f, int dunno) {
		GL11.glPushMatrix();
		GL11.glTranslated((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		
		DiamondBotTileEntity MyOven = (DiamondBotTileEntity) entity;//change
		GL11.glRotatef(90, 0, 1, 0);
		if(MyOven!= null){
		if(MyOven.getDirection() == 3){
			GL11.glRotatef(270, 0, 1, 0);
		}
		else if(MyOven.getDirection() == 4){
			GL11.glRotatef(0, 0, 1, 0);
		}
		else if(MyOven.getDirection() == 2){ //correct
			GL11.glRotatef(90, 0, 1, 0);
		}
		else if(MyOven.getDirection() == 5){
			GL11.glRotatef(180, 0, 1, 0);
		}
		}
		
		if(CookingPlusConfig.SjinBot == false){
			this.bindTexture(texture);
		}
		else{
			this.bindTexture(sjintexture);
		}
		
		GL11.glPushMatrix();
		if(MyOven != null){
			this.model.RenderModel(0.0625f, MyOven.getFace());
		}
		else{
			this.model.RenderModel(0.0625f, 1);
		}
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
