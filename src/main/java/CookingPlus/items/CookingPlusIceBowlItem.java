package CookingPlus.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
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
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving){
    	if(entityLiving instanceof EntityPlayer){
    		--stack.stackSize;
    		EntityPlayer playerIn = (EntityPlayer) entityLiving;
    		playerIn.getFoodStats().addStats(this, stack);
    		//worldIn.playSoundAtEntity(playerIn, "random.burp", 0.5F,worldIn.rand.nextFloat() * 0.1F + 0.9F);
    		this.onFoodEaten(stack, worldIn, playerIn);
    		//playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
    		if(playerIn.inventory.addItemStackToInventory(new ItemStack(Items.BOWL)) == false){
    			playerIn.dropItem(new ItemStack(Items.BOWL), false);
    		}
    	}
   		return stack;
   	}
    
    @Override
    public String getName()
    {
    	return name;
    }

}