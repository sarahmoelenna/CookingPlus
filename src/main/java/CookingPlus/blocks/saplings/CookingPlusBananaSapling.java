package CookingPlus.blocks.saplings;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomSapling;
import CookingPlus.generation.CookingPlusGenOriginalTree;
import CookingPlus.generation.CookingPlusGenPalmTree;

public class CookingPlusBananaSapling extends CookingPlusCustomSapling {

	private final String name = "bananasapling";
	
	public CookingPlusBananaSapling() {
		super("bananasapling");
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune) {
	    return Item.getItemFromBlock(CookingPlusMain.blockBananaSapling);
	}


	@Override
	public void GenTree(World myWorld, int x, int y, int z, Random myRand){
    	WorldGenerator myGen = new CookingPlusGenPalmTree(CookingPlusMain.blockPalmLog, CookingPlusMain.blockBananaLeaves, 0, 0, true, 6, myRand.nextInt(6) + 1, false, 2);
    	myGen.generate(myWorld, myRand, new BlockPos(new Vec3(x, y, z)));
    }
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	 public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	 {
		return worldIn.getBlockState(pos.down()).getBlock() == Blocks.sand;
	 }
}
