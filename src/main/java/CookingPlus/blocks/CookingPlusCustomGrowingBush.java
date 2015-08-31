package CookingPlus.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusCustomGrowingBush extends CookingPlusCustomBlockBush implements IGrowable {
	 
	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);
	
	public CookingPlusCustomGrowingBush()
	    {
			setBlockBounds(0.0F, 0.0F, 0.0F, 1.0f, 1.0f, 1.0f);
			this.setHardness(1.0f);
			this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)));
	    }
	 
	@Override
	public boolean canBlockStay(World world, BlockPos myPos, IBlockState myState)
    {
		Block parBlock = world.getBlockState(myPos).getBlock();
    	if(parBlock == Blocks.dirt){
    		return true;
    	}
    	else if(parBlock == Blocks.grass){
    		return true;
    	}
    	else if(parBlock == Blocks.farmland){
    		return true;
    	}
    	else if(parBlock == getBushBlock()){
    		return true;
    	}
    	else return false;
    }
	
	public boolean canBlockGrow(World world, BlockPos myPos, IBlockState myState)
    {
		//System.out.println(world.getBlockState(myPos).getBlock().getLocalizedName());
		Block parBlock = world.getBlockState(new BlockPos(new Vec3(myPos.getX(), myPos.getY()-1, myPos.getZ()))).getBlock();
    	if(parBlock == Blocks.dirt){
    		return true;
    	}
    	else if(parBlock == Blocks.grass){
    		return true;
    	}
    	else if(parBlock == Blocks.farmland){
    		return true;
    	}
    	else return false;
    }
	
	@Override
	protected boolean canPlaceBlockOn(Block parBlock) {
		if(parBlock == Blocks.dirt){
    		return true;
    	}
    	else if(parBlock == Blocks.grass){
    		return true;
    	}
    	else if(parBlock == Blocks.farmland){
    		return true;
    	}
    	else if(parBlock == getBushBlock()){
    		return true;
    	}
    	else return false;
	}
    
    @Override
    public int getRenderType()
    {
        return 3;
    }
    
    @Override
    public boolean canUseBonemeal(World p_149852_1_, Random parRand, BlockPos pos, IBlockState state)
    {	
    	//can use bonemeal?
    	return false;
    }
    
    public Block getBushBlock(){
    	return null;
    }
    
    public Item getBushDrop(){
    	return null;
    }
    
    protected void growBush(World parWorld, Random parRand, int parX, int parY, int parZ, IBlockState state){
    	//System.out.println("A");
    	if(parRand.nextInt(10) > 2){
    		//System.out.println("B");
    		if(GetWorldBlock(parWorld, parX, parY + 1, parZ) != null){
    			//System.out.println("C");
    			if(GetWorldBlock(parWorld, parX, parY + 1, parZ).equals(Blocks.air)){
    				//System.out.println("D");
    				if(canGrow(parWorld, new BlockPos(new Vec3(parX, parY + 1, parZ)), state)){
    					//System.out.println("E");
    					SetWorldBlock(parWorld, parX, parY + 1, parZ, getBushBlock(), 0, 2);
    				}
    			}
    		}
    	}
    }
	
    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState myState, Random rand)
    {
        super.updateTick(worldIn, pos, myState, rand);
        int growStage = ((Integer)myState.getValue(AGE)).intValue() + 1;
        //System.out.println(growStage);
        if (growStage >= 7)
        {
        	growBush(worldIn, rand, pos.getX(), pos.getY(), pos.getZ(), myState);
            growStage = 7;
        }
        
        worldIn.setBlockState(pos, myState.withProperty(AGE, Integer.valueOf(growStage)), 2);
    }

    @Override
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos myPos, IBlockState myState, int fortune)
    {
    	List<ItemStack> ret = super.getDrops(world, myPos, myState, fortune);
        ret.clear();
        int growStage = ((Integer)myState.getValue(AGE)).intValue();
        
        ret.add(new ItemStack(Item.getItemFromBlock(getBushBlock()), 1, 0)); //always drops at least one seed
        
        if (growStage >= 6)
        {
        	ret.add(new ItemStack(getBushDrop(), 1, 0)); //extra seeds if grown
        	if(growStage == 7){ //if fully grown
            for (int i = 0; i < 2 + fortune; ++i)
            {
            	Random MyRand = new Random();
                if (MyRand.nextInt(40) <= growStage)
                {
                    ret.add(new ItemStack(getBushDrop(), 1, 0)); //extra seeds if grown
                }
            }
        	}
        }

        return ret;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random, int fortune)
    {
        return (Item.getItemFromBlock(getBushBlock())); //create item
    }

    @Override
    public boolean canGrow(World parWorld, BlockPos MyPos, IBlockState state, boolean p_149851_5_)
    {
    	int parX = MyPos.getX(); 
    	int parY = MyPos.getY(); 
    	int parZ = MyPos.getZ(); 
    	//System.out.println("A");
    	if(GetWorldBlock(parWorld, parX, parY - 2, parZ) != null){
    		//System.out.println("B");
			if(canBlockGrow(parWorld, new BlockPos(new Vec3(parX, parY - 1, parZ)), state)){
				//System.out.println("C");
				return true;
			}
			else if(GetWorldBlock(parWorld, parX, parY - 2, parZ).equals(getBushBlock())){
				if(GetWorldBlock(parWorld, parX, parY - 3, parZ) != null){
					if(canBlockGrow(parWorld, new BlockPos(new Vec3(parX, parY - 2, parZ)), state)){
						return true;
					}
				}
			}
		}
		return false;
    }

    @Override
    public void grow(World parWorld, Random parRand, BlockPos pos, IBlockState state)
    {

    }

	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return (1);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(!worldIn.isRemote)
        {
    		if(((Integer)state.getValue(AGE)).intValue() >= 6){
    			worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(0)), 2);
    			//playerIn.dropPlayerItemWithRandomChoice(new ItemStack(getBushDrop()), false);
    			this.spawnAsEntity(worldIn, pos, new ItemStack(getBushDrop()));
    		}
        }
    	return true;
    }

	public boolean canGrow(World parWorld, BlockPos myPos, IBlockState myState){
		//System.out.println("X");
		if(GetWorldBlock(parWorld, myPos.getX(), myPos.getY() - 2, myPos.getZ()) != null){
			//System.out.println("Y");
			if(canBlockGrow(parWorld, new BlockPos(new Vec3(myPos.getX(), myPos.getY() - 1, myPos.getZ())), myState)){
				//System.out.println("Z");
				return true;
			}
			else if(GetWorldBlock(parWorld, myPos.getX(), myPos.getY() - 2, myPos.getZ()).equals(getBushBlock())){
				//System.out.println("ZZ");
				if(GetWorldBlock(parWorld, myPos.getX(), myPos.getY() - 3, myPos.getZ()) != null){
					//System.out.println("ZY");
					if(canBlockGrow(parWorld, new BlockPos(new Vec3(myPos.getX(), myPos.getY() - 2, myPos.getZ())), myState)){
						//System.out.println("ZX");
						return true;
					}
				}
			}
		}
		return false;
	}

	private void SetWorldBlock(World myWorld, int x, int y, int z, Block newBlock, int meta, int notify){
		myWorld.setBlockState(new BlockPos(new Vec3(x, y, z)), newBlock.getDefaultState()); 
	}
	
	private Block GetWorldBlock(World myWorld, int x, int y, int z){
		return myWorld.getBlockState(new BlockPos(new Vec3(x, y, z))).getBlock();
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
