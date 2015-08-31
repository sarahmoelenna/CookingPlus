package CookingPlus.items.Drinks;

import CookingPlus.items.CookingPlusCustomJuice;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusGooseBerryJuice extends CookingPlusCustomJuice
{

	private final String name = "gooseberryjuice";
	
    public CookingPlusGooseBerryJuice() 
    {
        super(3, 1F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("gooseberryjuice");
        //setTextureName("cookingplus:blueberry");
        setCreativeTab(CreativeTabs.tabFood);
        setPotionEffect(32, 40, 5, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}