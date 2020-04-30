package CookingPlus.items;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusUncookedCrabCake extends CookingPlusCustomItem {

	private final String name = "uncookedcrabcake";
	
	public CookingPlusUncookedCrabCake(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(name);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
