package CookingPlus.items.PotteryStuff;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusCupcakeTrayMold extends CookingPlusCustomItem {

	private final String name = "cupcaketraymold";
	
	public CookingPlusCupcakeTrayMold(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("cupcaketraymold");
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
