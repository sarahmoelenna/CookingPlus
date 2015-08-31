package CookingPlus.items.foods;

import CookingPlus.items.CookingPlusCustomEdibleFood;
import CookingPlus.items.CookingPlusCustomJuice;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusPorkJerky extends CookingPlusCustomEdibleFood
{

	private final String name = "porkjerky";
	
    public CookingPlusPorkJerky() 
    {
        super(2, 1F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("porkjerky");
        setCreativeTab(CreativeTabs.tabFood);
        setPotionEffect(32, 40, 5, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}