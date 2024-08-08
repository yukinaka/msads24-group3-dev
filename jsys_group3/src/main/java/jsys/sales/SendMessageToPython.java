package jsys.sales;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendMessageToPython {
    public static void main(String[] args) {
        try {
            // PythonのAPIエンドポイントURL
            URL url = new URL("http://localhost:5000/api/receive");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // 送信するメッセージ
//            String jsonInputString = "[{\"message\": \"Javaからこんにちは！\"}, {\"message\": \"Javaからこんにちは２！\"}]";
            String messages = "{\"role\": \"system\", \"content\": \"あなたは優秀なアシスタントAIです。\"}, {\"role\": \"user\", \"content\":\"あなたはどんなことができますか？\"}";
            String jsonInputString = "[" + messages + "]";

            // メッセージをPython APIに送信
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            String decodedResponse;
            
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
                decodedResponse = decodeUnicode(responseString);

                System.out.println("Response from Python API: " + decodedResponse);
            }
            
            // 変換するためのキーを指定
            String keyRole = "role";
            String keyContent = "content";

            // 役割に対応するキーを探す
            int roleStartIndex = decodedResponse.indexOf("\"" + keyRole + "\":");
            int contentStartIndex = decodedResponse.indexOf("\"" + keyContent + "\":");
            
         // 値の抽出を開始する位置を計算
            roleStartIndex += keyRole.length() + 3; // 3は ":\" "の長さ
            contentStartIndex += keyContent.length() + 3; // 3は ":\" "の長さ

            // 役割の終わりのインデックスを見つける
            int roleEndIndex = decodedResponse.indexOf("\"", roleStartIndex);

            // コンテンツの終わりのインデックスを見つける
            int contentEndIndex = decodedResponse.indexOf("\"", contentStartIndex);

            // 新しいJSON形式の文字列を生成
            String newJsonString = String.format("{\"%s\":\"%s\",\"%s\":\"%s\"}",
                    keyRole,
                    decodedResponse.substring(roleStartIndex, roleEndIndex),
                    keyContent,
                    decodedResponse.substring(contentStartIndex, contentEndIndex));
            
            messages += ", " + newJsonString;
            
            String userInputMessage = "東京は日本のどこにありますか？";
            // 新しいJSON形式の文字列を生成
            String userInputMessageJson = String.format("{\"%s\":\"%s\",\"%s\":\"%s\"}",
                    "role",
                    "user",
                    "content",
                    userInputMessage);
            
            messages += ", " + userInputMessageJson;
            jsonInputString = "[" + messages + "]";
            
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
            	decodedResponse = decodeUnicode(responseString);
            	
            	System.out.println("Response from Python API: " + decodedResponse);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
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
