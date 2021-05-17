package db.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import db.DBConnection;
import db.IFishPackDB;
import exception.DataAccessException;
import model.Aquarium;
import model.FeedingPlan;
import model.FishPack;
import model.FishSpecies;
import model.Period;

public class FishPackDB implements IFishPackDB {
	private static final String Q_INSERT_FISH_PACK = "INSERT INTO fish_pack (birthday, fish_specie_id, feeding_plan_id, status) VALUES (?, ?, ?, ?)";
	private static final String Q_UPDATE_FISH_PACK = "UPDATE fish_pack SET pack_number = ? WHERE id = ?";
	private static final String Q_INSERT_PERIOD = "INSERT INTO fish_pack_period (start_date, aquarium_id, fish_pack_id) VALUES (?,?,?)";
	private static final String Q_GET_FISH_PACK = "SELECT fish_pack.id AS fish_pack_id, fish_pack.birthday AS fish_pack_birthday, fish_pack.pack_number AS fish_pack_number, fish_pack.status AS fish_pack_status, fish_pack.fish_specie_id AS species_id, fish_pack.feeding_plan_id AS , fish_pack_period.id as period_id, fish_pack_period.aquarium_id, fish_pack_period.end_date, fish_pack_period.start_date FROM fish_pack JOIN fish_pack_period ON fish_pack_period.id = (SELECT TOP 1  id FROM fish_pack_period WHERE end_date is null AND fish_pack_id = fish_pack.id ORDER BY fish_pack_period.start_date DESC) WHERE pack_number like ?";

	private PreparedStatement psInsertFishPack;
	private PreparedStatement psUpdateFishPack;
	private PreparedStatement psInsertPeriod;
	private PreparedStatement psGetFishpack;

	public FishPackDB() throws DataAccessException {
		Connection connection = DBConnection.getInstance().getConnection();

		try {
			psInsertFishPack = connection.prepareStatement(Q_INSERT_FISH_PACK, PreparedStatement.RETURN_GENERATED_KEYS);
			psUpdateFishPack = connection.prepareStatement(Q_UPDATE_FISH_PACK);
			psInsertPeriod = connection.prepareStatement(Q_INSERT_PERIOD, PreparedStatement.RETURN_GENERATED_KEYS);
			psGetFishpack = connection.prepareStatement(Q_GET_FISH_PACK);
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
		Map<Integer, FishPack> fishpacks = new HashMap<Integer, FishPack>();
		
		psGetFishpack.setString(1, "%" + searchInput + "%");
		ResultSet rs = psGetFishpack.executeQuery();

		while (rs.next()) {
			int fishPackId = rs.getInt("fish_pack_id");

			LocalDate birthday = rs.getDate("birthday").toLocalDate();
			LocalDate periodStartDay = rs.getDate("start_date").toLocalDate();

			Date endDate = rs.getDate("end_date");
			LocalDate periodEndDate = null;
			if (endDate != null) {
				periodEndDate = endDate.toLocalDate();
			}
			String status = rs.getString("status");
			
			FeedingPlan feedingPlan = FeedingPlanDB.buildObject(rs);
			FishSpecies fishSpecies = FishSpeciesDB.buildObject(rs);
			Period<Aquarium> aquarium = new Period<Aquarium>(AquariumDB.buildObject(rs), periodStartDay, periodEndDate);
			
			FishPack fishPack = new FishPack(fishPackId, status, birthday, feedingPlan, fishSpecies, aquarium);
			
			fishpacks.put(fishPackId, fishPack);
		}

//		System.out.println("PLEASE NOTICE! FishPackDB.getFishPack havent been implemented yet. ");
		return fishpacks;
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
