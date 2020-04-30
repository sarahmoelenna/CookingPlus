package CookingPlus.blocks.crops;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomCrops;

public class CookingPlusChilliPlant extends CookingPlusCustomCrops
{

	private final String name = "chillicrop";
	
    public CookingPlusChilliPlant()
    {
        // Basic block setup
    	GameRegistry.registerBlock(this, name);
        this.setUnlocalizedName("chillicrop");
        //setBlockTextureName("cookingplus:chilli_stage_0");	//rename
    }

    @Override
    protected Item GetSeedItem(){
    	return CookingPlusMain.chilliseed;
    }
    
    @Override
    protected Item GetHarvestItem(){
    	return CookingPlusMain.chilli;
    }
  
    @Override
	public String getName()
	{
		return name;
	}

}
    
    