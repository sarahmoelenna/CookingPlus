package CookingPlus.blocks.leaves;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomLeaves;

public class CookingPlusTangleLeaves extends CookingPlusCustomLeaves {

	private final String name = "tangleleaves";
	
	public CookingPlusTangleLeaves() {
		super("tangleleaves");
		Blocks.FIRE.setFireInfo(this, 0, 0);
		GameRegistry.registerBlock(this, name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Item getSapling(){
		return null;
	}
	
	@Override
	public Block getLeaves(){
		return CookingPlusMain.blockTangleLeaves;
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos myPos, IBlockState myState, int fortune) {
		List<ItemStack> ret = super.getDrops(world, myPos, myState,fortune);
		Random rand = world instanceof World ? ((World)world).rand : new Random();
		
		if (rand.nextInt(20) == 0)
		{
            ret.add(new ItemStack(getItemDropped(myState, rand, fortune), 1));
		}

		return ret;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState state, World worldIn, BlockPos myPos, Random rand)
	{
	if(worldIn.getBlockState(myPos.down()).getBlock() == Blocks.AIR){
		for (int l = 0; l < 2; ++l){
			if(rand.nextInt(10) > 8){
				float f = (float) myPos.getX() + rand.nextFloat();
				float f1 = (float) myPos.getY();
				float f2 = (float) myPos.getZ() + rand.nextFloat();
				worldIn.spawnParticle(EnumParticleTypes.DRIP_LAVA, (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
			}
		}
	}
	}

}
