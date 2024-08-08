package jsys.sales.chatbot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChatClient {

    public static void main(String[] args) {
        try {
            // PythonのAPIエンドポイントURL
            URL url = new URL("http://localhost:5000/api/chat");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // ユーザーメッセージを手動でJSON形式にする
            String userMessage = "こんにちは、AI!";
            String jsonInputString = "{\"message\": \"" + escapeJson(userMessage) + "\"}";

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

                // レスポンスから応答を抽出する
                String botResponse = parseJsonResponse(response.toString());
                System.out.println("AIからの応答: " + botResponse);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // JSONの特殊文字をエスケープするメソッド
    private static String escapeJson(String input) {
        return input.replace("\\", "\\\\")
                    .replace("\"", "\\\"")
                    .replace("\b", "\\b")
                    .replace("\f", "\\f")
                    .replace("\n", "\\n")
                    .replace("\r", "\\r")
                    .replace("\t", "\\t");
    }

    // レスポンス文字列から応答を抽出するメソッド
    private static String parseJsonResponse(String jsonResponse) {
        // JSONが { "response": "AIの応答" } の形式であると仮定
        int startIndex = jsonResponse.indexOf("\"response\": \"") + "\"response\": \"".length();
        int endIndex = jsonResponse.indexOf("\"", startIndex);
        if (startIndex != -1 && endIndex != -1) {
            return jsonResponse.substring(startIndex, endIndex);
        }
        return "応答の抽出に失敗しました";
    }
}

