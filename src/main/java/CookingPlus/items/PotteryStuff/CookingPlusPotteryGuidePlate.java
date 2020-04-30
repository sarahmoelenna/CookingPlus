package CookingPlus.items.PotteryStuff;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusPotteryGuidePlate extends CookingPlusCustomItem {

	private final String name = "potteryguideplate";
	
	public CookingPlusPotteryGuidePlate(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("potteryguideplate");
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
