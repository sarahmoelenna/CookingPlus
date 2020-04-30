package CookingPlus.items.Harvest;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusSaltPile extends CookingPlusCustomItem {

	private final String name = "saltpile";
	
	public CookingPlusSaltPile(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("saltpile");
		setCreativeTab(CreativeTabs.MISC);
		//setTextureName(CookingPlusMain.MODID + ":saltpile");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
