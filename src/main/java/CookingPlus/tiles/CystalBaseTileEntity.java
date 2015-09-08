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

public class CystalBaseTileEntity extends TileEntity implements IUpdatePlayerListBox {

	private float rotation;
	private float bobbing;
	private boolean bobstate;
	
	public CystalBaseTileEntity() {
		Random myRand = new Random();
		rotation = myRand.nextInt(360);
		bobbing = myRand.nextInt(200)/200.0f;
		bobstate = false;
	}
	
	
	public void processActivate(EntityPlayer Player) {
		
	}
	

	@Override
    public void update(){
		rotation += 0.8f;
		if(rotation > 360){
			rotation = 0;
		}
		if(bobstate == false){
			bobbing += 0.05;
		}
		else{
			bobbing -= 0.05;
		}
		if(bobbing > 1){
			bobstate = true;
		}
		if(bobbing < 0){
			bobstate = false;
		}
	}
	
	public int getCrystalType(){
		return 0;
	}

	public float getRotation(){
		return rotation;
	}
	
	public float getBobbing(){
		return bobbing;
	}
	

}
