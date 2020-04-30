package CookingPlus.Interfaces;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;

public interface ILeyLineProducer {
	
	public int blocksUntilConnection(EnumFacing myFacing);
	
	public int getOutputFromSide(EnumFacing myFacing);
	
	public void setInputToSide(EnumFacing myFacing, int amount);
	
	public void processPlayerActivate(EnumFacing myFacing, EntityPlayer myPlayer);
	
	public int stateOfSide(EnumFacing myFacing);
	
	public int getSideBlockCount(EnumFacing myFacing);
	
	public float getLeyRotation();
	
	public boolean isBeamVisible(EnumFacing myFacing);

	public int getBeamPowerLevel();
}
