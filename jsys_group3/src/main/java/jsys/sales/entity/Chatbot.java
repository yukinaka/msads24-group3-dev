package jsys.sales.entity;

import java.io.Serializable;

/**
 * Chatbotエンティティ
 */
public class Chatbot implements Serializable {

	/* メンバ変数 */
	/** role */
	private String role;

	/** content */
	private String content;

	/**
	 * コンストラクタ(引数なし)
	 */
	public Chatbot() {

	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


}
