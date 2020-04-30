package CookingPlus.Dimension;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CellularAutomationIslands {
	//Generate a list of random islands on every startup
	//world gen picks a random island from list with a random rotation applied to it
	//trees/plants are applied during worldgen
	//dirt is added during island generation
	protected World currentWorld;
	public int w;
	public int h;
	public int l;
	protected int IslandArray[][][];
	protected Random myRand;
	
	public ArrayList<BlockPos> MyList;
	public ArrayList<BlockPos> MyDirtList;
	public ArrayList<BlockPos> MyGrassList;
	public int OffsetX;
	public int OffsetY;
	public int OffsetZ;
	
	public CellularAutomationIslands(World myWorld, int W, int H, int L){
		currentWorld = myWorld;
		w = W;
		h = H;
		l = L;
		IslandArray = new int[W][H][L];
		myRand = new Random();
		MyList = new ArrayList<BlockPos>();
		MyDirtList = new ArrayList<BlockPos>();
		MyGrassList = new ArrayList<BlockPos>();
	}
	
	public void BeginGeneration(int Iterations, int SmoothIterations){
		SeedGameofLife();
		
		for(int i = 0; i < Iterations; i++){
			IterateLife();
		}
		
		for(int i = 0; i < SmoothIterations; i++){
			Smooth();
		}
		
		CullSingleBlocks();
		CullSingleBlocks();
		FlattenTop();
		
		ExtractLargestIsland();
		
		for(int i = 0; i < 96; i++){
			for(int j = 0; j < 50; j++){
				for(int k = 0; k < 96; k++){
					if(IslandArray[i][j][k] == 1){
						if(j + 1 < 50 && IslandArray[i][j + 1][k] != 1){
							MyGrassList.add(new BlockPos(i, j, k));
						}
						else if(j + 2 < 50 && IslandArray[i][j + 2][k] != 1){
							MyDirtList.add(new BlockPos(i, j, k));
						}
						else if(j + 3 < 50 && IslandArray[i][j + 3][k] != 1){
							MyDirtList.add(new BlockPos(i, j, k));
						}
						else{
							MyList.add(new BlockPos(i, j, k));
						}
					}
				}
			}
		}
		
		int maxY = 0;
		int minY = 0;
		int maxX = 0;
		int minX = 0;
		int maxZ = 0;
		int minZ = 0;
		
		for(int i = 0; i < MyList.size(); i++){
			
			if(MyList.get(i).getX() > maxX){
				maxX = MyList.get(i).getX();
			}
			if(MyList.get(i).getY() > maxY){
				maxY = MyList.get(i).getY();
			}
			if(MyList.get(i).getZ() > maxZ){
				maxZ = MyList.get(i).getZ();
			}
			
			if(MyList.get(i).getX() < minX){
				minX = MyList.get(i).getX();
			}
			if(MyList.get(i).getY() < minY){
				minY = MyList.get(i).getY();
			}
			if(MyList.get(i).getZ() < minZ){
				minZ = MyList.get(i).getZ();
			}
		}
		
		int midY;
		int midX;
		int midZ;
		
		midX = maxX - (maxX - minX)/2;
		midY = maxY - (maxY - minY)/2;
		midZ = maxZ - (maxZ - minZ)/2;
		
		OffsetX = l/2 - midX;
		OffsetY = h/2 - midY;
		OffsetZ = w/2 - midZ;
		
		for(int i = 0; i < MyList.size(); i++){
			MyList.get(i).add(OffsetX - l/2, OffsetY - h/2, OffsetZ - l/2);
		}
		for(int i = 0; i < MyDirtList.size(); i++){
			MyDirtList.get(i).add(OffsetX - l/2, OffsetY - h/2, OffsetZ - l/2);
		}
		for(int i = 0; i < MyGrassList.size(); i++){
			MyGrassList.get(i).add(OffsetX - l/2, OffsetY - h/2, OffsetZ - l/2);
		}
		
	}
	
	private void IterateLife(){
		float ChancetoGrow = 0.4f;
		float ChancetoDie = 0.6f;
		int TempArray[][][] = new int[w][h][l];
		
		for(int i = 0; i < w; i++){
			for(int j = 0; j < h; j++){
				for(int k = 0; k < l; k++){
					int Count = CountSurrounding(i, j, k);
					if(Count <= 4 && Count != 0){
						if(myRand.nextFloat() < ChancetoGrow){
							TempArray[i][j][k] = 1;
						}
						else{
							TempArray[i][j][k] = IslandArray[i][j][k];
						}
					}
					else if(Count >= 5){
						if(myRand.nextFloat() < ChancetoDie){
							TempArray[i][j][k] = 0;
						}
						else{
							TempArray[i][j][k] = IslandArray[i][j][k];
						}
					}
					else{
						TempArray[i][j][k] = IslandArray[i][j][k];
					}
				}
			}
		}
		
		IslandArray = TempArray;
	}
	
	private void Smooth(){
		float ChancetoGrow = 0.1f;
		float ChancetoDie = 0.6f;
		int TempArray[][][] = new int[w][h][l];
		
		for(int i = 0; i < w; i++){
			for(int j = 0; j < h; j++){
				for(int k = 0; k < l; k++){
					int Count = CountSurrounding(i, j, k);
					if(Count == 6){
						TempArray[i][j][k] = 1;
					}
					else if(Count > 2){
						if(myRand.nextFloat() < ChancetoGrow * Count){
							TempArray[i][j][k] = 1;
						}
						else{
							TempArray[i][j][k] = IslandArray[i][j][k];
						}
					}
					else if(Count > 0 && Count < 3){
						if(myRand.nextFloat() < ChancetoGrow * Count){
							TempArray[i][j][k] = 0;
						}
						else{
							TempArray[i][j][k] = IslandArray[i][j][k];
						}
					}
					else{
						TempArray[i][j][k] = 0;
					}
				}
			}
		}
		
		IslandArray = TempArray;
	}
	
	private void FlattenTop(){
		
		for(int i = 0; i < w; i++){
			for(int j = 0; j < h; j++){
				for(int k = 0; k < l; k++){
					int Count = CountSurrounding(i, j, k);
					if(j + 1 < h){
						if(IslandArray[i][j + 1][k] == 0){
							IslandArray[i][j][k] = 0;
						}
					}
				}
			}
		}
		
	}
	
	private int CountSurrounding(int i, int j, int k){
		int Count = 0;
		//left
		if(i - 1 > 0){
			if(IslandArray[i - 1][j][k] == 1){
				Count++;
			}
		}
		//right
		if(i + 1 < w){
			if(IslandArray[i + 1][j][k] == 1){
				Count++;
			}
		}
		//down
		if(j - 1 > 0){
			if(IslandArray[i][j - 1][k] == 1){
				Count++;
			}
		}
		//up
		if(j + 1 < h){
			if(IslandArray[i][j + 1][k] == 1){
				Count++;
			}
		}
		//back
		if(k - 1 > 0){
			if(IslandArray[i][j][k - 1] == 1){
				Count++;
			}
		}
		//front
		if(k + 1 < l){
			if(IslandArray[i][j][k + 1] == 1){
						Count++;
			}
		}
		
		return Count;
	}
	
	private void CullSingleBlocks(){
		int TempArray[][][] = new int[w][h][l];
		
		for(int i = 0; i < w; i++){
			for(int j = 0; j < h; j++){
				for(int k = 0; k < l; k++){
					int Count = CountSurrounding(i, j, k);
					if(Count < 3){
						TempArray[i][j][k] = 0;
					}
					else{
						TempArray[i][j][k] = IslandArray[i][j][k];
					}
				}
			}
		}
		
		IslandArray = TempArray;
	}
	
	private void SeedGameofLife(){
		float SpawnChance = 0.0001f;
		for(int i = 10; i < w - 10; i++){
			for(int j = 10; j < h - 10; j++){
				for(int k = 10; k < l - 10; k++){
					if(myRand.nextFloat() < SpawnChance){
						IslandArray[i][j][k] = 1;
					}
				}
			}
		}
	}
	
	public void TranslateIslandtoWorld(int x, int y, int z, World myWorld){
		System.out.println(x + " " + y + " " + z);
		for(int i = 0; i < w; i++){
			for(int j = 0; j < h; j++){
				for(int k = 0; k < l; k++){
					if(IslandArray[i][j][k] == 1){
						if(currentWorld.getBlockState(new BlockPos(i + x, j + y, k + z)).getBlock().getMaterial(currentWorld.getBlockState(new BlockPos(i + x, j + y, k + z))) == Material.AIR){
							myWorld.setBlockState(new BlockPos(i + x, j + y, k + z), Blocks.STONE.getDefaultState());
						}
					}
				}
			}
		}
	}
	
	private void ExtractLargestIsland(){
		
		int CheckArray[][][] = new int[w][h][l];
		int Max = 0;
		
		for(int i = 0; i < w; i++){
			for(int j = 0; j < h; j++){
				for(int k = 0; k < l; k++){
					if(CheckArray[i][j][k] == 0){
						if(IslandArray[i][j][k] == 1){
							int GetCount = FillIslandCheck(CheckArray, new BlockPos(i,j,k));
							if(GetCount > Max){
								Max = GetCount;
							}
						}
					}
				}
			}
		}
		
		for(int i = 0; i < w; i++){
			for(int j = 0; j < h; j++){
				for(int k = 0; k < l; k++){
					if(CheckArray[i][j][k] != Max){
						IslandArray[i][j][k] = 0;
					}
				}
			}
		}
	}
	
	private int FillIslandCheck(int[][][] myCheckArray, BlockPos myPos){
		ArrayList<BlockPos> MyList = new ArrayList<BlockPos>();
		int Count = 1;
		MyList.add(myPos);
		//System.out.println("Starting Extraction " + myPos);
		for(int i = 0; i < MyList.size(); i++){
			int X = MyList.get(i).getX();
			int Y = MyList.get(i).getY();
			int Z = MyList.get(i).getZ();
			//right
			if(X + 1 < w){
				if(IslandArray[X + 1][Y][Z] == 1){
					if(!MyList.contains(new BlockPos(X + 1, Y, Z))){
						MyList.add(new BlockPos(X + 1, Y, Z));
						Count++;
					}
				}
			}
			//left
			if(X - 1 > 0){
				if(IslandArray[X - 1][Y][Z] == 1){
					if(!MyList.contains(new BlockPos(X - 1, Y, Z))){
						MyList.add(new BlockPos(X - 1, Y, Z));
						Count++;
					}
				}
			}
			//down
			if(Y - 1 > 0){
				if(IslandArray[X][Y - 1][Z] == 1){
					if(!MyList.contains(new BlockPos(X, Y - 1, Z))){
						MyList.add(new BlockPos(X, Y - 1, Z));
						Count++;
					}
				}
			}
			//up
			if(Y + 1 < h){
				if(IslandArray[X][Y + 1][Z] == 1){
					if(!MyList.contains(new BlockPos(X, Y + 1, Z))){
						MyList.add(new BlockPos(X, Y + 1, Z));
						Count++;
					}
				}
			}
			//front
			if(Z + 1 < l){
				if(IslandArray[X][Y][Z + 1] == 1){
					if(!MyList.contains(new BlockPos(X, Y, Z + 1))){
						MyList.add(new BlockPos(X, Y, Z + 1));
						Count++;
					}
				}
			}
			//back
			if(Z - 1 > 0){
				if(IslandArray[X][Y][Z - 1] == 1){
					if(!MyList.contains(new BlockPos(X, Y, Z - 1))){
						MyList.add(new BlockPos(X, Y, Z - 1));
						Count++;
					}
				}
			}
		}
		//System.out.println("Extraction Calculated");
		for(int i = 0; i < MyList.size(); i++){
			int X = MyList.get(i).getX();
			int Y = MyList.get(i).getY();
			int Z = MyList.get(i).getZ();
			myCheckArray[X][Y][Z] = MyList.size();
		}
		
		
		return MyList.size();
	}

	public int[][][] GetIsland(){
		return IslandArray;
	}
}
