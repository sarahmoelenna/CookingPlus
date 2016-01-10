package CookingPlus.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import CookingPlus.CookingPlusMain;
import CookingPlus.generation.CookingPlusNetherGen;

public class CookingPlusTangleHeart extends CookingPlusCustomBlock{

	private final String name = "tangleheart";
	
	public CookingPlusTangleHeart() {
		super(Material.glass);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName("tangleheart");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		this.setHarvestLevel("pickaxe", 0);
		this.setStepSound(soundTypeStone);
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
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		if(playerIn.getCurrentEquippedItem().getItem() == Items.dye){
			if(playerIn.getCurrentEquippedItem().getItem().getDamage(playerIn.getCurrentEquippedItem()) == 15){
				Random myRand = new Random();
				if(myRand.nextFloat() > 0.9f){
					CookingPlusNetherGen.SurroundWithBlock(worldIn, pos, CookingPlusMain.blockTangleLeaves);
					CookingPlusNetherGen.SpreadTangle(worldIn, pos, myRand, 1);
					CookingPlusNetherGen.SpreadTangle(worldIn, pos, myRand, 1);
					CookingPlusNetherGen.SpreadTangle(worldIn, pos, myRand, 1);
				}
				playerIn.getCurrentEquippedItem().stackSize--;
				if(playerIn.getCurrentEquippedItem().stackSize <= 0){
					playerIn.setCurrentItemOrArmor(0, null);
				}
			}
		}
		
		return false;
    }
	

}
