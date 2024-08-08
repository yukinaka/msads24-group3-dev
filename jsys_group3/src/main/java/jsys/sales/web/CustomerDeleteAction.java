/**
 * @author J22_油井清子（2024/8/8）
 */
package jsys.sales.web;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jsys.sales.common.SalesSystemException;
import jsys.sales.entity.Employee;
import jsys.sales.logic.CustomerDeleteLogic;

/**
 *得意先情報の削除を行う
 */
public class CustomerDeleteAction implements ActionIF{
	/**
	 *削除完了ページへの遷移を実行する
	 * @param request　リクエストオブジェクト
	 * @return 遷移先ページ
	 */
	public String execute(HttpServletRequest request){

		String page = "V221_02CustomerDeletionCompletion";

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

			CustomerDeleteLogic logic = new CustomerDeleteLogic();
			logic.deleteCustomer(custCode);

		} catch (SalesSystemException e) {
			request.setAttribute("errorMessage", e.getMessage());
			page = "V901_01SystemError.jsp";
		}
		return page;
	}
}
