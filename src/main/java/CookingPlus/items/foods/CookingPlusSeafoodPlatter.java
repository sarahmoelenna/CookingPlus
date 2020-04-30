package CookingPlus.items.foods;

import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomEdibleFood;

public class CookingPlusSeafoodPlatter extends CookingPlusCustomEdibleFood
{

	private final String name = "seafoodplatter";
	
	public CookingPlusSeafoodPlatter() 
    {
        super(12, 8F);
        GameRegistry.registerItem(this, name);
        setUnlocalizedName(name);
        setPotionEffect(32, 300, 25, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}