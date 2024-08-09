/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * FrontController.java
 *
 */
package jsys.sales.web;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/jsysFC" })
public class FrontController extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 遷移先ページ名の設定
		String path="/WEB-INF/jsp/";
		String page = null;
		// Actionクラス
		ActionIF action = null;
		// パラメータの取得
		request.setCharacterEncoding("UTF-8");
		String buttonId = request.getParameter("buttonId");

		// パラメータ未送信または空文字の場合
		if (buttonId == null || buttonId.equals("")) {
			// TODO 1 プロトタイピング作成演習：得意先管理メニュー画面のbuttonIdをデフォルトとして設定してください。
			buttonId = "V101_01";

		}
		// リクエスト種別の判定
		switch (buttonId) {
		// TODO 2 プロトタイピング作成演習：得意先検索各種画面遷移に関連するcaseを追加してください。
			case "V101_01":
				page = "V101_01Login.jsp";
				break;

			case "V101_01_01":
				action = new LoginAction();
				page = action.execute(request);
				break;

			case "V101_02_01":
				page = "V101_03CustomerManagementMenu.jsp";
				break;

			case "V101_02_02":
				page = "V101_04CustomerSummaryMenu.jsp";
				break;

			case "V101_03_01":
				page = "V201_01CustomerRegistration.jsp";
				break;

			case "V101_03_02":
				request.setAttribute("order", "dft");
				action = new CustomerListAction();
				page = action.execute(request);
				break;

			case "V101_04_01":
				page = "V301_01OrderSummaryWithinPeriod.jsp";
				break;

			case "V101_04_02":
				page = "V302_01ProductOrderSummary.jsp";
				break;

			case "V201_01_01":
				action = new CustomerRegistCheckAction();
				page = action.execute(request);
				break;

			case "V201_02_01":
				action = new CustomerRegistAction();
				page = action.execute(request);
				break;

			case "V201_02_02":
				page = "V201_01CustomerRegistration.jsp";
				break;

			case "V201_03_01":
				page = "V201_01CustomerRegistration.jsp";
				break;

			case "V202_01_01":
				action = new CustomerFindAction();
				page = action.execute(request);
				break;

			case "V202_01_02":
				request.setAttribute("order", "asc");
				action = new CustomerListAction();
				page = action.execute(request);
				break;

			case "V202_01_03":
				request.setAttribute("order", "desc");
				action = new CustomerListAction();
				page = action.execute(request);
				break;

			case "V202_01_04":
//				action = new CustomerListPrevPageAction();
				action = new CustomerListChangePageAction();
				page = action.execute(request);
				break;

			case "V202_01_05":
//				action = new CustomerListNextPageAction();
				action = new CustomerListChangePageAction();
				page = action.execute(request);
				break;

			case "V202_01_06":
				action = new CustomerDetailAction();
				page = action.execute(request);
				break;
			case "V211_01_01":
				page = "V202_01CustomerList.jsp";
				break;

			case "V211_01_02":
				action = new CustomerUpdateCheckAction();
				page = action.execute(request);
				break;

			case "V211_01_03":
				action = new CustomerDeleteCheckAction();
				page = action.execute(request);
				break;

			case "V211_01_04":
				action = new CustomerRestCheckAction();
				page = action.execute(request);
				break;

			case "V221_01_01":
				action = new CustomerDeleteAction();
				page = action.execute(request);
				break;

			case "V221_01_02":
				page = "V211_01CustomerDetails.jsp";
				break;

			case "V221_02_01":
				page = "V202_01CustomerList.jsp";
				break;

			case "V222_01_01":
				action = new CustomerUpdateCheckAction();
				page = action.execute(request);
				break;

			case "V222_02_01":
				action = new CustomerUpdateAction();
				page = action.execute(request);
				break;

			case "V222_02_02":
				page = "V222_01CustomerUpdate.jsp";
				break;

			case "V222_03_01":
				page = "V202_01CustomerList.jsp";
				break;

			case "V223_01_01":
				action = new CustomerRestAction();
				page = action.execute(request);
				break;

			case "V223_01_02":
				page = "V211_01CustomerDetails.jsp";
				break;

			case "V223_02_01":
				page = "V202_01CustomerList.jsp";
				break;

			case "V301_01_01":
				action = new OrderSummaryWithinPeriodAction();
				page = action.execute(request);
				break;

			case "V302_01_01":
				action = new ProductSummaryAction();
				page = action.execute(request);
				break;

			case "V101_99_01":
				page = "V101_01Login.jsp";
				break;

		}

		// 結果画面に転送
		RequestDispatcher rd = request.getRequestDispatcher(path + page);
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
