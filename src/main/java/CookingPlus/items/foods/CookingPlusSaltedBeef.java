package CookingPlus.items.foods;

import CookingPlus.items.CookingPlusCustomEdibleFood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusSaltedBeef extends CookingPlusCustomEdibleFood {
	
	private final String name = "saltedbeef";
	
	public CookingPlusSaltedBeef() 
    {
        super(6, 4);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("saltedbeef");
        //setTextureName("cookingplus:cookedprawn");
        setCreativeTab(CreativeTabs.tabFood);
        setPotionEffect(32, 100, 10, 100);
    }

	@Override
    public String getName()
    {
    	return name;
    }
}
