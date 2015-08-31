package CookingPlus.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusRawCrab extends CookingPlusCustomEdibleFood {

	private final String name = "rawcrab";
	
	public CookingPlusRawCrab() 
    {
        super(1, 0.3F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName(name);
    }
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
