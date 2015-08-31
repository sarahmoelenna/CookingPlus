package CookingPlus.items.foods;

import CookingPlus.items.CookingPlusCustomEdibleFood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusSaltedChicken extends CookingPlusCustomEdibleFood {
	
	private final String name = "saltedchicken";
	
	public CookingPlusSaltedChicken() 
    {
        super(6, 4);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("saltedchicken");
        setCreativeTab(CreativeTabs.tabFood);
        setPotionEffect(32, 100, 10, 100);
    }

	@Override
    public String getName()
    {
    	return name;
    }
}
