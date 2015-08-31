package CookingPlus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;

public class CookingPlusCustomUnderwaterPlant extends Block {

	public static final PropertyInteger LEVEL = PropertyInteger.create("level",0, 15);

	public CookingPlusCustomUnderwaterPlant() {
		super(Material.water);
		this.setDefaultState(this.blockState.getBaseState().withProperty(LEVEL,Integer.valueOf(0)));
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	@Override
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.CUTOUT;
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((Integer) state.getValue(LEVEL)).intValue();
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] { LEVEL });
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(LEVEL, Integer.valueOf(meta));
    }
	
	//public boolean canBlockStay(World world, BlockPos pos)
    //{
		//return (world.getBlockState(pos.north()).getBlock() == Blocks.water && (world.getBlockState(pos.west()).getBlock() == Blocks.water && world.getBlockState(pos.south()).getBlock() == Blocks.water && world.getBlockState(pos.east()).getBlock() == Blocks.water));
    //}
	
	public String getName()
	{
		return null;
	}

}
