package CookingPlus.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class CookingPlusChurn extends ModelBase
{
  //fields
    ModelRenderer center;
    ModelRenderer right;
    ModelRenderer left;
    ModelRenderer back;
    ModelRenderer front;
    ModelRenderer stick;
  
  public CookingPlusChurn()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      center = new ModelRenderer(this, 0, 0);
      center.addBox(0F, 0F, 0F, 10, 12, 10);
      center.setRotationPoint(-5F, 12F, -5F);
      center.setTextureSize(128, 64);
      center.mirror = true;
      setRotation(center, 0F, 0F, 0F);
      right = new ModelRenderer(this, 28, 22);
      right.addBox(0F, 0F, 0F, 1, 12, 6);
      right.setRotationPoint(5F, 12F, -3F);
      right.setTextureSize(128, 64);
      right.mirror = true;
      setRotation(right, 0F, 0F, 0F);
      left = new ModelRenderer(this, 0, 22);
      left.addBox(0F, 0F, 0F, 1, 12, 6);
      left.setRotationPoint(-6F, 12F, -3F);
      left.setTextureSize(128, 64);
      left.mirror = true;
      setRotation(left, 0F, 0F, 0F);
      back = new ModelRenderer(this, 14, 22);
      back.addBox(0F, 0F, 0F, 6, 12, 1);
      back.setRotationPoint(-3F, 12F, 5F);
      back.setTextureSize(128, 64);
      back.mirror = true;
      setRotation(back, 0F, 0F, 0F);
      front = new ModelRenderer(this, 42, 22);
      front.addBox(0F, 0F, 0F, 6, 12, 1);
      front.setRotationPoint(-3F, 12F, -6F);
      front.setTextureSize(128, 64);
      front.mirror = true;
      setRotation(front, 0F, 0F, 0F);
      stick = new ModelRenderer(this, 40, 0);
      stick.addBox(-1F, 0F, -1F, 2, 12, 2);
      stick.setRotationPoint(0F, 0F, 0F);
      stick.setTextureSize(128, 64);
      stick.mirror = true;
      setRotation(stick, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    center.render(f5);
    right.render(f5);
    left.render(f5);
    back.render(f5);
    front.render(f5);
    stick.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void RenderModel(float f5, float offset)
  {
	  	stick.offsetY = offset;
	    center.render(f5);
	    right.render(f5);
	    left.render(f5);
	    back.render(f5);
	    front.render(f5);
	    stick.render(f5);
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
  }

}
