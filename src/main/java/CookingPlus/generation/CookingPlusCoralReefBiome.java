package CookingPlus.generation;

import java.util.Random;

import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenOcean;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import CookingPlus.CookingPlusMain;

public class CookingPlusCoralReefBiome extends BiomeGenBase {

	
    public CookingPlusCoralReefBiome(int i) {
        super(i);
        
        BiomeGenBase.Height CoralReefHeight = new BiomeGenBase.Height(-1.2F, 0.1F);
        
        setBiomeName("Coral Reef");
        topBlock = CookingPlusMain.blockCoralRock.getDefaultState();
        fillerBlock = CookingPlusMain.blockCoralRock.getDefaultState();
        enableRain = true;
        this.setHeight(CoralReefHeight);
        this.theBiomeDecorator.treesPerChunk = 0;
        this.theBiomeDecorator.gravelAsSandGen = null;
        this.setColor(113);
        
    }
    
    
}

