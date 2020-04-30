package CookingPlus.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusCustomUnderwaterPlant extends Block {

	AxisAlignedBB MY_FULL_BLOCK_AABB;
	public static final PropertyInteger LEVEL = PropertyInteger.create("level",0, 15);

	public CookingPlusCustomUnderwaterPlant() {
		super(Material.WATER);
		this.setDefaultState(this.blockState.getBaseState().withProperty(LEVEL,Integer.valueOf(0)));
		// TODO Auto-generated constructor stub
	}

	@Override
    @SideOnly(Side.CLIENT)
	 public BlockRenderLayer getBlockLayer()
	 {
	     return BlockRenderLayer.CUTOUT;
	 }

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((Integer) state.getValue(LEVEL)).intValue();
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] { LEVEL });
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(LEVEL, Integer.valueOf(meta));
    }
	
	//public boolean canBlockStay(World world, BlockPos pos)
    //{
		//return (world.getBlockState(pos.north()).getBlock() == Blocks.WATER && (world.getBlockState(pos.west()).getBlock() == Blocks.WATER && world.getBlockState(pos.south()).getBlock() == Blocks.WATER && world.getBlockState(pos.east()).getBlock() == Blocks.WATER));
    //}
	
	public String getName()
	{
		return null;
	}
	
	
	
	public void setBlockBounds(float x1, float y1, float z1, float x2, float y2, float z2){
		MY_FULL_BLOCK_AABB = new AxisAlignedBB(x1, y1, z1, x2, y2, z2);
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
		if(MY_FULL_BLOCK_AABB != null){
			return MY_FULL_BLOCK_AABB;
		}
		else{
			return super.getBoundingBox(state, source, pos);
		}
    }
    
    
  //LETS FIX THESE OPAQUE CUBES
    public boolean isVisuallyOpaque()
    {
        return isOpaqueCube();
    }
	
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	
	//LETS FIX THESE FULL CUBES
	@Override
	public boolean isFullCube(IBlockState state)
    {
        return isFullCube();
    }
	
    public boolean isFullCube()
    {
        return false;
    }
	
    
    //LETS FIX OUR LEAVES
    @Override
    public boolean canSustainLeaves(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        return canSustainLeaves(world, pos);
    }
    
	public boolean canSustainLeaves(IBlockAccess world, BlockPos pos)
    {
        return true;
    }
	
	@Override
	public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return false;
    }
	
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB p_185477_4_, List<AxisAlignedBB> p_185477_5_, Entity p_185477_6_)
    {
        //addCollisionBoxToList(pos, p_185477_4_, p_185477_5_, state.getSelectedBoundingBox(worldIn, pos));
    }

}
