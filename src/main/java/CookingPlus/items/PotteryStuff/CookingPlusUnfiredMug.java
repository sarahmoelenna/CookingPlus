package CookingPlus.items.PotteryStuff;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusUnfiredMug extends CookingPlusCustomItem {

	private final String name = "unfiredmug";
	
	public CookingPlusUnfiredMug(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("unfiredmug");
		setCreativeTab(CreativeTabs.MISC);
		//setTextureName(CookingPlusMain.MODID + ":cakebatter");
		setMaxStackSize(16);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
