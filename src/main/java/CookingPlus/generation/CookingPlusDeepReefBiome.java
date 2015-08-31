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

public class CookingPlusDeepReefBiome extends BiomeGenBase {

	
    public CookingPlusDeepReefBiome(int i) {
        super(i);
        setBiomeName("Deep Reef");
        BiomeGenBase.Height height_oceanfloor = new BiomeGenBase.Height(-1.97F, 0.01F);
        this.setHeight(height_oceanfloor);
        this.setColor(113);
        
    }
    
    
}

