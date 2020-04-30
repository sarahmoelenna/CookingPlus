package CookingPlus.Dimension;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkGenerator;
import CookingPlus.CookingPlusConfig;

public class CookingPlusEdenDimension extends WorldProvider {

	public CookingPlusEdenDimension(){
		super();
		isHellWorld = false;
		hasNoSky = false;
		//dimensionId = CookingPlusConfig.EdenDimensionID;
		//worldChunkMgr = WorldType.DEBUG_WORLD.getBiomeProvider(world);
	}
	
	@Override
	public IChunkGenerator createChunkGenerator()
    {
        return new CookingPlusEdenDimensionChunkProvider(this.worldObj, true, this.worldObj.getSeed());
    }
	
	
	
	public void registerWorldChunkManager()
    {
        //this.worldChunkMgr = new BiomeProvider(CookingPlusConfig.EdenDimensionID, WorldType.DEFAULT, "Eden");
    }

	@Override
	public DimensionType getDimensionType() {
		// TODO Auto-generated method stub
		return DimensionType.getById(CookingPlusConfig.EdenDimensionID);
	}

}
