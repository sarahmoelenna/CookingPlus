package CookingPlus.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import ModelBoxes.CookingPlusLaserInnerModelBox;
import ModelBoxes.CookingPlusLaserOuterModelBox;

public class CookingPlusLaser extends ModelBase
{
  //fields
    ModelRenderer Shape15;
    ModelRenderer Shape16;
  
  public CookingPlusLaser()
  {
    textureWidth = 32;
    textureHeight = 32;
 
      Shape15 = new ModelRenderer(this, 0, 0);
      //Shape15.addBox(-0.5F, 0F, -0.5F, 1, 1, 1);
      Shape15.cubeList.add(new CookingPlusLaserInnerModelBox(Shape15));
      Shape15.setRotationPoint(0F, 14F, 0F);
      Shape15.setTextureSize(32, 32);
      Shape15.mirror = true;
      setRotation(Shape15, 0F, 0F, 0F);
      
      Shape16 = new ModelRenderer(this, 0, 0);
      //Shape15.addBox(-0.5F, 0F, -0.5F, 1, 1, 1);
      Shape16.cubeList.add(new CookingPlusLaserOuterModelBox(Shape16));
      Shape16.setRotationPoint(0F, 14F, 0F);
      Shape16.setTextureSize(32, 32);
      Shape16.mirror = true;
      setRotation(Shape16, 0F, 0F, 0F);
      
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);

    Shape15.render(f5);
    Shape16.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
  }

  public void RenderModel(float f5)
  {
	  //GL11.glDisable(GL11.GL_CULL_FACE);
	  Shape15.render(f5);
	  Shape16.render(f5);
	  //GL11.glEnable(GL11.GL_CULL_FACE);
  }
}
