package CookingPlus.items.Harvest;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusBuchuLeaf extends CookingPlusCustomItem {

	private final String name = "buchuleaf";
	
	public CookingPlusBuchuLeaf(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("buchuleaf");
		setCreativeTab(CreativeTabs.MISC);
		//setTextureName(CookingPlusMain.MODID + ":flour");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
