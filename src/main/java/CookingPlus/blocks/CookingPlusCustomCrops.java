package CookingPlus.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusCustomCrops extends BlockCrops implements IGrowable
{
    protected int maxGrowthStage = 7;
    AxisAlignedBB MY_FULL_BLOCK_AABB;
    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);

    //@SideOnly(Side.CLIENT)
    //protected IIcon[] iIcon;

    public CookingPlusCustomCrops()
    {
     // Basic block setup
        setTickRandomly(true);
        float f = 0.5F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
        //setCreativeTab((CreativeTabs)null);
        setHardness(0.0F);
        setSoundType(SoundType.GROUND);
        disableStats();
        this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)));
    }

    /**
     * is the block grass, dirt or farmland
     */
    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        Block soil = worldIn.getBlockState(pos.down()).getBlock();
        return soil == Blocks.FARMLAND;
    }

    public void incrementGrowStage(World parWorld, Random parRand, BlockPos myPos, IBlockState myState)
    {
    	
        int growStage = ((Integer)myState.getValue(AGE)).intValue() + MathHelper.getRandomIntegerInRange(parRand, 2, 5);

        if (growStage > maxGrowthStage)
        {
         growStage = maxGrowthStage;
        }

        parWorld.setBlockState(myPos, myState.withProperty(AGE, Integer.valueOf(growStage)), 2);
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random random, int fortune)
    {
        return GetSeedItem();
    }

   

 // checks if finished growing (a grow stage of 7 is final stage)
    @Override
    public boolean canGrow(World parWorld, BlockPos myPos, IBlockState myState, boolean p_149851_5_)
    {
    	//System.out.println("function1");
        return ((Integer)myState.getValue(AGE)).intValue() != 7;
    }

    /*
     * (non-Javadoc)
     * @see net.minecraft.block.IGrowable#func_149852_a(net.minecraft.world.World, 
     * java.util.Random, int, int, int)
     */
    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
        return true;
    }

    /*
     * (non-Javadoc)
     * @see net.minecraft.block.IGrowable#func_149853_b(net.minecraft.world.World, 
     * java.util.Random, int, int, int)
     */
    @Override
    public void grow(World parWorld, Random parRand, BlockPos myPos, IBlockState myState)
    {
    	//System.out.println("function3" + " " + parX + " " + parY + " " + parZ);
        incrementGrowStage(parWorld, parRand, myPos, myState);
    }
    
    /**
     * Ticks the block if it's been scheduled
     */
    @Override
    public void updateTick(World parWorld, BlockPos myPos, IBlockState myState, Random parRand)
    {
        super.updateTick(parWorld, myPos, myState, parRand);
        int growStage = ((Integer)myState.getValue(AGE)).intValue() + 1;

        if (growStage > 7)
        {
            growStage = 7;
        }

        //System.out.println(parX + " " + parY + " " + parZ);
        parWorld.setBlockState(myPos, myState.withProperty(AGE, Integer.valueOf(growStage)), 2);
        //parWorld.setBlockMetadataWithNotify(parX, parY, parZ, growStage, 2);
    }
    
    protected boolean stillOnFarm(World parWorld, int parX, int parY, int parZ){
    	//System.out.println("A");
    	if(GetWorldBlock(parWorld, parX, parY - 1, parZ) != null){
    		//System.out.println("B");
    		if(GetWorldBlock(parWorld, parX, parY - 1, parZ).equals(Blocks.FARMLAND)){
    			//System.out.println("C");
    			return true;
    		}
    	}
		return false;
    }
    
    @Override
    public boolean canBlockStay(World world, BlockPos myPos, IBlockState myState){
		return stillOnFarm(world, myPos.getX(), myPos.getY(), myPos.getZ());
    }
    
    protected Block GetWorldBlock(World myWorld, int x, int y, int z){
		return myWorld.getBlockState(new BlockPos(new Vec3d(x, y, z))).getBlock();
	}

    protected Item GetSeedItem(){
    	return null;
    }
    
    protected Item GetHarvestItem(){
    	return null;
    }

    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos myPos, IBlockState myState, int fortune)
    {
    	List<ItemStack> ret = super.getDrops(world, myPos, myState, fortune);
        ret.clear();
        int growStage = ((Integer)myState.getValue(AGE)).intValue();
        
        ret.add(new ItemStack(GetSeedItem(), 1, 0)); //always drops at least one seed
        
        if (growStage >= 7)
        {
        	ret.add(new ItemStack(GetHarvestItem(), 1, 0)); //extra seeds if grown
        	//if(growStage == 7){ //if fully grown
            for (int i = 0; i < 2 + fortune; ++i)
            {
            	Random MyRand = new Random();
                if (MyRand.nextInt(40) <= growStage)
                {
                    ret.add(new ItemStack(GetSeedItem(), 1, 0)); //extra seeds if grown
                }
            }
        	//}
        }

        return ret;
    }
    
    @Override
    public int quantityDropped(IBlockState state, int fortune, Random random)
    {
        return (1);
    }
    
    public String getName(){
		return null;
	}

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(AGE, Integer.valueOf(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(AGE)).intValue();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {AGE});
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
}