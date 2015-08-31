package CookingPlus.items.Harvest;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusSageLeaf extends CookingPlusCustomItem {

	private final String name = "sageleaf";
	
	public CookingPlusSageLeaf(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("sageleaf");
		setCreativeTab(CreativeTabs.tabMisc);
		//setTextureName(CookingPlusMain.MODID + ":flour");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
