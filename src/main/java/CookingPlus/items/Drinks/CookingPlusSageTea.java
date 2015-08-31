package CookingPlus.items.Drinks;

import CookingPlus.items.CookingPlusCustomHerbalTea;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusSageTea extends CookingPlusCustomHerbalTea {

	private final String name = "herbalteasage";
	
	public CookingPlusSageTea(){
		super();
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("herbalteasage");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
	@Override
	public int getPotionID(){
		 return 20;
	 }
	
}
