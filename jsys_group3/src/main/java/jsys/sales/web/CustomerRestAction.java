/**
 * @author J11_宮澤奈保子（2024/8/8）
 */
package jsys.sales.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jsys.sales.common.SalesSystemException;
import jsys.sales.entity.Employee;
import jsys.sales.logic.CustomerRestLogic;

/**
 * 得意先復元を行う
 */
public class CustomerRestAction implements ActionIF {

	/**
	 * 復元アクション
	 * @param request HttpServletRequestオブジェクト
	 * @return 遷移ページ
	 */
	@Override
	public String execute(HttpServletRequest request) {

		String page = "V223_02CustomerRestorationCompletion.jsp";

		try {

			HttpSession session = request.getSession(false);
			Employee loginEmployee;

			/*セッション判断*/
			if(session == null) {
				throw new SalesSystemException("セッションが無効です。");
			}else {

				loginEmployee = (Employee)session.getAttribute("loginEmployee");

				/*ログイン情報判断*/
				if(loginEmployee == null) {
					throw new SalesSystemException("ログイン情報が存在しません。");
				}

			}

			String custCode = request.getParameter("custCode");

			CustomerRestLogic logic = new CustomerRestLogic();
			logic.restCustomer(custCode);

		}catch (SalesSystemException e) {

			request.setAttribute("errorMessage", e.getMessage());
			page = "V901_01SystemError.jsp";

		}

		return page;

	}

}
