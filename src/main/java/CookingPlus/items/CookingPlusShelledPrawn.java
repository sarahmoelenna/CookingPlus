package CookingPlus.items;

import CookingPlus.CookingPlusMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusShelledPrawn extends CookingPlusCustomItem {
	
	private final String name = "prawn";
	
	public CookingPlusShelledPrawn(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("prawn");
		setCreativeTab(CreativeTabs.tabMisc);
		//setTextureName(CookingPlusMain.MODID + ":prawn");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
