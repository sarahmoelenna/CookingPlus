package CookingPlus.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusStarUncooked extends CookingPlusCustomItem {

	private final String name = "staruncooked";
	
	public CookingPlusStarUncooked(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("staruncooked");
		setCreativeTab(CreativeTabs.MISC);
		//setTextureName(CookingPlusMain.MODID + ":dough");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
