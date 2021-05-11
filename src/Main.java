import db.DBConnection;
import env.ENV;
import exception.DataAccessException;

public class Main {

	public static void main(String[] args) {
		try {	
			System.out.println(DBConnection.startConnection(ENV.db_host, ENV.db_port, ENV.db_name, ENV.db_username, ENV.db_password));
			System.out.println(DBConnection.startConnection(ENV.db_host, ENV.db_port, ENV.db_name, ENV.db_username, ENV.db_password));
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
