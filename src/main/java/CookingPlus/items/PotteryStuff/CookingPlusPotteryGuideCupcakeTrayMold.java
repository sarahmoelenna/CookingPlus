package CookingPlus.items.PotteryStuff;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusPotteryGuideCupcakeTrayMold extends CookingPlusCustomItem {

	private final String name = "potteryguidecupcaketraymold";
	
	public CookingPlusPotteryGuideCupcakeTrayMold(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("potteryguidecupcaketraymold");
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
