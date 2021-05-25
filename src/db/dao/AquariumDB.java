package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import db.DBConnection;
import db.IAquariumDB;
import exception.DataAccessException;
import model.Aquarium;
import model.Location;

public class AquariumDB implements IAquariumDB {

	private static final String Q_GET_AQUARIUM = "SELECT aquarium.id AS aquarium_id, location_id AS aquarium_location_id, location.address AS aquarium_location_address, expense_id AS aquarium_expense_id, number AS aquarium_number, size AS aquarium_size FROM aquarium JOIN location ON aquarium.location_id = location.id WHERE number LIKE ?";
	private PreparedStatement psGetAquarium;

	public AquariumDB() throws DataAccessException {
		Connection connection = DBConnection.getInstance().getConnection();

		try {
			psGetAquarium = connection.prepareStatement(Q_GET_AQUARIUM);
		} catch (SQLException e) {
			throw new DataAccessException("could not create preparedstatement, check your query", null);
		}
	}

	@Override
	public Map<Integer, Aquarium> getAquarium(String searchInput) throws DataAccessException {

		Map<Integer, Aquarium> res = null;

		try {
			psGetAquarium.setString(1, "%" + searchInput + "%");

			ResultSet rs = psGetAquarium.executeQuery();

			res = buildObjects(rs);
		} catch (SQLException e) {
//			e.printStackTrace();
			throw new DataAccessException("Could not retireve aquarium, check the query", e);
		}

		return res;
	}

	protected static Map<Integer, Aquarium> buildObjects(ResultSet rs) throws SQLException {
		Map<Integer, Aquarium> res = new HashMap<Integer, Aquarium>();
		Aquarium current = null;
		while (rs.next()) {
			current = buildObject(rs);
			res.put(current.getId(), current);
		}
		return res;
	}

	protected static Aquarium buildObject(ResultSet rs) throws SQLException {
		Aquarium res = null;
		// TODO - NUMBER NEEDS TO BE STRING IN DB
		Location location = new Location(rs.getString("aquarium_location_address"));
		res = new Aquarium(rs.getString("aquarium_number"), rs.getDouble("aquarium_size"), location);
		res.setId(rs.getInt("aquarium_id"));
		return res;
	}

}
