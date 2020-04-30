package CookingPlus.blocks.saplings;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomSapling;
import CookingPlus.generation.CookingPlusGenBambooTree;

public class CookingPlusBambooSprout extends CookingPlusCustomSapling {

	private final String name = "bamboosprout";
	
	public CookingPlusBambooSprout() {
		super("bamboosprout");
		GameRegistry.registerBlock(this, name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune) {
	    return Item.getItemFromBlock(CookingPlusMain.blockBambooSprout);
	}


	@Override
	public void GenTree(World myWorld, int x, int y, int z, Random myRand){
    	WorldGenerator myGen = new CookingPlusGenBambooTree(CookingPlusMain.blockBamboo, CookingPlusMain.blockBambooLeaves, 0, 0, true, 6, myRand.nextInt(12) + 1, false);
    	if(!myGen.generate(myWorld, myRand, new BlockPos(new Vec3d(x, y, z)))){
    		myWorld.setBlockState(new BlockPos(x, y, z), this.getDefaultState());
    	}
    }
	
	@Override
	public String getName()
	{
		return name;
	}
	
	
}
