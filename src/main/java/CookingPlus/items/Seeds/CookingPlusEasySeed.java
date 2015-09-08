package CookingPlus.items.Seeds;

import CookingPlus.CookingPlusMain;
import CookingPlus.items.CookingPlusCustomEdibleSeed;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusEasySeed extends CookingPlusCustomEdibleSeed 
{
	private String name;
	private Block myCropBlock;
	private Block myGroundBlock;

    public CookingPlusEasySeed(String myName, Block myCrop, Block GroundBlock)
    {
        super(1, 0.3F, myCrop, GroundBlock);
        name = myName;
        GameRegistry.registerItem(this, name);
        setUnlocalizedName(name);
        myCropBlock = myCrop;
        myGroundBlock = GroundBlock;
    }
    
    public Block GetCropBlock(){
		return myCropBlock;
    }
    
    @Override
    public String getName()
    {
    	return name;
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
            if (parWorld.getBlockState(MyPos).getBlock() == myGroundBlock && parWorld.isAirBlock(new BlockPos(new Vec3(MyPos.getX(), MyPos.getY()+1, MyPos.getZ()))))
            {
             // place the plant block
            	setBlock(parWorld, new BlockPos(new Vec3(MyPos.getX(), MyPos.getY()+1, MyPos.getZ())));
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
}