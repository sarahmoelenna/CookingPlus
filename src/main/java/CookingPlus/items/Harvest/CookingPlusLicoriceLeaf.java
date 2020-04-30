package CookingPlus.items.Harvest;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusLicoriceLeaf extends CookingPlusCustomItem {

	private final String name = "licoriceleaf";
	
	public CookingPlusLicoriceLeaf(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("licoriceleaf");
		setCreativeTab(CreativeTabs.MISC);
		//setTextureName(CookingPlusMain.MODID + ":flour");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
