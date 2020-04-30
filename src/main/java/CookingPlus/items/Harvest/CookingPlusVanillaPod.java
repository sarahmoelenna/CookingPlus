package CookingPlus.items.Harvest;

import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusVanillaPod extends CookingPlusCustomItem {

	private final String name = "vanillapod";
	
	public CookingPlusVanillaPod(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("vanillapod");
		//setCreativeTab(CreativeTabs.MISC);
		//setTextureName(CookingPlusMain.MODID + ":rack");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
