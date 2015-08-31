package CookingPlus.items;

import CookingPlus.CookingPlusMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusRack extends CookingPlusCustomItem {

	private final String name = "rack";
	
	public CookingPlusRack(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("rack");
		//setCreativeTab(CreativeTabs.tabMisc);
		//setTextureName(CookingPlusMain.MODID + ":rack");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
