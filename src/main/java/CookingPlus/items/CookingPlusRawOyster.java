package CookingPlus.items;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusRawOyster extends CookingPlusCustomEdibleFood {

	private final String name = "rawoyster";
	
	public CookingPlusRawOyster() 
    {
        super(1, 0.3F);	//change this
        GameRegistry.registerItem(this, name);
        setUnlocalizedName(name);
    }
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
