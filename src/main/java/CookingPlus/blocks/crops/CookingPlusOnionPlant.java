package CookingPlus.blocks.crops;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import CookingPlus.CookingPlusMain;
import CookingPlus.blocks.CookingPlusCustomCrops;

public class CookingPlusOnionPlant extends CookingPlusCustomCrops {

	private final String name = "onioncrop";
	
	public CookingPlusOnionPlant() {
		// Basic block setup
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName("onioncrop");
		//setBlockTextureName("cookingplus:onion_stage_0"); // rename
	}

	@Override
	protected Item GetSeedItem() {
		return CookingPlusMain.onionseed;
	}

	@Override
	protected Item GetHarvestItem() {
		return CookingPlusMain.onion;
	}
	
	@Override
	public String getName()
	{
		return name;
	}
}