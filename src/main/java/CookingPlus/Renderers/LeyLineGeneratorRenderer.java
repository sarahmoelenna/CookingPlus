package CookingPlus.Renderers;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import CookingPlus.Interfaces.ILeyLineProducer;
import CookingPlus.models.CookingPlusGatherer;
import CookingPlus.models.CookingPlusLaser;
import CookingPlus.models.CookingPlusLeyMachineCore;
import CookingPlus.models.CookingPlusLeyMachineSide;
import CookingPlus.tiles.CookingPlusCustomTileEntity;
import CookingPlus.tiles.DesalinatorTileEntity;
import CookingPlus.tiles.LaserDroneBayTileEntity;
import CookingPlus.tiles.LeyLineGeneratorTileEntity;

public class LeyLineGeneratorRenderer extends TileEntitySpecialRenderer<CookingPlusCustomTileEntity> {
	
	ResourceLocation texture = new ResourceLocation("agriculturalrevolution:textures/blocks/machine_simple.png");
	ResourceLocation texturetwo = new ResourceLocation("agriculturalrevolution:textures/blocks/machine_side.png");
	ResourceLocation leybeam = new ResourceLocation("agriculturalrevolution:textures/blocks/leybeam.png");
	ResourceLocation leybeam1 = new ResourceLocation("agriculturalrevolution:textures/blocks/leybeam_1.png");
	ResourceLocation leybeam2 = new ResourceLocation("agriculturalrevolution:textures/blocks/leybeam_2.png");
	ResourceLocation leybeam3 = new ResourceLocation("agriculturalrevolution:textures/blocks/leybeam_3.png");
	ResourceLocation leybeam4 = new ResourceLocation("agriculturalrevolution:textures/blocks/leybeam_4.png");
	ResourceLocation leybeam5 = new ResourceLocation("agriculturalrevolution:textures/blocks/leybeam_5.png");
	ResourceLocation leybeam6 = new ResourceLocation("agriculturalrevolution:textures/blocks/leybeam_6.png");
	
	ResourceLocation coreTexture = new ResourceLocation("agriculturalrevolution:textures/blocks/aircrystal.png");
	ResourceLocation coreTexture2 = new ResourceLocation("agriculturalrevolution:textures/blocks/firecrystal.png");
	
	private CookingPlusLeyMachineSide model;
	private CookingPlusLaser lasermodel;
	private CookingPlusLeyMachineCore coremodel;
	
	public LeyLineGeneratorRenderer(){
		this.model = new CookingPlusLeyMachineSide();
		this.lasermodel = new CookingPlusLaser();
		this.coremodel = new CookingPlusLeyMachineCore();
	}
	
	@Override
	public void renderTileEntityAt(CookingPlusCustomTileEntity entity, double x, double y, double z, float f, int dunno) {
		GL11.glPushMatrix();
		GL11.glTranslated((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		ILeyLineProducer myentity = (ILeyLineProducer) entity;
		this.bindTexture(texture);
		if(myentity.stateOfSide(EnumFacing.EAST) < 2){
			if(myentity.stateOfSide(EnumFacing.EAST) == 0){
				this.bindTexture(texture);
			}
			else{
				this.bindTexture(texturetwo);
			}
			GL11.glPushMatrix();
			model.RenderModel(0.0625f);
			GL11.glPopMatrix();
		}
		if(myentity.stateOfSide(EnumFacing.WEST) < 2){
			if(myentity.stateOfSide(EnumFacing.WEST) == 0){
				this.bindTexture(texture);
			}
			else{
				this.bindTexture(texturetwo);
			}
			GL11.glPushMatrix();
			GL11.glRotatef(180,0,1,0);
			model.RenderModel(0.0625f);
			GL11.glPopMatrix();
		}
		if(myentity.stateOfSide(EnumFacing.NORTH) < 2){
			if(myentity.stateOfSide(EnumFacing.NORTH) == 0){
				this.bindTexture(texture);
			}
			else{
				this.bindTexture(texturetwo);
			}
			GL11.glPushMatrix();
			GL11.glRotatef(270,0,1,0);
			model.RenderModel(0.0625f);
			GL11.glPopMatrix();
		}
		if(myentity.stateOfSide(EnumFacing.SOUTH) < 2){
			if(myentity.stateOfSide(EnumFacing.SOUTH) == 0){
				this.bindTexture(texture);
			}
			else{
				this.bindTexture(texturetwo);
			}
			GL11.glPushMatrix();
			GL11.glRotatef(90,0,1,0);
			model.RenderModel(0.0625f);
			GL11.glPopMatrix();
		}
		if(myentity.stateOfSide(EnumFacing.UP) < 2){
			if(myentity.stateOfSide(EnumFacing.UP) == 0){
				this.bindTexture(texture);
			}
			else{
				this.bindTexture(texturetwo);
			}
			GL11.glPushMatrix();
			GL11.glTranslated(1, 1, 0);
			GL11.glRotatef(90,0,0,1);
			model.RenderModel(0.0625f);
			GL11.glPopMatrix();
		}
		if(myentity.stateOfSide(EnumFacing.DOWN) < 2){
			if(myentity.stateOfSide(EnumFacing.DOWN) == 0){
				this.bindTexture(texture);
			}
			else{
				this.bindTexture(texturetwo);
			}
			GL11.glPushMatrix();
			GL11.glTranslated(-1, 1, 0);
			GL11.glRotatef(270,0,0,1);
			model.RenderModel(0.0625f);
			GL11.glPopMatrix();
		}
		
		
		//lets begin drawing our leylines
		GL11.glEnable(GL11.GL_BLEND); 
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		int beamLength = 0;
		int beamPower = myentity.getBeamPowerLevel();
		if(beamPower == 0){
			this.bindTexture(leybeam);
		} else if(beamPower == 1){
			this.bindTexture(leybeam1);
		} else if(beamPower == 2){
			this.bindTexture(leybeam2);
		} else if(beamPower == 3){
			this.bindTexture(leybeam3);
		} else if(beamPower == 4){
			this.bindTexture(leybeam4);
		} else if(beamPower == 5){
			this.bindTexture(leybeam5);
		} else if(beamPower == 6){
			this.bindTexture(leybeam6);
		}
		//UP Beam
		if(myentity.stateOfSide(EnumFacing.UP) == 2 && myentity.isBeamVisible(EnumFacing.UP)){
			beamLength = myentity.getSideBlockCount(EnumFacing.UP);
			if(beamLength > 0){
				beamLength++;
				GL11.glPushMatrix();
				GL11.glTranslated(0, 1 ,0);
				GL11.glRotatef(0, 1, 0, 0);
				if(beamLength > 1){
					GL11.glTranslated(0, -beamLength * 0.5f, 0);
					GL11.glScalef(1, beamLength, 1);
				}
				GL11.glTranslated(0, -1,0);
				GL11.glRotatef(myentity.getLeyRotation(), 0, 1, 0);
				lasermodel.RenderModel(0.0625f);
				GL11.glPopMatrix();
			}
		}
		//DOWN Beam
		if(myentity.stateOfSide(EnumFacing.DOWN) == 2 && myentity.isBeamVisible(EnumFacing.DOWN)){
			beamLength = myentity.getSideBlockCount(EnumFacing.DOWN);
			if(beamLength > 0){
				beamLength++;
				GL11.glPushMatrix();
				GL11.glTranslated(0, 1 ,0);
				GL11.glRotatef(180, 1, 0, 0);
				if(beamLength > 1){
					GL11.glTranslated(0, -beamLength * 0.5f, 0);
					GL11.glScalef(1, beamLength, 1);
				}
				GL11.glTranslated(0, -1,0);
				GL11.glRotatef(myentity.getLeyRotation(), 0, 1, 0);
				lasermodel.RenderModel(0.0625f);
				GL11.glPopMatrix();
			}
		}
		//EAST Beam
		if(myentity.stateOfSide(EnumFacing.EAST) == 2&& myentity.isBeamVisible(EnumFacing.EAST)){
			beamLength = myentity.getSideBlockCount(EnumFacing.EAST);
			if(beamLength > 0){
				beamLength++;
				GL11.glPushMatrix();
				GL11.glTranslated(0, 1 ,0);
				GL11.glRotatef(270, 0, 0, 1);
				if(beamLength > 1){
					GL11.glTranslated(0, -beamLength * 0.5f, 0);
					GL11.glScalef(1, beamLength, 1);
				}
				GL11.glTranslated(0, -1,0);
				GL11.glRotatef(myentity.getLeyRotation(), 0, 1, 0);
				lasermodel.RenderModel(0.0625f);
				GL11.glPopMatrix();
			}
		}
		//WEST Beam
		if(myentity.stateOfSide(EnumFacing.WEST) == 2&& myentity.isBeamVisible(EnumFacing.WEST)){
			beamLength = myentity.getSideBlockCount(EnumFacing.WEST);
			if(beamLength > 0){
				beamLength++;
				GL11.glPushMatrix();
				GL11.glTranslated(0, 1 ,0);
				GL11.glRotatef(90, 0, 0, 1);
				if(beamLength > 1){
					GL11.glTranslated(0, -beamLength * 0.5f, 0);
					GL11.glScalef(1, beamLength, 1);
				}
				GL11.glTranslated(0, -1,0);
				GL11.glRotatef(myentity.getLeyRotation(), 0, 1, 0);
				lasermodel.RenderModel(0.0625f);
				GL11.glPopMatrix();
			}
		}
		//SOUTH Beam
		if(myentity.stateOfSide(EnumFacing.SOUTH) == 2 && myentity.isBeamVisible(EnumFacing.SOUTH)){
			beamLength = myentity.getSideBlockCount(EnumFacing.SOUTH);
			if(beamLength > 0){
				beamLength++;
				GL11.glPushMatrix();
				GL11.glTranslated(0, 1 ,0);
				GL11.glRotatef(270, 1, 0, 0);
				if(beamLength > 1){
					GL11.glTranslated(0, -beamLength * 0.5f, 0);
					GL11.glScalef(1, beamLength, 1);
				}
				GL11.glTranslated(0, -1,0);
				GL11.glRotatef(myentity.getLeyRotation(), 0, 1, 0);
				lasermodel.RenderModel(0.0625f);
				GL11.glPopMatrix();
			}
		}
		//North Beam
		if(myentity.stateOfSide(EnumFacing.NORTH) == 2 && myentity.isBeamVisible(EnumFacing.NORTH)){
			beamLength = myentity.getSideBlockCount(EnumFacing.NORTH);
			if(beamLength > 0){
				beamLength++;
				GL11.glPushMatrix();
				GL11.glTranslated(0, 1 ,0);
				GL11.glRotatef(90, 1, 0, 0);
				if(beamLength > 1){
					GL11.glTranslated(0, -beamLength * 0.5f,0);
					GL11.glScalef(1, beamLength, 1);
				}
				GL11.glTranslated(0, -1 ,0);
				GL11.glRotatef(myentity.getLeyRotation(), 0, 1, 0);
				lasermodel.RenderModel(0.0625f);
				GL11.glPopMatrix();
			}
		}
		
		if(entity instanceof LeyLineGeneratorTileEntity){
			this.bindTexture(coreTexture2);
		}
		else{
			this.bindTexture(coreTexture);
		}
		GL11.glPushMatrix();
		GL11.glRotatef(myentity.getLeyRotation(), 0, 1, 0);
		coremodel.RenderModel(0.0625f);
		GL11.glPopMatrix();
		
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
	}

	public boolean isGlobalRenderer(CookingPlusCustomTileEntity te)
    {
        return true;
    }
}
