package db;

import java.util.Map;

import model.FishSpecies;

public interface IFishSpeciesDB {
	public Map<Integer, FishSpecies> getFishSpecies(String searchInput);
	
	public FishSpecies getFishSpeciesWithID(int id);
}
