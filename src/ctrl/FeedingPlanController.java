package ctrl;

import java.util.ArrayList;
import java.util.List;

import db.Database;
import db.IFeedingPlanDB;
import db.dao.FeedingPlanDB;
import exception.DataAccessException;
import model.FeedingPlan;

public class FeedingPlanController {
	private List<FeedingPlan> feedingPlanMatches;
	private IFeedingPlanDB feedingPlanDB;

	public FeedingPlanController() throws DataAccessException {
		this.feedingPlanDB = Database.getInstance().feedingPlanDB();
	}
	
	public List<FeedingPlan> searchFeedingPlan(String searchInput) {
		feedingPlanMatches = feedingPlanDB.getFeedingPlan(searchInput);
		return new ArrayList<>(feedingPlanMatches);
	}

	public FeedingPlan getFeedingPlan(int feedingPlanId) {
		return feedingPlanMatches.parallelStream()
				.filter(feedingPlan -> feedingPlan.getID() == feedingPlanId)
				.findFirst().get();
	}
}
