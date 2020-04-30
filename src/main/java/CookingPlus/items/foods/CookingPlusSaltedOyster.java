package CookingPlus.items.foods;

import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomEdibleFood;

public class CookingPlusSaltedOyster extends CookingPlusCustomEdibleFood {
	
	private final String name = "saltedoyster";
	
	public CookingPlusSaltedOyster() 
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
