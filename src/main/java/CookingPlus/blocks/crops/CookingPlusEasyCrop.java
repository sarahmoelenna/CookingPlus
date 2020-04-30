package CookingPlus.blocks.crops;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
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
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        Block soil = worldIn.getBlockState(pos.down()).getBlock();
        return soil == GroundBlock;
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
    
    