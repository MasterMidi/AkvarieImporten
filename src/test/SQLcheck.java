package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import db.DBConnection;
import db.dao.FeedingPlanDB;
import env.ENV;
import exception.DataAccessException;
import model.FeedingPlan;

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

}
