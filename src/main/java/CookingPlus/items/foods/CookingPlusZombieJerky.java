package CookingPlus.items.foods;

import CookingPlus.items.CookingPlusCustomEdibleFood;
import CookingPlus.items.CookingPlusCustomJuice;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusZombieJerky extends CookingPlusCustomEdibleFood
{

	private final String name = "zombiejerky";
	
    public CookingPlusZombieJerky() 
    {
        super(2, 1F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName(name);
        setPotionEffect(Potion.confusion.getId(), 40, 5, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}