package ModelBoxes;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusLeyDesynthCrystalModelBox extends ModelBox {

	private TexturedQuad[] MyquadList;
	PositionTextureVertex[] MyvertexPositions;
	
	public CookingPlusLeyDesynthCrystalModelBox(ModelRenderer p_i46359_1_) {
		super(p_i46359_1_, 0, 0, 0, 0,0, 0, 0, 0, 0);
		MyquadList = new TexturedQuad[24];
		float offsetU = 0;
		float offsetV = 0;
		PositionTextureVertex positiontexturevertex0 = new PositionTextureVertex(-1.0141282f ,-18.73136f ,1.7916479f ,0.0949413f + offsetU,0.13899797f + offsetV);
		PositionTextureVertex positiontexturevertex1 = new PositionTextureVertex(-1.0141282f ,-12.4704f ,1.7916479f ,0.0949413f + offsetU,0.36280102f + offsetV);
		PositionTextureVertex positiontexturevertex2 = new PositionTextureVertex(1.0141277f ,-12.4704f ,1.7916479f ,0.12879f + offsetU,0.36280102f + offsetV);
		PositionTextureVertex positiontexturevertex3 = new PositionTextureVertex(1.0141277f ,-18.73136f ,1.7916479f ,0.12879f + offsetU,0.13899797f + offsetV);
		this.MyquadList[0] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex0 ,positiontexturevertex1 ,positiontexturevertex2 ,positiontexturevertex3});
		this.MyquadList[0].flipFace();
		PositionTextureVertex positiontexturevertex4 = new PositionTextureVertex(-2.028256f ,-18.73136f ,0.0f ,0.0602511f + offsetU,0.13899797f + offsetV);
		PositionTextureVertex positiontexturevertex5 = new PositionTextureVertex(-2.028256f ,-12.4704f ,0.0f ,0.0602511f + offsetU,0.36280102f + offsetV);
		PositionTextureVertex positiontexturevertex6 = new PositionTextureVertex(-1.0141282f ,-12.4704f ,1.7916479f ,0.0949413f + offsetU,0.36280102f + offsetV);
		PositionTextureVertex positiontexturevertex7 = new PositionTextureVertex(-1.0141282f ,-18.73136f ,1.7916479f ,0.0949413f + offsetU,0.13899797f + offsetV);
		this.MyquadList[1] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex4 ,positiontexturevertex5 ,positiontexturevertex6 ,positiontexturevertex7});
		this.MyquadList[1].flipFace();
		PositionTextureVertex positiontexturevertex8 = new PositionTextureVertex(-1.0141282f ,-18.73136f ,-1.7916479f ,0.0255608f + offsetU,0.13899797f + offsetV);
		PositionTextureVertex positiontexturevertex9 = new PositionTextureVertex(-1.0141282f ,-12.4704f ,-1.7916479f ,0.0255608f + offsetU,0.36280102f + offsetV);
		PositionTextureVertex positiontexturevertex10 = new PositionTextureVertex(-2.028256f ,-12.4704f ,0.0f ,0.0602511f + offsetU,0.36280102f + offsetV);
		PositionTextureVertex positiontexturevertex11 = new PositionTextureVertex(-2.028256f ,-18.73136f ,0.0f ,0.0602511f + offsetU,0.13899797f + offsetV);
		this.MyquadList[2] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex8 ,positiontexturevertex9 ,positiontexturevertex10 ,positiontexturevertex11});
		this.MyquadList[2].flipFace();
		PositionTextureVertex positiontexturevertex12 = new PositionTextureVertex(1.0141277f ,-18.73136f ,-1.7916479f ,0.198171f + offsetU,0.13899797f + offsetV);
		PositionTextureVertex positiontexturevertex13 = new PositionTextureVertex(1.0141277f ,-12.4704f ,-1.7916479f ,0.198171f + offsetU,0.36280102f + offsetV);
		PositionTextureVertex positiontexturevertex14 = new PositionTextureVertex(-1.0141282f ,-12.4704f ,-1.7916479f ,0.23202f + offsetU,0.36280102f + offsetV);
		PositionTextureVertex positiontexturevertex15 = new PositionTextureVertex(-1.0141282f ,-18.73136f ,-1.7916479f ,0.23202f + offsetU,0.13899797f + offsetV);
		this.MyquadList[3] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex12 ,positiontexturevertex13 ,positiontexturevertex14 ,positiontexturevertex15});
		this.MyquadList[3].flipFace();
		PositionTextureVertex positiontexturevertex16 = new PositionTextureVertex(2.0282564f ,-18.73136f ,0.0f ,0.163481f + offsetU,0.13899797f + offsetV);
		PositionTextureVertex positiontexturevertex17 = new PositionTextureVertex(2.0282564f ,-12.4704f ,0.0f ,0.163481f + offsetU,0.36280102f + offsetV);
		PositionTextureVertex positiontexturevertex18 = new PositionTextureVertex(1.0141277f ,-12.4704f ,-1.7916479f ,0.198171f + offsetU,0.36280102f + offsetV);
		PositionTextureVertex positiontexturevertex19 = new PositionTextureVertex(1.0141277f ,-18.73136f ,-1.7916479f ,0.198171f + offsetU,0.13899797f + offsetV);
		this.MyquadList[4] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex16 ,positiontexturevertex17 ,positiontexturevertex18 ,positiontexturevertex19});
		this.MyquadList[4].flipFace();
		PositionTextureVertex positiontexturevertex20 = new PositionTextureVertex(1.0141277f ,-18.73136f ,1.7916479f ,0.12879f + offsetU,0.13899797f + offsetV);
		PositionTextureVertex positiontexturevertex21 = new PositionTextureVertex(1.0141277f ,-12.4704f ,1.7916479f ,0.12879f + offsetU,0.36280102f + offsetV);
		PositionTextureVertex positiontexturevertex22 = new PositionTextureVertex(2.0282564f ,-12.4704f ,0.0f ,0.163481f + offsetU,0.36280102f + offsetV);
		PositionTextureVertex positiontexturevertex23 = new PositionTextureVertex(2.0282564f ,-18.73136f ,0.0f ,0.163481f + offsetU,0.13899797f + offsetV);
		this.MyquadList[5] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex20 ,positiontexturevertex21 ,positiontexturevertex22 ,positiontexturevertex23});
		this.MyquadList[5].flipFace();
		PositionTextureVertex positiontexturevertex24 = new PositionTextureVertex(-1.0141282f ,-18.73136f ,1.7916479f ,0.0949413f + offsetU,0.13899797f + offsetV);
		PositionTextureVertex positiontexturevertex25 = new PositionTextureVertex(1.0141277f ,-18.73136f ,1.7916479f ,0.12879f + offsetU,0.13899797f + offsetV);
		PositionTextureVertex positiontexturevertex26 = new PositionTextureVertex(0.052207947f ,-21.86256f ,0.09163189f ,0.128883f + offsetU,0.027068019f + offsetV);
		PositionTextureVertex positiontexturevertex27 = new PositionTextureVertex(-0.050640106f ,-21.86256f ,0.09163189f ,0.0952702f + offsetU,0.027068019f + offsetV);
		this.MyquadList[6] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex24 ,positiontexturevertex25 ,positiontexturevertex26 ,positiontexturevertex27});
		this.MyquadList[6].flipFace();
		PositionTextureVertex positiontexturevertex28 = new PositionTextureVertex(-2.028256f ,-18.73136f ,0.0f ,0.0602511f + offsetU,0.13899797f + offsetV);
		PositionTextureVertex positiontexturevertex29 = new PositionTextureVertex(-1.0141282f ,-18.73136f ,1.7916479f ,0.0949413f + offsetU,0.13899797f + offsetV);
		PositionTextureVertex positiontexturevertex30 = new PositionTextureVertex(-0.050640106f ,-21.86256f ,0.09163189f ,0.0952702f + offsetU,0.027068019f + offsetV);
		PositionTextureVertex positiontexturevertex31 = new PositionTextureVertex(-0.10206413f ,-21.86256f ,7.839203E-4f ,0.0605032f + offsetU,0.027068019f + offsetV);
		this.MyquadList[7] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex28 ,positiontexturevertex29 ,positiontexturevertex30 ,positiontexturevertex31});
		this.MyquadList[7].flipFace();
		PositionTextureVertex positiontexturevertex32 = new PositionTextureVertex(-1.0141282f ,-18.73136f ,-1.7916479f ,0.0255608f + offsetU,0.13899797f + offsetV);
		PositionTextureVertex positiontexturevertex33 = new PositionTextureVertex(-2.028256f ,-18.73136f ,0.0f ,0.0602511f + offsetU,0.13899797f + offsetV);
		PositionTextureVertex positiontexturevertex34 = new PositionTextureVertex(-0.10206413f ,-21.86256f ,7.839203E-4f ,0.0605032f + offsetU,0.027068019f + offsetV);
		PositionTextureVertex positiontexturevertex35 = new PositionTextureVertex(-0.050640106f ,-21.86256f ,-0.090079784f ,0.0254712f + offsetU,0.027068019f + offsetV);
		this.MyquadList[8] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex32 ,positiontexturevertex33 ,positiontexturevertex34 ,positiontexturevertex35});
		this.MyquadList[8].flipFace();
		PositionTextureVertex positiontexturevertex36 = new PositionTextureVertex(1.0141277f ,-18.73136f ,-1.7916479f ,0.198171f + offsetU,0.13899797f + offsetV);
		PositionTextureVertex positiontexturevertex37 = new PositionTextureVertex(-1.0141282f ,-18.73136f ,-1.7916479f ,0.23202f + offsetU,0.13899797f + offsetV);
		PositionTextureVertex positiontexturevertex38 = new PositionTextureVertex(-0.050640106f ,-21.86256f ,-0.090079784f ,0.23193f + offsetU,0.027068019f + offsetV);
		PositionTextureVertex positiontexturevertex39 = new PositionTextureVertex(0.052207947f ,-21.86256f ,-0.090079784f ,0.197836f + offsetU,0.027068019f + offsetV);
		this.MyquadList[9] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex36 ,positiontexturevertex37 ,positiontexturevertex38 ,positiontexturevertex39});
		this.MyquadList[9].flipFace();
		PositionTextureVertex positiontexturevertex40 = new PositionTextureVertex(2.0282564f ,-18.73136f ,0.0f ,0.163481f + offsetU,0.13899797f + offsetV);
		PositionTextureVertex positiontexturevertex41 = new PositionTextureVertex(1.0141277f ,-18.73136f ,-1.7916479f ,0.198171f + offsetU,0.13899797f + offsetV);
		PositionTextureVertex positiontexturevertex42 = new PositionTextureVertex(0.052207947f ,-21.86256f ,-0.090079784f ,0.197836f + offsetU,0.027068019f + offsetV);
		PositionTextureVertex positiontexturevertex43 = new PositionTextureVertex(0.10363197f ,-21.86256f ,7.839203E-4f ,0.163232f + offsetU,0.027068019f + offsetV);
		this.MyquadList[10] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex40 ,positiontexturevertex41 ,positiontexturevertex42 ,positiontexturevertex43});
		this.MyquadList[10].flipFace();
		PositionTextureVertex positiontexturevertex44 = new PositionTextureVertex(1.0141277f ,-18.73136f ,1.7916479f ,0.12879f + offsetU,0.13899797f + offsetV);
		PositionTextureVertex positiontexturevertex45 = new PositionTextureVertex(2.0282564f ,-18.73136f ,0.0f ,0.163481f + offsetU,0.13899797f + offsetV);
		PositionTextureVertex positiontexturevertex46 = new PositionTextureVertex(0.10363197f ,-21.86256f ,7.839203E-4f ,0.163232f + offsetU,0.027068019f + offsetV);
		PositionTextureVertex positiontexturevertex47 = new PositionTextureVertex(0.052207947f ,-21.86256f ,0.09163189f ,0.128883f + offsetU,0.027068019f + offsetV);
		this.MyquadList[11] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex44 ,positiontexturevertex45 ,positiontexturevertex46 ,positiontexturevertex47});
		this.MyquadList[11].flipFace();
		PositionTextureVertex positiontexturevertex48 = new PositionTextureVertex(7.839203E-4f ,-21.86256f ,7.839203E-4f ,0.111866f + offsetU,0.027068019f + offsetV);
		PositionTextureVertex positiontexturevertex49 = new PositionTextureVertex(0.10363197f ,-21.86256f ,7.839203E-4f ,0.163232f + offsetU,0.027068019f + offsetV);
		PositionTextureVertex positiontexturevertex50 = new PositionTextureVertex(0.052207947f ,-21.86256f ,-0.090079784f ,0.197836f + offsetU,0.027068019f + offsetV);
		PositionTextureVertex positiontexturevertex51 = new PositionTextureVertex(-0.050640106f ,-21.86256f ,-0.090079784f ,0.23193f + offsetU,0.027068019f + offsetV);
		this.MyquadList[12] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex48 ,positiontexturevertex49 ,positiontexturevertex50 ,positiontexturevertex51});
		this.MyquadList[12].flipFace();
		PositionTextureVertex positiontexturevertex52 = new PositionTextureVertex(-0.10206413f ,-21.86256f ,7.839203E-4f ,0.0605032f + offsetU,0.027068019f + offsetV);
		PositionTextureVertex positiontexturevertex53 = new PositionTextureVertex(-0.050640106f ,-21.86256f ,0.09163189f ,0.0952702f + offsetU,0.027068019f + offsetV);
		PositionTextureVertex positiontexturevertex54 = new PositionTextureVertex(7.839203E-4f ,-21.86256f ,7.839203E-4f ,0.111866f + offsetU,0.027068019f + offsetV);
		PositionTextureVertex positiontexturevertex55 = new PositionTextureVertex(-0.050640106f ,-21.86256f ,-0.090079784f ,0.0254712f + offsetU,0.027068019f + offsetV);
		this.MyquadList[13] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex52 ,positiontexturevertex53 ,positiontexturevertex54 ,positiontexturevertex55});
		this.MyquadList[13].flipFace();
		PositionTextureVertex positiontexturevertex56 = new PositionTextureVertex(0.052207947f ,-21.86256f ,0.09163189f ,0.128883f + offsetU,0.027068019f + offsetV);
		PositionTextureVertex positiontexturevertex57 = new PositionTextureVertex(0.10363197f ,-21.86256f ,7.839203E-4f ,0.163232f + offsetU,0.027068019f + offsetV);
		PositionTextureVertex positiontexturevertex58 = new PositionTextureVertex(7.839203E-4f ,-21.86256f ,7.839203E-4f ,0.111866f + offsetU,0.027068019f + offsetV);
		PositionTextureVertex positiontexturevertex59 = new PositionTextureVertex(-0.050640106f ,-21.86256f ,0.09163189f ,0.0952702f + offsetU,0.027068019f + offsetV);
		this.MyquadList[14] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex56 ,positiontexturevertex57 ,positiontexturevertex58 ,positiontexturevertex59});
		this.MyquadList[14].flipFace();
		PositionTextureVertex positiontexturevertex60 = new PositionTextureVertex(1.0141277f ,-12.4704f ,1.7916479f ,0.12879f + offsetU,0.36280102f + offsetV);
		PositionTextureVertex positiontexturevertex61 = new PositionTextureVertex(-1.0141282f ,-12.4704f ,1.7916479f ,0.0949413f + offsetU,0.36280102f + offsetV);
		PositionTextureVertex positiontexturevertex62 = new PositionTextureVertex(-0.064352036f ,-9.340639f ,0.11585617f ,0.095202f + offsetU,0.474674f + offsetV);
		PositionTextureVertex positiontexturevertex63 = new PositionTextureVertex(0.065919876f ,-9.340639f ,0.11585617f ,0.128862f + offsetU,0.474674f + offsetV);
		this.MyquadList[15] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex60 ,positiontexturevertex61 ,positiontexturevertex62 ,positiontexturevertex63});
		this.MyquadList[15].flipFace();
		PositionTextureVertex positiontexturevertex64 = new PositionTextureVertex(-1.0141282f ,-12.4704f ,1.7916479f ,0.0949413f + offsetU,0.36280102f + offsetV);
		PositionTextureVertex positiontexturevertex65 = new PositionTextureVertex(-2.028256f ,-12.4704f ,0.0f ,0.0602511f + offsetU,0.36280102f + offsetV);
		PositionTextureVertex positiontexturevertex66 = new PositionTextureVertex(-0.12948799f ,-9.340639f ,7.839203E-4f ,0.0604498f + offsetU,0.474674f + offsetV);
		PositionTextureVertex positiontexturevertex67 = new PositionTextureVertex(-0.064352036f ,-9.340639f ,0.11585617f ,0.095202f + offsetU,0.474674f + offsetV);
		this.MyquadList[16] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex64 ,positiontexturevertex65 ,positiontexturevertex66 ,positiontexturevertex67});
		this.MyquadList[16].flipFace();
		PositionTextureVertex positiontexturevertex68 = new PositionTextureVertex(-2.028256f ,-12.4704f ,0.0f ,0.0602511f + offsetU,0.36280102f + offsetV);
		PositionTextureVertex positiontexturevertex69 = new PositionTextureVertex(-1.0141282f ,-12.4704f ,-1.7916479f ,0.0255608f + offsetU,0.36280102f + offsetV);
		PositionTextureVertex positiontexturevertex70 = new PositionTextureVertex(-0.064352036f ,-9.340639f ,-0.11428785f ,0.0254827f + offsetU,0.474674f + offsetV);
		PositionTextureVertex positiontexturevertex71 = new PositionTextureVertex(-0.12948799f ,-9.340639f ,7.839203E-4f ,0.0604498f + offsetU,0.474674f + offsetV);
		this.MyquadList[17] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex68 ,positiontexturevertex69 ,positiontexturevertex70 ,positiontexturevertex71});
		this.MyquadList[17].flipFace();
		PositionTextureVertex positiontexturevertex72 = new PositionTextureVertex(-1.0141282f ,-12.4704f ,-1.7916479f ,0.23202f + offsetU,0.36280102f + offsetV);
		PositionTextureVertex positiontexturevertex73 = new PositionTextureVertex(1.0141277f ,-12.4704f ,-1.7916479f ,0.198171f + offsetU,0.36280102f + offsetV);
		PositionTextureVertex positiontexturevertex74 = new PositionTextureVertex(0.065919876f ,-9.340639f ,-0.11428785f ,0.197906f + offsetU,0.474674f + offsetV);
		PositionTextureVertex positiontexturevertex75 = new PositionTextureVertex(-0.064352036f ,-9.340639f ,-0.11428785f ,0.231942f + offsetU,0.474674f + offsetV);
		this.MyquadList[18] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex72 ,positiontexturevertex73 ,positiontexturevertex74 ,positiontexturevertex75});
		this.MyquadList[18].flipFace();
		PositionTextureVertex positiontexturevertex76 = new PositionTextureVertex(1.0141277f ,-12.4704f ,-1.7916479f ,0.198171f + offsetU,0.36280102f + offsetV);
		PositionTextureVertex positiontexturevertex77 = new PositionTextureVertex(2.0282564f ,-12.4704f ,0.0f ,0.163481f + offsetU,0.36280102f + offsetV);
		PositionTextureVertex positiontexturevertex78 = new PositionTextureVertex(0.13105583f ,-9.340639f ,7.839203E-4f ,0.163284f + offsetU,0.474674f + offsetV);
		PositionTextureVertex positiontexturevertex79 = new PositionTextureVertex(0.065919876f ,-9.340639f ,-0.11428785f ,0.197906f + offsetU,0.474674f + offsetV);
		this.MyquadList[19] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex76 ,positiontexturevertex77 ,positiontexturevertex78 ,positiontexturevertex79});
		this.MyquadList[19].flipFace();
		PositionTextureVertex positiontexturevertex80 = new PositionTextureVertex(2.0282564f ,-12.4704f ,0.0f ,0.163481f + offsetU,0.36280102f + offsetV);
		PositionTextureVertex positiontexturevertex81 = new PositionTextureVertex(1.0141277f ,-12.4704f ,1.7916479f ,0.12879f + offsetU,0.36280102f + offsetV);
		PositionTextureVertex positiontexturevertex82 = new PositionTextureVertex(0.065919876f ,-9.340639f ,0.11585617f ,0.128862f + offsetU,0.474674f + offsetV);
		PositionTextureVertex positiontexturevertex83 = new PositionTextureVertex(0.13105583f ,-9.340639f ,7.839203E-4f ,0.163284f + offsetU,0.474674f + offsetV);
		this.MyquadList[20] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex80 ,positiontexturevertex81 ,positiontexturevertex82 ,positiontexturevertex83});
		this.MyquadList[20].flipFace();
		PositionTextureVertex positiontexturevertex84 = new PositionTextureVertex(0.13105583f ,-9.340639f ,7.839203E-4f ,0.163284f + offsetU,0.474674f + offsetV);
		PositionTextureVertex positiontexturevertex85 = new PositionTextureVertex(0.065919876f ,-9.340639f ,0.11585617f ,0.128862f + offsetU,0.474674f + offsetV);
		PositionTextureVertex positiontexturevertex86 = new PositionTextureVertex(-0.064352036f ,-9.340639f ,0.11585617f ,0.095202f + offsetU,0.474674f + offsetV);
		PositionTextureVertex positiontexturevertex87 = new PositionTextureVertex(7.839203E-4f ,-9.340639f ,7.839203E-4f ,0.111866f + offsetU,0.474674f + offsetV);
		this.MyquadList[21] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex84 ,positiontexturevertex85 ,positiontexturevertex86 ,positiontexturevertex87});
		this.MyquadList[21].flipFace();
		PositionTextureVertex positiontexturevertex88 = new PositionTextureVertex(7.839203E-4f ,-9.340639f ,7.839203E-4f ,0.111866f + offsetU,0.474674f + offsetV);
		PositionTextureVertex positiontexturevertex89 = new PositionTextureVertex(-0.064352036f ,-9.340639f ,0.11585617f ,0.095202f + offsetU,0.474674f + offsetV);
		PositionTextureVertex positiontexturevertex90 = new PositionTextureVertex(-0.12948799f ,-9.340639f ,7.839203E-4f ,0.0604498f + offsetU,0.474674f + offsetV);
		PositionTextureVertex positiontexturevertex91 = new PositionTextureVertex(-0.064352036f ,-9.340639f ,-0.11428785f ,0.0254827f + offsetU,0.474674f + offsetV);
		this.MyquadList[22] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex88 ,positiontexturevertex89 ,positiontexturevertex90 ,positiontexturevertex91});
		this.MyquadList[22].flipFace();
		PositionTextureVertex positiontexturevertex92 = new PositionTextureVertex(7.839203E-4f ,-9.340639f ,7.839203E-4f ,0.111866f + offsetU,0.474674f + offsetV);
		PositionTextureVertex positiontexturevertex93 = new PositionTextureVertex(-0.064352036f ,-9.340639f ,-0.11428785f ,0.231942f + offsetU,0.474674f + offsetV);
		PositionTextureVertex positiontexturevertex94 = new PositionTextureVertex(0.065919876f ,-9.340639f ,-0.11428785f ,0.197906f + offsetU,0.474674f + offsetV);
		PositionTextureVertex positiontexturevertex95 = new PositionTextureVertex(0.13105583f ,-9.340639f ,7.839203E-4f ,0.163284f + offsetU,0.474674f + offsetV);
		this.MyquadList[23] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex92 ,positiontexturevertex93 ,positiontexturevertex94 ,positiontexturevertex95});
		this.MyquadList[23].flipFace();
		
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
