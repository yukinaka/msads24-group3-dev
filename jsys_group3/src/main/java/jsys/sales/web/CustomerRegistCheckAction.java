/**
 * @author J22_油井清子（2024/8/8）
 */
package jsys.sales.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.entity.Customer;
import jsys.sales.entity.Employee;
import jsys.sales.logic.CustomerRegistLogic;

/**
 *得意先情報登録の入力チェックを行う
 */
public class CustomerRegistCheckAction implements ActionIF{

	public String execute(HttpServletRequest request){

		String page = "V201_02CustomerRegistrationConfirmation";
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

			String custName = request.getParameter("custName");		//CustomerFindViewのnameの名前
			String telNo1 = request.getParameter("telNo1");
			String telNo2 = request.getParameter("telNo2");
			String telNo3 = request.getParameter("telNo3");
			String postalCode1 = request.getParameter("postalCode1");
			String address1 = request.getParameter("address1");
			String postalCode2 = request.getParameter("postalCode2");
			String address2 = request.getParameter("address2");
			String discountRate = request.getParameter("discountRate");

			if (custName == null || custName.equals("")) {
				throw new SalesBusinessException("得意先名が未入力です。");
			}
			if (telNo1 == null || telNo1.equals("")) {
				throw new SalesBusinessException("電話番号1が未入力です。");
			}
			if (discountRate == null || discountRate.equals("")) {
				throw new SalesBusinessException("割引率が未入力です。");
			}

			Customer customer = new Customer();
			customer.setCustName(custName);
			customer.setTelNo1(telNo1);
			customer.setTelNo2(telNo2);
			customer.setTelNo3(telNo3);
			customer.setPostalCode1(postalCode1);
			customer.setAddress1(address1);
			customer.setPostalCode2(postalCode2);
			customer.setAddress2(address2);
			customer.setDiscountRate(Integer.parseInt(discountRate));

			CustomerRegistLogic logic = new CustomerRegistLogic();
			logic.checkCustomer(customer);

			// 処理結果の格納
			request.setAttribute("customer", customer);

		} catch (SalesBusinessException e) {
			// 業務エラー発生時
			// エラーメッセージの格納
			request.setAttribute("errorMessage", e.getMessage());
			// 遷移先ページ名の設定
			page = "V201_01CustomerRegistration";
		} catch (SalesSystemException e) {
			// システムエラー発生時
			// エラーメッセージの格納
			request.setAttribute("errorMessage", e.getMessage());
			// 遷移先ページ名の設定
			page = "V901_01SystemError.jsp";
		}
		return page;
	}
}
