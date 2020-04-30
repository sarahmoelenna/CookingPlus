package CookingPlus.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusButterBlock extends CookingPlusCustomBlock{

	private final String name = "butterblock";
	
	public CookingPlusButterBlock() {
		super(Material.GOURD);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName("butterblock");
		//this.setBlockTextureName("cookingplus:butterblock");
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		this.setSoundType(SoundType.SNOW);
	}
	
	@Override
	public String getName()
	{
		return name;
	}

}
