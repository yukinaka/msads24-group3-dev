/**
 * @author J22_油井清子（2024/8/7）
 */
package jsys.sales.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jsys.sales.entity.ProductSummary;

/**
 * 商品別受注集計テーブルの情報を操作する
 */
public class ProductSummaryDAO {

	/* メンバ変数 */
	private Connection con;

	/**
	 * @param con DB接続用のConnectionオブジェクト
	 */
	public ProductSummaryDAO(Connection con) {
		this.con = con;
	}

	/**
	 *
	 * @param　custCode 得意先コード
	 * @return 実行結果
	 * @throws SQLException データベースエラー
	 */

	public ArrayList<ProductSummary> productOrderSummary(String custCode) throws SQLException {

		String sql ="select order_details.item_code, item.item_name, sum(order_details.order_num) as total_num, item.price "
				+ "from orders inner join ( order_details inner join item on order_details.item_code = item.item_code ) on orders.order_no = order_details.order_no "
				+ "where orders.customer_code = ? "
				+ "group by order_details.item_code;";

		PreparedStatement stmt = null;
		ResultSet res = null;
		ArrayList<ProductSummary> productSummaryList = null;

		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1,custCode);

			res = stmt.executeQuery();
			ProductSummary productSummary=null;

			while (res.next()) {
				if(productSummaryList==null) {
					productSummaryList = new ArrayList<>();
				}
				productSummary = new ProductSummary();
				productSummary.setItemCode(res.getString("item_code"));
				productSummary.setItemName(res.getString("item_name"));
				productSummary.setItemPrice(res.getInt("price"));
				productSummary.setTotalNum(res.getInt("total_num"));

				productSummaryList.add(productSummary);
			}
		} finally {

			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return productSummaryList;
	}
}
