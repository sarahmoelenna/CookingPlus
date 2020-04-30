package CookingPlus;

import CookingPlus.Interfaces.ILeyPoweredEntity;
import CookingPlus.blocks.CookingPlusBananaBlock;
import CookingPlus.blocks.CookingPlusCoconutBlock;
import CookingPlus.blocks.tileentity.CookingPlusBotBlock;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CookingPlusGenericHelper {
	
	private static final CookingPlusGenericHelper GenericHelper = new CookingPlusGenericHelper();

	public static CookingPlusGenericHelper instance()
    {
        return GenericHelper;
    }
	
	public BlockPos NearestPlayerSafeSpot(BlockPos myPos, World worldIn){
		
		if(worldIn.getBlockState(myPos.north()).getBlock() == Blocks.AIR){
			if(worldIn.getBlockState(myPos.north().up()).getBlock() == Blocks.AIR){
				return myPos.north();
			}
		}
		else if(worldIn.getBlockState(myPos.south()).getBlock() == Blocks.AIR){
			if(worldIn.getBlockState(myPos.south().up()).getBlock() == Blocks.AIR){
				return myPos.south();
			}
		}
		else if(worldIn.getBlockState(myPos.east()).getBlock() == Blocks.AIR){
			if(worldIn.getBlockState(myPos.east().up()).getBlock() == Blocks.AIR){
				return myPos.east();
			}
		}
		else if(worldIn.getBlockState(myPos.west()).getBlock() == Blocks.AIR){
			if(worldIn.getBlockState(myPos.west().up()).getBlock() == Blocks.AIR){
				return myPos.west();
			}
		}
		return null;
	}
	
	public static boolean isValidAttachmentNetworkInventoryBlock(Block myBlock, IBlockAccess myWorld, BlockPos myPos){
		 TileEntity myEntity = myWorld.getTileEntity(myPos);
		 //System.out.println("A");
		 //System.out.println(myWorld.getBlockState(myPos).getBlock().getUnlocalizedName());
		 if(myEntity instanceof TileEntityLockable){
			 //System.out.println("B");
			 if(myEntity instanceof TileEntityBeacon
					 || myEntity instanceof TileEntityBrewingStand
					 || myEntity instanceof TileEntityFurnace
					 || myEntity instanceof TileEntityDispenser
					 || myEntity instanceof TileEntityHopper){
				 return false;
			 }
			 return true;
		 }
		 
		 return false;
	 }
	
	public static boolean isValidNetworkEnergyStorageBlock(Block myBlock, IBlockAccess myWorld, BlockPos myPos){
		 TileEntity myEntity = myWorld.getTileEntity(myPos);
		 if(myEntity instanceof ILeyPoweredEntity){
			 if(((ILeyPoweredEntity)myEntity).hasLeyStorage() == true){
				 return true;
			 }
		 }
		 return false;
	 }
	
	public static boolean isValidNetworkAttachment(Block myBlock, IBlockAccess myWorld, BlockPos myPos){
		 if(myBlock instanceof CookingPlusBotBlock){
			 return true;
		 }
		 if(myBlock == CookingPlusMain.blockNetworkBlock){
			 return true;
		 }
		 if(myBlock == CookingPlusMain.blockBattery){
			 return true;
		 }
		 if(myBlock == CookingPlusMain.blockLeyReceiver){
			 return true;
		 }
		 TileEntity myEntity = myWorld.getTileEntity(myPos);
		 if(myEntity instanceof TileEntityLockable){
			 if(myEntity instanceof TileEntityBeacon
					 || myEntity instanceof TileEntityBrewingStand
					 || myEntity instanceof TileEntityFurnace
					 || myEntity instanceof TileEntityDispenser
					 || myEntity instanceof TileEntityHopper){
				 return false;
			 }
			 return true;
		 }
		 
		 return false;
	 }
	
	public static boolean isLoggerPriorityBlock(Block myBlock){
		if(myBlock instanceof CookingPlusBananaBlock){
			return true;
		} else if(myBlock instanceof CookingPlusCoconutBlock){
			return true;
		}
		return false;
	}
}
