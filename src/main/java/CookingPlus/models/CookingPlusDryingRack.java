package CookingPlus.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import ModelBoxes.CookingPlusDryingRackModelBox;

public class CookingPlusDryingRack extends ModelBase
{
  //fields
    ModelRenderer Shape15;
  
  public CookingPlusDryingRack()
  {
    textureWidth = 16;
    textureHeight = 16;
 
      Shape15 = new ModelRenderer(this, 0, 0);
      //Shape15.addBox(-0.5F, 0F, -0.5F, 1, 1, 1);
      Shape15.cubeList.add(new CookingPlusDryingRackModelBox(Shape15));
      Shape15.setRotationPoint(0F, 14F, 0F);
      Shape15.setTextureSize(16, 16);
      Shape15.mirror = true;
      setRotation(Shape15, 0F, 0F, 0F);
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

  public void RenderModel(float f5)
  {

	  Shape15.render(f5);
  }
}
