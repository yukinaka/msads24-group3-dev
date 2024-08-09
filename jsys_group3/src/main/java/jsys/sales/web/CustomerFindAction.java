/**
 * @author J05_田中勇起（2024/8/9）
 */
package jsys.sales.web;

import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.entity.Customer;
import jsys.sales.entity.Employee;
import jsys.sales.logic.CustomerFindLogic;

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
			if (request.getParameter("checkbox").equals("true")) {
				checkbox = true;
			} else {
				checkbox = false;
			}
			System.out.println(checkbox);

			CustomerFindLogic logic = new CustomerFindLogic();
			ArrayList<Customer> custList= logic.findCustomer(custStr);

			request.setAttribute("custList", custList);
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
