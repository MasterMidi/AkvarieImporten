package db.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import db.DBConnection;
import db.IFishPackDB;
import exception.DataAccessException;
import model.FishPack;

public class FishPackDB implements IFishPackDB {
	private static final String Q_INSERT_FISH_PACK = "INSERT INTO fish_pack (birthday, fish_specie_id, feeding_plan_id, status) VALUES (?, ?, ?, ?)";
	private static final String Q_UPDATE_FISH_PACK = "UPDATE fish_pack SET pack_number = ? WHERE id = ?";
	private PreparedStatement psInsertFishPack;
	private PreparedStatement psUpdateFishPack;
	
	public FishPackDB() throws DataAccessException {
		Connection connection = DBConnection.getInstance().getConnection();

		try {
			psInsertFishPack = connection.prepareStatement(Q_INSERT_FISH_PACK,PreparedStatement.RETURN_GENERATED_KEYS);
			psUpdateFishPack = connection.prepareStatement(Q_UPDATE_FISH_PACK);
		} catch (SQLException e) {
			throw new DataAccessException("could not create preparedstatement, check your query", null);
		}
	}
	

	@Override
	public boolean insertFishPack(FishPack fishPack) throws SQLException, DataAccessException {
		prepareStatementFishPack(fishPack);
		Integer id = DBConnection.getInstance().executeInsertWithIdentity(psInsertFishPack);
		String packNumber = fishPack.getSpecies().getName() + id;
		psUpdateFishPack.setString(1, packNumber);
		psUpdateFishPack.setInt(2, id);
		psUpdateFishPack.execute();
		
		
		return false;
	}


	private void prepareStatementFishPack(FishPack fishPack) throws SQLException {
		int feedingPlan = fishPack.getFeedingPlan().getID();
		int species = fishPack.getSpecies().getId();
		Date birthDate = Date.valueOf(fishPack.getBirthDate());
		psInsertFishPack.setDate(1, birthDate);
		psInsertFishPack.setInt(2, species);
		psInsertFishPack.setInt(3, feedingPlan);
		psInsertFishPack.setString(4, "not ready");
		
	}

}
