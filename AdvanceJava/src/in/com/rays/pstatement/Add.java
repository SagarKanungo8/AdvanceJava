package in.com.rays.pstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Add {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","root");
		 
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(13,'travis',113,78,89,95)");
		
		int i = ps.executeUpdate();
		
		 System.out.println("Data Inserted" + i);
		
	}

}
