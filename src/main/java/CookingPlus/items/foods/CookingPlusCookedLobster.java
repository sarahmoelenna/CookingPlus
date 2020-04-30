package CookingPlus.items.foods;

import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomEdibleFood;

public class CookingPlusCookedLobster extends CookingPlusCustomEdibleFood {
	
	private final String name = "cookedlobster";
	
	public CookingPlusCookedLobster() 
    {
        super(3, 0.5F);
        GameRegistry.registerItem(this, name);
        setUnlocalizedName(name);
        setPotionEffect(32, 50, 5, 100);
    }

	@Override
    public String getName()
    {
    	return name;
    }
}
