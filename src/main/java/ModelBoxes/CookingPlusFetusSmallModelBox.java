package ModelBoxes;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusFetusSmallModelBox extends ModelBox {

	private TexturedQuad[] MyquadList;
	PositionTextureVertex[] MyvertexPositions;
	
	public CookingPlusFetusSmallModelBox(ModelRenderer p_i46359_1_) {
		super(p_i46359_1_, 0, 0, 0, 0,0, 0, 0, 0, 0);
		MyquadList = new TexturedQuad[12];
		
		PositionTextureVertex positiontexturevertex0 = new PositionTextureVertex(-1.3373122f ,-2.2822237f ,-1.3373122f ,0.0421203f ,0.9710423f);
		PositionTextureVertex positiontexturevertex1 = new PositionTextureVertex(1.3373117f ,-2.2822237f ,-1.3373122f ,0.355033f ,0.9710423f);
		PositionTextureVertex positiontexturevertex2 = new PositionTextureVertex(1.3373117f ,-2.2822237f ,1.3373117f ,0.355033f ,0.381715f);
		PositionTextureVertex positiontexturevertex3 = new PositionTextureVertex(-1.3373122f ,-2.2822237f ,1.3373117f ,0.0421203f ,0.381715f);
		this.MyquadList[0] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex0 ,positiontexturevertex1 ,positiontexturevertex2 ,positiontexturevertex3});
		this.MyquadList[0].flipFace();
		PositionTextureVertex positiontexturevertex4 = new PositionTextureVertex(-1.3373122f ,-5.9294395f ,-1.3373122f ,0.0421203f ,0.9710423f);
		PositionTextureVertex positiontexturevertex5 = new PositionTextureVertex(-1.3373122f ,-5.9294395f ,1.3373117f ,0.355033f ,0.9710423f);
		PositionTextureVertex positiontexturevertex6 = new PositionTextureVertex(1.3373117f ,-5.9294395f ,1.3373117f ,0.355033f ,0.381715f);
		PositionTextureVertex positiontexturevertex7 = new PositionTextureVertex(1.3373117f ,-5.9294395f ,-1.3373122f ,0.0421203f ,0.381715f);
		this.MyquadList[1] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex4 ,positiontexturevertex5 ,positiontexturevertex6 ,positiontexturevertex7});
		this.MyquadList[1].flipFace();
		PositionTextureVertex positiontexturevertex8 = new PositionTextureVertex(-1.3373122f ,-5.9294395f ,1.3373117f ,0.425268f ,0.379583f);
		PositionTextureVertex positiontexturevertex9 = new PositionTextureVertex(-1.3373122f ,-2.2822237f ,1.3373117f ,0.425268f ,0.9631791f);
		PositionTextureVertex positiontexturevertex10 = new PositionTextureVertex(1.3373117f ,-2.2822237f ,1.3373117f ,0.745846f ,0.9631791f);
		PositionTextureVertex positiontexturevertex11 = new PositionTextureVertex(1.3373117f ,-5.9294395f ,1.3373117f ,0.745846f ,0.379583f);
		this.MyquadList[2] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex8 ,positiontexturevertex9 ,positiontexturevertex10 ,positiontexturevertex11});
		this.MyquadList[2].flipFace();
		PositionTextureVertex positiontexturevertex12 = new PositionTextureVertex(1.3373117f ,-5.9294395f ,-1.3373122f ,0.0421203f ,0.9710423f);
		PositionTextureVertex positiontexturevertex13 = new PositionTextureVertex(1.3373117f ,-2.2822237f ,-1.3373122f ,0.355033f ,0.9710423f);
		PositionTextureVertex positiontexturevertex14 = new PositionTextureVertex(-1.3373122f ,-2.2822237f ,-1.3373122f ,0.355033f ,0.381715f);
		PositionTextureVertex positiontexturevertex15 = new PositionTextureVertex(-1.3373122f ,-5.9294395f ,-1.3373122f ,0.0421203f ,0.381715f);
		this.MyquadList[3] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex12 ,positiontexturevertex13 ,positiontexturevertex14 ,positiontexturevertex15});
		this.MyquadList[3].flipFace();
		PositionTextureVertex positiontexturevertex16 = new PositionTextureVertex(-1.3373122f ,-5.9294395f ,-1.3373122f ,0.0421203f ,0.9710423f);
		PositionTextureVertex positiontexturevertex17 = new PositionTextureVertex(-1.3373122f ,-2.2822237f ,-1.3373122f ,0.355033f ,0.9710423f);
		PositionTextureVertex positiontexturevertex18 = new PositionTextureVertex(-1.3373122f ,-2.2822237f ,1.3373117f ,0.355033f ,0.381715f);
		PositionTextureVertex positiontexturevertex19 = new PositionTextureVertex(-1.3373122f ,-5.9294395f ,1.3373117f ,0.0421203f ,0.381715f);
		this.MyquadList[4] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex16 ,positiontexturevertex17 ,positiontexturevertex18 ,positiontexturevertex19});
		this.MyquadList[4].flipFace();
		PositionTextureVertex positiontexturevertex20 = new PositionTextureVertex(1.3373117f ,-5.9294395f ,1.3373117f ,0.0421203f ,0.9710423f);
		PositionTextureVertex positiontexturevertex21 = new PositionTextureVertex(1.3373117f ,-2.2822237f ,1.3373117f ,0.355033f ,0.9710423f);
		PositionTextureVertex positiontexturevertex22 = new PositionTextureVertex(1.3373117f ,-2.2822237f ,-1.3373122f ,0.355033f ,0.381715f);
		PositionTextureVertex positiontexturevertex23 = new PositionTextureVertex(1.3373117f ,-5.9294395f ,-1.3373122f ,0.0421203f ,0.381715f);
		this.MyquadList[5] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex20 ,positiontexturevertex21 ,positiontexturevertex22 ,positiontexturevertex23});
		this.MyquadList[5].flipFace();
		PositionTextureVertex positiontexturevertex24 = new PositionTextureVertex(1.0941601f ,-8.11776f ,1.0941601f ,0.0631804f ,0.33660603f);
		PositionTextureVertex positiontexturevertex25 = new PositionTextureVertex(1.0941601f ,-5.9294395f ,1.0941601f ,0.357666f ,0.33660603f);
		PositionTextureVertex positiontexturevertex26 = new PositionTextureVertex(1.0941601f ,-5.9294395f ,-1.0941601f ,0.357666f ,0.04211998f);
		PositionTextureVertex positiontexturevertex27 = new PositionTextureVertex(1.0941601f ,-8.11776f ,-1.0941601f ,0.0631804f ,0.04211998f);
		this.MyquadList[6] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex24 ,positiontexturevertex25 ,positiontexturevertex26 ,positiontexturevertex27});
		this.MyquadList[6].flipFace();
		PositionTextureVertex positiontexturevertex28 = new PositionTextureVertex(-1.0941601f ,-8.11776f ,-1.0941601f ,0.0631804f ,0.33660603f);
		PositionTextureVertex positiontexturevertex29 = new PositionTextureVertex(-1.0941601f ,-5.9294395f ,-1.0941601f ,0.357666f ,0.33660603f);
		PositionTextureVertex positiontexturevertex30 = new PositionTextureVertex(-1.0941601f ,-5.9294395f ,1.0941601f ,0.357666f ,0.04211998f);
		PositionTextureVertex positiontexturevertex31 = new PositionTextureVertex(-1.0941601f ,-8.11776f ,1.0941601f ,0.0631804f ,0.04211998f);
		this.MyquadList[7] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex28 ,positiontexturevertex29 ,positiontexturevertex30 ,positiontexturevertex31});
		this.MyquadList[7].flipFace();
		PositionTextureVertex positiontexturevertex32 = new PositionTextureVertex(1.0941601f ,-8.11776f ,-1.0941601f ,0.0654483f ,0.341008f);
		PositionTextureVertex positiontexturevertex33 = new PositionTextureVertex(1.0941601f ,-5.9294395f ,-1.0941601f ,0.359934f ,0.341008f);
		PositionTextureVertex positiontexturevertex34 = new PositionTextureVertex(-1.0941601f ,-5.9294395f ,-1.0941601f ,0.359934f ,0.04652202f);
		PositionTextureVertex positiontexturevertex35 = new PositionTextureVertex(-1.0941601f ,-8.11776f ,-1.0941601f ,0.0654483f ,0.04652202f);
		this.MyquadList[8] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex32 ,positiontexturevertex33 ,positiontexturevertex34 ,positiontexturevertex35});
		this.MyquadList[8].flipFace();
		PositionTextureVertex positiontexturevertex36 = new PositionTextureVertex(-1.0941601f ,-8.11776f ,1.0941601f ,0.421203f ,0.036854982f);
		PositionTextureVertex positiontexturevertex37 = new PositionTextureVertex(-1.0941601f ,-5.9294395f ,1.0941601f ,0.421203f ,0.33134103f);
		PositionTextureVertex positiontexturevertex38 = new PositionTextureVertex(1.0941601f ,-5.9294395f ,1.0941601f ,0.715688f ,0.33134103f);
		PositionTextureVertex positiontexturevertex39 = new PositionTextureVertex(1.0941601f ,-8.11776f ,1.0941601f ,0.715688f ,0.036854982f);
		this.MyquadList[9] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex36 ,positiontexturevertex37 ,positiontexturevertex38 ,positiontexturevertex39});
		this.MyquadList[9].flipFace();
		PositionTextureVertex positiontexturevertex40 = new PositionTextureVertex(-1.0941601f ,-8.11776f ,-1.0941601f ,0.0631804f ,0.33660603f);
		PositionTextureVertex positiontexturevertex41 = new PositionTextureVertex(-1.0941601f ,-8.11776f ,1.0941601f ,0.357666f ,0.33660603f);
		PositionTextureVertex positiontexturevertex42 = new PositionTextureVertex(1.0941601f ,-8.11776f ,1.0941601f ,0.357666f ,0.04211998f);
		PositionTextureVertex positiontexturevertex43 = new PositionTextureVertex(1.0941601f ,-8.11776f ,-1.0941601f ,0.0631804f ,0.04211998f);
		this.MyquadList[10] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex40 ,positiontexturevertex41 ,positiontexturevertex42 ,positiontexturevertex43});
		this.MyquadList[10].flipFace();
		PositionTextureVertex positiontexturevertex44 = new PositionTextureVertex(-1.0941601f ,-5.9294395f ,-1.0941601f ,0.0631804f ,0.33660603f);
		PositionTextureVertex positiontexturevertex45 = new PositionTextureVertex(1.0941601f ,-5.9294395f ,-1.0941601f ,0.357666f ,0.33660603f);
		PositionTextureVertex positiontexturevertex46 = new PositionTextureVertex(1.0941601f ,-5.9294395f ,1.0941601f ,0.357666f ,0.04211998f);
		PositionTextureVertex positiontexturevertex47 = new PositionTextureVertex(-1.0941601f ,-5.9294395f ,1.0941601f ,0.0631804f ,0.04211998f);
		this.MyquadList[11] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex44 ,positiontexturevertex45 ,positiontexturevertex46 ,positiontexturevertex47});
		this.MyquadList[11].flipFace();
		
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
