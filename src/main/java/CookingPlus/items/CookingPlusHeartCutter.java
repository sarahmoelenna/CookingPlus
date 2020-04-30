package CookingPlus.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusHeartCutter extends CookingPlusCustomItem {

	private final String name = "heartcutter";
	
	public CookingPlusHeartCutter(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("heartcutter");
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
