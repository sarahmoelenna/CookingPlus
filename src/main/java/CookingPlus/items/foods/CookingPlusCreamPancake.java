package CookingPlus.items.foods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomEdibleFood;

public class CookingPlusCreamPancake extends CookingPlusCustomEdibleFood
{

	private final String name = "creampancake";
	
    public CookingPlusCreamPancake() 
    {
        super(6, 4F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("creampancake");
        setCreativeTab(CreativeTabs.FOOD);
        setPotionEffect(32, 100, 10, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}