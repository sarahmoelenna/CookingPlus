package CookingPlus.items.Harvest;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusTeaLeaf extends CookingPlusCustomItem {

	private final String name = "tealeaf";
	
	public CookingPlusTeaLeaf(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("tealeaf");
		setCreativeTab(CreativeTabs.MISC);
		//setTextureName(CookingPlusMain.MODID + ":flour");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
