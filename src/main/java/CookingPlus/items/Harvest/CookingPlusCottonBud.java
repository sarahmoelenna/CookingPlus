package CookingPlus.items.Harvest;

import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusCottonBud extends CookingPlusCustomItem {

	private final String name = "cottonbud";
	
	public CookingPlusCottonBud(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("cottonbud");
		//setCreativeTab(CreativeTabs.MISC);
		//setTextureName(CookingPlusMain.MODID + ":rack");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
