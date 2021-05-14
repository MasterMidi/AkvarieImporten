package db;

import java.util.List;
import java.util.Map;

import model.Aquarium;
import model.FeedingPlan;

public interface IAquariumDB {
    public Map<Integer, Aquarium> getAquarium(String searchInput);

}
