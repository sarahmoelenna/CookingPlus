package CookingPlus.Dungeons;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface CookingPlusStructureComponent {

	public void setBoundingBox(CookingPlusStructureBoundingBox myBoundingBox);
	
	public CookingPlusStructureBoundingBox getBoundingBox();
	
	public void isBlockPosWithingBoundingBox(BlockPos myCheckPos);
	
	public void doesBoundingBoxCollide(CookingPlusStructureBoundingBox myBoundingBox);
	
	public void generateComponent(World myWorld, Random myRand);
	
	public void generateAttachedComponents(Random myRand);
	
	public void setComponentList(ArrayList<CookingPlusStructureComponent> myComponentList);
	
	public ArrayList<CookingPlusStructureComponent> getUpdatedComponentList();
	
	public void decorateComponent(World myWorld, Random myRand);
}
