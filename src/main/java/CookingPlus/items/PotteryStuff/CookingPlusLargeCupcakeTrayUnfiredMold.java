package CookingPlus.items.PotteryStuff;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusLargeCupcakeTrayUnfiredMold extends CookingPlusCustomItem {

	private final String name = "largecupcaketrayunfiredmold";
	
	public CookingPlusLargeCupcakeTrayUnfiredMold(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("largecupcaketrayunfiredmold");
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
