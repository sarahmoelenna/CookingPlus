package CookingPlus.items.Drinks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomJuice;

public class CookingPlusPeachJuice extends CookingPlusCustomJuice
{

	private final String name = "peachjuice";
	
    public CookingPlusPeachJuice() 
    {
        super(3, 1F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("peachjuice");
        //setTextureName("cookingplus:blueberry");
        setCreativeTab(CreativeTabs.FOOD);
        setPotionEffect(32, 40, 5, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}