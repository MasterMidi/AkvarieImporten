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
	return fishSpeciesDb.getFishSpecies(searchInput);
	
}
	
}
