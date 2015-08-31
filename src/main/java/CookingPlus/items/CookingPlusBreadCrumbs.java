package CookingPlus.items;

import CookingPlus.CookingPlusMain;
import net.minecraft.creativetab.CreativeTabs;
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
