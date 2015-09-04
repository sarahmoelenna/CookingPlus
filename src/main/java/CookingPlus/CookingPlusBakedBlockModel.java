package CookingPlus;

import java.io.IOException;
import java.util.List;

import CookingPlus.blocks.CookingPlusCustomRenderedBlock;
import CookingPlus.blocks.CookingPlusCustomRopeCrop;

import com.google.common.base.Function;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.SimpleBakedModel.Builder;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.property.IExtendedBlockState;

public class CookingPlusBakedBlockModel extends CookingPlusSmartBlockModel {

	public CookingPlusBakedBlockModel(VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
		super(false, false, bakedTextureGetter.apply(CookingPlusBlockModel.TA), format, bakedTextureGetter);
		//System.out.println("BakedBlockModel");
	}

	@Override
	public IBakedModel handleBlockState(IBlockState state) {
		Builder b = new Builder(this, null);
		b.setTexture(this.getTexture());
		//System.out.println(" yolo swag");
		int ypos = 1;
        if(state instanceof IExtendedBlockState) { //add block drawing stuff here i think
            ypos = ((IExtendedBlockState)state).getValue(CookingPlusCustomRenderedBlock.JAI);
            //System.out.println(ypos);
            //BakedQuad myquad = new BakedQuad(null, ypos, null);
            
            IModel model;
			try {
				if(state.getBlock().equals(CookingPlusMain.blockGrapeCrop) || state.getBlock().equals(CookingPlusMain.blockHopCrop) || state.getBlock().equals(CookingPlusMain.blockVanillaCrop)){
					int rope = ((Integer)state.getValue(CookingPlusCustomRopeCrop.ROPETYPE)).intValue();
					
					IBakedModel bm;
					List<BakedQuad> list;
					//rope
					
					if(rope == 0){
						model = ModelLoaderRegistry.getModel(CookingPlusBlockModel.ME);
		        		bm = model.bake(model.getDefaultState(), getFormat(), textureGetter);
		        		list = bm.getGeneralQuads();
		        		for (BakedQuad bq : list) {
		        			b.addGeneralQuad(bq);
		        		}
		        		
					}
					else if(rope == 1){
						model = ModelLoaderRegistry.getModel(CookingPlusBlockModel.MB);
		        		bm = model.bake(model.getDefaultState(), getFormat(), textureGetter);
		        		list = bm.getGeneralQuads();
		        		for (BakedQuad bq : list) {
		        			b.addGeneralQuad(bq);
		        		}
		        		
					}
					else if(rope == 2){
						model = ModelLoaderRegistry.getModel(CookingPlusBlockModel.MF);
		        		bm = model.bake(model.getDefaultState(), getFormat(), textureGetter);
		        		list = bm.getGeneralQuads();
		        		for (BakedQuad bq : list) {
		        			b.addGeneralQuad(bq);
		        		}
		        		
					}
					else if(rope == 3){
						model = ModelLoaderRegistry.getModel(CookingPlusBlockModel.MG);
		        		bm = model.bake(model.getDefaultState(), getFormat(), textureGetter);
		        		list = bm.getGeneralQuads();
		        		for (BakedQuad bq : list) {
		        			b.addGeneralQuad(bq);
		        		}

					}
					
					//crop
					int age = ((Integer)state.getValue(CookingPlusCustomRopeCrop.AGE)).intValue();
					//System.out.println(age + " age");
					if(age < 1){
						model = ModelLoaderRegistry.getModel(CookingPlusBlockModel.MD);
						bm = model.bake(model.getDefaultState(), getFormat(), textureGetter);
						list = bm.getGeneralQuads();
						for (BakedQuad bq : list) {
							b.addGeneralQuad(bq);
						}
					}
					else if(age > 0 && age < 3){
						//System.out.println(age + " age");
						model = ModelLoaderRegistry.getModel(CookingPlusBlockModel.MC);
						bm = model.bake(model.getDefaultState(), getFormat(), textureGetter);
						list = bm.getGeneralQuads();
						for (BakedQuad bq : list) {
							b.addGeneralQuad(bq);
						}
					}
					else{
						if(ypos == 1){
							model = ModelLoaderRegistry.getModel(CookingPlusBlockModel.MA);
							bm = model.bake(model.getDefaultState(), getFormat(), textureGetter);
							list = bm.getGeneralQuads();
							for (BakedQuad bq : list) {
								b.addGeneralQuad(bq);
							}
						}
						else if(ypos == 2){
							model = ModelLoaderRegistry.getModel(CookingPlusBlockModel.MH);
							bm = model.bake(model.getDefaultState(), getFormat(), textureGetter);
							list = bm.getGeneralQuads();
							for (BakedQuad bq : list) {
								b.addGeneralQuad(bq);
							}
						}
						else if(ypos == 3){
							model = ModelLoaderRegistry.getModel(CookingPlusBlockModel.MI);
							bm = model.bake(model.getDefaultState(), getFormat(), textureGetter);
							list = bm.getGeneralQuads();
							for (BakedQuad bq : list) {
								b.addGeneralQuad(bq);
							}
						}
					}

				}
		        
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		
		//BakedQuad myquad = new BakedQuad(null, ypos, null);
		
		//b.addGeneralQuad(myquad);
		
		//myquad = ...;
		
		//b.addFaceQuad(EnumFacing.UP, myquad);
		
		return b.makeBakedModel();
	}
	
	 protected int[] createFaceArray(float bottomX, float bottomY, float bottomZ, float topX, float topY, float topZ, float bU, float bV, float tU, float tV){
	    	int[] faceArray = new int[28];
			return faceArray;
	 }
}