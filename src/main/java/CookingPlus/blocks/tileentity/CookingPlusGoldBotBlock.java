package CookingPlus.blocks.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import CookingPlus.tiles.GoldBotTileEntity;


public class CookingPlusGoldBotBlock extends CookingPlusBotBlock {

	public CookingPlusGoldBotBlock(){
		super("goldbot");
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new GoldBotTileEntity();
	}
	
}
