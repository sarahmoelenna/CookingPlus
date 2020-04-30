package CookingPlus.tiles;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CookingPlusCustomTileEntity extends TileEntity {

public void UpdateBlock(IBlockState state, BlockPos myPos, World myWorld){
	//System.out.println("update tile entity for client");
	if(this.worldObj != null){
		if(this.worldObj.isRemote == false){
			if(myPos != null){
				if(state != null){
					//myWorld.setBlockState(myPos, state);
					myWorld.notifyBlockUpdate(myPos, state, state, 3);
				}
			}
		}
	}
}

@Override
public NBTTagCompound getUpdateTag() {
    // getUpdateTag() is called whenever the chunkdata is sent to the
    // client. In contrast getUpdatePacket() is called when the tile entity
    // itself wants to sync to the client. In many cases you want to send
    // over the same information in getUpdateTag() as in getUpdatePacket().
    return writeToNBT(new NBTTagCompound());
}

}