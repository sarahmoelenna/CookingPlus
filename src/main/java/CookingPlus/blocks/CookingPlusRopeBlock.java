package CookingPlus.blocks;

import java.util.Random;

import CookingPlus.CookingPlusMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusRopeBlock extends CookingPlusCustomBlock{

	private final String name = "rope";
	
	public static final PropertyInteger ROPETYPE = PropertyInteger.create("type", 0, 3);
	//0 - hang bottom
	//1 - straight
	//2 - bottom
	//3 - top
	public CookingPlusRopeBlock() {
		super(Material.plants);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName("rope");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		this.setBlockBounds(0.4f, 0, 0.4f, 0.6f, 1, 0.6f);
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	public boolean isOpaqueCube()
    {
        return false;
    }

	@Override
    public boolean isFullCube()
    {
        return false;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.CUTOUT;
	}

	@Override
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return true;
    }
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
		if( worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos)){
			if(worldIn.getBlockState(new BlockPos(new Vec3(pos.getX(), pos.getY() + 1, pos.getZ()))).getBlock() != null){
				if(worldIn.getBlockState(new BlockPos(new Vec3(pos.getX(), pos.getY() + 1, pos.getZ()))).getBlock().isReplaceable(worldIn, new BlockPos(new Vec3(pos.getX(), pos.getY() + 1, pos.getZ())))==false){
					return true;
				}
			}
		}
        return false;	
    }

	@Override
	public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(ROPETYPE, Integer.valueOf(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(ROPETYPE)).intValue();
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {ROPETYPE});
    }
    
    public void checkRopeStatus(World world, BlockPos myPos){
    	
    	//IBlockState myState = world.getBlockState(myPos);
    	int StateNumber = ((Integer)world.getBlockState(myPos).getValue(ROPETYPE)).intValue();
    	boolean hasTop = false;
    	boolean hasBottom = false;
    	if(isRopeBlock(world.getBlockState(myPos.up()).getBlock())){
    		hasTop = true;
    	}
    	if(isRopeBlock(world.getBlockState(myPos.down()).getBlock())){
    		hasBottom = true;
    	}
    	
    	if(hasTop && hasBottom){
    		world.setBlockState(myPos, this.getDefaultState().withProperty(ROPETYPE, 1));
    		if(StateNumber != 1){
    			updateBlockIfApplicable(world, myPos.up());
    			updateBlockIfApplicable(world, myPos.down());
    		}
    	}
    	else if(hasTop && !hasBottom){
    		world.setBlockState(myPos, this.getDefaultState().withProperty(ROPETYPE, 2));
    		if(StateNumber != 2){
    			updateBlockIfApplicable(world, myPos.up());
    			updateBlockIfApplicable(world, myPos.down());
    		}
    	}
    	else if(!hasTop && hasBottom){
    		world.setBlockState(myPos, this.getDefaultState().withProperty(ROPETYPE, 3));
    		if(checkIfBlockAbove(world, myPos) == false){
    			breakRopeBlock(world, myPos);
    		}
    		
    		if(StateNumber != 3){	
    			updateBlockIfApplicable(world, myPos.up());
    			updateBlockIfApplicable(world, myPos.down());
    		}
    	}
    	else if(!hasTop && !hasBottom){ //no top
    		world.setBlockState(myPos, this.getDefaultState().withProperty(ROPETYPE, 0));
    		
    		if(checkIfBlockAbove(world, myPos) == false){
    			breakRopeBlock(world, myPos);
    		}
    		
    		if(StateNumber != 0){
    			updateBlockIfApplicable(world, myPos.up());
    			updateBlockIfApplicable(world, myPos.down());
    		}
    	}
    }
    
    public IBlockState getRopeStatus(World world, BlockPos myPos){
    	boolean hasTop = false;
    	boolean hasBottom = false;
    	if(isRopeBlock(world.getBlockState(myPos.up()).getBlock())){
    		hasTop = true;
    	}
    	if(isRopeBlock(world.getBlockState(myPos.down()).getBlock())){
    		hasBottom = true;
    	}
    	
    	if(hasTop && hasBottom){
    		return this.getDefaultState().withProperty(ROPETYPE, 1);
    	}
    	else if(hasTop && !hasBottom){
    		return this.getDefaultState().withProperty(ROPETYPE, 2);
    	}
    	else if(!hasTop && hasBottom){
    		return this.getDefaultState().withProperty(ROPETYPE, 3);
    	}
    	else return this.getDefaultState().withProperty(ROPETYPE, 0);
    	
    }
    
    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
    	
    	return getRopeStatus(worldIn, pos);	
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) 
    {
    	checkRopeStatus(worldIn, pos);
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state){
    	updateBlockIfApplicable(worldIn, pos.up());
		updateBlockIfApplicable(worldIn, pos.down());
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

    protected boolean checkIfBlockAbove(World worldIn, BlockPos myPos){
    	
    	if(worldIn.getBlockState(myPos.up()).getBlock() != null){
			if(worldIn.getBlockState(myPos.up()).getBlock().isReplaceable(worldIn, myPos.up())==false){
				return true;
			}
		}
    	return false;
    }
    
    protected void breakRopeBlock(World worldIn, BlockPos myPos){
    	this.dropBlockAsItem(worldIn, myPos, getDefaultState(), 0);
    	worldIn.setBlockToAir(myPos);
    }

    public boolean isRopeBlock(Block myBlock){
    	if(myBlock.equals(CookingPlusMain.blockRope)){
    		return true;
    	}
    	else if(myBlock.equals(CookingPlusMain.blockGrapeCrop)){
    		return true;
    	}
    	else if(myBlock.equals(CookingPlusMain.blockHopCrop)){
    		return true;
    	}
    	else if(myBlock.equals(CookingPlusMain.blockVanillaCrop)){
    		return true;
    	}
    	return false;
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
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        checkRopeStatus(worldIn, pos);
    }
    
    @Override public boolean isLadder(IBlockAccess world, BlockPos pos, EntityLivingBase entity) { return true; }
}

