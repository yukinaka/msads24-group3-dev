/**
 * @author J05_田中勇起（2024/8/7）
 */
package jsys.sales.test;

import java.sql.Connection;
import java.sql.SQLException;

import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.CustomerDAO;
import jsys.sales.entity.Customer;

public class TestCustomerDAO01_02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection con = null;

		// テストのための準備としてデータベースに接続する。

		try {
			con = ConnectionManager.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ここからテストを行う。
		try {
			CustomerDAO custDAO = new CustomerDAO(con);

			Customer customer = new Customer();

			customer.setCustCode("KA0100");
//			customer.setCustName("Sストア");
			customer.setTelNo1("045-128-3581");
			customer.setPostalCode1("220-0001");
			customer.setAddress1("横浜市西区北幸2-1");
			customer.setDiscountRate(0);

			boolean result = custDAO.insertCustomer(customer);

			System.out.println("戻り値：" + result);

		} catch (SQLException e) {
			System.out.println("SQLExceptionがスローされました。");
			e.printStackTrace();
		} finally {
			try {// データベースへの接続を切断する
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
