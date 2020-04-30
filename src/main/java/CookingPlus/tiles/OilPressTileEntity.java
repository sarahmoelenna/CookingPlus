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
import CookingPlus.items.CookingPlusCustomEdibleRopeCropSeed;
import CookingPlus.items.CookingPlusCustomEdibleSeed;

public class OilPressTileEntity extends CookingPlusCustomTileEntity implements ITickable {

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
				Player.addChatMessage(new TextComponentTranslation("msg.pressempty.txt"));
			}
			else if(MoveState == 1){
				Player.addChatMessage(new TextComponentTranslation("msg.pressprocess.txt"));
			}
			else{
				Player.addChatMessage(new TextComponentTranslation("msg.pressdone.txt"));
			}
		}
		else{
			if(MoveState == 2){
				if(Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND) != null){
					if(Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).isItemEqual(new ItemStack(Items.GLASS_BOTTLE))){
						Player.dropItem(new ItemStack(CookingPlusMain.vegetableoil), false);
						
						if(Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).stackSize > 1){
							ItemStack TempStack = Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).copy();
							TempStack.stackSize--;
							Player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, TempStack);
						}
						else{
							Player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, null);
						}
						MoveState = 0;
						
					}
					else{
						Player.addChatMessage(new TextComponentTranslation("msg.pressdone.txt"));
					}
				}
				else{
					Player.addChatMessage(new TextComponentTranslation("msg.pressdone.txt"));
				}
				
			}
			else if(MoveState == 1){
				
			}
			else if(MoveState == 0){
				if(Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND) != null){
					if(isSeed(Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND))){
						if(Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).stackSize > 1){
							ItemStack TempStack = Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).copy();
							TempStack.stackSize--;
							Player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, TempStack);
						}
						else{
							Player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, null);
						}
						ButterState = 1;
						MoveState = 1;
					}
					else{
						Player.addChatMessage(new TextComponentTranslation("msg.pressempty.txt"));
					}
				}
				else{
					Player.addChatMessage(new TextComponentTranslation("msg.pressempty.txt"));
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
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
	

		nbt.setInteger("MyMoveState", MoveState);
		nbt.setFloat("MyMovement", MovementTimer);
		nbt.setInteger("MyButterState", ButterState);

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
	
	public boolean isSeed(ItemStack MyStack){
		if(MyStack.getItem().equals(Items.WHEAT_SEEDS)){
			return true;
		}
		else if(MyStack.getItem().equals(Items.MELON_SEEDS)){
			return true;
		}
		else if(MyStack.getItem().equals(Items.PUMPKIN_SEEDS)){
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
