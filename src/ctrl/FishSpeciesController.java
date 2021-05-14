package ctrl;

import java.util.ArrayList;
import java.util.List;

import db.Database;
import db.IFishSpeciesDB;
import db.dao.FishSpeciesDB;
import exception.DataAccessException;
import model.FishSpecies;

public class FishSpeciesController {
	private List<FishSpecies> speciesMatches;
	private IFishSpeciesDB fishSpeciesDB;

	public FishSpeciesController() throws DataAccessException {
		this.fishSpeciesDB = Database.getInstance().fishSpeciesDB();
	}

	public List<FishSpecies> searchFishSpecies(String searchInput) {
		this.speciesMatches = fishSpeciesDB.getFishSpecies(searchInput);
		return new ArrayList<>(speciesMatches);

	}

	public FishSpecies getFishSpecies(int fishSpeciesId){
		FishSpecies res = null;
		res = speciesMatches
				.parallelStream()
				.filter((x) -> x.getId()== fishSpeciesId)
				.findFirst().get();
		return res;
	}
}
