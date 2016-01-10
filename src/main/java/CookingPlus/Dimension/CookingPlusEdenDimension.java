package CookingPlus.Dimension;

import CookingPlus.CookingPlusConfig;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderEnd;

public class CookingPlusEdenDimension extends WorldProvider {

	public CookingPlusEdenDimension(){
		super();
		isHellWorld = false;
		hasNoSky = false;
		dimensionId = CookingPlusConfig.EdenDimensionID;
		worldChunkMgr = new CookingPlusEdenChunkManager();
	}
	
	@Override
	public IChunkProvider createChunkGenerator()
    {
        return new CookingPlusEdenDimensionChunkProvider(this.worldObj, this.worldObj.getSeed());
    }
	
	
	@Override
	public String getDimensionName() {
		return "Eden";
	}

	@Override
	public String getInternalNameSuffix() {
		// TODO Auto-generated method stub
		return "eden";
	}
	
	@Override
	public void registerWorldChunkManager()
    {
        this.worldChunkMgr = new CookingPlusEdenChunkManager();
        this.isHellWorld = false;
        this.hasNoSky = false;
        this.dimensionId = CookingPlusConfig.EdenDimensionID;
    }

}
