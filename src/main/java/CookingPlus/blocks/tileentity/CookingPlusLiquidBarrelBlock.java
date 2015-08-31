package CookingPlus.blocks.tileentity;

import CookingPlus.CookingPlusMain;
import CookingPlus.tiles.ButterChurnTileEntity;
import CookingPlus.tiles.LiquidBarrelTileEntity;
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

public class CookingPlusLiquidBarrelBlock extends CookingPlusCustomTileEntityBlock {

	private final String name = "liquidbarrel";
	
	public CookingPlusLiquidBarrelBlock() {
		super(Material.wood);
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
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		if(!worldIn.isRemote)
        {
                LiquidBarrelTileEntity t = (LiquidBarrelTileEntity) worldIn.getTileEntity(pos);
                t.processActivate(playerIn);
        }
		return true;
		
    }

}
