package CookingPlus.items.Drinks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomJuice;

public class CookingPlusBlueBerryJuice extends CookingPlusCustomJuice
{

	private final String name = "blueberryjuice";
	
    public CookingPlusBlueBerryJuice() 
    {
        super(3, 1F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("blueberryjuice");
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