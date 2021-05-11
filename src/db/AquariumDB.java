package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.DataAccessException;
import model.Aquarium;

public class AquariumDB implements IAquariumDB {

    private static final String Q_GET_AQUARIUM = "TODO";
    private PreparedStatement psGetAquarium;

    @Override
    public List<Aquarium> getAquarium(String searchInput) {
	List<Aquarium> res = null;

	try {
	    Connection con = DBConnection.getInstance().getConnection();

	    psGetAquarium = con.prepareStatement(Q_GET_AQUARIUM);

	    psGetAquarium.setString(1, searchInput);

	    ResultSet rs = psGetAquarium.executeQuery();

	    res = buildObjects(rs);
	} catch (DataAccessException | SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return res;
    }

    private List<Aquarium> buildObjects(ResultSet rs) throws SQLException {
	List<Aquarium> res = new ArrayList<>();
	Aquarium current = null;
	while (rs.next()) {
	    current = buildObject(rs);
	    res.add(current);
	}
	return res;
    }

    private Aquarium buildObject(ResultSet rs) throws SQLException {
	Aquarium res = null;
	// TODO - NUMBER NEEDS TO BE STRING IN DB
	res = new Aquarium(rs.getString("number"), rs.getDouble("size"));
	res.setId(rs.getInt("id"));
	return res;
    }

}
