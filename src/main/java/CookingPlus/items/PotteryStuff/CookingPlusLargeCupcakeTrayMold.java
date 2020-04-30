package CookingPlus.items.PotteryStuff;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusLargeCupcakeTrayMold extends CookingPlusCustomItem {

	private final String name = "largecupcaketraymold";
	
	public CookingPlusLargeCupcakeTrayMold(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("largecupcaketraymold");
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
