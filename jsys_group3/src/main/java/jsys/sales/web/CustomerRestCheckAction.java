/**
 * @author J11_宮澤奈保子（2024/8/8）
 */
package jsys.sales.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jsys.sales.common.SalesSystemException;
import jsys.sales.entity.Customer;
import jsys.sales.entity.Employee;

/**
 * 得意先復元の入力チェックを行う
 */
public class CustomerRestCheckAction implements ActionIF {

	/**
	 * 復元確認アクション
	 * @param request HttpServletRequestオブジェクト
	 * @return 遷移ページ
	 */
	@Override
	public String execute(HttpServletRequest request) {

		String page = "V223_01CustomerRestorationConfirmation.jsp";

		try {

			HttpSession session = request.getSession(false);

			/*セッション判断*/
			if(session == null) {
				throw new SalesSystemException("セッションが無効です。");
			}else {

				Employee loginEmployee = (Employee)session.getAttribute("loginEmployee");

				/*ログイン情報判断*/
				if(loginEmployee == null) {
					throw new SalesSystemException("ログイン情報が存在しません。");
				}

			}

			//値を取得する
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

			//値をセットする
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

			// 処理結果の格納
			request.setAttribute("customer", customer);

		}catch(SalesSystemException e) {

			// エラーメッセージの格納
			request.setAttribute("errorMessage", e.getMessage());
			// 遷移先ページ名の設定
			if(e.getMessage().equals("セッションが無効です。") || e.getMessage().equals("ログイン情報が存在しません。")) {
				page = "V101_99Logout.jsp";
			}else {
				page = "V901_01SystemError.jsp";
			}

		}

		return page;

	}

}
