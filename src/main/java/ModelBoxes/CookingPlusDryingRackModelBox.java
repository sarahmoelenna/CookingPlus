package ModelBoxes;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusDryingRackModelBox extends ModelBox {

	private TexturedQuad[] MyquadList;
	PositionTextureVertex[] MyvertexPositions;
	
	public CookingPlusDryingRackModelBox(ModelRenderer p_i46359_1_) {
		super(p_i46359_1_, 0, 0, 0, 0,0, 0, 0, 0, 0);
		MyquadList = new TexturedQuad[22];
		
		PositionTextureVertex positiontexturevertex0 = new PositionTextureVertex(3.2016f ,-5.9967976f ,-7.998399f ,0.692969f ,0.9999f);
		PositionTextureVertex positiontexturevertex1 = new PositionTextureVertex(3.2016f ,-5.9967995f ,8.0016f ,0.692969f ,1.00016594E-4f);
		PositionTextureVertex positiontexturevertex2 = new PositionTextureVertex(1.6032f ,-5.9983997f ,8.0f ,0.590727f ,1.9997358E-4f);
		PositionTextureVertex positiontexturevertex3 = new PositionTextureVertex(1.6032f ,-5.998398f ,-8.000001f ,0.590727f ,1.0f);
		this.MyquadList[0] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex0 ,positiontexturevertex1 ,positiontexturevertex2 ,positiontexturevertex3});
		PositionTextureVertex positiontexturevertex4 = new PositionTextureVertex(3.1999998f ,-4.3952f ,8.003201f ,0.692866f ,0.0f);
		PositionTextureVertex positiontexturevertex5 = new PositionTextureVertex(3.1999998f ,-4.3952f ,-7.9968004f ,0.692866f ,0.9998f);
		PositionTextureVertex positiontexturevertex6 = new PositionTextureVertex(1.6015997f ,-4.3968f ,-7.998399f ,0.590625f ,0.9999f);
		PositionTextureVertex positiontexturevertex7 = new PositionTextureVertex(1.6015997f ,-4.3968f ,8.0016f ,0.590625f ,1.00016594E-4f);
		this.MyquadList[1] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex4 ,positiontexturevertex5 ,positiontexturevertex6 ,positiontexturevertex7});
		PositionTextureVertex positiontexturevertex8 = new PositionTextureVertex(3.2016f ,-5.9967995f ,8.0016f ,0.692969f ,1.00016594E-4f);
		PositionTextureVertex positiontexturevertex9 = new PositionTextureVertex(3.2016f ,-5.9967976f ,-7.998399f ,0.692969f ,0.9999f);
		PositionTextureVertex positiontexturevertex10 = new PositionTextureVertex(8.0016f ,-5.9967976f ,-7.998399f ,1.0f ,0.9999f);
		PositionTextureVertex positiontexturevertex11 = new PositionTextureVertex(8.0016f ,-5.9967995f ,8.0016f ,1.0f ,1.00016594E-4f);
		this.MyquadList[2] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex8 ,positiontexturevertex9 ,positiontexturevertex10 ,positiontexturevertex11});
		PositionTextureVertex positiontexturevertex12 = new PositionTextureVertex(1.6015997f ,10.003201f ,8.0016f ,0.590625f ,1.00016594E-4f);
		PositionTextureVertex positiontexturevertex13 = new PositionTextureVertex(1.6015997f ,10.003201f ,-7.998398f ,0.590625f ,0.9999f);
		PositionTextureVertex positiontexturevertex14 = new PositionTextureVertex(0.0031995773f ,10.0016f ,-7.999998f ,0.488384f ,1.0f);
		PositionTextureVertex positiontexturevertex15 = new PositionTextureVertex(0.0031995773f ,10.0016f ,8.0f ,0.488384f ,1.9997358E-4f);
		this.MyquadList[3] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex12 ,positiontexturevertex13 ,positiontexturevertex14 ,positiontexturevertex15});
		PositionTextureVertex positiontexturevertex16 = new PositionTextureVertex(1.6000004f ,8.4048f ,-7.9967976f ,0.590523f ,0.9998f);
		PositionTextureVertex positiontexturevertex17 = new PositionTextureVertex(1.6000004f ,8.4048f ,8.003201f ,0.590523f ,0.0f);
		PositionTextureVertex positiontexturevertex18 = new PositionTextureVertex(0.0016002655f ,8.4032f ,8.0016f ,0.488281f ,1.00016594E-4f);
		PositionTextureVertex positiontexturevertex19 = new PositionTextureVertex(0.0016002655f ,8.4032f ,-7.998398f ,0.488281f ,0.9999f);
		this.MyquadList[4] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex16 ,positiontexturevertex17 ,positiontexturevertex18 ,positiontexturevertex19});
		PositionTextureVertex positiontexturevertex20 = new PositionTextureVertex(1.6015997f ,10.003201f ,8.0016f ,0.590625f ,1.00016594E-4f);
		PositionTextureVertex positiontexturevertex21 = new PositionTextureVertex(8.0016f ,10.003201f ,8.0016f ,1.0f ,1.00016594E-4f);
		PositionTextureVertex positiontexturevertex22 = new PositionTextureVertex(8.0016f ,10.003201f ,-7.998398f ,1.0f ,0.9999f);
		PositionTextureVertex positiontexturevertex23 = new PositionTextureVertex(1.6015997f ,10.003201f ,-7.998398f ,0.590625f ,0.9999f);
		this.MyquadList[5] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex20 ,positiontexturevertex21 ,positiontexturevertex22 ,positiontexturevertex23});
		PositionTextureVertex positiontexturevertex24 = new PositionTextureVertex(3.1999998f ,-4.3952f ,-7.9968004f ,0.690522f ,0.100189984f);
		PositionTextureVertex positiontexturevertex25 = new PositionTextureVertex(1.6000004f ,8.4048f ,-7.9967976f ,0.587397f ,0.90011f);
		PositionTextureVertex positiontexturevertex26 = new PositionTextureVertex(8.0f ,8.4048f ,-7.9967976f ,0.999897f ,0.90011f);
		PositionTextureVertex positiontexturevertex27 = new PositionTextureVertex(8.0f ,-4.3952f ,-7.9968004f ,0.999897f ,0.100189984f);
		this.MyquadList[6] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex24 ,positiontexturevertex25 ,positiontexturevertex26 ,positiontexturevertex27});
		PositionTextureVertex positiontexturevertex28 = new PositionTextureVertex(8.0f ,-4.3952f ,8.003201f ,0.999897f ,0.100189984f);
		PositionTextureVertex positiontexturevertex29 = new PositionTextureVertex(8.0f ,8.4048f ,8.003201f ,0.999897f ,0.90011f);
		PositionTextureVertex positiontexturevertex30 = new PositionTextureVertex(1.6000004f ,8.4048f ,8.003201f ,0.587397f ,0.90011f);
		PositionTextureVertex positiontexturevertex31 = new PositionTextureVertex(3.1999998f ,-4.3952f ,8.003201f ,0.690522f ,0.100189984f);
		this.MyquadList[7] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex28 ,positiontexturevertex29 ,positiontexturevertex30 ,positiontexturevertex31});
		PositionTextureVertex positiontexturevertex32 = new PositionTextureVertex(1.6000004f ,8.4048f ,8.003201f ,0.587397f ,0.90011f);
		PositionTextureVertex positiontexturevertex33 = new PositionTextureVertex(8.0f ,8.4048f ,8.003201f ,0.999897f ,0.90011f);
		PositionTextureVertex positiontexturevertex34 = new PositionTextureVertex(8.0016f ,10.003201f ,8.0016f ,1.0f ,1.0f);
		PositionTextureVertex positiontexturevertex35 = new PositionTextureVertex(1.6015997f ,10.003201f ,8.0016f ,0.5875f ,1.0f);
		this.MyquadList[8] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex32 ,positiontexturevertex33 ,positiontexturevertex34 ,positiontexturevertex35});
		PositionTextureVertex positiontexturevertex36 = new PositionTextureVertex(8.0f ,8.4048f ,-7.9967976f ,0.999897f ,0.90011f);
		PositionTextureVertex positiontexturevertex37 = new PositionTextureVertex(1.6000004f ,8.4048f ,-7.9967976f ,0.587397f ,0.90011f);
		PositionTextureVertex positiontexturevertex38 = new PositionTextureVertex(1.6015997f ,10.003201f ,-7.998398f ,0.5875f ,1.0f);
		PositionTextureVertex positiontexturevertex39 = new PositionTextureVertex(8.0016f ,10.003201f ,-7.998398f ,1.0f ,1.0f);
		this.MyquadList[9] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex36 ,positiontexturevertex37 ,positiontexturevertex38 ,positiontexturevertex39});
		PositionTextureVertex positiontexturevertex40 = new PositionTextureVertex(1.6000004f ,8.4048f ,8.003201f ,0.587397f ,0.90011f);
		PositionTextureVertex positiontexturevertex41 = new PositionTextureVertex(1.6015997f ,10.003201f ,8.0016f ,0.5875f ,1.0f);
		PositionTextureVertex positiontexturevertex42 = new PositionTextureVertex(0.0031995773f ,10.0016f ,8.0f ,0.484478f ,0.9999f);
		PositionTextureVertex positiontexturevertex43 = new PositionTextureVertex(0.0016002655f ,8.4032f ,8.0016f ,0.484375f ,0.90001f);
		this.MyquadList[10] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex40 ,positiontexturevertex41 ,positiontexturevertex42 ,positiontexturevertex43});
		PositionTextureVertex positiontexturevertex44 = new PositionTextureVertex(1.6015997f ,10.003201f ,-7.998398f ,0.5875f ,1.0f);
		PositionTextureVertex positiontexturevertex45 = new PositionTextureVertex(1.6000004f ,8.4048f ,-7.9967976f ,0.587397f ,0.90011f);
		PositionTextureVertex positiontexturevertex46 = new PositionTextureVertex(0.0016002655f ,8.4032f ,-7.998398f ,0.484375f ,0.90001f);
		PositionTextureVertex positiontexturevertex47 = new PositionTextureVertex(0.0031995773f ,10.0016f ,-7.999998f ,0.484478f ,0.9999f);
		this.MyquadList[11] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex44 ,positiontexturevertex45 ,positiontexturevertex46 ,positiontexturevertex47});
		PositionTextureVertex positiontexturevertex48 = new PositionTextureVertex(3.1999998f ,-4.3952f ,-7.9968004f ,0.690522f ,0.100189984f);
		PositionTextureVertex positiontexturevertex49 = new PositionTextureVertex(8.0f ,-4.3952f ,-7.9968004f ,0.999897f ,0.100189984f);
		PositionTextureVertex positiontexturevertex50 = new PositionTextureVertex(8.0016f ,-5.9967976f ,-7.998399f ,1.0f ,1.00016594E-4f);
		PositionTextureVertex positiontexturevertex51 = new PositionTextureVertex(3.2016f ,-5.9967976f ,-7.998399f ,0.690625f ,1.00016594E-4f);
		this.MyquadList[12] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex48 ,positiontexturevertex49 ,positiontexturevertex50 ,positiontexturevertex51});
		PositionTextureVertex positiontexturevertex52 = new PositionTextureVertex(8.0f ,-4.3952f ,8.003201f ,0.999897f ,0.100189984f);
		PositionTextureVertex positiontexturevertex53 = new PositionTextureVertex(3.1999998f ,-4.3952f ,8.003201f ,0.690522f ,0.100189984f);
		PositionTextureVertex positiontexturevertex54 = new PositionTextureVertex(3.2016f ,-5.9967995f ,8.0016f ,0.690625f ,1.00016594E-4f);
		PositionTextureVertex positiontexturevertex55 = new PositionTextureVertex(8.0016f ,-5.9967995f ,8.0016f ,1.0f ,1.00016594E-4f);
		this.MyquadList[13] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex52 ,positiontexturevertex53 ,positiontexturevertex54 ,positiontexturevertex55});
		PositionTextureVertex positiontexturevertex56 = new PositionTextureVertex(3.1999998f ,-4.3952f ,-7.9968004f ,0.690522f ,0.100189984f);
		PositionTextureVertex positiontexturevertex57 = new PositionTextureVertex(3.2016f ,-5.9967976f ,-7.998399f ,0.690625f ,1.00016594E-4f);
		PositionTextureVertex positiontexturevertex58 = new PositionTextureVertex(1.6032f ,-5.998398f ,-8.000001f ,0.587603f ,0.0f);
		PositionTextureVertex positiontexturevertex59 = new PositionTextureVertex(1.6015997f ,-4.3968f ,-7.998399f ,0.5875f ,0.10009003f);
		this.MyquadList[14] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex56 ,positiontexturevertex57 ,positiontexturevertex58 ,positiontexturevertex59});
		PositionTextureVertex positiontexturevertex60 = new PositionTextureVertex(3.2016f ,-5.9967995f ,8.0016f ,0.690625f ,1.00016594E-4f);
		PositionTextureVertex positiontexturevertex61 = new PositionTextureVertex(3.1999998f ,-4.3952f ,8.003201f ,0.690522f ,0.100189984f);
		PositionTextureVertex positiontexturevertex62 = new PositionTextureVertex(1.6015997f ,-4.3968f ,8.0016f ,0.5875f ,0.10009003f);
		PositionTextureVertex positiontexturevertex63 = new PositionTextureVertex(1.6032f ,-5.9983997f ,8.0f ,0.587603f ,0.0f);
		this.MyquadList[15] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex60 ,positiontexturevertex61 ,positiontexturevertex62 ,positiontexturevertex63});
		PositionTextureVertex positiontexturevertex64 = new PositionTextureVertex(1.6015997f ,-4.3968f ,8.0016f ,9.99966E-5f ,0.10009003f);
		PositionTextureVertex positiontexturevertex65 = new PositionTextureVertex(1.6015997f ,-4.3968f ,-7.998399f ,0.9999f ,0.10009003f);
		PositionTextureVertex positiontexturevertex66 = new PositionTextureVertex(1.6032f ,-5.998398f ,-8.000001f ,1.0f ,0.0f);
		PositionTextureVertex positiontexturevertex67 = new PositionTextureVertex(1.6032f ,-5.9983997f ,8.0f ,1.99993E-4f ,0.0f);
		this.MyquadList[16] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex64 ,positiontexturevertex65 ,positiontexturevertex66 ,positiontexturevertex67});
		PositionTextureVertex positiontexturevertex68 = new PositionTextureVertex(8.0f ,-4.3952f ,-7.9968004f ,0.9998f ,0.100189984f);
		PositionTextureVertex positiontexturevertex69 = new PositionTextureVertex(8.0f ,-4.3952f ,8.003201f ,0.0f ,0.100189984f);
		PositionTextureVertex positiontexturevertex70 = new PositionTextureVertex(8.0016f ,-5.9967995f ,8.0016f ,9.99966E-5f ,1.00016594E-4f);
		PositionTextureVertex positiontexturevertex71 = new PositionTextureVertex(8.0016f ,-5.9967976f ,-7.998399f ,0.9999f ,1.00016594E-4f);
		this.MyquadList[17] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex68 ,positiontexturevertex69 ,positiontexturevertex70 ,positiontexturevertex71});
		PositionTextureVertex positiontexturevertex72 = new PositionTextureVertex(0.0016002655f ,8.4032f ,-7.998398f ,0.9999f ,0.90001f);
		PositionTextureVertex positiontexturevertex73 = new PositionTextureVertex(0.0016002655f ,8.4032f ,8.0016f ,9.99966E-5f ,0.90001f);
		PositionTextureVertex positiontexturevertex74 = new PositionTextureVertex(0.0031995773f ,10.0016f ,8.0f ,1.99993E-4f ,0.9999f);
		PositionTextureVertex positiontexturevertex75 = new PositionTextureVertex(0.0031995773f ,10.0016f ,-7.999998f ,1.0f ,0.9999f);
		this.MyquadList[18] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex72 ,positiontexturevertex73 ,positiontexturevertex74 ,positiontexturevertex75});
		PositionTextureVertex positiontexturevertex76 = new PositionTextureVertex(8.0f ,8.4048f ,8.003201f ,0.0f ,0.90011f);
		PositionTextureVertex positiontexturevertex77 = new PositionTextureVertex(8.0f ,8.4048f ,-7.9967976f ,0.9998f ,0.90011f);
		PositionTextureVertex positiontexturevertex78 = new PositionTextureVertex(8.0016f ,10.003201f ,-7.998398f ,0.9999f ,1.0f);
		PositionTextureVertex positiontexturevertex79 = new PositionTextureVertex(8.0016f ,10.003201f ,8.0016f ,9.99966E-5f ,1.0f);
		this.MyquadList[19] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex76 ,positiontexturevertex77 ,positiontexturevertex78 ,positiontexturevertex79});
		PositionTextureVertex positiontexturevertex80 = new PositionTextureVertex(8.0f ,-4.3952f ,-7.9968004f ,0.9998f ,0.100189984f);
		PositionTextureVertex positiontexturevertex81 = new PositionTextureVertex(8.0f ,8.4048f ,-7.9967976f ,0.9998f ,0.90011f);
		PositionTextureVertex positiontexturevertex82 = new PositionTextureVertex(8.0f ,8.4048f ,8.003201f ,0.0f ,0.90011f);
		PositionTextureVertex positiontexturevertex83 = new PositionTextureVertex(8.0f ,-4.3952f ,8.003201f ,0.0f ,0.100189984f);
		this.MyquadList[20] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex80 ,positiontexturevertex81 ,positiontexturevertex82 ,positiontexturevertex83});
		PositionTextureVertex positiontexturevertex84 = new PositionTextureVertex(3.1999998f ,-4.3952f ,8.003201f ,0.0f ,0.100189984f);
		PositionTextureVertex positiontexturevertex85 = new PositionTextureVertex(1.6000004f ,8.4048f ,8.003201f ,0.0f ,0.90011f);
		PositionTextureVertex positiontexturevertex86 = new PositionTextureVertex(1.6000004f ,8.4048f ,-7.9967976f ,0.9998f ,0.90011f);
		PositionTextureVertex positiontexturevertex87 = new PositionTextureVertex(3.1999998f ,-4.3952f ,-7.9968004f ,0.9998f ,0.100189984f);
		this.MyquadList[21] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex84 ,positiontexturevertex85 ,positiontexturevertex86 ,positiontexturevertex87});
	
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
