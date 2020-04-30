package CookingPlus.generation;

import net.minecraft.world.biome.Biome;
import CookingPlus.CookingPlusMain;

public class CookingPlusCoralReefBiome extends Biome {

	
    public CookingPlusCoralReefBiome(BiomeProperties i) {
        super(i);
        
        //Biome.Height CoralReefHeight = new Biome.Height(-1.2F, 0.1F);
        //setBiomeName("Coral Reef");
        topBlock = CookingPlusMain.blockCoralRock.getDefaultState();
        fillerBlock = CookingPlusMain.blockCoralRock.getDefaultState();
        //this.setHeight(CoralReefHeight);
       //this.setColor(113);
        
    }
    

    
    
}

