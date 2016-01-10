package CookingPlus.items;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusWaterOrb extends CookingPlusCustomItem {

private final String name = "waterorb";
	
	public CookingPlusWaterOrb(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(name);
	}
	
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(worldIn, playerIn, false);

        if (movingobjectposition == null)
        {
            return itemStackIn;
        }
        else
        {
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
            {
                BlockPos blockpos = movingobjectposition.getBlockPos();
                BlockPos blockpos1 = blockpos.offset(movingobjectposition.sideHit);
                worldIn.setBlockState(blockpos1, Blocks.water.getDefaultState());
                if(itemStackIn.stackSize > 1){
                	--itemStackIn.stackSize;
                }
                else{
                	return new ItemStack(itemStackIn.getItem(), 0);
                }
            }

           
        }
        
        return itemStackIn;
    }
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
