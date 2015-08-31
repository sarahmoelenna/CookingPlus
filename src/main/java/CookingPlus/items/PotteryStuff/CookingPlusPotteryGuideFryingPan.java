package CookingPlus.items.PotteryStuff;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusPotteryGuideFryingPan extends CookingPlusCustomItem {

	private final String name = "potteryguidefryingpan";
	
	public CookingPlusPotteryGuideFryingPan(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("potteryguidefryingpan");
		setCreativeTab(CreativeTabs.tabMisc);
		//setTextureName(CookingPlusMain.MODID + ":dough");
		setMaxStackSize(1);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
