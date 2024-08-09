/**
 * @author J22_油井清子（2024/8/9）
 */
package jsys.sales.web;
import java.sql.Date;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.entity.Customer;
import jsys.sales.entity.Employee;
import jsys.sales.entity.PeriodSummary;
import jsys.sales.logic.CustomerRegistLogic;
/**
 *期間内の受注集計を行う
 */
public class OrderSummaryWithinPeriodActionValidation implements ActionIF{

	/**
	 *期間内受注集計ページへの遷移を実行する
	 * @param request　リクエストオブジェクト
	 * @return 遷移先ページ
	 */
	public String execute(HttpServletRequest request){

		String page = "V301_01OrderSummaryWithinPeriod.jsp";
//		try {
//			HttpSession session = request.getSession(false);
//			Employee loginEmployee;

//			if(session==null) {
//				throw new SalesSystemException("セッションが無効です。");
//			}else {
//
//				loginEmployee = (Employee)session.getAttribute("loginEmployee");
//				if(loginEmployee == null) {
//					throw new SalesSystemException("ログイン情報が存在しません。");
//				}
//			}

//			int firstDay = Integer.parseInt(request.getParameter("firstDay"));
//			int lastDay = Integer.parseInt(request.getParameter("lastDay"));

			String firstDay = request.getParameter("firstDay");
			String lastDay = request.getParameter("lastDay");

			System.out.println("firstDay : " + firstDay);
			System.out.println("lastDay : " + lastDay);



//			if (firstDay>lastDay){
//				throw new SalesBusinessException("正しい期間を選択してください。");
//			}


//			OrderSummaryWithinPeriodLogic logic = new OrderSummaryWithinPeriodLogic();
//			ArrayList<PeriodSummary> periodSummaryList = logic.OrderSummaryWithinPeriod(firstDay,lastDay);

//			request.setAttribute("periodSummaryList", periodSummaryList);

//		} catch (SalesBusinessException e) {
//			request.setAttribute("errorMessage", e.getMessage());
//			request.setAttribute("errorMessageList", e.getMessageList());
//			page = "V301_01OrderSummaryWithinPeriod.jsp";
//
//		} catch (SalesSystemException e) {
//			request.setAttribute("errorMessage", e.getMessage());
//			page = "V901_01SystemError.jsp";
//		}
		return page;
	}

}
