package CookingPlus.Renderers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import CookingPlus.models.CookingPlusMarketBox;
import CookingPlus.tiles.MarketBoxTileEntity;

public class MarketBoxRender extends TileEntitySpecialRenderer {
	EntityItem entItem;
	ResourceLocation texture = new ResourceLocation("agriculturalrevolution:textures/blocks/marketboxmap.png");
	
	private CookingPlusMarketBox model;
	
	public MarketBoxRender(){
		entItem = null;
		this.model = new CookingPlusMarketBox();
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f, int dunno) {
		GL11.glPushMatrix();//model transformations
		GL11.glTranslated((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		
		MarketBoxTileEntity MyOven = (MarketBoxTileEntity) entity;

		GL11.glRotatef(90, 0, 1, 0);
		if(MyOven != null){
		if(MyOven.getDirection() == 3){
			GL11.glRotatef(0, 0, 1, 0);
		}
		else if(MyOven.getDirection() == 4){
			GL11.glRotatef(90, 0, 1, 0);
		}
		else if(MyOven.getDirection() == 2){ 
			GL11.glRotatef(180, 0, 1, 0);
		}
		else if(MyOven.getDirection() == 5){
			GL11.glRotatef(270, 0, 1, 0);
		}
		}
		
		this.bindTexture(texture);
		
		GL11.glPushMatrix(); //model
		this.model.RenderModel(0.0625f);
		GL11.glPopMatrix();
		
		GL11.glPopMatrix();
		
		if(MyOven != null){
		if(MyOven.hasWorldObj() == true){
		 int slot = 0; //Example: int slot = 1;
		 if(MyOven.getStackInSlot(slot) != null){
			 entItem = new EntityItem(MyOven.getWorld(), x, y, z, MyOven.getStackInSlot(slot));
			 //if((entItem == null) || entItem.getEntityItem().getItem() != MyOven.getStackInSlot(slot).getItem())entItem = new EntityItem(MyOven.getWorld(), x, y, z, MyOven.getStackInSlot(slot));
			 GL11.glPushMatrix();
			 
			//itemstack render
				//GL11.glRotatef(90, 0, 1, 0);
			 	GL11.glTranslatef((float)x + 0.5f, (float)y, (float)z + 0.5f);
			 	
			 	if(MyOven.getDirection() == 2){
					GL11.glRotatef(0, 0, 1, 0);
				}
				else if(MyOven.getDirection() == 4){
					GL11.glRotatef(90, 0, 1, 0);
				}
				else if(MyOven.getDirection() == 3){ 
					GL11.glRotatef(180, 0, 1, 0);
				}
				else if(MyOven.getDirection() == 5){
					GL11.glRotatef(270, 0, 1, 0);
				}
			 	
			 	
			 RenderHelper.disableStandardItemLighting();
			 this.entItem.hoverStart = 0.0F;
			 RenderHelper.enableStandardItemLighting();
			 //RenderItem.renderInFrame = true;
			 	GL11.glPushMatrix();//item one
			 	GL11.glTranslatef(0.23F, 0.15f, 0.1F);
			 	GL11.glRotatef(90, 1, 0, 0);
			 	GL11.glScalef(0.5f, 0.5f, 0.5f);
			 	Minecraft.getMinecraft().getRenderItem().renderItem(MyOven.getStackInSlot(slot), ItemCameraTransforms.TransformType.NONE);
			 	//Minecraft.getMinecraft().getRenderManager().renderEntityStatic(this.entItem, 0, true);
			 	//Minecraft.getMinecraft().getRenderManager().renderEntityWithPosYaw(this.entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
			 	GL11.glPopMatrix();
			 	
			 	if(MyOven.getStackInSlot(slot).stackSize > 12){
			 	GL11.glPushMatrix();//item two
			 	GL11.glTranslatef(0.23F, 0.16f, -0.1F);
			 	GL11.glRotatef(90, 1, 0, 0);
			 	GL11.glScalef(0.5f, 0.5f, 0.5f);
			 	Minecraft.getMinecraft().getRenderItem().renderItem(MyOven.getStackInSlot(slot), ItemCameraTransforms.TransformType.NONE);
			 	//Minecraft.getMinecraft().getRenderManager().renderEntityStatic(this.entItem, 0, true);
			 	//Minecraft.getMinecraft().getRenderManager().renderEntityWithPosYaw(this.entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
			 	GL11.glPopMatrix();
			 	}
			 	
			 	if(MyOven.getStackInSlot(slot).stackSize > 24){
			 	GL11.glPushMatrix();//item three
			 	GL11.glTranslatef(0F, 0.17f, 0.1F);
			 	GL11.glRotatef(90, 1, 0, 0);
			 	GL11.glScalef(0.5f, 0.5f, 0.5f);
			 	Minecraft.getMinecraft().getRenderItem().renderItem(MyOven.getStackInSlot(slot), ItemCameraTransforms.TransformType.NONE);
			 	//Minecraft.getMinecraft().getRenderManager().renderEntityStatic(this.entItem, 0, true);
			 	//Minecraft.getMinecraft().getRenderManager().renderEntityWithPosYaw(this.entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
			 	GL11.glPopMatrix();
			 	}

			 	if(MyOven.getStackInSlot(slot).stackSize > 36){
			 	GL11.glPushMatrix();//item four
			 	GL11.glTranslatef(0F, 0.18f, -0.1F);
			 	GL11.glRotatef(90, 1, 0, 0);
			 	GL11.glScalef(0.5f, 0.5f, 0.5f);
			 	Minecraft.getMinecraft().getRenderItem().renderItem(MyOven.getStackInSlot(slot), ItemCameraTransforms.TransformType.NONE);
			 	//Minecraft.getMinecraft().getRenderManager().renderEntityStatic(this.entItem, 0, true);
			 	//Minecraft.getMinecraft().getRenderManager().renderEntityWithPosYaw(this.entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
			 	GL11.glPopMatrix();
			 	}
			 	
			 	if(MyOven.getStackInSlot(slot).stackSize > 48){
			 	GL11.glPushMatrix();//item five
			 	GL11.glTranslatef(-0.25F, 0.19f, 0.1F);
			 	GL11.glRotatef(90, 1, 0, 0);
			 	GL11.glScalef(0.5f, 0.5f, 0.5f);
			 	Minecraft.getMinecraft().getRenderItem().renderItem(MyOven.getStackInSlot(slot), ItemCameraTransforms.TransformType.NONE);
			 	//Minecraft.getMinecraft().getRenderManager().renderEntityStatic(this.entItem, 0, true);
			 	//Minecraft.getMinecraft().getRenderManager().renderEntityWithPosYaw(this.entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
			 	GL11.glPopMatrix();
			 	}
			 	
			 	if(MyOven.getStackInSlot(slot).stackSize > 60){
			 	GL11.glPushMatrix();//item six
			 	GL11.glTranslatef(-0.25F, 0.20f, -0.1F);
			 	GL11.glRotatef(90, 1, 0, 0);
			 	GL11.glScalef(0.5f, 0.5f, 0.5f);
			 	Minecraft.getMinecraft().getRenderItem().renderItem(MyOven.getStackInSlot(slot), ItemCameraTransforms.TransformType.NONE);
			 	//Minecraft.getMinecraft().getRenderManager().renderEntityStatic(this.entItem, 0, true);
			 	//Minecraft.getMinecraft().getRenderManager().renderEntityWithPosYaw(this.entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
			 	GL11.glPopMatrix();
			 	}
			 	RenderHelper.enableStandardItemLighting();
			 	
			 //RenderItem.renderInFrame = false;
			 GL11.glPopMatrix();
		 }
		}
		}
	}

}
