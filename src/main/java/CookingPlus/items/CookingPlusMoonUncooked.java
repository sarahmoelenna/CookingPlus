package CookingPlus.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusMoonUncooked extends CookingPlusCustomItem {

	private final String name = "moonuncooked";
	
	public CookingPlusMoonUncooked(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("moonuncooked");
		setCreativeTab(CreativeTabs.MISC);
		//setTextureName(CookingPlusMain.MODID + ":dough");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
