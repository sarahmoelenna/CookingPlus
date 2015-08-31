package CookingPlus.items;

import CookingPlus.CookingPlusMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusStarUncooked extends CookingPlusCustomItem {

	private final String name = "staruncooked";
	
	public CookingPlusStarUncooked(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("staruncooked");
		setCreativeTab(CreativeTabs.tabMisc);
		//setTextureName(CookingPlusMain.MODID + ":dough");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
