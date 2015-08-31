package CookingPlus.prebuiltstructures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class CookingPlusPreBuiltStructure {

	int width;
	int height;
	int length;
	int[][][] MyStructureArray;
	
	public CookingPlusPreBuiltStructure(int w, int h, int l){
		width = w;
		height = h;
		length = l;
		
		MyStructureArray = new int[w][h][l];
		
	}
	
	public void Generate(World worldIn, int x, int y, int z, boolean offsetToBaseCenter, int rotation, Random randIn){
		
		int offsetX = 0;
		int offsetY = 0;
		int offsetZ = 0;
		
		int myRotation = rotation;
		if(myRotation == 0 || myRotation > 4){
			myRotation = randIn.nextInt(4) + 1;
		}
		
		if(offsetToBaseCenter == true){
			offsetX = width/2;
			offsetZ = length/2;
		}
		
		if(myRotation == 1){ //east facing
			for(int i = 0; i < width; i++){
				for(int j = 0; j < height; j++){
					for(int k = 0; k < length; k++){
						if(MyStructureArray[i][j][k] > 0){
							setBlock(worldIn, randIn, new BlockPos(new Vec3(x + i - offsetX, y + j - offsetY, z + k - offsetZ)), i,j,k, myRotation);
						}
					}
				}
			}
		}
		else if(myRotation == 2){
			for(int i = 0; i < width; i++){
				for(int j = 0; j < height; j++){
					for(int k = 0; k < length; k++){
						if(MyStructureArray[i][j][k] > 0){
							setBlock(worldIn, randIn, new BlockPos(new Vec3(x + k - offsetX, y + j - offsetY, z + i - offsetZ)), i,j,k, myRotation);
						}
					}
				}
			}
		}
		else if(myRotation == 3){
			for(int i = 0; i < width; i++){
				for(int j = 0; j < height; j++){
					for(int k = 0; k < length; k++){
						if(MyStructureArray[width - i - 1][j][k] > 0){
							setBlock(worldIn, randIn, new BlockPos(new Vec3(x + k - offsetX, y + j - offsetY, z + i - offsetZ)),width - i - 1,j,k, myRotation);
						}
					}
				}
			}
		}
		else if(myRotation == 4){
			for(int i = 0; i < width; i++){
				for(int j = 0; j < height; j++){
					for(int k = 0; k < length; k++){
						if(MyStructureArray[width - i - 1][j][k] > 0){
							setBlock(worldIn, randIn, new BlockPos(new Vec3(x + i - offsetX, y + j - offsetY, z + k - offsetZ)), width - i - 1,j,k, myRotation);
						}
					}
				}
			}
		}
		
	}
	
public void Generate(World worldIn, int x, int y, int z, int myoffsetX, int myoffsetZ, int rotation, Random randIn){
		
		int offsetX = myoffsetX;
		int offsetY = 0;
		int offsetZ = myoffsetZ;
		
		int myRotation = rotation;
		if(myRotation == 0 || myRotation > 4){
			myRotation = randIn.nextInt(4) + 1;
		}
		
		
		if(myRotation == 1){ //east facing
			for(int i = 0; i < width; i++){
				for(int j = 0; j < height; j++){
					for(int k = 0; k < length; k++){
						if(MyStructureArray[i][j][k] > 0){
							setBlock(worldIn, randIn, new BlockPos(new Vec3(x + i - offsetX, y + j - offsetY, z + k - offsetZ)), i,j,k, myRotation);
						}
					}
				}
			}
		}
		else if(myRotation == 2){
			for(int i = 0; i < width; i++){
				for(int j = 0; j < height; j++){
					for(int k = 0; k < length; k++){
						if(MyStructureArray[i][j][k] > 0){
							setBlock(worldIn, randIn, new BlockPos(new Vec3(x + k - offsetX, y + j - offsetY, z + i - offsetZ)), i,j,k, myRotation);
						}
					}
				}
			}
		}
		else if(myRotation == 3){
			for(int i = 0; i < width; i++){
				for(int j = 0; j < height; j++){
					for(int k = 0; k < length; k++){
						if(MyStructureArray[width - i - 1][j][k] > 0){
							setBlock(worldIn, randIn, new BlockPos(new Vec3(x + k - offsetX, y + j - offsetY, z + i - offsetZ)),width - i - 1,j,k, myRotation);
						}
					}
				}
			}
		}
		else if(myRotation == 4){
			for(int i = 0; i < width; i++){
				for(int j = 0; j < height; j++){
					for(int k = 0; k < length; k++){
						if(MyStructureArray[width - i - 1][j][k] > 0){
							setBlock(worldIn, randIn, new BlockPos(new Vec3(x + i - offsetX, y + j - offsetY, z + k - offsetZ)), width - i - 1,j,k, myRotation);
						}
					}
				}
			}
		}
		
	}

	public void setBlock(World worldIn, Random randIn, BlockPos myPos, int i, int j, int k, int rotation){}
	
}
