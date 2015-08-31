package CookingPlus.items;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class CookingPlusCustomEdibleSeed extends ItemFood implements IPlantable
{
    private final Block theBlockPlant;
    /**
     * Block ID of the soil this seed food should be planted on.
     */
    private final Block soilId;

    public CookingPlusCustomEdibleSeed(int parHealAmount, float parSaturationModifier, 
          Block parBlockPlant, Block parSoilBlock)
    {
        super(parHealAmount, parSaturationModifier, false);
        theBlockPlant = parBlockPlant;
        soilId = parSoilBlock;
    }

    @Override
    public boolean onItemUse(ItemStack parItemStack, EntityPlayer parPlayer, 
          World parWorld, BlockPos MyPos, EnumFacing myFace, float par8, 
          float par9, float par10)
    {
     // not sure what this parameter does, copied it from potato
        if (myFace != EnumFacing.UP)
        {
            return false;
        }
        // check if player has capability to edit
        else if (parPlayer.canPlayerEdit(new BlockPos(new Vec3(MyPos.getX(), MyPos.getY()+1, MyPos.getZ())), myFace, parItemStack))
        {
            // check that the soil block can sustain the plant
            // and that block above is air so there is room for plant to grow
            if (parWorld.getBlockState(MyPos).getBlock().canSustainPlant(parWorld, MyPos, myFace, this) && parWorld.isAirBlock(new BlockPos(new Vec3(MyPos.getX(), MyPos.getY()+1, MyPos.getZ()))))
            {
             // place the plant block
            	setBlock(parWorld, new BlockPos(new Vec3(MyPos.getX(), MyPos.getY()+1, MyPos.getZ())));
                //parWorld.setBlock(new BlockPos(new Vec3(MyPos.getX(), MyPos.getY()+1, MyPos.getZ())), theBlockPlant);
                // decrement the stack of seed items
                --parItemStack.stackSize;
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos myPos)
    {
        return EnumPlantType.Crop;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos myPos)
    {
        return GetCropBlock().getDefaultState();
    }

    //@Override
    //public int getPlantMetadata(IBlockAccess world, BlockPos myPos)
    //{
    //    return 0;
    //}

    public Block getSoilId() 
    {
        return soilId;
    }
    
    public String getName()
    {
    	return null;
    }
    
    private void setBlock(World myWorld, BlockPos myPos){
    	myWorld.setBlockState(myPos, theBlockPlant.getDefaultState()); 
    }

    public Block GetCropBlock(){
		return null;
    	
    }
}