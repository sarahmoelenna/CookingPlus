package ModelBoxes;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusLaserOuterModelBox extends ModelBox {

	private TexturedQuad[] MyquadList;
	PositionTextureVertex[] MyvertexPositions;
	
	public CookingPlusLaserOuterModelBox(ModelRenderer p_i46359_1_) {
		super(p_i46359_1_, 0, 0, 0, 0,0, 0, 0, 0, 0);
		MyquadList = new TexturedQuad[4];
		
		float offsetU = 0;
		float offsetV = 0;
		
		PositionTextureVertex positiontexturevertex0 = new PositionTextureVertex(0.0f ,-6.0f ,3.6441755f ,0.892091f + offsetU,0.09380299f + offsetV);
		PositionTextureVertex positiontexturevertex1 = new PositionTextureVertex(0.0f ,10.0f ,3.6441755f ,0.892091f + offsetU,0.9004586f + offsetV);
		PositionTextureVertex positiontexturevertex2 = new PositionTextureVertex(3.6441755f ,10.0f ,0.0f ,0.657737f + offsetU,0.9004586f + offsetV);
		PositionTextureVertex positiontexturevertex3 = new PositionTextureVertex(3.6441755f ,-6.0f ,0.0f ,0.657737f + offsetU,0.09380299f + offsetV);
		this.MyquadList[0] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex0 ,positiontexturevertex1 ,positiontexturevertex2 ,positiontexturevertex3});
		this.MyquadList[0].flipFace();
		PositionTextureVertex positiontexturevertex4 = new PositionTextureVertex(0.0f ,-6.0f ,-3.6441598f ,0.657737f + offsetU,0.09380299f + offsetV);
		PositionTextureVertex positiontexturevertex5 = new PositionTextureVertex(0.0f ,10.0f ,-3.6441598f ,0.657737f + offsetU,0.9004586f + offsetV);
		PositionTextureVertex positiontexturevertex6 = new PositionTextureVertex(-3.6441598f ,10.0f ,0.0f ,0.892091f + offsetU,0.9004586f + offsetV);
		PositionTextureVertex positiontexturevertex7 = new PositionTextureVertex(-3.6441598f ,-6.0f ,0.0f ,0.892091f + offsetU,0.09380299f + offsetV);
		this.MyquadList[1] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex4 ,positiontexturevertex5 ,positiontexturevertex6 ,positiontexturevertex7});
		this.MyquadList[1].flipFace();
		PositionTextureVertex positiontexturevertex8 = new PositionTextureVertex(3.6441755f ,-6.0f ,0.0f ,0.892091f + offsetU,0.09380299f + offsetV);
		PositionTextureVertex positiontexturevertex9 = new PositionTextureVertex(3.6441755f ,10.0f ,0.0f ,0.892091f + offsetU,0.9004586f + offsetV);
		PositionTextureVertex positiontexturevertex10 = new PositionTextureVertex(0.0f ,10.0f ,-3.6441598f ,0.657737f + offsetU,0.9004586f + offsetV);
		PositionTextureVertex positiontexturevertex11 = new PositionTextureVertex(0.0f ,-6.0f ,-3.6441598f ,0.657737f + offsetU,0.09380299f + offsetV);
		this.MyquadList[2] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex8 ,positiontexturevertex9 ,positiontexturevertex10 ,positiontexturevertex11});
		this.MyquadList[2].flipFace();
		PositionTextureVertex positiontexturevertex12 = new PositionTextureVertex(-3.6441598f ,-6.0f ,0.0f ,0.657737f + offsetU,0.09380299f + offsetV);
		PositionTextureVertex positiontexturevertex13 = new PositionTextureVertex(-3.6441598f ,10.0f ,0.0f ,0.657737f + offsetU,0.9004586f + offsetV);
		PositionTextureVertex positiontexturevertex14 = new PositionTextureVertex(0.0f ,10.0f ,3.6441755f ,0.892091f + offsetU,0.9004586f + offsetV);
		PositionTextureVertex positiontexturevertex15 = new PositionTextureVertex(0.0f ,-6.0f ,3.6441755f ,0.892091f + offsetU,0.09380299f + offsetV);
		this.MyquadList[3] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex12 ,positiontexturevertex13 ,positiontexturevertex14 ,positiontexturevertex15});
		this.MyquadList[3].flipFace();
		
	}
	
	@Override
	 @SideOnly(Side.CLIENT)
	 public void render(VertexBuffer renderer, float scale)
	 {
	     for (int i = 0; i < this.MyquadList.length; ++i)
	     {
	         this.MyquadList[i].draw(renderer, scale);
	     }
	 }
}
