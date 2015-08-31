package CookingPlus.items;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusButterIngot extends CookingPlusCustomEdibleFood {
	
	private final String name = "butteringot";
	
	public CookingPlusButterIngot() 
    {
        super(1, 0.5F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName("butteringot");
        //setTextureName("cookingplus:butteringot");

    }
	
	@Override
    public String getName()
    {
    	return name;
    }

}
