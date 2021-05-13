package db;

import java.sql.SQLException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import exception.DataAccessException;
import model.FishPack;

public class Repository {
	private IAquariumDB aquariumDB;
	private IFeedingPlanDB feedingPlanDB;
	private IFishPackDB fishPackDB;
	private IFishSpeciesDB fishSpeciesDB;

	public Repository() {
		Database db = Database.getInstance();

		aquariumDB = db.aquariumDB();
		feedingPlanDB = db.feedingPlanDB();
		fishPackDB = db.fishPackDB();
		fishSpeciesDB = db.fishSpeciesDB();
	}

	public void insertFishPack(FishPack fishPack) {
		Future<Boolean> f = Database.databaseWriteExecutor.submit(new Callable<Boolean>() {

			@Override
			public Boolean call() throws Exception {
				fishPackDB.insertFishPack(fishPack);
				return null;
			}
		});
		
//		f.get();
	}
}
