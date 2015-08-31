package CookingPlus.items.Harvest;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusVanillaPod extends CookingPlusCustomItem {

	private final String name = "vanillapod";
	
	public CookingPlusVanillaPod(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("vanillapod");
		//setCreativeTab(CreativeTabs.tabMisc);
		//setTextureName(CookingPlusMain.MODID + ":rack");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
