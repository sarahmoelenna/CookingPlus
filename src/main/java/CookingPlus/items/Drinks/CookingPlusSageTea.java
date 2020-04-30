package CookingPlus.items.Drinks;

import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomHerbalTea;

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
