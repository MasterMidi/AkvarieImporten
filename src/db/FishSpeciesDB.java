package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


import exception.DataAccessException;
import model.FishSpecies;

public class FishSpeciesDB implements IFishSpeciesDB {
	//TODO
	static final String Q_GET_FISH_SPECIES = "TODO";
	private PreparedStatement psGetFishSpecies;

	public FishSpeciesDB() throws DataAccessException {
	}
	@Override
	public List<FishSpecies> getFishSpecies(String searchInput) {
		List<FishSpecies> res = null;
		
		try {
			Connection con = DBConnection.getInstance().getConnection();
			
			PreparedStatement stmt = con.prepareStatement(Q_GET_FISH_SPECIES);
			
			stmt.setString(1, searchInput);
		} catch (DataAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

}
