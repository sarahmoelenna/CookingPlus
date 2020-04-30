package CookingPlus.blocks.tileentity;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CookingPlusCustomTileEntityBlock extends BlockContainer {

	AxisAlignedBB MY_FULL_BLOCK_AABB;
	
	protected CookingPlusCustomTileEntityBlock(Material materialIn) {
		super(materialIn);
		this.isBlockContainer = true;
		this.lightOpacity = 0;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return null;
	}
	
	public String GetName(){
		return null;
	}
	
	//@Override
    //public int getRenderType() {
    //        return -1;
    //}
	
	public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.INVISIBLE;
    }
    
    
    //It's not a normal block, so you need this too.
    public boolean renderAsNormalBlock() {
            return false;
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
        return false;
    }
	
	public int getRenderType() {
        return -1;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
		return false;
    }
	
	@Override
	public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return false;
    }
	
	
	


}
