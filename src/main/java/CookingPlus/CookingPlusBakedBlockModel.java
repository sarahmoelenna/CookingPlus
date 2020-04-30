package CookingPlus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.property.IExtendedBlockState;
import CookingPlus.blocks.CookingPlusCustomRenderedBlock;
import CookingPlus.blocks.CookingPlusCustomRopeCrop;

import com.google.common.base.Function;

public class CookingPlusBakedBlockModel extends CookingPlusSmartBlockModel {

	public CookingPlusBakedBlockModel(VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
		super(false, false, bakedTextureGetter.apply(CookingPlusBlockModel.TA), format, bakedTextureGetter);
		//System.out.println("BakedBlockModel");
	} 

	@Override
	public TextureAtlasSprite getParticleTexture() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) 
	{

		List<BakedQuad> myQuadList = new ArrayList<BakedQuad>();
		//Builder b = new Builder(this, null);
		//b.setTexture(this.getTexture());
		int ypos = 1;
        if(state instanceof IExtendedBlockState) 
        { //add block drawing stuff here i think
            ypos = ((IExtendedBlockState)state).getValue(CookingPlusCustomRenderedBlock.JAI);
            //BakedQuad myquad = new BakedQuad(null, ypos, null);
            
            IModel model;
			try {
				if(state.getBlock().equals(CookingPlusMain.blockGrapeCrop) || state.getBlock().equals(CookingPlusMain.blockHopCrop) || state.getBlock().equals(CookingPlusMain.blockVanillaCrop))
				{
					int rope = ((Integer)state.getValue(CookingPlusCustomRopeCrop.ROPETYPE)).intValue();
					IBakedModel bm;
					List<BakedQuad> list;
					//rope
					
					if(rope == 0){
						model = ModelLoaderRegistry.getModel(CookingPlusBlockModel.ME);
		        		bm = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, textureGetter);
		        		list = bm.getQuads(CookingPlusMain.blockRope.getDefaultState().withProperty(CookingPlusCustomRopeCrop.ROPETYPE, 0), side, rand);
		        		for (BakedQuad bq : list) {
		        			myQuadList.add(bq);
		        		}
		        		
					}
					else if(rope == 1){
						model = ModelLoaderRegistry.getModel(CookingPlusBlockModel.MB);
		        		bm = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, textureGetter);
		        		list = bm.getQuads(CookingPlusMain.blockRope.getDefaultState().withProperty(CookingPlusCustomRopeCrop.ROPETYPE, 1), side, rand);
		        		for (BakedQuad bq : list) {
		        			myQuadList.add(bq);
		        		}
		        		
					}
					else if(rope == 2){
						model = ModelLoaderRegistry.getModel(CookingPlusBlockModel.MF);
		        		bm = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, textureGetter);
		        		list = bm.getQuads(CookingPlusMain.blockRope.getDefaultState().withProperty(CookingPlusCustomRopeCrop.ROPETYPE, 2), side, rand);
		        		for (BakedQuad bq : list) {
		        			myQuadList.add(bq);
		        		}
		        		
					}
					else if(rope == 3){
						model = ModelLoaderRegistry.getModel(CookingPlusBlockModel.MG);
		        		bm = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, textureGetter);
		        		list = bm.getQuads(CookingPlusMain.blockRope.getDefaultState().withProperty(CookingPlusCustomRopeCrop.ROPETYPE, 3), side, rand);
		        		for (BakedQuad bq : list) {
		        			myQuadList.add(bq);
		        		}

					}
					
					//crop
					int age = ((Integer)state.getValue(CookingPlusCustomRopeCrop.AGE)).intValue();
					//System.out.println(age + " age");
					if(age < 1){
						model = ModelLoaderRegistry.getModel(CookingPlusBlockModel.MD);
						bm = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, textureGetter);
						list = bm.getQuads(CookingPlusMain.blockVanillaCrop.getDefaultState().withProperty(CookingPlusCustomRopeCrop.AGE, 0), side, rand);
						for (BakedQuad bq : list) {
		        			myQuadList.add(bq);
		        		}
					}
					else if(age > 0 && age < 3){
						//System.out.println(age + " age");
						model = ModelLoaderRegistry.getModel(CookingPlusBlockModel.MC);
						bm = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, textureGetter);
						list = bm.getQuads(CookingPlusMain.blockVanillaCrop.getDefaultState().withProperty(CookingPlusCustomRopeCrop.AGE, 2), side, rand);
						for (BakedQuad bq : list) {
		        			myQuadList.add(bq);
		        		}
					}
					else{
						if(ypos == 1){
							model = ModelLoaderRegistry.getModel(CookingPlusBlockModel.MA);
							bm = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, textureGetter);
							list = bm.getQuads(CookingPlusMain.blockGrapeCrop.getDefaultState().withProperty(CookingPlusCustomRopeCrop.AGE, 3), side, rand);
							for (BakedQuad bq : list) {
			        			myQuadList.add(bq);
			        		}
						}
						else if(ypos == 2){
							model = ModelLoaderRegistry.getModel(CookingPlusBlockModel.MH);
							bm = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, textureGetter);
							list = bm.getQuads(CookingPlusMain.blockHopCrop.getDefaultState().withProperty(CookingPlusCustomRopeCrop.AGE, 3), side, rand);
							for (BakedQuad bq : list) {
			        			myQuadList.add(bq);
			        		}
						}
						else if(ypos == 3){
							model = ModelLoaderRegistry.getModel(CookingPlusBlockModel.MI);
							bm = model.bake(model.getDefaultState(), DefaultVertexFormats.BLOCK, textureGetter);
							list = bm.getQuads(CookingPlusMain.blockVanillaCrop.getDefaultState().withProperty(CookingPlusCustomRopeCrop.AGE, 3), side, rand);
							for (BakedQuad bq : list) {
			        			myQuadList.add(bq);
			        		}
						}
					}

				}
		        
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }
		return myQuadList;
		
	}
        

	@Override
	public ItemOverrideList getOverrides() {
		// TODO Auto-generated method stub
		return null;
	}
}