package CookingPlus.blocks;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.CookingPlusMain;

public class CookingPlusTangleLog extends CookingPlusCustomBlock{

	private final String name = "tanglelog";
	
	public CookingPlusTangleLog() {
		super(Material.wood);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		this.setStepSound(soundTypeWood);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune) {
	    return Item.getItemFromBlock(CookingPlusMain.blockTangleLog);
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
	public boolean canSustainLeaves(IBlockAccess world, BlockPos pos)
    {
        return true;
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

	                if (iblockstate1.getBlock().isLeaves(worldIn, blockpos1))
	                {
	                    iblockstate1.getBlock().beginLeavesDecay(worldIn, blockpos1);
	                }
	            }
	        }
	    }

}
