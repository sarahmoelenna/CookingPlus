package CookingPlus.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.CookingPlusMain;

public class CookingPlusCustomHerbalTea extends CookingPlusCustomEdibleFood {

	public CookingPlusCustomHerbalTea() {
		super(6, 4);
		this.setMaxStackSize(16);
		this.setAlwaysEdible();
		// TODO Auto-generated constructor stub
	}

	@Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
	{
	if(entityLiving instanceof EntityPlayer){
		EntityPlayer playerIn = (EntityPlayer) entityLiving;
	    	
		--stack.stackSize;
		 if(playerIn.isPotionActive(Potion.getPotionById(getPotionID()))){
			 playerIn.removeActivePotionEffect(Potion.getPotionById(getPotionID()));
			//super.onItemUseFinish(stack, worldIn, playerIn);
			//worldIn.playSoundAtEntity(playerIn, "random.burp", 0.5F,worldIn.rand.nextFloat() * 0.1F + 0.9F);
			//playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
		 }
		 playerIn.getFoodStats().addStats(this, stack);
		 this.onFoodEaten(stack, worldIn, playerIn);
		 if(playerIn.inventory.addItemStackToInventory(new ItemStack(CookingPlusMain.mug)) == false){
			playerIn.dropItem(new ItemStack(CookingPlusMain.mug), false);
		 }
	}
	return stack;
	}
	 
	 public int getPotionID(){
		 return 0;
	 }
	 
	 @Override
	 @SideOnly(Side.CLIENT)
	    public boolean hasEffect(ItemStack stack)
	    {
	        return true;
	    }
	 
}
