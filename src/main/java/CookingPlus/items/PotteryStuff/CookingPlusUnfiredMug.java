package CookingPlus.items.PotteryStuff;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusUnfiredMug extends CookingPlusCustomItem {

	private final String name = "unfiredmug";
	
	public CookingPlusUnfiredMug(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("unfiredmug");
		setCreativeTab(CreativeTabs.tabMisc);
		//setTextureName(CookingPlusMain.MODID + ":cakebatter");
		setMaxStackSize(16);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
