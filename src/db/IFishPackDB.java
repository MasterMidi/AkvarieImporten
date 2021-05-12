package db;

import java.sql.SQLException;

import exception.DataAccessException;
import model.FishPack;

public interface IFishPackDB {
	
	public boolean insertFishPack(FishPack fishPack) throws SQLException, DataAccessException;

}
