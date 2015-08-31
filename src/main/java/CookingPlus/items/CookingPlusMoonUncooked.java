package CookingPlus.items;

import CookingPlus.CookingPlusMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusMoonUncooked extends CookingPlusCustomItem {

	private final String name = "moonuncooked";
	
	public CookingPlusMoonUncooked(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("moonuncooked");
		setCreativeTab(CreativeTabs.tabMisc);
		//setTextureName(CookingPlusMain.MODID + ":dough");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
