package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exception.DataAccessException;

/**
 * 
 * @author knol, Michael, Magnus, Julius, Mike
 * @version 2021-04-20
 */
public class DBConnection {
	private Connection connection = null;
	private static DBConnection dbConnection;

	private static final String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	private static String dbName = null;
	private static String serverAddress = null;
	private static int serverPort = -1;
	private static String userName = null;
	private static String password = null;

	private DBConnection() throws DataAccessException {
		// Cheat sheet for the printf() method, the format is also used in the
		// String.format() method
		// http://alvinalexander.com/programming/printf-format-cheat-sheet
		String connectionString = String.format("jdbc:sqlserver://%s:%d;databaseName=%s;user=%s;password=%s",
				serverAddress, serverPort, dbName, userName, password);
		try {
			Class.forName(DRIVER_CLASS);
			connection = DriverManager.getConnection(connectionString);
			throw new SQLException();
		} catch (ClassNotFoundException e) {
			throw new DataAccessException("Missing JDBC driver", e);

		} catch (SQLException e) {
			throw new DataAccessException(String.format("Could not connect to database %s@%s:%d user %s", dbName,
					serverAddress, serverPort, userName), e);
		}
	}

	public static synchronized DBConnection getInstance() throws DataAccessException {
		if (dbConnection == null) {
			dbConnection = new DBConnection();
		}
		return dbConnection;
	}
	
	public static void setupDB(String serverAddress, int serverPort, String dbName, String userName, String password) {
		DBConnection.serverAddress = serverAddress;
		DBConnection.serverPort = serverPort;
		DBConnection.dbName = dbName;
		DBConnection.userName = userName;
		DBConnection.password = password;
	}
	
	public static synchronized DBConnection resetDB() throws DataAccessException {
		dbConnection = new DBConnection();
		return dbConnection;
	}

	/**
	 * 
	 * @throws DataAccessException - if the transaction could not be started (connection problem)
	 */
	public void startTransaction() throws DataAccessException {
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			throw new DataAccessException("Connection error. Could not start transaction.", e);
		}
	}

	/**
	 * 
	 * @throws DataAccessException - if the transaction could not be committed (connection problem)
	 */
	public void commitTransaction() throws DataAccessException {
		try {
			try {
				connection.commit();
			} catch (SQLException e) {
				throw e;
			} finally {
				connection.setAutoCommit(true);
			}
		} catch (SQLException e) {
			throw new DataAccessException("Connection error. Could not commit transaction", e);
		}
	}

	public void rollbackTransaction() throws DataAccessException {
		try {
			try {
				connection.rollback();
			} catch (SQLException e) {
				throw e;
			} finally {
				connection.setAutoCommit(true);
			}
		} catch (SQLException e) {
			throw new DataAccessException("Could not rollback transaction", e);
		}
	}

	public int executeInsertWithIdentity(String sql) throws DataAccessException {
		System.out.println("DBConnection, Inserting: " + sql);
		int res = -1;
		try (Statement s = connection.createStatement()) {
			res = s.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			if (res > 0) {
				ResultSet rs = s.getGeneratedKeys();
				rs.next();
				res = rs.getInt(1);
			}
			// s.close(); -- the try block does this for us now

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not execute insert (" + sql + ").", e);
		}
		return res;
	}

	public int executeInsertWithIdentity(PreparedStatement ps) throws DataAccessException {
		// requires prepared statement to be created with the additional argument
		// PreparedStatement.RETURN_GENERATED_KEYS
		int res = -1;
		try {
			res = ps.executeUpdate();
			if (res > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				res = rs.getInt(1);
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not execute insert", e);
		}
		return res;
	}

	public void executeInsert(PreparedStatement ps) throws DataAccessException {
		// requires prepared statement to be created with the additional argument
		// PreparedStatement.RETURN_GENERATED_KEYS
		try {
			ps.executeUpdate();
		} catch (SQLException e) {
			// e.printStackTrace();
			throw new DataAccessException("Could not execute insert", e);
		}
	}

	public Connection getConnection() {
		//TODO: ability to reopen connection?
		return connection;
	}

	/**
	 * Closes connection object. Use when the program wont need the connection anymore (can't be reopened)
	 */
	public void disconnect() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
