package CookingPlus.items.PotteryStuff;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusMug extends CookingPlusCustomItem {

	private final String name = "mug";
	
	public CookingPlusMug(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("mug");
		setCreativeTab(CreativeTabs.tabMisc);
		//setTextureName(CookingPlusMain.MODID + ":cakebatter");
		setMaxStackSize(16);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
