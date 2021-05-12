package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;

import ctrl.FishPackController;
import db.DBConnection;
import db.dao.FeedingPlanDB;
import db.dao.FishPackDB;
import env.ENV;
import exception.DataAccessException;
import model.FeedingPlan;
import model.FishPack;
import model.FishSpecies;

public class SQLcheck {
	
	@BeforeClass
	public static void startup() throws DataAccessException {
		DBConnection.startConnection(ENV.db_host, ENV.db_port, ENV.db_name, ENV.db_username, ENV.db_password);
	}

	@Test
	public void test() throws DataAccessException {
		FeedingPlanDB db = new FeedingPlanDB();
		
		FeedingPlan plan = db.getFeedingPlan("normal fisk").get(0);
		
		assertEquals("Normal fisk", plan.getName());
	}
	
	@Test
	public void test2() throws DataAccessException {		
		assertEquals(2, 2);
	}
	@Test
	public void testFishPackInsert() throws DataAccessException, SQLException {
		FeedingPlan plan = new FeedingPlan("Normal fisk", 3, 35, null);
		FishSpecies fs = new FishSpecies("fiskeart", 10, 5, 2, 20);
		fs.setId(1);
		plan.setID(1);
		FishPack fp = new FishPack(LocalDate.now(), plan, fs);
		FishPackDB fpDB = new FishPackDB();
		fpDB.insertFishPack(fp);
		
	}
}
