package ctrl;

import java.util.HashMap;
import java.util.Map;

import db.Database;
import db.IAquariumDB;
import exception.DataAccessException;
import model.Aquarium;

public class AquariumController {
	private Map<Integer, Aquarium> aquariumMatches;
	private IAquariumDB aquariumDB;

	public AquariumController() throws DataAccessException {
		this.aquariumDB = Database.getInstance().aquariumDB();
	}

	public HashMap<Integer, Aquarium> searchAquarium(String searchInput) {
		aquariumMatches = aquariumDB.getAquarium(searchInput);
		return new HashMap<Integer, Aquarium>(aquariumMatches);
	}

	public Aquarium getAquarium(int aquariumID) {
		Aquarium res = aquariumMatches.get(aquariumID);

		return res;
	}
}
