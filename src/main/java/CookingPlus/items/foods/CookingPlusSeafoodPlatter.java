package CookingPlus.items.foods;

import CookingPlus.items.CookingPlusCustomEdibleFood;
import CookingPlus.items.CookingPlusCustomJuice;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusSeafoodPlatter extends CookingPlusCustomEdibleFood
{

	private final String name = "seafoodplatter";
	
	public CookingPlusSeafoodPlatter() 
    {
        super(12, 8F);
        GameRegistry.registerItem(this, name);
        setUnlocalizedName(name);
        setPotionEffect(32, 300, 25, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}