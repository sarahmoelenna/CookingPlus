package CookingPlus.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusPestle extends CookingPlusCustomItem {

	private final String name = "pestle";
	
	public CookingPlusPestle(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("pestle");
		setCreativeTab(CreativeTabs.MISC);
		//setTextureName(CookingPlusMain.MODID + ":pestle");
		setMaxStackSize(1);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
