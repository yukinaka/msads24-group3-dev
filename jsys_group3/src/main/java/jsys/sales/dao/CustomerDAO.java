/**
 * @author J05_田中勇起（2024/8/6）
 */

package jsys.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jsys.sales.entity.Customer;

/**
 * 得意先テーブルの情報を操作する
 */
public class CustomerDAO {

	/* メンバ変数 */
	private Connection con;

	/**
	 * @param con DB接続用のConnectionオブジェクト
	 */
	public CustomerDAO(Connection con) {
		this.con = con;
	}

	/**
	 * 引数で指定された得意先オブジェクトの情報を得意先テーブルに登録する
	 * @param customer 得意先オブジェクト
	 * @return 実行結果
	 * @throws SQLException データベースエラー
	 */
	public boolean insertCustomer(Customer customer) throws SQLException {
		return true;
	}

	/**
	 * 得意先テーブルに存在する全ての得意先情報を検索し、得意先オブジェクトをArrayListに格納して返す
	 * @return 得意先オブジェクトが格納されたArrayList
	 * @throws SQLException データベースエラー
	 */
	public ArrayList<Customer> findAllCustomer() throws SQLException {
		return null;
	}

	/**
	 * 引数で指定された得意先コードをもとに得意先テーブルから該当する得意先情報をあいまい検索し、一致した得意先オブジェクトをArrayListに格納して返す
	 * @param custCode
	 * @return 得意先オブジェクトが格納されたArrayList
	 * @throws SQLException データベースエラー
	 */
	public ArrayList<Customer> findCustomerByCode(String custCode) throws SQLException {
		return null;
	}

	/**
	 * 引数で指定された得意先名をもとに得意先テーブルから該当する得意先情報をあいまい検索し、一致した得意先オブジェクトをArrayListに格納して返す
	 * @param custName
	 * @return 得意先オブジェクトが格納されたArrayList
	 * @throws SQLException データベースエラー
	 */
	public ArrayList<Customer> findCustomerByName(String custName) throws SQLException {
		return null;
	}

	/**
	 * 引数で指定された得意先名をもとに得意先テーブルから該当する得意先情報を完全一致検索し、一致した得意先オブジェクトを返す
	 * @param custName
	 * @return 得意先オブジェクト
	 * @throws SQLException データベースエラー
	 */
	public Customer findCustomerByUniqueName(String custName) throws SQLException {
		return null;
	}

	/**
	 * 引数で指定された得意先コードに完全一致する得意先情報を得意先テーブルから論理削除する
	 * @param custCode
	 * @return 実行結果
	 * @throws SQLException データベースエラー
	 */
	public boolean deleteCustomer(String custCode) throws SQLException {
		return true;
	}

	/**
	 * 引数で指定された得意先コードに完全一致する得意先情報を得意先テーブルから論理復元する
	 * @param custCode
	 * @return 実行結果
	 * @throws SQLException データベースエラー
	 */
	public boolean restCustomer(String custCode) throws SQLException {
		return true;
	}

	/**
	 * 引数で指定された得意先オブジェクトをもとに、既に得意先テーブルに登録されている得意先情報を更新する
	 * @param customer 得意先オブジェクト
	 * @return 実行結果
	 * @throws SQLException データベースエラー
	 */
	public boolean updateCustomer(Customer customer) throws SQLException {
		return true;
	}

//	/**
//	 * 引数で指定された得意先コードをもとに得意先テーブルから該当する得意先情報をあいまい検索し、ArrayList一致する得意先を1件検索する
//	 * @param custCode 得意先コード
//	 * @return 得意先オブジェクト
//	 * @throws SQLException SQLException
//	 */
//	 public Customer findCustomer(String custCode) throws SQLException {
//
//		String sql = "SELECT customer_code, customer_name, customer_telno, customer_postalcode, customer_address, discount_rate, delete_flag "
//				+ "FROM customer WHERE customer_code = ?";
//		PreparedStatement stmt = null;
//		ResultSet res = null;
//		Customer object = null;
//
//		/**
//		 * try-catch
//		 */
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, custCode);
//			res = stmt.executeQuery();
//
//			if (res.next() && !res.getBoolean("delete_flag")) {
//
//				object = new Customer(
//						res.getString("customer_code"),
//						res.getString("customer_name"),
//						res.getString("customer_telno"),
//						res.getString("customer_postalcode"),
//						res.getString("customer_address"),
//						res.getInt("discount_rate"));
//			}
//
//		} finally {
//			if (res!=null) res.close();
//			if (stmt!=null) stmt.close();
//		}
//
//		return object;
//
//	}



}
