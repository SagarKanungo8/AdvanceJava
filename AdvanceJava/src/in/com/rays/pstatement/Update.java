package in.com.rays.pstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Update {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("update marksheet set name = 'virat' where id = 14");
		
		int i  = ps.executeUpdate();
		
		System.out.println("Data Updated" + i);
				
		
	}

}
