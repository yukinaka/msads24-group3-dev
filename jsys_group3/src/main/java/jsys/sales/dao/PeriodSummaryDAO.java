/**
 * @author J22_油井清子（2024/8/7）
 */
package jsys.sales.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
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
	 *
	 * @param　firstDay, firstDay				//***********************************************
	 * @return 実行結果
	 * @throws SQLException データベースエラー
	 */
	public ArrayList<PeriodSummary> orderSummaryWithinPeriod(Date firstDay, Date lastDay) throws SQLException {

		String sql ="select orders.customer_code, customer.customer_name, SUM(orders.total_price) as total_price "
				+ "from orders inner join customer on orders.customer_code = customer.customer_code "
				+ "where orders.order_date between ? and ? "
				+ "group by customer_code;";

		PreparedStatement stmt = null;
		ResultSet res = null;
		ArrayList<PeriodSummary> periodSummaryList = null;

		try {
			stmt = con.prepareStatement(sql);

			stmt.setDate(1,firstDay);
			stmt.setDate(2,lastDay);

			res = stmt.executeQuery();
			PeriodSummary periodSummary=null;

			while (res.next()) {
				if (periodSummaryList==null) {
					periodSummaryList = new ArrayList<>();
				}
				periodSummary = new PeriodSummary();
				periodSummary.setCustCode(res.getString("customer_code"));
				periodSummary.setCustName(res.getString("customer_name"));
				periodSummary.setTotalPricePerCust(res.getInt("total_price"));

				periodSummaryList.add(periodSummary);
			}

		} finally {

			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return periodSummaryList;
	}
}
