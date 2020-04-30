package CookingPlus.items;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusBreadCrumbs extends CookingPlusCustomItem {

	private final String name = "breadcrumbs";
	
	public CookingPlusBreadCrumbs(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(name);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
