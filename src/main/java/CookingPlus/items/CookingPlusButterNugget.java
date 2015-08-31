package CookingPlus.items;

import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;

public class CookingPlusButterNugget extends CookingPlusCustomItem {

	private final String name = "butternugget";
	
	public CookingPlusButterNugget(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("butternugget");
		//setTextureName(CookingPlusMain.MODID + ":butternugget");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
}
