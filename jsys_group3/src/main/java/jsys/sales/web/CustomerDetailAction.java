/**
 * @author J05_田中勇起（2024/8/9）
 */
package jsys.sales.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jsys.sales.common.SalesSystemException;
import jsys.sales.entity.Customer;
import jsys.sales.entity.Employee;

/**
 *得意先詳細情報画面へ遷移する
 */
public class CustomerDetailAction implements ActionIF{
	/**
	 *得意先詳細情報画面への遷移を実行する
	 * @param request リクエストオブジェクト
	 * @return 遷移先ページ
	 */
	public String execute(HttpServletRequest request){

		String page = "V211_01CustomerDetails.jsp";
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

			String custCode = request.getParameter("custCode");
			String custName = request.getParameter("custName");
			String telNo1 = request.getParameter("telNo1");
			String telNo2 = request.getParameter("telNo2");
			String telNo3 = request.getParameter("telNo3");
			String postalCode1 = request.getParameter("postalCode1");
			String address1 = request.getParameter("address1");
			String postalCode2 = request.getParameter("postalCode2");
			String address2 = request.getParameter("address2");
			String discountRate = request.getParameter("discountRate");
			String deleteFlag = request.getParameter("deleteFlag");
			String lastUpdateBy = request.getParameter("lastUpdateBy");

			Customer customer = new Customer();
			customer.setCustCode(custCode);
			customer.setCustName(custName);
			customer.setTelNo1(telNo1);
			customer.setTelNo2(telNo2);
			customer.setTelNo3(telNo3);
			customer.setPostalCode1(postalCode1);
			customer.setAddress1(address1);
			customer.setPostalCode2(postalCode2);
			customer.setAddress2(address2);
			customer.setDiscountRate(Integer.parseInt(discountRate));
			customer.setDeleteFlag(Boolean.parseBoolean(deleteFlag));
			customer.setLastUpdateBy(lastUpdateBy);

			request.setAttribute("customer", customer);

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
