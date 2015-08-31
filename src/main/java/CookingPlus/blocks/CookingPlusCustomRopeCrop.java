package CookingPlus.blocks;

import java.util.List;
import java.util.Random;

import CookingPlus.CookingPlusMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;

public class CookingPlusCustomRopeCrop extends CookingPlusCustomRenderedBlock implements IPlantable {

	protected int maxGrowthStage = 7;

	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 3);
	public static final PropertyInteger ROPETYPE = PropertyInteger.create("type", 0, 3);

	public CookingPlusCustomRopeCrop() {
		super(Material.plants);
		this.setTickRandomly(true);
		this.setDefaultState(this.blockState.getBaseState().withProperty(ROPETYPE, Integer.valueOf(0)).withProperty(AGE, Integer.valueOf(0)));
		
	}

	@Override
	public void updateTick(World parWorld, BlockPos myPos, IBlockState myState,Random parRand) {
		super.updateTick(parWorld, myPos, myState, parRand);
		int growStage = ((Integer) myState.getValue(AGE)).intValue();
		if(parRand.nextFloat() > 0.75f){
			growStage++;
		}

		if (growStage > 3) {
			growCropUp(parWorld, myPos.up());
			growStage = 3;
		}
		//System.out.println(((Integer)myState.getValue(AGE)).intValue() + " Update");
		// System.out.println(growStage + " grown");
		parWorld.setBlockState(myPos,myState.withProperty(AGE, Integer.valueOf(growStage)), 2);
	}

	@Override
	protected BlockState createBlockState() {
		return new ExtendedBlockState(this, new IProperty[] { ROPETYPE, AGE },
				new IUnlistedProperty[] { JAI }); // maybe need to add listed
													// property?
	}

	@Override
	public IBlockState getExtendedState(IBlockState state, IBlockAccess world, BlockPos pos) {
		if (state instanceof IExtendedBlockState) {
			//state.withProperty(AGE, 0);
			return ((IExtendedBlockState) state).withProperty(JAI, 1);
		}
		return state;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(ROPETYPE, (meta & 3)).withProperty(AGE, Integer.valueOf(meta & 15 >> 2));
	    
		//return this.getDefaultState().withProperty(AGE, Integer.valueOf(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		byte b0 = 0;
        int i = b0 | ((Integer)state.getValue(ROPETYPE)).intValue();
        i |= ((Integer)state.getValue(AGE)).intValue() << 2;
        return i;
		//return ((Integer) state.getValue(AGE)).intValue();
	}

	public void checkRopeStatus(World world, BlockPos myPos) {

		// IBlockState myState = world.getBlockState(myPos);
		int StateNumber = ((Integer) world.getBlockState(myPos).getValue(ROPETYPE)).intValue();
		boolean hasTop = false;
		boolean hasBottom = false;
		if (isRopeBlock(world.getBlockState(myPos.up()).getBlock())) {
			hasTop = true;
		}
		if (isRopeBlock(world.getBlockState(myPos.down()).getBlock())) {
			hasBottom = true;
		}

		if (hasTop && hasBottom) {
			world.setBlockState(myPos,world.getBlockState(myPos).withProperty(ROPETYPE, 1));
			if (StateNumber != 1) {
				updateBlockIfApplicable(world, myPos.up());
    			updateBlockIfApplicable(world, myPos.down());
			}
		} else if (hasTop && !hasBottom) {
			world.setBlockState(myPos,world.getBlockState(myPos).withProperty(ROPETYPE, 2));
			if (StateNumber != 2) {
				updateBlockIfApplicable(world, myPos.up());
    			updateBlockIfApplicable(world, myPos.down());
			}
		} else if (!hasTop && hasBottom) {
			world.setBlockState(myPos,world.getBlockState(myPos).withProperty(ROPETYPE, 3));
			if (checkIfBlockAbove(world, myPos) == false) {
				breakRopeBlock(world, myPos);
			}
			
			if (StateNumber != 3) {	
				updateBlockIfApplicable(world, myPos.up());
    			updateBlockIfApplicable(world, myPos.down());
			}
		} else if (!hasTop && !hasBottom) { // no top
			world.setBlockState(myPos,world.getBlockState(myPos).withProperty(ROPETYPE, 0));

			if (checkIfBlockAbove(world, myPos) == false) {
				breakRopeBlock(world, myPos);
			}

			if (StateNumber != 0) {
				updateBlockIfApplicable(world, myPos.up());
    			updateBlockIfApplicable(world, myPos.down());
			}
		}
	}

	public IBlockState getRopeStatus(World world, BlockPos myPos) {
		boolean hasTop = false;
		boolean hasBottom = false;
		if (isRopeBlock(world.getBlockState(myPos.up()).getBlock())) {
			hasTop = true;
		}
		if (isRopeBlock(world.getBlockState(myPos.down()).getBlock())) {
			hasBottom = true;
		}

		if (hasTop && hasBottom) {
			return this.getDefaultState().withProperty(ROPETYPE, 1);
		} else if (hasTop && !hasBottom) {
			return this.getDefaultState().withProperty(ROPETYPE, 2);
		} else if (!hasTop && hasBottom) {
			return this.getDefaultState().withProperty(ROPETYPE, 3);
		} else
			return this.getDefaultState().withProperty(ROPETYPE, 0);

	}

	public boolean isRopeBlock(Block myBlock) {
		if (myBlock.equals(CookingPlusMain.blockRope)) {
			return true;
		} else if (myBlock.equals(CookingPlusMain.blockGrapeCrop)) {
			return true;
		} else if (myBlock.equals(CookingPlusMain.blockHopCrop)) {
			return true;
		} else if (myBlock.equals(CookingPlusMain.blockVanillaCrop)) {
			return true;
		}
		return false;
	}

	protected boolean checkIfBlockAbove(World worldIn, BlockPos myPos) {

		if (worldIn.getBlockState(myPos.up()).getBlock() != null) {
			if (worldIn.getBlockState(myPos.up()).getBlock()
					.isReplaceable(worldIn, myPos.up()) == false) {
				return true;
			}
		}
		return false;
	}

	protected void breakRopeBlock(World worldIn, BlockPos myPos) {
		//this.dropBlockAsItem(worldIn, myPos, CookingPlusMain.blockRope.getDefaultState(), 0);
		this.spawnAsEntity(worldIn, myPos, new ItemStack(Item.getItemFromBlock(CookingPlusMain.blockRope)));
		this.spawnAsEntity(worldIn, myPos, new ItemStack(GetSeedItem()));
		if( ((Integer)worldIn.getBlockState(myPos).getValue(AGE)).intValue() == 3 ){
			this.spawnAsEntity(worldIn, myPos, new ItemStack(GetCropItem()));
		}
		worldIn.setBlockToAir(myPos);
	}

	@Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state){

		//System.out.println(((Integer)state.getValue(AGE)).intValue() + " Added");
		//System.out.println(((Integer)this.blockState.getBlock().getDefaultState().getValue(AGE)).intValue() + " default Added");
		//worldIn.setBlockState(pos, getDefaultState().withProperty(AGE, 0));
		updateBlockIfApplicable(worldIn, pos.up());
		updateBlockIfApplicable(worldIn, pos.down());
    }
	
	@Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
		//System.out.println(((Integer)worldIn.getBlockState(pos).getValue(AGE)).intValue() + " Placed");
    	return getRopeStatus(worldIn, pos);	
    }
	
	protected void updateBlockIfApplicable(World world, BlockPos pos){
    	Block myBlock = world.getBlockState(pos).getBlock();
    	if(myBlock.equals(CookingPlusMain.blockRope)){
    		((CookingPlusRopeBlock)world.getBlockState(pos).getBlock()).checkRopeStatus(world, pos);
    	}
    	if(myBlock instanceof CookingPlusCustomRopeCrop){
    		((CookingPlusCustomRopeCrop)world.getBlockState(pos).getBlock()).checkRopeStatus(world, pos);
    	}
    }
	
	@Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) 
    {
    	updateBlockIfApplicable(worldIn, pos.up());
		updateBlockIfApplicable(worldIn, pos.down());
    }
    
    @Override
    public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) 
    {
    	updateBlockIfApplicable(worldIn, pos.up());
		updateBlockIfApplicable(worldIn, pos.down());
    }
    
    @Override
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
    	//System.out.println(((Integer)state.getValue(AGE)).intValue() + " Neighbour");
        if(worldIn.getBlockState(pos.down()).getBlock().equals(CookingPlusMain.blockRope)){
        	//gotta break
        	int myRope = ((Integer)worldIn.getBlockState(pos).getValue(ROPETYPE)).intValue();
        	worldIn.setBlockState(pos, CookingPlusMain.blockRope.getDefaultState().withProperty(CookingPlusRopeBlock.ROPETYPE, myRope));
        }
        else if(worldIn.getBlockState(pos.down()).getBlock().equals(GetCropBlock())){
        	//fine
        }
        else if(worldIn.getBlockState(pos.down()).getBlock().equals(Blocks.farmland)){
        	//fine
        }
        else{
        	//return to rope
        	int myRope = ((Integer)worldIn.getBlockState(pos).getValue(ROPETYPE)).intValue();
        	worldIn.setBlockState(pos, CookingPlusMain.blockRope.getDefaultState().withProperty(CookingPlusRopeBlock.ROPETYPE, myRope));
        }
        
        checkRopeStatus(worldIn, pos);
        
    }

    private void growCropUp(World myWorld, BlockPos myPos){
    	if(myWorld.getBlockState(myPos).getBlock()!= null){
    		if(myWorld.getBlockState(myPos).getBlock().equals(CookingPlusMain.blockRope)){
    			int myRope = ((Integer)myWorld.getBlockState(myPos).getValue(CookingPlusRopeBlock.ROPETYPE)).intValue();
    			myWorld.setBlockState(myPos, getDefaultState().withProperty(ROPETYPE, myRope).withProperty(AGE, 0));
    		}
    	}
    	//System.out.println(((Integer)myWorld.getBlockState(myPos).getValue(AGE)).intValue() + " Grow");
    }

    protected Item GetCropItem(){
    	return null;
    }
    
    protected Item GetSeedItem(){
    	return null;
    }
    
    protected Block GetCropBlock(){
    	return null;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
    	if(!worldIn.isRemote)
        {
    		if(((Integer)state.getValue(AGE)).intValue() >= 3){
    			worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(1)), 2);
    			//playerIn.dropPlayerItemWithRandomChoice(new ItemStack(GetCropItem()), false);
    			this.spawnAsEntity(worldIn, pos, new ItemStack(GetCropItem()));
    		}
        }
    	return true;
    }

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Crop;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		IBlockState state = world.getBlockState(pos);
        if (state.getBlock() != this) return getDefaultState();
        //System.out.println("blah");
        return state;
	}
	
	 @Override
	 public List<ItemStack> getDrops(IBlockAccess world, BlockPos myPos, IBlockState myState, int fortune)
	   {
	    	List<ItemStack> ret = super.getDrops(world, myPos, myState, fortune);
	        ret.clear();
	        int growStage = ((Integer)myState.getValue(AGE)).intValue();
	        
	        ret.add(new ItemStack(GetSeedItem(), 1, 0)); //always drops at least one seed
	        ret.add(new ItemStack(CookingPlusMain.blockRope, 1, 0)); //always drops at least one seed
	        
	        if (growStage >= 3)
	        {
	        	ret.add(new ItemStack(GetCropItem(), 1, 0)); //extra seeds if grown
	        }
	        return ret;
	   }

}
