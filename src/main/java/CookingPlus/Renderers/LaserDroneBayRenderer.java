package CookingPlus.Renderers;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

import org.lwjgl.opengl.GL11;

import CookingPlus.models.CookingPlusDrone;
import CookingPlus.models.CookingPlusGatherer;
import CookingPlus.models.CookingPlusLaser;
import CookingPlus.tiles.LaserDroneBayTileEntity;
import ModelBoxes.CookingPlusDroneModelBox;

public class LaserDroneBayRenderer extends TileEntitySpecialRenderer<LaserDroneBayTileEntity> {
	
	ResourceLocation texture = new ResourceLocation("agriculturalrevolution:textures/blocks/laserdronebaymap.png");
	ResourceLocation dronetexture = new ResourceLocation("agriculturalrevolution:textures/blocks/botdronemap.png");
	ResourceLocation lasertexture = new ResourceLocation("agriculturalrevolution:textures/blocks/lasermap.png");
	
	private CookingPlusGatherer model;
	private CookingPlusDrone dronemodel;
	private CookingPlusLaser lasermodel;
	
	public LaserDroneBayRenderer(){
		this.model = new CookingPlusGatherer();
		this.dronemodel = new CookingPlusDrone();
		this.lasermodel = new CookingPlusLaser();
	}
	
	
	@Override
	public void renderTileEntityAt(LaserDroneBayTileEntity entity, double x, double y, double z, float f, int dunno) {
		GL11.glPushMatrix();
		GL11.glTranslated((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		LaserDroneBayTileEntity myentity = (LaserDroneBayTileEntity) entity;
		this.bindTexture(texture);
		
		GL11.glPushMatrix();
		if(myentity != null){
			this.model.RenderModel(0.0625f, myentity.getType());
		}
		else{
			this.model.RenderModel(0.0625f, 0);
		}
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		//lets render out 'drone'
		myentity = (LaserDroneBayTileEntity) entity;
		GL11.glPushMatrix();
		GL11.glTranslated((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		Vec3d myPos = new Vec3d(0,0,0);
		if(myentity != null){
			myPos = myentity.getDroneOffsetPos();
		}
		GL11.glTranslated(myPos.xCoord, myPos.yCoord, myPos.zCoord);
		GL11.glRotatef(180, 0f, 0f, 1f);
		if(myentity != null){
			GL11.glRotatef(myentity.getRotation(), 0, 1f, 0);
		}
		this.bindTexture(dronetexture);
		
		GL11.glPushMatrix();
		GL11.glScalef(0.5f, 0.5f, 0.5f);
		if(myentity != null){
			this.dronemodel.RenderModel(0.0625f);
		}
		else{
			
		}
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		
		//lets render out 'laser'
				myentity = (LaserDroneBayTileEntity) entity;
				GL11.glPushMatrix();
				GL11.glTranslated((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
				myPos = new Vec3d(0,0,0);
				if(myentity != null){
					myPos = myentity.getDroneOffsetPos();
				}
				GL11.glTranslated(myPos.xCoord, myPos.yCoord, myPos.zCoord);
				GL11.glRotatef(180, 0f, 0f, 1f);
				if(myentity != null){
					GL11.glRotatef(myentity.getRotation(), 0, 1f, 0);
				}
				this.bindTexture(lasertexture);
				
				GL11.glPushMatrix();
				GL11.glScalef(0.5f, 1.35f, 0.5f);
				if(myentity != null){
					//this.dronemodel.RenderModel(0.0625f);
					if(myentity.getInPosition() == true){
						GL11.glEnable(GL11.GL_BLEND); 
						this.lasermodel.RenderModel(0.0625f);
						GL11.glDisable(GL11.GL_BLEND);
					}
				}
				else{
					
				}
				GL11.glPopMatrix();
				GL11.glPopMatrix();
		
		
	}
	
	public boolean isGlobalRenderer(LaserDroneBayTileEntity te)
    {
        return true;
    }

}
