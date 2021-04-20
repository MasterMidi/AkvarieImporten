import env.ENV;
import exception.DataAccessException;
import tools.DBConnection;

public class Main {

	public static void main(String[] args) {
		DBConnection.setupDB(ENV.db_host, ENV.db_port, ENV.db_name, ENV.db_username, ENV.db_password);
		try {
			DBConnection.getInstance();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
