package CookingPlus.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusCupcakeTrayChocolate extends CookingPlusCustomItem {

	private final String name = "traychocolate";
	
	public CookingPlusCupcakeTrayChocolate(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("traychocolate");
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
