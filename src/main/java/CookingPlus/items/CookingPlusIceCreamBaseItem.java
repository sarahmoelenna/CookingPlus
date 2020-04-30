package CookingPlus.items;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusIceCreamBaseItem extends CookingPlusCustomItem {

	private final String name;
	
	public CookingPlusIceCreamBaseItem(String Myname){
		name = Myname;
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(name);
		setMaxStackSize(1);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
