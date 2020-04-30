package CookingPlus.items.Harvest;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.items.CookingPlusCustomEdibleFood;

public class CookingPlusBeetroot extends CookingPlusCustomEdibleFood
{
	
	private final String name = "beetroot";

    public CookingPlusBeetroot() 
    {
        super(1, 0.3F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("beetroot");
        //setTextureName("cookingplus:chilli");
        setCreativeTab(CreativeTabs.FOOD);
        setPotionEffect(32, 20, 0, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}