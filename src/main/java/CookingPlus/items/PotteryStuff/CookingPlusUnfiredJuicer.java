package CookingPlus.items.PotteryStuff;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusUnfiredJuicer extends CookingPlusCustomItem {

	private final String name = "unfiredjuicer";
	
	public CookingPlusUnfiredJuicer(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("unfiredjuicer");
		setCreativeTab(CreativeTabs.MISC);
		//setTextureName(CookingPlusMain.MODID + ":cakebatter");
		setMaxStackSize(1);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
