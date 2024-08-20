/**
 * @author J11_宮澤奈保子（2024/8/20）
 */
package jsys.sales.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LogoutAction implements ActionIF {

	/**
	 * ログアウトボタンクリック時の処理を実行する。
	 *
	 * @param request リクエスト情報
	 * @return 遷移先ページ名
	 */
	public String execute(HttpServletRequest request) {
		// 遷移先ページ名の設定
		String page = "V101_99Logout.jsp";
		// セッションの生成
		HttpSession session = request.getSession(true);
		// セッションの破棄
		session.invalidate();
		return page;
	}
}
