package in.com.rays.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserModel {
	
	public void add(UserBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
		
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getFirstName());
		ps.setString(3, bean.getLastName());
		ps.setString(4, bean.getLoginId());
		ps.setString(5, bean.getPassword());
		ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(7, bean.getAddress());
	
	
		int i = ps.executeUpdate();
		System.out.println("Data Inserted " + i);
	}
				
		
		public void update (UserBean bean) throws Exception {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
			
			PreparedStatement ps = conn.prepareStatement("update user set first_name = ? where id  = ?");
			
			
			ps.setString(1, bean.getFirstName());
			ps.setInt(2, bean.getId());
			
		    int i =	ps.executeUpdate();
			
			System.out.println("Data Updated" + i);
		}
		
		public void delete(int id) throws Exception {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
			
			PreparedStatement ps = conn.prepareStatement("delete from user where id = ?");
			
			ps.setInt(1,id);
			
			UserModel model = new UserModel();
			
			int i = ps.executeUpdate();
			
			System.out.println("Data Deleted" + i);
		
		}

          public List search(UserBean bean,int PageNo,int PageSize) throws Exception {
        	  
        	  Class.forName("com.mysql.cj.jdbc.Driver");
        	  
        	  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
        	  
        	  StringBuffer sql = new StringBuffer("Select * from user where 1=1");
        	  
        	  if(bean != null) {
        		  
        		//  if(bean.getFirstName()!=null && bean.getFirstName().length() > 0) {
        		  
                  //sql.append(" and first_name like '" + bean.getFirstName() + "%'");
        	  
        	  //}
        		  if(bean.getDob()!=null && bean.getDob().getTime() > 0) {
        			  sql.append(" and dob like '" + new java.sql.Date(bean.getDob().getTime()) + "%'");
        		  }
        	  
        	  if(PageSize > 0) {
        		  
        	  PageNo = (PageNo-1)*PageSize;
        	  
        	  sql.append(" limit s" + PageNo + ", " + PageSize);
        	 
        	  }
        	  }
        	  System.out.println("SQL=====>>>>" + sql);
        	  
        	  PreparedStatement ps = conn.prepareStatement(sql.toString());
        	  
        	  ResultSet rs  = ps.executeQuery();
        	  
        	  List list = new ArrayList();
        	  
             while(rs.next()) {
        	
        	bean = new UserBean();
        	
        	bean.setId(rs.getInt(1));
        	bean.setFirstName(rs.getString(2));
        	bean.setLastName(rs.getString(3));
        	bean.setLoginId(rs.getString(4));
        	bean.setPassword(rs.getString(5));
        	bean.setDob(rs.getDate(6));
        	bean.setAddress(rs.getString(7));
        	
        	list.add(bean);
        }
        	  
			return list;
        	  
          }
          
          public UserBean findbyId(int id) throws Exception {
        	  
        	  Class.forName("com.mysql.cj.jdbc.Driver");
        	  
        	  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
        	  
        	  PreparedStatement ps = conn.prepareStatement("select * from user where id =?");
        	  
        	  ps.setInt(1, id);
        	  
        	  ResultSet rs = ps.executeQuery();
        	  
        	  UserBean bean = null;
        	  
        	  while(rs.next()) {
        	  
        	  bean = new UserBean();
        	  
        	      bean.setId(rs.getInt(1));
        	      bean.setFirstName(rs.getString(2));
        	      bean.setLastName(rs.getString(3));
        	      bean.setLoginId(rs.getString(4));
        	      bean.setPassword(rs.getString(5));
        	      bean.setDob(rs.getDate(6));
        	      bean.setAddress(rs.getString(7));
        	  }
        	      return bean;
            	  
            	  
          }
		
          public UserBean authenticate(String loginId,String password) throws Exception {
        	  
        	  Class.forName("com.mysql.cj.jdbc.Driver");
        	  
        	  Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
        	  		
        	PreparedStatement ps = conn.prepareStatement("select * from user where login_id = ? and password = ?"); 		  
        			  
        	ps.setString(1, loginId);
        	ps.setString(2, password);
        	
        	ResultSet rs = ps.executeQuery();
        	UserBean bean = null;
        	
        	while(rs.next()) {
        		
            bean = new UserBean();
            bean.setId(rs.getInt(1));
            bean.setFirstName(rs.getString(2));
            bean.setLastName(rs.getString(3));
            bean.setLoginId(rs.getString(4));
            bean.setPassword(rs.getString(5));
            bean.setDob(rs.getDate(6));
            bean.setAddress(rs.getString(7));
        		
        		
        	}
        	 
			return bean;
		}
          
          public Integer nextPk() throws Exception {
        	  
        	  int pk = 0;
        	  
        	  Class.forName("com.mysql.cj.jdbc.Driver");
        	  		
        	  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");
        	  
        	  PreparedStatement ps = conn.prepareStatement("select max(id) from user");
        	  
        	  ResultSet rs = ps.executeQuery();
        	  
        	  while(rs.next()) {
        		  
        		  pk = rs.getInt(1);
        	  }
        	   return pk+1;
        	  
        	  
        	  
        	  
        	  
        	  
        	  
        	  
			
		}
          
          
          
          
          
		
	}


        	  
        	  
        	  
        	  
        	  
        	  
        	  
        	  
        	  
        	  
        	  
        		  
			

