package CookingPlus.items;

import CookingPlus.CookingPlusMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusHeartUncooked extends CookingPlusCustomItem {

	private final String name = "heartuncooked";
	
	public CookingPlusHeartUncooked(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("heartuncooked");
		setCreativeTab(CreativeTabs.tabMisc);
		//setTextureName(CookingPlusMain.MODID + ":dough");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
