package in.co.rays.MetaData;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestMetaData {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		
		
	}

}
