package CookingPlus.items.foods;

import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomEdibleFood;

public class CookingPlusPlainChocolateCupcake extends CookingPlusCustomEdibleFood {
	
	private final String name = "plainchocolatecupcake";
	
	public CookingPlusPlainChocolateCupcake() 
    {
        super(3, 0.5F);
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("plainchocolatecupcake");
        setPotionEffect(32, 50, 5, 100);
    }

	@Override
    public String getName()
    {
    	return name;
    }
}
