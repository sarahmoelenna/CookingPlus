package CookingPlus.blocks.tileentity;

import CookingPlus.CookingPlusGenericHelper;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.tileentity.CookingPlusBotBlock;
import CookingPlus.tiles.BatteryBlockTileEntity;
import CookingPlus.tiles.LeyLineReceiverTileEntity;
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
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusLeyLineReceiverBlock extends CookingPlusCustomTileEntityBlock{

	private final String name = "leylinereceiver";
	
	
	public CookingPlusLeyLineReceiverBlock() {
		super(Material.IRON);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName("leylinereceiver");
		this.setSoundType(SoundType.METAL);
		this.setTickRandomly(false);
		}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }
	
	 
	 public boolean isValidAttachmentBlock(Block myBlock, IBlockAccess myWorld, BlockPos myPos){
		 return CookingPlusGenericHelper.instance().isValidNetworkAttachment(myBlock, myWorld, myPos);
	 }
	
	@Override
	public String GetName()
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
	
	@Override
	public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return false;
    }
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new LeyLineReceiverTileEntity();
	}
	
}
