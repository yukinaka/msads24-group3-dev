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
import jsys.sales.entity.Customer;

/**
 * 得意先変更ロジック
 */
public class CustomerUpdateLogic {

	/**
	 * コンストラクタ(引数なし)
	 */
	public CustomerUpdateLogic() {

	}

	/**
	 * 引数で指定された得意先名が重複していないかチェックする。
	 * @param customer 得意先オブジェクト
	 * @throws SalesBusinessException 業務エラー
	 * @throws SalesSystemException システムエラー
	 */
	public void checkCustomer(Customer customer) throws SalesBusinessException, SalesSystemException {

		String name;
		Connection con = null;
		Customer findCustomer = null;

		name = customer.getCustName();

		try {

			con = ConnectionManager.getConnection();

			//得意先名の検索
			CustomerDAO customerDAO = new CustomerDAO(con);
			findCustomer = customerDAO.findCustomerByUniqueName(name);

			/*得意先名重複判断*/
			if(findCustomer != null) {

				if (!findCustomer.getCustCode().equals(customer.getCustCode())) {
					throw new SalesBusinessException("その得意先名は既に登録されています。");
				}

			}

		}catch(SQLException e) {
			e.printStackTrace();

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

	/**
	 * 引数で指定された得意先コードの得意先情報を変更する
	 * @param custCode 得意先コード
	 * @throws SalesSystemException システムエラー
	 */
	public void updateCustomer(Customer customer)
			throws SalesSystemException {
		Connection con = null;
		boolean result = false;

		try {
			con = ConnectionManager.getConnection();
			// DAOを生成し、メソッドを呼び出す
			CustomerDAO customerDAO = new CustomerDAO(con);
			result = customerDAO.updateCustomer(customer);

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
