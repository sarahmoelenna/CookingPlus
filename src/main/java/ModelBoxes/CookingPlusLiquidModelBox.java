package ModelBoxes;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.PositionTextureVertex;
import net.minecraft.client.model.TexturedQuad;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusLiquidModelBox extends ModelBox {

	private TexturedQuad[] MyquadList;
	PositionTextureVertex[] MyvertexPositions;
	
	public CookingPlusLiquidModelBox(ModelRenderer p_i46359_1_) {
		super(p_i46359_1_, 0, 0, 0, 0,0, 0, 0, 0, 0);
		MyquadList = new TexturedQuad[1];
		
		PositionTextureVertex positiontexturevertex0 = new PositionTextureVertex(-8f ,-4.3968f ,-8 ,0.0f ,1.0f);
		PositionTextureVertex positiontexturevertex1 = new PositionTextureVertex(8 ,-4.3968f ,-8 ,1.0f ,1.0f);
		PositionTextureVertex positiontexturevertex2 = new PositionTextureVertex(8 ,-4.3968f ,8 ,1.0f ,0.0f);
		PositionTextureVertex positiontexturevertex3 = new PositionTextureVertex(-8 ,-4.3968f ,8 ,0.0f ,0.0f);
		this.MyquadList[0] = new TexturedQuad(new PositionTextureVertex[] {positiontexturevertex0 ,positiontexturevertex1 ,positiontexturevertex2 ,positiontexturevertex3});
		
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
