package CookingPlus.blocks;

import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusCustomTranslucentCoral extends CookingPlusCustomUnderwaterPlant {

	public CookingPlusCustomTranslucentCoral(){
		super();
		this.setLightLevel(0.75f);
		this.setBlockBounds(0, 0, 0, 1, 1, 1);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
	 public BlockRenderLayer getBlockLayer()
	 {
	     return BlockRenderLayer.TRANSLUCENT;
	 }
	
	 @Override
	 public boolean isOpaqueCube()
	 {
	     return false;
	 }

	 @Override
	 public boolean isFullCube()
	 {
	     return true;
	 }
	 
	 @SideOnly(Side.CLIENT)
	 public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
	 {
	      return worldIn.getBlockState(pos).getBlock() != this;
	 }
	 
	 @Override
	 public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos){
		 return false;
	 }
	 
	 @Override
	 public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB p_185477_4_, List<AxisAlignedBB> p_185477_5_, Entity p_185477_6_)
	 {
		 addCollisionBoxToList(pos, p_185477_4_, p_185477_5_, MY_FULL_BLOCK_AABB);
	 }
	
}
