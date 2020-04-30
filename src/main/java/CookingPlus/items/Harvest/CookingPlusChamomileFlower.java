package CookingPlus.items.Harvest;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusChamomileFlower extends CookingPlusCustomItem {

	private final String name = "chamomileflower";
	
	public CookingPlusChamomileFlower(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("chamomileflower");
		setCreativeTab(CreativeTabs.MISC);
		//setTextureName(CookingPlusMain.MODID + ":flour");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
