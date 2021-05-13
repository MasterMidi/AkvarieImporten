package ctrl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

    public List<FishSpecies> searchFishSpecies(String searchInput) {
	return fishSpeciesController.searchFishSpecies(searchInput);
    }

    // TODO Get Fishpacks
    public List<FishPack> searchFishPack(String searchInput) {
	ArrayList<FishPack> list = new ArrayList<>();
	FeedingPlan fplan = feedingPlanController.searchFeedingPlan("").get(0);
	FishSpecies fspec = fishSpeciesController.searchFishSpecies("").get(0);
	Aquarium fAqua = aquariumController.searchAquarium("").get(0);
	FishPack fishpack = new FishPack(LocalDate.now(), fplan, fspec);
	fishpack.setAquarium(fAqua);
	list.add(fishpack);
	return list;
    }

    public List<Aquarium> searchAquarium(String searchInput) {
	return aquariumController.searchAquarium(searchInput);
    }

    public List<FeedingPlan> searchFeedingplans(String searchInput) {
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

    /**
     * It works? yes!
     * 
     * @return something ¯\_(ツ)_/¯
     */
    public Future<Boolean> finishFishPack() {
	return Database.databaseWriteExecutor.submit(() -> fishPackDB.insertFishPack(fishPack));
    }
}
