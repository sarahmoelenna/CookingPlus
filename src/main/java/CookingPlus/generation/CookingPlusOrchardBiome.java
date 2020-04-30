package CookingPlus.generation;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import CookingPlus.CookingPlusMain;

public class CookingPlusOrchardBiome extends Biome {

	
    public CookingPlusOrchardBiome(BiomeProperties i) {
        super(i);
        //setBiomeName("Orchard");
        topBlock = Blocks.GRASS.getDefaultState();
        fillerBlock = Blocks.DIRT.getDefaultState();
        //enableRain = true;
        //this.setTemperatureRainfall(0.6F, 0.6F);
        //this.setHeight(height_LowPlains);
        this.theBiomeDecorator.treesPerChunk = 5;
        //this.setColor(2250012);
    }
    
    @Override
	public WorldGenAbstractTree genBigTreeChance(Random random)
	{
    	int treeType = random.nextInt(9);
    	switch(treeType){
        case 0:
        	return new CookingPlusGenOriginalTree(Blocks.LOG, CookingPlusMain.blockLemonLeaves, 0, 0, 3);
        case 1:
        	return new CookingPlusGenOriginalTree(Blocks.LOG, CookingPlusMain.blockAppleLeaves, 0, 0, 3);
        case 2:
        	return new CookingPlusGenOriginalTree(Blocks.LOG, CookingPlusMain.blockPeachLeaves, 0, 0, 3);
		case 3:
			return new CookingPlusGenOriginalTree(Blocks.LOG, CookingPlusMain.blockLimeLeaves, 0, 0, 3);
		case 4:
			return new CookingPlusGenOriginalTree(Blocks.LOG, CookingPlusMain.blockOrangeLeaves, 0, 0, 3);
		case 5:
			return new CookingPlusGenOriginalTree(Blocks.LOG, CookingPlusMain.blockCherryLeaves, 0, 0, 3);
		case 6:
			return new CookingPlusGenOriginalTree(Blocks.LOG, CookingPlusMain.blockMangoLeaf, 0, 0, 3);
		case 7:
			return new CookingPlusGenOriginalTree(Blocks.LOG, CookingPlusMain.blockKiwiLeaf, 0, 0, 3);
		case 8:
			return new CookingPlusGenOriginalTree(Blocks.LOG, CookingPlusMain.blockAvocadoLeaf, 0, 0, 3);
		}
        return new CookingPlusGenOriginalTree(Blocks.LOG, CookingPlusMain.blockAppleLeaves, 0, 0, 3);
	}
    
    /*@SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos)
    {
        double d0 = GRASS_COLOR_NOISE.func_151601_a((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return d0 < -0.1D ? 5011004 : 2250012;
    }

    @SideOnly(Side.CLIENT)
    public int getFoliageColorAtPos(BlockPos pos)
    {
        return 2250012;
    }*/
}

