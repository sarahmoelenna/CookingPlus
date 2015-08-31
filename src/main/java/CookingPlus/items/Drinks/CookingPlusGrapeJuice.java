package CookingPlus.items.Drinks;

import CookingPlus.items.CookingPlusCustomJuice;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusGrapeJuice extends CookingPlusCustomJuice
{

	private final String name = "grapejuice";
	
    public CookingPlusGrapeJuice() 
    {
        super(3, 1F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("grapejuice");
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