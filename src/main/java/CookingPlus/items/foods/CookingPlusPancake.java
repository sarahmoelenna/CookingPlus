package CookingPlus.items.foods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomEdibleFood;

public class CookingPlusPancake extends CookingPlusCustomEdibleFood
{

	private final String name = "pancake";
	
    public CookingPlusPancake() 
    {
        super(3, 1F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("pancake");
        setCreativeTab(CreativeTabs.FOOD);
        setPotionEffect(32, 40, 5, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}