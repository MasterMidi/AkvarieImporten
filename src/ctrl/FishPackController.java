package ctrl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.Future;

import db.Database;
import db.IFishPackDB;
import exception.DataAccessException;
import model.Aquarium;
import model.FeedingPlan;
import model.FishPack;
import model.FishSpecies;

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
		this.fishPackDB = Database.getInstance().fishPackDB();
	}

	public void createEmptyFishPack() {
		this.fishPack = new FishPack();
	}

	public Map<Integer, FishSpecies> searchFishSpecies(String searchInput) {
		return fishSpeciesController.searchFishSpecies(searchInput);
	}

	public void setFishPackBirthday(LocalDate date) {
		this.fishPack.setBirthDate(date);
	}

	public void setFishSpecies(int speciesID) {
		FishSpecies fishSpecies = fishSpeciesController.getFishSpecies(speciesID);
		this.fishPack.setSpecies(fishSpecies);
	}

	public Map<Integer, Aquarium> searchAquarium(String searchInput) throws DataAccessException {
		return aquariumController.searchAquarium(searchInput);
	}

	public void setAquarium(int aquariumID) {
		Aquarium aquarium = aquariumController.getAquarium(aquariumID);
		this.fishPack.setAquarium(aquarium);

	}

	public Map<Integer, FeedingPlan> searchFeedingplans(String searchInput) throws DataAccessException {
		return feedingPlanController.searchFeedingPlan(searchInput);
	}

	public void setFeedingPlan(int feedingPlanID) {
		FeedingPlan feedingPlan = feedingPlanController.getFeedingPlan(feedingPlanID);
		this.fishPack.setFeedingPlan(feedingPlan);
	}

	/**
	 * It works? yes!
	 * 
	 * @return something ¯\_(ツ)_/¯
	 */
	public Future<Boolean> finishFishPack() {
		return Database.databaseWriteExecutor.submit(() -> fishPackDB.insertFishPack(fishPack));
	}

	public Map<Integer, FishPack> searchFishPack(String searchInput) throws SQLException, DataAccessException {
		return fishPackDB.getFishPack(searchInput);
	}
}
