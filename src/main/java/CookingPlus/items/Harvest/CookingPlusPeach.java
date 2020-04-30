package CookingPlus.items.Harvest;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomEdibleFood;

public class CookingPlusPeach extends CookingPlusCustomEdibleFood
{
	private final String name = "peach";

    public CookingPlusPeach() 
    {
        super(1, 0.5F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("peach");
        //setTextureName("cookingplus:peach");
        setCreativeTab(CreativeTabs.FOOD);
        setPotionEffect(32, 20, 0, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}