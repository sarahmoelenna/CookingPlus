package CookingPlus.items.foods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomEdibleFood;

public class CookingPlusCookedPrawn extends CookingPlusCustomEdibleFood {
	
	private final String name = "cookedprawn";
	
	public CookingPlusCookedPrawn() 
    {
        super(3, 0.5F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("cookedprawn");
        //setTextureName("cookingplus:cookedprawn");
        setCreativeTab(CreativeTabs.FOOD);
        setPotionEffect(32, 50, 5, 100);
    }

	@Override
    public String getName()
    {
    	return name;
    }
}
