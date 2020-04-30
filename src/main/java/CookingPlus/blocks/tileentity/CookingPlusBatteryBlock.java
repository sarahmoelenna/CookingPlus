package CookingPlus.blocks.tileentity;

import CookingPlus.Interfaces.ILeyPoweredEntity;
import CookingPlus.tiles.BatteryBlockTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusBatteryBlock extends CookingPlusCustomTileEntityBlock {

	public static final PropertyInteger POWER_LEVEL = PropertyInteger.create("power_level", 0, 7);
	protected String name = "batteryblock";
	public CookingPlusBatteryBlock() {
		super(Material.IRON);
		this.setUnlocalizedName("batteryblock");
		this.setSoundType(SoundType.METAL);
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public String GetName(){
		return name;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }
	
	@Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(POWER_LEVEL, Integer.valueOf(meta));
    }
	
	@Override
    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(POWER_LEVEL)).intValue();
    }
	
	@Override
	protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {POWER_LEVEL});
    }

	@Override
    public BlockStateContainer getBlockState()
    {
        return this.blockState;
    }
	
	@Override
	public boolean isVisuallyOpaque()
    {
        return true;
    }
	
	@Override
	public boolean isFullCube(IBlockState state)
    {
        return true;
    }
	
	@Override
	public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return true;
    }
	
	@Override
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
		return true;
    }
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new BatteryBlockTileEntity();
	}
	


}
