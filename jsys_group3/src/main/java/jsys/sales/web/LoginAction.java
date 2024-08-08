/**
 * @author J05_田中勇起（2024/8/8）
 */
package jsys.sales.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.entity.Employee;
import jsys.sales.logic.LoginLogic;

public class LoginAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest request) {

		String page = "V201_01CustomerRegistration.jsp";

		try {
			String empNo = request.getParameter("empNo");
			String password = request.getParameter("password");

			LoginLogic logic = new LoginLogic();
			Employee employee= logic.login(empNo, password);

			HttpSession session = request.getSession(true);
			session.setAttribute("loginEmployee", employee);

		} catch (SalesBusinessException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.setAttribute("errorMessageList", e.getMessageList());
			page = "V101_01Login.jsp";

		} catch (SalesSystemException e) {
			request.setAttribute("errorMessage", e.getMessage());
			page = "V901_01SystemError.jsp";
		}

		return page;
	}

}
