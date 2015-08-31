package CookingPlus.items;

import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomRopeCrop;
import CookingPlus.blocks.CookingPlusRopeBlock;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class CookingPlusCustomEdibleRopeCropSeed extends ItemFood implements IPlantable
{
    private final Block theBlockPlant;
    /**
     * Block ID of the soil this seed food should be planted on.
     */
    private final Block soilId;

    public CookingPlusCustomEdibleRopeCropSeed(int parHealAmount, float parSaturationModifier, 
          Block parBlockPlant, Block parSoilBlock)
    {
        super(parHealAmount, parSaturationModifier, false);
        theBlockPlant = parBlockPlant;
        soilId = parSoilBlock;
    }

    @Override
    public boolean onItemUse(ItemStack parItemStack, EntityPlayer parPlayer, World parWorld, BlockPos MyPos, EnumFacing myFace, float par8, float par9, float par10)
    {
    	//System.out.println("rawr");
        if (parWorld.getBlockState(MyPos).getBlock().equals(CookingPlusMain.blockRope) && parWorld.getBlockState(MyPos.down()).getBlock().equals(Blocks.farmland))
            {
             // place the plant block
            	//setBlock(parWorld, new BlockPos(new Vec3(MyPos.getX(), MyPos.getY()+1, MyPos.getZ())));
                //parWorld.setBlock(new BlockPos(new Vec3(MyPos.getX(), MyPos.getY()+1, MyPos.getZ())), theBlockPlant);
            	int currentrope = ((Integer)parWorld.getBlockState(MyPos).getValue(CookingPlusRopeBlock.ROPETYPE)).intValue();
            	
            	parWorld.setBlockState(MyPos, GetCropBlock().getDefaultState().withProperty(CookingPlusCustomRopeCrop.ROPETYPE, currentrope).withProperty(CookingPlusCustomRopeCrop.AGE, 0),3);
            	// decrement the stack of seed items
                --parItemStack.stackSize;
                return true;
            }
        return false;
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