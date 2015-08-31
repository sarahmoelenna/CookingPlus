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

public class CookingPlusLemonSapling extends CookingPlusCustomSapling {

	private final String name = "lemonsapling";
	
	public CookingPlusLemonSapling() {
		super("lemonsapling");
		GameRegistry.registerBlock(this, name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune) {
	    return Item.getItemFromBlock(CookingPlusMain.blockLemonSapling);
	}


	@Override
	public void GenTree(World myWorld, int x, int y, int z, Random myRand){
    	WorldGenerator myGen = new CookingPlusGenOriginalTree(Blocks.log, CookingPlusMain.blockLemonLeaves, 0, 0, 3);
    	myGen.generate(myWorld, myRand, new BlockPos(new Vec3(x, y, z)));
    }
	
	@Override
	public String getName()
	{
		return name;
	}
}
