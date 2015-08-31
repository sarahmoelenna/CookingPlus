package CookingPlus.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusCustomTranslucentCoral extends CookingPlusCustomUnderwaterPlant {

	public CookingPlusCustomTranslucentCoral(){
		super();
		this.setLightLevel(0.75f);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.TRANSLUCENT;
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
	 public boolean isReplaceable(World worldIn, BlockPos pos){
		 return false;
	 }
	
}
