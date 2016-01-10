package CookingPlus.tiles;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.CookingPlusMain;

public class FisherTileEntity extends TileEntity implements IUpdatePlayerListBox {

	float Rotation;
	
	public FisherTileEntity() {
		Random myRand = new Random();
		Rotation = myRand.nextInt(360);
	}
	

	public void processActivate(EntityPlayer Player) {
		
	}
	

	@Override
    public void update(){
		Rotation += 0.03f;
		
		if(!CookingPlusMain.blockFisher.canPlaceBlockAt(this.getWorld(), this.getPos())){
			CookingPlusMain.blockFisher.dropBlockAsItem(this.getWorld(), this.getPos(), this.getWorld().getBlockState(this.getPos()), 0);
			this.getWorld().setBlockState(this.getPos(), Blocks.air.getDefaultState());
		}
		
	}
	
	public float getMovement(){
		return Rotation;
	}

	

}
