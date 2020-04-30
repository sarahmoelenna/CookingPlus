package CookingPlus.blocks;

import CookingPlus.CookingPlusGenericHelper;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CrystalGrowthBaseBlock extends CookingPlusCustomBlock {

	private String name;
	
	public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool WEST = PropertyBool.create("west");
    public static final PropertyBool UP = PropertyBool.create("up");
    public static final PropertyBool DOWN = PropertyBool.create("down");
	
	protected CrystalGrowthBaseBlock(String myname) {
		super(Material.GLASS);
		name = myname;
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName(name);
		this.setSoundType(SoundType.GLASS);
		this.setDefaultState(this.blockState.getBaseState().withProperty(NORTH, Boolean.valueOf(false)).withProperty(EAST, Boolean.valueOf(false)).withProperty(SOUTH, Boolean.valueOf(false)).withProperty(WEST, Boolean.valueOf(false)).withProperty(UP, Boolean.valueOf(false)).withProperty(DOWN, Boolean.valueOf(false)));
	}
	
	 @Override
	 public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	 {
	 	Block block = worldIn.getBlockState(pos.down()).getBlock();
	 	Block block1 = worldIn.getBlockState(pos.up()).getBlock();
	 	Block block2 = worldIn.getBlockState(pos.north()).getBlock();
		Block block3 = worldIn.getBlockState(pos.east()).getBlock();
	 	Block block4 = worldIn.getBlockState(pos.south()).getBlock();
		Block block5 = worldIn.getBlockState(pos.west()).getBlock();
	 	return state.withProperty(DOWN, Boolean.valueOf(isValidAttachmentBlock(block, worldIn, pos.down()))).withProperty(UP, Boolean.valueOf(isValidAttachmentBlock(block1, worldIn, pos.up()))).withProperty(NORTH, Boolean.valueOf(isValidAttachmentBlock(block2, worldIn, pos.north()))).withProperty(EAST, Boolean.valueOf(isValidAttachmentBlock(block3, worldIn, pos.east()))).withProperty(SOUTH, Boolean.valueOf(isValidAttachmentBlock(block4, worldIn, pos.south()))).withProperty(WEST, Boolean.valueOf(isValidAttachmentBlock(block5, worldIn, pos.west())));
	 }
		 
	public boolean isValidAttachmentBlock(Block myBlock, IBlockAccess myWorld, BlockPos myPos){
		return myBlock.isNormalCube(myBlock.getDefaultState(), myWorld, myPos) && myBlock.isFullyOpaque(myBlock.getDefaultState());
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn)
    {
		if(isValidAttachmentBlock(worldIn.getBlockState(pos.down()).getBlock(), worldIn, pos.down())){
			
		}
		else if(isValidAttachmentBlock(worldIn.getBlockState(pos.up()).getBlock(), worldIn, pos.up())){
			
		}
		else if(isValidAttachmentBlock(worldIn.getBlockState(pos.east()).getBlock(), worldIn, pos.east())){
			
		}
		else if(isValidAttachmentBlock(worldIn.getBlockState(pos.west()).getBlock(), worldIn, pos.west())){
			
		}
		else if(isValidAttachmentBlock(worldIn.getBlockState(pos.south()).getBlock(), worldIn, pos.south())){
			
		}
		else if(isValidAttachmentBlock(worldIn.getBlockState(pos.north()).getBlock(), worldIn, pos.north())){
	
		}
		else{
			this.dropBlockAsItem(worldIn, pos, getDefaultState(), 0);
			worldIn.setBlockToAir(pos);
		}
		
		
    }
	
	@Override
	public boolean isFullCube(IBlockState state)
	{
	    return false;
	}
	
	public String getName()
	{
		return name;
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
    {
        return 0;
    }
	
	@Override
	protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {NORTH, EAST, SOUTH, WEST, UP, DOWN});
    }

	@Override
    public BlockStateContainer getBlockState()
    {
        return this.blockState;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	{
		return true;
	}

}
