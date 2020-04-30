package CookingPlus.items.Drinks;

import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomHerbalTea;

public class CookingPlusRosemaryTea extends CookingPlusCustomHerbalTea {

	private final String name = "herbaltearosemary";
	
	public CookingPlusRosemaryTea(){
		super();
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("herbaltearosemary");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
	@Override
	public int getPotionID(){
		 return 2;
	 }
	
}
