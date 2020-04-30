package CookingPlus.items.foods;

import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomEdibleFood;

public class CookingPlusSaltedSquid extends CookingPlusCustomEdibleFood {
	
	private final String name = "saltedsquid";
	
	public CookingPlusSaltedSquid() 
    {
        super(6, 4);
        GameRegistry.registerItem(this, name);
        setUnlocalizedName(name);
        setPotionEffect(32, 100, 10, 100);
    }

	@Override
    public String getName()
    {
    	return name;
    }
}
