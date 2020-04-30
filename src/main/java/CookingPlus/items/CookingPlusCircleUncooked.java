package CookingPlus.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusCircleUncooked extends CookingPlusCustomItem {

	private final String name = "circleuncooked";
	
	public CookingPlusCircleUncooked(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("circleuncooked");
		setCreativeTab(CreativeTabs.MISC);
		//setTextureName(CookingPlusMain.MODID + ":dough");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
