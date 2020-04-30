package CookingPlus.Renderers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import CookingPlus.blocks.tileentity.FishTankBlock;
import CookingPlus.tiles.FishTankTileEntity;


public class FishTankRenderer extends TileEntitySpecialRenderer {
	
	EntityItem entItem;
	
	
	public FishTankRenderer(){
		entItem = null;
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f, int dunno) {
		FishTankTileEntity MyOven = (FishTankTileEntity) entity;//change

		if(MyOven != null){
			if(MyOven.hasWorldObj() == true && MyOven.canProcess() == true){
				for(float i = 0; i < 9; i++){
					if(MyOven.getRenderItem((int)i) != null){
						
						float myX = i%3f - 1f + ((MyOven.movementX[(int)i] - 0.5f) * 0.7f);
						float myY = 1f + ((MyOven.movementY[(int)i] - 0.5f) * 0.7f);
						float myZ = (i - i%3f)/3f - 1f + ((MyOven.movementZ[(int)i] - 0.5f) * 0.7f);
						
						
						GL11.glPushMatrix();
						GL11.glTranslatef((float)x + 0.5f, (float)y + 0.5f, (float)z + 0.5f);
						RenderHelper.disableStandardItemLighting();
						if(MyOven.getStackInSlot((int)i).stackSize > 0){
						 	GL11.glPushMatrix();//item two
						 	GL11.glTranslatef(myX, myY, myZ);
						 	
						 	float Angle = 0;
							Angle = (float)Math.atan2(x + 0.5f + myX,z +0.5f + myZ);
							float MyAngle = (float) (Angle*(180/Math.PI));
							GL11.glRotatef(MyAngle, 0, 1, 0);
							
							GL11.glRotatef(-45, 0, 0, 1);
							
						 	GL11.glScalef(0.5f, 0.5f, 0.5f);
						 	Minecraft.getMinecraft().getRenderItem().renderItem(MyOven.getRenderItem((int)i), ItemCameraTransforms.TransformType.NONE);
						 	GL11.glPopMatrix();
						}
						RenderHelper.enableStandardItemLighting();
						GL11.glPopMatrix();
					}
				}
			}
		}
	}
}
