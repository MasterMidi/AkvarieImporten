package ctrl;

import java.time.LocalDate;
import java.util.List;

import db.IFishPackDB;
import db.dao.FishPackDB;
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
		this.fishPackDB = new FishPackDB();
	}

	public void createEmptyFishPack() {
		this.fishPack = new FishPack();
	}
	
	public List<FishSpecies> searchFishSpecies(String searchInput) {
		return fishSpeciesController.searchFishSpecies(searchInput);	
	}
	
	public List<Aquarium> searchAquarium(String searchInput) {
		return aquariumController.searchAquarium(searchInput);
	}
	//TODO shoudnt throw anything
	public List<FeedingPlan> searchFeedingplans(String searchInput) throws DataAccessException {
		return feedingPlanController.searchFeedingPlan(searchInput);
	}
	
	public void setFishSpecies(int speciesID) {
		FishSpecies fishSpecies = fishSpeciesController.getFishSpecies(speciesID);
		this.fishPack.setSpecies(fishSpecies);
	}
	
	public void setFishPackBirthday(LocalDate date) {
		this.fishPack.setBirthDate(date);
	}
	
	public void setFeedingPlan(int feedingPlanID) {
		FeedingPlan feedingPlan = feedingPlanController.getFeedingPlan(feedingPlanID);
		this.fishPack.setFeedingPlan(feedingPlan);
	}
	
	public void setAquarium(int aquariumID) {
		Aquarium aquarium = aquariumController.getAquarium(aquariumID);
		this.fishPack.setAquarium(aquarium);
		
	}
}
