package CookingPlus.items;

import CookingPlus.CookingPlusMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusKnife extends CookingPlusCustomItem {

	private final String name = "knife";
	
	public CookingPlusKnife(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("knife");
		//setTextureName(CookingPlusMain.MODID + ":knife");
		setMaxStackSize(1);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
