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

public class CookingPlusAppleSapling extends CookingPlusCustomSapling {

	private final String name = "applesapling";
	
	public CookingPlusAppleSapling() {
		super("applesapling");
		GameRegistry.registerBlock(this, name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune) {
	    return Item.getItemFromBlock(CookingPlusMain.blockAppleSapling);
	}


	@Override
	public void GenTree(World myWorld, int x, int y, int z, Random myRand){
    	WorldGenerator myGen = new CookingPlusGenOriginalTree(Blocks.log, CookingPlusMain.blockAppleLeaves, 0, 0, 3);
    	if(!myGen.generate(myWorld, myRand, new BlockPos(new Vec3(x, y, z)))){
    		myWorld.setBlockState(new BlockPos(x, y, z), this.getDefaultState());
    	}
    }
	
	@Override
	public String getName()
	{
		return name;
	}
}
