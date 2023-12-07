package in.co.rays.TransactionHandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class TestTransactionHandling {
	
	public static void main(String[] args) throws Exception {
		
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
			
			conn.setAutoCommit(false);
			
			Statement stmt = conn.createStatement();
			
			int i = stmt.executeUpdate("insert into emp values(9,'virat',4000)");
			     i = stmt.executeUpdate("insert into emp values(9,'rajat',5000)");
			     i = stmt.executeUpdate("insert into emp values(10,'viraj',8000)");
			     
			     conn.commit();
			     conn.close();
			     System.out.println("Data Inserted" + i);
			    	
			    
		} catch (Exception e) {
			conn.rollback();
			System.out.println(e.getMessage());
	}
		
			}
}
