package CookingPlus.items.Drinks;

import CookingPlus.items.CookingPlusCustomHerbalTea;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusBuchuTea extends CookingPlusCustomHerbalTea {

	private final String name = "herbalteabuchu";
	
	public CookingPlusBuchuTea(){
		super();
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("herbalteabuchu");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
	@Override
	public int getPotionID(){
		 return 9;
	 }
	
}
