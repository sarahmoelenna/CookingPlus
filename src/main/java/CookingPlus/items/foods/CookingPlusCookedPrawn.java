package CookingPlus.items.foods;

import CookingPlus.items.CookingPlusCustomEdibleFood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusCookedPrawn extends CookingPlusCustomEdibleFood {
	
	private final String name = "cookedprawn";
	
	public CookingPlusCookedPrawn() 
    {
        super(3, 0.5F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("cookedprawn");
        //setTextureName("cookingplus:cookedprawn");
        setCreativeTab(CreativeTabs.tabFood);
        setPotionEffect(32, 50, 5, 100);
    }

	@Override
    public String getName()
    {
    	return name;
    }
}
