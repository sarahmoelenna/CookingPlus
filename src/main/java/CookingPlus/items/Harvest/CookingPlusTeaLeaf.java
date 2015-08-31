package CookingPlus.items.Harvest;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusTeaLeaf extends CookingPlusCustomItem {

	private final String name = "tealeaf";
	
	public CookingPlusTeaLeaf(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("tealeaf");
		setCreativeTab(CreativeTabs.tabMisc);
		//setTextureName(CookingPlusMain.MODID + ":flour");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
