package CookingPlus;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusPotion extends Potion {

	private static final ResourceLocation MyIcon = new ResourceLocation("cookingplus","/textures/gui/inventory.png");
	
	public CookingPlusPotion(int potionArrayNum, boolean isBadEffect,int liquidColour) {
		super(isBadEffect, liquidColour);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Potion setIconIndex(int par1, int par2) 
	   {
	     super.setIconIndex(par1, par2);
	     return this;
	   }
	

		
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasStatusIcon() 
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(MyIcon);
		return true;
	}
	
	@Override
	public void applyAttributesModifiersToEntity(EntityLivingBase entityLivingBaseIn, AbstractAttributeMap p_111185_2_, int amplifier)
    {
		
    }
	


}
