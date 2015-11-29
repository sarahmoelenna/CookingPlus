package CookingPlus.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import CookingPlus.CookingPlusMain;
import CookingPlus.generation.CookingPlusGenOriginalTree;

public class CookingPlusCustomSapling extends BlockBush implements IGrowable {

		public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);
	
		public CookingPlusCustomSapling(String name){
			this.setUnlocalizedName(name);
			this.setStepSound(soundTypeGrass);
		}
	
		//igrowable.....
		// checks if finished growing (a grow stage of 7 is final stage)
		
		@Override
	    public boolean canGrow(World parWorld, BlockPos MyPos, IBlockState state, boolean p_149851_5_)
	    {
		 	//has grown fully?
	        return true;
	    }

	    /*
	     * (non-Javadoc)
	     * @see net.minecraft.block.IGrowable#func_149852_a(net.minecraft.world.World, 
	     * java.util.Random, int, int, int)
	     */
	    @Override
	    public boolean canUseBonemeal(World p_149852_1_, Random parRand, BlockPos pos, IBlockState state)
	    {	
	    	//can use bonemeal?
	    	return (double)p_149852_1_.rand.nextFloat() < 0.45D;
	    }

	    /*
	     * (non-Javadoc)
	     * @see net.minecraft.block.IGrowable#func_149853_b(net.minecraft.world.World, 
	     * java.util.Random, int, int, int)
	     */
	    @Override
	    public void grow(World parWorld, Random parRand, BlockPos pos, IBlockState state)
	    {
	    	//grow me
	    	this.growTree(parWorld, pos.getX(), pos.getY(), pos.getZ(), state, parRand);
	    }

	    //block stuff
	    @Override
	    public void updateTick(World myWorld, BlockPos myPos, IBlockState myState, Random myRand)
	    {
	        if (!myWorld.isRemote)
	        {
	            super.updateTick(myWorld, myPos, myState, myRand);
	            //System.out.println("Check");
	            if (myWorld.getLightFromNeighbors(myPos.up()) >= 9 && myRand.nextInt(7) == 0)
	            {
	            	//System.out.println("light");
	                this.growTree(myWorld, myPos.getX(), myPos.getY(), myPos.getZ(), myState, myRand);
	            }
	        }
	    }

	    public void growTree(World myWorld, int parX, int parY, int parZ, IBlockState myState, Random myRand)
	    {
	        int i = ((Integer)myState.getValue(AGE)).intValue() + MathHelper.getRandomIntegerInRange(myWorld.rand, 2, 5);
	        if ((i & 8) == 0)
	        {
	        	myWorld.setBlockState(new BlockPos(new Vec3(parX, parY, parZ)), myState.withProperty(AGE, Integer.valueOf(i)), 2);
	        }
	        else
	        {
	        	SetWorldBlock(myWorld, parX, parY, parZ, Blocks.air, 0, 2);
	            this.GenTree(myWorld, parX, parY, parZ, myRand);
	        }
	    }
	    
	    public void GenTree(World myWorld, int x, int y, int z, Random myRand){
	    	WorldGenerator myGen = new CookingPlusGenOriginalTree(Blocks.log, CookingPlusMain.blockAppleLeaves, 0, 0, 3);
	    	myGen.generate(myWorld, myRand, new BlockPos(new Vec3(x, y, z)));
	    }
	    
	    private void SetWorldBlock(World myWorld, int x, int y, int z, Block newBlock, int meta, int notify){
			myWorld.setBlockState(new BlockPos(new Vec3(x, y, z)), newBlock.getDefaultState()); 
		}
		
		private Block GetWorldBlock(World myWorld, int x, int y, int z){
			return myWorld.getBlockState(new BlockPos(new Vec3(x, y, z))).getBlock();
		}
	   
		@Override
		public int quantityDropped(IBlockState myState, int fortune, Random random) {
		    return 1;
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
	    protected BlockState createBlockState()
	    {
	        return new BlockState(this, new IProperty[] {AGE});
	    }
}
