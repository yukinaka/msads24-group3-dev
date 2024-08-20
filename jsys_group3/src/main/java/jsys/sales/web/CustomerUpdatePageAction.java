/**
 * @author J22_油井清子（2024/8/9）
 */
package jsys.sales.web;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jsys.sales.common.SalesSystemException;
import jsys.sales.entity.Customer;
import jsys.sales.entity.Employee;

/**
 *得意先変更画面への遷移を行う
 */
public class CustomerUpdatePageAction implements ActionIF{


	/**
	 *変更画面への遷移を実行する
	 * @param request　リクエストオブジェクト
	 * @return 遷移先ページ
	 */
	public String execute(HttpServletRequest request){

		String page = "V222_01CustomerUpdate.jsp";
		try {

			HttpSession session = request.getSession(false);
			if(session==null) {
				throw new SalesSystemException("セッションが無効です。");
			}else {

				Employee loginEmployee = (Employee)session.getAttribute("loginEmployee");
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
			
			String[] telNo1Parts = telNo1 != "" ? telNo1.split("-") : new String[]{"", "", ""};
			request.setAttribute("telNo1_1", telNo1Parts[0]);
			request.setAttribute("telNo1_2", telNo1Parts[1]);
			request.setAttribute("telNo1_3", telNo1Parts[2]);
			String[] telNo2Parts = telNo2 != "" ? telNo2.split("-") : new String[]{"", "", ""};
			request.setAttribute("telNo2_1", telNo2Parts[0]);
			request.setAttribute("telNo2_2", telNo2Parts[1]);
			request.setAttribute("telNo2_3", telNo2Parts[2]);
			String[] telNo3Parts = telNo3 != "" ? telNo3.split("-") : new String[]{"", "", ""};
			request.setAttribute("telNo3_1", telNo3Parts[0]);
			request.setAttribute("telNo3_2", telNo3Parts[1]);
			request.setAttribute("telNo3_3", telNo3Parts[2]);
			String[] postalCode1Parts = postalCode1 != "" ? postalCode1.split("-") : new String[]{"", ""};
			request.setAttribute("postalCode1_1", postalCode1Parts[0]);
			request.setAttribute("postalCode1_2", postalCode1Parts[1]);
			String[] postalCode2Parts = postalCode2 != "" ? postalCode2.split("-") : new String[]{"", ""};
			request.setAttribute("postalCode2_1", postalCode2Parts[0]);
			request.setAttribute("postalCode2_2", postalCode2Parts[1]);
			

		} catch (SalesSystemException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.getMessage());
			page = "V901_01SystemError.jsp";
		}
		return page;
	}
}
