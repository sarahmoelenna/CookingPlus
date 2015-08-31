package CookingPlus.items.Harvest;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusSaltPile extends CookingPlusCustomItem {

	private final String name = "saltpile";
	
	public CookingPlusSaltPile(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("saltpile");
		setCreativeTab(CreativeTabs.tabMisc);
		//setTextureName(CookingPlusMain.MODID + ":saltpile");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
