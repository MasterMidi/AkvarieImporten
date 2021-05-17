package db;

import java.util.Map;

import model.Aquarium;

public interface IAquariumDB {
	public Map<Integer, Aquarium> getAquarium(String searchInput);

}
