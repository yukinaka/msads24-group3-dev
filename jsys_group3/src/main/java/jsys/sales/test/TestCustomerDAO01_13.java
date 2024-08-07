/**
 * @author J05_田中勇起（2024/8/7）
 */
package jsys.sales.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.CustomerDAO;
import jsys.sales.entity.Customer;

public class TestCustomerDAO01_13 {

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

			String custCode = "0001";
			ArrayList<Customer> custList = custDAO.findCustomerByCode(custCode);

			if (custList == null) {
				System.out.println("戻り値：" + custList);
			} else {

				for (Customer cust : custList) {
					System.out.println("得意先コード：" + cust.getCustCode());
					System.out.println("得意先名：" + cust.getCustName());
					System.out.println("電話番号１：" + cust.getTelNo1());
					System.out.println("郵便番号１：" + cust.getPostalCode1());
					System.out.println("住所１：" + cust.getAddress1());
					System.out.println("得意先コード：" + cust.getCustCode());
					System.out.println("割引率：" + cust.getDiscountRate());
					System.out.println("最終更新者：" + cust.getLastUpdateBy());
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
