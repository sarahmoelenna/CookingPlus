package CookingPlus.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusWaterOrb extends CookingPlusCustomItem {

private final String name = "waterorb";
	
	public CookingPlusWaterOrb(){
		GameRegistry.registerItem(this, name);
		setUnlocalizedName(name);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) 
    {
        RayTraceResult movingobjectposition = this.rayTrace(worldIn, playerIn, false);

        if (movingobjectposition == null)
        {
            return new ActionResult(EnumActionResult.PASS, itemStackIn);
        }
        else
        {
            if (movingobjectposition.typeOfHit == RayTraceResult.Type.BLOCK)
            {
                BlockPos blockpos = movingobjectposition.getBlockPos();
                BlockPos blockpos1 = blockpos.offset(movingobjectposition.sideHit);
                worldIn.setBlockState(blockpos1, Blocks.WATER.getDefaultState());
                if(itemStackIn.stackSize > 1){
                	--itemStackIn.stackSize;
                }
                else{
                	return new ActionResult(EnumActionResult.PASS, new ItemStack(itemStackIn.getItem(), 0));
                }
            }

           
        }
        
        return new ActionResult(EnumActionResult.PASS, itemStackIn);
    }
	
	@Override
    public String getName()
    {
    	return name;
    }
	
}
