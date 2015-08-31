package CookingPlus.items.PotteryStuff;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusUnfiredJuicer extends CookingPlusCustomItem {

	private final String name = "unfiredjuicer";
	
	public CookingPlusUnfiredJuicer(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("unfiredjuicer");
		setCreativeTab(CreativeTabs.tabMisc);
		//setTextureName(CookingPlusMain.MODID + ":cakebatter");
		setMaxStackSize(1);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
