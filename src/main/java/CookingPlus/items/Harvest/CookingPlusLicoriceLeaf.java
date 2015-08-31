package CookingPlus.items.Harvest;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusLicoriceLeaf extends CookingPlusCustomItem {

	private final String name = "licoriceleaf";
	
	public CookingPlusLicoriceLeaf(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("licoriceleaf");
		setCreativeTab(CreativeTabs.tabMisc);
		//setTextureName(CookingPlusMain.MODID + ":flour");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
