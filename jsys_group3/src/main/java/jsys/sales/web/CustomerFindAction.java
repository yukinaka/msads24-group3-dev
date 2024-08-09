/**
 * @author J05_田中勇起（2024/8/9）
 */
package jsys.sales.web;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.entity.Customer;
import jsys.sales.entity.Employee;
import jsys.sales.logic.CustomerFindLogic;
import jsys.sales.logic.CustomerListLogic;

/**
 * 得意先一覧画面で検索を行うActionクラス
 */
public class CustomerFindAction implements ActionIF {

	/**
	 *
	 * @see jsys.sales.web.ActionIF#execute(jakarta.servlet.http.HttpServletRequest)
	 */
	@Override
	public String execute(HttpServletRequest request) {

		String page = "V202_01CustomerList.jsp";

		try {

			HttpSession session = request.getSession(false);
			Employee loginEmployee;

			if(session==null) {
				throw new SalesSystemException("セッションが無効です。");
			}else {

				loginEmployee = (Employee)session.getAttribute("loginEmployee");
				if(loginEmployee == null) {
					throw new SalesSystemException("ログイン情報が存在しません。");
				}
			}

			String custStr = request.getParameter("custStr");

			boolean checkbox;
			if (request.getParameter("ckbotton")==null) {
				checkbox = false;
			} else {
				checkbox = true;
			}
//			if (request.getParameter("ckbutton").equals("true")) {
//				checkbox = true;
//			} else {
//				checkbox = false;
//			}
			System.out.println(checkbox);

			CustomerFindLogic logic = new CustomerFindLogic();
			List<Customer> custList= logic.findCustomer(custStr);

			request.setAttribute("custList", custList);

			int size = 20;
			int block = (custList.size() + (size - 1)) / size;

			int currentPage = 1;
			request.setAttribute("currentPage", currentPage);

			CustomerListLogic pageLogic = new CustomerListLogic();
			List<Customer> custListInCurrentPage = pageLogic.findCustomerInCurrentPage(custList, size, block, currentPage);
			request.setAttribute("custListInCurrentPage", custListInCurrentPage);

			request.setAttribute("checkbox", checkbox);

		} catch (SalesBusinessException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.setAttribute("errorMessageList", e.getMessageList());
			page = "V202_01CustomerList.jsp";

		} catch (SalesSystemException e) {
			request.setAttribute("errorMessage", e.getMessage());
			page = "V901_01SystemErrorPage.jsp";
		}

		return page;
	}

}

