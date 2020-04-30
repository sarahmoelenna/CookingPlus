package CookingPlus.Renderers;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import CookingPlus.CookingPlusMain;
import CookingPlus.models.CookingPlusVat;
import CookingPlus.tiles.VatTileEntity;

public class VatRenderer extends TileEntitySpecialRenderer {
	
	ResourceLocation texture = new ResourceLocation("agriculturalrevolution:textures/blocks/vatmap.png");
	ResourceLocation fetustexture = new ResourceLocation("agriculturalrevolution:textures/blocks/fetusmap.png");
	
	private CookingPlusVat model;
	
	public VatRenderer(){
		this.model = new CookingPlusVat();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f, int dunno) {
		GL11.glPushMatrix();
		GL11.glTranslated((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		
		VatTileEntity MyOven = (VatTileEntity) entity;
		GL11.glRotatef(90, 0, 1, 0);
		if(MyOven != null){
		if(MyOven.getDirection() == 3){
			GL11.glRotatef(270, 0, 1, 0);
		}
		else if(MyOven.getDirection() == 4){
			GL11.glRotatef(0, 0, 1, 0);
		}
		else if(MyOven.getDirection() == 2){
			GL11.glRotatef(90, 0, 1, 0);
		}
		else if(MyOven.getDirection() == 5){
			GL11.glRotatef(180, 0, 1, 0);
		}
		}
		
		this.bindTexture(texture);
		
		GL11.glPushMatrix();
		this.model.RenderModel(0.0625f);
		GL11.glPopMatrix();
		if(MyOven != null){
		if(MyOven.GetAge() < 4 && MyOven.GetType() != 0){
			this.bindTexture(fetustexture);
			GL11.glPushMatrix();
			if(MyOven.GetAge() < 2){
				this.model.RenderFetusModel(0.0625f, true);
			}
			else{
				this.model.RenderFetusModel(0.0625f, false);
			}
			GL11.glPopMatrix();
		}
		}
		
		GL11.glPopMatrix();
		
		if(MyOven != null){
		if(entity.hasWorldObj()){		
		GlStateManager.enableBlend();
		if(MyOven.GetType() != 0 && MyOven.GetAge() >= 4){
			GL11.glPushMatrix();
			EntityAgeable myPig = new EntitySheep(this.getWorld());
			if(MyOven.GetType() == 1){
				myPig = new EntitySheep(this.getWorld());
			}
			else if(MyOven.GetType() == 2){
				myPig = new EntityPig(this.getWorld());
			}
			else if(MyOven.GetType() == 3){
				myPig = new EntityChicken(this.getWorld());
			}
			else if(MyOven.GetType() == 4){
				myPig = new EntityCow(this.getWorld());
			}
			else if(MyOven.GetType() == 5){
				myPig = new EntityRabbit(this.getWorld());
			}
			myPig.setGrowingAge(-8);
			float offsetX = 0.5f;
			float offsetZ = 0.5f;
			if(MyOven.getDirection() == 3){
				myPig.rotationYaw = 0 % 360.0F;
				myPig.prevRenderYawOffset = 0 % 360.0F;
				myPig.rotationYawHead = 0 % 360.0F;
				myPig.prevRotationYawHead = 0 % 360.0F;
				offsetX = 0.5f;
				offsetZ = 0.33f;
			}
			else if(MyOven.getDirection() == 4){
				myPig.rotationYaw = 90 % 360.0F;
				myPig.prevRenderYawOffset = 90 % 360.0F;
				myPig.rotationYawHead = 90 % 360.0F;
				myPig.prevRotationYawHead = 90 % 360.0F;
				offsetZ = 0.5f;
				offsetX = 0.67f;
			}
			else if(MyOven.getDirection() == 2){
				myPig.rotationYaw = 180 % 360.0F;
				myPig.prevRenderYawOffset = 180 % 360.0F;
				myPig.rotationYawHead = 180 % 360.0F;
				myPig.prevRotationYawHead = 180 % 360.0F;
				offsetX = 0.5f;
				offsetZ = 0.67f;
			}
			else if(MyOven.getDirection() == 5){
				myPig.rotationYaw = 270 % 360.0F;
				myPig.prevRenderYawOffset = 270 % 360.0F;
				myPig.rotationYawHead = 270 % 360.0F;
				myPig.prevRotationYawHead = 270 % 360.0F;
				offsetZ = 0.5f;
				offsetX = 0.33f;
			}
			
			Render myAnimalRender = Minecraft.getMinecraft().getRenderManager().getEntityRenderObject(myPig);
			myAnimalRender.doRender(myPig, x + offsetX, y + 0.5f, z + offsetZ, 0, 0);
			GL11.glPopMatrix();
		}
				IBlockState myBlock = CookingPlusMain.blockBlueCoralBlock.getDefaultState();
				 this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
				 GlStateManager.pushMatrix();
                 GlStateManager.translate((float)x, (float)y, (float)z);
                 GlStateManager.enableLighting();
                 Tessellator tessellator = Tessellator.getInstance();
                 VertexBuffer worldrenderer = tessellator.getBuffer();
                 //worldrenderer.startDrawingQuads();
                 //worldrenderer.setVertexFormat(DefaultVertexFormats.BLOCK);
                 worldrenderer.begin(7, DefaultVertexFormats.BLOCK);
                 int i = entity.getPos().getX();
                 int j = entity.getPos().getY();
                 int k = entity.getPos().getZ();
                 worldrenderer.setTranslation((double)((float)(-i)), (double)(-j) + 0.5f, (double)((float)(-k)));
                 BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
                 IBakedModel ibakedmodel = blockrendererdispatcher.getModelForState(myBlock);
                 blockrendererdispatcher.getBlockModelRenderer().renderModel(this.getWorld(), ibakedmodel, myBlock, entity.getPos(), worldrenderer, false);
                 worldrenderer.setTranslation(0.0D, 0.0D, 0.0D);
                 tessellator.draw();
                 GlStateManager.popMatrix();
         
         GlStateManager.disableBlend();
		}
		
		
	}
	}
	
	
	
}
