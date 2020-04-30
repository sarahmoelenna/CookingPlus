package CookingPlus.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import CookingPlus.CookingPlusMain;

public class CookingPlusNeedle extends CookingPlusSingleStackItem {

	public CookingPlusNeedle() {
		super("needle");
		
	}
	
	 @Override
	 public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity, EnumHand hand)
	 {
		 if(entity instanceof EntityPig){
			 itemstack = new ItemStack(CookingPlusMain.pigneedle);
			 entity.attackEntityFrom(DamageSource.generic, 1);
			 player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, itemstack);
			 return true;
			}
			if(entity instanceof EntityCow){
				itemstack = new ItemStack(CookingPlusMain.cowneedle);
				entity.attackEntityFrom(DamageSource.generic, 1);
				player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, itemstack);
				return true;
			}
			if(entity instanceof EntityChicken){
				itemstack = new ItemStack(CookingPlusMain.chickenneedle);
				entity.attackEntityFrom(DamageSource.generic, 1);
				player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, itemstack);
				return true;
			}
			if(entity instanceof EntitySheep){
				itemstack = new ItemStack(CookingPlusMain.sheepneedle);
				entity.attackEntityFrom(DamageSource.generic, 1);
				player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, itemstack);
				return true;
			}
			if(entity instanceof EntityRabbit){
				itemstack = new ItemStack(CookingPlusMain.rabbitneedle);
				entity.attackEntityFrom(DamageSource.generic, 1);
				player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, itemstack);
				return true;
			}
		return false;
	 }

}
