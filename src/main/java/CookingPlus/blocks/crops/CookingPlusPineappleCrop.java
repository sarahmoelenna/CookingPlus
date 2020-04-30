package CookingPlus.blocks.crops;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomCrops;

public class CookingPlusPineappleCrop extends CookingPlusCustomCrops
{

	private final String name = "pineapplecrop";
	
    public CookingPlusPineappleCrop()
    {
        // Basic block setup
    	GameRegistry.registerBlock(this, name);
        this.setUnlocalizedName(name);
    }

    @Override
    protected Item GetSeedItem(){
    	return CookingPlusMain.pineappleseed;
    }
    
    @Override
    protected Item GetHarvestItem(){
    	return CookingPlusMain.pineapple;
    }
  
    @Override
	public String getName()
	{
		return name;
	}

}
    
    