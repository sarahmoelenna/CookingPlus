package CookingPlus.generation;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.CookingPlusMain;

public class CookingPlusBambooBiome extends Biome {

	
    public CookingPlusBambooBiome(Biome.BiomeProperties properties) {
        super(properties);
        //this.biomeName = "Bamboo Grove";
        topBlock = Blocks.GRASS.getDefaultState();
        fillerBlock = Blocks.DIRT.getDefaultState();
        this.theBiomeDecorator.treesPerChunk = 20;
        //this.setColor(2250013);
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
    	return 9628553;
    }
    
    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos)
    {
    	 return 9628553;
    }

    @SideOnly(Side.CLIENT)
    public int getFoliageColorAtPos(BlockPos pos)
    {
        return 9628553;
    }
    
}

