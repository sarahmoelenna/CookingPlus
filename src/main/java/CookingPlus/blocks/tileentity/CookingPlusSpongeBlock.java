package CookingPlus.blocks.tileentity;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.tiles.SpongeTileEntity;

public class CookingPlusSpongeBlock extends CookingPlusCustomTileEntityBlock {

	private final String name = "spongeblock";
	
	public CookingPlusSpongeBlock() {
		super(Material.CAKE);
		this.setUnlocalizedName(name);
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new SpongeTileEntity();
	}
	
	public String GetName(){
		return name;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		if(playerIn.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND) == null){
			if(playerIn.getFoodStats().getFoodLevel() < 20){
				playerIn.getFoodStats().setFoodLevel(10);
				playerIn.getFoodStats().setFoodSaturationLevel(10);
				//PotionEffect myEffect = new PotionEffect(CookingPlusMain.myTestPotion.getId(), 500, 25);
				//playerIn.addPotionEffect(myEffect);
				worldIn.setBlockToAir(pos);
			}
		}
		return true;
		
    }

}
