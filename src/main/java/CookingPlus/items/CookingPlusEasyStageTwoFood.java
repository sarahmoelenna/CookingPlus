package CookingPlus.items;

import CookingPlus.items.CookingPlusCustomEdibleFood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusEasyStageTwoFood extends CookingPlusCustomEdibleFood
{

	private String name;
	
    public CookingPlusEasyStageTwoFood(String myName) 
    {
    	super(3, 0.5F);	//change this
    	name = myName;
        GameRegistry.registerItem(this, name);
        setUnlocalizedName(name);
        setPotionEffect(32, 50, 5, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}