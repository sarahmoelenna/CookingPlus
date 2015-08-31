package ModelBoxes;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusSheetPressTopModelBox extends ModelBox {

	private TexturedQuad[] MyquadList;
	PositionTextureVertex[] MyvertexPositions;
	
	public CookingPlusSheetPressTopModelBox(ModelRenderer p_i46359_1_) {
		super(p_i46359_1_, 0, 0, 0, 0,0, 0, 0, 0, 0);
		MyquadList = new TexturedQuad[28];

		PositionTextureVertex positiontexturevertex0 = new PositionTextureVertex(3.7333279f ,1.3860159f ,-2.0f ,0.381836f ,0.053710997f);
		PositionTextureVertex positiontexturevertex1 = new PositionTextureVertex(-3.7333279f ,1.3860159f ,-2.0f ,0.59082f ,0.053710997f);
		PositionTextureVertex positiontexturevertex2 = new PositionTextureVertex(-3.7333279f ,1.3860159f ,2.0f ,0.59082f ,0.262695f);
		PositionTextureVertex positiontexturevertex3 = new PositionTextureVertex(3.7333279f ,1.3860159f ,2.0f ,0.381836f ,0.262695f);
		this.MyquadList[0] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex0 ,positiontexturevertex1 ,positiontexturevertex2 ,positiontexturevertex3});
		PositionTextureVertex positiontexturevertex4 = new PositionTextureVertex(3.7333279f ,-1.0755839f ,-2.0f ,0.381836f ,0.053710997f);
		PositionTextureVertex positiontexturevertex5 = new PositionTextureVertex(3.7333279f ,-1.0755839f ,2.0f ,0.381836f ,0.262695f);
		PositionTextureVertex positiontexturevertex6 = new PositionTextureVertex(-3.7333279f ,-1.0755839f ,2.0f ,0.59082f ,0.262695f);
		PositionTextureVertex positiontexturevertex7 = new PositionTextureVertex(-3.7333279f ,-1.0755839f ,-2.0f ,0.59082f ,0.053710997f);
		this.MyquadList[1] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex4 ,positiontexturevertex5 ,positiontexturevertex6 ,positiontexturevertex7});
		PositionTextureVertex positiontexturevertex8 = new PositionTextureVertex(3.7333279f ,-1.0755839f ,2.0f ,0.381836f ,0.262695f);
		PositionTextureVertex positiontexturevertex9 = new PositionTextureVertex(3.7333279f ,1.3860159f ,2.0f ,0.381836f ,0.262695f);
		PositionTextureVertex positiontexturevertex10 = new PositionTextureVertex(-3.7333279f ,1.3860159f ,2.0f ,0.59082f ,0.262695f);
		PositionTextureVertex positiontexturevertex11 = new PositionTextureVertex(-3.7333279f ,-1.0755839f ,2.0f ,0.59082f ,0.262695f);
		this.MyquadList[2] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex8 ,positiontexturevertex9 ,positiontexturevertex10 ,positiontexturevertex11});
		PositionTextureVertex positiontexturevertex12 = new PositionTextureVertex(-3.7333279f ,-1.0755839f ,-2.0f ,0.59082f ,0.053710997f);
		PositionTextureVertex positiontexturevertex13 = new PositionTextureVertex(-3.7333279f ,1.3860159f ,-2.0f ,0.59082f ,0.053710997f);
		PositionTextureVertex positiontexturevertex14 = new PositionTextureVertex(3.7333279f ,1.3860159f ,-2.0f ,0.381836f ,0.053710997f);
		PositionTextureVertex positiontexturevertex15 = new PositionTextureVertex(3.7333279f ,-1.0755839f ,-2.0f ,0.381836f ,0.053710997f);
		this.MyquadList[3] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex12 ,positiontexturevertex13 ,positiontexturevertex14 ,positiontexturevertex15});
		PositionTextureVertex positiontexturevertex16 = new PositionTextureVertex(3.7333279f ,-1.0755839f ,-2.0f ,0.381836f ,0.053710997f);
		PositionTextureVertex positiontexturevertex17 = new PositionTextureVertex(3.7333279f ,1.3860159f ,-2.0f ,0.381836f ,0.053710997f);
		PositionTextureVertex positiontexturevertex18 = new PositionTextureVertex(3.7333279f ,1.3860159f ,2.0f ,0.381836f ,0.262695f);
		PositionTextureVertex positiontexturevertex19 = new PositionTextureVertex(3.7333279f ,-1.0755839f ,2.0f ,0.381836f ,0.262695f);
		this.MyquadList[4] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex16 ,positiontexturevertex17 ,positiontexturevertex18 ,positiontexturevertex19});
		PositionTextureVertex positiontexturevertex20 = new PositionTextureVertex(-3.7333279f ,-1.0755839f ,2.0f ,0.59082f ,0.262695f);
		PositionTextureVertex positiontexturevertex21 = new PositionTextureVertex(-3.7333279f ,1.3860159f ,2.0f ,0.59082f ,0.262695f);
		PositionTextureVertex positiontexturevertex22 = new PositionTextureVertex(-3.7333279f ,1.3860159f ,-2.0f ,0.59082f ,0.053710997f);
		PositionTextureVertex positiontexturevertex23 = new PositionTextureVertex(-3.7333279f ,-1.0755839f ,-2.0f ,0.59082f ,0.053710997f);
		this.MyquadList[5] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex20 ,positiontexturevertex21 ,positiontexturevertex22 ,positiontexturevertex23});
		PositionTextureVertex positiontexturevertex24 = new PositionTextureVertex(4.3655996f ,-5.999998f ,-2.1828318f ,0.0740165f ,0.08768803f);
		PositionTextureVertex positiontexturevertex25 = new PositionTextureVertex(4.3655996f ,-5.999998f ,2.1838398f ,0.0740165f ,0.19749397f);
		PositionTextureVertex positiontexturevertex26 = new PositionTextureVertex(-4.367728f ,-6.000001f ,2.1838398f ,0.183823f ,0.19749397f);
		PositionTextureVertex positiontexturevertex27 = new PositionTextureVertex(-4.367728f ,-6.000001f ,-2.1828318f ,0.183823f ,0.08768803f);
		this.MyquadList[6] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex24 ,positiontexturevertex25 ,positiontexturevertex26 ,positiontexturevertex27});
		PositionTextureVertex positiontexturevertex28 = new PositionTextureVertex(-7.999998f ,-3.537168f ,-4.0f ,0.229492f ,0.04199201f);
		PositionTextureVertex positiontexturevertex29 = new PositionTextureVertex(8.0f ,-3.537168f ,-4.0f ,0.0283203f ,0.04199201f);
		PositionTextureVertex positiontexturevertex30 = new PositionTextureVertex(4.3655996f ,-5.999998f ,-2.1828318f ,0.0740165f ,0.08768803f);
		PositionTextureVertex positiontexturevertex31 = new PositionTextureVertex(-4.367728f ,-6.000001f ,-2.1828318f ,0.183823f ,0.08768803f);
		this.MyquadList[7] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex28 ,positiontexturevertex29 ,positiontexturevertex30 ,positiontexturevertex31});
		PositionTextureVertex positiontexturevertex32 = new PositionTextureVertex(-7.999998f ,-3.537168f ,4.0f ,0.229492f ,0.243164f);
		PositionTextureVertex positiontexturevertex33 = new PositionTextureVertex(-7.999998f ,-3.537168f ,-4.0f ,0.229492f ,0.04199201f);
		PositionTextureVertex positiontexturevertex34 = new PositionTextureVertex(-4.367728f ,-6.000001f ,-2.1828318f ,0.183823f ,0.08768803f);
		PositionTextureVertex positiontexturevertex35 = new PositionTextureVertex(-4.367728f ,-6.000001f ,2.1838398f ,0.183823f ,0.19749397f);
		this.MyquadList[8] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex32 ,positiontexturevertex33 ,positiontexturevertex34 ,positiontexturevertex35});
		PositionTextureVertex positiontexturevertex36 = new PositionTextureVertex(8.0f ,-3.537168f ,4.0f ,0.0283203f ,0.243164f);
		PositionTextureVertex positiontexturevertex37 = new PositionTextureVertex(-7.999998f ,-3.537168f ,4.0f ,0.229492f ,0.243164f);
		PositionTextureVertex positiontexturevertex38 = new PositionTextureVertex(-4.367728f ,-6.000001f ,2.1838398f ,0.183823f ,0.19749397f);
		PositionTextureVertex positiontexturevertex39 = new PositionTextureVertex(4.3655996f ,-5.999998f ,2.1838398f ,0.0740165f ,0.19749397f);
		this.MyquadList[9] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex36 ,positiontexturevertex37 ,positiontexturevertex38 ,positiontexturevertex39});
		PositionTextureVertex positiontexturevertex40 = new PositionTextureVertex(8.0f ,-3.537168f ,-4.0f ,0.0283203f ,0.04199201f);
		PositionTextureVertex positiontexturevertex41 = new PositionTextureVertex(8.0f ,-3.537168f ,4.0f ,0.0283203f ,0.243164f);
		PositionTextureVertex positiontexturevertex42 = new PositionTextureVertex(4.3655996f ,-5.999998f ,2.1838398f ,0.0740165f ,0.19749397f);
		PositionTextureVertex positiontexturevertex43 = new PositionTextureVertex(4.3655996f ,-5.999998f ,-2.1828318f ,0.0740165f ,0.08768803f);
		this.MyquadList[10] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex40 ,positiontexturevertex41 ,positiontexturevertex42 ,positiontexturevertex43});
		PositionTextureVertex positiontexturevertex44 = new PositionTextureVertex(8.0f ,-1.0755839f ,-4.0f ,0.0283203f ,0.04199201f);
		PositionTextureVertex positiontexturevertex45 = new PositionTextureVertex(-7.999999f ,-1.0755839f ,-4.0f ,0.229492f ,0.04199201f);
		PositionTextureVertex positiontexturevertex46 = new PositionTextureVertex(-7.999999f ,-1.0755839f ,4.0f ,0.229492f ,0.243164f);
		PositionTextureVertex positiontexturevertex47 = new PositionTextureVertex(8.0f ,-1.0755839f ,4.0f ,0.0283203f ,0.243164f);
		this.MyquadList[11] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex44 ,positiontexturevertex45 ,positiontexturevertex46 ,positiontexturevertex47});
		PositionTextureVertex positiontexturevertex48 = new PositionTextureVertex(8.0f ,-3.537168f ,4.0f ,0.0283203f ,0.243164f);
		PositionTextureVertex positiontexturevertex49 = new PositionTextureVertex(8.0f ,-1.0755839f ,4.0f ,0.0283203f ,0.243164f);
		PositionTextureVertex positiontexturevertex50 = new PositionTextureVertex(-7.999999f ,-1.0755839f ,4.0f ,0.229492f ,0.243164f);
		PositionTextureVertex positiontexturevertex51 = new PositionTextureVertex(-7.999998f ,-3.537168f ,4.0f ,0.229492f ,0.243164f);
		this.MyquadList[12] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex48 ,positiontexturevertex49 ,positiontexturevertex50 ,positiontexturevertex51});
		PositionTextureVertex positiontexturevertex52 = new PositionTextureVertex(-7.999998f ,-3.537168f ,-4.0f ,0.229492f ,0.04199201f);
		PositionTextureVertex positiontexturevertex53 = new PositionTextureVertex(-7.999999f ,-1.0755839f ,-4.0f ,0.229492f ,0.04199201f);
		PositionTextureVertex positiontexturevertex54 = new PositionTextureVertex(8.0f ,-1.0755839f ,-4.0f ,0.0283203f ,0.04199201f);
		PositionTextureVertex positiontexturevertex55 = new PositionTextureVertex(8.0f ,-3.537168f ,-4.0f ,0.0283203f ,0.04199201f);
		this.MyquadList[13] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex52 ,positiontexturevertex53 ,positiontexturevertex54 ,positiontexturevertex55});
		PositionTextureVertex positiontexturevertex56 = new PositionTextureVertex(8.0f ,-3.537168f ,-4.0f ,0.0283203f ,0.04199201f);
		PositionTextureVertex positiontexturevertex57 = new PositionTextureVertex(8.0f ,-1.0755839f ,-4.0f ,0.0283203f ,0.04199201f);
		PositionTextureVertex positiontexturevertex58 = new PositionTextureVertex(8.0f ,-1.0755839f ,4.0f ,0.0283203f ,0.243164f);
		PositionTextureVertex positiontexturevertex59 = new PositionTextureVertex(8.0f ,-3.537168f ,4.0f ,0.0283203f ,0.243164f);
		this.MyquadList[14] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex56 ,positiontexturevertex57 ,positiontexturevertex58 ,positiontexturevertex59});
		PositionTextureVertex positiontexturevertex60 = new PositionTextureVertex(-7.999998f ,-3.537168f ,4.0f ,0.229492f ,0.243164f);
		PositionTextureVertex positiontexturevertex61 = new PositionTextureVertex(-7.999999f ,-1.0755839f ,4.0f ,0.229492f ,0.243164f);
		PositionTextureVertex positiontexturevertex62 = new PositionTextureVertex(-7.999999f ,-1.0755839f ,-4.0f ,0.229492f ,0.04199201f);
		PositionTextureVertex positiontexturevertex63 = new PositionTextureVertex(-7.999998f ,-3.537168f ,-4.0f ,0.229492f ,0.04199201f);
		this.MyquadList[15] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex60 ,positiontexturevertex61 ,positiontexturevertex62 ,positiontexturevertex63});
		PositionTextureVertex positiontexturevertex64 = new PositionTextureVertex(-6.6442657f ,-1.0755839f ,0.7290077f ,0.936523f ,0.05761701f);
		PositionTextureVertex positiontexturevertex65 = new PositionTextureVertex(-6.6442657f ,3.8476162f ,0.7290077f ,0.936523f ,0.268555f);
		PositionTextureVertex positiontexturevertex66 = new PositionTextureVertex(-6.6442657f ,3.8476162f ,-0.7290082f ,0.706055f ,0.268555f);
		PositionTextureVertex positiontexturevertex67 = new PositionTextureVertex(-6.6442657f ,-1.0755839f ,-0.7290082f ,0.706055f ,0.05761701f);
		this.MyquadList[16] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex64 ,positiontexturevertex65 ,positiontexturevertex66 ,positiontexturevertex67});
		PositionTextureVertex positiontexturevertex68 = new PositionTextureVertex(-5.089072f ,-1.0755839f ,-0.7290082f ,0.706055f ,0.05761701f);
		PositionTextureVertex positiontexturevertex69 = new PositionTextureVertex(-5.089072f ,3.8476162f ,-0.7290082f ,0.706055f ,0.268555f);
		PositionTextureVertex positiontexturevertex70 = new PositionTextureVertex(-5.089072f ,3.8476162f ,0.7290077f ,0.936523f ,0.268555f);
		PositionTextureVertex positiontexturevertex71 = new PositionTextureVertex(-5.089072f ,-1.0755839f ,0.7290077f ,0.936523f ,0.05761701f);
		this.MyquadList[17] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex68 ,positiontexturevertex69 ,positiontexturevertex70 ,positiontexturevertex71});
		PositionTextureVertex positiontexturevertex72 = new PositionTextureVertex(-6.6442657f ,-1.0755839f ,-0.7290082f ,0.706055f ,0.05761701f);
		PositionTextureVertex positiontexturevertex73 = new PositionTextureVertex(-6.6442657f ,3.8476162f ,-0.7290082f ,0.706055f ,0.268555f);
		PositionTextureVertex positiontexturevertex74 = new PositionTextureVertex(-5.089072f ,3.8476162f ,-0.7290082f ,0.706055f ,0.268555f);
		PositionTextureVertex positiontexturevertex75 = new PositionTextureVertex(-5.089072f ,-1.0755839f ,-0.7290082f ,0.706055f ,0.05761701f);
		this.MyquadList[18] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex72 ,positiontexturevertex73 ,positiontexturevertex74 ,positiontexturevertex75});
		PositionTextureVertex positiontexturevertex76 = new PositionTextureVertex(-5.089072f ,-1.0755839f ,0.7290077f ,0.936523f ,0.05761701f);
		PositionTextureVertex positiontexturevertex77 = new PositionTextureVertex(-5.089072f ,3.8476162f ,0.7290077f ,0.936523f ,0.268555f);
		PositionTextureVertex positiontexturevertex78 = new PositionTextureVertex(-6.6442657f ,3.8476162f ,0.7290077f ,0.936523f ,0.268555f);
		PositionTextureVertex positiontexturevertex79 = new PositionTextureVertex(-6.6442657f ,-1.0755839f ,0.7290077f ,0.936523f ,0.05761701f);
		this.MyquadList[19] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex76 ,positiontexturevertex77 ,positiontexturevertex78 ,positiontexturevertex79});
		PositionTextureVertex positiontexturevertex80 = new PositionTextureVertex(-5.089072f ,-1.0755839f ,-0.7290082f ,0.706055f ,0.05761701f);
		PositionTextureVertex positiontexturevertex81 = new PositionTextureVertex(-5.089072f ,-1.0755839f ,0.7290077f ,0.936523f ,0.05761701f);
		PositionTextureVertex positiontexturevertex82 = new PositionTextureVertex(-6.6442657f ,-1.0755839f ,0.7290077f ,0.936523f ,0.05761701f);
		PositionTextureVertex positiontexturevertex83 = new PositionTextureVertex(-6.6442657f ,-1.0755839f ,-0.7290082f ,0.706055f ,0.05761701f);
		this.MyquadList[20] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex80 ,positiontexturevertex81 ,positiontexturevertex82 ,positiontexturevertex83});
		PositionTextureVertex positiontexturevertex84 = new PositionTextureVertex(-5.089072f ,3.8476162f ,-0.7290082f ,0.706055f ,0.268555f);
		PositionTextureVertex positiontexturevertex85 = new PositionTextureVertex(-6.6442657f ,3.8476162f ,-0.7290082f ,0.706055f ,0.268555f);
		PositionTextureVertex positiontexturevertex86 = new PositionTextureVertex(-6.6442657f ,3.8476162f ,0.7290077f ,0.936523f ,0.268555f);
		PositionTextureVertex positiontexturevertex87 = new PositionTextureVertex(-5.089072f ,3.8476162f ,0.7290077f ,0.936523f ,0.268555f);
		this.MyquadList[21] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex84 ,positiontexturevertex85 ,positiontexturevertex86 ,positiontexturevertex87});
		PositionTextureVertex positiontexturevertex88 = new PositionTextureVertex(6.644272f ,3.8476162f ,-0.7290082f ,0.706055f ,0.268555f);
		PositionTextureVertex positiontexturevertex89 = new PositionTextureVertex(5.089072f ,3.8476162f ,-0.7290082f ,0.706055f ,0.268555f);
		PositionTextureVertex positiontexturevertex90 = new PositionTextureVertex(5.089072f ,3.8476162f ,0.7290077f ,0.936523f ,0.268555f);
		PositionTextureVertex positiontexturevertex91 = new PositionTextureVertex(6.644272f ,3.8476162f ,0.7290077f ,0.936523f ,0.268555f);
		this.MyquadList[22] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex88 ,positiontexturevertex89 ,positiontexturevertex90 ,positiontexturevertex91});
		PositionTextureVertex positiontexturevertex92 = new PositionTextureVertex(6.644272f ,-1.0755839f ,-0.7290082f ,0.706055f ,0.05761701f);
		PositionTextureVertex positiontexturevertex93 = new PositionTextureVertex(6.644272f ,-1.0755839f ,0.7290077f ,0.936523f ,0.05761701f);
		PositionTextureVertex positiontexturevertex94 = new PositionTextureVertex(5.089072f ,-1.0755839f ,0.7290077f ,0.936523f ,0.05761701f);
		PositionTextureVertex positiontexturevertex95 = new PositionTextureVertex(5.089072f ,-1.0755839f ,-0.7290082f ,0.706055f ,0.05761701f);
		this.MyquadList[23] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex92 ,positiontexturevertex93 ,positiontexturevertex94 ,positiontexturevertex95});
		PositionTextureVertex positiontexturevertex96 = new PositionTextureVertex(6.644272f ,-1.0755839f ,0.7290077f ,0.936523f ,0.05761701f);
		PositionTextureVertex positiontexturevertex97 = new PositionTextureVertex(6.644272f ,3.8476162f ,0.7290077f ,0.936523f ,0.268555f);
		PositionTextureVertex positiontexturevertex98 = new PositionTextureVertex(5.089072f ,3.8476162f ,0.7290077f ,0.936523f ,0.268555f);
		PositionTextureVertex positiontexturevertex99 = new PositionTextureVertex(5.089072f ,-1.0755839f ,0.7290077f ,0.936523f ,0.05761701f);
		this.MyquadList[24] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex96 ,positiontexturevertex97 ,positiontexturevertex98 ,positiontexturevertex99});
		PositionTextureVertex positiontexturevertex100 = new PositionTextureVertex(5.089072f ,-1.0755839f ,-0.7290082f ,0.706055f ,0.05761701f);
		PositionTextureVertex positiontexturevertex101 = new PositionTextureVertex(5.089072f ,3.8476162f ,-0.7290082f ,0.706055f ,0.268555f);
		PositionTextureVertex positiontexturevertex102 = new PositionTextureVertex(6.644272f ,3.8476162f ,-0.7290082f ,0.706055f ,0.268555f);
		PositionTextureVertex positiontexturevertex103 = new PositionTextureVertex(6.644272f ,-1.0755839f ,-0.7290082f ,0.706055f ,0.05761701f);
		this.MyquadList[25] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex100 ,positiontexturevertex101 ,positiontexturevertex102 ,positiontexturevertex103});
		PositionTextureVertex positiontexturevertex104 = new PositionTextureVertex(6.644272f ,-1.0755839f ,-0.7290082f ,0.706055f ,0.05761701f);
		PositionTextureVertex positiontexturevertex105 = new PositionTextureVertex(6.644272f ,3.8476162f ,-0.7290082f ,0.706055f ,0.268555f);
		PositionTextureVertex positiontexturevertex106 = new PositionTextureVertex(6.644272f ,3.8476162f ,0.7290077f ,0.936523f ,0.268555f);
		PositionTextureVertex positiontexturevertex107 = new PositionTextureVertex(6.644272f ,-1.0755839f ,0.7290077f ,0.936523f ,0.05761701f);
		this.MyquadList[26] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex104 ,positiontexturevertex105 ,positiontexturevertex106 ,positiontexturevertex107});
		PositionTextureVertex positiontexturevertex108 = new PositionTextureVertex(5.089072f ,-1.0755839f ,0.7290077f ,0.936523f ,0.05761701f);
		PositionTextureVertex positiontexturevertex109 = new PositionTextureVertex(5.089072f ,3.8476162f ,0.7290077f ,0.936523f ,0.268555f);
		PositionTextureVertex positiontexturevertex110 = new PositionTextureVertex(5.089072f ,3.8476162f ,-0.7290082f ,0.706055f ,0.268555f);
		PositionTextureVertex positiontexturevertex111 = new PositionTextureVertex(5.089072f ,-1.0755839f ,-0.7290082f ,0.706055f ,0.05761701f);
		this.MyquadList[27] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex108 ,positiontexturevertex109 ,positiontexturevertex110 ,positiontexturevertex111});
		
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void render(WorldRenderer p_178780_1_, float p_178780_2_)
	{
	    for (int i = 0; i < this.MyquadList.length; ++i)
	    {
	        this.MyquadList[i].draw(p_178780_1_, p_178780_2_);
	    }
	}
	
}

