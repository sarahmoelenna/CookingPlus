package CookingPlus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class CookingPlusCustomRenderedBlock extends Block {

	AxisAlignedBB MY_FULL_BLOCK_AABB;
	
    public CookingPlusCustomRenderedBlock(Material materialIn) {
		super(materialIn);
		this.setLightOpacity(0);	
	}

	public static final IUnlistedProperty<Integer> JAI = new IUnlistedProperty<Integer>() {
        @Override
        public String getName() {
            return "justAnotherInteger";
        }
        @Override
        public boolean isValid(Integer value) {
            return true;
        }
        @Override
        public Class<Integer> getType() {
            return Integer.class;
        }
        @Override
        public String valueToString(Integer value) {
            return value.toString();
        }
    };

    @Override
    protected BlockStateContainer createBlockState() {
        return new ExtendedBlockState(this, new IProperty[] { }, new IUnlistedProperty[]{ JAI }); // maybe need to add listed property?
    }

    @Override
    public IBlockState getExtendedState(IBlockState state, IBlockAccess world, BlockPos pos) {
        if(state instanceof IExtendedBlockState) {
            return ((IExtendedBlockState)state).withProperty(JAI, pos.getY());
        }
        return state;
    }
    
    public String getName(){
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
    @SideOnly(Side.CLIENT)
	 public BlockRenderLayer getBlockLayer()
	 {
	     return BlockRenderLayer.CUTOUT;
	 }
    
    @Override
	public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return false;
    }

}