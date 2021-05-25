package db;

import java.util.Map;

import exception.DataAccessException;
import model.FeedingPlan;

public interface IFeedingPlanDB {

	Map<Integer, FeedingPlan> getFeedingPlan(String searchInput) throws DataAccessException;

}
