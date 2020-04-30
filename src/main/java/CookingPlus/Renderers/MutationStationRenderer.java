package CookingPlus.Renderers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import CookingPlus.blocks.tileentity.MutationStationBlock;
import CookingPlus.tiles.MutationStationTileEntity;


public class MutationStationRenderer extends TileEntitySpecialRenderer {
	
	EntityItem entItem;
	
	
	public MutationStationRenderer(){
		entItem = null;
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f, int dunno) {
		MutationStationTileEntity MyOven = (MutationStationTileEntity) entity;//change

		if(MyOven != null){
			if(MyOven.hasWorldObj() == true){
				
				int myDirection = MyOven.getWorld().getBlockState(MyOven.getPos()).getValue(MutationStationBlock.FACING).getIndex();
				
				 int slot = 0;
				 if(MyOven.getStackInSlot(slot) != null){
					 entItem = new EntityItem(MyOven.getWorld(), x, y, z, MyOven.getStackInSlot(slot));
					 GL11.glPushMatrix();
					 GL11.glTranslatef((float)x + 0.5f, (float)y, (float)z + 0.5f);
					 
					 this.entItem.hoverStart = 0.0F;
					 
					 if(myDirection == 2){
						GL11.glRotatef(0, 0, 1, 0);
					}
					else if(myDirection == 4){
						GL11.glRotatef(90, 0, 1, 0);
					}
					else if(myDirection == 3){ //correct
						GL11.glRotatef(180, 0, 1, 0);
					}
					else if(myDirection == 5){
						GL11.glRotatef(270, 0, 1, 0);
					}
					 
					 RenderHelper.disableStandardItemLighting();
					 if(MyOven.getStackInSlot(slot).stackSize > 0){
						 	GL11.glPushMatrix();//item two
						 	GL11.glTranslatef(-0.25F, 0.1f, -0.05F);
						 	GL11.glRotatef(90, 1, 0, 0);
						 	GL11.glScalef(0.18f, 0.18f, 0.18f);
						 	Minecraft.getMinecraft().getRenderItem().renderItem(MyOven.getStackInSlot(slot), ItemCameraTransforms.TransformType.NONE);
						 	GL11.glPopMatrix();
					 }
					 RenderHelper.enableStandardItemLighting();
					 GL11.glPopMatrix();
				 }
				 
				 
				 slot = 1;
				 if(MyOven.getStackInSlot(slot) != null){
					 entItem = new EntityItem(MyOven.getWorld(), x, y, z, MyOven.getStackInSlot(slot));
					 GL11.glPushMatrix();
					 GL11.glTranslatef((float)x + 0.5f, (float)y, (float)z + 0.5f);
					 
					 this.entItem.hoverStart = 0.0F;
					 
					 if(myDirection == 2){
						GL11.glRotatef(0, 0, 1, 0);
					}
					else if(myDirection == 4){
						GL11.glRotatef(90, 0, 1, 0);
					}
					else if(myDirection == 3){ //correct
						GL11.glRotatef(180, 0, 1, 0);
					}
					else if(myDirection == 5){
						GL11.glRotatef(270, 0, 1, 0);
					}
					 
					 RenderHelper.disableStandardItemLighting();
					 if(MyOven.getStackInSlot(slot).stackSize > 0){
						 	GL11.glPushMatrix();//item two
						 	GL11.glTranslatef(-0.25F, 0.1f, -0.25F);
						 	GL11.glRotatef(90, 1, 0, 0);
						 	GL11.glScalef(0.18f, 0.18f, 0.18f);
						 	Minecraft.getMinecraft().getRenderItem().renderItem(MyOven.getStackInSlot(slot), ItemCameraTransforms.TransformType.NONE);
						 	GL11.glPopMatrix();
					 }
					 RenderHelper.enableStandardItemLighting();
					 GL11.glPopMatrix();
				 }
			}
		}
	}
}
