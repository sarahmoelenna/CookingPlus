package CookingPlus.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusCakeBatter extends CookingPlusCustomItem {

	private final String name = "cakebatter";
	
	public CookingPlusCakeBatter(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName("cakebatter");
		setCreativeTab(CreativeTabs.MISC);
		//setTextureName(CookingPlusMain.MODID + ":cakebatter");
		setMaxStackSize(1);
	}
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
