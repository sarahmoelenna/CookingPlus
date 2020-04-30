package CookingPlus.items;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusDriedSeaweed extends CookingPlusCustomItem {
	
	private final String name = "driedseaweed";
	
	public CookingPlusDriedSeaweed(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("driedseaweed");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
