package CookingPlus.items.Drinks;

import CookingPlus.items.CookingPlusCustomHerbalTea;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusChamomileTea extends CookingPlusCustomHerbalTea {

	private final String name = "herbalteachamomile";
	
	public CookingPlusChamomileTea(){
		super();
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("herbalteachamomile");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
	@Override
	public int getPotionID(){
		 return 15;
	 }
	
}
