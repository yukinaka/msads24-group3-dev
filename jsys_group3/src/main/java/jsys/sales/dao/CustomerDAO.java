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

		String sql = "INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?,?,false,?)";
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement(sql);

			stmt.setString(1, customer.getCustCode());
			stmt.setString(2, customer.getCustName());
			stmt.setString(3, customer.getTelNo1());
			stmt.setString(4, customer.getTelNo2());
			stmt.setString(5, customer.getTelNo3());
			stmt.setString(6, customer.getPostalCode1());
			stmt.setString(7, customer.getAddress1());
			stmt.setString(8, customer.getPostalCode2());
			stmt.setString(9, customer.getAddress2());
			stmt.setInt(10, customer.getDiscountRate());
			stmt.setString(11, customer.getLastUpdateBy());

			int count = stmt.executeUpdate();

			/*登録完了判断*/
			if(count == 1) {
				return true;
			}

		}finally {

			if(stmt != null) {
				stmt.close();
			}

		}

		return false;
	}

	/**
	 * 得意先テーブルに存在する全ての得意先情報を検索し、得意先オブジェクトをArrayListに格納して返す
	 * @return 得意先オブジェクトが格納されたArrayList
	 * @throws SQLException データベースエラー
	 */
	public ArrayList<Customer> findAllCustomer() throws SQLException {

		String sql = "select * from customer";
		PreparedStatement stmt = null;
		ResultSet res = null;
		ArrayList<Customer> customerList = null;
		Customer customer = null;

		try {

			stmt = con.prepareStatement(sql);
			res = stmt.executeQuery();


			/*検索結果格納ループ*/
			while(res.next()) {
				if (customerList==null) {
					customerList = new ArrayList<>();
				}

				customer = new Customer();

				customer.setCustCode(res.getString("customer_code"));
				customer.setCustName(res.getString("customer_name"));
				customer.setTelNo1(res.getString("customer_telno1"));
				customer.setTelNo2(res.getString("customer_telno2"));
				customer.setTelNo3(res.getString("customer_telno3"));
				customer.setPostalCode1(res.getString("customer_postalcode1"));
				customer.setAddress1(res.getString("customer_address1"));
				customer.setPostalCode2(res.getString("customer_postalcode2"));
				customer.setAddress2(res.getString("customer_address2"));
				customer.setDiscountRate(res.getInt("discount_rate"));
				customer.setDeleteFlag(res.getBoolean("delete_flag"));
				customer.setLastUpdateBy(res.getString("last_update_by"));

				customerList.add(customer);

			}

		}finally {

			if(res != null) {
				res.close();
			}
			if(stmt != null) {
				stmt.close();
			}

		}

		return customerList;

	}

	/**
	 * 引数で指定された得意先コードをもとに得意先テーブルから該当する得意先情報をあいまい検索し、一致した得意先オブジェクトをArrayListに格納して返す
	 * @param custCode 得意先コード
	 * @return 得意先オブジェクトが格納されたArrayList
	 * @throws SQLException データベースエラー
	 */
	public ArrayList<Customer> findCustomerByCode(String custCode) throws SQLException {

		String sql = "select * from customer where customer_code like ?";
		PreparedStatement stmt = null;
		ResultSet res = null;
		ArrayList<Customer> customerList = null;
		Customer customer = null;

		try {

			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + custCode + "%");
			res = stmt.executeQuery();


			/*検索結果格納ループ*/
			while(res.next()) {
				if (customerList==null) {
					customerList = new ArrayList<>();
				}

				customer = new Customer();

				customer.setCustCode(res.getString("customer_code"));
				customer.setCustName(res.getString("customer_name"));
				customer.setTelNo1(res.getString("customer_telno1"));
				customer.setTelNo2(res.getString("customer_telno2"));
				customer.setTelNo3(res.getString("customer_telno3"));
				customer.setPostalCode1(res.getString("customer_postalcode1"));
				customer.setAddress1(res.getString("customer_address1"));
				customer.setPostalCode2(res.getString("customer_postalcode2"));
				customer.setAddress2(res.getString("customer_address2"));
				customer.setDiscountRate(res.getInt("discount_rate"));
				customer.setDeleteFlag(res.getBoolean("delete_flag"));
				customer.setLastUpdateBy(res.getString("last_update_by"));

				customerList.add(customer);

			}

		}finally {

			if(res != null) {
				res.close();
			}
			if(stmt != null) {
				stmt.close();
			}

		}

		return customerList;

	}

	/**
	 * 引数で指定された得意先名をもとに得意先テーブルから該当する得意先情報をあいまい検索し、一致した得意先オブジェクトをArrayListに格納して返す
	 * @param custName 得意先名
	 * @return 得意先オブジェクトが格納されたArrayList
	 * @throws SQLException データベースエラー
	 */
	public ArrayList<Customer> findCustomerByName(String custName) throws SQLException {

		String sql = "select * from customer where customer_name like ?";
		PreparedStatement stmt = null;
		ResultSet res = null;
		ArrayList<Customer> customerList = null;
		Customer customer = null;

		try {

			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + custName + "%");
			res = stmt.executeQuery();


			/*検索結果格納ループ*/
			while(res.next()) {
				if (customerList==null) {
					customerList = new ArrayList<>();
				}

				customer = new Customer();

				customer.setCustCode(res.getString("customer_code"));
				customer.setCustName(res.getString("customer_name"));
				customer.setTelNo1(res.getString("customer_telno1"));
				customer.setTelNo2(res.getString("customer_telno2"));
				customer.setTelNo3(res.getString("customer_telno3"));
				customer.setPostalCode1(res.getString("customer_postalcode1"));
				customer.setAddress1(res.getString("customer_address1"));
				customer.setPostalCode2(res.getString("customer_postalcode2"));
				customer.setAddress2(res.getString("customer_address2"));
				customer.setDiscountRate(res.getInt("discount_rate"));
				customer.setDeleteFlag(res.getBoolean("delete_flag"));
				customer.setLastUpdateBy(res.getString("last_update_by"));

				customerList.add(customer);

			}

		}finally {

			if(res != null) {
				res.close();
			}
			if(stmt != null) {
				stmt.close();
			}

		}

		return customerList;

	}

	/**
	 * 引数で指定された得意先名をもとに得意先テーブルから該当する得意先情報を完全一致検索し、一致した得意先オブジェクトを返す
	 * @param custName 得意先名
	 * @return 得意先オブジェクト
	 * @throws SQLException データベースエラー
	 */
	public Customer findCustomerByUniqueName(String custName) throws SQLException {

		String sql = "select * from customer where customer_name = ?";
		PreparedStatement stmt = null;
		ResultSet res = null;
		Customer customer = null;

		try {

			stmt = con.prepareStatement(sql);
			stmt.setString(1, custName);
			res = stmt.executeQuery();

			if(res.next()) {

				customer = new Customer();

				customer.setCustCode(res.getString("customer_code"));
				customer.setCustName(res.getString("customer_name"));
				customer.setTelNo1(res.getString("customer_telno1"));
				customer.setTelNo2(res.getString("customer_telno2"));
				customer.setTelNo3(res.getString("customer_telno3"));
				customer.setPostalCode1(res.getString("customer_postalcode1"));
				customer.setAddress1(res.getString("customer_address1"));
				customer.setPostalCode2(res.getString("customer_postalcode2"));
				customer.setAddress2(res.getString("customer_address2"));
				customer.setDiscountRate(res.getInt("discount_rate"));
				customer.setDeleteFlag(res.getBoolean("delete_flag"));
				customer.setLastUpdateBy(res.getString("last_update_by"));

			}

		}finally {

			if(res != null) {
				res.close();
			}
			if(stmt != null) {
				stmt.close();
			}

		}

		return customer;
	}

	/**
	 * 引数で指定された得意先コードに完全一致する得意先情報を得意先テーブルから論理削除する
	 * @param custCode 得意先コード
	 * @return 実行結果
	 * @throws SQLException データベースエラー
	 */
	public boolean deleteCustomer(String custCode) throws SQLException {

		String sql = "update customer set delete_flag = true where customer_code = ?";
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement(sql);
			stmt.setString(1, custCode);
			int count = stmt.executeUpdate();

			/*削除完了判断*/
			if(count == 1) {
				return true;
			}

		}finally {

			if(stmt != null) {
				stmt.close();
			}

		}

		return false;

	}

	/**
	 * 引数で指定された得意先コードに完全一致する得意先情報を得意先テーブルから論理復元する
	 * @param custCode 得意先コード
	 * @return 実行結果
	 * @throws SQLException データベースエラー
	 */
	public boolean restCustomer(String custCode) throws SQLException {
		String sql = "update customer set delete_flag = false where customer_code = ?";
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement(sql);
			stmt.setString(1, custCode);
			int count = stmt.executeUpdate();

			/*削除完了判断*/
			if(count == 1) {
				return true;
			}

		}finally {

			if(stmt != null) {
				stmt.close();
			}

		}

		return false;

	}

	/**
	 * 引数で指定された得意先オブジェクトをもとに、既に得意先テーブルに登録されている得意先情報を更新する
	 * @param customer 得意先オブジェクト
	 * @return 実行結果
	 * @throws SQLException データベースエラー
	 */
	public boolean updateCustomer(Customer customer) throws SQLException {

		String sql = "update customer set customer_name = ?,"
				+ " customer_telno1 = ?, customer_telno2 = ?, customer_telno3 = ?,"
				+ " customer_postalcode1 = ?, customer_address1 = ?, customer_postalcode2 = ?, customer_address2 = ?,"
				+ " discount_rate = ?, delete_flag = ?, last_update_by = ?"
				+ " where customer_code = ?";
		PreparedStatement stmt = null;

		try {

			stmt = con.prepareStatement(sql);

			stmt.setString(1, customer.getCustName());
			stmt.setString(2, customer.getTelNo1());
			stmt.setString(3, customer.getTelNo2());
			stmt.setString(4, customer.getTelNo3());
			stmt.setString(5, customer.getPostalCode1());
			stmt.setString(6, customer.getAddress1());
			stmt.setString(7, customer.getPostalCode2());
			stmt.setString(8, customer.getAddress2());
			stmt.setInt(9, customer.getDiscountRate());
			stmt.setBoolean(10, customer.isDeleteFlag());
			stmt.setString(11, customer.getLastUpdateBy());
			stmt.setString(12, customer.getCustCode());

			int count = stmt.executeUpdate();

			/*更新完了判断*/
			if(count == 1) {
				return true;
			}

		}finally {

			if(stmt != null) {
				stmt.close();
			}

		}

		return false;

	}

}
