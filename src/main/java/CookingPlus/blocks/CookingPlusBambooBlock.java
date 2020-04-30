package CookingPlus.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusBambooBlock extends CookingPlusCustomBlock{

	private final String name = "bambooblock";
	
	public CookingPlusBambooBlock() {
		super(Material.WOOD);
		GameRegistry.registerBlock(this, name);
		this.setUnlocalizedName("bambooblock");
		//this.setBlockTextureName("cookingplus:butterblock");
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		this.setSoundType(SoundType.WOOD);
		Blocks.FIRE.setFireInfo(this, 5, 20);
	}
	
	@Override
	public String getName()
	{
		return name;
	}

	
	

}
