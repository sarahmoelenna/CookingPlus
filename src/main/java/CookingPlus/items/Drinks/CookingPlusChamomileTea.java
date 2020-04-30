package CookingPlus.items.Drinks;

import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomHerbalTea;

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
