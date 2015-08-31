package CookingPlus.items.PotteryStuff;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusLargeCupcakeTrayUnfiredMold extends CookingPlusCustomItem {

	private final String name = "largecupcaketrayunfiredmold";
	
	public CookingPlusLargeCupcakeTrayUnfiredMold(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("largecupcaketrayunfiredmold");
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
