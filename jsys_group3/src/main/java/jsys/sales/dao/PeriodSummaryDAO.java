/**
 * @author J22_油井清子（2024/8/7）
 */
package jsys.sales.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import jsys.sales.entity.PeriodSummary;

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
	 * 引数で指定された集計期間をもとに受注テーブル・得意先テーブルから該当する集計情報を検索し、取得した集計オブジェクトをArrayListに格納して返す
	 * @param firstDay 集計初日
	 * @param lastDay 集計最終日
	 * @return 期間内別集計オブジェクトが格納されたArrayList
	 * @throws SQLException データベースエラー
	 */
	public ArrayList<PeriodSummary> orderSummaryWithinPeriod(Date firstDay, Date lastDay) throws SQLException {

//		String sql ="select orders.customer_code, customer.customer_name, SUM(orders.total_price) as total_price "
//				+ "from orders inner join customer on orders.customer_code = customer.customer_code "
//				+ "where orders.order_date between ? and ? "
//				+ "group by customer_code;";
//
//		PreparedStatement stmt = null;
//		ResultSet res = null;
//		ArrayList<PeriodSummary> periodSummaryList = null;
//
//		try {
//			stmt = con.prepareStatement(sql);
//
//			stmt.setDate(1,firstDay);
//			stmt.setDate(2,lastDay);
//
//			res = stmt.executeQuery();
//			PeriodSummary periodSummary=null;
//
//			while (res.next()) {
//				if (periodSummaryList==null) {
//					periodSummaryList = new ArrayList<>();
//				}
//				periodSummary = new PeriodSummary();
//				periodSummary.setCustCode(res.getString("customer_code"));
//				periodSummary.setCustName(res.getString("customer_name"));
//				periodSummary.setTotalPricePerCust(res.getInt("total_price"));
//
//				periodSummaryList.add(periodSummary);
//			}
//
//		} finally {
//
//			if (res != null) {
//				res.close();
//			}
//			if (stmt != null) {
//				stmt.close();
//			}
//		}
//		return periodSummaryList;
		
		ArrayList<PeriodSummary> periodSummaryList = new ArrayList<>();
		
		for (int i=1; i<=10; i++) {
			
			PeriodSummary periodSummary = new PeriodSummary();
			periodSummary.setCustCode(String.format("KA%04d", i));
			periodSummary.setCustName("ストア" + i);
			periodSummary.setTotalPricePerCust(300000);

			periodSummaryList.add(periodSummary);
		}
		
		return periodSummaryList;
		
	}
}
