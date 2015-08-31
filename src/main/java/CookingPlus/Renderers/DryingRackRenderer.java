package CookingPlus.Renderers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import CookingPlus.models.CookingPlusDryingRack;
import CookingPlus.tiles.DryingRackTileEntity;

public class DryingRackRenderer extends TileEntitySpecialRenderer {
	
	ResourceLocation texture = new ResourceLocation("cookingplus:textures/blocks/dryingrack.png");
	EntityItem entItem;
	
	private CookingPlusDryingRack model;
	
	public DryingRackRenderer(){
		this.model = new CookingPlusDryingRack();
		entItem = null;
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f, int dunno) {
		GL11.glPushMatrix();
		GL11.glTranslated((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		
		DryingRackTileEntity MyOven = (DryingRackTileEntity) entity;//change
		//System.out.println(MyOven.getDirection());
		GL11.glRotatef(90, 0, 1, 0);
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
		
		this.bindTexture(texture);
		
		GL11.glPushMatrix();
		this.model.RenderModel(0.0625f);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
			if(MyOven.hasWorldObj() == true){
				 int slot = 0;
				 if(MyOven.getStackInSlot(slot) != null){
					 entItem = new EntityItem(MyOven.getWorld(), x, y, z, MyOven.getStackInSlot(slot));
					 //if((entItem == null) || entItem.getEntityItem().getItem() != MyOven.getStackInSlot(slot).getItem())entItem = new EntityItem(MyOven.getWorld(), x, y, z, MyOven.getStackInSlot(slot));
					 GL11.glPushMatrix();
					 GL11.glTranslatef((float)x + 0.5f, (float)y, (float)z + 0.5f);
					 
					 this.entItem.hoverStart = 0.0F;
					 
					 if(MyOven.getDirection() == 2){
							GL11.glRotatef(0, 0, 1, 0);
						}
						else if(MyOven.getDirection() == 4){
							GL11.glRotatef(90, 0, 1, 0);
						}
						else if(MyOven.getDirection() == 3){ //correct
							GL11.glRotatef(180, 0, 1, 0);
						}
						else if(MyOven.getDirection() == 5){
							GL11.glRotatef(270, 0, 1, 0);
						}
					 
					 RenderHelper.disableStandardItemLighting();
					 if(MyOven.getStackInSlot(slot).stackSize > 0){
						 	GL11.glPushMatrix();//item two
						 	GL11.glTranslatef(0.0F, 0.05f, 0.06F);
						 	GL11.glRotatef(8, 1, 0, 0);
						 	Minecraft.getMinecraft().getRenderManager().renderEntityWithPosYaw(this.entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
						 	GL11.glPopMatrix();
					 }
					 RenderHelper.enableStandardItemLighting();
					 
					 GL11.glPopMatrix();
				 }
				}
			
	}

}
