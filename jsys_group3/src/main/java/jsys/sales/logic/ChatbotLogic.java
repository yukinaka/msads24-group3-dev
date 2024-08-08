/**
 * @author J05_田中勇起（2024/8/7）
 */
package jsys.sales.logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import jsys.sales.entity.Chatbot;

public class ChatbotLogic {
	
	public ArrayList<Chatbot> initClient(){
		
		ArrayList<Chatbot> messages = new ArrayList<>();
		
        try {
        	
            // PythonのAPIエンドポイントURL
            URL url = new URL("http://localhost:5000/api/receive");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String system_prompt = "このスレッドの全ての質問に対して以下のルールに厳格に従って答えてください。"
            		+ "1. タロットカードの大アルカナをランダムに選択してください"
            		+ "2. さらに、正位置と逆位置もランダムに選択してください。"
            		+ "3. 質問に対して、1 と 2 でランダムに選ばれた内容を踏まえて回答してください。";
            
            Chatbot system = new Chatbot();
            
            system.setRole("system");
            system.setContent(system_prompt);
            
            String JsonSystem = String.format("{\"role\":\"%s\",\"content\":\"%s\"}",
                    system.getRole(),
                    system.getContent());
            
            // 送信するメッセージ
            String jsonInputString = "[" + JsonSystem + "]";

            // メッセージをPython APIに送信
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            
  
            // Python APIからのレスポンスを読み取る
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                String responseString = response.toString();

                // Unicodeエスケープシーケンスをデコード
                String decodedResponse = decodeUnicode(responseString);

                // 変換するためのキーを指定
                String keyRole = "role";
                String keyContent = "content";
                
                // 役割に対応するキーを探す
                int roleStartIndex = decodedResponse.indexOf("\"" + keyRole + "\":");
                int contentStartIndex = decodedResponse.indexOf("\"" + keyContent + "\":");
                
                // 値の抽出を開始する位置を計算
                roleStartIndex += keyRole.length() + 4; // 4は ":\" "の長さ
                contentStartIndex += keyContent.length() + 4; // 4は ":\" "の長さ
                
                // 役割の終わりのインデックスを見つける
                int roleEndIndex = decodedResponse.indexOf("\"", roleStartIndex);

                // コンテンツの終わりのインデックスを見つける
                int contentEndIndex = decodedResponse.indexOf("\"", contentStartIndex);
                
                Chatbot reply = new Chatbot();
                
                reply.setRole(decodedResponse.substring(roleStartIndex, roleEndIndex));
                reply.setContent(decodedResponse.substring(contentStartIndex, contentEndIndex));
                
                messages.add(reply);

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        
        }
        
		return messages;
	}
	
	public ArrayList<Chatbot> chatClient(String userInput, ArrayList<Chatbot> messages){
        
		try {
        	
            // PythonのAPIエンドポイントURL
            URL url = new URL("http://localhost:5000/api/receive");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            
            String system_prompt = "このスレッドの全ての質問に対して以下のルールに厳格に従って答えてください。"
            		+ "1. タロットカードの大アルカナをランダムに選択してください"
            		+ "2. さらに、正位置と逆位置もランダムに選択してください。"
            		+ "3. 質問に対して、1 と 2 でランダムに選ばれた内容を踏まえて回答してください。";
            
            Chatbot system = new Chatbot();
            
            system.setRole("system");
            system.setContent(system_prompt);
            
            String JsonSystem = String.format("{\"role\":\"%s\",\"content\":\"%s\"}",
                    system.getRole(),
                    system.getContent());
            
            // 送信するメッセージ
            String jsonInputString = JsonSystem;

            Chatbot user = new Chatbot();
            user.setRole("user");
            user.setContent(userInput);
            messages.add(user);
            
            for (int i=0; i<messages.size(); i++) {
            	Chatbot chatbot = messages.get(i);
            	String JsonString = String.format("{\"role\":\"%s\",\"content\":\"%s\"}",
                        chatbot.getRole(),
                        chatbot.getContent());
            	jsonInputString += "," + JsonString;
            }
            
            // 送信するメッセージ
            jsonInputString = "[" + jsonInputString + "]";

            // メッセージをPython APIに送信
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            
            // Python APIからのレスポンスを読み取る
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                String responseString = response.toString();

                // Unicodeエスケープシーケンスをデコード
                String decodedResponse = decodeUnicode(responseString);

                // 変換するためのキーを指定
                String keyRole = "role";
                String keyContent = "content";
                
                // 役割に対応するキーを探す
                int roleStartIndex = decodedResponse.indexOf("\"" + keyRole + "\":");
                int contentStartIndex = decodedResponse.indexOf("\"" + keyContent + "\":");
                
                // 値の抽出を開始する位置を計算
                roleStartIndex += keyRole.length() + 4; // 4は ":\" "の長さ
                contentStartIndex += keyContent.length() + 4; // 4は ":\" "の長さ
                
                // 役割の終わりのインデックスを見つける
                int roleEndIndex = decodedResponse.indexOf("\"", roleStartIndex);

                // コンテンツの終わりのインデックスを見つける
                int contentEndIndex = decodedResponse.indexOf("\"", contentStartIndex);
                
                Chatbot reply = new Chatbot();
                
                reply.setRole(decodedResponse.substring(roleStartIndex, roleEndIndex));
                reply.setContent(decodedResponse.substring(contentStartIndex, contentEndIndex));
                
                messages.add(reply);

            }
            
		} catch (Exception e) {
            e.printStackTrace();
        
        }
		return null;
	}

	
    private static String decodeUnicode(String unicodeString) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < unicodeString.length()) {
            char c = unicodeString.charAt(i++);
            if (c == '\\' && i < unicodeString.length() && unicodeString.charAt(i) == 'u') {
                i++;
                int value = 0;
                for (int j = 0; j < 4; j++) {
                    char hexChar = unicodeString.charAt(i++);
                    value = (value << 4) + Character.digit(hexChar, 16);
                }
                sb.append((char) value);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
