package CookingPlus.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusCreamBucket extends CookingPlusCustomItem {

	private final String name = "creambucket";
	
	public CookingPlusCreamBucket(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("creambucket");
		setCreativeTab(CreativeTabs.MISC);
		setMaxStackSize(1);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
