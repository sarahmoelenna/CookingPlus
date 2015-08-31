package CookingPlus.items.PotteryStuff;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusPotteryGuideLargeCupcakeTrayMold extends CookingPlusCustomItem {

	private final String name = "potteryguidelargecupcaketraymold";
	
	public CookingPlusPotteryGuideLargeCupcakeTrayMold(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("potteryguidelargecupcaketraymold");
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
