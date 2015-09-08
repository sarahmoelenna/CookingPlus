package CookingPlus.generation;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import CookingPlus.CookingPlusMain;

public class CookingPlusOrchardBiome extends BiomeGenBase {

	
    public CookingPlusOrchardBiome(int i) {
        super(i);
        setBiomeName("Orchard");
        topBlock = Blocks.grass.getDefaultState();
        fillerBlock = Blocks.dirt.getDefaultState();
        enableRain = true;
        this.setTemperatureRainfall(0.6F, 0.6F);
        this.setHeight(height_LowPlains);
        this.theBiomeDecorator.treesPerChunk = 5;
        this.setColor(2250012);
    }
    
    @Override
	public WorldGenAbstractTree genBigTreeChance(Random random)
	{
    	int treeType = random.nextInt(9);
    	switch(treeType){
        case 0:
        	return new CookingPlusGenOriginalTree(Blocks.log, CookingPlusMain.blockLemonLeaves, 0, 0, 3);
        case 1:
        	return new CookingPlusGenOriginalTree(Blocks.log, CookingPlusMain.blockAppleLeaves, 0, 0, 3);
        case 2:
        	return new CookingPlusGenOriginalTree(Blocks.log, CookingPlusMain.blockPeachLeaves, 0, 0, 3);
		case 3:
			return new CookingPlusGenOriginalTree(Blocks.log, CookingPlusMain.blockLimeLeaves, 0, 0, 3);
		case 4:
			return new CookingPlusGenOriginalTree(Blocks.log, CookingPlusMain.blockOrangeLeaves, 0, 0, 3);
		case 5:
			return new CookingPlusGenOriginalTree(Blocks.log, CookingPlusMain.blockCherryLeaves, 0, 0, 3);
		case 6:
			return new CookingPlusGenOriginalTree(Blocks.log, CookingPlusMain.blockMangoLeaf, 0, 0, 3);
		case 7:
			return new CookingPlusGenOriginalTree(Blocks.log, CookingPlusMain.blockKiwiLeaf, 0, 0, 3);
		case 8:
			return new CookingPlusGenOriginalTree(Blocks.log, CookingPlusMain.blockAvocadoLeaf, 0, 0, 3);
		}
        return new CookingPlusGenOriginalTree(Blocks.log, CookingPlusMain.blockAppleLeaves, 0, 0, 3);
	}
    
}

