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
import jsys.sales.entity.Employee;
import jsys.sales.entity.PeriodSummary;
import jsys.sales.logic.OrderSummaryWithinPeriodLogic;
/**
 *期間内の受注集計を行う
 */
public class OrderSummaryWithinPeriodAction implements ActionIF{

	/**
	 *期間内受注集計ページへの遷移を実行する
	 * @param request　リクエストオブジェクト
	 * @return 遷移先ページ
	 */
	public String execute(HttpServletRequest request){

		String page = "V301_01OrderSummaryWithinPeriod.jsp";
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

			Date firstDay = null;
			Date lastDay = null;

			try {

				firstDay = Date.valueOf(request.getParameter("firstDay"));
				lastDay = Date.valueOf(request.getParameter("lastDay"));

			} catch (IllegalArgumentException e) {
				throw new SalesSystemException("システムエラーが発生しました。");
			}

			if (firstDay.after(lastDay)){
				throw new SalesBusinessException("正しい期間を選択してください。");
			}

			OrderSummaryWithinPeriodLogic logic = new OrderSummaryWithinPeriodLogic();
			ArrayList<PeriodSummary> periodSummaryList = logic.orderSummaryWithinPeriodLogic(firstDay,lastDay);
			int total = logic.periodSummaryTotal(periodSummaryList);

			request.setAttribute("periodSummaryList", periodSummaryList);
			request.setAttribute("total", total);

			if (periodSummaryList==null) {
				throw new SalesBusinessException("選択された集計期間に該当する受注情報は存在しません。");
			}

		} catch (SalesBusinessException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.setAttribute("errorMessageList", e.getMessageList());
			page = "V301_01OrderSummaryWithinPeriod.jsp";

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
