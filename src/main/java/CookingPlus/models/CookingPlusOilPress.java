package CookingPlus.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class CookingPlusOilPress extends ModelBase
{
  //fields
    ModelRenderer base;
    ModelRenderer sidea;
    ModelRenderer sideb;
    ModelRenderer sidec;
    ModelRenderer sided;
    ModelRenderer pole;
    ModelRenderer horizontal;
    ModelRenderer roller;
    ModelRenderer rollerb;
    ModelRenderer rolLa;
    ModelRenderer rolLb;
    ModelRenderer rolLc;
    ModelRenderer rolLd;
    ModelRenderer rolRd;
    ModelRenderer rolRa;
    ModelRenderer rolRb;
    ModelRenderer rolRc;
  
    public CookingPlusOilPress()
    {
      textureWidth = 128;
      textureHeight = 64;
      
        base = new ModelRenderer(this, 0, 0);
        base.addBox(-6F, 0F, -6F, 12, 8, 12);
        base.setRotationPoint(0F, 16F, 0F);
        base.setTextureSize(128, 64);
        base.mirror = true;
        setRotation(base, 0F, 0F, 0F);
        sidea = new ModelRenderer(this, 18, 29);
        sidea.addBox(-7F, 0F, -4F, 1, 8, 8);
        sidea.setRotationPoint(0F, 16F, 0F);
        sidea.setTextureSize(128, 64);
        sidea.mirror = true;
        setRotation(sidea, 0F, 0F, 0F);
        sideb = new ModelRenderer(this, 0, 29);
        sideb.addBox(6F, 0F, -4F, 1, 8, 8);
        sideb.setRotationPoint(0F, 16F, 0F);
        sideb.setTextureSize(128, 64);
        sideb.mirror = true;
        setRotation(sideb, 0F, 0F, 0F);
        sidec = new ModelRenderer(this, 0, 20);
        sidec.addBox(-4F, 0F, 6F, 8, 8, 1);
        sidec.setRotationPoint(0F, 16F, 0F);
        sidec.setTextureSize(128, 64);
        sidec.mirror = true;
        setRotation(sidec, 0F, 0F, 0F);
        sided = new ModelRenderer(this, 18, 20);
        sided.addBox(-4F, 0F, -7F, 8, 8, 1);
        sided.setRotationPoint(0F, 16F, 0F);
        sided.setTextureSize(128, 64);
        sided.mirror = true;
        setRotation(sided, 0F, 0F, 0F);
        pole = new ModelRenderer(this, 48, 0);
        pole.addBox(-1F, 0F, -1F, 2, 6, 2);
        pole.setRotationPoint(0F, 10F, 0F);
        pole.setTextureSize(128, 64);
        pole.mirror = true;
        setRotation(pole, 0F, 0F, 0F);
        horizontal = new ModelRenderer(this, 56, 0);
        horizontal.addBox(-1F, -1F, -7F, 2, 2, 14);
        horizontal.setRotationPoint(0F, 12F, 0F);
        horizontal.setTextureSize(128, 64);
        horizontal.mirror = true;
        setRotation(horizontal, 0F, 0F, 0F);
        roller = new ModelRenderer(this, 37, 25);
        roller.addBox(-3F, -3F, -6F, 6, 6, 2);
        roller.setRotationPoint(0F, 12F, 0F);
        roller.setTextureSize(128, 64);
        roller.mirror = true;
        setRotation(roller, 0F, 0F, 0F);
        rollerb = new ModelRenderer(this, 37, 25);
        rollerb.addBox(-3F, -3F, 4F, 6, 6, 2);
        rollerb.setRotationPoint(0F, 12F, 0F);
        rollerb.setTextureSize(128, 64);
        rollerb.mirror = true;
        setRotation(rollerb, 0F, 0F, 0F);
        rolLa = new ModelRenderer(this, 37, 34);
        rolLa.addBox(-2F, -4F, -6F, 4, 1, 2);
        rolLa.setRotationPoint(0F, 12F, 0F);
        rolLa.setTextureSize(128, 64);
        rolLa.mirror = true;
        setRotation(rolLa, 0F, 0F, 0F);
        rolLb = new ModelRenderer(this, 37, 37);
        rolLb.addBox(-2F, 3F, -6F, 4, 1, 2);
        rolLb.setRotationPoint(0F, 12F, 0F);
        rolLb.setTextureSize(128, 64);
        rolLb.mirror = true;
        setRotation(rolLb, 0F, 0F, 0F);
        rolLc = new ModelRenderer(this, 37, 40);
        rolLc.addBox(-4F, -2F, -6F, 1, 4, 2);
        rolLc.setRotationPoint(0F, 12F, 0F);
        rolLc.setTextureSize(128, 64);
        rolLc.mirror = true;
        setRotation(rolLc, 0F, 0F, 0F);
        rolLd = new ModelRenderer(this, 37, 40);
        rolLd.addBox(3F, -2F, -6F, 1, 4, 2);
        rolLd.setRotationPoint(0F, 12F, 0F);
        rolLd.setTextureSize(128, 64);
        rolLd.mirror = true;
        setRotation(rolLd, 0F, 0F, 0F);
        rolRd = new ModelRenderer(this, 37, 40);
        rolRd.addBox(3F, -2F, 4F, 1, 4, 2);
        rolRd.setRotationPoint(0F, 12F, 0F);
        rolRd.setTextureSize(128, 64);
        rolRd.mirror = true;
        setRotation(rolRd, 0F, 0F, 0F);
        rolRa = new ModelRenderer(this, 37, 34);
        rolRa.addBox(-2F, -4F, 4F, 4, 1, 2);
        rolRa.setRotationPoint(0F, 12F, 0F);
        rolRa.setTextureSize(128, 64);
        rolRa.mirror = true;
        setRotation(rolRa, 0F, 0F, 0F);
        rolRb = new ModelRenderer(this, 37, 37);
        rolRb.addBox(-2F, 3F, 4F, 4, 1, 2);
        rolRb.setRotationPoint(0F, 12F, 0F);
        rolRb.setTextureSize(128, 64);
        rolRb.mirror = true;
        setRotation(rolRb, 0F, 0F, 0F);
        rolRc = new ModelRenderer(this, 37, 40);
        rolRc.addBox(-4F, -2F, 4F, 1, 4, 2);
        rolRc.setRotationPoint(0F, 12F, 0F);
        rolRc.setTextureSize(128, 64);
        rolRc.mirror = true;
        setRotation(rolRc, 0F, 0F, 0F);
    }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    base.render(f5);
    sidea.render(f5);
    sideb.render(f5);
    sidec.render(f5);
    sided.render(f5);
    pole.render(f5);
    horizontal.render(f5);
    roller.render(f5);
    rollerb.render(f5);
    rolLa.render(f5);
    rolLb.render(f5);
    rolLc.render(f5);
    rolLd.render(f5);
    rolRd.render(f5);
    rolRa.render(f5);
    rolRb.render(f5);
    rolRc.render(f5);
  }
  
  public void RenderModel(float f5, float rotation)
  {
	  	//pole.rotateAngleY = -rotation;
	  	base.rotateAngleY = -rotation;
	  	sidea.rotateAngleY = -rotation;
	  	sideb.rotateAngleY = -rotation;
	  	sidec.rotateAngleY = -rotation;
	  	sided.rotateAngleY = -rotation;
	  
	  	//rolLc.rotateAngleY = rotation;
	  	//rolLd.rotateAngleY = rotation;
	  	//rolRa.rotateAngleY = rotation;
	  	//rolRb.rotateAngleY = rotation;
	  	//rolRc.rotateAngleY = rotation;
	  	//rolRd.rotateAngleY = rotation;
	  	
	  	//horizontal.rotateAngleZ = -rotation;
	  	roller.rotateAngleZ = -rotation;
	  	rollerb.rotateAngleZ = rotation;
	  	rolLa.rotateAngleZ = -rotation;
	  	rolLb.rotateAngleZ = -rotation;
	  	rolLc.rotateAngleZ = -rotation;
	  	rolLd.rotateAngleZ = -rotation;
	  	rolRa.rotateAngleZ = rotation;
	  	rolRb.rotateAngleZ = rotation;
	  	rolRc.rotateAngleZ = rotation;
	  	rolRd.rotateAngleZ = rotation;
	  
	  	base.render(f5);
	    sidea.render(f5);
	    sideb.render(f5);
	    sidec.render(f5);
	    sided.render(f5);
	    pole.render(f5);
	    horizontal.render(f5);
	    roller.render(f5);
	    rollerb.render(f5);
	    rolLa.render(f5);
	    rolLb.render(f5);
	    rolLc.render(f5);
	    rolLd.render(f5);
	    rolRa.render(f5);
	    rolRb.render(f5);
	    rolRc.render(f5);
	    rolRd.render(f5);
  }
  
  public void setRotation(ModelRenderer model, float x, float y, float z)
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
