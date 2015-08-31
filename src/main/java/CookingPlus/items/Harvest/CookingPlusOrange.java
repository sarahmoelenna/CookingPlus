package CookingPlus.items.Harvest;

import CookingPlus.items.CookingPlusCustomEdibleFood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusOrange extends CookingPlusCustomEdibleFood
{
	private final String name = "orange";

    public CookingPlusOrange() 
    {
        super(1, 0.5F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("orange");
        //setTextureName("cookingplus:lemon");
        setCreativeTab(CreativeTabs.tabFood);
        setPotionEffect(32, 20, 0, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}