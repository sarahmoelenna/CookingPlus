package CookingPlus.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusButterBlock extends CookingPlusCustomBlock{

	private final String name = "butterblock";
	
	public CookingPlusButterBlock() {
		super(Material.gourd);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName("butterblock");
		//this.setBlockTextureName("cookingplus:butterblock");
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		this.setStepSound(soundTypeSnow);
	}
	
	@Override
	public String getName()
	{
		return name;
	}

}
