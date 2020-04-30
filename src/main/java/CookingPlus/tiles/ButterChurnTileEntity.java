package CookingPlus.tiles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.CookingPlusMain;

public class ButterChurnTileEntity extends CookingPlusCustomTileEntity implements ITickable {

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
					Player.addChatMessage(new TextComponentTranslation("msg.butterready.txt"));
				}
				if(inputstate == 1){
					Player.addChatMessage(new TextComponentTranslation("msg.creamready.txt"));
				}
			}
			else if(ButterState != 0 && ButterState != 10){
				Player.addChatMessage(new TextComponentTranslation("msg.butternotready.txt"));
			}
			else{
				Player.addChatMessage(new TextComponentTranslation("msg.butterdone.txt"));
			}
		}
		else{
			if(ButterState == 10){
				//Player.addChatMessage(new TextComponentTranslation("msg.butterdone.txt"));
				if(inputstate == 2){
					Player.dropItem(new ItemStack(CookingPlusMain.blockButter), false);
					ButterState = 0;
					inputstate = 0;
				}
				if(inputstate == 1){
					if(Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).isItemEqual(new ItemStack(Items.BUCKET))){
						if(Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).stackSize > 1){
							ItemStack mystack = new ItemStack(Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).getItem(), Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).stackSize - 1);
							Player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, mystack);
						}
						else{
							Player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, null);
						}
						if(Player.inventory.addItemStackToInventory(new ItemStack(CookingPlusMain.creambucket)) == false){
							Player.dropItem(new ItemStack(CookingPlusMain.creambucket), false);
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
				if(Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND) != null){
					if(Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).isItemEqual(new ItemStack(Items.MILK_BUCKET))){
						Player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BUCKET));
						ButterState = 1;
						MoveState = 1;
						inputstate = 1;
					}
					if(Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).isItemEqual(new ItemStack(CookingPlusMain.creambucket))){
						Player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BUCKET));
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
			UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
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
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {

		nbt.setInteger("MyMoveState", MoveState);
		nbt.setFloat("MyMovement", MovementTimer);
		nbt.setInteger("MyButterState", ButterState);
		nbt.setInteger("IS", inputstate);

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
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
		readFromNBT(packet.getNbtCompound());
	}
}
