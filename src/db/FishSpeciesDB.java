package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import exception.DataAccessException;
import model.FishSpecies;

public class FishSpeciesDB implements IFishSpeciesDB {
	//TODO
	static final String Q_GET_FISH_SPECIES = "SELECT * FROM fishSpecies WHERE name LIKE ?";
	private PreparedStatement psGetFishSpecies;

	@Override
	public List<FishSpecies> getFishSpecies(String searchInput) {
		List<FishSpecies> res = null;
		
		try {
			Connection con = DBConnection.getInstance().getConnection();
			
			PreparedStatement stmt = con.prepareStatement(Q_GET_FISH_SPECIES);
			
			stmt.setString(1, searchInput);
			
			ResultSet rs = stmt.executeQuery();
			
			res = buildObjects(rs);
		} catch (DataAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	private List<FishSpecies> buildObjects(ResultSet rs) throws SQLException {
		List<FishSpecies> res = new ArrayList<FishSpecies>();
		FishSpecies current = null;
		
		while(rs.next()) {
			current = buildObject(rs);
			res.add(current);
		}
		return res;
	}
	private FishSpecies buildObject(ResultSet rs) throws SQLException {
		FishSpecies res = null;
		res = new FishSpecies(rs.getString("name"), rs.getInt("average_eggs"), rs.getDouble("birth_size"), rs.getDouble("grow_rate"), rs.getDouble("minimum_sales_size"));
		res.setId(rs.getInt("id"));
		return res;
	}

}
