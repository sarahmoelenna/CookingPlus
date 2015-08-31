package CookingPlus.items.Harvest;

import CookingPlus.items.CookingPlusCustomEdibleFood;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusBlueBerry extends CookingPlusCustomEdibleFood
{

	private final String name = "blueberry";
	
    public CookingPlusBlueBerry() 
    {
        super(1, 0.3F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("blueberry");
        //setTextureName("cookingplus:blueberry");
        setCreativeTab(CreativeTabs.tabFood);
        setPotionEffect(32, 20, 0, 100);
    }
    
    @Override
    public String getName()
    {
    	return name;
    }
}