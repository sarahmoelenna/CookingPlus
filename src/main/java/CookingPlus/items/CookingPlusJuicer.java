package CookingPlus.items;

import CookingPlus.CookingPlusMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusJuicer extends CookingPlusCustomItem {

	private final String name = "juicer";
	
	public CookingPlusJuicer(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("juicer");
		setCreativeTab(CreativeTabs.tabMisc);
		//setTextureName(CookingPlusMain.MODID + ":cakebatter");
		setMaxStackSize(1);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
