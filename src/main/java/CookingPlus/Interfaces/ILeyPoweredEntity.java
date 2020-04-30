package CookingPlus.Interfaces;

public interface ILeyPoweredEntity {
	
	boolean hasLeyStorage();
	
	boolean canRequestLeyAmount(int amount);
	
	void drainLeyEnergy(int amount);
	
	int getmaxStorageAmount();
	
	int getCurrentStorageAmount();
	
	int transfertEnergyToStorage(int amount);
}
