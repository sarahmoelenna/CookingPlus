package CookingPlus.items.Harvest;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusChamomileFlower extends CookingPlusCustomItem {

	private final String name = "chamomileflower";
	
	public CookingPlusChamomileFlower(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("chamomileflower");
		setCreativeTab(CreativeTabs.tabMisc);
		//setTextureName(CookingPlusMain.MODID + ":flour");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
