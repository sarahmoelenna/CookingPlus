package CookingPlus.items;

import CookingPlus.CookingPlusMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusShelledOyster extends CookingPlusCustomItem {
	
	private final String name = "shelledoyster";
	
	public CookingPlusShelledOyster(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("shelledoyster");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
