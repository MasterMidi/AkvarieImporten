package ctrl;

import java.util.List;
import db.FishSpeciesDB;
import db.IFishSpeciesDB;
import exception.DataAccessException;
import model.FishSpecies;

public class FishSpeciesController {
	private List<FishSpecies> speciesMatches;
	private IFishSpeciesDB fishSpeciesDb;

	public FishSpeciesController() throws DataAccessException {
		this.fishSpeciesDb = new FishSpeciesDB();
	}

	public List<FishSpecies> searchFishSpecies(String searchInput) {
		this.speciesMatches = fishSpeciesDb.getFishSpecies(searchInput);
		return speciesMatches;

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
