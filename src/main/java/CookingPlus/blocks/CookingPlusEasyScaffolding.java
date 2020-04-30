package CookingPlus.blocks;

import java.util.List;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusEasyScaffolding extends CookingPlusBasicBlock {

	AxisAlignedBB MY_SCAFF_BLOCK_AABB;
	
	public CookingPlusEasyScaffolding(Material myMat, CreativeTabs myTab,String myName, float myHardness, float myResistance,SoundType mySound) {
		super(myMat, myTab, myName, myHardness, myResistance, mySound);
		this.setLightOpacity(0);
	}
	
	
	@Override
    @SideOnly(Side.CLIENT)
	 public BlockRenderLayer getBlockLayer()
	 {
	     return BlockRenderLayer.CUTOUT;
	 }
	
	@Override 
	public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity) { 
		return true; 
	}

	
	@Override
	public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
    {
		if(face == EnumFacing.UP || face == EnumFacing.DOWN){
			return true;
		}
        return false;
    }
	
	@Override
	public boolean isBlockSolid(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
    {
		if(side == EnumFacing.UP || side == EnumFacing.DOWN){
			return true;
		}
        return false;
    }
	
	
	 @Override
	 @SideOnly(Side.CLIENT)
	 public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
	 {
		 return true;
	 }
	

	@Override
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	
	



}
