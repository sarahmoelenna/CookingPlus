package CookingPlus.blocks.tileentity;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.tiles.FisherTileEntity;

public class CookingPlusFisherBlock extends CookingPlusCustomTileEntityBlock {

	private final String name = "fisherblock";
	
	public static final PropertyInteger LEVEL = PropertyInteger.create("level",0, 15);
	
	public CookingPlusFisherBlock() {
		super(Material.WATER);
		this.setUnlocalizedName(name);
		this.setTickRandomly(false);
		this.setDefaultState(this.blockState.getBaseState().withProperty(LEVEL,Integer.valueOf(0)));
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((Integer) state.getValue(LEVEL)).intValue();
	}

	@Override
	protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {LEVEL});
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(LEVEL, Integer.valueOf(meta));
    }

	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new FisherTileEntity();
	}
	
	public String GetName(){
		return name;
	}
	
	@Override
    public int getRenderType() {
            return -1;
    }
    
    //It's not an opaque cube, so you need this.
    @Override
    public boolean isOpaqueCube() {
            return false;
    }
    
    //It's not a normal block, so you need this too.
    public boolean renderAsNormalBlock() {
            return false;
    }
    
    @Override
    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos)
    {
        return false;
    }
    
    @Override
    public void updateTick(World myWorld, BlockPos myPos, IBlockState myState, Random rand)
	{	
    	System.out.println("hmm");
		if(!canPlaceBlockAt(myWorld, myPos)){
			this.dropBlockAsItem(myWorld, myPos, myState, 0);
			myWorld.setBlockState(myPos, Blocks.WATER.getDefaultState());
		}
	}
    
    @Override
	public boolean canPlaceBlockAt(World parWorld, BlockPos myPos)
    {
		if(parWorld.getBlockState(myPos.up()).getBlock() instanceof CookingPlusBotBlock){
			if(parWorld.getBlockState(myPos.east()).getBlock().getMaterial(parWorld.getBlockState(myPos.east())) == Material.WATER){
				if(parWorld.getBlockState(myPos.west()).getBlock().getMaterial(parWorld.getBlockState(myPos.west())) == Material.WATER){
					if(parWorld.getBlockState(myPos.north()).getBlock().getMaterial(parWorld.getBlockState(myPos.north())) == Material.WATER){
						if(parWorld.getBlockState(myPos.south()).getBlock().getMaterial(parWorld.getBlockState(myPos.south())) == Material.WATER){
							if(parWorld.getBlockState(myPos.down()).getBlock().getMaterial(parWorld.getBlockState(myPos.up())) == Material.WATER){
								return true;
							}
						}
					}
				}
			}
		}
		return false;
    }
    

}
