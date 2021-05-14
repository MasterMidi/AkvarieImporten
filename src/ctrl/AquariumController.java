package ctrl;

import java.util.ArrayList;
import java.util.List;

import db.Database;
import db.IAquariumDB;
import db.dao.AquariumDB;
import exception.DataAccessException;
import model.Aquarium;

public class AquariumController {
    private List<Aquarium> aquariumMatches;
    private IAquariumDB aquariumDB;

    public AquariumController() throws DataAccessException {
	this.aquariumDB = Database.getInstance().aquariumDB();
    }

    public List<Aquarium> searchAquarium(String searchInput) {
	aquariumMatches = aquariumDB.getAquarium(searchInput);
	return new ArrayList<>(aquariumMatches);
    }

    public Aquarium getAquarium(int aquariumID) {
	Aquarium res = aquariumMatches
			.parallelStream()
			.filter(x -> x.getId() == aquariumID)
			.findFirst().get();
	return res;
    }
}
