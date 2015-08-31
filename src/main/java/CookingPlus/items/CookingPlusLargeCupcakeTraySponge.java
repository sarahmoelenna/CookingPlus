package CookingPlus.items;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusLargeCupcakeTraySponge extends CookingPlusCustomItem {

	private final String name = "traylargesponge";
	
	public CookingPlusLargeCupcakeTraySponge(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("traylargesponge");
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
