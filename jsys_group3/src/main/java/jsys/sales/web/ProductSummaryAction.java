/**
 * @author J22_油井清子（2024/8/9）
 */
package jsys.sales.web;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.entity.Customer;
import jsys.sales.entity.Employee;
import jsys.sales.entity.ProductSummary;
import jsys.sales.logic.CustomerFindLogic;
import jsys.sales.logic.CustomerListLogic;
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

			CustomerListLogic custLogic = new CustomerListLogic();
			List<Customer> custList = custLogic.findAllCustomer("dft");
			request.setAttribute("custList", custList);

			String custCodeName = request.getParameter("CustomerCodeName");

			try {

				String custCode = custCodeName.substring(0, 6);
				request.setAttribute("custCodeName", custCodeName);

				CustomerFindLogic findLogic = new CustomerFindLogic();
				ArrayList<Customer> cust = findLogic.findCustomer(custCode);
				if(cust.get(0).isDeleteFlag()) {
					throw new SalesBusinessException("選択された得意先の受注情報は存在しません。");
				}

				ProductSummaryLogic summaryLogic = new ProductSummaryLogic();
				ArrayList<ProductSummary> productSummaryList = summaryLogic.productOrderSummary(custCode);
				int total = summaryLogic.productSummaryTotal(productSummaryList);
				request.setAttribute("productSummaryList", productSummaryList);
				request.setAttribute("total", total);

				if (productSummaryList==null) {
					throw new SalesBusinessException("選択された得意先の受注情報は存在しません。");
				}

			}catch(StringIndexOutOfBoundsException e) {
				throw new SalesBusinessException("選択された得意先の受注情報は存在しません。");
			}

		} catch (SalesBusinessException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.setAttribute("errorMessageList", e.getMessageList());
			page = "V302_01ProductOrderSummary.jsp";

		} catch (SalesSystemException e) {
			request.setAttribute("errorMessage", e.getMessage());

			if(e.getMessage().equals("セッションが無効です。") || e.getMessage().equals("ログイン情報が存在しません。")) {
				page = "V101_99Logout.jsp";
			}else {
				page = "V901_01SystemError.jsp";
			}

		}

		finally{

		}
		return page;
	}
}
