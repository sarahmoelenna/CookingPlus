package CookingPlus.blocks.crops;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomCrops;

public class CookingPlusCottonPlant extends CookingPlusCustomCrops
{

	private final String name = "cottoncrop";
	
    public CookingPlusCottonPlant()
    {
        // Basic block setup
    	GameRegistry.registerBlock(this, name);
        this.setUnlocalizedName("cottoncrop");
        //setBlockTextureName("cookingplus:chilli_stage_0");	//rename
    }

    @Override
    protected Item GetSeedItem(){
    	return CookingPlusMain.cottonseed;
    }
    
    @Override
    protected Item GetHarvestItem(){
    	return CookingPlusMain.cottonbud;
    }
  
    @Override
	public String getName()
	{
		return name;
	}

}
    
    