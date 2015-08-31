package CookingPlus.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class CookingPlusCustomJuice extends CookingPlusCustomEdibleFood {

	public CookingPlusCustomJuice(int parHealAmount, float parSaturationModifier) {
		super(parHealAmount, parSaturationModifier);
		setMaxStackSize(16);
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn,EntityPlayer playerIn) {
		--stack.stackSize;
		playerIn.getFoodStats().addStats(this, stack);
		worldIn.playSoundAtEntity(playerIn, "random.burp", 0.5F,worldIn.rand.nextFloat() * 0.1F + 0.9F);
		this.onFoodEaten(stack, worldIn, playerIn);
		playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
		if(playerIn.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle)) == false){
			playerIn.dropPlayerItemWithRandomChoice(new ItemStack(Items.glass_bottle), false);
		}
		return stack;
	}

}
