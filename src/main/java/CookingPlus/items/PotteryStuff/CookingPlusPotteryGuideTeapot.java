package CookingPlus.items.PotteryStuff;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusPotteryGuideTeapot extends CookingPlusCustomItem {

	private final String name = "potteryguideteapot";
	
	public CookingPlusPotteryGuideTeapot(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("potteryguideteapot");
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
