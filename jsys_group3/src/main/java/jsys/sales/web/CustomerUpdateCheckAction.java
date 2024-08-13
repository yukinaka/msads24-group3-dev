/**
 * @author J22_油井清子（2024/8/9）
 */
package jsys.sales.web;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.entity.Customer;
import jsys.sales.entity.Employee;
import jsys.sales.logic.CustomerUpdateLogic;

/**
 *得意先情報の変更を行う
 */
public class CustomerUpdateCheckAction implements ActionIF{


	/**
	 *変更確認ページへの遷移を実行する
	 * @param request　リクエストオブジェクト
	 * @return 遷移先ページ
	 */
	public String execute(HttpServletRequest request){

		String page = "V222_02CustomerModificationConfirmation.jsp";
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
			String telNo1 = request.getParameter("telNo1-1") + "-" + request.getParameter("telNo1-2") + "-" + request.getParameter("telNo1-3");
			String telNo2 = request.getParameter("telNo2-1") + "-" + request.getParameter("telNo2-2") + "-" + request.getParameter("telNo2-3");
			String telNo3 = request.getParameter("telNo3-1") + "-" + request.getParameter("telNo3-2") + "-" + request.getParameter("telNo3-3");
			String postalCode1 = request.getParameter("postalCode1-1") + "-" + request.getParameter("postalCode1-2");
			String address1 = request.getParameter("address1");
			String postalCode2 = request.getParameter("postalCode2-1") + "-" + request.getParameter("postalCode2-2");
			String address2 = request.getParameter("address2");
			String discountRate = request.getParameter("discountRate");
			String deleteFlag = request.getParameter("deleteFlag");

			ArrayList<String> errorMessageList = new ArrayList<>();

			// 電話番号1の処理
			telNo1 = request.getParameter("telNo1-1") + "-" + request.getParameter("telNo1-2") + "-" + request.getParameter("telNo1-3");
			telNo1 = telNo1.replaceAll("^-|-$", "").replaceAll("--", "-"); // 前後のハイフンを削除し、連続したハイフンを1つに

			// 電話番号2の処理
			telNo2 = request.getParameter("telNo2-1") + "-" + request.getParameter("telNo2-2") + "-" + request.getParameter("telNo2-3");
			telNo2 = telNo2.replaceAll("^-|-$", "").replaceAll("--", "-"); // 前後のハイフンを削除し、連続したハイフンを1つに

			// 電話番号3の処理
			telNo3 = request.getParameter("telNo3-1") + "-" + request.getParameter("telNo3-2") + "-" + request.getParameter("telNo3-3");
			telNo3 = telNo3.replaceAll("^-|-$", "").replaceAll("--", "-"); // 前後のハイフンを削除し、連続したハイフンを1つに

			// 郵便番号1の処理
			postalCode1 = request.getParameter("postalCode1-1") + "-" + request.getParameter("postalCode1-2");
			postalCode1 = postalCode1.replaceAll("^-|-$", "").replaceAll("--", "-"); // 前後のハイフンを削除し、連続したハイフンを1つに

			// 郵便番号2の処理
			postalCode2 = request.getParameter("postalCode2-1") + "-" + request.getParameter("postalCode2-2");
			postalCode2 = postalCode2.replaceAll("^-|-$", "").replaceAll("--", "-"); // 前後のハイフンを削除し、連続したハイフンを1つに

			// 電話番号2のバリデーション
			if (!telNo2.isEmpty() && !telNo2.equals("--")) {
			    if (!telNo2.matches("^[0-9]{2,4}-[0-9]{3,4}-[0-9]{3,4}$")) {
			        errorMessageList.add("電話番号2が不正です。");
			    }
			}

			// 電話番号3のバリデーション
			if (!telNo3.isEmpty() && !telNo3.equals("--")) {
			    if (!telNo3.matches("^[0-9]{2,4}-[0-9]{3,4}-[0-9]{3,4}$")) {
			        errorMessageList.add("電話番号3が不正です。");
			    }
			}

			// 郵便番号1のバリデーション
			if (!postalCode1.isEmpty() && !postalCode1.equals("-")) {
			    if (!postalCode1.matches("^[0-9]{3}-[0-9]{4}$")) {
			        errorMessageList.add("郵便番号1が不正です。");
			    }
			}

			// 郵便番号2のバリデーション
			if (!postalCode2.isEmpty() && !postalCode2.equals("-")) {
			    if (!postalCode2.matches("^[0-9]{3}-[0-9]{4}$")) {
			        errorMessageList.add("郵便番号2が不正です。");
			    }
			}
			if (!errorMessageList.isEmpty()) {
				throw new SalesBusinessException(errorMessageList);
			}

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
			customer.setDeleteFlag(Boolean.getBoolean(deleteFlag));

			CustomerUpdateLogic logic = new CustomerUpdateLogic();
			logic.checkCustomer(customer);

			// 処理結果の格納
			request.setAttribute("customer", customer);

		} catch (SalesBusinessException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.setAttribute("errorMessageList", e.getMessageList());
			// 遷移先ページ名の設定0
			page = "V222_01CustomerUpdate.jsp";
		} catch (SalesSystemException e) {
			e.printStackTrace();
			// システムエラー発生時
			// エラーメッセージの格納
			request.setAttribute("errorMessage", e.getMessage());
			page = "V901_01SystemError.jsp";
		}
		return page;
	}
}
