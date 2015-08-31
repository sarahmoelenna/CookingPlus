package CookingPlus.items;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusCupcakeTrayVelvet extends CookingPlusCustomItem {

	private final String name = "trayvelvet";
	
	public CookingPlusCupcakeTrayVelvet(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("trayvelvet");
		setCreativeTab(CreativeTabs.tabMisc);
		//setTextureName(CookingPlusMain.MODID + ":dough");
		setMaxStackSize(1);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
