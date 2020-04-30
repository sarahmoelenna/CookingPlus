package CookingPlus.blocks;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.generation.CookingPlusNetherGen;

public class CookingPlusTangleHeart extends CookingPlusCustomBlock{

	private final String name = "tangleheart";
	
	public CookingPlusTangleHeart() {
		super(Material.GLASS);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName("tangleheart");
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		this.setHarvestLevel("pickaxe", 0);
		this.setSoundType(SoundType.STONE);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune) {
	    return CookingPlusMain.tangleheartshard;
	}


	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
	    return 1;
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		if(playerIn.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).getItem() == Items.DYE){
			if(playerIn.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).getItem().getDamage(playerIn.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND)) == 15){
				Random myRand = new Random();
				if(myRand.nextFloat() > 0.9f){
					CookingPlusNetherGen.SurroundWithBlock(worldIn, pos, CookingPlusMain.blockTangleLeaves);
					CookingPlusNetherGen.SpreadTangle(worldIn, pos, myRand, 1);
					CookingPlusNetherGen.SpreadTangle(worldIn, pos, myRand, 1);
					CookingPlusNetherGen.SpreadTangle(worldIn, pos, myRand, 1);
				}
				playerIn.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).stackSize--;
				if(playerIn.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).stackSize <= 0){
					playerIn.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, null);
				}
			}
		}
		
		return false;
    }
	

}
