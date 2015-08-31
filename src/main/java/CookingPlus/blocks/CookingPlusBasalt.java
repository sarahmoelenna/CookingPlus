package CookingPlus.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusBasalt extends CookingPlusCustomBlock{

	private final String name = "basalt";
	
	public CookingPlusBasalt() {
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName("basalt");
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 1);
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World worldIn, BlockPos myPos, IBlockState state, Random rand) {
		
		if(worldIn.getBlockState(myPos.up()).getBlock() == Blocks.water){
			if(worldIn.getBlockState(myPos.north()).getBlock() == Blocks.lava || worldIn.getBlockState(myPos.east()).getBlock() == Blocks.lava || worldIn.getBlockState(myPos.west()).getBlock() == Blocks.lava || worldIn.getBlockState(myPos.south()).getBlock() == Blocks.lava){
					for (int l = 0; l < 2; ++l)
						{
						float f = (float) myPos.getX() + rand.nextFloat();
						float f1 = (float) myPos.getY() + 0.8f + rand.nextFloat();
						float f2 = (float) myPos.getZ() + rand.nextFloat();
						worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
						}
					}
			}
		}

}
