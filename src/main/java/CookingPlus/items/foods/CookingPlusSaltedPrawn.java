package CookingPlus.items.foods;

import CookingPlus.items.CookingPlusCustomEdibleFood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusSaltedPrawn extends CookingPlusCustomEdibleFood {
	
	private final String name = "saltedprawn";
	
	public CookingPlusSaltedPrawn() 
    {
        super(6, 4);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("saltedprawn");
        //setTextureName("cookingplus:cookedprawn");
        setCreativeTab(CreativeTabs.tabFood);
        setPotionEffect(32, 100, 10, 100);
    }

	@Override
    public String getName()
    {
    	return name;
    }
}
