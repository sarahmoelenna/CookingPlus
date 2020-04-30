package CookingPlus.items;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusCocoaPowder extends CookingPlusCustomItem {
	
	private final String name = "cocoapowder";
	
	public CookingPlusCocoaPowder() 
    {
        super();
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("cocoapowder");
    }

	@Override
    public String getName()
    {
    	return name;
    }
}
