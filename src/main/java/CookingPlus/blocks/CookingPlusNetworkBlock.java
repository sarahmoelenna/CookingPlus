package CookingPlus.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusNetworkBlock extends CookingPlusCustomBlock{

	private final String name = "networkblock";
	
	public CookingPlusNetworkBlock() {
		super(Material.iron);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName("networkblock");
		this.setHardness(0.5f);
		this.setResistance(1.0F);
		this.setStepSound(soundTypeMetal);
	}
	
	@Override
	public String getName()
	{
		return name;
	}

}
