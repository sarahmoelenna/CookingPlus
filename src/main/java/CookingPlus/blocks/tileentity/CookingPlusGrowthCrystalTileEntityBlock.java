package CookingPlus.blocks.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import CookingPlus.tiles.CookingPlusGrowthCrystalTileEntity;
public class CookingPlusGrowthCrystalTileEntityBlock extends CookingPlusCyrtsalBaseTileEntityBlock {

	public CookingPlusGrowthCrystalTileEntityBlock() {
		super("growthcrystal");
		
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new CookingPlusGrowthCrystalTileEntity();
	}

}
