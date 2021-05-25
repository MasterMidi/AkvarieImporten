package ctrl;

import java.util.HashMap;
import java.util.Map;

import db.Database;
import db.IFeedingPlanDB;
import exception.DataAccessException;
import model.FeedingPlan;

public class FeedingPlanController {
	private Map<Integer, FeedingPlan> feedingPlanMatches;
	private IFeedingPlanDB feedingPlanDB;

	public FeedingPlanController() {
		this.feedingPlanDB = Database.getInstance().feedingPlanDB();
	}

	public Map<Integer, FeedingPlan> searchFeedingPlan(String searchInput) throws DataAccessException {
		feedingPlanMatches = feedingPlanDB.getFeedingPlan(searchInput);
		return new HashMap<Integer, FeedingPlan>(feedingPlanMatches);
	}

	public FeedingPlan getFeedingPlan(int feedingPlanId) {
		return feedingPlanMatches.get(feedingPlanId);
	}
}
