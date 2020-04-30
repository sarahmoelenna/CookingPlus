package ModelBoxes;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusCubeModelBox extends ModelBox {

	private TexturedQuad[] MyquadList;
	PositionTextureVertex[] MyvertexPositions;
	
	public CookingPlusCubeModelBox(ModelRenderer p_i46359_1_) {
		super(p_i46359_1_, 0, 0, 0, 0,0, 0, 0, 0, 0);
		MyquadList = new TexturedQuad[6];
		
		PositionTextureVertex positiontexturevertex0 = new PositionTextureVertex(8.0f ,10.0f ,8.0f ,0.0f ,1.0f);
		PositionTextureVertex positiontexturevertex1 = new PositionTextureVertex(8.0f ,-6.0f ,8.0f ,1.0f ,1.0f);
		PositionTextureVertex positiontexturevertex2 = new PositionTextureVertex(8.0f ,-6.0f ,-7.999999f ,1.0f ,0.0f);
		PositionTextureVertex positiontexturevertex3 = new PositionTextureVertex(8.0f ,10.0f ,-7.999999f ,0.0f ,0.0f);
		this.MyquadList[0] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex0 ,positiontexturevertex1 ,positiontexturevertex2 ,positiontexturevertex3});
		PositionTextureVertex positiontexturevertex4 = new PositionTextureVertex(-7.9999995f ,10.0f ,-7.999999f ,0.0f ,1.0f);
		PositionTextureVertex positiontexturevertex5 = new PositionTextureVertex(-7.9999995f ,-6.0f ,-7.999999f ,1.0f ,1.0f);
		PositionTextureVertex positiontexturevertex6 = new PositionTextureVertex(-7.9999995f ,-6.0f ,8.0f ,1.0f ,0.0f);
		PositionTextureVertex positiontexturevertex7 = new PositionTextureVertex(-7.9999995f ,10.0f ,8.0f ,0.0f ,0.0f);
		this.MyquadList[1] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex4 ,positiontexturevertex5 ,positiontexturevertex6 ,positiontexturevertex7});
		PositionTextureVertex positiontexturevertex8 = new PositionTextureVertex(8.0f ,10.0f ,-7.999999f ,0.0f ,1.0f);
		PositionTextureVertex positiontexturevertex9 = new PositionTextureVertex(8.0f ,-6.0f ,-7.999999f ,1.0f ,1.0f);
		PositionTextureVertex positiontexturevertex10 = new PositionTextureVertex(-7.9999995f ,-6.0f ,-7.999999f ,1.0f ,0.0f);
		PositionTextureVertex positiontexturevertex11 = new PositionTextureVertex(-7.9999995f ,10.0f ,-7.999999f ,0.0f ,0.0f);
		this.MyquadList[2] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex8 ,positiontexturevertex9 ,positiontexturevertex10 ,positiontexturevertex11});
		PositionTextureVertex positiontexturevertex12 = new PositionTextureVertex(-7.9999995f ,10.0f ,8.0f ,0.0f ,1.0f);
		PositionTextureVertex positiontexturevertex13 = new PositionTextureVertex(-7.9999995f ,-6.0f ,8.0f ,1.0f ,1.0f);
		PositionTextureVertex positiontexturevertex14 = new PositionTextureVertex(8.0f ,-6.0f ,8.0f ,1.0f ,0.0f);
		PositionTextureVertex positiontexturevertex15 = new PositionTextureVertex(8.0f ,10.0f ,8.0f ,0.0f ,0.0f);
		this.MyquadList[3] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex12 ,positiontexturevertex13 ,positiontexturevertex14 ,positiontexturevertex15});
		PositionTextureVertex positiontexturevertex16 = new PositionTextureVertex(-7.9999995f ,10.0f ,-7.999999f ,0.0f ,1.0f);
		PositionTextureVertex positiontexturevertex17 = new PositionTextureVertex(-7.9999995f ,10.0f ,8.0f ,1.0f ,1.0f);
		PositionTextureVertex positiontexturevertex18 = new PositionTextureVertex(8.0f ,10.0f ,8.0f ,1.0f ,0.0f);
		PositionTextureVertex positiontexturevertex19 = new PositionTextureVertex(8.0f ,10.0f ,-7.999999f ,0.0f ,0.0f);
		this.MyquadList[4] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex16 ,positiontexturevertex17 ,positiontexturevertex18 ,positiontexturevertex19});
		PositionTextureVertex positiontexturevertex20 = new PositionTextureVertex(-7.9999995f ,-6.0f ,-7.999999f ,0.0f ,1.0f);
		PositionTextureVertex positiontexturevertex21 = new PositionTextureVertex(8.0f ,-6.0f ,-7.999999f ,1.0f ,1.0f);
		PositionTextureVertex positiontexturevertex22 = new PositionTextureVertex(8.0f ,-6.0f ,8.0f ,1.0f ,0.0f);
		PositionTextureVertex positiontexturevertex23 = new PositionTextureVertex(-7.9999995f ,-6.0f ,8.0f ,0.0f ,0.0f);
		this.MyquadList[5] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex20 ,positiontexturevertex21 ,positiontexturevertex22 ,positiontexturevertex23});

		
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
