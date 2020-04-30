package CookingPlus.items.PotteryStuff;

import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

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
