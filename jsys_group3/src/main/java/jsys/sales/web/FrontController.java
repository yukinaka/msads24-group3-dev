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

			case "V101_02":
				page = "V101_02MainMenu.jsp";
				break;

			case "V101_03":
				page = "V101_03CustomerManagementMenu.jsp";
				break;

			case "V101_04":
				page = "V101_04CustomerSummaryMenu.jsp";
				break;

			case "V101_99":
				page = "V101_99Logout.jsp";
				break;

			case "V201_01":
				page = "V201_01CustomerRegistration.jsp";
				break;

			case "V201_02":
				page = "V201_02CustomerRegistrationConfirmation.jsp";
				break;

			case "V201_03":
				page = "V201_03CustomerRegistrationCompletion.jsp";
				break;

			case "V202_01":
				page = "V202_01CustomerList.jsp";
				break;

			case "V211_01":
				page = "V211_01CustomerDetails.jsp";
				break;

			case "V221_01":
				page = "V221_01CustomerDeletionConfirmation.jsp";
				break;

			case "V221_02":
				page = "V221_02CustomerDeletionCompletion.jsp";
				break;

			case "V222_01":
				page = "V222_01CustomerUpdate.jsp";
				break;

			case "V222_02":
				page = "V222_02CustomerModificationConfirmation.jsp";
				break;

			case "V222_03":
				page = "V222_03CustomerModificationCompletion.jsp";
				break;

			case "V223_01":
				page = "V223_01CustomerRestorationConfirmation.jsp";
				break;

			case "V223_02":
				page = "V223_02CustomerRestorationCompletion.jsp";
				break;

			case "V301_01":
				page = "V301_01OrderSummaryWithinPeriod.jsp";
				break;

			case "V302_01":
				page = "V302_01ProductOrderSummary.jsp";
				break;

			case "V901_01":
				page = "V901_01SystemError.jsp";
				break;

			case "V400_00":
				page = "V400_00Navbar.jsp";
				break;

//			case "V200_01_01":
//				page = "V200_01CustomerManagementMenu.jsp";
//				break;
//
//			case "V201_01_01":
//				page = "V200_01CustomerManagementMenu.jsp";
//				break;
//
//			case "V200_01_02":
//				page = "V201_01CustomerFindView.jsp";
//				break;
//
//			case "V201_02_01":
//				page = "V201_01CustomerFindView.jsp";
//				break;
//
//			case "V201_01_02":
//				action = new CustomerFindAction();
//				page = action.execute(request);
//				break;



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
				action = new CustomerFindAction();
				page = action.execute(request);
				break;

			case "V202_01_03":
				request.setAttribute("order", "desc");
				action = new CustomerFindAction();
				page = action.execute(request);
				break;

			case "V202_01_06":
				action = new CustomerDetailAction();
				page = action.execute(request);
				break;

//			case "V202_01_02":
//				action = new CustomerListAction();
//				page = action.execute(request);
//				break;
//
//			case "V202_01_03":
//				action = new CustomerListAction();
//				page = action.execute(request);
//				break;
//
//			case "V202_01_04":
//				action = new CustomerListAction();
//				page = action.execute(request);
//				break;
//
//			case "V202_01_05":
//				action = new CustomerListAction();
//				page = action.execute(request);
//				break;

//			case "V101_03_02":
//				action = new LoginAction();
//				page = action.execute(request);
//				break;
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
