package CookingPlus.generation;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenOcean;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import CookingPlus.CookingPlusMain;

public class CookingPlusKelpForestBiome extends BiomeGenOcean {

	
    public CookingPlusKelpForestBiome(int i) {
        super(i);
        setBiomeName("Kelp Forest");
        topBlock = Blocks.sand.getDefaultState();
        fillerBlock = Blocks.sand.getDefaultState();
        this.setHeight(height_Oceans);
        this.setColor(113);
    }
   
    
}

