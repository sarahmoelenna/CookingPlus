package CookingPlus.items.Drinks;

import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomHerbalTea;

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
