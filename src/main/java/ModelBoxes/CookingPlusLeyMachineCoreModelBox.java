package ModelBoxes;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusLeyMachineCoreModelBox extends ModelBox {

	private TexturedQuad[] MyquadList;
	PositionTextureVertex[] MyvertexPositions;
	
	public CookingPlusLeyMachineCoreModelBox(ModelRenderer p_i46359_1_) {
		super(p_i46359_1_, 0, 0, 0, 0,0, 0, 0, 0, 0);
		MyquadList = new TexturedQuad[6];
		int offsetU = 0;
		int offsetV = 0;
		
		PositionTextureVertex positiontexturevertex0 = new PositionTextureVertex(-2.2627358f ,4.2627354f ,-4.525488f ,0.0f + offsetU,1.0f + offsetV);
		PositionTextureVertex positiontexturevertex1 = new PositionTextureVertex(0.93724823f ,7.462736f ,0.0f ,1.0f + offsetU,1.0f + offsetV);
		PositionTextureVertex positiontexturevertex2 = new PositionTextureVertex(-2.2627358f ,4.2627354f ,4.525488f ,1.0f + offsetU,0.0f + offsetV);
		PositionTextureVertex positiontexturevertex3 = new PositionTextureVertex(-5.462736f ,1.0627518f ,0.0f ,0.0f + offsetU,0.0f + offsetV);
		this.MyquadList[0] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex0 ,positiontexturevertex1 ,positiontexturevertex2 ,positiontexturevertex3});
		this.MyquadList[0].flipFace();
		PositionTextureVertex positiontexturevertex4 = new PositionTextureVertex(2.2627363f ,-0.26273632f ,-4.525488f ,0.0f + offsetU,1.0f + offsetV);
		PositionTextureVertex positiontexturevertex5 = new PositionTextureVertex(-0.93726397f ,-3.4627523f ,0.0f ,1.0f + offsetU,1.0f + offsetV);
		PositionTextureVertex positiontexturevertex6 = new PositionTextureVertex(2.2627363f ,-0.26273632f ,4.525488f ,1.0f + offsetU,0.0f + offsetV);
		PositionTextureVertex positiontexturevertex7 = new PositionTextureVertex(5.4627523f ,2.9372635f ,0.0f ,0.0f + offsetU,0.0f + offsetV);
		this.MyquadList[1] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex4 ,positiontexturevertex5 ,positiontexturevertex6 ,positiontexturevertex7});
		this.MyquadList[1].flipFace();
		PositionTextureVertex positiontexturevertex8 = new PositionTextureVertex(-0.93726397f ,-3.4627523f ,0.0f ,0.0f + offsetU,1.0f + offsetV);
		PositionTextureVertex positiontexturevertex9 = new PositionTextureVertex(-5.462736f ,1.0627518f ,0.0f ,1.0f + offsetU,1.0f + offsetV);
		PositionTextureVertex positiontexturevertex10 = new PositionTextureVertex(-2.2627358f ,4.2627354f ,4.525488f ,1.0f + offsetU,0.0f + offsetV);
		PositionTextureVertex positiontexturevertex11 = new PositionTextureVertex(2.2627363f ,-0.26273632f ,4.525488f ,0.0f + offsetU,0.0f + offsetV);
		this.MyquadList[2] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex8 ,positiontexturevertex9 ,positiontexturevertex10 ,positiontexturevertex11});
		this.MyquadList[2].flipFace();
		PositionTextureVertex positiontexturevertex12 = new PositionTextureVertex(5.4627523f ,2.9372635f ,0.0f ,0.0f + offsetU,1.0f + offsetV);
		PositionTextureVertex positiontexturevertex13 = new PositionTextureVertex(0.93724823f ,7.462736f ,0.0f ,1.0f + offsetU,1.0f + offsetV);
		PositionTextureVertex positiontexturevertex14 = new PositionTextureVertex(-2.2627358f ,4.2627354f ,-4.525488f ,1.0f + offsetU,0.0f + offsetV);
		PositionTextureVertex positiontexturevertex15 = new PositionTextureVertex(2.2627363f ,-0.26273632f ,-4.525488f ,0.0f + offsetU,0.0f + offsetV);
		this.MyquadList[3] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex12 ,positiontexturevertex13 ,positiontexturevertex14 ,positiontexturevertex15});
		this.MyquadList[3].flipFace();
		PositionTextureVertex positiontexturevertex16 = new PositionTextureVertex(2.2627363f ,-0.26273632f ,-4.525488f ,0.0f + offsetU,1.0f + offsetV);
		PositionTextureVertex positiontexturevertex17 = new PositionTextureVertex(-2.2627358f ,4.2627354f ,-4.525488f ,1.0f + offsetU,1.0f + offsetV);
		PositionTextureVertex positiontexturevertex18 = new PositionTextureVertex(-5.462736f ,1.0627518f ,0.0f ,1.0f + offsetU,0.0f + offsetV);
		PositionTextureVertex positiontexturevertex19 = new PositionTextureVertex(-0.93726397f ,-3.4627523f ,0.0f ,0.0f + offsetU,0.0f + offsetV);
		this.MyquadList[4] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex16 ,positiontexturevertex17 ,positiontexturevertex18 ,positiontexturevertex19});
		this.MyquadList[4].flipFace();
		PositionTextureVertex positiontexturevertex20 = new PositionTextureVertex(2.2627363f ,-0.26273632f ,4.525488f ,0.0f + offsetU,1.0f + offsetV);
		PositionTextureVertex positiontexturevertex21 = new PositionTextureVertex(-2.2627358f ,4.2627354f ,4.525488f ,1.0f + offsetU,1.0f + offsetV);
		PositionTextureVertex positiontexturevertex22 = new PositionTextureVertex(0.93724823f ,7.462736f ,0.0f ,1.0f + offsetU,0.0f + offsetV);
		PositionTextureVertex positiontexturevertex23 = new PositionTextureVertex(5.4627523f ,2.9372635f ,0.0f ,0.0f + offsetU,0.0f + offsetV);
		this.MyquadList[5] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex20 ,positiontexturevertex21 ,positiontexturevertex22 ,positiontexturevertex23});
		this.MyquadList[5].flipFace();
		
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
