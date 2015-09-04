package ModelBoxes;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusHydrophonicFanModelBox extends ModelBox {

	private TexturedQuad[] MyquadList;
	PositionTextureVertex[] MyvertexPositions;
	
	public CookingPlusHydrophonicFanModelBox(ModelRenderer p_i46359_1_) {
		super(p_i46359_1_, 0, 0, 0, 0,0, 0, 0, 0, 0);
		MyquadList = new TexturedQuad[24];
		
		PositionTextureVertex positiontexturevertex0 = new PositionTextureVertex(0.87808037f ,5.5811844f ,6.61856f ,0.828604f ,0.577923f);
		PositionTextureVertex positiontexturevertex1 = new PositionTextureVertex(0.87808037f ,5.5811844f ,7.784384f ,0.828604f ,0.577923f);
		PositionTextureVertex positiontexturevertex2 = new PositionTextureVertex(-0.8209281f ,5.5811844f ,7.784384f ,0.794962f ,0.577923f);
		PositionTextureVertex positiontexturevertex3 = new PositionTextureVertex(-0.8209281f ,5.5811844f ,6.61856f ,0.794962f ,0.577923f);
		this.MyquadList[0] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex0 ,positiontexturevertex1 ,positiontexturevertex2 ,positiontexturevertex3});
		this.MyquadList[0].flipFace();
		PositionTextureVertex positiontexturevertex4 = new PositionTextureVertex(-0.85819197f ,1.8186722f ,6.617216f ,0.794224f ,0.49578202f);
		PositionTextureVertex positiontexturevertex5 = new PositionTextureVertex(0.84081554f ,1.8186722f ,6.617216f ,0.827866f ,0.49578202f);
		PositionTextureVertex positiontexturevertex6 = new PositionTextureVertex(0.87808037f ,5.5811844f ,6.61856f ,0.828604f ,0.577923f);
		PositionTextureVertex positiontexturevertex7 = new PositionTextureVertex(-0.8209281f ,5.5811844f ,6.61856f ,0.794962f ,0.577923f);
		this.MyquadList[1] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex4 ,positiontexturevertex5 ,positiontexturevertex6 ,positiontexturevertex7});
		this.MyquadList[1].flipFace();
		PositionTextureVertex positiontexturevertex8 = new PositionTextureVertex(-0.85819197f ,1.8186722f ,7.78304f ,0.794224f ,0.49578202f);
		PositionTextureVertex positiontexturevertex9 = new PositionTextureVertex(-0.85819197f ,1.8186722f ,6.617216f ,0.794224f ,0.49578202f);
		PositionTextureVertex positiontexturevertex10 = new PositionTextureVertex(-0.8209281f ,5.5811844f ,6.61856f ,0.794962f ,0.577923f);
		PositionTextureVertex positiontexturevertex11 = new PositionTextureVertex(-0.8209281f ,5.5811844f ,7.784384f ,0.794962f ,0.577923f);
		this.MyquadList[2] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex8 ,positiontexturevertex9 ,positiontexturevertex10 ,positiontexturevertex11});
		this.MyquadList[2].flipFace();
		PositionTextureVertex positiontexturevertex12 = new PositionTextureVertex(0.84081554f ,1.8186722f ,7.78304f ,0.827866f ,0.49578202f);
		PositionTextureVertex positiontexturevertex13 = new PositionTextureVertex(-0.85819197f ,1.8186722f ,7.78304f ,0.794224f ,0.49578202f);
		PositionTextureVertex positiontexturevertex14 = new PositionTextureVertex(-0.8209281f ,5.5811844f ,7.784384f ,0.794962f ,0.577923f);
		PositionTextureVertex positiontexturevertex15 = new PositionTextureVertex(0.87808037f ,5.5811844f ,7.784384f ,0.828604f ,0.577923f);
		this.MyquadList[3] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex12 ,positiontexturevertex13 ,positiontexturevertex14 ,positiontexturevertex15});
		this.MyquadList[3].flipFace();
		PositionTextureVertex positiontexturevertex16 = new PositionTextureVertex(0.84081554f ,1.8186722f ,6.617216f ,0.827866f ,0.49578202f);
		PositionTextureVertex positiontexturevertex17 = new PositionTextureVertex(0.84081554f ,1.8186722f ,7.78304f ,0.827866f ,0.49578202f);
		PositionTextureVertex positiontexturevertex18 = new PositionTextureVertex(0.87808037f ,5.5811844f ,7.784384f ,0.828604f ,0.577923f);
		PositionTextureVertex positiontexturevertex19 = new PositionTextureVertex(0.87808037f ,5.5811844f ,6.61856f ,0.828604f ,0.577923f);
		this.MyquadList[4] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex16 ,positiontexturevertex17 ,positiontexturevertex18 ,positiontexturevertex19});
		this.MyquadList[4].flipFace();
		PositionTextureVertex positiontexturevertex20 = new PositionTextureVertex(4.062624f ,-3.3287039f ,6.61856f ,0.891661f ,0.383408f);
		PositionTextureVertex positiontexturevertex21 = new PositionTextureVertex(4.062624f ,-3.3287039f ,7.784384f ,0.891661f ,0.383408f);
		PositionTextureVertex positiontexturevertex22 = new PositionTextureVertex(4.9121284f ,-1.8573122f ,7.784384f ,0.908482f ,0.41553098f);
		PositionTextureVertex positiontexturevertex23 = new PositionTextureVertex(4.9121284f ,-1.8573122f ,6.61856f ,0.908482f ,0.41553098f);
		this.MyquadList[5] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex20 ,positiontexturevertex21 ,positiontexturevertex22 ,positiontexturevertex23});
		this.MyquadList[5].flipFace();
		PositionTextureVertex positiontexturevertex24 = new PositionTextureVertex(1.69032f ,0.34727955f ,6.617216f ,0.844687f ,0.46366f);
		PositionTextureVertex positiontexturevertex25 = new PositionTextureVertex(0.84081554f ,-1.1241121f ,6.617216f ,0.827866f ,0.431538f);
		PositionTextureVertex positiontexturevertex26 = new PositionTextureVertex(4.062624f ,-3.3287039f ,6.61856f ,0.891661f ,0.383408f);
		PositionTextureVertex positiontexturevertex27 = new PositionTextureVertex(4.9121284f ,-1.8573122f ,6.61856f ,0.908482f ,0.41553098f);
		this.MyquadList[6] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex24 ,positiontexturevertex25 ,positiontexturevertex26 ,positiontexturevertex27});
		this.MyquadList[6].flipFace();
		PositionTextureVertex positiontexturevertex28 = new PositionTextureVertex(1.69032f ,0.34727955f ,7.78304f ,0.844687f ,0.46366f);
		PositionTextureVertex positiontexturevertex29 = new PositionTextureVertex(1.69032f ,0.34727955f ,6.617216f ,0.844687f ,0.46366f);
		PositionTextureVertex positiontexturevertex30 = new PositionTextureVertex(4.9121284f ,-1.8573122f ,6.61856f ,0.908482f ,0.41553098f);
		PositionTextureVertex positiontexturevertex31 = new PositionTextureVertex(4.9121284f ,-1.8573122f ,7.784384f ,0.908482f ,0.41553098f);
		this.MyquadList[7] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex28 ,positiontexturevertex29 ,positiontexturevertex30 ,positiontexturevertex31});
		this.MyquadList[7].flipFace();
		PositionTextureVertex positiontexturevertex32 = new PositionTextureVertex(0.84081554f ,-1.1241121f ,7.78304f ,0.827866f ,0.431538f);
		PositionTextureVertex positiontexturevertex33 = new PositionTextureVertex(1.69032f ,0.34727955f ,7.78304f ,0.844687f ,0.46366f);
		PositionTextureVertex positiontexturevertex34 = new PositionTextureVertex(4.9121284f ,-1.8573122f ,7.784384f ,0.908482f ,0.41553098f);
		PositionTextureVertex positiontexturevertex35 = new PositionTextureVertex(4.062624f ,-3.3287039f ,7.784384f ,0.891661f ,0.383408f);
		this.MyquadList[8] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex32 ,positiontexturevertex33 ,positiontexturevertex34 ,positiontexturevertex35});
		this.MyquadList[8].flipFace();
		PositionTextureVertex positiontexturevertex36 = new PositionTextureVertex(0.84081554f ,-1.1241121f ,6.617216f ,0.827866f ,0.431538f);
		PositionTextureVertex positiontexturevertex37 = new PositionTextureVertex(0.84081554f ,-1.1241121f ,7.78304f ,0.827866f ,0.431538f);
		PositionTextureVertex positiontexturevertex38 = new PositionTextureVertex(4.062624f ,-3.3287039f ,7.784384f ,0.891661f ,0.383408f);
		PositionTextureVertex positiontexturevertex39 = new PositionTextureVertex(4.062624f ,-3.3287039f ,6.61856f ,0.891661f ,0.383408f);
		this.MyquadList[9] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex36 ,positiontexturevertex37 ,positiontexturevertex38 ,positiontexturevertex39});
		this.MyquadList[9].flipFace();
		PositionTextureVertex positiontexturevertex40 = new PositionTextureVertex(-4.9112797f ,-1.829216f ,6.61856f ,0.713968f ,0.416144f);
		PositionTextureVertex positiontexturevertex41 = new PositionTextureVertex(-4.9112797f ,-1.829216f ,7.784384f ,0.713968f ,0.416144f);
		PositionTextureVertex positiontexturevertex42 = new PositionTextureVertex(-4.061776f ,-3.3006077f ,7.784384f ,0.730789f ,0.384022f);
		PositionTextureVertex positiontexturevertex43 = new PositionTextureVertex(-4.061776f ,-3.3006077f ,6.61856f ,0.730789f ,0.384022f);
		this.MyquadList[10] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex40 ,positiontexturevertex41 ,positiontexturevertex42 ,positiontexturevertex43});
		this.MyquadList[10].flipFace();
		PositionTextureVertex positiontexturevertex44 = new PositionTextureVertex(-0.85819197f ,-1.1241121f ,6.617216f ,0.794224f ,0.431538f);
		PositionTextureVertex positiontexturevertex45 = new PositionTextureVertex(-1.707696f ,0.34727955f ,6.617216f ,0.777403f ,0.46366f);
		PositionTextureVertex positiontexturevertex46 = new PositionTextureVertex(-4.9112797f ,-1.829216f ,6.61856f ,0.713968f ,0.416144f);
		PositionTextureVertex positiontexturevertex47 = new PositionTextureVertex(-4.061776f ,-3.3006077f ,6.61856f ,0.730789f ,0.384022f);
		this.MyquadList[11] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex44 ,positiontexturevertex45 ,positiontexturevertex46 ,positiontexturevertex47});
		this.MyquadList[11].flipFace();
		PositionTextureVertex positiontexturevertex48 = new PositionTextureVertex(-0.85819197f ,-1.1241121f ,7.78304f ,0.794224f ,0.431538f);
		PositionTextureVertex positiontexturevertex49 = new PositionTextureVertex(-0.85819197f ,-1.1241121f ,6.617216f ,0.794224f ,0.431538f);
		PositionTextureVertex positiontexturevertex50 = new PositionTextureVertex(-4.061776f ,-3.3006077f ,6.61856f ,0.730789f ,0.384022f);
		PositionTextureVertex positiontexturevertex51 = new PositionTextureVertex(-4.061776f ,-3.3006077f ,7.784384f ,0.730789f ,0.384022f);
		this.MyquadList[12] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex48 ,positiontexturevertex49 ,positiontexturevertex50 ,positiontexturevertex51});
		this.MyquadList[12].flipFace();
		PositionTextureVertex positiontexturevertex52 = new PositionTextureVertex(-1.707696f ,0.34727955f ,7.78304f ,0.777403f ,0.46366f);
		PositionTextureVertex positiontexturevertex53 = new PositionTextureVertex(-0.85819197f ,-1.1241121f ,7.78304f ,0.794224f ,0.431538f);
		PositionTextureVertex positiontexturevertex54 = new PositionTextureVertex(-4.061776f ,-3.3006077f ,7.784384f ,0.730789f ,0.384022f);
		PositionTextureVertex positiontexturevertex55 = new PositionTextureVertex(-4.9112797f ,-1.829216f ,7.784384f ,0.713968f ,0.416144f);
		this.MyquadList[13] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex52 ,positiontexturevertex53 ,positiontexturevertex54 ,positiontexturevertex55});
		this.MyquadList[13].flipFace();
		PositionTextureVertex positiontexturevertex56 = new PositionTextureVertex(-1.707696f ,0.34727955f ,6.617216f ,0.777403f ,0.46366f);
		PositionTextureVertex positiontexturevertex57 = new PositionTextureVertex(-1.707696f ,0.34727955f ,7.78304f ,0.777403f ,0.46366f);
		PositionTextureVertex positiontexturevertex58 = new PositionTextureVertex(-4.9112797f ,-1.829216f ,7.784384f ,0.713968f ,0.416144f);
		PositionTextureVertex positiontexturevertex59 = new PositionTextureVertex(-4.9112797f ,-1.829216f ,6.61856f ,0.713968f ,0.416144f);
		this.MyquadList[14] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex56 ,positiontexturevertex57 ,positiontexturevertex58 ,positiontexturevertex59});
		this.MyquadList[14].flipFace();
		PositionTextureVertex positiontexturevertex60 = new PositionTextureVertex(0.84081554f ,1.8186722f ,6.617216f ,0.827866f ,0.49578202f);
		PositionTextureVertex positiontexturevertex61 = new PositionTextureVertex(-0.85819197f ,1.8186722f ,6.617216f ,0.794224f ,0.49578202f);
		PositionTextureVertex positiontexturevertex62 = new PositionTextureVertex(-1.707696f ,0.34727955f ,6.617216f ,0.777403f ,0.46366f);
		PositionTextureVertex positiontexturevertex63 = new PositionTextureVertex(-0.008687973f ,0.34727955f ,6.617216f ,0.811045f ,0.46366f);
		this.MyquadList[15] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex60 ,positiontexturevertex61 ,positiontexturevertex62 ,positiontexturevertex63});
		this.MyquadList[15].flipFace();
		PositionTextureVertex positiontexturevertex64 = new PositionTextureVertex(0.84081554f ,1.8186722f ,6.617216f ,0.827866f ,0.49578202f);
		PositionTextureVertex positiontexturevertex65 = new PositionTextureVertex(-0.008687973f ,0.34727955f ,6.617216f ,0.811045f ,0.46366f);
		PositionTextureVertex positiontexturevertex66 = new PositionTextureVertex(0.84081554f ,-1.1241121f ,6.617216f ,0.827866f ,0.431538f);
		PositionTextureVertex positiontexturevertex67 = new PositionTextureVertex(1.69032f ,0.34727955f ,6.617216f ,0.844687f ,0.46366f);
		this.MyquadList[16] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex64 ,positiontexturevertex65 ,positiontexturevertex66 ,positiontexturevertex67});
		this.MyquadList[16].flipFace();
		PositionTextureVertex positiontexturevertex68 = new PositionTextureVertex(-1.707696f ,0.34727955f ,6.617216f ,0.777403f ,0.46366f);
		PositionTextureVertex positiontexturevertex69 = new PositionTextureVertex(-0.85819197f ,-1.1241121f ,6.617216f ,0.794224f ,0.431538f);
		PositionTextureVertex positiontexturevertex70 = new PositionTextureVertex(0.84081554f ,-1.1241121f ,6.617216f ,0.827866f ,0.431538f);
		PositionTextureVertex positiontexturevertex71 = new PositionTextureVertex(-0.008687973f ,0.34727955f ,6.617216f ,0.811045f ,0.46366f);
		this.MyquadList[17] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex68 ,positiontexturevertex69 ,positiontexturevertex70 ,positiontexturevertex71});
		this.MyquadList[17].flipFace();
		PositionTextureVertex positiontexturevertex72 = new PositionTextureVertex(-0.85819197f ,1.8186722f ,7.78304f ,0.794224f ,0.49578202f);
		PositionTextureVertex positiontexturevertex73 = new PositionTextureVertex(-0.008687973f ,0.34727955f ,7.78304f ,0.811045f ,0.46366f);
		PositionTextureVertex positiontexturevertex74 = new PositionTextureVertex(-0.85819197f ,-1.1241121f ,7.78304f ,0.794224f ,0.431538f);
		PositionTextureVertex positiontexturevertex75 = new PositionTextureVertex(-1.707696f ,0.34727955f ,7.78304f ,0.777403f ,0.46366f);
		this.MyquadList[18] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex72 ,positiontexturevertex73 ,positiontexturevertex74 ,positiontexturevertex75});
		this.MyquadList[18].flipFace();
		PositionTextureVertex positiontexturevertex76 = new PositionTextureVertex(-0.85819197f ,1.8186722f ,7.78304f ,0.794224f ,0.49578202f);
		PositionTextureVertex positiontexturevertex77 = new PositionTextureVertex(0.84081554f ,1.8186722f ,7.78304f ,0.827866f ,0.49578202f);
		PositionTextureVertex positiontexturevertex78 = new PositionTextureVertex(1.69032f ,0.34727955f ,7.78304f ,0.844687f ,0.46366f);
		PositionTextureVertex positiontexturevertex79 = new PositionTextureVertex(-0.008687973f ,0.34727955f ,7.78304f ,0.811045f ,0.46366f);
		this.MyquadList[19] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex76 ,positiontexturevertex77 ,positiontexturevertex78 ,positiontexturevertex79});
		this.MyquadList[19].flipFace();
		PositionTextureVertex positiontexturevertex80 = new PositionTextureVertex(0.84081554f ,-1.1241121f ,7.78304f ,0.827866f ,0.431538f);
		PositionTextureVertex positiontexturevertex81 = new PositionTextureVertex(-0.85819197f ,-1.1241121f ,7.78304f ,0.794224f ,0.431538f);
		PositionTextureVertex positiontexturevertex82 = new PositionTextureVertex(-0.008687973f ,0.34727955f ,7.78304f ,0.811045f ,0.46366f);
		PositionTextureVertex positiontexturevertex83 = new PositionTextureVertex(1.69032f ,0.34727955f ,7.78304f ,0.844687f ,0.46366f);
		this.MyquadList[20] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex80 ,positiontexturevertex81 ,positiontexturevertex82 ,positiontexturevertex83});
		this.MyquadList[20].flipFace();
		PositionTextureVertex positiontexturevertex84 = new PositionTextureVertex(1.69032f ,0.34727955f ,6.617216f ,0.844687f ,0.46366f);
		PositionTextureVertex positiontexturevertex85 = new PositionTextureVertex(1.69032f ,0.34727955f ,7.78304f ,0.844687f ,0.46366f);
		PositionTextureVertex positiontexturevertex86 = new PositionTextureVertex(0.84081554f ,1.8186722f ,7.78304f ,0.827866f ,0.49578202f);
		PositionTextureVertex positiontexturevertex87 = new PositionTextureVertex(0.84081554f ,1.8186722f ,6.617216f ,0.827866f ,0.49578202f);
		this.MyquadList[21] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex84 ,positiontexturevertex85 ,positiontexturevertex86 ,positiontexturevertex87});
		this.MyquadList[21].flipFace();
		PositionTextureVertex positiontexturevertex88 = new PositionTextureVertex(-0.85819197f ,1.8186722f ,6.617216f ,0.794224f ,0.49578202f);
		PositionTextureVertex positiontexturevertex89 = new PositionTextureVertex(-0.85819197f ,1.8186722f ,7.78304f ,0.794224f ,0.49578202f);
		PositionTextureVertex positiontexturevertex90 = new PositionTextureVertex(-1.707696f ,0.34727955f ,7.78304f ,0.777403f ,0.46366f);
		PositionTextureVertex positiontexturevertex91 = new PositionTextureVertex(-1.707696f ,0.34727955f ,6.617216f ,0.777403f ,0.46366f);
		this.MyquadList[22] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex88 ,positiontexturevertex89 ,positiontexturevertex90 ,positiontexturevertex91});
		this.MyquadList[22].flipFace();
		PositionTextureVertex positiontexturevertex92 = new PositionTextureVertex(-0.85819197f ,-1.1241121f ,6.617216f ,0.794224f ,0.431538f);
		PositionTextureVertex positiontexturevertex93 = new PositionTextureVertex(-0.85819197f ,-1.1241121f ,7.78304f ,0.794224f ,0.431538f);
		PositionTextureVertex positiontexturevertex94 = new PositionTextureVertex(0.84081554f ,-1.1241121f ,7.78304f ,0.827866f ,0.431538f);
		PositionTextureVertex positiontexturevertex95 = new PositionTextureVertex(0.84081554f ,-1.1241121f ,6.617216f ,0.827866f ,0.431538f);
		this.MyquadList[23] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex92 ,positiontexturevertex93 ,positiontexturevertex94 ,positiontexturevertex95});
		this.MyquadList[23].flipFace();
		
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
