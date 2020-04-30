package CookingPlus.blocks;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.CookingPlusMain;

public class CookingPlusBamboo extends CookingPlusCustomBlock{

	private final String name = "bamboo";
	
	public CookingPlusBamboo() {
		super(Material.WOOD);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName("bamboo");
		this.setBlockBounds(0.3125f, 0f, 0.3125f, 0.6875f, 1f, 0.6875f);
		
		//this.setBlockTextureName("cookingplus:salt");
		this.setLightOpacity(5);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		this.setSoundType(SoundType.WOOD);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune) {
	    return Item.getItemFromBlock(CookingPlusMain.blockBamboo);
	}


	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
	    return 1;
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
	public boolean canSustainLeaves(IBlockAccess world, BlockPos pos)
    {
        return true;
    }
    
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block neighborBlock){
		if(worldIn.getBlockState(pos.down()).getBlock() != null){
			if(worldIn.getBlockState(pos.down()).getBlock().equals(CookingPlusMain.blockBamboo)){
				
			}
			else if(worldIn.getBlockState(pos.down()).getBlock().equals(Blocks.DIRT)){
				
			}
			else if(worldIn.getBlockState(pos.down()).getBlock().equals(Blocks.GRASS)){
				
			}
			else if(worldIn.getBlockState(pos.down()).getBlock().equals(Blocks.FARMLAND)){
				
			}
			else{
				dropBlockAsItem(worldIn, pos, state, 0);
				this.breakBlock(worldIn, pos, state);
				worldIn.setBlockToAir(pos);
			}
		}
	}
	
	@Override
	 public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	    {
	        byte b0 = 4;
	        int i = b0 + 1;

	        if (worldIn.isAreaLoaded(pos.add(-i, -i, -i), pos.add(i, i, i)))
	        {
	            Iterator iterator = BlockPos.getAllInBox(pos.add(-b0, -b0, -b0), pos.add(b0, b0, b0)).iterator();

	            while (iterator.hasNext())
	            {
	                BlockPos blockpos1 = (BlockPos)iterator.next();
	                IBlockState iblockstate1 = worldIn.getBlockState(blockpos1);

	                if (iblockstate1.getBlock().isLeaves(iblockstate1, worldIn, blockpos1))
	                {
	                    iblockstate1.getBlock().beginLeavesDecay(iblockstate1, worldIn, blockpos1);
	                }
	            }
	        }
	    }
	
	@Override
	public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return false;
    }

}
