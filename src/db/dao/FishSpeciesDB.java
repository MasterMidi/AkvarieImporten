package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import db.DBConnection;
import db.IFishSpeciesDB;
import exception.DataAccessException;
import model.FishSpecies;

public class FishSpeciesDB implements IFishSpeciesDB {
	// TODO
	static final String Q_GET_FISH_SPECIES = "SELECT * FROM fish_species WHERE name LIKE ?";
	static final String Q_GET_FISH_SPECIES_ID = "SELECT * FROM fish_species WHERE id = ?";

	private PreparedStatement psGetFishSpecies;
	private PreparedStatement psGetFishSpeciesID;

	public FishSpeciesDB() throws DataAccessException {
		Connection connection = DBConnection.getInstance().getConnection();

		try {
			psGetFishSpecies = connection.prepareStatement(Q_GET_FISH_SPECIES);
			psGetFishSpeciesID = connection.prepareStatement(Q_GET_FISH_SPECIES_ID);
		} catch (SQLException e) {
			throw new DataAccessException("could not create preparedstatement, check your query", null);
		}
	}

	@Override
	public Map<Integer, FishSpecies> getFishSpecies(String searchInput) {
		Map<Integer, FishSpecies> res = null;

		try {

			psGetFishSpecies.setString(1, "%" + searchInput + "%");

			ResultSet rs = psGetFishSpecies.executeQuery();

			res = buildObjects(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public FishSpecies getFishSpeciesWithID(int id) {
		FishSpecies res = null;

		try {
			psGetFishSpeciesID.setInt(1, id);

			ResultSet rs = psGetFishSpeciesID.executeQuery();

			rs.next();
			res = buildObject(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	private Map<Integer, FishSpecies> buildObjects(ResultSet rs) throws SQLException {
		Map<Integer, FishSpecies> res = new HashMap<Integer, FishSpecies>();
		FishSpecies current = null;
		while(rs.next()) {
			current = buildObject(rs);
			res.put(current.getId(), current);
		}
		return res;
	}

	private FishSpecies buildObject(ResultSet rs) throws SQLException {
		FishSpecies res = null;
		res = new FishSpecies(rs.getString("name"), rs.getInt("average_eggs"), rs.getDouble("birth_size"),
				rs.getDouble("grow_rate"), rs.getInt("minimum_sale_size"));
		res.setId(rs.getInt("id"));
		return res;
	}

}
