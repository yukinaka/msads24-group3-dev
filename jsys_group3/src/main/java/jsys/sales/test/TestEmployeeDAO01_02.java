/**
 * @author J28_木場厚汰（2024/8/8）
 */
package jsys.sales.test;

import java.sql.Connection;
import java.sql.SQLException;

import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.EmployeeDAO;
import jsys.sales.entity.Employee;

public class TestEmployeeDAO01_02 {

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
			EmployeeDAO  empDAO = new EmployeeDAO(con);

			Employee employee = new Employee();

			employee.setEmpNo("H20001");
			employee.setEmpName("安藤直也");
			employee.setPassword("zy0001");
			Employee findEmployee = empDAO.findEmployee("H99999");

			System.out.println("戻り値：" + findEmployee.getEmpNo());
			System.out.println("戻り値：" + findEmployee.getEmpName());
			System.out.println("戻り値：" + findEmployee.getPassword());


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
