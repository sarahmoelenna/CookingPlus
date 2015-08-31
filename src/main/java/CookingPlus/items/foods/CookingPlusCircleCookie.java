package CookingPlus.items.foods;

import CookingPlus.items.CookingPlusCustomEdibleFood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusCircleCookie extends CookingPlusCustomEdibleFood
{

	private final String name = "circlecookie";
	
    public CookingPlusCircleCookie() 
    {
        super(1, 0.3F);
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("circlecookie");
        setCreativeTab(CreativeTabs.tabFood);
        setPotionEffect(32, 20, 0, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}