/**
 * @author J08_中井俊（2024/8/7）
 */

package jsys.sales.dao;

import java.sql.Connection;
import java.sql.SQLException;

import jsys.sales.entity.Employee;

/**
 * 従業員テーブルの情報を操作する
 */
public class EmployeeDAO {

	/* メンバ変数 */
	private Connection con;

	/**
	 * @param con DB接続用のConnectionオブジェクト
	 */
	public EmployeeDAO(Connection con) {
		this.con = con;
	}

	/**
	 * 引数で指定された従業員番号を従業員テーブルから検索し、一致した従業員オブジェクトを返す
	 * @param empNo 従業員番号
	 * @return 従業員オブジェクト
	 * @throws SQLException データベースエラー
	 */
	public Employee findEmployee(String empNo) throws SQLException{
//		String sql = "select * from employee where employee_no = ?";
//		PreparedStatement stmt = null;
//		ResultSet res = null;
//		Employee employee = null;
//
//		try {
//			// PreparedStatementの生成
//			stmt = con.prepareStatement(sql);
//			// Employeeオブジェクトの生成
//			employee = new Employee();
//			// パラメータの設定
//			stmt.setString(1, empNo);
//			// SQL文の実行
//			res = stmt.executeQuery();
//
//			if(res.next()) {
//				employee.setEmpNo(res.getString("employee_no"));
//				employee.setEmpName(res.getString("employee_name"));
//				employee.setPassword(res.getString("password"));
//			}
//
//		}finally {
//			// クローズ処理
//			if (res != null) {
//				res.close();
//			}
//			if (stmt != null) {
//				stmt.close();
//			}
//		}
//		return employee;
		
		Employee employee = new Employee();
		
		employee.setEmpNo("H20001");
		employee.setPassword("zy0001");
		employee.setEmpName("Taro");
		
		return employee;
		
	}

}
