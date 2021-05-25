package db;

import java.util.Map;

import exception.DataAccessException;
import model.Aquarium;

public interface IAquariumDB {
	public Map<Integer, Aquarium> getAquarium(String searchInput) throws DataAccessException;

}
