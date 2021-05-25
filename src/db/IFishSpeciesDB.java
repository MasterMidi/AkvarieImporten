package db;

import java.sql.SQLException;
import java.util.Map;

import model.FishSpecies;

public interface IFishSpeciesDB {
	public Map<Integer, FishSpecies> getFishSpecies(String searchInput) throws SQLException;
}
