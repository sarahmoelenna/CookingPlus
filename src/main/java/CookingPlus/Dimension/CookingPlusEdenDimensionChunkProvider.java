package CookingPlus.Dimension;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorSimplex;
import net.minecraft.world.gen.feature.WorldGenEndIsland;
import net.minecraft.world.gen.structure.MapGenEndCity;

public class CookingPlusEdenDimensionChunkProvider extends ChunkProviderEnd {

	 private Random rand;
	    protected static final IBlockState END_STONE = Blocks.END_STONE.getDefaultState();
	    protected static final IBlockState AIR = Blocks.AIR.getDefaultState();
	    private NoiseGeneratorOctaves field_185969_i;
	    private NoiseGeneratorOctaves field_185970_j;
	    private NoiseGeneratorOctaves field_185971_k;
	    /** A NoiseGeneratorOctaves used in generating terrain */
	    public NoiseGeneratorOctaves noiseGen5;
	    /** A NoiseGeneratorOctaves used in generating terrain */
	    public NoiseGeneratorOctaves noiseGen6;
	    /** Reference to the World object. */
	    private final World worldObj;
	    /** are map structures going to be generated (e.g. strongholds) */
	    private final boolean mapFeaturesEnabled;
	    private final MapGenEndCity field_185972_n = new MapGenEndCity(this);
	    private NoiseGeneratorSimplex islandNoise;
	    private double[] field_185974_p;
	    /** The biomes that are used to generate the chunk */
	    private Biome[] biomesForGeneration;
	    double[] field_185966_e;
	    double[] field_185967_f;
	    double[] field_185968_g;
	    private final WorldGenEndIsland field_185975_r = new WorldGenEndIsland();
	    // temporary variables used during event handling
	    private int chunkX = 0;
	    private int chunkZ = 0;
	    
	    public World myWorld;

	public CookingPlusEdenDimensionChunkProvider(World worldObjIn, boolean mapFeaturesEnabledIn, long seed) {
		super(worldObjIn, mapFeaturesEnabledIn, seed);
		myWorld = worldObjIn;
		this.worldObj = worldObjIn;
        this.mapFeaturesEnabled = mapFeaturesEnabledIn;
        this.rand = new Random(seed);
        this.field_185969_i = new NoiseGeneratorOctaves(this.rand, 16);
        this.field_185970_j = new NoiseGeneratorOctaves(this.rand, 16);
        this.field_185971_k = new NoiseGeneratorOctaves(this.rand, 8);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
        this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
        this.islandNoise = new NoiseGeneratorSimplex(this.rand);

        net.minecraftforge.event.terraingen.InitNoiseGensEvent.ContextEnd ctx =
                new net.minecraftforge.event.terraingen.InitNoiseGensEvent.ContextEnd(field_185969_i, field_185970_j, field_185971_k, noiseGen5, noiseGen6, islandNoise);
        ctx = net.minecraftforge.event.terraingen.TerrainGen.getModdedNoiseGenerators(worldObjIn, this.rand, ctx);
        this.field_185969_i = ctx.getLPerlin1();
        this.field_185970_j = ctx.getLPerlin2();
        this.field_185971_k = ctx.getPerlin();
        this.noiseGen5 = ctx.getDepth();
        this.noiseGen6 = ctx.getScale();
        this.islandNoise = ctx.getIsland();
	}
	
	 public void GenerateIsland(int chunkX, int chunkZ, ChunkPrimer myPrimer,Random myRand)
	 {
		 if(myRand.nextFloat() < 0.05f){
			CookingPlusIslandHelper.GetRandomIsland().TranslateToWorld(myWorld, chunkX * 16, 82, chunkZ * 16, myRand);
		}
	 }
 
	 @Override
	 public Chunk provideChunk(int x, int z)
	    {
	        this.chunkX = x; this.chunkZ = z;
	        this.rand.setSeed((long)x * 341873128712L + (long)z * 132897987541L);
	        ChunkPrimer chunkprimer = new ChunkPrimer();
	        this.biomesForGeneration = this.worldObj.getBiomeProvider().loadBlockGeneratorData(this.biomesForGeneration, x * 16, z * 16, 16, 16);
	        this.setBlocksInChunk(x, z, chunkprimer);
	        this.buildSurfaces(chunkprimer);

	        if (this.mapFeaturesEnabled)
	        {
	            this.field_185972_n.generate(this.worldObj, x, z, chunkprimer);
	        }

	        Chunk chunk = new Chunk(this.worldObj, chunkprimer, x, z);
	        byte[] abyte = chunk.getBiomeArray();

	        for (int i = 0; i < abyte.length; ++i)
	        {
	            abyte[i] = (byte)Biome.getIdForBiome(this.biomesForGeneration[i]);
	        }

	        this.GenerateIsland(x, z, chunkprimer, rand);
	        chunk.generateSkylightMap();
	        return chunk;
	    }
	
}
