package CookingPlus.blocks.tileentity;

import CookingPlus.CookingPlusMain;
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

public class CookingPlusVanillaBlock extends CookingPlusCustomTileEntityBlock {

	private final String name = "vanillablock";
	
	public CookingPlusVanillaBlock() {
		super(Material.cake);
		this.setUnlocalizedName(name);
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new VanillaTileEntity();
	}
	
	public String GetName(){
		return name;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		if(playerIn.getCurrentEquippedItem() == null){
			if(playerIn.getFoodStats().getFoodLevel() < 20){
				playerIn.getFoodStats().setFoodLevel(20);
				playerIn.getFoodStats().setFoodSaturationLevel(20);
				PotionEffect myEffect = new PotionEffect(CookingPlusMain.myTestPotion.getId(), 1000, 50);
				playerIn.addPotionEffect(myEffect);
				worldIn.setBlockToAir(pos);
			}
		}
		return true;
		
    }

}
