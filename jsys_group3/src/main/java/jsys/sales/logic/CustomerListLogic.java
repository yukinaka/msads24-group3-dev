/**
 * @author J05_田中勇起（2024/8/9）
 */
package jsys.sales.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.CustomerDAO;
import jsys.sales.entity.Customer;

/**
 * 得意先一覧を取得するLogicクラス
 */
public class CustomerListLogic {

	/**
	 * 得意先テーブルから全ての得意先を取得し、ArrayListに格納して返す
	 * @return 得意先一覧
	 * @throws SalesBusinessException
	 * @throws SalesSystemException
	 */
	public ArrayList<Customer> findAllCustomer() throws SalesBusinessException, SalesSystemException {

		Connection con = null;
		ArrayList<Customer> custList = null;

		try {
			con = ConnectionManager.getConnection();

			CustomerDAO customerDAO = new CustomerDAO(con);
			custList = customerDAO.findAllCustomer();

			if (custList==null) {
				throw new SalesBusinessException("取引先は存在しません。");
			}

		} catch (SQLException e) {
			throw new SalesSystemException("システムエラーが発生しました。システム管理者に連絡してください。");

		} finally {

			try {
				if (con!=null) con.close();

			} catch (SQLException e) {
				throw new SalesSystemException("システムエラーが発生しました。システム管理者に連絡してください。");

			}
		}

		return custList;

	}

	public ArrayList<Customer> findCustomerInCurrentPage(ArrayList<Customer> custList, int size, int block, int currentPage) {

		ArrayList<Customer> custListInCurrentPage;
		block = (custList.size() + (size - 1)) / size;

		int start = (currentPage - 1) * size;
		int end = Math.min(start + size, custList.size());
		custListInCurrentPage = (ArrayList)custList.subList(start, end);


		return custListInCurrentPage;
	}

}
