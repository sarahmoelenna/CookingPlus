package CookingPlus.Renderers;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import CookingPlus.models.CookingPlusLiquidBarrel;
import CookingPlus.tiles.LiquidBarrelTileEntity;

public class LiquidBarrelRenderer extends TileEntitySpecialRenderer {
	
	EntityItem entItem;
	ResourceLocation texture = new ResourceLocation("agriculturalrevolution:textures/blocks/dryingrack.png");
	ResourceLocation Creamtexture = new ResourceLocation("agriculturalrevolution:textures/blocks/creamliquid.png");
	ResourceLocation watertexture = new ResourceLocation("agriculturalrevolution:textures/blocks/waterliquid.png");
	ResourceLocation cheddartexture = new ResourceLocation("agriculturalrevolution:textures/blocks/cheddarliquid.png");
	ResourceLocation bluetexture = new ResourceLocation("agriculturalrevolution:textures/blocks/blueliquid.png");
	ResourceLocation halloumitexture = new ResourceLocation("agriculturalrevolution:textures/blocks/halloumiliquid.png");
	ResourceLocation cctexture = new ResourceLocation("agriculturalrevolution:textures/blocks/ccliquid.png");
	
	private CookingPlusLiquidBarrel model;
	
	public LiquidBarrelRenderer(){
		this.model = new CookingPlusLiquidBarrel();
		entItem = null;
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f, int dunno) {
		GL11.glPushMatrix();
		GL11.glTranslated((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		
		this.bindTexture(texture);
		
		GL11.glPushMatrix();
		this.model.RenderModel(0.0625f);
		if(entity != null){
		if(entity instanceof LiquidBarrelTileEntity){
			LiquidBarrelTileEntity myEntity = (LiquidBarrelTileEntity)entity;
			if(myEntity.getLiquid().equals("cream")){
				this.bindTexture(Creamtexture);
				this.model.RenderLiquid(0.0625f, 0.0f);
			}
			if(myEntity.getLiquid().equals("water")){
				this.bindTexture(watertexture);
				this.model.RenderLiquid(0.0625f, 0.0f);
			}
			if(myEntity.getLiquid().equals("cheddar")){
				this.bindTexture(cheddartexture);
				this.model.RenderLiquid(0.0625f, 0.0f);
			}
			if(myEntity.getLiquid().equals("halloumi")){
				this.bindTexture(halloumitexture);
				this.model.RenderLiquid(0.0625f, 0.0f);
			}
			if(myEntity.getLiquid().equals("blue")){
				this.bindTexture(bluetexture);
				this.model.RenderLiquid(0.0625f, 0.0f);
			}
			if(myEntity.getLiquid().equals("cc")){
				this.bindTexture(cctexture);
				this.model.RenderLiquid(0.0625f, 0.0f);
			}
		}
		}
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		

	}

}
