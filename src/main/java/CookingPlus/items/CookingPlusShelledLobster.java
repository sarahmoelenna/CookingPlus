package CookingPlus.items;

import CookingPlus.CookingPlusMain;
import net.minecraft.creativetab.CreativeTabs;
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
