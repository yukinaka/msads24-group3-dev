/**
 * @author J05_田中勇起（2024/8/7）
 */
package jsys.sales.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.ProductSummaryDAO;
import jsys.sales.entity.ProductSummary;

public class TestProductSummaryDAO01_02 {

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
			ProductSummaryDAO productSummaryDAO = new ProductSummaryDAO(con);

			String custCode = "KA9999";

			ArrayList<ProductSummary> productSummaryList = productSummaryDAO.productOrderSummary(custCode);

			if (productSummaryList==null) {
				System.out.println("戻り値：" + productSummaryList);

			} else {
				for (ProductSummary periodSummary : productSummaryList) {

					System.out.println("商品コード：" + periodSummary.getItemCode());
					System.out.println("商品名　　：" + periodSummary.getItemName());
					System.out.println("合計数量　：" + periodSummary.getTotalNum());
					System.out.println("単価　　　：" + periodSummary.getItemPrice());
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
