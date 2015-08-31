package CookingPlus.blocks;

import CookingPlus.CookingPlusMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusCoconutBlock extends CookingPlusCustomBlock{

	private final String name = "coconutblock";
	
	public CookingPlusCoconutBlock() {
		super(Material.cactus);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName(name);
		this.setStepSound(soundTypeWood);
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	@Override
    public boolean isFullCube()
    {
        return false;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.CUTOUT;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
        return null;
    }
	
	@Override
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock){
		if(worldIn.getBlockState(pos.up()).getBlock() != null){
			if(worldIn.getBlockState(pos.up()).getBlock() == CookingPlusMain.blockCoconutLeaves){
				
			}
			else{
				dropBlockAsItem(worldIn, pos, state, 0);
				worldIn.setBlockToAir(pos);
			}
		}
	}
	
	@Override
	 public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	 {
		return false;
	 }

}
