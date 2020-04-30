package CookingPlus.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusRawPrawn extends CookingPlusCustomEdibleFood {

	private final String name = "rawprawn";
	
	public CookingPlusRawPrawn() 
    {
        super(1, 0.3F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("rawprawn");
        //setTextureName("cookingplus:deshelledprawn");
        setCreativeTab(CreativeTabs.FOOD);
    }
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
