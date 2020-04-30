package CookingPlus.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusVegetableOil extends CookingPlusCustomItem {

	private final String name = "vegetableoil";
	
	public CookingPlusVegetableOil(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("vegetableoil");
		setCreativeTab(CreativeTabs.MISC);
		//setTextureName(CookingPlusMain.MODID + ":vegetableoil");
		setMaxStackSize(16);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
