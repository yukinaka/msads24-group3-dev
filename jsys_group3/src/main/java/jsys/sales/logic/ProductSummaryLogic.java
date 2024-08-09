/**
 * @author J011_宮澤奈保子（2024/8/7）
 */
package jsys.sales.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.ProductSummaryDAO;
import jsys.sales.entity.ProductSummary;

/**
 * 商品別受注集計ロジック
 */
public class ProductSummaryLogic {

	public ArrayList<ProductSummary> productOrderSummary(String custCode) throws SalesBusinessException, SalesSystemException {

		Connection con = null;
		ArrayList<ProductSummary> productSummaryList = null;

		try {

			con = ConnectionManager.getConnection();
			ProductSummaryDAO productSummaryDAO = new ProductSummaryDAO(con);

			productSummaryList = productSummaryDAO.productOrderSummary(custCode);

			/*集計結果判断*/
			if(productSummaryList == null) {

				throw new SalesBusinessException("選択された得意先の受注情報は存在しません。");

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

		return productSummaryList;

	}

	/**
	 * 引数で指定された商品別合計金額の総計を計算する。
	 * @param productSummaryList 商品別受注集計リスト
	 */
	public int productSummaryTotal(ArrayList<ProductSummary> productSummaryList) {

		int total = 0;

		/*総計計算ループ*/
		for(int i = 0; i < productSummaryList.size(); i++) {

			total = total + productSummaryList.get(i).getTotalPricePerItem();

		}

		return total;

	}

}
