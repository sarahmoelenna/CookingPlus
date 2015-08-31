package CookingPlus.items.PotteryStuff;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusSoakedBook extends CookingPlusCustomItem {

	private final String name = "soakedbook";
	
	public CookingPlusSoakedBook(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("soakedbook");
		setMaxStackSize(1);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
