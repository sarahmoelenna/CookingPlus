package CookingPlus.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusMultiStackItem extends CookingPlusCustomItem {

private String name;
	
	public CookingPlusMultiStackItem(String myName){
		name = myName;
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(name);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
