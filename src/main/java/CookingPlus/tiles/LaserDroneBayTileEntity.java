package CookingPlus.tiles;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.CookingPlusGenericHelper;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.tileentity.CookingPlusCustomTileEntityBlock;

public class LaserDroneBayTileEntity extends CookingPlusCustomTileEntity implements ITickable {

	float speed;
	float basespeed;
	float rotation;
	int basepause;
	int pause;
	int Type = 0;
	int rangeboost;
	boolean droneInPosition;
	Vec3d oldlaserDroneVec;
	Vec3d currentlaserDroneVec;
	Vec3d currentharvestDroneVec;
	//BlockPos currentlaserDronePosition;
	//BlockPos currentharvestDronePosition;
	private static final ArrayList<Block> IgnoreBlockList = new ArrayList<Block>();
	
	public LaserDroneBayTileEntity() {
		Random myRand = new Random();
		basespeed = 0.03f;
		basepause = 30;
		rotation = 0;
		pause = 0;
		speed = basespeed;
		rangeboost = 0;
		
		if(IgnoreBlockList.isEmpty()){
			IgnoreBlockList.add(CookingPlusMain.blockNetworkBlock);
			IgnoreBlockList.add(CookingPlusMain.blockCopperScaff);
			IgnoreBlockList.add(CookingPlusMain.blockZincScaff);
			IgnoreBlockList.add(CookingPlusMain.blockIronScaff);
			IgnoreBlockList.add(CookingPlusMain.blockDiamondScaff);
			IgnoreBlockList.add(CookingPlusMain.blockGoldScaff);
			IgnoreBlockList.add(CookingPlusMain.blockSiliconScaff);
			IgnoreBlockList.add(CookingPlusMain.blockRedstoneScaff);
			IgnoreBlockList.add(Blocks.BEDROCK);
			IgnoreBlockList.add(Blocks.RED_SANDSTONE);
			IgnoreBlockList.add(Blocks.SLIME_BLOCK);
		}
		
		SetDroneInPosition(false);
		//currentharvestDronePosition = this.getPos();
		
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);

		if(nbt.getFloat("dronech") > -1000){
			currentharvestDroneVec = new Vec3d(nbt.getFloat("dronehx"), nbt.getFloat("dronehy"), nbt.getFloat("dronehz"));
		}
		
		if(nbt.getFloat("dronecy") > -1000){
			currentlaserDroneVec = new Vec3d(nbt.getFloat("dronecx"), nbt.getFloat("dronecy"), nbt.getFloat("dronecz"));
		}
		
		droneInPosition = nbt.getBoolean("DIP");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		
		if(currentharvestDroneVec == null){
			nbt.setFloat("dronehx", 0);
			nbt.setFloat("dronehy", -1000);
			nbt.setFloat("dronehz", 0);
		}
		else{
			nbt.setFloat("dronehx", (float) currentharvestDroneVec.xCoord);
			nbt.setFloat("dronehy", (float) currentharvestDroneVec.yCoord);
			nbt.setFloat("dronehz", (float) currentharvestDroneVec.zCoord);
		}
		
		if(currentlaserDroneVec == null){
			nbt.setFloat("dronecx", 0);
			nbt.setFloat("dronecy", -1000);
			nbt.setFloat("dronecz", 0);
		}
		else{
			nbt.setFloat("dronecx", (float) currentlaserDroneVec.xCoord);
			nbt.setFloat("dronecy", (float) currentlaserDroneVec.yCoord);
			nbt.setFloat("dronecz", (float) currentlaserDroneVec.zCoord);
		}

		nbt.setBoolean("DIP", droneInPosition);

		return super.writeToNBT(nbt);
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
	
	public void processActivate(EntityPlayer Player) {
		
	}
	
	@Override
    public void update(){
		
		rotation+=3;
		
		if(currentlaserDroneVec == null){
			currentlaserDroneVec = new Vec3d(getPos().getX(), getPos().getY(), getPos().getZ());
		}
		Type ++;
		if(Type > 12){
			Type = 0;
		}

		if(currentharvestDroneVec != null){
			MoveDrone();
		}
		
		if(!CookingPlusMain.blockLaserDroneBay.canPlaceBlockAt(this.getWorld(), this.getPos())){
			CookingPlusMain.blockLaserDroneBay.dropBlockAsItem(this.getWorld(), this.getPos(), this.getWorld().getBlockState(this.getPos()), 0);
			this.getWorld().setBlockState(this.getPos(), Blocks.AIR.getDefaultState());
		}
		
	}
	
	public int getType(){
		return Type/4;
	}

	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
		if(oldState.getBlock().equals(CookingPlusMain.blockLaserDroneBay) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockLaserDroneBay) == false){
				world.removeTileEntity(pos);
			}
		}
        return false;
    }

	public boolean updateLaserDrone(BlockPos myBayPos, float droneSpeedMultiplier, BotTileEntity myBot, int myRangeBoost){
		speed = basespeed / droneSpeedMultiplier;
		
		rangeboost = myRangeBoost;
		
		if(currentlaserDroneVec == null){
			currentlaserDroneVec = new Vec3d(getPos().getX(), getPos().getY(), getPos().getZ());
		}
		if(this.getWorld().isRemote == false){
			if(findNextHarvestBlock(pos) == false){
				return false;
			}
			
			if(currentlaserDroneVec.xCoord != currentharvestDroneVec.xCoord || currentlaserDroneVec.yCoord != currentharvestDroneVec.yCoord + 1 || currentlaserDroneVec.zCoord != currentharvestDroneVec.zCoord){
				SetDroneInPosition(false);
			}
			else{
				SetDroneInPosition(true);
			}
			
			if(droneInPosition == true){
				pause++;
				if(pause > basepause * droneSpeedMultiplier){
					if(currentharvestDroneVec != null){
						HarvestCurrentBlock(myBot);
						pause = 0;
					}
				}
			}
			
		}
		/*
		if(this.getWorld().isRemote==true){
			if(droneInPosition == true){
				pause++;
				System.out.println("hhmmm");
				if(pause > basepause * droneSpeedMultiplier){
						pause = 0;
						System.out.println("hhmmm");
				}
			}
			else{
				pause = 0 ;
			}
		}*/
		
		return true;
	}
	
	protected boolean findNextHarvestBlock(BlockPos myPos){
		
		for(int y = 0; y < myPos.getY(); y++){
			for(int x = 0; x < 9 + rangeboost * 2; x++){
				for(int z = 0; z < 9 + rangeboost * 2; z++){
					BlockPos myCheckPos = new BlockPos(new Vec3d(myPos.getX() + x - 4 - rangeboost, myPos.getY() - y, myPos.getZ() + z - 4 - rangeboost));
					if(isBlockValidForHarvest(myCheckPos)){
						SetCurrentHarvestPosition(myCheckPos);
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	private void SetCurrentHarvestPosition(BlockPos myNewHarvest){
		if(currentharvestDroneVec != new Vec3d(myNewHarvest.getX(), myNewHarvest.getY(), myNewHarvest.getZ())){
			currentharvestDroneVec = new Vec3d(myNewHarvest.getX(), myNewHarvest.getY(), myNewHarvest.getZ());
			UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
		}
	}
	
	private void SetDroneInPosition(boolean newValue){
		if(droneInPosition != newValue){
			droneInPosition = newValue;
			UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
		}
	}
	
	private boolean isBlockValidForHarvest(BlockPos myCheckPos){
		Block myBlock = this.getWorld().getBlockState(myCheckPos).getBlock();
		if(myBlock instanceof CookingPlusCustomTileEntityBlock == false){
			if(myBlock instanceof BlockChest == false){
			if(IgnoreBlockList.contains(myBlock) == false){
				if(myBlock.getDefaultState().getMaterial() != Material.AIR){
					if(myBlock.getDefaultState().getMaterial() != Material.LAVA){
						if(myBlock.getDefaultState().getMaterial() != Material.WATER){
							if(CookingPlusGenericHelper.isValidNetworkAttachment(myBlock, getWorld(), myCheckPos) == false){
								return true;
							}
						}
					}
				}
			}
			}
		}
		return false;
	}

	private void HarvestCurrentBlock(BotTileEntity myBot){
		//System.out.println(currentlaserDroneVec + " Laser Pos");
		//System.out.println(currentharvestDroneVec + " Harvest Pos");
		myBot.DepositBlockPositionIntoChest(new BlockPos(currentharvestDroneVec));
		this.getWorld().setBlockState(new BlockPos(currentharvestDroneVec), Blocks.AIR.getDefaultState());
		SetDroneInPosition(false);
	}

	@SideOnly(Side.CLIENT)
	public Vec3d getDroneOffsetPos(){
		//System.out.println(currentlaserDronePosition + " Laser Pos");
		if(currentlaserDroneVec.xCoord == 0 && currentlaserDroneVec.yCoord == 0 && currentlaserDroneVec.zCoord == 0){
			return currentlaserDroneVec;
		}
		else{
			return currentlaserDroneVec.subtract(new Vec3d(getPos().getX(), getPos().getY(), getPos().getZ()));
		}
		
	}
	
	@SideOnly(Side.CLIENT)
	public float getRotation(){	
		return rotation;
	}
	
	@SideOnly(Side.CLIENT)
	public boolean getInPosition(){	
		return droneInPosition;
	}
	
	protected void MoveDrone(){
		//System.out.println(currentlaserDroneVec + " Laser Pos");
		//System.out.println(currentharvestDroneVec + " Harvest Pos");
		if(currentlaserDroneVec.xCoord != currentharvestDroneVec.xCoord || currentlaserDroneVec.yCoord != currentharvestDroneVec.yCoord + 1 || currentlaserDroneVec.zCoord != currentharvestDroneVec.zCoord){
			oldlaserDroneVec = new Vec3d(currentlaserDroneVec.xCoord, currentlaserDroneVec.yCoord, currentlaserDroneVec.zCoord);
			//First we get our positions
			float ldpx = (float) currentlaserDroneVec.xCoord;
			float ldpy = (float) currentlaserDroneVec.yCoord;
			float ldpz = (float) currentlaserDroneVec.zCoord;
			
			float hdx = (float) currentharvestDroneVec.xCoord;
			float hdy = (float) (currentharvestDroneVec.yCoord + 1);
			float hdz = (float) currentharvestDroneVec.zCoord;
			
			int XDirection = 0;
			int YDirection = 0;
			int ZDirection = 0;
			//now lets figure out with direction we need to travel in
			if(ldpx < hdx){
				XDirection = 1;
			}
			else if(ldpx > hdx){
				XDirection = -1;
			}
			
			if(ldpy < hdy){
				YDirection = 1;
			}
			else if(ldpy > hdy){
				YDirection = -1;
			}
			
			if(ldpz < hdz){
				ZDirection = 1;
			}
			else if(ldpz > hdz){
				ZDirection = -1;
			}
			//Okay now lets try to move our drone
			//first the X
			if(XDirection > 0){
				if(ldpx + speed > hdx){
					ldpx = hdx;
					//System.out.println("Move Positive X");
				}
				else{
					ldpx = ldpx + speed;
					//System.out.println("Move Positive X");
				}
			}
			if(XDirection < 0){
				if(ldpx - speed < hdx){
					ldpx = hdx;
					//System.out.println("Move Negative X");
				}
				else{
					ldpx = ldpx - speed;
					//System.out.println("Move Negative X");
				}
			}
			//now the Y
			if(YDirection > 0){
				if(ldpy + speed > hdy){
					ldpy = hdy;
					//System.out.println("Move Positive Y");
				}
				else{
					ldpy = ldpy + speed;
					//System.out.println("Move Positive Y");
				}
			}
			if(YDirection < 0){
				if(ldpy - speed < hdy){
					ldpy = hdy;
					//System.out.println("Move Negative Y");
				}
				else{
					ldpy = ldpy - speed;
					//System.out.println("Move Negative Y");
				}
			}
			//finally the Z
			if(ZDirection > 0){
				if(ldpz + speed > hdz){
					ldpz = hdz;
					//System.out.println("Move Positive Z");
				}
				else{
					ldpz = ldpz + speed;
					//System.out.println("Move Positive Z");
				}
			}
			if(ZDirection < 0){
				if(ldpz - speed < hdz){
					ldpz = hdz;
					//System.out.println("Move Negative Z");
				}
				else{
					ldpz = ldpz - speed;
					//System.out.println("Move Negative Z");
				}
			}
			//now lets see if they are the same?
			//System.out.println(speed + " Speed");
			//System.out.println(ldpx + " " + ldpy + " " + ldpz + " New Position");
			
			currentlaserDroneVec = new Vec3d(ldpx,ldpy,ldpz);
			if(ldpx == hdx && ldpy == hdy && ldpz == hdz){
				UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
			}

			
		}
		else{
			
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
    public net.minecraft.util.math.AxisAlignedBB getRenderBoundingBox()
    {
		net.minecraft.util.math.AxisAlignedBB MY_AABB = new net.minecraft.util.math.AxisAlignedBB(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
		return MY_AABB;
    }
}
