package CookingPlus.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.CookingPlusMain;

public class CookingPlusLightAirBlock extends CookingPlusCustomBlock {

	public CookingPlusLightAirBlock() {
		super(Material.air);
		this.setUnlocalizedName("lightair");
		this.setLightLevel(0.4f);
		GameRegistry.registerBlock(this, "lightair");
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
		return true;
	}

	@Override
	public boolean canCollideCheck(IBlockState state, boolean hitIfLiquid) {
		return false;
	}

	@Override
	public boolean isReplaceable(World worldIn, BlockPos pos) {
		return true;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos,IBlockState state) {
		return null;
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
	public int quantityDropped(IBlockState myState, int fortune, Random random) {
		return 0;
	}

	private void SetWorldBlock(World myWorld, int x, int y, int z,
			Block newBlock, int meta, int notify) {myWorld.setBlockState(new BlockPos(new Vec3(x, y, z)),newBlock.getDefaultState());
	}

	private Block GetWorldBlock(World myWorld, int x, int y, int z) {
		return myWorld.getBlockState(new BlockPos(new Vec3(x, y, z))).getBlock();
	}
}
