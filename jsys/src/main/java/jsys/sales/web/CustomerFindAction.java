package jsys.sales.web;

import jakarta.servlet.http.HttpServletRequest;
import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.entity.Customer;
import jsys.sales.logic.CustomerFindLogic;

public class CustomerFindAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest request) {

		String page = "V201_02CustomerFindResultView.jsp";

		try {
			String custCode = request.getParameter("custCode");

			if (custCode==null || custCode.equals("")) {
				throw new SalesBusinessException("得意先コードを入力してください。");
			}

			CustomerFindLogic logic = new CustomerFindLogic();
			Customer customer = logic.findCustomer(custCode);

			request.setAttribute("customer", customer);

		} catch (SalesBusinessException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.setAttribute("errorMessageList", e.getMessageList());
			page = "V201_01CustomerFindView.jsp";

		} catch (SalesSystemException e) {
			request.setAttribute("errorMessage", e.getMessage());
			page = "V901_01SystemErrorPage.jsp";
		}

		return page;
	}

}
