package in.co.rays.Marksheet;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;

public class TestMarksheet {

	public static void main(String[] args) throws Exception {

		// testadd();
		// testupdate();
		// testdelete();
		 testfindbyPk() ;

	//	testsearch();
	}

	private static void testadd() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setId(14);
		bean.setName("smith");
		bean.setRollNo(114);
		bean.setPhysics(96);
		bean.setChemistry(98);
		bean.setMaths(99);

		MarksheetModel model = new MarksheetModel();
		model.add(bean);
	}

	private static void testupdate() throws Exception {

		MarksheetBean bean = new MarksheetBean();

		bean.setId(14);
		bean.setName("virat");

		MarksheetModel model = new MarksheetModel();
		model.update(bean);

	}

	private static void testdelete() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		bean.setId(14);

		MarksheetModel model = new MarksheetModel();
		model.delete(bean);
	}

	private static void testfindbyPk() throws Exception {

		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = model.findbyPk(1);

		if (bean != null) {

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.print("\t" + bean.getMaths());

		} else {
			System.out.println("Id Not Found");
		}
	}

//		testnextPk();	
//	}
//
//	private static void testnextPk() {
//		MarksheetModel model = new MarksheetModel();
////		
////		

	private static void testsearch() throws Exception {

		MarksheetBean bean = new MarksheetBean();
		bean.setName("s%");
		// bean.setRollNo(101);

		MarksheetModel model = new MarksheetModel();

		List list = model.search(null, 0, 1);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (MarksheetBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());

		}

	}
}
