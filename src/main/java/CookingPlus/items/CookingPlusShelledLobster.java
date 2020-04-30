package CookingPlus.items;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusShelledLobster extends CookingPlusCustomItem {
	
	private final String name = "shelledlobster";
	
	public CookingPlusShelledLobster(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("shelledlobster");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
