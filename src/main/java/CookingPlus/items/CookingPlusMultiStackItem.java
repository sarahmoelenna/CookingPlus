package CookingPlus.items;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusMultiStackItem extends CookingPlusCustomItem {

private String name;
	
	public CookingPlusMultiStackItem(String myName){
		name = myName;
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(name);
	}
	
	public CookingPlusMultiStackItem(String myName, int stackSize){
		name = myName;
		this.setMaxStackSize(stackSize);
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(name);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
