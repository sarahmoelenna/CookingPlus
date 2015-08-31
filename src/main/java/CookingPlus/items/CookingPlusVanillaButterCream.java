package CookingPlus.items;

import CookingPlus.CookingPlusMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusVanillaButterCream extends CookingPlusCustomItem {

	private final String name = "vanillabuttercream";
	
	public CookingPlusVanillaButterCream(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("vanillabuttercream");
		setCreativeTab(CreativeTabs.tabMisc);
		setMaxStackSize(1);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
