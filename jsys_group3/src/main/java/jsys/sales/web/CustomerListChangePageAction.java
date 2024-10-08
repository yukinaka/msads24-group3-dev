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
 * 得意先一覧で次ページへ遷移するActionクラス
 */
public class CustomerListChangePageAction implements ActionIF {

	/**
	 *
	 * @see jsys.sales.web.ActionIF#execute(jakarta.servlet.http.HttpServletRequest)
	 */
	@Override
	public String execute(HttpServletRequest request) {

		String page = "V202_01CustomerList.jsp";

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

			CustomerListLogic logic = new CustomerListLogic();

			String order = request.getParameter("order");
			request.setAttribute("order", order);

			List<Customer> custList = logic.findAllCustomer(order);

			if (request.getParameter("checkbox").equals("true")){
				request.setAttribute("checkbox", true);

			} else {
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

			request.setAttribute("custList", custList);

			int size = 20;
			int lastPage = (custList.size() + (size - 1)) / size;
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));

			request.setAttribute("lastPage", lastPage);
			request.setAttribute("currentPage", currentPage);

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

		}

		return page;
	}

}
