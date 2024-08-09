/**
 * @author J08_中井俊（2024/8/9）
 */
package jsys.sales.test;

import java.sql.Connection;
import java.sql.SQLException;import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.CustomerCodeDAO;

public class TestCustomerCodeDAO01_03 {

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
			CustomerCodeDAO custDAO = new CustomerCodeDAO(con);
			boolean custList = custDAO.updateCustomerCode(custDAO.findCustomerCode()+1);

			System.out.println(custList);

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
