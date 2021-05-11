package ctrl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import db.IFeedingPlanDB;
import exception.DataAccessException;
import model.FeedingPlan;

public class FeedingPlanController {
	private IFeedingPlanDB feedingPlanDB;
	private List<FeedingPlan> feedingPlanMatches;

	public List<FeedingPlan> searchFeedingPlan(String searchInput) throws DataAccessException {
		feedingPlanMatches = feedingPlanDB.getFeedingPlan(searchInput);

		return new ArrayList<>(feedingPlanMatches);
	}

	public FeedingPlan getFeedingPlan(int feedingPlanId) {
		return feedingPlanMatches.parallelStream()
				.filter(feedingPlan -> feedingPlan.getID() == feedingPlanId)
				.collect(Collectors.toList()).get(0);
	}
}
