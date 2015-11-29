package CookingPlus.blocks.tileentity;

import CookingPlus.CookingPlusMain;
import CookingPlus.tiles.GrabberTileEntity;
import CookingPlus.tiles.SpongeTileEntity;
import CookingPlus.tiles.VanillaTileEntity;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusGrabberBlock extends CookingPlusCustomTileEntityBlock {

	private final String name = "grabberblock";
	
	public CookingPlusGrabberBlock() {
		super(Material.iron);
		this.setUnlocalizedName(name);
		this.setTickRandomly(false);
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new GrabberTileEntity();
	}
	
	public String GetName(){
		return name;
	}
	
	

}
