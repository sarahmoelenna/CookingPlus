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
import CookingPlus.CookingPlusMain;
import CookingPlus.tiles.LiquidBarrelTileEntity;

public class CookingPlusLiquidBarrelBlock extends CookingPlusCustomTileEntityBlock {

	private final String name = "liquidbarrel";
	
	public CookingPlusLiquidBarrelBlock() {
		super(Material.WOOD);
		this.setUnlocalizedName(name);
		this.setTickRandomly(true);
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new LiquidBarrelTileEntity();
	}
	
	public String GetName(){
		return name;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		if(!worldIn.isRemote)
        {
                LiquidBarrelTileEntity t = (LiquidBarrelTileEntity) worldIn.getTileEntity(pos);
                t.processActivate(playerIn);
                
                if(playerIn.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).getItem() == CookingPlusMain.dirtyneedle){
					playerIn.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(CookingPlusMain.needle, 1));
				}
                
        }
		return true;
		
    }

}
