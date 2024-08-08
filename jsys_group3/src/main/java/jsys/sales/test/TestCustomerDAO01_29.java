///**
// * @author J28_木場厚汰（2024/8/8）
// */
//package jsys.sales.test;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//import jsys.sales.dao.ConnectionManager;
//import jsys.sales.dao.CustomerDAO;
//import jsys.sales.entity.Customer;
//
//public class TestCustomerDAO01_29 {
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		Connection con = null;
//
//		// テストのための準備としてデータベースに接続する。
//
//		try {
//			con = ConnectionManager.getConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		// ここからテストを行う。
//		try {
//
//			CustomerDAO custDAO = new CustomerDAO(con);
//
//			Customer customer = new Customer();
//
//			custDAO.updateCustomer("Sストア","0451283581","","","2200001","","横浜市西区北幸2-1","","0");
//
//		} catch (SQLException e) {
//			System.out.println("SQLExceptionがスローされました。");
//			e.printStackTrace();
//		} finally {
//			try {// データベースへの接続を切断する
//				if (con != null) {
//					con.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//
//
//	}
//
//}
