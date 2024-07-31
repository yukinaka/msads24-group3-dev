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
			buttonId = "V101_03";

		}
		// リクエスト種別の判定
		switch (buttonId) {
		// TODO 2 プロトタイピング作成演習：得意先検索各種画面遷移に関連するcaseを追加してください。

			case "V101_01_01":
				page = "V101_01Login.jsp";
				break;

			case "V101_01_02":
				page = "V101_02MainMenu.jsp";
				break;

			case "V200_01_01":
				page = "V200_01CustomerManagementMenu.jsp";
				break;

			case "V201_01_01":
				page = "V200_01CustomerManagementMenu.jsp";
				break;

			case "V200_01_02":
				page = "V201_01CustomerFindView.jsp";
				break;

			case "V201_02_01":
				page = "V201_01CustomerFindView.jsp";
				break;

			case "V201_01_02":
				action = new CustomerFindAction();
				page = action.execute(request);
				break;

			case "V301_01_01":
				page = "V301_01OrderSummaryWithinPeriod.jsp";
				break;

			case "V101_03":
				page = "V101_03CustomerManagementMenu.jsp";
				break;

			case "V101_04":
				page = "V101_04CustomerSummaryMenu.jsp";
				break;

			case "V221_01":
				page = "V221_01CustomerDeletionConfirmation.jsp";
				break;

			case "V221_02":
				page = "V221_02CustomerDeletionCompletion.jsp";
				break;

			case "V222_02":
				page = "V222_02CustomerRestorationCompletion.jsp";
				break;

			case "V223_01":
				page = "V223_01CustomerRestorationConfirmation.jsp";
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
