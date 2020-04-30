package CookingPlus.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusVanillaEssence extends CookingPlusCustomItem {

	private final String name = "vanillaessence";
	
	public CookingPlusVanillaEssence(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("vanillaessence");
		setCreativeTab(CreativeTabs.MISC);
		//setTextureName(CookingPlusMain.MODID + ":flour");
		this.setMaxStackSize(16);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
