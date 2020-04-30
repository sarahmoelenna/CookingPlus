package CookingPlus.blocks.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import CookingPlus.tiles.CookingPlusLightCrystalTileEntity;
public class CookingPlusLightCrystalBlock extends CookingPlusCyrtsalBaseTileEntityBlock {

	public CookingPlusLightCrystalBlock() {
		super("lightcrystal");
		
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new CookingPlusLightCrystalTileEntity();
	}

}
