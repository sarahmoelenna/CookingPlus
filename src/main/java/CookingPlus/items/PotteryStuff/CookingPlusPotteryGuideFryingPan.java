package CookingPlus.items.PotteryStuff;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusPotteryGuideFryingPan extends CookingPlusCustomItem {

	private final String name = "potteryguidefryingpan";
	
	public CookingPlusPotteryGuideFryingPan(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("potteryguidefryingpan");
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
