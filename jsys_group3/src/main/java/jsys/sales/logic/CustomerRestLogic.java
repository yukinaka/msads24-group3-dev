/**
 * @author J22_油井清子（2024/8/8）
 */
package jsys.sales.logic;
import java.sql.Connection;
import java.sql.SQLException;
import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.CustomerDAO;

/**
 * 得意先復元ロジック
 */
public class CustomerRestLogic {
	/**
	 * コンストラクタ(引数なし)
	 */
	public CustomerRestLogic() {

	}

	/**
	 * 引数で指定された得意先コードの得意先情報を復元する
	 * @param custCode 得意先コード
	 * @throws SalesBusinessException 業務エラー
	 * @throws SalesSystemException システムエラー
	 */
	public void restCustomer(String custCode)
			throws SalesBusinessException, SalesSystemException {
		Connection con = null;
		boolean result = false;

		try {
			con = ConnectionManager.getConnection();
			// DAOを生成し、メソッドを呼び出す
			CustomerDAO customerDAO = new CustomerDAO(con);
			result = customerDAO.restCustomer(custCode);

			if(!result) {
				throw new SalesSystemException("システムエラーが発生しました。");
			}

		}catch(SQLException e) {
			throw new SalesSystemException("システムエラーが発生しました。");

		}finally {

			try {
				if(con != null) {
					con.close();
				}
			}catch(SQLException e) {
				throw new SalesSystemException("システムエラーが発生しました。");
			}
		}
	}
}
