package CookingPlus.blocks.tileentity;

import CookingPlus.CookingPlusGenericHelper;
import CookingPlus.CookingPlusMain;
import CookingPlus.Interfaces.ILeyLineProducer;
import CookingPlus.blocks.tileentity.CookingPlusBotBlock;
import CookingPlus.tiles.BatteryBlockTileEntity;
import CookingPlus.tiles.LeyLineGeneratorTileEntity;
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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusLeyLineGeneratorBlock extends CookingPlusCustomTileEntityBlock{

	private final String name = "leylinegenerator";
	
	
	public CookingPlusLeyLineGeneratorBlock() {
		super(Material.IRON);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName("leylinegenerator");
		this.setSoundType(SoundType.METAL);
		this.setTickRandomly(false);
		}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.SOLID;
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
		return new LeyLineGeneratorTileEntity();
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		TileEntity myEntity = worldIn.getTileEntity(pos);
		if(myEntity instanceof ILeyLineProducer){
			((ILeyLineProducer)myEntity).processPlayerActivate(side, playerIn);
		}
		return true;
    }
}
