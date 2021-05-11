package ctrl;

import db.IFishPackDB;
import db.dao.FishPackDB;
import exception.DataAccessException;
import model.FishPack;

public class FishPackController {
	private AquariumController aquariumController;
	private FeedingPlanController feedingPlanController;
	private FishSpeciesController fishSpeciesController;
	private IFishPackDB fishPackDB;
	private FishPack fishPack;
	
	public FishPackController() throws DataAccessException {
		this.aquariumController = new AquariumController();
		this.feedingPlanController = new FeedingPlanController();
		this.fishSpeciesController = new FishSpeciesController();
		this.fishPackDB = new FishPackDB();
	}

}
