package CookingPlus.items;

import CookingPlus.CookingPlusMain;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class CookingPlusNeedle extends CookingPlusSingleStackItem {

	public CookingPlusNeedle() {
		super("needle");
		
	}
	
	 @Override
	 public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity)
	 {
		 if(entity instanceof EntityPig){
			 itemstack = new ItemStack(CookingPlusMain.pigneedle);
			 entity.attackEntityFrom(DamageSource.generic, 1);
			 player.setCurrentItemOrArmor(0, itemstack);
			 return true;
			}
			if(entity instanceof EntityCow){
				itemstack = new ItemStack(CookingPlusMain.cowneedle);
				entity.attackEntityFrom(DamageSource.generic, 1);
				player.setCurrentItemOrArmor(0, itemstack);
				return true;
			}
			if(entity instanceof EntityChicken){
				itemstack = new ItemStack(CookingPlusMain.chickenneedle);
				entity.attackEntityFrom(DamageSource.generic, 1);
				player.setCurrentItemOrArmor(0, itemstack);
				return true;
			}
			if(entity instanceof EntitySheep){
				itemstack = new ItemStack(CookingPlusMain.sheepneedle);
				entity.attackEntityFrom(DamageSource.generic, 1);
				player.setCurrentItemOrArmor(0, itemstack);
				return true;
			}
			if(entity instanceof EntityRabbit){
				itemstack = new ItemStack(CookingPlusMain.rabbitneedle);
				entity.attackEntityFrom(DamageSource.generic, 1);
				player.setCurrentItemOrArmor(0, itemstack);
				return true;
			}
		return false;
	 }

}
