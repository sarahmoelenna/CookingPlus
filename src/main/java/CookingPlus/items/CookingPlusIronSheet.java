package CookingPlus.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusIronSheet extends CookingPlusCustomItem {

	private final String name = "ironsheet";
	
	public CookingPlusIronSheet(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("ironsheet");
		setCreativeTab(CreativeTabs.MISC);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
