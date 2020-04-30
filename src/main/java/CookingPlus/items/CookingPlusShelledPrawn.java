package CookingPlus.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusShelledPrawn extends CookingPlusCustomItem {
	
	private final String name = "prawn";
	
	public CookingPlusShelledPrawn(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("prawn");
		setCreativeTab(CreativeTabs.MISC);
		//setTextureName(CookingPlusMain.MODID + ":prawn");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
