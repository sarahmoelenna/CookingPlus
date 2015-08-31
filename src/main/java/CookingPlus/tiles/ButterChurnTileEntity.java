package CookingPlus.tiles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.CookingPlusMain;

public class ButterChurnTileEntity extends TileEntity implements IUpdatePlayerListBox {

	public int MoveState; //0 - none, 1 - up, 2 - down //4 - ready
	public float MovementTimer;
	public int ButterState; //0 - empty, 10 - done
	public int inputstate;
	
	public ButterChurnTileEntity() {
		MoveState = 0;
		MovementTimer = 0;
		ButterState = 0;
		inputstate = 0;
	}

	public void processActivate(EntityPlayer Player) {
		if(ButterState == 6){
			ButterState = 10;
		}
		
		if(Player.isSneaking()){
			if(ButterState == 10){
				if(inputstate == 2){
					Player.addChatMessage(new ChatComponentTranslation("msg.butterready.txt"));
				}
				if(inputstate == 1){
					Player.addChatMessage(new ChatComponentTranslation("msg.creamready.txt"));
				}
			}
			else if(ButterState != 0 && ButterState != 10){
				Player.addChatMessage(new ChatComponentTranslation("msg.butternotready.txt"));
			}
			else{
				Player.addChatMessage(new ChatComponentTranslation("msg.butterdone.txt"));
			}
		}
		else{
			if(ButterState == 10){
				//Player.addChatMessage(new ChatComponentTranslation("msg.butterdone.txt"));
				if(inputstate == 2){
					Player.dropPlayerItemWithRandomChoice(new ItemStack(CookingPlusMain.blockButter), false);
					ButterState = 0;
					inputstate = 0;
				}
				if(inputstate == 1){
					if(Player.getCurrentEquippedItem().isItemEqual(new ItemStack(Items.bucket))){
						if(Player.getCurrentEquippedItem().stackSize > 1){
							ItemStack mystack = new ItemStack(Player.getCurrentEquippedItem().getItem(), Player.getCurrentEquippedItem().stackSize - 1);
							Player.setCurrentItemOrArmor(0, mystack);
						}
						else{
							Player.setCurrentItemOrArmor(0, null);
						}
						if(Player.inventory.addItemStackToInventory(new ItemStack(CookingPlusMain.creambucket)) == false){
							Player.dropPlayerItemWithRandomChoice(new ItemStack(CookingPlusMain.creambucket), false);
						}
						ButterState = 0;
						inputstate = 0;
					}
				}
				
			}
			else if(ButterState != 0 && ButterState != 10 && MoveState == 0){
				ButterState++;
				MoveState = 1;
			}
			else if(ButterState == 0){
				if(Player.getCurrentEquippedItem() != null){
					if(Player.getCurrentEquippedItem().isItemEqual(new ItemStack(Items.milk_bucket))){
						Player.setCurrentItemOrArmor(0, new ItemStack(Items.bucket));
						ButterState = 1;
						MoveState = 1;
						inputstate = 1;
					}
					if(Player.getCurrentEquippedItem().isItemEqual(new ItemStack(CookingPlusMain.creambucket))){
						Player.setCurrentItemOrArmor(0, new ItemStack(Items.bucket));
						ButterState = 1;
						MoveState = 1;
						inputstate = 2;
					}
				}
			}
		}
		
		
	}

	@Override
    public void update(){
		if(MoveState != 0){
			this.worldObj.markBlockForUpdate(this.getPos());
		}
		
		if(MoveState == 1){
			MovementTimer+= 5;
		}
		else if(MoveState == 2){
			MovementTimer-= 5;
		}
		if(MovementTimer > 100){
			MoveState = 2;
		}
		else if(MovementTimer < 0){
			MoveState = 0;
		}
		
	}

	@SideOnly(Side.CLIENT)
	public float getMovement(){
		//System.out.println(Movement);
		return MovementTimer;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);

		MoveState = nbt.getInteger("MyMoveState");
		MovementTimer = nbt.getFloat("MyMovement");
		ButterState = nbt.getInteger("MyButterState");
		inputstate = nbt.getInteger("IS");
		// System.out.println(EntityDirection);

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);

		nbt.setInteger("MyMoveState", MoveState);
		nbt.setFloat("MyMovement", MovementTimer);
		nbt.setInteger("MyButterState", ButterState);
		nbt.setInteger("IS", inputstate);


	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);
		return new S35PacketUpdateTileEntity(this.getPos(), 1, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.getNbtCompound());
	}
}
