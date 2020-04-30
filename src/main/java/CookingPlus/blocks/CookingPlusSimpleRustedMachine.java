package CookingPlus.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusSimpleRustedMachine extends CookingPlusBasicBlock {

	protected BlockRenderLayer myLayer;
	
	public CookingPlusSimpleRustedMachine(String myName, BlockRenderLayer layer) {
		super(Material.IRON, CreativeTabs.BUILDING_BLOCKS, myName, 1, 1, SoundType.METAL);
		myLayer = layer;
		this.setLightOpacity(5);

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
	    @SideOnly(Side.CLIENT)
		 public BlockRenderLayer getBlockLayer()
		 {
		     return myLayer;
		 }

	 @Override
		public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
	    {
	        return false;
	    }
}
