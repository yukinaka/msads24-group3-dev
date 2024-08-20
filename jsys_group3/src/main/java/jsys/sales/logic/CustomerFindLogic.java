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

public class CustomerFindLogic {

	public ArrayList<Customer> findCustomer(String custStr) throws SalesBusinessException, SalesSystemException {

		Connection con = null;
		ArrayList<Customer> custList= null;

		try {
			con = ConnectionManager.getConnection();
			CustomerDAO customerDAO = new CustomerDAO(con);

			ArrayList<Customer> custListByCode = customerDAO.findCustomerByCode(custStr);
			if (custListByCode!=null) {
				custList = new ArrayList<>();

				for (Customer cust : custListByCode) {
					custList.add(cust);
				}
			}

			ArrayList<Customer> custListByName = customerDAO.findCustomerByName(custStr);
			if (custListByName!=null) {
				if (custList==null) {
					custList = new ArrayList<>();
				}
				for (Customer cust : custListByName) {
					boolean existFlag = false;
					for (Customer existCust : custList) {
						if (cust.getCustCode().equals(existCust.getCustCode())) {
							existFlag = true;
						}
					}
					if (!existFlag) {
						custList.add(cust);
					}
				}
			}

			if (custList==null) {
				throw new SalesBusinessException("検索結果が見つかりませんでした。");
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

}
