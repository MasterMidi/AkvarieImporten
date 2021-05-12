package db;

import java.util.List;

import model.FeedingPlan;

public interface IFeedingPlanDB {

	List<FeedingPlan> getFeedingPlan(String searchInput);
	
}
