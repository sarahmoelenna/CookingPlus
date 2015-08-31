package CookingPlus.items.foods;

import CookingPlus.items.CookingPlusCustomEdibleFood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusSaltedLobster extends CookingPlusCustomEdibleFood {
	
	private final String name = "saltedlobster";
	
	public CookingPlusSaltedLobster() 
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
