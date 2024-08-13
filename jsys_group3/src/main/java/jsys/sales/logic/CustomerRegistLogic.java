/**
 * @author J11_宮澤奈保子（2024/8/8）
 */
package jsys.sales.logic;

import java.sql.Connection;
import java.sql.SQLException;

import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.CustomerCodeDAO;
import jsys.sales.dao.CustomerDAO;
import jsys.sales.entity.Customer;

/**
 * 得意先登録ロジック
 */
public class CustomerRegistLogic {

	/**
	 * コンストラクタ(引数なし)
	 */
	public CustomerRegistLogic() {

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

				throw new SalesBusinessException("その得意先名は既に登録されています。");

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
	 * 引数で指定された得意先オブジェクトの情報を得意先テーブルに登録する。
	 * @param customer 得意先オブジェクト
	 * @throws SalesSystemException システムエラー
	 */
	public void insertCustomer(Customer customer) throws SalesSystemException {

		Connection con = null;
		int custCode = 0;
		boolean result = false;

		try {

			con = ConnectionManager.getConnection();
			con.setAutoCommit(false);

			//得意先コードの取得
			CustomerCodeDAO customerCodeDAO = new CustomerCodeDAO(con);
			custCode = customerCodeDAO.findCustomerCode();

			customer.setCustCode(String.format("KA%04d", custCode + 1));

			//得意先の登録
			CustomerDAO customerDAO = new CustomerDAO(con);
			result = customerDAO.insertCustomer(customer);

			/*登録完了判断*/
			if(!result) {
				throw new SalesSystemException("システムエラーが発生しました。");
			}

			//得意先採番テーブルの更新
			customerCodeDAO.updateCustomerCode(custCode + 1);

			con.commit();

		}catch(SQLException e) {
			e.printStackTrace();

			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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
