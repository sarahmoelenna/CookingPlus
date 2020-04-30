package CookingPlus.blocks;

import CookingPlus.CookingPlusGenericHelper;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.tileentity.CookingPlusBotBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusNetworkBlock extends CookingPlusCustomBlock{

	private final String name = "networkpipe";
	
	public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool WEST = PropertyBool.create("west");
    public static final PropertyBool UP = PropertyBool.create("up");
    public static final PropertyBool DOWN = PropertyBool.create("down");
	
	public CookingPlusNetworkBlock() {
		super(Material.IRON);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName("networkblock");
		this.setHardness(0.5f);
		this.setResistance(1.0F);
		this.setSoundType(SoundType.METAL);
		
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
		 return CookingPlusGenericHelper.instance().isValidNetworkAttachment(myBlock, myWorld, myPos);
	 }
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
	
	@Override
	 public boolean isFullCube(IBlockState state)
	 {
	     return false;
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
