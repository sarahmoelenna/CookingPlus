package CookingPlus.items.Drinks;

import CookingPlus.items.CookingPlusCustomJuice;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusEasyJuice extends CookingPlusCustomJuice
{

	private String name;
	
    public CookingPlusEasyJuice(String myName) 
    {
        super(3, 1F);	//change this
        name = myName;
        GameRegistry.registerItem(this, name);
        setUnlocalizedName(name);
        setPotionEffect(32, 40, 5, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}