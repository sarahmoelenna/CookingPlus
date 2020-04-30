package CookingPlus.items.PotteryStuff;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusLargeCupcakeTray extends CookingPlusCustomItem {

	private final String name = "largecupcaketray";
	
	public CookingPlusLargeCupcakeTray(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("largecupcaketray");
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
