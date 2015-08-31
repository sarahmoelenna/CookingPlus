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
import CookingPlus.items.CookingPlusCustomEdibleRopeCropSeed;
import CookingPlus.items.CookingPlusCustomEdibleSeed;

public class OilPressTileEntity extends TileEntity implements IUpdatePlayerListBox {

	public int MoveState; //0 - none, 1 - up, 2 - down //4 - ready
	public float MovementTimer;
	public int ButterState; //0 - empty, 10 - done
	
	public OilPressTileEntity() {
		MoveState = 0;
		MovementTimer = 0;
		ButterState = 0;
	}

	public void processActivate(EntityPlayer Player) {
		if(Player.isSneaking()){
			if(MoveState == 0){
				Player.addChatMessage(new ChatComponentTranslation("msg.pressempty.txt"));
			}
			else if(MoveState == 1){
				Player.addChatMessage(new ChatComponentTranslation("msg.pressprocess.txt"));
			}
			else{
				Player.addChatMessage(new ChatComponentTranslation("msg.pressdone.txt"));
			}
		}
		else{
			if(MoveState == 2){
				//Player.addChatMessage(new ChatComponentTranslation("msg.butterdone.txt"));
				if(Player.getCurrentEquippedItem() != null){
					if(Player.getCurrentEquippedItem().isItemEqual(new ItemStack(Items.glass_bottle))){
						Player.dropPlayerItemWithRandomChoice(new ItemStack(CookingPlusMain.vegetableoil), false);
						
						if(Player.getCurrentEquippedItem().stackSize > 1){
							ItemStack TempStack = Player.getCurrentEquippedItem().copy();
							TempStack.stackSize--;
							Player.setCurrentItemOrArmor(0, TempStack);
						}
						else{
							Player.setCurrentItemOrArmor(0, null);
						}
						MoveState = 0;
						
					}
					else{
						Player.addChatMessage(new ChatComponentTranslation("msg.pressdone.txt"));
					}
				}
				else{
					Player.addChatMessage(new ChatComponentTranslation("msg.pressdone.txt"));
				}
				
			}
			else if(MoveState == 1){
				
			}
			else if(MoveState == 0){
				if(Player.getCurrentEquippedItem() != null){
					if(isSeed(Player.getCurrentEquippedItem())){
						if(Player.getCurrentEquippedItem().stackSize > 1){
							ItemStack TempStack = Player.getCurrentEquippedItem().copy();
							TempStack.stackSize--;
							Player.setCurrentItemOrArmor(0, TempStack);
						}
						else{
							Player.setCurrentItemOrArmor(0, null);
						}
						ButterState = 1;
						MoveState = 1;
					}
					else{
						Player.addChatMessage(new ChatComponentTranslation("msg.pressempty.txt"));
					}
				}
				else{
					Player.addChatMessage(new ChatComponentTranslation("msg.pressempty.txt"));
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
			MovementTimer+= 0.1f;
			//System.out.println(MovementTimer);
			if(MovementTimer > 3 * Math.PI){
				MovementTimer = 0;
				MoveState = 2;
			}
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

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);

		nbt.setInteger("MyMoveState", MoveState);
		nbt.setFloat("MyMovement", MovementTimer);
		nbt.setInteger("MyButterState", ButterState);



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
	
	public boolean isSeed(ItemStack MyStack){
		if(MyStack.getItem().equals(Items.wheat_seeds)){
			return true;
		}
		else if(MyStack.getItem().equals(Items.melon_seeds)){
			return true;
		}
		else if(MyStack.getItem().equals(Items.pumpkin_seeds)){
			return true;
		}
		else if(MyStack.getItem() instanceof CookingPlusCustomEdibleSeed){
			return true;
		}
		else if(MyStack.getItem() instanceof CookingPlusCustomEdibleRopeCropSeed){
			return true;
		}
		return false;
	}
}
