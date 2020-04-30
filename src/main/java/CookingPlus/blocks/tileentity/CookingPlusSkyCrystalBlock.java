package CookingPlus.blocks.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import CookingPlus.tiles.CookingPlusSkyCrystalTileEntity;
public class CookingPlusSkyCrystalBlock extends CookingPlusCyrtsalBaseTileEntityBlock {

	public CookingPlusSkyCrystalBlock() {
		super("skycrystal");
		
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new CookingPlusSkyCrystalTileEntity();
	}

}
