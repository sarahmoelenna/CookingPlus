package CookingPlus.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusPancakeMix extends CookingPlusCustomItem {

	private final String name = "pancakemix";
	
	public CookingPlusPancakeMix(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("pancakemix");
		setCreativeTab(CreativeTabs.MISC);
		this.setMaxStackSize(1);
		//setTextureName(CookingPlusMain.MODID + ":flour");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
