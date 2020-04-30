package CookingPlus.items.PotteryStuff;

import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

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
