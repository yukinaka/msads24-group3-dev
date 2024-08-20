/**
 * @author J05_田中勇起（2024/8/9）
 */
package jsys.sales.web;

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
		String custStr = null;
		int currentPage = 1;
		int lastPage = 1;
		boolean checkbox = false;

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

			if (request.getParameter("checkbox")==null) {
				checkbox = false;
			} else {
				checkbox = true;
			}

			custStr = request.getParameter("custStr");
			CustomerFindLogic logic = new CustomerFindLogic();
			List<Customer> custList = logic.findCustomer(custStr);
			
			/* チェックボックスがチェックされていない場合は、削除済みの得意先をリストから削除する */
			if (!checkbox) {
				for (Customer cust : custList) {
					if (cust.isDeleteFlag()) {
						custList.remove(cust);
					}
				}
				if (custList.isEmpty()) {
					throw new SalesBusinessException("検索結果が見つかりませんでした。");
				}
			}
			
			request.setAttribute("custList", custList);

			int size = 20;
			lastPage = (custList.size() + (size - 1)) / size;

			CustomerListLogic pageLogic = new CustomerListLogic();
			List<Customer> custListInCurrentPage = pageLogic.findCustomerInCurrentPage(custList, size, lastPage, currentPage);
			request.setAttribute("custListInCurrentPage", custListInCurrentPage);

		} catch (SalesBusinessException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.setAttribute("errorMessageList", e.getMessageList());
			request.setAttribute("order", "dft");
			ActionIF action = new CustomerListAction();
			page = action.execute(request);

		} catch (SalesSystemException e) {
			request.setAttribute("errorMessage", e.getMessage());
			page = "V901_01SystemErrorPage.jsp";
			
		} finally {
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("lastPage", lastPage);
			request.setAttribute("checkbox", checkbox);
			request.setAttribute("custStr", custStr);
		}

		return page;
	}

}

