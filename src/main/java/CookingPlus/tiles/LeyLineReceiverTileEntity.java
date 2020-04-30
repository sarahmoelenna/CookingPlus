package CookingPlus.tiles;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import CookingPlus.CookingPlusConfig;
import CookingPlus.CookingPlusGenericHelper;
import CookingPlus.CookingPlusMain;
import CookingPlus.Interfaces.ILeyPoweredEntity;

public class LeyLineReceiverTileEntity extends CookingPlusCustomTileEntity implements ILeyPoweredEntity, ITickable {

	protected int leyEnergyThisTick;
	public int rotation;
	
	public boolean north;
	public boolean south;
	public boolean up;
	public boolean down;
	public boolean east;
	public boolean west;
	
	public LeyLineReceiverTileEntity(){
		leyEnergyThisTick = 0;
		
		north = false;
		south = false;
		up = false;
		down = false;
		east = false;
		west = false;
		rotation = 0;
	}
	
	@Override
	public boolean hasLeyStorage() {
		return false;
	}

	@Override
	public boolean canRequestLeyAmount(int amount) {
		return false;
	}

	@Override
	public void drainLeyEnergy(int amount) {
		
	}

	@Override
	public int getmaxStorageAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCurrentStorageAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update() {
		rotation++;
		//North
		if(getWorld().getBlockState(getPos().north()).getBlock() == CookingPlusMain.blockNetworkBlock ||
				getWorld().getBlockState(getPos().north()).getBlock() == CookingPlusMain.blockBattery){
			north = true;
		}
		else{
			north = false;
		}
		//South
		if(getWorld().getBlockState(getPos().south()).getBlock() == CookingPlusMain.blockNetworkBlock ||
				getWorld().getBlockState(getPos().south()).getBlock() == CookingPlusMain.blockBattery){
			south = true;
		}
		else{
			south = false;
		}
		//east
		if(getWorld().getBlockState(getPos().east()).getBlock() == CookingPlusMain.blockNetworkBlock ||
				getWorld().getBlockState(getPos().east()).getBlock() == CookingPlusMain.blockBattery){
			east = true;
		}
		else{
			east = false;
		}
		//west
		if(getWorld().getBlockState(getPos().west()).getBlock() == CookingPlusMain.blockNetworkBlock ||
				getWorld().getBlockState(getPos().west()).getBlock() == CookingPlusMain.blockBattery){
			west = true;
		}
		else{
			west = false;
		}
		//up
		if(getWorld().getBlockState(getPos().up()).getBlock() == CookingPlusMain.blockNetworkBlock ||
				getWorld().getBlockState(getPos().up()).getBlock() == CookingPlusMain.blockBattery){
			up = true;
		}
		else{
			up = false;
		}
		//down
		if(getWorld().getBlockState(getPos().down()).getBlock() == CookingPlusMain.blockNetworkBlock ||
				getWorld().getBlockState(getPos().down()).getBlock() == CookingPlusMain.blockBattery){
			down = true;
		}
		else{
			down = false;
		}
		
		if(this.getWorld().isRemote == false){
			beganEnergyTransfer();
		}
		
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
    {
		if(oldState.getBlock().equals(CookingPlusMain.blockLeyReceiver) == true){
			if(newSate.getBlock().equals(CookingPlusMain.blockLeyReceiver) == false){
				world.removeTileEntity(pos);
				//return true;
			}
		}
        return false;
    }

	public void beganEnergyTransfer(){
		
		ArrayList<BlockPos> myPowerList = getPowerPosList();
		
		for(int i = 0; i < myPowerList.size() && leyEnergyThisTick > 0; i++){
			 ILeyPoweredEntity myEntity = (ILeyPoweredEntity) this.getWorld().getTileEntity(myPowerList.get(i));
			 if(myEntity.hasLeyStorage()){
				 leyEnergyThisTick = myEntity.transfertEnergyToStorage(leyEnergyThisTick);
			 }
		}
		leyEnergyThisTick = 0;
		
	}
	
	public ArrayList<BlockPos> getPowerPosList(){
		 ArrayList<BlockPos> PosList = new ArrayList<BlockPos>();
		 Block NorthBlock  = this.getWorld().getBlockState(this.getPos().north()).getBlock();
		 Block SouthBlock = this.getWorld().getBlockState(this.getPos().south()).getBlock();
		 Block EastBlock = this.getWorld().getBlockState(this.getPos().east()).getBlock();
		 Block WestBlock  = this.getWorld().getBlockState(this.getPos().west()).getBlock();
		 Block UpBlock  = this.getWorld().getBlockState(this.getPos().up()).getBlock();
		 Block DownBlock  = this.getWorld().getBlockState(this.getPos().down()).getBlock();
		 
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(SouthBlock, getWorld(), getPos().south())){
					PosList.add(this.getPos().south());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(NorthBlock, getWorld(), getPos().north())){
					PosList.add(this.getPos().north());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(WestBlock, getWorld(), getPos().west())){
					PosList.add(this.getPos().west());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(UpBlock, getWorld(), getPos().up())){
					PosList.add(this.getPos().up());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(DownBlock, getWorld(), getPos().down())){
					PosList.add(this.getPos().down());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(EastBlock, getWorld(), getPos().east())){
					PosList.add(this.getPos().east());
				}
		 
		 if(CookingPlusConfig.EnableBotNetwork == true){
			 return GetNetworkedpowerPosList(PosList);
		 }
		 else{
			 return PosList;
		 }
	 }
	 
	public ArrayList<BlockPos> GetNetworkedpowerPosList(ArrayList<BlockPos> ExistingChestList){
		 ArrayList<BlockPos> NetworkList = new ArrayList<BlockPos>();
		 ArrayList<BlockPos> ChestList = new ArrayList<BlockPos>();
		 Block NetworkBlock = CookingPlusMain.blockNetworkBlock;
		 
		 Block NorthBlock  = this.getWorld().getBlockState(this.getPos().north()).getBlock();
		 Block SouthBlock = this.getWorld().getBlockState(this.getPos().south()).getBlock();
		 Block EastBlock = this.getWorld().getBlockState(this.getPos().east()).getBlock();
		 Block WestBlock  = this.getWorld().getBlockState(this.getPos().west()).getBlock();
		 Block UpBlock  = this.getWorld().getBlockState(this.getPos().up()).getBlock();
		 Block DownBlock  = this.getWorld().getBlockState(this.getPos().down()).getBlock();
		
				if(this.getWorld().getBlockState(this.getPos().north()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().north());
				}
				if(this.getWorld().getBlockState(this.getPos().south()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().south());
				}
				if(this.getWorld().getBlockState(this.getPos().west()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().west());
				}
				if(this.getWorld().getBlockState(this.getPos().up()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().up());
				}
				if(this.getWorld().getBlockState(this.getPos().down()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().down());
				}
				if(this.getWorld().getBlockState(this.getPos().east()).getBlock() == NetworkBlock){
					NetworkList.add(this.getPos().east());
				}
		 
		 for(int i = 0; i < NetworkList.size(); i++){
			 BlockPos myCurrentPos = NetworkList.get(i);
			  
			 	if(this.getWorld().getBlockState(myCurrentPos.north()).getBlock() == NetworkBlock && !NetworkList.contains(myCurrentPos.north())){
					NetworkList.add(myCurrentPos.north());
				}
				if(this.getWorld().getBlockState(myCurrentPos.south()).getBlock() == NetworkBlock && !NetworkList.contains(myCurrentPos.south())){
					NetworkList.add(myCurrentPos.south());
				}
				if(this.getWorld().getBlockState(myCurrentPos.west()).getBlock() == NetworkBlock && !NetworkList.contains(myCurrentPos.west())){
					NetworkList.add(myCurrentPos.west());
				}
				if(this.getWorld().getBlockState(myCurrentPos.east()).getBlock() == NetworkBlock && !NetworkList.contains(myCurrentPos.east())){
					NetworkList.add(myCurrentPos.east());
				}
				if(this.getWorld().getBlockState(myCurrentPos.up()).getBlock() == NetworkBlock && !NetworkList.contains(myCurrentPos.up())){
					NetworkList.add(myCurrentPos.up());
				}
				if(this.getWorld().getBlockState(myCurrentPos.down()).getBlock() == NetworkBlock && !NetworkList.contains(myCurrentPos.down())){
					NetworkList.add(myCurrentPos.down());
				}
		 }
		 
		 for(int i = 0; i < NetworkList.size(); i++){
			 BlockPos myCurrentPos = NetworkList.get(i);
			 
			 NorthBlock  = this.getWorld().getBlockState(myCurrentPos.north()).getBlock();
			 SouthBlock = this.getWorld().getBlockState(myCurrentPos.south()).getBlock();
			 EastBlock = this.getWorld().getBlockState(myCurrentPos.east()).getBlock();
			 WestBlock  = this.getWorld().getBlockState(myCurrentPos.west()).getBlock();
			 UpBlock  = this.getWorld().getBlockState(myCurrentPos.up()).getBlock();
			 DownBlock  = this.getWorld().getBlockState(myCurrentPos.down()).getBlock();
			 
			 	if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(NorthBlock, getWorld(), myCurrentPos.north()) && !ExistingChestList.contains(myCurrentPos.north()) && !ChestList.contains(myCurrentPos.north())){
					ChestList.add(myCurrentPos.north());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(SouthBlock, getWorld(), myCurrentPos.south()) && !ExistingChestList.contains(myCurrentPos.south()) && !ChestList.contains(myCurrentPos.south())){
					ChestList.add(myCurrentPos.south());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(WestBlock, getWorld(), myCurrentPos.west()) && !ExistingChestList.contains(myCurrentPos.west()) && !ChestList.contains(myCurrentPos.west())){
					ChestList.add(myCurrentPos.west());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(EastBlock, getWorld(), myCurrentPos.east()) && !ExistingChestList.contains(myCurrentPos.east()) && !ChestList.contains(myCurrentPos.east())){
					ChestList.add(myCurrentPos.east());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(UpBlock, getWorld(), myCurrentPos.up()) && !ExistingChestList.contains(myCurrentPos.up()) && !ChestList.contains(myCurrentPos.up())){
					ChestList.add(myCurrentPos.up());
				}
				if(CookingPlusGenericHelper.isValidNetworkEnergyStorageBlock(DownBlock, getWorld(), myCurrentPos.down()) && !ExistingChestList.contains(myCurrentPos.down()) && !ChestList.contains(myCurrentPos.down())){
					ChestList.add(myCurrentPos.down());
				}
		 }
		 ChestList.addAll(ExistingChestList);
		return ChestList;
	 }

	@Override
	public int transfertEnergyToStorage(int amount) {
		return amount;
	}

	public void inputEnergy(int amount){
		leyEnergyThisTick += amount;
	}
}
