package db;

import java.util.List;

import model.Aquarium;

public interface IAquariumDB {
    public List<Aquarium> getAquarium(String searchInput);

}
