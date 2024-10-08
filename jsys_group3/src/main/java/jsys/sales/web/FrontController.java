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
			buttonId = "V101_99_01";

		}
		// リクエスト種別の判定
		switch (buttonId) {

			case "V101_01_01":
				action = new LoginAction();
				page = action.execute(request);
				break;

			case "V101_02":
				page = "V101_02MainMenu.jsp";
				break;

			case "V101_03":
				action = new LogoutAction();
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
				request.setAttribute("order", "dft");
				action = new CustomerListAction();
				action.execute(request);
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
				action = new CustomerRegistPageAction();
				page = action.execute(request);
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
				action = new CustomerListChangePageAction();
				page = action.execute(request);
				break;

			case "V202_01_05":
				request.setAttribute("order", "dft");
				action = new CustomerListAction();
				page = action.execute(request);
				break;

			case "V202_01_06":
				action = new CustomerDetailAction();
				page = action.execute(request);
				break;

			case "V211_01_01":
				request.setAttribute("order", "dft");
				action = new CustomerListAction();
				page = action.execute(request);
				break;

			case "V211_01_02":
				action = new CustomerUpdatePageAction();
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
				action = new CustomerDetailAction();
				page = action.execute(request);
				break;

			case "V221_02_01":
				request.setAttribute("order", "dft");
				action = new CustomerListAction();
				page = action.execute(request);
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
				action = new CustomerUpdatePageAction();
				page = action.execute(request);
				break;

			case "V222_03_01":
				request.setAttribute("order", "dft");
				action = new CustomerListAction();
				page = action.execute(request);
				break;

			case "V223_01_01":
				action = new CustomerRestAction();
				page = action.execute(request);
				break;

			case "V223_01_02":
				action = new CustomerDetailAction();
				page = action.execute(request);
				break;

			case "V223_02_01":
				request.setAttribute("order", "dft");
				action = new CustomerListAction();
				page = action.execute(request);
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
