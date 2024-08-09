/**
 * @author J11_宮澤奈保子（2024/8/9）
 */
package jsys.sales.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.CustomerDAO;
import jsys.sales.entity.Customer;

public class TestCustomerDAO02_01 {

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

			ArrayList<Customer> customerList = custDAO.findAllCustomer("dft");

			System.out.println("戻り値：");

			for(int i = 0; i < customerList.size(); i++) {

				System.out.print(customerList.get(i).getCustCode() + "　");
				System.out.print(customerList.get(i).getCustName() + "　");
				System.out.print(customerList.get(i).getTelNo1() + "　");
				System.out.print(customerList.get(i).getPostalCode1() + "　");
				System.out.print(customerList.get(i).getAddress1() + "　");
				System.out.print(customerList.get(i).getDiscountRate() + "　");
				System.out.println(customerList.get(i).getLastUpdateBy());

			}

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
