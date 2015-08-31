package CookingPlus.items.foods;

import CookingPlus.items.CookingPlusCustomEdibleFood;
import CookingPlus.items.CookingPlusCustomJuice;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusChocolatePancake extends CookingPlusCustomEdibleFood
{

	private final String name = "chocolatepancake";
	
    public CookingPlusChocolatePancake() 
    {
        super(6, 4F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("chocolatepancake");
        setCreativeTab(CreativeTabs.tabFood);
        setPotionEffect(32, 100, 10, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}