package CookingPlus.items.foods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomEdibleFood;

public class CookingPlusSheepJerky extends CookingPlusCustomEdibleFood
{

	private final String name = "sheepjerky";
	
    public CookingPlusSheepJerky() 
    {
        super(2, 1F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("sheepjerky");
        setCreativeTab(CreativeTabs.FOOD);
        setPotionEffect(32, 40, 5, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}