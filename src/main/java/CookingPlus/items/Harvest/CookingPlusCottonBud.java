package CookingPlus.items.Harvest;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusCottonBud extends CookingPlusCustomItem {

	private final String name = "cottonbud";
	
	public CookingPlusCottonBud(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("cottonbud");
		//setCreativeTab(CreativeTabs.tabMisc);
		//setTextureName(CookingPlusMain.MODID + ":rack");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
