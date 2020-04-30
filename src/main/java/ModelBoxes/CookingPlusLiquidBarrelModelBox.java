package ModelBoxes;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusLiquidBarrelModelBox extends ModelBox {

	private TexturedQuad[] MyquadList;
	
	public CookingPlusLiquidBarrelModelBox(ModelRenderer p_i46359_1_) {
		super(p_i46359_1_, 0, 0, 0, 0,0, 0, 0, 0, 0);
		MyquadList = new TexturedQuad[14];
		
		PositionTextureVertex positiontexturevertex0 = new PositionTextureVertex(8.0016f ,10.0016f ,-7.998397f ,0.9999f ,1.0f);
		PositionTextureVertex positiontexturevertex1 = new PositionTextureVertex(8.0016f ,10.0016f ,8.0016f ,0.0f ,1.0f);
		PositionTextureVertex positiontexturevertex2 = new PositionTextureVertex(8.003201f ,-6.0f ,8.0f ,1.00007E-4f ,0.0f);
		PositionTextureVertex positiontexturevertex3 = new PositionTextureVertex(8.003201f ,-5.999998f ,-8.0f ,1.0f ,0.0f);
		this.MyquadList[0] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex0 ,positiontexturevertex1 ,positiontexturevertex2 ,positiontexturevertex3});
		PositionTextureVertex positiontexturevertex4 = new PositionTextureVertex(6.3999996f ,8.4032f ,6.4032f ,0.09989f ,0.90011f);
		PositionTextureVertex positiontexturevertex5 = new PositionTextureVertex(6.3999996f ,8.4032f ,-6.3968f ,0.89981f ,0.90011f);
		PositionTextureVertex positiontexturevertex6 = new PositionTextureVertex(6.4016f ,-5.998396f ,-6.3984f ,0.89991f ,1.00016594E-4f);
		PositionTextureVertex positiontexturevertex7 = new PositionTextureVertex(6.4016f ,-5.998398f ,6.4016f ,0.09999f ,1.00016594E-4f);
		this.MyquadList[1] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex4 ,positiontexturevertex5 ,positiontexturevertex6 ,positiontexturevertex7});
		PositionTextureVertex positiontexturevertex8 = new PositionTextureVertex(-7.998396f ,10.0016f ,8.0016f ,0.0f ,1.0f);
		PositionTextureVertex positiontexturevertex9 = new PositionTextureVertex(-7.998396f ,10.0016f ,-7.998397f ,0.9999f ,1.0f);
		PositionTextureVertex positiontexturevertex10 = new PositionTextureVertex(-7.9967976f ,-5.999998f ,-8.0f ,1.0f ,0.0f);
		PositionTextureVertex positiontexturevertex11 = new PositionTextureVertex(-7.9967976f ,-6.0f ,8.0f ,1.00007E-4f ,0.0f);
		this.MyquadList[2] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex8 ,positiontexturevertex9 ,positiontexturevertex10 ,positiontexturevertex11});
		PositionTextureVertex positiontexturevertex12 = new PositionTextureVertex(-6.4f ,8.4032f ,-6.3968f ,0.89981f ,0.90011f);
		PositionTextureVertex positiontexturevertex13 = new PositionTextureVertex(-6.4f ,8.4032f ,6.4032f ,0.09989f ,0.90011f);
		PositionTextureVertex positiontexturevertex14 = new PositionTextureVertex(-6.3984f ,-5.998398f ,6.4016f ,0.09999f ,1.00016594E-4f);
		PositionTextureVertex positiontexturevertex15 = new PositionTextureVertex(-6.3984f ,-5.998396f ,-6.3984f ,0.89991f ,1.00016594E-4f);
		this.MyquadList[3] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex12 ,positiontexturevertex13 ,positiontexturevertex14 ,positiontexturevertex15});
		PositionTextureVertex positiontexturevertex16 = new PositionTextureVertex(8.0016f ,10.0016f ,8.0016f ,0.9999f ,1.0f);
		PositionTextureVertex positiontexturevertex17 = new PositionTextureVertex(-7.998397f ,10.0016f ,8.0016f ,0.0f ,1.0f);
		PositionTextureVertex positiontexturevertex18 = new PositionTextureVertex(-7.9967966f ,-6.0f ,8.0f ,1.00007E-4f ,0.0f);
		PositionTextureVertex positiontexturevertex19 = new PositionTextureVertex(8.003201f ,-6.0f ,8.0f ,1.0f ,0.0f);
		this.MyquadList[4] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex16 ,positiontexturevertex17 ,positiontexturevertex18 ,positiontexturevertex19});
		PositionTextureVertex positiontexturevertex20 = new PositionTextureVertex(-6.4f ,8.4032f ,6.4032f ,0.0998898f ,0.90011f);
		PositionTextureVertex positiontexturevertex21 = new PositionTextureVertex(6.3999996f ,8.4032f ,6.4032f ,0.89981f ,0.90011f);
		PositionTextureVertex positiontexturevertex22 = new PositionTextureVertex(6.4016f ,-5.998398f ,6.4016f ,0.89991f ,1.00016594E-4f);
		PositionTextureVertex positiontexturevertex23 = new PositionTextureVertex(-6.3984f ,-5.998398f ,6.4016f ,0.0999898f ,1.00016594E-4f);
		this.MyquadList[5] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex20 ,positiontexturevertex21 ,positiontexturevertex22 ,positiontexturevertex23});
		PositionTextureVertex positiontexturevertex24 = new PositionTextureVertex(-7.998397f ,10.0016f ,-7.998397f ,0.0f ,1.0f);
		PositionTextureVertex positiontexturevertex25 = new PositionTextureVertex(8.0016f ,10.0016f ,-7.998397f ,0.9999f ,1.0f);
		PositionTextureVertex positiontexturevertex26 = new PositionTextureVertex(8.003201f ,-5.999998f ,-8.0f ,1.0f ,0.0f);
		PositionTextureVertex positiontexturevertex27 = new PositionTextureVertex(-7.9967966f ,-5.999998f ,-8.0f ,1.00007E-4f ,0.0f);
		this.MyquadList[6] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex24 ,positiontexturevertex25 ,positiontexturevertex26 ,positiontexturevertex27});
		PositionTextureVertex positiontexturevertex28 = new PositionTextureVertex(6.3999996f ,8.4032f ,-6.3968f ,0.89981f ,0.90011f);
		PositionTextureVertex positiontexturevertex29 = new PositionTextureVertex(-6.4f ,8.4032f ,-6.3968f ,0.0998898f ,0.90011f);
		PositionTextureVertex positiontexturevertex30 = new PositionTextureVertex(-6.3984f ,-5.998396f ,-6.3984f ,0.0999898f ,1.00016594E-4f);
		PositionTextureVertex positiontexturevertex31 = new PositionTextureVertex(6.4016f ,-5.998396f ,-6.3984f ,0.89991f ,1.00016594E-4f);
		this.MyquadList[7] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex28 ,positiontexturevertex29 ,positiontexturevertex30 ,positiontexturevertex31});
		PositionTextureVertex positiontexturevertex32 = new PositionTextureVertex(6.4016f ,-5.998398f ,6.4016f ,0.89992f ,0.10008001f);
		PositionTextureVertex positiontexturevertex33 = new PositionTextureVertex(6.4016f ,-5.998396f ,-6.3984f ,0.89992f ,0.89992f);
		PositionTextureVertex positiontexturevertex34 = new PositionTextureVertex(8.003201f ,-5.999996f ,-8.0f ,1.0f ,1.0f);
		PositionTextureVertex positiontexturevertex35 = new PositionTextureVertex(8.003201f ,-5.999998f ,8.0f ,1.0f ,1.9997358E-4f);
		this.MyquadList[8] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex32 ,positiontexturevertex33 ,positiontexturevertex34 ,positiontexturevertex35});
		PositionTextureVertex positiontexturevertex36 = new PositionTextureVertex(-6.3984f ,-5.998396f ,-6.3984f ,0.10008f ,0.89992f);
		PositionTextureVertex positiontexturevertex37 = new PositionTextureVertex(-6.3984f ,-5.998398f ,6.4016f ,0.10008f ,0.10008001f);
		PositionTextureVertex positiontexturevertex38 = new PositionTextureVertex(-7.9967966f ,-5.999998f ,8.0f ,2.00142E-4f ,1.9997358E-4f);
		PositionTextureVertex positiontexturevertex39 = new PositionTextureVertex(-7.9967966f ,-5.999996f ,-8.0f ,2.00142E-4f ,1.0f);
		this.MyquadList[9] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex36 ,positiontexturevertex37 ,positiontexturevertex38 ,positiontexturevertex39});
		PositionTextureVertex positiontexturevertex40 = new PositionTextureVertex(-6.3984f ,-5.998398f ,6.4016f ,0.10008f ,0.10008001f);
		PositionTextureVertex positiontexturevertex41 = new PositionTextureVertex(6.4016f ,-5.998398f ,6.4016f ,0.89992f ,0.10008001f);
		PositionTextureVertex positiontexturevertex42 = new PositionTextureVertex(8.003201f ,-5.999998f ,8.0f ,1.0f ,1.9997358E-4f);
		PositionTextureVertex positiontexturevertex43 = new PositionTextureVertex(-7.9967966f ,-5.999998f ,8.0f ,2.00142E-4f ,1.9997358E-4f);
		this.MyquadList[10] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex40 ,positiontexturevertex41 ,positiontexturevertex42 ,positiontexturevertex43});
		PositionTextureVertex positiontexturevertex44 = new PositionTextureVertex(6.4016f ,-5.998396f ,-6.3984f ,0.89992f ,0.89992f);
		PositionTextureVertex positiontexturevertex45 = new PositionTextureVertex(-6.3984f ,-5.998396f ,-6.3984f ,0.10008f ,0.89992f);
		PositionTextureVertex positiontexturevertex46 = new PositionTextureVertex(-7.9967966f ,-5.999996f ,-8.0f ,2.00142E-4f ,1.0f);
		PositionTextureVertex positiontexturevertex47 = new PositionTextureVertex(8.003201f ,-5.999996f ,-8.0f ,1.0f ,1.0f);
		this.MyquadList[11] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex44 ,positiontexturevertex45 ,positiontexturevertex46 ,positiontexturevertex47});
		PositionTextureVertex positiontexturevertex48 = new PositionTextureVertex(-6.4f ,8.4032f ,6.4032f ,0.09998f ,0.09998f);
		PositionTextureVertex positiontexturevertex49 = new PositionTextureVertex(-6.4f ,8.4032f ,-6.3968f ,0.09998f ,0.89981997f);
		PositionTextureVertex positiontexturevertex50 = new PositionTextureVertex(6.3999996f ,8.4032f ,-6.3968f ,0.89982f ,0.89981997f);
		PositionTextureVertex positiontexturevertex51 = new PositionTextureVertex(6.3999996f ,8.4032f ,6.4032f ,0.89982f ,0.09998f);
		this.MyquadList[12] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex48 ,positiontexturevertex49 ,positiontexturevertex50 ,positiontexturevertex51});
		PositionTextureVertex positiontexturevertex52 = new PositionTextureVertex(-8.0f ,10.003201f ,8.003201f ,0.0f ,0.0f);
		PositionTextureVertex positiontexturevertex53 = new PositionTextureVertex(8.0f ,10.003201f ,8.003201f ,0.9998f ,0.0f);
		PositionTextureVertex positiontexturevertex54 = new PositionTextureVertex(8.0f ,10.003201f ,-7.9967976f ,0.9998f ,0.9998f);
		PositionTextureVertex positiontexturevertex55 = new PositionTextureVertex(-8.0f ,10.003201f ,-7.9967976f ,0.0f ,0.9998f);
		this.MyquadList[13] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex52 ,positiontexturevertex53 ,positiontexturevertex54 ,positiontexturevertex55});
		
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
