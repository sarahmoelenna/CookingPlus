package CookingPlus.items;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusShelledCrab extends CookingPlusCustomItem {
	
	private final String name = "shelledcrab";
	
	public CookingPlusShelledCrab(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("shelledcrab");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
