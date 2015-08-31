package CookingPlus.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class CookingPlusBrickOven extends ModelBase
{
  //fields
    ModelRenderer bottom;
    ModelRenderer top;
    ModelRenderer back;
    ModelRenderer right;
    ModelRenderer left;
    ModelRenderer top1;
    ModelRenderer back1;
    ModelRenderer left1;
    ModelRenderer right1;
    ModelRenderer chimney;
    ModelRenderer bar;
    ModelRenderer bar1;
    ModelRenderer bar2;
    ModelRenderer bar3;
  
  public CookingPlusBrickOven()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      bottom = new ModelRenderer(this, 0, 22);
      bottom.addBox(0F, 0F, 0F, 16, 5, 16);
      bottom.setRotationPoint(-8F, 19F, -8F);
      bottom.setTextureSize(128, 64);
      bottom.mirror = true;
      setRotation(bottom, 0F, 0F, 0F);
      top = new ModelRenderer(this, 0, 43);
      top.addBox(0F, 0F, 0F, 16, 5, 16);
      top.setRotationPoint(-8F, 8F, -8F);
      top.setTextureSize(128, 64);
      top.mirror = true;
      setRotation(top, 0F, 0F, 0F);
      back = new ModelRenderer(this, 64, 54);
      back.addBox(0F, 0F, 0F, 16, 6, 4);
      back.setRotationPoint(-8F, 13F, -8F);
      back.setTextureSize(128, 64);
      back.mirror = true;
      setRotation(back, 0F, 0F, 0F);
      right = new ModelRenderer(this, 64, 36);
      right.addBox(0F, 0F, 0F, 4, 6, 12);
      right.setRotationPoint(-8F, 13F, -4F);
      right.setTextureSize(128, 64);
      right.mirror = true;
      setRotation(right, 0F, 0F, 0F);
      left = new ModelRenderer(this, 0, 4);
      left.addBox(0F, 0F, 0F, 4, 6, 12);
      left.setRotationPoint(4F, 13F, -4F);
      left.setTextureSize(128, 64);
      left.mirror = true;
      setRotation(left, 0F, 0F, 0F);
      top1 = new ModelRenderer(this, 64, 16);
      top1.addBox(0F, 0F, 0F, 14, 4, 16);
      top1.setRotationPoint(-7F, -1F, -8F);
      top1.setTextureSize(128, 64);
      top1.mirror = true;
      setRotation(top1, 0F, 0F, 0F);
      back1 = new ModelRenderer(this, 64, 54);
      back1.addBox(0F, 0F, 0F, 14, 5, 4);
      back1.setRotationPoint(-7F, 3F, -8F);
      back1.setTextureSize(128, 64);
      back1.mirror = true;
      setRotation(back1, 0F, 0F, 0F);
      left1 = new ModelRenderer(this, 0, 4);
      left1.addBox(0F, 0F, 0F, 4, 5, 12);
      left1.setRotationPoint(3F, 3F, -4F);
      left1.setTextureSize(128, 64);
      left1.mirror = true;
      setRotation(left1, 0F, 0F, 0F);
      right1 = new ModelRenderer(this, 64, 36);
      right1.addBox(0F, 0F, 0F, 4, 5, 12);
      right1.setRotationPoint(-7F, 3F, -4F);
      right1.setTextureSize(128, 64);
      right1.mirror = true;
      setRotation(right1, 0F, 0F, 0F);
      chimney = new ModelRenderer(this, 32, 3);
      chimney.addBox(0F, 0F, 0F, 6, 13, 6);
      chimney.setRotationPoint(-3F, -14F, -3F);
      chimney.setTextureSize(128, 64);
      chimney.mirror = true;
      setRotation(chimney, 0F, 0F, 0F);
      bar = new ModelRenderer(this, 0, 0);
      bar.addBox(0F, 0F, 0F, 6, 1, 1);
      bar.setRotationPoint(-3F, 6F, -3F);
      bar.setTextureSize(128, 64);
      bar.mirror = true;
      setRotation(bar, 0F, 0F, 0F);
      bar1 = new ModelRenderer(this, 0, 0);
      bar1.addBox(0F, 0F, 0F, 6, 1, 1);
      bar1.setRotationPoint(-3F, 6F, -1F);
      bar1.setTextureSize(128, 64);
      bar1.mirror = true;
      setRotation(bar1, 0F, 0F, 0F);
      bar2 = new ModelRenderer(this, 0, 0);
      bar2.addBox(0F, 0F, 0F, 6, 1, 1);
      bar2.setRotationPoint(-3F, 6F, 1F);
      bar2.setTextureSize(128, 64);
      bar2.mirror = true;
      setRotation(bar2, 0F, 0F, 0F);
      bar3 = new ModelRenderer(this, 0, 0);
      bar3.addBox(0F, 0F, 0F, 6, 1, 1);
      bar3.setRotationPoint(-3F, 6F, 3F);
      bar3.setTextureSize(128, 64);
      bar3.mirror = true;
      setRotation(bar3, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    bottom.render(f5);
    top.render(f5);
    back.render(f5);
    right.render(f5);
    left.render(f5);
    top1.render(f5);
    back1.render(f5);
    left1.render(f5);
    right1.render(f5);
    chimney.render(f5);
    bar.render(f5);
    bar1.render(f5);
    bar2.render(f5);
    bar3.render(f5);
  }
  
  public void RenderModel(float f5)
  {
	  bottom.render(f5);
	  top.render(f5);
	  back.render(f5);
	  right.render(f5);
	  left.render(f5);
	  top1.render(f5);
	  back1.render(f5);
	  left1.render(f5);
	  right1.render(f5);
	  chimney.render(f5);
	  bar.render(f5);
	  bar1.render(f5);
	  bar2.render(f5);
	  bar3.render(f5);
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

}
