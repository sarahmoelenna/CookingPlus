package CookingPlus.items.Drinks;

import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomHerbalTea;

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
