package CookingPlus.items;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusRack extends CookingPlusCustomItem {

	private final String name = "rack";
	
	public CookingPlusRack(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("rack");
		//setCreativeTab(CreativeTabs.MISC);
		//setTextureName(CookingPlusMain.MODID + ":rack");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
