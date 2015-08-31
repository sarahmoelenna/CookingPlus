package CookingPlus.items.Harvest;

import CookingPlus.items.CookingPlusCustomEdibleFood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusBanana extends CookingPlusCustomEdibleFood
{

	private final String name = "banana";
	
    public CookingPlusBanana() 
    {
        super(1, 0.3F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("banana");
        setPotionEffect(32, 20, 0, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}