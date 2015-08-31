package CookingPlus.items;

import CookingPlus.CookingPlusMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusCookieBatter extends CookingPlusCustomItem {

	private final String name = "cookiebatter";
	
	public CookingPlusCookieBatter(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("cookiebatter");
		setCreativeTab(CreativeTabs.tabMisc);
		//setTextureName(CookingPlusMain.MODID + ":dough");
		setMaxStackSize(1);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
