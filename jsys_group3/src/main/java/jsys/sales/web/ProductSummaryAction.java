/**
 * @author J22_油井清子（2024/8/9）
 */
package jsys.sales.web;

import java.util.ArrayList;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.entity.Employee;
import jsys.sales.entity.ProductSummary;
import jsys.sales.logic.ProductSummaryLogic;
/**
 *商品別受注集計を行う
 */
public class ProductSummaryAction implements ActionIF{

	/**
	 *商品別受注集計ページへの遷移を実行する
	 * @param request　リクエストオブジェクト
	 * @return 遷移先ページ
	 */
	public String execute(HttpServletRequest request){

		String page = "V302_01ProductOrderSummary.jsp";
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

			ProductSummaryLogic logic = new ProductSummaryLogic();
			ArrayList<ProductSummary> productSummaryList = logic.productOrderSummary(custCode);

			request.setAttribute("productSummaryList", productSummaryList);

			if (productSummaryList==null) {
				throw new SalesBusinessException("選択された得意先の受注情報は存在しません。");
			}

		} catch (SalesBusinessException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.setAttribute("errorMessageList", e.getMessageList());
			page = "V302_01ProductOrderSummary.jsp";

		} catch (SalesSystemException e) {
			request.setAttribute("errorMessage", e.getMessage());
			page = "V901_01SystemError.jsp";
		}
		return page;
	}
}
