/**
 * @author J28_木場厚汰（2024/8/8）
 */
package jsys.sales.test;

import java.sql.Connection;
import java.sql.SQLException;

import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.CustomerDAO;
import jsys.sales.entity.Customer;

public class TestCustomerDAO01_30 {

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

//			customer.setCustName("Sストア");
			customer.setTelNo1("0451283581");
			customer.setTelNo2("");
			customer.setTelNo3("");
			customer.setPostalCode1("2200001");
			customer.setAddress1("");
			customer.setPostalCode2("");
			customer.setAddress2("横浜市西区北幸2-1");
			customer.setDiscountRate(0);
			customer.setDeleteFlag(false);
			customer.setLastUpdateBy("H20001");
			customer.setCustCode("KA0100");

			boolean result = custDAO.updateCustomer(customer);

			System.out.println("戻り値:"+result);

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
