/**
 * @author J11_宮澤奈保子（2024/8/8）
 */
package jsys.sales.logic;

import java.sql.Connection;
import java.sql.SQLException;

import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.CustomerDAO;

/**
 * 得意先削除ロジック
 */
public class CustomerDeleteLogic {

	/**
	 * コンストラクタ(引数なし)
	 */
	public CustomerDeleteLogic() {

	}

	/**
	 * 引数で指定された得意先コードの得意先を削除する
	 * @param custCode 得意先コード
	 * @throws SalesBusinessException 業務エラー
	 * @throws SalesSystemException システムエラー
	 */
	public void deleteCustomer(String custCode) throws SalesBusinessException, SalesSystemException {

		Connection con = null;
		boolean result = false;

		try {

			con = ConnectionManager.getConnection();

			CustomerDAO customerDAO = new CustomerDAO(con);
			result = customerDAO.deleteCustomer(custCode);

			//削除完了判断
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
