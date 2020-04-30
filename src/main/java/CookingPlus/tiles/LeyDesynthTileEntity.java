package CookingPlus.tiles;

import java.util.Random;

import CookingPlus.CookingPlusConfig;
import CookingPlus.CookingPlusMain;
import CookingPlus.Interfaces.ILeyLineProducer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;

public class LeyDesynthTileEntity extends CookingPlusCustomTileEntity implements ITickable {

	public int generatedInput;
	public float rotation;
	private float bobbing;
	private boolean bobstate;
	public int crystalType;
	public int crystalDecay;
	//0 - none
	//1 - air
	//2 - earth
	//3 - fire
	//4 - water
	
	public LeyDesynthTileEntity(){
		Random myRand = new Random();
		generatedInput = 0;
		rotation = myRand.nextInt(360);
		bobbing = myRand.nextInt(200)/200.0f;
		bobstate = false;
		crystalType = 0;
		crystalDecay = 0;
	}
	
	@Override
	public void update() {
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
		
		if(CookingPlusConfig.disableCrystalDecay == false){
			DecayCrystal();
		}
		GeneratePower();
		SpreadPower();
		generatedInput = 0;
	}
	
	public void DecayCrystal(){
		if(crystalType > 0){
			crystalDecay++;
			if(crystalDecay > 24000*3){
				Random myRand = new Random();
				if(myRand.nextInt(200) == 0){
					if(crystalType == 1){
						CookingPlusMain.blockAirCrystalCluster.dropBlockAsItem(getWorld(), getPos().up(), CookingPlusMain.blockAirCrystalCluster.getDefaultState(), 0);
					} else if(crystalType == 2){
						CookingPlusMain.blockEarthCrystalCluster.dropBlockAsItem(getWorld(), getPos().up(), CookingPlusMain.blockEarthCrystalCluster.getDefaultState(), 0);
					} else if(crystalType == 3){
						CookingPlusMain.blockFireCrystalCluster.dropBlockAsItem(getWorld(), getPos().up(), CookingPlusMain.blockFireCrystalCluster.getDefaultState(), 0);
					} else if(crystalType == 4){
						CookingPlusMain.blockWaterCrystalCluster.dropBlockAsItem(getWorld(), getPos().up(), CookingPlusMain.blockWaterCrystalCluster.getDefaultState(), 0);
					}
					updateCrystalType(0);
					crystalDecay = 0;
				}
			}
		}
		else{
			crystalDecay = 0;
		}
	}
	
	public void GeneratePower(){
		if(crystalType != 0){
			if(crystalType == 1){
				airEnergyGeneration();
			}else if(crystalType == 2){
				earthEnergyGeneration();
			}else if(crystalType == 3){
				fireEnergyGeneration();
			}else if(crystalType == 4){
				waterEnergyGeneration();
			}
		}
	}
	
	public void airEnergyGeneration(){
		if(this.getPos().getY() > 62){
			if(this.getWorld().getBlockState(getPos().up().up()).getMaterial() == Material.AIR){
				if(this.getWorld().getBlockState(getPos().east().up()).getMaterial() == Material.AIR){
					if(this.getWorld().getBlockState(getPos().west().up()).getMaterial() == Material.AIR){
						if(this.getWorld().getBlockState(getPos().north().up()).getMaterial() == Material.AIR){
							if(this.getWorld().getBlockState(getPos().south().up()).getMaterial() == Material.AIR){
								int energyFromAir = (int) ((this.getPos().getY() - 62f)/5f);
								generatedInput += energyFromAir;
							}
						}
					}
				}
			}
		}
	}
	
	public void earthEnergyGeneration(){
		if(this.getWorld().isDaytime() == true && getWorld().isRaining() == false && getWorld().isThundering() == false){
			BlockPos myTopBlockPos = this.getWorld().getTopSolidOrLiquidBlock(getPos());
			if(myTopBlockPos.getY() == this.getPos().up().up().getY()){
				generatedInput+=20;
			}
		}
	}

	public void fireEnergyGeneration(){
		if(this.getWorld().getBlockState(getPos().east().up()).getBlock() == Blocks.FIRE){
			generatedInput+=7;
		}
		if(this.getWorld().getBlockState(getPos().west().up()).getBlock() == Blocks.FIRE){
			generatedInput+=7;
		}
		if(this.getWorld().getBlockState(getPos().north().up()).getBlock() == Blocks.FIRE){
			generatedInput+=7;
		}
		if(this.getWorld().getBlockState(getPos().south().up()).getBlock() == Blocks.FIRE){
			generatedInput+=7;
		}
	}

	public void waterEnergyGeneration(){
		if((this.getWorld().isRaining() || this.getWorld().isThundering()) && this.getWorld().getBiomeForCoordsBody(getPos()).isSnowyBiome() == false){
			BlockPos myTopBlockPos = this.getWorld().getTopSolidOrLiquidBlock(getPos());
			if(myTopBlockPos.getY() == this.getPos().up().up().getY()){
				if(this.getWorld().isThundering()){
					generatedInput+=40;
				}
				else{
					generatedInput+=20;
				}
			}
		}
	}
	
	public void SpreadPower(){
		ILeyLineProducer myEntity;
		if(this.getWorld().getBlockState(getPos().east()).getBlock() == CookingPlusMain.blockLeyGenerator && generatedInput > 0){
			myEntity = (ILeyLineProducer) this.getWorld().getTileEntity(getPos().east());
			myEntity.setInputToSide(EnumFacing.WEST, generatedInput);
			generatedInput = 0;
		}
		if(this.getWorld().getBlockState(getPos().west()).getBlock() == CookingPlusMain.blockLeyGenerator && generatedInput > 0){
			myEntity = (ILeyLineProducer) this.getWorld().getTileEntity(getPos().west());
			myEntity.setInputToSide(EnumFacing.EAST, generatedInput);
			generatedInput = 0;
		}
		if(this.getWorld().getBlockState(getPos().north()).getBlock() == CookingPlusMain.blockLeyGenerator && generatedInput > 0){
			myEntity = (ILeyLineProducer) this.getWorld().getTileEntity(getPos().north());
			myEntity.setInputToSide(EnumFacing.SOUTH, generatedInput);
			generatedInput = 0;
		}
		if(this.getWorld().getBlockState(getPos().south()).getBlock() == CookingPlusMain.blockLeyGenerator && generatedInput > 0){
			myEntity = (ILeyLineProducer) this.getWorld().getTileEntity(getPos().south());
			myEntity.setInputToSide(EnumFacing.NORTH, generatedInput);
			generatedInput = 0;
		}
		if(this.getWorld().getBlockState(getPos().down()).getBlock() == CookingPlusMain.blockLeyGenerator && generatedInput > 0){
			myEntity = (ILeyLineProducer) this.getWorld().getTileEntity(getPos().down());
			myEntity.setInputToSide(EnumFacing.UP, generatedInput);
			generatedInput = 0;
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);

		crystalType = nbt.getInteger("IS");
		crystalDecay = nbt.getInteger("CD");

	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {

		nbt.setInteger("IS", crystalType);
		nbt.setInteger("CD", crystalDecay);

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
	
	public int getCrystalType(){
		return crystalType;
	}

	public float getRotation(){
		return rotation;
	}
	
	public float getBobbing(){
		return bobbing;
	}
	
	public void updateCrystalType(int value){
		if(this.getWorld().isRemote == false){
			if(crystalType != value){
				crystalType = value;
				UpdateBlock(this.worldObj.getBlockState(this.getPos()), this.getPos(), this.worldObj);
			}
		}
	}
	
	public void processActivate(EntityPlayer Player) {
		if(Player.isSneaking() == false){
			if(crystalType == 0){
				Item myItem = Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).getItem();
				if(myItem == CookingPlusMain.pristineaircrystal){
					updateCrystalType(1);
					if(Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).stackSize > 1){
						Player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(myItem, Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).stackSize - 1));
					}
					else{
						Player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, null);
					}
				} else if(myItem == CookingPlusMain.pristineearthcrystal){
					updateCrystalType(2);
					if(Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).stackSize > 1){
						Player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(myItem, Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).stackSize - 1));
					}
					else{
						Player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, null);
					}
				}else if(myItem == CookingPlusMain.pristinefirecrystal){
					updateCrystalType(3);
					if(Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).stackSize > 1){
						Player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(myItem, Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).stackSize - 1));
					}
					else{
						Player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, null);
					}
				}else if(myItem == CookingPlusMain.pristinewatercrystal){
					updateCrystalType(4);
					if(Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).stackSize > 1){
						Player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(myItem, Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).stackSize - 1));
					}
					else{
						Player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, null);
					}
				}
			}
		}
		else{
			if(Player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND) == null){
				if(crystalType == 1){
					Player.dropItem(new ItemStack(CookingPlusMain.pristineaircrystal), false);
					updateCrystalType(0);
				}else if(crystalType == 2){
					Player.dropItem(new ItemStack(CookingPlusMain.pristineearthcrystal), false);
					updateCrystalType(0);
				}else if(crystalType == 3){
					Player.dropItem(new ItemStack(CookingPlusMain.pristinefirecrystal), false);
					updateCrystalType(0);
				}else if(crystalType == 4){
					Player.dropItem(new ItemStack(CookingPlusMain.pristinewatercrystal), false);
					updateCrystalType(0);
				}
			}
		}
	}

	public Item getCurrentCrystal(){
		if(crystalType == 1){
			return CookingPlusMain.pristineaircrystal;
		}else if(crystalType == 2){
			return CookingPlusMain.pristineearthcrystal;
		}else if(crystalType == 3){
			return CookingPlusMain.pristinefirecrystal;
		}else if(crystalType == 4){
			return CookingPlusMain.pristinewatercrystal;
		}
		else return null;
	}
	
}
