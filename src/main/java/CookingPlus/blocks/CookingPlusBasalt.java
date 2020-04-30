package CookingPlus.blocks;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CookingPlusBasalt extends CookingPlusCustomBlock{

	private final String name = "basalt";
	
	public CookingPlusBasalt() {
		super(Material.ROCK);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName("basalt");
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		this.setSoundType(SoundType.STONE);
		this.setHarvestLevel("pickaxe", 1);
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState IworldIn, World worldIn, BlockPos state, Random rand) {
		BlockPos myPos = new BlockPos(state.getX(), state.getY(), state.getZ());
		if(worldIn.getBlockState(myPos.up()).getBlock() == Blocks.WATER){
			if(worldIn.getBlockState(myPos.north()).getBlock() == Blocks.LAVA || worldIn.getBlockState(myPos.east()).getBlock() == Blocks.LAVA || worldIn.getBlockState(myPos.west()).getBlock() == Blocks.LAVA || worldIn.getBlockState(myPos.south()).getBlock() == Blocks.LAVA){
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
