package CookingPlus.blocks.crops;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
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
    
    