package db;

import java.sql.SQLException;
import java.util.Map;

import exception.DataAccessException;
import model.FishPack;

public interface IFishPackDB {
	
	public boolean insertFishPack(FishPack fishPack) throws SQLException, DataAccessException;
	public Map<Integer, FishPack> getFishPack(String searchInput) throws SQLException, DataAccessException;

}
