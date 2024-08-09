/**
 * @author J011_宮澤奈保子（2024/8/7）
 */
package jsys.sales.logic;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;

import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.PeriodSummaryDAO;
import jsys.sales.entity.PeriodSummary;

/**
 * 期間内受注集計ロジック
 */
public class OrderSummaryWithinPeriodLogic {

	/**
	 * 引数で指定された期間の受注集計を行う。
	 * @param firstDay 初日
	 * @param lastDay 最終日
	 * @throws SalesBusinessException 業務エラー
	 * @throws SalesSystemException システムエラー
	 */
	public ArrayList<PeriodSummary> orderSummaryWithinPeriodLogic(Date firstDay, Date lastDay) throws SalesBusinessException, SalesSystemException {

		Connection con = null;
		ArrayList<PeriodSummary> periodSummaryList = null;

		try {

			con = ConnectionManager.getConnection();
			PeriodSummaryDAO periodSummaryDAO = new PeriodSummaryDAO(con);

			periodSummaryList = periodSummaryDAO.orderSummaryWithinPeriod(firstDay, lastDay);

			/*集計結果判断*/
			if(periodSummaryList == null) {

				throw new SalesBusinessException("選択された集計期間に該当する受注情報は存在しません。");

			}

		}catch(SQLException e) {
			throw new SalesSystemException("システムエラーが発生しました。");
		}finally {
			try {
				if (con!=null) {
					con.close();
				}
			}catch (SQLException e) {
				throw new SalesSystemException("システムエラーが発生しました。");
			}
		}

		return periodSummaryList;

	}

	/**
	 * 引数で指定された得意先別合計金額の総計を計算する。
	 * @param periodSummaryList 期間内受注集計リスト
	 */
	public int periodSummaryTotal(ArrayList<PeriodSummary> periodSummaryList) {

		int total = 0;

		/*総計計算ループ*/
		for(int i = 0; i < periodSummaryList.size(); i++) {

			total = total + periodSummaryList.get(i).getTotalPricePerCust();

		}

		return total;

	}

}
