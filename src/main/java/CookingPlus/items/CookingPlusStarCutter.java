package CookingPlus.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusStarCutter extends CookingPlusCustomItem {

	private final String name = "starcutter";
	
	public CookingPlusStarCutter(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("starcutter");
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
