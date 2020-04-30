package CookingPlus.items.Drinks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomJuice;

public class CookingPlusBeer extends CookingPlusCustomJuice
{

	private final String name = "beer";
	
    public CookingPlusBeer() 
    {
        super(6, 4F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("beer");
        //setTextureName("cookingplus:blueberry");
        setCreativeTab(CreativeTabs.FOOD);
        setPotionEffect(32, 100, 10, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
    
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
    	if(entityLiving instanceof EntityPlayer){
    		PotionEffect myNausea = new PotionEffect(MobEffects.NAUSEA, 900, 10);
    		EntityPlayer playerIn = (EntityPlayer) entityLiving;
    		playerIn.addPotionEffect(myNausea);
    		return super.onItemUseFinish(stack, worldIn, playerIn);
    	}
		return super.onItemUseFinish(stack, worldIn, entityLiving);
	}
}