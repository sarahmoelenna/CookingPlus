package CookingPlus.items.PotteryStuff;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusPotteryGuideLargeCupcakeTrayMold extends CookingPlusCustomItem {

	private final String name = "potteryguidelargecupcaketraymold";
	
	public CookingPlusPotteryGuideLargeCupcakeTrayMold(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("potteryguidelargecupcaketraymold");
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
