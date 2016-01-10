package CookingPlus.Dimension;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.eventhandler.Event.Result;

public class CookingPlusEdenDimensionChunkProvider extends ChunkProviderEnd {

	private int chunkX=0, chunkZ=0;
	private World myWorld;
	
	 private Random endRNG;
	 private NoiseGeneratorOctaves noiseGen1;
	 private NoiseGeneratorOctaves noiseGen2;
	 private NoiseGeneratorOctaves noiseGen3;
	 public NoiseGeneratorOctaves noiseGen4;
	 public NoiseGeneratorOctaves noiseGen5;
	 private World endWorld;
	 private double[] densities;
	 /** The biomes that are used to generate the chunk */
	 private BiomeGenBase[] biomesForGeneration;
	 double[] noiseData1;
	 double[] noiseData2;
	 double[] noiseData3;
	 double[] noiseData4;
	 double[] noiseData5;
	 private static final String __OBFID = "CL_00000397";

	public CookingPlusEdenDimensionChunkProvider(World worldIn, long p_i2007_2_) {
		super(worldIn, p_i2007_2_);
		myWorld = worldIn;
		
		this.endWorld = worldIn;
        this.endRNG = new Random(p_i2007_2_);
        this.noiseGen1 = new NoiseGeneratorOctaves(this.endRNG, 16);
        this.noiseGen2 = new NoiseGeneratorOctaves(this.endRNG, 16);
        this.noiseGen3 = new NoiseGeneratorOctaves(this.endRNG, 8);
        this.noiseGen4 = new NoiseGeneratorOctaves(this.endRNG, 10);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.endRNG, 16);

        NoiseGenerator[] noiseGens = {noiseGen1, noiseGen2, noiseGen3, noiseGen4, noiseGen5};
        noiseGens = TerrainGen.getModdedNoiseGenerators(worldIn, this.endRNG, noiseGens);
        this.noiseGen1 = (NoiseGeneratorOctaves)noiseGens[0];
        this.noiseGen2 = (NoiseGeneratorOctaves)noiseGens[1];
        this.noiseGen3 = (NoiseGeneratorOctaves)noiseGens[2];
        this.noiseGen4 = (NoiseGeneratorOctaves)noiseGens[3];
        this.noiseGen5 = (NoiseGeneratorOctaves)noiseGens[4];
	}
	
	private double[] initializeNoiseField(double[] p_73187_1_, int p_73187_2_, int p_73187_3_, int p_73187_4_, int p_73187_5_, int p_73187_6_, int p_73187_7_)
    {
        ChunkProviderEvent.InitNoiseField event = new ChunkProviderEvent.InitNoiseField(this, p_73187_1_, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.getResult() == Result.DENY) return event.noisefield;

        if (p_73187_1_ == null)
        {
            p_73187_1_ = new double[p_73187_5_ * p_73187_6_ * p_73187_7_];
        }

        double d0 = 684.412D;
        double d1 = 684.412D;
        this.noiseData4 = this.noiseGen4.generateNoiseOctaves(this.noiseData4, p_73187_2_, p_73187_4_, p_73187_5_, p_73187_7_, 1.121D, 1.121D, 0.5D);
        this.noiseData5 = this.noiseGen5.generateNoiseOctaves(this.noiseData5, p_73187_2_, p_73187_4_, p_73187_5_, p_73187_7_, 200.0D, 200.0D, 0.5D);
        d0 *= 2.0D;
        this.noiseData1 = this.noiseGen3.generateNoiseOctaves(this.noiseData1, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, d0 / 80.0D, d1 / 160.0D, d0 / 80.0D);
        this.noiseData2 = this.noiseGen1.generateNoiseOctaves(this.noiseData2, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, d0, d1, d0);
        this.noiseData3 = this.noiseGen2.generateNoiseOctaves(this.noiseData3, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, d0, d1, d0);
        int k1 = 0;

        for (int l1 = 0; l1 < p_73187_5_; ++l1)
        {
            for (int i2 = 0; i2 < p_73187_7_; ++i2)
            {
                float f = (float)(l1 + p_73187_2_) / 1.0F;
                float f1 = (float)(i2 + p_73187_4_) / 1.0F;
                float f2 = 100.0F - MathHelper.sqrt_float(f * f + f1 * f1) * 8.0F;

                if (f2 > 80.0F)
                {
                    f2 = 80.0F;
                }

                if (f2 < -100.0F)
                {
                    f2 = -100.0F;
                }

                for (int j2 = 0; j2 < p_73187_6_; ++j2)
                {
                    double d2 = 0.0D;
                    double d3 = this.noiseData2[k1] / 512.0D;
                    double d4 = this.noiseData3[k1] / 512.0D;
                    double d5 = (this.noiseData1[k1] / 10.0D + 1.0D) / 2.0D;

                    if (d5 < 0.0D)
                    {
                        d2 = d3;
                    }
                    else if (d5 > 1.0D)
                    {
                        d2 = d4;
                    }
                    else
                    {
                        d2 = d3 + (d4 - d3) * d5;
                    }

                    d2 -= 8.0D;
                    d2 += (double)f2;
                    byte b0 = 2;
                    double d6;

                    if (j2 > p_73187_6_ / 2 - b0)
                    {
                        d6 = (double)((float)(j2 - (p_73187_6_ / 2 - b0)) / 64.0F);
                        d6 = MathHelper.clamp_double(d6, 0.0D, 1.0D);
                        d2 = d2 * (1.0D - d6) + -3000.0D * d6;
                    }

                    b0 = 8;

                    if (j2 < b0)
                    {
                        d6 = (double)((float)(b0 - j2) / ((float)b0 - 1.0F));
                        d2 = d2 * (1.0D - d6) + -30.0D * d6;
                    }

                    p_73187_1_[k1] = d2;
                    ++k1;
                }
            }
        }

        return p_73187_1_;
    }

	 public void GenerateIsland(int chunkX, int chunkZ, ChunkPrimer myPrimer,Random myRand)
	 {
		 if(myRand.nextFloat() < 0.05f){
			CookingPlusIslandHelper.GetRandomIsland().TranslateToWorld(myWorld, chunkX * 16, 82, chunkZ * 16);
		}
	 }

	 @Override
	 public Chunk provideChunk(int x, int z)
	    {
	        chunkX = x; chunkZ = z;
	        this.endRNG.setSeed((long)x * 341873128712L + (long)z * 132897987541L);
	        ChunkPrimer chunkprimer = new ChunkPrimer();
	        this.biomesForGeneration = this.myWorld.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, x * 16, z * 16, 16, 16);
	        Chunk chunk = new Chunk(this.myWorld, chunkprimer, x, z);
	        byte[] abyte = chunk.getBiomeArray();

	        for (int k = 0; k < abyte.length; ++k)
	        {
	            abyte[k] = (byte)this.biomesForGeneration[k].biomeID;
	        }
	        this.GenerateIsland(x, z, chunkprimer, endRNG);
	        chunk.generateSkylightMap();
	        return chunk;
	    }
	
}
