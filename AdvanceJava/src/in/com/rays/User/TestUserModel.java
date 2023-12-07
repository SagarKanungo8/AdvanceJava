package in.com.rays.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	public static void main(String[] args) throws Exception {
		//testadd();
		//testupdate();
		//testdelete();
	//   testsearch();
		//testfindbyId();
		//testauthenticate();
		testnextPk();
			}

	private static void testnextPk() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		
		int i = model.nextPk();
		
		if(bean!=null) {
			
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLoginId());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println(bean.getAddress());
		}
		
	}

	private static void testauthenticate() throws Exception {
		UserModel model = new UserModel();
		
		UserBean bean = model.authenticate("dipesh@gmail.com", "123");
		
		if(bean!=null) {
			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());
		} else {
			System.out.println("Invalid User");
		}
		
	}

	private static void testfindbyId() throws Exception {
		
		UserModel model = new UserModel();
		
		UserBean bean = model.findbyId(1);
		
		if(bean != null) {
			
			System.out.print("\t" + bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t"  +bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t"+ bean.getAddress());
		}else {
			System.out.println("ID not found");
		}
		
		
	}

	private static void testsearch() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
		UserBean bean = new UserBean();
		
		//bean.setFirstName("D%");
		
		bean.setDob(sdf.parse("2001-09-05"));
		
		UserModel model = new UserModel();
		
	    List list = model.search(bean,1,1);
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			
			bean = (UserBean) it.next();
			
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());
			
		}
			
	}

	private static void testdelete() throws Exception{
		UserBean bean  = new UserBean();
		
		UserModel model = new UserModel();
		
		model.delete(1);
		
	}

	private static void testupdate() throws Exception {
		UserBean bean = new UserBean();
		
		bean.setId(2);
		bean.setFirstName("virat");
		
		UserModel model = new UserModel();
		
		model.update(bean);	
		
	}

	private static void testadd() throws Exception {
		

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserBean bean = new UserBean();
		bean.setId(1);
		bean.setFirstName("dipesh");
		bean.setLastName("gurjar");
		bean.setLoginId("dipesh@gmail.com");
		bean.setPassword("123");
	    bean.setDob(sdf.parse("2001-09-05"));
	    bean.setAddress("indore");
	    
	    UserModel model = new UserModel();
	    
	    model.add(bean);
		
		
	}
}

