package CookingPlus.items.Harvest;

import CookingPlus.items.CookingPlusCustomEdibleFood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusEasyHarvest extends CookingPlusCustomEdibleFood
{

	private String name;
	
    public CookingPlusEasyHarvest(String myName) 
    {
        super(1, 0.3F);	//change this
        name = myName;
        GameRegistry.registerItem(this, name);
        setUnlocalizedName(name);
        setPotionEffect(32, 20, 0, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}