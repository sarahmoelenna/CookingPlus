package CookingPlus.blocks.saplings;

import java.util.Random;

import net.minecraft.block.Block;
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

public class CookingPlusEasySapling extends CookingPlusCustomSapling {

	private String name;
	private Block saplingBlock;
	private Block leafBlock;
	private Block logBlock;
	
	public CookingPlusEasySapling(String myName) {
		super(myName);
		name = myName;
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune) {
	    return Item.getItemFromBlock(saplingBlock);
	}
	
	public void SetBlocks(Block myLeaf, Block mySapling, Block myLog){
		logBlock = myLog;
		leafBlock = myLeaf;
		saplingBlock = mySapling;
	}


	@Override
	public void GenTree(World myWorld, int x, int y, int z, Random myRand){
    	WorldGenerator myGen = new CookingPlusGenOriginalTree(logBlock, leafBlock, 0, 0, 3);
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
