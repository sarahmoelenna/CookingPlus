package CookingPlus.items.PotteryStuff;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusPotterGuideJuicer extends CookingPlusCustomItem {

	private final String name = "potteryguidejuicer";
	
	public CookingPlusPotterGuideJuicer(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("potteryguidejuicer");
		setCreativeTab(CreativeTabs.MISC);
		//setTextureName(CookingPlusMain.MODID + ":dough");
		setMaxStackSize(1);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
