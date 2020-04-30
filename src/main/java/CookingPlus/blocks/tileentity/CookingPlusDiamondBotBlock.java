package CookingPlus.blocks.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import CookingPlus.tiles.DiamondBotTileEntity;


public class CookingPlusDiamondBotBlock extends CookingPlusBotBlock {

	public CookingPlusDiamondBotBlock(){
		super("diamondbot");
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new DiamondBotTileEntity();
	}
	
}
