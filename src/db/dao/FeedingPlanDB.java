package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import db.IFeedingPlanDB;
import exception.DataAccessException;
import model.FeedingPlan;

public class FeedingPlanDB implements IFeedingPlanDB {

	private static final String Q_GET_FEEDING_PLAN = "SELECT id, name, interval, amount FROM feeding_plan WHERE name LIKE ?";
	private PreparedStatement psGetFeedingPlan;

	public FeedingPlanDB() throws DataAccessException {
		Connection connection = DBConnection.getInstance().getConnection();

		try {
			psGetFeedingPlan = connection.prepareStatement(Q_GET_FEEDING_PLAN);
		} catch (SQLException e) {
			throw new DataAccessException("could not create preparedstatement, check your query", null);
		}
	}

	@Override
	public List<FeedingPlan> getFeedingPlan(String searchInput) throws DataAccessException {
		
		List<FeedingPlan> returnList = null;
		try {
			psGetFeedingPlan.setString(1, "%" + searchInput + "%");

			ResultSet rs = psGetFeedingPlan.executeQuery();
			returnList = buildObjects(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnList;
	}


	private List<FeedingPlan> buildObjects(ResultSet rs) throws SQLException {
		List<FeedingPlan> feedingPlanList = new ArrayList<>();
		while (rs.next()) {
			feedingPlanList.add(buildObject(rs));
		}

		return feedingPlanList;
	}

	private FeedingPlan buildObject(ResultSet rs) throws SQLException {

		FeedingPlan plan = new FeedingPlan(rs.getString("name"), rs.getInt("interval"), rs.getInt("amount"), null); //Food-parameter is null, as that is out of this use case.
		plan.setID(rs.getInt("id"));

		return plan;
	}




}
