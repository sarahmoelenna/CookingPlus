package CookingPlus.blocks.crops;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomCrops;

public class CookingPlusEasyCrop extends CookingPlusCustomCrops
{

	private String name;
	private Block GroundBlock;
	private Item SeedItem;
	private Item HarvestItem;
	
    public CookingPlusEasyCrop(String myName)
    {
    	name = myName;
    	GameRegistry.registerBlock(this, name);
        this.setUnlocalizedName(name);
    }

    @Override
    protected Item GetSeedItem(){
    	return SeedItem;
    }
    
    @Override
    protected Item GetHarvestItem(){
    	return HarvestItem;
    }
  
    @Override
	public String getName()
	{
		return name;
	}
    
    public void SetData(Block myGround, Item myHarvest, Item mySeed){
    	GroundBlock = myGround;
    	HarvestItem = myHarvest;
    	SeedItem = mySeed;
    }
    
    @Override
    protected boolean canPlaceBlockOn(Block parBlock)
    {
        return parBlock == GroundBlock;
    }
    
    @Override
    protected boolean stillOnFarm(World parWorld, int parX, int parY, int parZ){
    	//System.out.println("A");
    	if(GetWorldBlock(parWorld, parX, parY - 1, parZ) != null){
    		//System.out.println("B");
    		if(GetWorldBlock(parWorld, parX, parY - 1, parZ).equals(GroundBlock)){
    			//System.out.println("C");
    			return true;
    		}
    	}
		return false;
    }

    @Override
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        return worldIn.getBlockState(pos.down()).getBlock() == GroundBlock;
    }
    
}
    
    