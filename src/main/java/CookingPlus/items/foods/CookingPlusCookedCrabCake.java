package CookingPlus.items.foods;

import CookingPlus.items.CookingPlusCustomEdibleFood;
import CookingPlus.items.CookingPlusCustomJuice;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusCookedCrabCake extends CookingPlusCustomEdibleFood
{

	private final String name = "cookedcrabcake";
	
	public CookingPlusCookedCrabCake() 
    {
        super(8, 6F);
        GameRegistry.registerItem(this, name);
        setUnlocalizedName(name);
        setPotionEffect(32, 200, 15, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}