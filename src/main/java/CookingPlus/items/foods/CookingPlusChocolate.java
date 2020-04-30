package CookingPlus.items.foods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomEdibleFood;

public class CookingPlusChocolate extends CookingPlusCustomEdibleFood {
	
	private final String name = "chocolate";
	
	public CookingPlusChocolate() 
    {
        super(1, 0.5F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("chocolate");
        setCreativeTab(CreativeTabs.FOOD);
        setPotionEffect(32, 20, 0, 100);
    }

	@Override
    public String getName()
    {
    	return name;
    }
}
