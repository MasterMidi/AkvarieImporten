package db;

import java.util.List;

import exception.DataAccessException;
import model.FeedingPlan;

public interface IFeedingPlanDB {

	List<FeedingPlan> getFeedingPlan(String searchInput) throws DataAccessException;
	
}
