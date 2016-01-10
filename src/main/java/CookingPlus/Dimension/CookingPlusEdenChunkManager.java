package CookingPlus.Dimension;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import CookingPlus.CookingPlusConfig;
import CookingPlus.generation.CookingPlusOrchardBiome;
import net.minecraft.util.BlockPos;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;

public class CookingPlusEdenChunkManager extends WorldChunkManager {

	private BiomeGenBase biomeGenerator;
	private float rainfall;
	
	public CookingPlusEdenChunkManager()
    {
        this.biomeGenerator = new CookingPlusOrchardBiome(CookingPlusConfig.OrchardID);
        this.rainfall = 0.1f;
    }
	
	@Override
	public BiomeGenBase getBiomeGenerator(BlockPos p_180631_1_)
    {
        return this.biomeGenerator;
    }
	
	 @Override
	 public float[] getRainfall(float[] listToReuse, int x, int z, int width, int length)
	    {
	        if (listToReuse == null || listToReuse.length < width * length)
	        {
	            listToReuse = new float[width * length];
	        }

	        Arrays.fill(listToReuse, 0, width * length, this.rainfall);
	        return listToReuse;
	    }
	
	@Override
	public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] BiomeArray, int p_76937_2_, int p_76937_3_, int fromindex, int toindex)
    {
        if (BiomeArray == null || BiomeArray.length < fromindex * toindex)
        {
        	BiomeArray = new BiomeGenBase[fromindex * toindex];
        }

        Arrays.fill(BiomeArray, 0, fromindex * toindex, this.biomeGenerator);
        return BiomeArray;
    }
	
	/**
     * Returns biomes to use for the blocks and loads the other data like temperature and humidity onto the
     * WorldChunkManager Args: oldBiomeList, x, z, width, depth
     */
	@Override
    public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] oldBiomeList, int x, int z, int width, int depth)
    {
        if (oldBiomeList == null || oldBiomeList.length < width * depth)
        {
            oldBiomeList = new BiomeGenBase[width * depth];
        }

        Arrays.fill(oldBiomeList, 0, width * depth, this.biomeGenerator);
        return oldBiomeList;
    }
	
	@Override
	public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] listToReuse, int x, int z, int width, int length, boolean cacheFlag)
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
