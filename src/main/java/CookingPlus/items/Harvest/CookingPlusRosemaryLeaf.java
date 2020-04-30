package CookingPlus.items.Harvest;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusRosemaryLeaf extends CookingPlusCustomItem {

	private final String name = "rosemaryleaf";
	
	public CookingPlusRosemaryLeaf(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("rosemaryleaf");
		setCreativeTab(CreativeTabs.MISC);
		//setTextureName(CookingPlusMain.MODID + ":flour");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
