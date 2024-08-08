package jsys.sales.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.CustomerDAO;
import jsys.sales.entity.Customer;

public class CustomerListLogic {

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

		return null;

	}
}
