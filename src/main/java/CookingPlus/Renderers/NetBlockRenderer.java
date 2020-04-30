package CookingPlus.Renderers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import CookingPlus.models.CookingPlusPlainCube;
import CookingPlus.tiles.NetBlockTileEntity;

public class NetBlockRenderer extends TileEntitySpecialRenderer {
	
	EntityItem entItem;
	ResourceLocation texture = new ResourceLocation("agriculturalrevolution:textures/blocks/netblock.png");
	
	private CookingPlusPlainCube model;
	
	public NetBlockRenderer(){
		this.model = new CookingPlusPlainCube();
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
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		
		
		if(entity instanceof NetBlockTileEntity){
		NetBlockTileEntity MyOven = (NetBlockTileEntity) entity;
		if(MyOven != null){
		if(MyOven.hasWorldObj() == true){
			 int slot = 0;
			 if(MyOven.getStackInSlot(slot) != null){
				 entItem = new EntityItem(MyOven.getWorld(), x, y, z, MyOven.getStackInSlot(slot));
				 GL11.glPushMatrix();
				 GL11.glDisable(GL11.GL_CULL_FACE);
				 GL11.glTranslatef((float)x + 0.5f, (float)y, (float)z + 0.5f);
				 this.entItem.hoverStart = 0.0F;

				 RenderHelper.disableStandardItemLighting();
				 if(MyOven.getStackInSlot(slot).stackSize > 0){
					 	GL11.glPushMatrix();//item two
					 	GL11.glTranslatef(0.0F, 0.5f, 0.0F);
					 	//GL11.glRotatef(90, 1, 0, 0);
					 	GL11.glScalef(0.9f, 0.9f, 0.9f);
					 	float Angle = 0;
						Angle = (float)Math.atan2(x + 0.5f,z +0.5f);
						float MyAngle = (float) (Angle*(180/Math.PI));
						GL11.glRotatef(MyAngle, 0, 1, 0);
						//Minecraft.getMinecraft().getRenderManager().renderEntityStatic(this.entItem, 0, true);
						Minecraft.getMinecraft().getRenderItem().renderItem(MyOven.getStackInSlot(slot), ItemCameraTransforms.TransformType.NONE);
					 	
					 	GL11.glPopMatrix();
				 }
				 RenderHelper.enableStandardItemLighting();
				 GL11.glEnable(GL11.GL_CULL_FACE);
				 GL11.glPopMatrix();
			 }
			}
		}
		}
	}

}
