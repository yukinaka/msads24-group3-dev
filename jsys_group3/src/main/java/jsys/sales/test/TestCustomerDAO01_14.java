/**
 * @author J08_中井俊（2024/8/8）
 */
package jsys.sales.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.CustomerDAO;
import jsys.sales.entity.Customer;

public class TestCustomerDAO01_14 {

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

			String custName = "A";
			ArrayList<Customer> custList = custDAO.findCustomerByName(custName);

			if (custList == null) {
				System.out.println("戻り値：" + custList);
			} else {

				for (Customer cust : custList) {
					System.out.println("得意先名：" + cust.getCustName());
					System.out.println();
				}
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
