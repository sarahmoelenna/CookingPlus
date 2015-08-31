package CookingPlus.items;

import CookingPlus.CookingPlusMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusCustomHerbalTea extends CookingPlusCustomEdibleFood {

	public CookingPlusCustomHerbalTea() {
		super(6, 4);
		this.setMaxStackSize(16);
		this.setAlwaysEdible();
		// TODO Auto-generated constructor stub
	}

	 @Override
		public ItemStack onItemUseFinish(ItemStack stack, World worldIn,EntityPlayer playerIn) {
	    	//PotionEffect myNausea = new PotionEffect(Potion.confusion.getId(), 100, 5);
	    	//Potion.confusion.getId();
			//playerIn.addPotionEffect(myNausea);
		 if(playerIn.isPotionActive(getPotionID())){
			 playerIn.removePotionEffect(getPotionID());
		 }
			//super.onItemUseFinish(stack, worldIn, playerIn);
		 	--stack.stackSize;
			playerIn.getFoodStats().addStats(this, stack);
			worldIn.playSoundAtEntity(playerIn, "random.burp", 0.5F,worldIn.rand.nextFloat() * 0.1F + 0.9F);
			this.onFoodEaten(stack, worldIn, playerIn);
			playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
			if(playerIn.inventory.addItemStackToInventory(new ItemStack(CookingPlusMain.mug)) == false){
				playerIn.dropPlayerItemWithRandomChoice(new ItemStack(CookingPlusMain.mug), false);
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
