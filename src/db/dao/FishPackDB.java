package db.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import db.DBConnection;
import db.IFishPackDB;
import exception.DataAccessException;
import model.Aquarium;
import model.FishPack;
import model.Period;

public class FishPackDB implements IFishPackDB {
	private static final String Q_INSERT_FISH_PACK = "INSERT INTO fish_pack (birthday, fish_specie_id, feeding_plan_id, status) VALUES (?, ?, ?, ?)";
	private static final String Q_UPDATE_FISH_PACK = "UPDATE fish_pack SET pack_number = ? WHERE id = ?";
	private static final String Q_INSERT_PERIOD = "INSERT INTO fish_pack_period (start_date, aquarium_id, fish_pack_id) VALUES (?,?,?)";
	private static final String Q_GET_FISH_PACK = "";

	private PreparedStatement psInsertFishPack;
	private PreparedStatement psUpdateFishPack;
	private PreparedStatement psInsertPeriod;

	public FishPackDB() throws DataAccessException {
		Connection connection = DBConnection.getInstance().getConnection();

		try {
			psInsertFishPack = connection.prepareStatement(Q_INSERT_FISH_PACK, PreparedStatement.RETURN_GENERATED_KEYS);
			psUpdateFishPack = connection.prepareStatement(Q_UPDATE_FISH_PACK);
			psInsertPeriod = connection.prepareStatement(Q_INSERT_PERIOD, PreparedStatement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			throw new DataAccessException("could not create preparedstatement, check your query", null);
		}
	}

	@Override
	public boolean insertFishPack(FishPack fishPack) throws SQLException, DataAccessException {
		DBConnection.getInstance().startTransaction();
		DBConnection.getInstance().setIsolationLevel(Connection.TRANSACTION_REPEATABLE_READ);

		prepareStatementFishPack(fishPack);
		Integer fishPackID = DBConnection.getInstance().executeInsertWithIdentity(psInsertFishPack);

		String packNumber = fishPack.getSpecies().getName() + fishPackID;
		psUpdateFishPack.setString(1, packNumber);
		psUpdateFishPack.setInt(2, fishPackID);
		psUpdateFishPack.execute();

		insertPeriod(fishPack.getAquariumPeriods().get(0), fishPackID);

		DBConnection.getInstance().setIsolationLevel(Connection.TRANSACTION_READ_COMMITTED);
		DBConnection.getInstance().commitTransaction();

		return true;
	}
	
	@Override
	public Map<Integer, FishPack> getFishPack(String searchInput) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	private void insertPeriod(Period<Aquarium> period, Integer fishPackID) throws SQLException, DataAccessException {
		psInsertPeriod.setDate(1, Date.valueOf(period.getStartDate()));
		psInsertPeriod.setInt(2, period.getObject().getId());
		psInsertPeriod.setInt(3, fishPackID);
		DBConnection.getInstance().executeInsertWithIdentity(psInsertPeriod);
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
