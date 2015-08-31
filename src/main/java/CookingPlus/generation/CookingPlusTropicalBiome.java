package CookingPlus.generation;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import CookingPlus.CookingPlusMain;

public class CookingPlusTropicalBiome extends BiomeGenBase {

	
    public CookingPlusTropicalBiome(int i) {
        super(i);
        this.spawnableCreatureList.clear();
        setBiomeName("Tropical Hills");
        topBlock = Blocks.sand.getDefaultState();
        fillerBlock = Blocks.sandstone.getDefaultState();
        enableRain = true;
        this.setHeight(height_LowHills);
        temperature = 1.5f;
        rainfall = 0.1f;
        this.theBiomeDecorator.treesPerChunk = 1;
        this.theBiomeDecorator.mushroomsPerChunk = -999;
        this.setColor(2250013);
    }
    
    @Override
	public WorldGenAbstractTree genBigTreeChance(Random random)
	{
    	int treeHeight = random.nextInt(6) + 1;
    	int which = random.nextInt(100);
    	if(which  < 90){
    		return new CookingPlusGenPalmTree(CookingPlusMain.blockPalmLog, CookingPlusMain.blockPalmLeaves, 0, 0, true, 6, treeHeight, false);
    	}
    	else if(which >= 90 && which < 95){
    		return new CookingPlusGenPalmTree(CookingPlusMain.blockPalmLog, CookingPlusMain.blockBananaLeaves, 0, 0, true, 6, treeHeight, false, 2);
    	}
    	else{
    		return new CookingPlusGenPalmTree(CookingPlusMain.blockPalmLog, CookingPlusMain.blockCoconutLeaves, 0, 0, true, 6, treeHeight, false, 1);
    	}
	}
    
    @Override
    public int getModdedBiomeGrassColor(int original)
    {
    	return 0xc8db84;
    }
    
}

