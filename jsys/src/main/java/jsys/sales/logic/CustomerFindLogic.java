package jsys.sales.logic;

import java.sql.Connection;
import java.sql.SQLException;

import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.CustomerDAO;
import jsys.sales.entity.Customer;

public class CustomerFindLogic {

	public Customer findCustomer(String custCode) throws SalesBusinessException, SalesSystemException {

		Connection con = null;
		Customer customer = null;

		try {
			con = ConnectionManager.getConnection();

			CustomerDAO customerDAO = new CustomerDAO(con);
			customer = customerDAO.findCustomer(custCode);

			if (customer==null) {
				throw new SalesBusinessException("該当する取引先コードは存在しません。");
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

		return customer;

	}
}
