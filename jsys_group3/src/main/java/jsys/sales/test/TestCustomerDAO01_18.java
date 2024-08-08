/**
 * @author J28_木場厚汰（2024/8/8）
 */
package jsys.sales.test;

import java.sql.Connection;
import java.sql.SQLException;

import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.CustomerDAO;
import jsys.sales.entity.Customer;

public class TestCustomerDAO01_18 {

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

			customer = custDAO.findCustomerByUniqueName("Aストア");

			System.out.println("customerの戻り値");
			System.out.println(customer.getCustCode());
			System.out.println(customer.getCustName());
			System.out.println(customer.getTelNo1());
			System.out.println(customer.getTelNo2());
			System.out.println(customer.getTelNo3());
			System.out.println(customer.getPostalCode1());
			System.out.println(customer.getAddress1());
			System.out.println(customer.getPostalCode2());
			System.out.println(customer.getAddress2());
			System.out.println(customer.getDiscountRate());
			System.out.println(customer.getLastUpdateBy());


		}catch (SQLException e) {
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
