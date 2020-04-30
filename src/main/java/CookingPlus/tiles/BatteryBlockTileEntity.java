package CookingPlus.tiles;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import CookingPlus.CookingPlusMain;
import CookingPlus.Interfaces.ILeyPoweredEntity;
import CookingPlus.blocks.tileentity.CookingPlusBatteryBlock;

public class BatteryBlockTileEntity extends CookingPlusCustomTileEntity implements  ILeyPoweredEntity {

	int PowerLevel;
	
	public BatteryBlockTileEntity(){
		PowerLevel = 0;
	}
	
	@Override
	public boolean hasLeyStorage() {
		return true;
	}

	@Override
	public boolean canRequestLeyAmount(int amount) {
		return PowerLevel >= amount;
	}

	@Override
	public void drainLeyEnergy(int amount) {
		PowerLevel -= amount;
		CheckBlockState();
	}

	private void CheckBlockState(){
		int BlockPowerLevel = (PowerLevel / 1000) * 7/8;
		if(this.getWorld().getBlockState(getPos()).getValue(CookingPlusBatteryBlock.POWER_LEVEL).intValue() != BlockPowerLevel){
			this.getWorld().setBlockState(getPos(), CookingPlusMain.blockBattery.getDefaultState().withProperty(CookingPlusBatteryBlock.POWER_LEVEL, BlockPowerLevel));
			UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
		}
	}
	

	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
		if(oldState.getBlock().equals(CookingPlusMain.blockBattery) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockBattery) == false){
				world.removeTileEntity(pos);
				//return true;
			}
		}
        return false;
    }

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		PowerLevel = nbt.getInteger("powerlevel");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		
		super.writeToNBT(nbt);
		nbt.setInteger("powerlevel", PowerLevel);
		return nbt;
	}
	
	@Override
    public SPacketUpdateTileEntity getUpdatePacket()
    {
		NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);
		return new SPacketUpdateTileEntity(this.getPos(), 1, tag);
    }
	
	@Override
	public void onDataPacket(NetworkManager net,SPacketUpdateTileEntity packet) {
		readFromNBT(packet.getNbtCompound());
	}

	@Override
	public int getmaxStorageAmount() {
		return 8000;
	}

	@Override
	public int getCurrentStorageAmount() {
		return PowerLevel;
	}

	@Override
	public int transfertEnergyToStorage(int amount) {
		if(getCurrentStorageAmount() < getmaxStorageAmount()){
			int capacityLeft = getmaxStorageAmount() - getCurrentStorageAmount();
			if(capacityLeft > amount){
				PowerLevel += amount;
				CheckBlockState();
				return 0;
			}
			else{
				PowerLevel += capacityLeft;
				CheckBlockState();
				return amount - capacityLeft;
			}
		}
		else{
			return amount;
		}
	}


}
