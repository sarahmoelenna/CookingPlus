package ModelBoxes;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusInscriberToolModelBox extends ModelBox {

	private TexturedQuad[] MyquadList;
	PositionTextureVertex[] MyvertexPositions;
	
	public CookingPlusInscriberToolModelBox(ModelRenderer p_i46359_1_) {
		super(p_i46359_1_, 0, 0, 0, 0,0, 0, 0, 0, 0);
		MyquadList = new TexturedQuad[26];
		
		int offsetU = 0;
		int offsetV = 0;
		
		PositionTextureVertex positiontexturevertex0 = new PositionTextureVertex(-4.8f ,2.0f ,-3.1999998f ,0.186481f + offsetU,0.343013f + offsetV);
		PositionTextureVertex positiontexturevertex1 = new PositionTextureVertex(-1.5999999f ,2.0f ,-3.1999998f ,0.337275f + offsetU,0.343013f + offsetV);
		PositionTextureVertex positiontexturevertex2 = new PositionTextureVertex(-1.5999999f ,2.0f ,0.0f ,0.337275f + offsetU,0.19221902f + offsetV);
		PositionTextureVertex positiontexturevertex3 = new PositionTextureVertex(-4.8f ,2.0f ,0.0f ,0.186481f + offsetU,0.19221902f + offsetV);
		this.MyquadList[0] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex0 ,positiontexturevertex1 ,positiontexturevertex2 ,positiontexturevertex3});
		this.MyquadList[0].flipFace();
		PositionTextureVertex positiontexturevertex4 = new PositionTextureVertex(-4.8f ,-1.1999998f ,-3.1999998f ,0.186481f + offsetU,0.343013f + offsetV);
		PositionTextureVertex positiontexturevertex5 = new PositionTextureVertex(-4.8f ,-1.1999998f ,0.0f ,0.337275f + offsetU,0.343013f + offsetV);
		PositionTextureVertex positiontexturevertex6 = new PositionTextureVertex(-1.5999999f ,-1.1999998f ,0.0f ,0.337275f + offsetU,0.19221902f + offsetV);
		PositionTextureVertex positiontexturevertex7 = new PositionTextureVertex(-1.5999999f ,-1.1999998f ,-3.1999998f ,0.186481f + offsetU,0.19221902f + offsetV);
		this.MyquadList[1] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex4 ,positiontexturevertex5 ,positiontexturevertex6 ,positiontexturevertex7});
		this.MyquadList[1].flipFace();
		PositionTextureVertex positiontexturevertex8 = new PositionTextureVertex(-4.8f ,-1.1999998f ,0.0f ,0.186481f + offsetU,0.343013f + offsetV);
		PositionTextureVertex positiontexturevertex9 = new PositionTextureVertex(-4.8f ,2.0f ,0.0f ,0.337275f + offsetU,0.343013f + offsetV);
		PositionTextureVertex positiontexturevertex10 = new PositionTextureVertex(-1.5999999f ,2.0f ,0.0f ,0.337275f + offsetU,0.19221902f + offsetV);
		PositionTextureVertex positiontexturevertex11 = new PositionTextureVertex(-1.5999999f ,-1.1999998f ,0.0f ,0.186481f + offsetU,0.19221902f + offsetV);
		this.MyquadList[2] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex8 ,positiontexturevertex9 ,positiontexturevertex10 ,positiontexturevertex11});
		this.MyquadList[2].flipFace();
		PositionTextureVertex positiontexturevertex12 = new PositionTextureVertex(-1.5999999f ,-1.1999998f ,-3.1999998f ,0.186481f + offsetU,0.343013f + offsetV);
		PositionTextureVertex positiontexturevertex13 = new PositionTextureVertex(-1.5999999f ,2.0f ,-3.1999998f ,0.337275f + offsetU,0.343013f + offsetV);
		PositionTextureVertex positiontexturevertex14 = new PositionTextureVertex(-4.8f ,2.0f ,-3.1999998f ,0.337275f + offsetU,0.19221902f + offsetV);
		PositionTextureVertex positiontexturevertex15 = new PositionTextureVertex(-4.8f ,-1.1999998f ,-3.1999998f ,0.186481f + offsetU,0.19221902f + offsetV);
		this.MyquadList[3] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex12 ,positiontexturevertex13 ,positiontexturevertex14 ,positiontexturevertex15});
		this.MyquadList[3].flipFace();
		PositionTextureVertex positiontexturevertex16 = new PositionTextureVertex(-4.8f ,-1.1999998f ,-3.1999998f ,0.186481f + offsetU,0.343013f + offsetV);
		PositionTextureVertex positiontexturevertex17 = new PositionTextureVertex(-4.8f ,2.0f ,-3.1999998f ,0.337275f + offsetU,0.343013f + offsetV);
		PositionTextureVertex positiontexturevertex18 = new PositionTextureVertex(-4.8f ,2.0f ,0.0f ,0.337275f + offsetU,0.19221902f + offsetV);
		PositionTextureVertex positiontexturevertex19 = new PositionTextureVertex(-4.8f ,-1.1999998f ,0.0f ,0.186481f + offsetU,0.19221902f + offsetV);
		this.MyquadList[4] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex16 ,positiontexturevertex17 ,positiontexturevertex18 ,positiontexturevertex19});
		this.MyquadList[4].flipFace();
		PositionTextureVertex positiontexturevertex20 = new PositionTextureVertex(-1.5999999f ,-1.1999998f ,0.0f ,0.186481f + offsetU,0.343013f + offsetV);
		PositionTextureVertex positiontexturevertex21 = new PositionTextureVertex(-1.5999999f ,2.0f ,0.0f ,0.337275f + offsetU,0.343013f + offsetV);
		PositionTextureVertex positiontexturevertex22 = new PositionTextureVertex(-1.5999999f ,2.0f ,-3.1999998f ,0.337275f + offsetU,0.19221902f + offsetV);
		PositionTextureVertex positiontexturevertex23 = new PositionTextureVertex(-1.5999999f ,-1.1999998f ,-3.1999998f ,0.186481f + offsetU,0.19221902f + offsetV);
		this.MyquadList[5] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex20 ,positiontexturevertex21 ,positiontexturevertex22 ,positiontexturevertex23});
		this.MyquadList[5].flipFace();
		PositionTextureVertex positiontexturevertex24 = new PositionTextureVertex(-2.6343842f ,1.5994396f ,-1.0343838f ,0.608956f + offsetU,0.037590027f + offsetV);
		PositionTextureVertex positiontexturevertex25 = new PositionTextureVertex(-2.6343842f ,4.2659683f ,-1.0343838f ,0.608956f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex26 = new PositionTextureVertex(-2.4001122f ,4.2659683f ,-1.5999999f ,0.744781f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex27 = new PositionTextureVertex(-2.4001122f ,1.5994396f ,-1.5999999f ,0.744781f + offsetU,0.037590027f + offsetV);
		this.MyquadList[6] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex24 ,positiontexturevertex25 ,positiontexturevertex26 ,positiontexturevertex27});
		this.MyquadList[6].flipFace();
		PositionTextureVertex positiontexturevertex28 = new PositionTextureVertex(-2.4001122f ,1.5994396f ,-1.5999999f ,0.744781f + offsetU,0.037590027f + offsetV);
		PositionTextureVertex positiontexturevertex29 = new PositionTextureVertex(-2.4001122f ,4.2659683f ,-1.5999999f ,0.744781f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex30 = new PositionTextureVertex(-2.6343842f ,4.2659683f ,-2.165616f ,0.880607f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex31 = new PositionTextureVertex(-2.6343842f ,1.5994396f ,-2.165616f ,0.880607f + offsetU,0.037590027f + offsetV);
		this.MyquadList[7] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex28 ,positiontexturevertex29 ,positiontexturevertex30 ,positiontexturevertex31});
		this.MyquadList[7].flipFace();
		PositionTextureVertex positiontexturevertex32 = new PositionTextureVertex(-2.6343842f ,1.5994396f ,-2.165616f ,0.608956f + offsetU,0.037590027f + offsetV);
		PositionTextureVertex positiontexturevertex33 = new PositionTextureVertex(-2.6343842f ,4.2659683f ,-2.165616f ,0.608956f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex34 = new PositionTextureVertex(-3.1999998f ,4.2659683f ,-2.399888f ,0.744781f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex35 = new PositionTextureVertex(-3.1999998f ,1.5994396f ,-2.399888f ,0.744781f + offsetU,0.037590027f + offsetV);
		this.MyquadList[8] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex32 ,positiontexturevertex33 ,positiontexturevertex34 ,positiontexturevertex35});
		this.MyquadList[8].flipFace();
		PositionTextureVertex positiontexturevertex36 = new PositionTextureVertex(-3.1999998f ,1.5994396f ,-2.399888f ,0.744781f + offsetU,0.037590027f + offsetV);
		PositionTextureVertex positiontexturevertex37 = new PositionTextureVertex(-3.1999998f ,4.2659683f ,-2.399888f ,0.744781f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex38 = new PositionTextureVertex(-3.765616f ,4.2659683f ,-2.165616f ,0.880607f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex39 = new PositionTextureVertex(-3.765616f ,1.5994396f ,-2.165616f ,0.880607f + offsetU,0.037590027f + offsetV);
		this.MyquadList[9] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex36 ,positiontexturevertex37 ,positiontexturevertex38 ,positiontexturevertex39});
		this.MyquadList[9].flipFace();
		PositionTextureVertex positiontexturevertex40 = new PositionTextureVertex(-3.765616f ,1.5994396f ,-2.165616f ,0.608956f + offsetU,0.037590027f + offsetV);
		PositionTextureVertex positiontexturevertex41 = new PositionTextureVertex(-3.765616f ,4.2659683f ,-2.165616f ,0.608956f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex42 = new PositionTextureVertex(-3.999888f ,4.2659683f ,-1.5999999f ,0.744781f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex43 = new PositionTextureVertex(-3.999888f ,1.5994396f ,-1.5999999f ,0.744781f + offsetU,0.037590027f + offsetV);
		this.MyquadList[10] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex40 ,positiontexturevertex41 ,positiontexturevertex42 ,positiontexturevertex43});
		this.MyquadList[10].flipFace();
		PositionTextureVertex positiontexturevertex44 = new PositionTextureVertex(-3.999888f ,1.5994396f ,-1.5999999f ,0.744781f + offsetU,0.037590027f + offsetV);
		PositionTextureVertex positiontexturevertex45 = new PositionTextureVertex(-3.999888f ,4.2659683f ,-1.5999999f ,0.744781f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex46 = new PositionTextureVertex(-3.765616f ,4.2659683f ,-1.0343838f ,0.880607f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex47 = new PositionTextureVertex(-3.765616f ,1.5994396f ,-1.0343838f ,0.880607f + offsetU,0.037590027f + offsetV);
		this.MyquadList[11] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex44 ,positiontexturevertex45 ,positiontexturevertex46 ,positiontexturevertex47});
		this.MyquadList[11].flipFace();
		PositionTextureVertex positiontexturevertex48 = new PositionTextureVertex(-3.765616f ,1.5994396f ,-1.0343838f ,0.608956f + offsetU,0.037590027f + offsetV);
		PositionTextureVertex positiontexturevertex49 = new PositionTextureVertex(-3.765616f ,4.2659683f ,-1.0343838f ,0.608956f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex50 = new PositionTextureVertex(-3.1999998f ,4.2659683f ,-0.8001118f ,0.744781f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex51 = new PositionTextureVertex(-3.1999998f ,1.5994396f ,-0.8001118f ,0.744781f + offsetU,0.037590027f + offsetV);
		this.MyquadList[12] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex48 ,positiontexturevertex49 ,positiontexturevertex50 ,positiontexturevertex51});
		this.MyquadList[12].flipFace();
		PositionTextureVertex positiontexturevertex52 = new PositionTextureVertex(-3.1999998f ,1.5994396f ,-0.8001118f ,0.744781f + offsetU,0.037590027f + offsetV);
		PositionTextureVertex positiontexturevertex53 = new PositionTextureVertex(-3.1999998f ,4.2659683f ,-0.8001118f ,0.744781f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex54 = new PositionTextureVertex(-2.6343842f ,4.2659683f ,-1.0343838f ,0.880607f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex55 = new PositionTextureVertex(-2.6343842f ,1.5994396f ,-1.0343838f ,0.880607f + offsetU,0.037590027f + offsetV);
		this.MyquadList[13] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex52 ,positiontexturevertex53 ,positiontexturevertex54 ,positiontexturevertex55});
		this.MyquadList[13].flipFace();
		PositionTextureVertex positiontexturevertex56 = new PositionTextureVertex(-2.4001122f ,4.2659683f ,-1.5999999f ,0.744781f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex57 = new PositionTextureVertex(-2.6343842f ,4.2659683f ,-1.0343838f ,0.608956f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex58 = new PositionTextureVertex(-3.03016f ,5.59896f ,-1.43016f ,0.703995f + offsetU,0.421763f + offsetV);
		PositionTextureVertex positiontexturevertex59 = new PositionTextureVertex(-2.9598718f ,5.59896f ,-1.5998402f ,0.744743f + offsetU,0.421763f + offsetV);
		this.MyquadList[14] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex56 ,positiontexturevertex57 ,positiontexturevertex58 ,positiontexturevertex59});
		this.MyquadList[14].flipFace();
		PositionTextureVertex positiontexturevertex60 = new PositionTextureVertex(-2.6343842f ,4.2659683f ,-2.165616f ,0.880607f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex61 = new PositionTextureVertex(-2.4001122f ,4.2659683f ,-1.5999999f ,0.744781f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex62 = new PositionTextureVertex(-2.9598718f ,5.59896f ,-1.5998402f ,0.744743f + offsetU,0.421763f + offsetV);
		PositionTextureVertex positiontexturevertex63 = new PositionTextureVertex(-3.03016f ,5.59896f ,-1.7695198f ,0.78549f + offsetU,0.421763f + offsetV);
		this.MyquadList[15] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex60 ,positiontexturevertex61 ,positiontexturevertex62 ,positiontexturevertex63});
		this.MyquadList[15].flipFace();
		PositionTextureVertex positiontexturevertex64 = new PositionTextureVertex(-3.1999998f ,4.2659683f ,-2.399888f ,0.744781f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex65 = new PositionTextureVertex(-2.6343842f ,4.2659683f ,-2.165616f ,0.608956f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex66 = new PositionTextureVertex(-3.03016f ,5.59896f ,-1.7695198f ,0.703995f + offsetU,0.421763f + offsetV);
		PositionTextureVertex positiontexturevertex67 = new PositionTextureVertex(-3.19984f ,5.59896f ,-1.839808f ,0.744743f + offsetU,0.421763f + offsetV);
		this.MyquadList[16] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex64 ,positiontexturevertex65 ,positiontexturevertex66 ,positiontexturevertex67});
		this.MyquadList[16].flipFace();
		PositionTextureVertex positiontexturevertex68 = new PositionTextureVertex(-3.765616f ,4.2659683f ,-2.165616f ,0.880607f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex69 = new PositionTextureVertex(-3.1999998f ,4.2659683f ,-2.399888f ,0.744781f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex70 = new PositionTextureVertex(-3.19984f ,5.59896f ,-1.839808f ,0.744743f + offsetU,0.421763f + offsetV);
		PositionTextureVertex positiontexturevertex71 = new PositionTextureVertex(-3.3695202f ,5.59896f ,-1.7695198f ,0.785491f + offsetU,0.421763f + offsetV);
		this.MyquadList[17] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex68 ,positiontexturevertex69 ,positiontexturevertex70 ,positiontexturevertex71});
		this.MyquadList[17].flipFace();
		PositionTextureVertex positiontexturevertex72 = new PositionTextureVertex(-3.999888f ,4.2659683f ,-1.5999999f ,0.744781f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex73 = new PositionTextureVertex(-3.765616f ,4.2659683f ,-2.165616f ,0.608956f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex74 = new PositionTextureVertex(-3.3695202f ,5.59896f ,-1.7695198f ,0.704072f + offsetU,0.421763f + offsetV);
		PositionTextureVertex positiontexturevertex75 = new PositionTextureVertex(-3.439808f ,5.59896f ,-1.5998402f ,0.74482f + offsetU,0.421763f + offsetV);
		this.MyquadList[18] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex72 ,positiontexturevertex73 ,positiontexturevertex74 ,positiontexturevertex75});
		this.MyquadList[18].flipFace();
		PositionTextureVertex positiontexturevertex76 = new PositionTextureVertex(-3.765616f ,4.2659683f ,-1.0343838f ,0.880607f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex77 = new PositionTextureVertex(-3.999888f ,4.2659683f ,-1.5999999f ,0.744781f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex78 = new PositionTextureVertex(-3.439808f ,5.59896f ,-1.5998402f ,0.74482f + offsetU,0.421763f + offsetV);
		PositionTextureVertex positiontexturevertex79 = new PositionTextureVertex(-3.3695202f ,5.59896f ,-1.43016f ,0.785567f + offsetU,0.421763f + offsetV);
		this.MyquadList[19] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex76 ,positiontexturevertex77 ,positiontexturevertex78 ,positiontexturevertex79});
		this.MyquadList[19].flipFace();
		PositionTextureVertex positiontexturevertex80 = new PositionTextureVertex(-3.1999998f ,4.2659683f ,-0.8001118f ,0.744781f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex81 = new PositionTextureVertex(-3.765616f ,4.2659683f ,-1.0343838f ,0.608956f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex82 = new PositionTextureVertex(-3.3695202f ,5.59896f ,-1.43016f ,0.704072f + offsetU,0.421763f + offsetV);
		PositionTextureVertex positiontexturevertex83 = new PositionTextureVertex(-3.19984f ,5.59896f ,-1.3598719f ,0.74482f + offsetU,0.421763f + offsetV);
		this.MyquadList[20] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex80 ,positiontexturevertex81 ,positiontexturevertex82 ,positiontexturevertex83});
		this.MyquadList[20].flipFace();
		PositionTextureVertex positiontexturevertex84 = new PositionTextureVertex(-2.6343842f ,4.2659683f ,-1.0343838f ,0.880607f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex85 = new PositionTextureVertex(-3.1999998f ,4.2659683f ,-0.8001118f ,0.744781f + offsetU,0.29372197f + offsetV);
		PositionTextureVertex positiontexturevertex86 = new PositionTextureVertex(-3.19984f ,5.59896f ,-1.3598719f ,0.74482f + offsetU,0.421763f + offsetV);
		PositionTextureVertex positiontexturevertex87 = new PositionTextureVertex(-3.03016f ,5.59896f ,-1.43016f ,0.785567f + offsetU,0.421763f + offsetV);
		this.MyquadList[21] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex84 ,positiontexturevertex85 ,positiontexturevertex86 ,positiontexturevertex87});
		this.MyquadList[21].flipFace();
		PositionTextureVertex positiontexturevertex88 = new PositionTextureVertex(-3.19984f ,5.59896f ,-1.3598719f ,0.732858f + offsetU,0.267442f + offsetV);
		PositionTextureVertex positiontexturevertex89 = new PositionTextureVertex(-3.19984f ,5.59896f ,-1.5998402f ,0.732858f + offsetU,0.20981598f + offsetV);
		PositionTextureVertex positiontexturevertex90 = new PositionTextureVertex(-2.9598718f ,5.59896f ,-1.5998402f ,0.675233f + offsetU,0.20981598f + offsetV);
		PositionTextureVertex positiontexturevertex91 = new PositionTextureVertex(-3.03016f ,5.59896f ,-1.43016f ,0.692111f + offsetU,0.25056398f + offsetV);
		this.MyquadList[22] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex88 ,positiontexturevertex89 ,positiontexturevertex90 ,positiontexturevertex91});
		this.MyquadList[22].flipFace();
		PositionTextureVertex positiontexturevertex92 = new PositionTextureVertex(-3.03016f ,5.59896f ,-1.7695198f ,0.692111f + offsetU,0.16906899f + offsetV);
		PositionTextureVertex positiontexturevertex93 = new PositionTextureVertex(-2.9598718f ,5.59896f ,-1.5998402f ,0.675233f + offsetU,0.20981598f + offsetV);
		PositionTextureVertex positiontexturevertex94 = new PositionTextureVertex(-3.19984f ,5.59896f ,-1.5998402f ,0.732858f + offsetU,0.20981598f + offsetV);
		PositionTextureVertex positiontexturevertex95 = new PositionTextureVertex(-3.19984f ,5.59896f ,-1.839808f ,0.732858f + offsetU,0.15219098f + offsetV);
		this.MyquadList[23] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex92 ,positiontexturevertex93 ,positiontexturevertex94 ,positiontexturevertex95});
		this.MyquadList[23].flipFace();
		PositionTextureVertex positiontexturevertex96 = new PositionTextureVertex(-3.19984f ,5.59896f ,-1.5998402f ,0.732858f + offsetU,0.20981598f + offsetV);
		PositionTextureVertex positiontexturevertex97 = new PositionTextureVertex(-3.439808f ,5.59896f ,-1.5998402f ,0.790484f + offsetU,0.20981598f + offsetV);
		PositionTextureVertex positiontexturevertex98 = new PositionTextureVertex(-3.3695202f ,5.59896f ,-1.7695198f ,0.773606f + offsetU,0.16906899f + offsetV);
		PositionTextureVertex positiontexturevertex99 = new PositionTextureVertex(-3.19984f ,5.59896f ,-1.839808f ,0.732858f + offsetU,0.15219098f + offsetV);
		this.MyquadList[24] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex96 ,positiontexturevertex97 ,positiontexturevertex98 ,positiontexturevertex99});
		this.MyquadList[24].flipFace();
		PositionTextureVertex positiontexturevertex100 = new PositionTextureVertex(-3.19984f ,5.59896f ,-1.3598719f ,0.732858f + offsetU,0.267442f + offsetV);
		PositionTextureVertex positiontexturevertex101 = new PositionTextureVertex(-3.3695202f ,5.59896f ,-1.43016f ,0.773606f + offsetU,0.25056398f + offsetV);
		PositionTextureVertex positiontexturevertex102 = new PositionTextureVertex(-3.439808f ,5.59896f ,-1.5998402f ,0.790484f + offsetU,0.20981598f + offsetV);
		PositionTextureVertex positiontexturevertex103 = new PositionTextureVertex(-3.19984f ,5.59896f ,-1.5998402f ,0.732858f + offsetU,0.20981598f + offsetV);
		this.MyquadList[25] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex100 ,positiontexturevertex101 ,positiontexturevertex102 ,positiontexturevertex103});
		this.MyquadList[25].flipFace();
		
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
