package CookingPlus.items;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusCupcakeTraySponge extends CookingPlusCustomItem {

	private final String name = "traysponge";
	
	public CookingPlusCupcakeTraySponge(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("traysponge");
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
