package jsys.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import jsys.sales.entity.;

/**
 * 期間内受注集計テーブルの情報を操作する
 */
public class PeriodSummaryDAO {

	/* メンバ変数 */
	private Connection con;

	/**
	 * @param con DB接続用のConnectionオブジェクト
	 */
	public PeriodSummaryDAO(Connection con) {
		this.con = con;
	}

	/**
	 *
	 * @param customer 得意先オブジェクト
	 * @return 実行結果
	 * @throws SQLException データベースエラー
	 */
	public ArrayList<PeriodSummary> orderSummaryWithinPeriod(Date firstDay, Date lastDay) throws SQLException {

		String sql =


		PreparedStatement stmt = null;
		ResultSet res = null;
		Customer customer = null;

		try {
			// PreparedStatementの作成
			stmt = con.prepareStatement(sql);
			// パラメータの設定
			stmt.setString(1,custCode);

			// SQL文の実行
			res = stmt.executeQuery();
			// 結果セットから情報を取り出す
			if (res.next()) {
				// Customerオブジェクトの生成
				customer = new Customer(res.getString("customer_code"), res.getString("customer_name"),res.getString("customer_telno"), res.getString("customer_postalcode"),res.getString("customer_address"),res.getInt("discount_rate"));

			}

		} finally {
			// クローズ処理
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return customer;
	}

}
