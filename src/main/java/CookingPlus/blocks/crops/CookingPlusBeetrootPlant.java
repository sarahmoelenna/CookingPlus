package CookingPlus.blocks.crops;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomCrops;

public class CookingPlusBeetrootPlant extends CookingPlusCustomCrops
{

	private final String name = "beetrootcrop";
	
    public CookingPlusBeetrootPlant()
    {
        // Basic block setup
    	GameRegistry.registerBlock(this, name);
        this.setUnlocalizedName("beetrootcrop");
        //setBlockTextureName("cookingplus:chilli_stage_0");	//rename
    }

    @Override
    protected Item GetSeedItem(){
    	return CookingPlusMain.beetrootseed;
    }
    
    @Override
    protected Item GetHarvestItem(){
    	return CookingPlusMain.beetroot;
    }
  
    @Override
	public String getName()
	{
		return name;
	}

}
    
    