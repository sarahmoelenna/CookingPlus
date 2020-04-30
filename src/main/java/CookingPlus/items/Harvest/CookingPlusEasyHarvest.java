package CookingPlus.items.Harvest;

import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomEdibleFood;

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