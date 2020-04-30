package CookingPlus.items.Harvest;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomEdibleFood;

public class CookingPlusStrawBerry extends CookingPlusCustomEdibleFood
{

	private final String name = "strawberry";
	
    public CookingPlusStrawBerry() 
    {
        super(1, 0.3F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("strawberry");
        //setTextureName("cookingplus:blueberry");
        setCreativeTab(CreativeTabs.FOOD);
        setPotionEffect(32, 20, 0, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}