package CookingPlus.Renderers;

import org.lwjgl.opengl.GL11;

import CookingPlus.CookingPlusMain;
import CookingPlus.models.CookingPlusBrickOven;
import CookingPlus.models.CookingPlusChurn;
import CookingPlus.models.CookingPlusOilPress;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class Render3DHandItem implements IItemRenderer {
	
	public CookingPlusBrickOven BrickOvenModel = new CookingPlusBrickOven();
	public CookingPlusChurn ButterChurnModel = new CookingPlusChurn();
	public CookingPlusOilPress OilPressModel = new CookingPlusOilPress();
	
	public Render3DHandItem(){
		//System.out.println("registered hand render");
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		//System.out.println(item.getDisplayName());
		if (item.isItemEqual(new ItemStack(CookingPlusMain.blockBrickOven))){
			//System.out.println("sup");
			return true;
		}
		else if (item.isItemEqual(new ItemStack(CookingPlusMain.blockButterChurn))){
			//System.out.println("sup");
			return true;
		}
		else if (item.isItemEqual(new ItemStack(CookingPlusMain.blockOilPress))){
			//System.out.println("sup");
			return true;
		}
		return false;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		// TODO Auto-generated method stub
		
			GL11.glPushMatrix();
		if (type == ItemRenderType.ENTITY){
			GL11.glTranslatef(0, 1f, 0);
			GL11.glRotatef(180, 1, 0, 0);
			if (item.isItemEqual(new ItemStack(CookingPlusMain.blockBrickOven))){
				//GL11.glTranslatef(0, -0.5f, 0);
				GL11.glScalef(0.75f,  0.75f,  0.75f);
			}
		}
		
		if (type == ItemRenderType.EQUIPPED){
			GL11.glTranslatef(0.625f, 1f, 0.625f);
			GL11.glRotatef(180, 1, 0, 0);
			if (item.isItemEqual(new ItemStack(CookingPlusMain.blockBrickOven))){
				//GL11.glTranslatef(0, -0.5f, 0);
				GL11.glScalef(0.75f,  0.75f,  0.75f);
			}
		}
			
		if (type == ItemRenderType.EQUIPPED_FIRST_PERSON){

			
			GL11.glTranslatef(0, 0, 0.3f);
			GL11.glRotatef(180, 1, 0, 0);
			GL11.glTranslatef(0, -1.5f, 0);
			if (item.isItemEqual(new ItemStack(CookingPlusMain.blockBrickOven))){
				//GL11.glTranslatef(0, -0.5f, 0);
				GL11.glScalef(0.75f,  0.75f,  0.75f);
			}
	
		}
		
		if (type == ItemRenderType.INVENTORY){
			
			GL11.glRotatef(180, 1, 0, 0);
			GL11.glTranslatef(0, -1f, 0);
			if (item.isItemEqual(new ItemStack(CookingPlusMain.blockBrickOven))){
				GL11.glTranslatef(0, 0.6f, 0);
				GL11.glScalef(0.65f,  0.65f,  0.65f);
			}

			}
		if (item.isItemEqual(new ItemStack(CookingPlusMain.blockBrickOven))){
			//System.out.println("sup");
			ResourceLocation ovenbricktexture = new ResourceLocation("cookingplus:textures/blocks/ovenmap.png");
			Minecraft.getMinecraft().renderEngine.bindTexture(ovenbricktexture);
			BrickOvenModel.render(null, 0, 0, 0, 0, 0, 0.0625f);
		}
		else if (item.isItemEqual(new ItemStack(CookingPlusMain.blockButterChurn))){
			//System.out.println("sup");
			ResourceLocation churntexture = new ResourceLocation("cookingplus:textures/blocks/churn.png");
			Minecraft.getMinecraft().renderEngine.bindTexture(churntexture);
			ButterChurnModel.render(null, 0, 0, 0, 0, 0, 0.0625f);
		}
		else if (item.isItemEqual(new ItemStack(CookingPlusMain.blockOilPress))){
			//System.out.println("sup");
			ResourceLocation oiltexture = new ResourceLocation("cookingplus:textures/blocks/oilpress.png");
			Minecraft.getMinecraft().renderEngine.bindTexture(oiltexture);
			OilPressModel.render(null, 0, 0, 0, 0, 0, 0.0625f);
		}
		

		GL11.glPopMatrix();
		
	}

}
