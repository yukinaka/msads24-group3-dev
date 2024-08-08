/**
 * @author J08_中井俊（2024/8/7）
 */

package jsys.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jsys.sales.entity.Employee;

/**
 * 従業員DAO
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
	 * 引数で指定された得意先オブジェクトの情報を得意先テーブルに登録する
	 * @param empNo 従業員番号
	 * @return employee　データベースの値を持つオブジェクト
	 * @throws SQLException データベースエラー
	 */
	public Employee findEmployee(String empNo) throws SQLException{
		String sql = "select * from employee where employee_no = ?";
		PreparedStatement stmt = null;
		ResultSet res = null;
		Employee employee = null;

		try {
			// PreparedStatementの生成
			stmt = con.prepareStatement(sql);
			// Employeeオブジェクトの生成
			employee = new Employee();
			// パラメータの設定
			stmt.setString(1, empNo);
			// SQL文の実行
			res = stmt.executeQuery();

			if(res.next()) {
				employee.setEmpNo(res.getString("employee_no"));
				employee.setEmpName(res.getString("employee_name"));
				employee.setPassword(res.getString("password"));
			}

		}finally {
			// クローズ処理
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return employee;
	}

}
