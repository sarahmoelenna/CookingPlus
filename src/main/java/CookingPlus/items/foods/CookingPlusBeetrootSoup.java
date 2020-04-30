package CookingPlus.items.foods;

import net.minecraft.creativetab.CreativeTabs;
import CookingPlus.items.CookingPlusCustomEdibleFood;

public class CookingPlusBeetrootSoup extends CookingPlusCustomEdibleFood
{

	private final String name = "beetrootsoup";
	
    public CookingPlusBeetrootSoup() 
    {
        super(6, 7.2F);	//change this
        //GameRegistry.registerItem(this, name);
        //setUnlocalizedName("beetrootsoup");
        //setTextureName("cookingplus:blueberry");
        setCreativeTab(CreativeTabs.FOOD);
        setPotionEffect(32, 20, 0, 100);
        this.setMaxStackSize(1);
    }
    

    
    @Override
    public String getName()
    {
    	return name;
    }
}