package CookingPlus.Dungeons;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class CookingPlusAbandonedLabStructure extends CookingPlusStructureBase {

	public CookingPlusAbandonedLabStructure(int chunkX, int chunkZ,World worldIn, Random randIn) {
		super(chunkX, chunkZ, worldIn, randIn);
	}
	
	@Override
	public void beginGeneration(){
		
		int myX = myRand.nextInt(16) + X;
		int myZ = myRand.nextInt(16) + Z;
		int myY = 0;
		int floodLevel = myRand.nextInt(30);
		myY = myWorld.getTopSolidOrLiquidBlock(new BlockPos(new Vec3d(myX, 0, myZ))).getY();
		int myBottomY = 0;
		
		if(myY > 70){
			myBottomY = myY - 60;
		}
		else{
			myBottomY = 10;
		}
		CookingPlusStructureBoundingBox myTempBoundingBox = new CookingPlusStructureBoundingBox(new BlockPos(new Vec3d(myX - 10, myBottomY, myZ - 10)), new BlockPos(new Vec3d(myX + 10, myY, myZ + 10)));
		CookingPlusAbandonedLabEntrance myEntrance = new CookingPlusAbandonedLabEntrance();
		myEntrance.setBoundingBox(myTempBoundingBox);
		myEntrance.setFloodLevel(floodLevel);
		componentList.add(myEntrance);
		
		for(int i = 0; i < componentList.size(); i++){
			componentList.get(i).setComponentList(componentList);
			componentList.get(i).generateAttachedComponents(myRand);
			updateComponentList(componentList.get(i).getUpdatedComponentList());
		}
		
		
		generateComponents();
		decorateComponents();
		
	}

}
