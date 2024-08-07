/**
 * @author J05_田中勇起（2024/8/7）
 */
package jsys.sales.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.PeriodSummaryDAO;
import jsys.sales.entity.PeriodSummary;

import java.sql.Date;

public class TestPeriodSummaryDAO01_01 {

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
			PeriodSummaryDAO periodSummaryDAO = new PeriodSummaryDAO(con);

			Date firstDay = new Date(2022-1900, 0, 1);
			Date lastDay = new Date(2022-1900, 2, 31);

			ArrayList<PeriodSummary> periodSummaryList = periodSummaryDAO.orderSummaryWithinPeriod(firstDay, lastDay);

			if (periodSummaryList==null) {
				System.out.println("戻り値：" + periodSummaryList);

			} else {
				for (PeriodSummary periodSummary : periodSummaryList) {

					System.out.println("得意先コード　　：" + periodSummary.getCustCode());
					System.out.println("得意先名　　　　：" + periodSummary.getCustName());
					System.out.println("得意先別合計金額：" + periodSummary.getTotalPricePerCust());
					System.out.println();
				}

			}

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
