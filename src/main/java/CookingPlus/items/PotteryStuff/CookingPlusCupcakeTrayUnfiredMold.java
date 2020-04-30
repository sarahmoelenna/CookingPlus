package CookingPlus.items.PotteryStuff;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusCupcakeTrayUnfiredMold extends CookingPlusCustomItem {

	private final String name = "cupcaketrayunfiredmold";
	
	public CookingPlusCupcakeTrayUnfiredMold(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("cupcaketrayunfiredmold");
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
