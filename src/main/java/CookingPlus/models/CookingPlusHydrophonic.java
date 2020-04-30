package CookingPlus.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import ModelBoxes.CookingPlusHydrophonicFanModelBox;
import ModelBoxes.CookingPlusHyrophonicModelBox;

public class CookingPlusHydrophonic extends ModelBase
{
    ModelRenderer Shape15;
    ModelRenderer Shape1;
  
  public CookingPlusHydrophonic()
  {
    textureWidth = 64;
    textureHeight = 64;
 
      Shape15 = new ModelRenderer(this, 0, 0);
      Shape15.cubeList.add(new CookingPlusHyrophonicModelBox(Shape15));
      Shape15.setRotationPoint(0F, 14F, 0F);
      Shape15.setTextureSize(64, 64);
      Shape15.mirror = true;
      setRotation(Shape15, 0F, 0F, 0F);
      
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.cubeList.add(new CookingPlusHydrophonicFanModelBox(Shape1));
      Shape1.setRotationPoint(0F, 14F, 0F);
      Shape1.offsetY = 0.12f;
      Shape1.setTextureSize(64, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);

    Shape15.render(f5);
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

  public void RenderModel(float f5, float rotation)
  {
	  Shape1.rotateAngleZ = rotation;
	  
	  Shape1.render(f5);
	  Shape15.render(f5);
  }
}
