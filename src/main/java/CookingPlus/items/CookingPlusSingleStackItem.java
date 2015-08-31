package CookingPlus.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusSingleStackItem extends CookingPlusCustomItem {

private String name;
	
	public CookingPlusSingleStackItem(String myName){
		name = myName;
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(name);
		setMaxStackSize(1);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
