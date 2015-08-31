package CookingPlus.items.Drinks;

import CookingPlus.items.CookingPlusCustomHerbalTea;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusMintTea extends CookingPlusCustomHerbalTea {

	private final String name = "herbalteamint";
	
	public CookingPlusMintTea(){
		super();
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("herbalteamint");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
	@Override
	public int getPotionID(){
		 return 19;
	 }
	
}
