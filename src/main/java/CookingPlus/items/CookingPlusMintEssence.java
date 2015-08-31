package CookingPlus.items;

import CookingPlus.CookingPlusMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusMintEssence extends CookingPlusCustomItem {

	private final String name = "mintessence";
	
	public CookingPlusMintEssence(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("mintessence");
		this.setMaxStackSize(16);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
