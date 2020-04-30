package CookingPlus.generation;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

public class CookingPlusKelpForestBiome extends Biome {

	
    public CookingPlusKelpForestBiome(BiomeProperties i) {
        super(i);
        //setBiomeName("Kelp Forest");
        topBlock = Blocks.SAND.getDefaultState();
        fillerBlock = Blocks.SAND.getDefaultState();
        //this.setHeight(height_Oceans);
        //this.setColor(113);
    }
    

   
    
}

