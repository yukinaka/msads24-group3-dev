/**
 * @author J011_宮澤奈保子（2024/8/7）
 */
package jsys.sales.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 得意先採番テーブルの情報を操作する
 */
public class CustomerCodeDAO {

	/* メンバ変数 */
	private Connection con;

	/**
	 * @param con DB接続用のConnectionオブジェクト
	 */
	public CustomerCodeDAO(Connection con) {
		this.con = con;
	}

	/**
	 * 得意先に割り当てるコードを取得する。
	 * @return 得意先採番コード
	 * @throws SQLException データベースエラー
	 */
	public int findCustomerCode() throws SQLException {

//		String sql = "select customer_code from customer_numbering";
//		PreparedStatement stmt = null;
//		ResultSet res = null;
//		int customerCode = 0;
//
//		try {
//
//			stmt = con.prepareStatement(sql);
//			res = stmt.executeQuery();
//
//			/*検索結果判断*/
//			if(res.next()) {
//				customerCode = res.getInt("customer_code");
//			}
//
//		}finally {
//
//			if(res != null) {
//				res.close();
//			}
//			if(stmt != null) {
//				stmt.close();
//			}
//
//		}
//
//		return customerCode;
		
		return 15;

	}

	/**
	 * 得意先に割り当てるコードを更新する。
	 * @param customerCode 得意先採番コード
	 * @return 実行結果
	 * @throws SQLException データベースエラー
	 */
	public boolean updateCustomerCode(int customerCode) throws SQLException {

//		String sql = "update customer_numbering set customer_code= ?";
//		PreparedStatement stmt = null;
//
//		try {
//
//			stmt = con.prepareStatement(sql);
//			stmt.setInt(1, customerCode);
//			int count = stmt.executeUpdate();
//
//			/*検索結果判断*/
//			if(count == 1) {
//				return true;
//			}
//
//		}finally {
//
//			if(stmt != null) {
//				stmt.close();
//			}
//
//		}
//
//		return false;
		
		return true;

	}

}
