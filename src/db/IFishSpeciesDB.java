package db;

import java.util.List;

import model.FishSpecies;

public interface IFishSpeciesDB {
	public List<FishSpecies> getFishSpecies(String searchInput);
}
