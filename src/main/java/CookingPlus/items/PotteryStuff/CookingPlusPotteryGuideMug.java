package CookingPlus.items.PotteryStuff;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusPotteryGuideMug extends CookingPlusCustomItem {

	private final String name = "potteryguidemug";
	
	public CookingPlusPotteryGuideMug(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("potteryguidemug");
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
