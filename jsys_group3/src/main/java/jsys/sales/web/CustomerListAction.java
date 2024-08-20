/**
 * @author J05_田中勇起（2024/8/7）
 */
package jsys.sales.web;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.entity.Customer;
import jsys.sales.entity.Employee;
import jsys.sales.logic.CustomerListLogic;

/**
 * 得意先一覧を表示するActionクラス
 */
public class CustomerListAction implements ActionIF {

	/**
	 *
	 * @see jsys.sales.web.ActionIF#execute(jakarta.servlet.http.HttpServletRequest)
	 */
	@Override
	public String execute(HttpServletRequest request) {

		String page = "V202_01CustomerList.jsp";
		int currentPage = 1;
		int lastPage = 1;

		try {

			HttpSession session = request.getSession(false);
			if (session==null) {
				throw new SalesSystemException("セッションが無効です。");
			} else {
				Employee loginEmployee = (Employee) session.getAttribute("loginEmployee");
				if (loginEmployee==null) {
					throw new SalesSystemException("ログイン情報が存在しません。");
				}
			}

			String order = (String)request.getAttribute("order");
			request.setAttribute("order", order);

			CustomerListLogic logic = new CustomerListLogic();
			List<Customer> custList = logic.findAllCustomer(order);

			if (request.getParameter("checkbox")==null) {
				request.setAttribute("checkbox", false);
				for (int i=0; i<custList.size(); i++) {
					Customer cust = custList.get(i);
					if (cust.isDeleteFlag()) {
						custList.remove(i);
						i--;
					}
				}

				if (custList.isEmpty()) {
					throw new SalesBusinessException("取引先は存在しません。");
				}

			} else if(!(boolean)Boolean.parseBoolean(request.getParameter("checkbox"))) {

				request.setAttribute("checkbox", false);
				for (int i=0; i<custList.size(); i++) {
					Customer cust = custList.get(i);
					if (cust.isDeleteFlag()) {
						custList.remove(i);
						i--;
					}
				}

				if (custList.isEmpty()) {
					throw new SalesBusinessException("取引先は存在しません。");
				}
			}

			else {
				request.setAttribute("checkbox", true);
			}

			request.setAttribute("custList", custList);

			int size = 20;
			lastPage = (custList.size() + (size - 1)) / size;

			List<Customer> custListInCurrentPage = logic.findCustomerInCurrentPage(custList, size, lastPage, currentPage);
			request.setAttribute("custListInCurrentPage", custListInCurrentPage);

		} catch (SalesBusinessException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.setAttribute("errorMessageList", e.getMessageList());
			page = "V202_01CustomerList.jsp";

		} catch (SalesSystemException e) {
			request.setAttribute("errorMessage", e.getMessage());

			if(e.getMessage().equals("セッションが無効です。") || e.getMessage().equals("ログイン情報が存在しません。")) {
				page = "V101_99Logout.jsp";
			}else {
				page = "V901_01SystemError.jsp";
			}

		} finally {
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("lastPage", lastPage);

		}

		return page;
	}

}
