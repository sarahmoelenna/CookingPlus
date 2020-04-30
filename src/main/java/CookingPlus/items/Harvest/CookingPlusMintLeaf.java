package CookingPlus.items.Harvest;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusMintLeaf extends CookingPlusCustomItem {

	private final String name = "mintleaf";
	
	public CookingPlusMintLeaf(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("mintleaf");
		setCreativeTab(CreativeTabs.MISC);
		//setTextureName(CookingPlusMain.MODID + ":flour");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
