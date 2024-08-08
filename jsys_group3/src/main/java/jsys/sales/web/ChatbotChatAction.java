/**
 * @author J05_田中勇起（2024/8/8）
 */
package jsys.sales.web;

import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jsys.sales.entity.Chatbot;
import jsys.sales.logic.ChatbotLogic;

public class ChatbotChatAction implements ActionIF {

	@Override
	public String execute(HttpServletRequest request) {

		String page = "V501_01ChatbotPage.jsp";

		try {
			String userInput = request.getParameter("userInput");

			HttpSession session = request.getSession(false);
			ArrayList<Chatbot> messages = (ArrayList<Chatbot>) session.getAttribute("messages");

			ChatbotLogic logic = new ChatbotLogic();
			logic.chatClient(userInput, messages);
			session.setAttribute("messages", messages);
			
//			ArrayList<String> messages = logic.chatClient(userInput);
//			logic.chatClient(messages, userInput);

		} catch (Exception e) {
			e.printStackTrace();;

		}

		return page;
	}

}
