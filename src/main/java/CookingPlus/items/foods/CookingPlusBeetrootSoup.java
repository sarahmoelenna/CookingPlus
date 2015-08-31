package CookingPlus.items.foods;

import CookingPlus.items.CookingPlusCustomEdibleFood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusBeetrootSoup extends CookingPlusCustomEdibleFood
{

	private final String name = "beetrootsoup";
	
    public CookingPlusBeetrootSoup() 
    {
        super(6, 7.2F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("beetrootsoup");
        //setTextureName("cookingplus:blueberry");
        setCreativeTab(CreativeTabs.tabFood);
        setPotionEffect(32, 20, 0, 100);
        this.setMaxStackSize(1);
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