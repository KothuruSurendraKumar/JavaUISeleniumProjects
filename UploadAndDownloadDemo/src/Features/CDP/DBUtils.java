package Features.CDP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {

	public static Object[][] getDataFromDB() throws SQLException {
		List<Object[]> dataList = new ArrayList<>();
		
		String host = "localhost";
		String port = "3306";
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo", "root",
				"Surendra@1");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM loginDetails");
		
		while(rs.next()) {
			dataList.add(new Object[] {
				rs.getString("username"),
				rs.getString("password")
			});
			System.out.println(rs.getString("username"));
			System.out.println(rs.getString("password"));
		}
		
		Object[][] dataObject = new Object[dataList.size()][];
		return dataList.toArray(dataObject);
		
		
	}
}
