package CookingPlus.Dimension;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import CookingPlus.generation.CookingPlusOrchardBiome;

public class CookingPlusEdenChunkManager extends BiomeProvider {

	private Biome biomeGenerator;
	private float rainfall;
	
	public CookingPlusEdenChunkManager()
    {
		Biome.BiomeProperties properties = new Biome.BiomeProperties("Orchard").setRainfall(0.3f).setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(0.8F);
        this.biomeGenerator = new CookingPlusOrchardBiome(properties);
        this.rainfall = 0.1f;
    }
	
	@Override
	public Biome getBiomeGenerator(BlockPos p_180631_1_)
    {
        return this.biomeGenerator;
    }
	
	
	@Override
	public Biome[] getBiomesForGeneration(Biome[] BiomeArray, int p_76937_2_, int p_76937_3_, int fromindex, int toindex)
    {
        if (BiomeArray == null || BiomeArray.length < fromindex * toindex)
        {
        	BiomeArray = new Biome[fromindex * toindex];
        }

        Arrays.fill(BiomeArray, 0, fromindex * toindex, this.biomeGenerator);
        return BiomeArray;
    }
	
	/**
     * Returns biomes to use for the blocks and loads the other data like temperature and humidity onto the
     * WorldChunkManager Args: oldBiomeList, x, z, width, depth
     */
	@Override
    public Biome[] loadBlockGeneratorData(Biome[] oldBiomeList, int x, int z, int width, int depth)
    {
        if (oldBiomeList == null || oldBiomeList.length < width * depth)
        {
            oldBiomeList = new Biome[width * depth];
        }

        Arrays.fill(oldBiomeList, 0, width * depth, this.biomeGenerator);
        return oldBiomeList;
    }
	
	@Override
	public Biome[] getBiomeGenAt(Biome[] listToReuse, int x, int z, int width, int length, boolean cacheFlag)
    {
        return this.loadBlockGeneratorData(listToReuse, x, z, width, length);
    }
	
	@Override
	public BlockPos findBiomePosition(int x, int z, int range, List biomes, Random random)
    {
        return biomes.contains(this.biomeGenerator) ? new BlockPos(x - range + random.nextInt(range * 2 + 1), 0, z - range + random.nextInt(range * 2 + 1)) : null;
    }

    /**
     * checks given Chunk's Biomes against List of allowed ones
     */
	@Override
    public boolean areBiomesViable(int p_76940_1_, int p_76940_2_, int p_76940_3_, List p_76940_4_)
    {
        return p_76940_4_.contains(this.biomeGenerator);
    }
}
