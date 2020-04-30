package CookingPlus.items.PotteryStuff;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusPotteryGuideTeapot extends CookingPlusCustomItem {

	private final String name = "potteryguideteapot";
	
	public CookingPlusPotteryGuideTeapot(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("potteryguideteapot");
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
