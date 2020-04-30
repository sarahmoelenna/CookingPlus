package CookingPlus.items.Drinks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomJuice;

public class CookingPlusGooseBerryJuice extends CookingPlusCustomJuice
{

	private final String name = "gooseberryjuice";
	
    public CookingPlusGooseBerryJuice() 
    {
        super(3, 1F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("gooseberryjuice");
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