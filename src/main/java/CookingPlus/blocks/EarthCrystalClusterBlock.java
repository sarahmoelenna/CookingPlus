package CookingPlus.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import CookingPlus.CookingPlusMain;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EarthCrystalClusterBlock extends CrystalGrowthBaseBlock {

	public EarthCrystalClusterBlock() {
		super("earthcrystal");
	}

	@Override
	public int quantityDropped(Random random)
    {
        return random.nextInt(5) + 1;
    }

    @Nullable
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return CookingPlusMain.earthcrystalshards;
    }
    
    @SideOnly(Side.CLIENT)
	@Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }
}
