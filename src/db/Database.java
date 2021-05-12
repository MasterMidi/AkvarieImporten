package db;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import db.dao.AquariumDB;
import db.dao.FeedingPlanDB;
import db.dao.FishPackDB;
import db.dao.FishSpeciesDB;
import exception.DataAccessException;

public class Database {
	public static final int NUMBER_OF_THREADS = 4;
	public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

	private static Database instance;
	private static IAquariumDB aquariumDB;
	private static IFeedingPlanDB feedingPlanDB;
	private static IFishPackDB fishPackDB;
	private static IFishSpeciesDB fishSpeciesDB;

	public static Database getInstance() {
		if (instance == null) {
			synchronized (Database.class) {
				if (instance == null) {
					instance = new Database();
				}
			}
		}
		return instance;
	}

	public IAquariumDB aquariumDB() {
		if (aquariumDB == null) {
			synchronized (AquariumDB.class) {
				if (aquariumDB == null) {
					try {
						aquariumDB = new AquariumDB();
					} catch (DataAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return aquariumDB;
	}

	public IFeedingPlanDB feedingPlanDB() {
		if (feedingPlanDB == null) {
			synchronized (FeedingPlanDB.class) {
				if (feedingPlanDB == null) {
					try {
						feedingPlanDB = new FeedingPlanDB();
					} catch (DataAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return feedingPlanDB;
	}

	public IFishPackDB fishPackDB() {
		if (fishPackDB == null) {
			synchronized (FishPackDB.class) {
				if (fishPackDB == null) {
					try {
						fishPackDB = new FishPackDB();
					} catch (DataAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return fishPackDB;
	}

	public IFishSpeciesDB fishSpeciesDB() {
		if (fishSpeciesDB == null) {
			synchronized (FishSpeciesDB.class) {
				if (fishSpeciesDB == null) {
					try {
						fishSpeciesDB = new FishSpeciesDB();
					} catch (DataAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return fishSpeciesDB;
	}
}
