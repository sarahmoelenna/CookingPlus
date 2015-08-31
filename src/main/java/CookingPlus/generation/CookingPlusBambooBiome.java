package CookingPlus.generation;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import CookingPlus.CookingPlusMain;

public class CookingPlusBambooBiome extends BiomeGenBase {

	
    public CookingPlusBambooBiome(int i) {
        super(i);
        setBiomeName("Bamboo Grove");
        topBlock = Blocks.grass.getDefaultState();
        fillerBlock = Blocks.dirt.getDefaultState();
        enableRain = true;
        this.setHeight(height_MidHills);
        temperature = 0.5f;
        rainfall = 0.5f;
        this.theBiomeDecorator.treesPerChunk = 20;
        this.setColor(2250013);
    }
    
    @Override
	public WorldGenAbstractTree genBigTreeChance(Random random)
	{
    	int treeHeight = random.nextInt(12) + 1;
        return new CookingPlusGenBambooTree(CookingPlusMain.blockBamboo, CookingPlusMain.blockBambooLeaves, 0, 0, true, 6, treeHeight, false);
	}
    
    @Override
    public int getModdedBiomeGrassColor(int original)
    {
    	return 0xc8db84;
    }
    
}

