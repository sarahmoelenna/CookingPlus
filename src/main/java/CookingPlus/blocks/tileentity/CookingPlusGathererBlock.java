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
import CookingPlus.tiles.CookingPlusGathererTileEntity;

public class CookingPlusGathererBlock extends CookingPlusCustomTileEntityBlock {

	private final String name = "gathererblock";
	
	public CookingPlusGathererBlock() {
		super(Material.IRON);
		this.setUnlocalizedName(name);
		this.setTickRandomly(false);
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new CookingPlusGathererTileEntity();
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
			if(parWorld.getBlockState(myPos.up()).getBlock() instanceof CookingPlusBotBlock){
				return true;
			}
			return false;
	    }
	
	

}
