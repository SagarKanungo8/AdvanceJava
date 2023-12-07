package in.co.rays.Callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;



public class TestProcedureOut {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		
		CallableStatement callStmt = conn.prepareCall("{CALL empOUT(?)}");
		
		callStmt.registerOutParameter(1, Types.INTEGER);
		
		callStmt.execute();
		
		System.out.println(callStmt.getInt(1));
		
		}
				
	}


