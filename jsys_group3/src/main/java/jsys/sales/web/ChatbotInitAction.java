/**
 * @author J05_田中勇起（2024/8/8）
 */
package jsys.sales.web;

import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jsys.sales.entity.Chatbot;
import jsys.sales.logic.ChatbotLogic;

public class ChatbotInitAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest request) {

		String page = "V501_01ChatbotPage.jsp";

		try {
//			String userInput = request.getParameter("userInput");

			ChatbotLogic logic = new ChatbotLogic();
			ArrayList<Chatbot> messages = logic.initClient();

			HttpSession session = request.getSession(true);
			session.setAttribute("messages", messages);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return page;
	}

}
