package CookingPlus.items.PotteryStuff;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusCupcakeTray extends CookingPlusCustomItem {

	private final String name = "cupcaketray";
	
	public CookingPlusCupcakeTray(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("cupcaketray");
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
