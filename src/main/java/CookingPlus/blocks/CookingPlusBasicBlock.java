package CookingPlus.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CookingPlusBasicBlock extends CookingPlusCustomBlock{

	String name;
	
	public CookingPlusBasicBlock(Material myMat, CreativeTabs myTab, String myName, float myHardness, float myResistance, SoundType mySound) {
		super(myMat);
		
		name = myName;
		this.setHardness(myHardness);
		this.setCreativeTab(myTab);
		this.setResistance(myResistance);
		this.setSoundType(mySound);
		this.setUnlocalizedName(myName);
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public String getName()
	{
		return name;
	}

	
	
}
