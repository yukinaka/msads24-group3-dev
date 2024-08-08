/**
 * @author J08_中井俊（2024/8/8）
 */
package jsys.sales.test;

import java.sql.Connection;
import java.sql.SQLException;
import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.CustomerDAO;

public class TestCustomerDAO01_27 {

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

			String custCode = "KA9999";
			boolean boolean1 = custDAO.restCustomer(custCode);

			System.out.println("戻り値：" + boolean1);



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
