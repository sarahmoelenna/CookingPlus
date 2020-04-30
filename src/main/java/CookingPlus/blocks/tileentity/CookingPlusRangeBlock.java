package CookingPlus.blocks.tileentity;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.tiles.CookingPlusRangeBlockTileEntity;

public class CookingPlusRangeBlock extends CookingPlusCustomTileEntityBlock {

	private final String name = "rangeblock";
	
	public CookingPlusRangeBlock() {
		super(Material.IRON);
		this.setUnlocalizedName(name);
		this.setTickRandomly(false);
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new CookingPlusRangeBlockTileEntity();
	}
	
	public String GetName(){
		return name;
	}
	
	@Override
	public void updateTick(World myWorld, BlockPos myPos, IBlockState myState, Random myRand)
	{	
		if(!canPlaceBlockAt(myWorld, myPos)){
			this.dropBlockAsItem(myWorld, myPos, myState, 0);
			myWorld.setBlockState(myPos, Blocks.AIR.getDefaultState());
		}
	}
	
	 @Override
	 	public boolean canPlaceBlockAt(World parWorld, BlockPos myPos)
	    {
			if(parWorld.getBlockState(myPos.east()).getBlock() instanceof CookingPlusBotBlock){
				return true;
			}
			if(parWorld.getBlockState(myPos.west()).getBlock() instanceof CookingPlusBotBlock){
				return true;
			}
			if(parWorld.getBlockState(myPos.north()).getBlock() instanceof CookingPlusBotBlock){
				return true;
			}
			if(parWorld.getBlockState(myPos.south()).getBlock() instanceof CookingPlusBotBlock){
				return true;
			}
			return false;
	    }
	
	

}
