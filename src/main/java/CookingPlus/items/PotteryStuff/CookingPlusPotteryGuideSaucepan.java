package CookingPlus.items.PotteryStuff;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusPotteryGuideSaucepan extends CookingPlusCustomItem {

	private final String name = "potteryguidesaucepan";
	
	public CookingPlusPotteryGuideSaucepan(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(name);
		setMaxStackSize(1);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
