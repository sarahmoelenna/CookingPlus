package CookingPlus.blocks.tileentity;

import CookingPlus.tiles.CookingPlusSkyCrystalTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
public class CookingPlusSkyCrystalBlock extends CookingPlusCyrtsalBaseTileEntityBlock {

	public CookingPlusSkyCrystalBlock() {
		super("skycrystal");
		
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new CookingPlusSkyCrystalTileEntity();
	}

}
