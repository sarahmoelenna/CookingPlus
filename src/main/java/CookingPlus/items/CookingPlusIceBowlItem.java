package CookingPlus.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusIceBowlItem extends CookingPlusCustomEdibleFood
{
	private String name;

    public CookingPlusIceBowlItem(String myName)
    {
        super(10, 8);
        name = myName;
        GameRegistry.registerItem(this, name);
        setUnlocalizedName(name);
        setPotionEffect(32, 200, 20, 100);
    }
    
    @Override
   	public ItemStack onItemUseFinish(ItemStack stack, World worldIn,EntityPlayer playerIn) {
   		--stack.stackSize;
   		playerIn.getFoodStats().addStats(this, stack);
   		worldIn.playSoundAtEntity(playerIn, "random.burp", 0.5F,worldIn.rand.nextFloat() * 0.1F + 0.9F);
   		this.onFoodEaten(stack, worldIn, playerIn);
   		playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
   		if(playerIn.inventory.addItemStackToInventory(new ItemStack(Items.bowl)) == false){
   			playerIn.dropPlayerItemWithRandomChoice(new ItemStack(Items.bowl), false);
   		}
   		return stack;
   	}
    
    @Override
    public String getName()
    {
    	return name;
    }

}