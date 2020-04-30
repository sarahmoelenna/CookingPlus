package CookingPlus.items.Drinks;

import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomJuice;

public class CookingPlusPineappleJuice extends CookingPlusCustomJuice
{

	private final String name = "pineapplejuice";
	
    public CookingPlusPineappleJuice() 
    {
        super(3, 1F);
        GameRegistry.registerItem(this, name);
        setUnlocalizedName(name);
        setPotionEffect(32, 40, 5, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}