package CookingPlus.blocks.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import CookingPlus.tiles.CookingPlusWaterCrystalTileEntity;
public class CookingPlusWaterCrystalBlock extends CookingPlusCyrtsalBaseTileEntityBlock {

	public CookingPlusWaterCrystalBlock() {
		super("watercrystal");
		
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new CookingPlusWaterCrystalTileEntity();
	}

}
