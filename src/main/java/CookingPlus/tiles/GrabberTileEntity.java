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

public class GrabberTileEntity extends TileEntity implements IUpdatePlayerListBox {

	float rotation;
	float timing;
	boolean direction;
	Random myRand;
	float speed;
	
	public GrabberTileEntity() {
		myRand = new Random();
		rotation = myRand.nextFloat() * 360;
		timing = 0;
		direction = false;
		speed = 0;
	}
	

	public void processActivate(EntityPlayer Player) {
		
	}
	

	@Override
    public void update(){
		if(timing <= 0){
			timing = myRand.nextFloat() * 1000;
			speed = myRand.nextFloat()/10;
			if(myRand.nextFloat() > 0.5f){
				direction = true;
			}
			else{
				direction = false;
			}
		}
		else{
			if(direction == true){
				rotation += speed;
			}
			else{
				rotation -= speed;
			}
			timing--;
		}
		
	}
	
	public float getMovement(){
		return rotation;
	}

	

}
