package CookingPlus.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class CookingPlusCustomBlockBush extends CookingPlusCustomBlock implements IPlantable
{
    //private static final String __OBFID = "CL_00000208";

    protected CookingPlusCustomBlockBush(Material materialIn)
    {
        super(materialIn);
        this.setTickRandomly(true);
        float f = 0.2F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3.0F, 0.5F + f);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }

    protected CookingPlusCustomBlockBush()
    {
        this(Material.PLANTS);
    }

    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        IBlockState soil = worldIn.getBlockState(pos.down());
        return super.canPlaceBlockAt(worldIn, pos) && soil.getBlock().canSustainPlant(soil, worldIn, pos.down(), net.minecraft.util.EnumFacing.UP, this);
    }

    /**
     * is the block grass, dirt or farmland
     */
    protected boolean canPlaceBlockOn(Block ground)
    {
        return ground == Blocks.GRASS || ground == Blocks.DIRT || ground == Blocks.FARMLAND;
    }

    /**
     * Called when a neighboring block changes.
     */
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block neighborBlock)
    {
        super.neighborChanged(state, worldIn, pos, neighborBlock);
        this.checkAndDropBlock(worldIn, pos, state);
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        this.checkAndDropBlock(worldIn, pos, state);
    }

    protected void checkAndDropBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!this.canBlockStay(worldIn, pos, state))
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
        }
    }

    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        if (state.getBlock() == this) //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
        {
            IBlockState soil = worldIn.getBlockState(pos.down());
            return soil.getBlock().canSustainPlant(soil, worldIn, pos.down(), net.minecraft.util.EnumFacing.UP, this);
        }
        return this.func_185514_i(worldIn.getBlockState(pos.down()));
    }
    
    protected boolean func_185514_i(IBlockState state)
    {
        return state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.FARMLAND;
    }


    @Override
    public EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        return net.minecraftforge.common.EnumPlantType.Plains;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos)
    {
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() != this) return getDefaultState();
        return state;
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
        return true;
    }
	
	
	//LETS FIX THESE FULL CUBES
	@Override
	public boolean isFullCube(IBlockState state)
    {
        return isFullCube();
    }
	
    public boolean isFullCube()
    {
        return true;
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
    
}