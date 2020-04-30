package CookingPlus.Renderers;

import net.minecraft.block.BlockBeetroot;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import CookingPlus.blocks.CookingPlusCustomCrops;
import CookingPlus.models.CookingPlusHydrophonic;
import CookingPlus.tiles.HydrophonicTileEntity;

public class HydrophonicRenderer extends TileEntitySpecialRenderer {
	
	ResourceLocation texture = new ResourceLocation("agriculturalrevolution:textures/blocks/hydrophonicmap.png");
	EntityItem entItem;
	
	private CookingPlusHydrophonic model;
	
	public HydrophonicRenderer(){
		this.model = new CookingPlusHydrophonic();
		entItem = null;
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f, int dunno) {
		
		GL11.glPushMatrix();
		if(entity != null){
		if(entity.hasWorldObj()){
			HydrophonicTileEntity MyHy = (HydrophonicTileEntity) entity;
			if(MyHy.getCurrentCrop() != null){
				IBlockState myBlock = Blocks.WHEAT.getDefaultState();
				if(MyHy.getCurrentCrop() instanceof CookingPlusCustomCrops){
				  myBlock = MyHy.getCurrentCrop().getDefaultState().withProperty(CookingPlusCustomCrops.AGE, MyHy.GetAge());
				}
				else if(MyHy.getCurrentCrop() instanceof BlockBeetroot || ((BlockCrops)MyHy.getCurrentCrop()).getMaxAge() == 3){
					int myAge = MyHy.GetAge();
					if(myAge == 0 || myAge == 1 || myAge == 2){
						myAge = 0;
					}
					else if(myAge == 3 || myAge == 4){
						myAge = 1;
					}
					else if(myAge == 5 || myAge == 6){
						myAge = 2;
					}
					else if(myAge == 7){
						myAge = 3;
					}
					myBlock = MyHy.getCurrentCrop().getDefaultState().withProperty(BlockBeetroot.BEETROOT_AGE, myAge);
				}
				else if(MyHy.getCurrentCrop() instanceof BlockCrops){
					myBlock = MyHy.getCurrentCrop().getDefaultState().withProperty(BlockCrops.AGE, MyHy.GetAge());
				}
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
                 worldrenderer.setTranslation((double)((float)(-i)), (double)(-j), (double)((float)(-k)));
                 BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
                 IBakedModel ibakedmodel = blockrendererdispatcher.getModelForState(myBlock);
                 blockrendererdispatcher.getBlockModelRenderer().renderModel(this.getWorld(), ibakedmodel, myBlock, entity.getPos(), worldrenderer, false);
                 worldrenderer.setTranslation(0.0D, 0.0D, 0.0D);
                 tessellator.draw();
                 GlStateManager.popMatrix();
			}
		}
		}
		GL11.glPopMatrix();
		
		
		
		GL11.glPushMatrix();
		GL11.glTranslated((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		
		HydrophonicTileEntity MyOven = (HydrophonicTileEntity) entity;
		GL11.glRotatef(90, 0, 1, 0);
		if(MyOven != null){
		if(MyOven.getDirection() == 3){
			GL11.glRotatef(90, 0, 1, 0);
		}
		else if(MyOven.getDirection() == 4){
			GL11.glRotatef(180, 0, 1, 0);
		}
		else if(MyOven.getDirection() == 2){ //correct
			GL11.glRotatef(270, 0, 1, 0);
		}
		else if(MyOven.getDirection() == 5){
			GL11.glRotatef(0, 0, 1, 0);
		}
		}
		
		this.bindTexture(texture);
		GL11.glPushMatrix();
		if(MyOven != null){
		this.model.RenderModel(0.0625f, MyOven.getRotation());
		}
		else{
			this.model.RenderModel(0.0625f, 0);
		}
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		

	}
	
}
