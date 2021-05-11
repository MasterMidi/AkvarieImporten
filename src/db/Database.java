package db;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Database {
	public static final int NUMBER_OF_THREADS = 2;
	public static final ExecutorService databaseAccessExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

	private static Database INSTANCE;

	public static synchronized Database getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Database();
		}
		return INSTANCE;
	}
}
