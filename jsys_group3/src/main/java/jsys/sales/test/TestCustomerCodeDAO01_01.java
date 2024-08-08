/**
 * @author J08_中井俊（2024/8/8）
 */
package jsys.sales.test;

import java.sql.Connection;
import java.sql.SQLException;import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.CustomerCodeDAO;

public class TestCustomerCodeDAO01_01 {

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
			int custList = custDAO.findCustomerCode();

			if (custList == 0) {
				System.out.println("戻り値：" + custList);
			} else {
				System.out.println("得意先コード：" + custList);
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
