package CookingPlus.blocks.tileentity;

import CookingPlus.tiles.CookingPlusGrowthCrystalTileEntity;
import CookingPlus.tiles.CookingPlusWaterCrystalTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
public class CookingPlusWaterCrystalBlock extends CookingPlusCyrtsalBaseTileEntityBlock {

	public CookingPlusWaterCrystalBlock() {
		super("watercrystal");
		
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new CookingPlusWaterCrystalTileEntity();
	}

}
