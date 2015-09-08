package CookingPlus.items;

import CookingPlus.items.CookingPlusCustomEdibleFood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusEasyStageThreeFood extends CookingPlusCustomEdibleFood
{

	private String name;
	
    public CookingPlusEasyStageThreeFood(String myName) 
    {
        super(6, 4);
        name = myName;
        GameRegistry.registerItem(this, name);
        setUnlocalizedName(name);
        setPotionEffect(32, 100, 10, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}