package CookingPlus.items.Harvest;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomItem;

public class CookingPlusSageLeaf extends CookingPlusCustomItem {

	private final String name = "sageleaf";
	
	public CookingPlusSageLeaf(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("sageleaf");
		setCreativeTab(CreativeTabs.MISC);
		//setTextureName(CookingPlusMain.MODID + ":flour");
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
