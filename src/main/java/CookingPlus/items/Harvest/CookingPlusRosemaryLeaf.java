package CookingPlus.items.Harvest;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusRosemaryLeaf extends CookingPlusCustomItem {

	private final String name = "rosemaryleaf";
	
	public CookingPlusRosemaryLeaf(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("rosemaryleaf");
		setCreativeTab(CreativeTabs.tabMisc);
		//setTextureName(CookingPlusMain.MODID + ":flour");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
