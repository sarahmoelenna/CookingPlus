package CookingPlus.Dungeons;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class CookingPlusStructureBase {

	public final ArrayList<CookingPlusStructureComponent> componentList = new ArrayList();
	
	int X;
	int Z;
	World myWorld;
	Random myRand;
	
	public CookingPlusStructureBase(int chunkX, int chunkZ, World worldIn, Random randIn){
		X = chunkX * 16;
		Z = chunkZ * 16;
		myWorld = worldIn;
		myRand = randIn;
	}
	
	public void beginGeneration(){
		
	}
	
	protected void generateComponents(){
		for(int i = 0; i < componentList.size(); i++){
			componentList.get(i).generateComponent(myWorld, myRand);
		}
	}
	
	protected void decorateComponents(){
		for(int i = 0; i < componentList.size(); i++){
			componentList.get(i).decorateComponent(myWorld, myRand);
		}
	}
	
	public static boolean checkCollision(CookingPlusStructureBoundingBox a, CookingPlusStructureBoundingBox b){
	{
		
		float ax = a.getX() + a.getSizeX()/2;
		float ay = a.getY() + a.getSizeY()/2;
		float az = a.getZ() + a.getSizeZ()/2;
		
		float asizex = a.getSizeX()/2;
		float asizey = a.getSizeY()/2;
		float asizez = a.getSizeZ()/2;
		
		float bx = b.getX() + b.getSizeX()/2;
		float by = b.getY() + b.getSizeY()/2;
		float bz = b.getZ() + b.getSizeZ()/2;
		
		float bsizex = b.getSizeX()/2;
		float bsizey = b.getSizeY()/2;
		float bsizez = b.getSizeZ()/2;
		//check the X axis
		if(Math.abs(ax - bx) < asizex + bsizex){
			//check the Y axis
			if(Math.abs(ay - by) < asizey + bsizey){
				//check the Z axis
				if(Math.abs(az - bz) < asizez + bsizez){
		        	return true;
		    	}
		 	}
		}
		 	return false;
		} 
	}
	
	public static boolean isPointWithinCircle(float xCenter, float zCenter, float xPoint, float zPoint, float radius){
		
		float xLength = xCenter-xPoint;
		float zLength = zCenter-zPoint;
		
		float length = (float) Math.sqrt(xLength * xLength + zLength * zLength);
		//System.out.println(xLength + " " + zLength + " " + length);
		return (length <= radius);
	}
	
	public static boolean doesBoundingBlockCollideWithList(ArrayList<CookingPlusStructureComponent> componentListIn, CookingPlusStructureBoundingBox boundingBoxIn){
		for(int i = 0; i < componentListIn.size(); i++){
			if(checkCollision(componentListIn.get(i).getBoundingBox(), boundingBoxIn)){
				return true;
			}
		}
		return false;
	}
	
	public void updateComponentList(ArrayList<CookingPlusStructureComponent> myList){
		componentList.clear();
		componentList.addAll(myList);
	}
}
