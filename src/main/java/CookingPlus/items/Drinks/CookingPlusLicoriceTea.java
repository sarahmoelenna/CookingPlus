package CookingPlus.items.Drinks;

import CookingPlus.items.CookingPlusCustomHerbalTea;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusLicoriceTea extends CookingPlusCustomHerbalTea {

	private final String name = "herbaltealicorice";
	
	public CookingPlusLicoriceTea(){
		super();
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("herbaltealicorice");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
	@Override
	public int getPotionID(){
		 return 4;
	 }
	
}
