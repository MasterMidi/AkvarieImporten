package db;

import java.util.Map;

import model.FeedingPlan;

public interface IFeedingPlanDB {

	Map<Integer, FeedingPlan> getFeedingPlan(String searchInput);

}
