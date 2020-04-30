package CookingPlus.tiles;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.CookingPlusMain;
import CookingPlus.Interfaces.ILeyLineProducer;
import CookingPlus.Interfaces.ILeyPoweredEntity;

public class LeyLinePropagatorTileEntity extends CookingPlusCustomTileEntity implements ILeyLineProducer, ITickable {
	//0 - connection to other block
	//1 - closed
	//2 - output ley
	//3 - input ley
	protected int north;
	protected int south;
	protected int east;
	protected int west;
	protected int up;
	protected int down;
	
	protected boolean northBeam;
	protected boolean southBeam;
	protected boolean eastBeam;
	protected boolean westBeam;
	protected boolean upBeam;
	protected boolean downBeam;
	
	protected int northInput;
	protected int southInput;
	protected int eastInput;
	protected int westInput;
	protected int upInput;
	protected int downInput;
	
	protected int energyInput;
	protected int powerLevel;
	
	public int northBlocks;
	public int southBlocks;
	public int eastBlocks;
	public int westBlocks;
	public int upBlocks;
	public int downBlocks;
	
	protected float Rotation;
	
	public LeyLinePropagatorTileEntity(){
		north = 1;
		south = 1;
		east = 1;
		west = 1;
		up = 1;
		down = 1;
		
		northBeam = false;
		southBeam = false;
		eastBeam = false;
		westBeam = false;
		upBeam = false;
		downBeam = false;
		
		northBlocks = 0;
		southBlocks = 0;
		eastBlocks = 0;
		westBlocks = 0;
		upBlocks = 0;
		downBlocks = 0;
		
		northInput = 0;
		southInput = 0;
		eastInput= 0;
		westInput = 0;
		upInput = 0;
		downInput = 0;
		
		energyInput = 0;
		powerLevel = 0;
		
		Rotation = 0;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);

		north = nbt.getInteger("north");
		south = nbt.getInteger("south");
		east = nbt.getInteger("east");
		west = nbt.getInteger("west");
		up = nbt.getInteger("up");
		down = nbt.getInteger("down");
		
		northBlocks = nbt.getInteger("northBlocks");
		southBlocks = nbt.getInteger("southBlocks");
		eastBlocks = nbt.getInteger("eastBlocks");
		westBlocks = nbt.getInteger("westBlocks");
		upBlocks = nbt.getInteger("upBlocks");
		downBlocks = nbt.getInteger("downBlocks");
		
		powerLevel = nbt.getInteger("powerlevel");
		
		northBeam = nbt.getBoolean("northBeam");
		southBeam = nbt.getBoolean("southBeam");
		eastBeam = nbt.getBoolean("eastBeam");
		westBeam = nbt.getBoolean("westBeam");
		upBeam = nbt.getBoolean("upBeam");
		downBeam = nbt.getBoolean("downBeam");

	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		
		super.writeToNBT(nbt);
		
		NBTTagList nbttaglist = new NBTTagList();
		
		nbt.setInteger("northBlocks", northBlocks);
		nbt.setInteger("southBlocks", southBlocks);
		nbt.setInteger("eastBlocks", eastBlocks);
		nbt.setInteger("westBlocks", westBlocks);
		nbt.setInteger("upBlocks", upBlocks);
		nbt.setInteger("downBlocks", downBlocks);
		
		nbt.setInteger("north", north);
		nbt.setInteger("south", south);
		nbt.setInteger("east", east);
		nbt.setInteger("west", west);
		nbt.setInteger("up", up);
		nbt.setInteger("down", down);
		
		nbt.setInteger("powerlevel", powerLevel);
		
		nbt.setBoolean("northBeam", northBeam);
		nbt.setBoolean("southBeam", southBeam);
		nbt.setBoolean("westBeam", westBeam);
		nbt.setBoolean("eastBeam", eastBeam);
		nbt.setBoolean("upBeam", upBeam);
		nbt.setBoolean("downBeam", downBeam);

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
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
		if(oldState.getBlock().equals(CookingPlusMain.blockLeyPropagator) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockLeyPropagator) == false){
				world.removeTileEntity(pos);
				//return true;
			}
		}
        return false;
    }
	
	@Override
	public void update() {
		
		if(this.getWorld().isRemote == false){
			updateBlockCount(EnumFacing.NORTH, blocksUntilConnection(EnumFacing.NORTH));
			updateBlockCount(EnumFacing.SOUTH, blocksUntilConnection(EnumFacing.SOUTH));
			updateBlockCount(EnumFacing.EAST, blocksUntilConnection(EnumFacing.EAST));
			updateBlockCount(EnumFacing.WEST, blocksUntilConnection(EnumFacing.WEST));
			updateBlockCount(EnumFacing.UP, blocksUntilConnection(EnumFacing.UP));
			updateBlockCount(EnumFacing.DOWN, blocksUntilConnection(EnumFacing.DOWN));
			
			energyInput = getCurrentInput();
			updateBeamVisibility();
			powerLeyConnectedDevices();
			updatePowerLevel();
			northInput = 0;
			southInput = 0;
			eastInput= 0;
			westInput = 0;
			upInput = 0;
			downInput = 0;
		}
		
		Rotation++;
	}

	public void updatePowerLevel(){
		int divideInputBy = 0;
		if(north == 2 && northBlocks > 0){
			divideInputBy++;
		}
		if(south == 2 && southBlocks > 0){
			divideInputBy++;
		}
		if(east == 2 && eastBlocks > 0){
			divideInputBy++;
		}
		if(west == 2 && westBlocks > 0){
			divideInputBy++;
		}
		if(up == 2 && upBlocks > 0){
			divideInputBy++;
		}
		if(down == 2 && downBlocks > 0){
			divideInputBy++;
		}
		int energyPerOutput = 0;
		if(energyInput > 0 && divideInputBy > 0){
			energyPerOutput = energyInput / divideInputBy;
		}
		if(energyPerOutput < 25){
			updatePowerLevel(0);
		} else if(energyPerOutput >= 25 && energyPerOutput < 50){
			updatePowerLevel(1);
		} else if(energyPerOutput >= 50 && energyPerOutput < 100){
			updatePowerLevel(2);
		} else if(energyPerOutput >= 100 && energyPerOutput < 200){
			updatePowerLevel(3);
		} else if(energyPerOutput >= 200 && energyPerOutput < 400){
			updatePowerLevel(4);
		} else if(energyPerOutput >= 400 && energyPerOutput < 800){
			updatePowerLevel(5);
		} else if(energyPerOutput > 800){
			updatePowerLevel(6);
		}
		else{
			updatePowerLevel(0);
		}
	}
	
	public void updatePowerLevel(int value){
		if(powerLevel != value){
			powerLevel = value;
			UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
		}
	}
	
	public int getCurrentInput(){
		int energyusage = 0;
		if(north == 2){
			energyusage+= 2;
		}
		if(south == 2){
			energyusage+= 2;
		}
		if(east == 2){
			energyusage+= 2;
		}
		if(west == 2){
			energyusage+= 2;
		}
		if(up == 2){
			energyusage+= 2;
		}
		if(down == 2){
			energyusage+= 2;
		}
		return northInput + southInput + eastInput + westInput + upInput + downInput - energyusage;
	}
	
	public void updateBeamVisibility(){
		if(energyInput > 0){
			updateBeamVisibility(EnumFacing.NORTH, true);
			updateBeamVisibility(EnumFacing.SOUTH, true);
			updateBeamVisibility(EnumFacing.EAST, true);
			updateBeamVisibility(EnumFacing.WEST, true);
			updateBeamVisibility(EnumFacing.UP, true);
			updateBeamVisibility(EnumFacing.DOWN, true);
		}
		else{
			updateBeamVisibility(EnumFacing.NORTH, false);
			updateBeamVisibility(EnumFacing.SOUTH, false);
			updateBeamVisibility(EnumFacing.EAST, false);
			updateBeamVisibility(EnumFacing.WEST, false);
			updateBeamVisibility(EnumFacing.UP, false);
			updateBeamVisibility(EnumFacing.DOWN, false);
		}
	}
		
	public void powerLeyConnectedDevices(){
		int divideInputBy = 0;
		
		if(north == 2 && northBlocks > 0){
			divideInputBy++;
		}
		if(south == 2 && southBlocks > 0){
			divideInputBy++;
		}
		if(east == 2 && eastBlocks > 0){
			divideInputBy++;
		}
		if(west == 2 && westBlocks > 0){
			divideInputBy++;
		}
		if(up == 2 && upBlocks > 0){
			divideInputBy++;
		}
		if(down == 2 && downBlocks > 0){
			divideInputBy++;
		}
		if(divideInputBy > 0){
			int energyPerOutput = energyInput / divideInputBy;
			if(north == 2){
				TileEntity myEntity = this.getWorld().getTileEntity(getPos().north(northBlocks + 1));
				if(myEntity instanceof LeyLineReceiverTileEntity){
					((LeyLineReceiverTileEntity)myEntity).inputEnergy(energyPerOutput);
				}
				if(myEntity instanceof LeyLinePropagatorTileEntity){
					((LeyLinePropagatorTileEntity)myEntity).setInputToSide(EnumFacing.NORTH, energyPerOutput);
				}
			}
			if(south == 2){
				TileEntity myEntity = this.getWorld().getTileEntity(getPos().south(southBlocks + 1));
				if(myEntity instanceof LeyLineReceiverTileEntity){
					((LeyLineReceiverTileEntity)myEntity).inputEnergy(energyPerOutput);
				}
				if(myEntity instanceof LeyLinePropagatorTileEntity){
					((LeyLinePropagatorTileEntity)myEntity).setInputToSide(EnumFacing.SOUTH, energyPerOutput);
				}
			}
			if(east == 2){
				TileEntity myEntity = this.getWorld().getTileEntity(getPos().east(eastBlocks + 1));
				if(myEntity instanceof LeyLineReceiverTileEntity){
					((LeyLineReceiverTileEntity)myEntity).inputEnergy(energyPerOutput);
				}
				if(myEntity instanceof LeyLinePropagatorTileEntity){
					((LeyLinePropagatorTileEntity)myEntity).setInputToSide(EnumFacing.EAST, energyPerOutput);
				}
			}
			if(west == 2){
				TileEntity myEntity = this.getWorld().getTileEntity(getPos().west(westBlocks + 1));
				if(myEntity instanceof LeyLineReceiverTileEntity){
					((LeyLineReceiverTileEntity)myEntity).inputEnergy(energyPerOutput);
				}
				if(myEntity instanceof LeyLinePropagatorTileEntity){
					((LeyLinePropagatorTileEntity)myEntity).setInputToSide(EnumFacing.WEST, energyPerOutput);
				}
			}
			if(up == 2){
				TileEntity myEntity = this.getWorld().getTileEntity(getPos().up(upBlocks + 1));
				if(myEntity instanceof LeyLineReceiverTileEntity){
					((LeyLineReceiverTileEntity)myEntity).inputEnergy(energyPerOutput);
				}
				if(myEntity instanceof LeyLinePropagatorTileEntity){
					((LeyLinePropagatorTileEntity)myEntity).setInputToSide(EnumFacing.UP, energyPerOutput);
				}
			}
			if(down == 2){
				TileEntity myEntity = this.getWorld().getTileEntity(getPos().down(downBlocks + 1));
				if(myEntity instanceof LeyLineReceiverTileEntity){
					((LeyLineReceiverTileEntity)myEntity).inputEnergy(energyPerOutput);
				}
				if(myEntity instanceof LeyLinePropagatorTileEntity){
					((LeyLinePropagatorTileEntity)myEntity).setInputToSide(EnumFacing.DOWN, energyPerOutput);
				}
			}
			
		}
	}
	
	public void updateBlockCount(EnumFacing myFacing, int value){
		if(myFacing == EnumFacing.NORTH){
			if(northBlocks != value){
				northBlocks = value;
				UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
			}
		}
		if(myFacing == EnumFacing.SOUTH){
			if(southBlocks != value){
				southBlocks = value;
				UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
			}
		}
		if(myFacing == EnumFacing.EAST){
			if(eastBlocks != value){
				eastBlocks = value;
				UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
			}
		}
		if(myFacing == EnumFacing.WEST){
			if(westBlocks != value){
				westBlocks = value;
				UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
			}
		}
		if(myFacing == EnumFacing.UP){
			if(upBlocks != value){
				upBlocks = value;
				UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
			}
		}
		if(myFacing == EnumFacing.DOWN){
			if(downBlocks != value){
				downBlocks = value;
				UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
			}
		}
	}
	
	public void updateBeamVisibility(EnumFacing myFacing, boolean value){
		if(myFacing == EnumFacing.NORTH){
			if(northBeam != value){
				northBeam = value;
				UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
			}
		}
		if(myFacing == EnumFacing.SOUTH){
			if(southBeam != value){
				southBeam = value;
				UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
			}
		}
		if(myFacing == EnumFacing.EAST){
			if(eastBeam != value){
				eastBeam = value;
				UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
			}
		}
		if(myFacing == EnumFacing.WEST){
			if(westBeam != value){
				westBeam = value;
				UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
			}
		}
		if(myFacing == EnumFacing.UP){
			if(upBeam != value){
				upBeam = value;
				UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
			}
		}
		if(myFacing == EnumFacing.DOWN){
			if(downBeam != value){
				downBeam = value;
				UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
			}
		}
	}
	
	@Override
	public int blocksUntilConnection(EnumFacing myFacing) {
		int blocksTillConnection = 0;
		boolean canCarryOn = true;
		if(myFacing == EnumFacing.NORTH){
			for(int i = 1; i <= 32 && canCarryOn == true && north == 2; i++){
				BlockPos myCheckPos = this.getPos().north(i);
				if(this.getWorld().getBlockState(myCheckPos).getMaterial() == Material.WATER
						|| this.getWorld().getBlockState(myCheckPos).getMaterial() == Material.LAVA
						|| this.getWorld().getBlockState(myCheckPos).getMaterial() == Material.AIR){
					blocksTillConnection++;
				}
				else{
					if(this.getWorld().getBlockState(myCheckPos).getBlock() != CookingPlusMain.blockLeyReceiver
							&& this.getWorld().getBlockState(myCheckPos).getBlock() != CookingPlusMain.blockLeyPropagator){
						blocksTillConnection = 0;
					}
					if(this.getWorld().getBlockState(myCheckPos).getBlock() == CookingPlusMain.blockLeyPropagator){
						ILeyLineProducer myentity = (ILeyLineProducer) this.getWorld().getTileEntity(myCheckPos);
						if(myentity.stateOfSide(EnumFacing.SOUTH) != 3){
							blocksTillConnection = 0;
						}
					}
					canCarryOn = false;
					
				}
				if(i == 32){
					if(this.getWorld().getBlockState(myCheckPos).getBlock() != CookingPlusMain.blockLeyReceiver
							&& this.getWorld().getBlockState(myCheckPos).getBlock() != CookingPlusMain.blockLeyPropagator){
						blocksTillConnection = 0;
					}
				}
			}
		}
		
		if(myFacing == EnumFacing.SOUTH){
			for(int i = 1; i <= 32 && canCarryOn == true  && south == 2; i++){
				BlockPos myCheckPos = this.getPos().south(i);
				if(this.getWorld().getBlockState(myCheckPos).getMaterial() == Material.WATER
						|| this.getWorld().getBlockState(myCheckPos).getMaterial() == Material.LAVA
						|| this.getWorld().getBlockState(myCheckPos).getMaterial() == Material.AIR){
					blocksTillConnection++;
				}
				else{
					if(this.getWorld().getBlockState(myCheckPos).getBlock() != CookingPlusMain.blockLeyReceiver
							&& this.getWorld().getBlockState(myCheckPos).getBlock() != CookingPlusMain.blockLeyPropagator){
						blocksTillConnection = 0;
					}
					if(this.getWorld().getBlockState(myCheckPos).getBlock() == CookingPlusMain.blockLeyPropagator){
						ILeyLineProducer myentity = (ILeyLineProducer) this.getWorld().getTileEntity(myCheckPos);
						if(myentity.stateOfSide(EnumFacing.NORTH) != 3){
							blocksTillConnection = 0;
						}
					}
					canCarryOn = false;
					
				}
				if(i == 32){
					if(this.getWorld().getBlockState(myCheckPos).getBlock() != CookingPlusMain.blockLeyReceiver
							&& this.getWorld().getBlockState(myCheckPos).getBlock() != CookingPlusMain.blockLeyPropagator){
						blocksTillConnection = 0;
					}
				}
			}
		}
		
		if(myFacing == EnumFacing.EAST){
			for(int i = 1; i <= 32 && canCarryOn == true && east == 2; i++){
				BlockPos myCheckPos = this.getPos().east(i);
				if(this.getWorld().getBlockState(myCheckPos).getMaterial() == Material.WATER
						|| this.getWorld().getBlockState(myCheckPos).getMaterial() == Material.LAVA
						|| this.getWorld().getBlockState(myCheckPos).getMaterial() == Material.AIR){
					blocksTillConnection++;
				}
				else{
					if(this.getWorld().getBlockState(myCheckPos).getBlock() != CookingPlusMain.blockLeyReceiver
							&& this.getWorld().getBlockState(myCheckPos).getBlock() != CookingPlusMain.blockLeyPropagator){
						blocksTillConnection = 0;
					}
					if(this.getWorld().getBlockState(myCheckPos).getBlock() == CookingPlusMain.blockLeyPropagator){
						ILeyLineProducer myentity = (ILeyLineProducer) this.getWorld().getTileEntity(myCheckPos);
						if(myentity.stateOfSide(EnumFacing.WEST) != 3){
							blocksTillConnection = 0;
						}
					}
					canCarryOn = false;
					
				}
				if(i == 32){
					if(this.getWorld().getBlockState(myCheckPos).getBlock() != CookingPlusMain.blockLeyReceiver
							&& this.getWorld().getBlockState(myCheckPos).getBlock() != CookingPlusMain.blockLeyPropagator){
						blocksTillConnection = 0;
					}
				}
			}
		}
		
		if(myFacing == EnumFacing.WEST){
			for(int i = 1; i <= 32 && canCarryOn == true  && west == 2; i++){
				BlockPos myCheckPos = this.getPos().west(i);
				if(this.getWorld().getBlockState(myCheckPos).getMaterial() == Material.WATER
						|| this.getWorld().getBlockState(myCheckPos).getMaterial() == Material.LAVA
						|| this.getWorld().getBlockState(myCheckPos).getMaterial() == Material.AIR){
					blocksTillConnection++;
				}
				else{
					if(this.getWorld().getBlockState(myCheckPos).getBlock() != CookingPlusMain.blockLeyReceiver
							&& this.getWorld().getBlockState(myCheckPos).getBlock() != CookingPlusMain.blockLeyPropagator){
						blocksTillConnection = 0;
					}
					if(this.getWorld().getBlockState(myCheckPos).getBlock() == CookingPlusMain.blockLeyPropagator){
						ILeyLineProducer myentity = (ILeyLineProducer) this.getWorld().getTileEntity(myCheckPos);
						if(myentity.stateOfSide(EnumFacing.EAST) != 3){
							blocksTillConnection = 0;
						}
					}
					canCarryOn = false;
					
				}
				if(i == 32){
					if(this.getWorld().getBlockState(myCheckPos).getBlock() != CookingPlusMain.blockLeyReceiver
							&& this.getWorld().getBlockState(myCheckPos).getBlock() != CookingPlusMain.blockLeyPropagator){
						blocksTillConnection = 0;
					}
				}
			}
		}
		
		if(myFacing == EnumFacing.UP){
			for(int i = 1; i <= 32 && canCarryOn == true && up == 2; i++){
				BlockPos myCheckPos = this.getPos().up(i);
				if(myCheckPos.getY() > 0 && myCheckPos.getY() < 256){
				if(this.getWorld().getBlockState(myCheckPos).getMaterial() == Material.WATER
						|| this.getWorld().getBlockState(myCheckPos).getMaterial() == Material.LAVA
						|| this.getWorld().getBlockState(myCheckPos).getMaterial() == Material.AIR){
					blocksTillConnection++;
				}
				else{
					if(this.getWorld().getBlockState(myCheckPos).getBlock() != CookingPlusMain.blockLeyReceiver
							&& this.getWorld().getBlockState(myCheckPos).getBlock() != CookingPlusMain.blockLeyPropagator){
						blocksTillConnection = 0;
					}
					if(this.getWorld().getBlockState(myCheckPos).getBlock() == CookingPlusMain.blockLeyPropagator){
						ILeyLineProducer myentity = (ILeyLineProducer) this.getWorld().getTileEntity(myCheckPos);
						if(myentity.stateOfSide(EnumFacing.DOWN) != 3){
							blocksTillConnection = 0;
						}
					}
					canCarryOn = false;
					
				}
				if(i == 32){
					if(this.getWorld().getBlockState(myCheckPos).getBlock() != CookingPlusMain.blockLeyReceiver
							&& this.getWorld().getBlockState(myCheckPos).getBlock() != CookingPlusMain.blockLeyPropagator){
						blocksTillConnection = 0;
					}
				}
				}
				else{
					canCarryOn = false;
					blocksTillConnection = 0;
				}
			}
		}
		
		if(myFacing == EnumFacing.DOWN){
			for(int i = 1; i <= 32 && canCarryOn == true && down == 2; i++){
				BlockPos myCheckPos = this.getPos().down(i);
				if(myCheckPos.getY() > 0 && myCheckPos.getY() < 256){
				if(this.getWorld().getBlockState(myCheckPos).getMaterial() == Material.WATER
						|| this.getWorld().getBlockState(myCheckPos).getMaterial() == Material.LAVA
						|| this.getWorld().getBlockState(myCheckPos).getMaterial() == Material.AIR){
					blocksTillConnection++;
				}
				else{
					if(this.getWorld().getBlockState(myCheckPos).getBlock() != CookingPlusMain.blockLeyReceiver
							&& this.getWorld().getBlockState(myCheckPos).getBlock() != CookingPlusMain.blockLeyPropagator){
						blocksTillConnection = 0;
					}
					if(this.getWorld().getBlockState(myCheckPos).getBlock() == CookingPlusMain.blockLeyPropagator){
						ILeyLineProducer myentity = (ILeyLineProducer) this.getWorld().getTileEntity(myCheckPos);
						if(myentity.stateOfSide(EnumFacing.UP) != 3){
							blocksTillConnection = 0;
						}
					}
					canCarryOn = false;
					
				}
				if(i == 32){
					if(this.getWorld().getBlockState(myCheckPos).getBlock() != CookingPlusMain.blockLeyReceiver
							&& this.getWorld().getBlockState(myCheckPos).getBlock() != CookingPlusMain.blockLeyPropagator){
						blocksTillConnection = 0;
					}
				}
				}
				else{
					canCarryOn = false;
					blocksTillConnection = 0;
				}
			}
		}
		
		return blocksTillConnection;
	}
		
	@Override
	public int stateOfSide(EnumFacing myFacing) {
		if(myFacing == EnumFacing.NORTH){
			return north;
		}
		if(myFacing == EnumFacing.SOUTH){
			return south;
		}
		if(myFacing == EnumFacing.EAST){
			return east;
		}
		if(myFacing == EnumFacing.WEST){
			return west;
		}
		if(myFacing == EnumFacing.UP){
			return up;
		}
		if(myFacing == EnumFacing.DOWN){
			return down;
		}
		return -1;
	}
	
	public boolean isBeamVisible(EnumFacing myFacing) {
		if(myFacing == EnumFacing.NORTH){
			return northBeam;
		}
		if(myFacing == EnumFacing.SOUTH){
			return southBeam;
		}
		if(myFacing == EnumFacing.EAST){
			return eastBeam;
		}
		if(myFacing == EnumFacing.WEST){
			return westBeam;
		}
		if(myFacing == EnumFacing.UP){
			return upBeam;
		}
		if(myFacing == EnumFacing.DOWN){
			return downBeam;
		}
		return false;
	}

	@Override
	public int getOutputFromSide(EnumFacing myFacing) {
		if(myFacing == EnumFacing.NORTH && north == 2){
			return north;
		}
		if(myFacing == EnumFacing.SOUTH && south == 2){
			return south;
		}
		if(myFacing == EnumFacing.EAST && east == 2){
			return east;
		}
		if(myFacing == EnumFacing.WEST && west == 2){
			return west;
		}
		if(myFacing == EnumFacing.UP && up == 2){
			return up;
		}
		if(myFacing == EnumFacing.DOWN && down == 2){
			return down;
		}
		return 0;
	}

	@Override
	public void setInputToSide(EnumFacing myFacing, int amount) {
		if(myFacing == EnumFacing.NORTH){
			northInput = amount;
		}
		if(myFacing == EnumFacing.SOUTH){
			 southInput = amount;
		}
		if(myFacing == EnumFacing.EAST){
			 eastInput = amount;
		}
		if(myFacing == EnumFacing.WEST){
			 westInput = amount;
		}
		if(myFacing == EnumFacing.UP){
			 upInput = amount;
		}
		if(myFacing == EnumFacing.DOWN){
			 downInput = amount;
		}
	}
	
	public void playerActivateMessage(EntityPlayer myPlayer, int Message){
		if(Message == 1){
			myPlayer.addChatMessage(new TextComponentTranslation("msg.leyside1.txt"));
		}
		if(Message == 2){
			myPlayer.addChatMessage(new TextComponentTranslation("msg.leyside2.txt"));
		}
		if(Message == 3){
			myPlayer.addChatMessage(new TextComponentTranslation("msg.leyside3.txt"));
		}
		UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
	}

	@Override
	public void processPlayerActivate(EnumFacing myFacing, EntityPlayer myPlayer){
		if(myPlayer.isSneaking() && this.getWorld().isRemote == false){
			if(myFacing == EnumFacing.NORTH){
				north++;
				if(north > 3){
					north = 1;
				}
				playerActivateMessage(myPlayer, north);
			}
			if(myFacing == EnumFacing.SOUTH){
				south++;
				if(south > 3){
					south = 1;
				}
				playerActivateMessage(myPlayer, south);
			}
			if(myFacing == EnumFacing.EAST){
				east++;
				if(east > 3){
					east = 1;
				}
				playerActivateMessage(myPlayer, east);
			}
			if(myFacing == EnumFacing.WEST){
				west++;
				if(west > 3){
					west = 1;
				}
				playerActivateMessage(myPlayer, west);
			}
			if(myFacing == EnumFacing.UP){
				up++;
				if(up > 3){
					up = 1;
				}
				playerActivateMessage(myPlayer, up);
			}
			if(myFacing == EnumFacing.DOWN){
				down++;
				if(down > 3){
					down = 1;
				}
				playerActivateMessage(myPlayer, down);
			}
		}
	}

	@Override
	public int getSideBlockCount(EnumFacing myFacing) {
		if(myFacing == EnumFacing.NORTH){
			return northBlocks;
		}
		if(myFacing == EnumFacing.SOUTH){
			return southBlocks;
		}
		if(myFacing == EnumFacing.EAST){
			return eastBlocks;
		}
		if(myFacing == EnumFacing.WEST){
			return westBlocks;
		}
		if(myFacing == EnumFacing.UP){
			return upBlocks;
		}
		if(myFacing == EnumFacing.DOWN){
			return downBlocks;
		}
			
		return 0;
	}

	@Override
	public float getLeyRotation() {
		return Rotation;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public net.minecraft.util.math.AxisAlignedBB getRenderBoundingBox()
    {
		net.minecraft.util.math.AxisAlignedBB MY_AABB = new net.minecraft.util.math.AxisAlignedBB(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
		return MY_AABB;
    }

	@Override
	public int getBeamPowerLevel() {
		// TODO Auto-generated method stub
		return powerLevel;
	}
}
