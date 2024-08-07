/**
 * @author J11_宮澤奈保子（2024/8/7）
 */
package jsys.sales.entity;

import java.io.Serializable;

/**
 * 従業員エンティティ
 */
public class Employee implements Serializable {

	/* メンバ変数 */
	/** 従業員番号 */
	private String empNo;

	/** 従業員名 */
	private String empName;

	/** パスワード */
	private String password;

	/**
	 * コンストラクタ(引数なし)
	 */
	public Employee() {

	}

	/**
	 * 従業員番号を取得する。
	 * @return 従業員番号
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * 従業員番号を設定する。
	 * @param empNo 従業員番号
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	/**
	 * 従業員名を取得する。
	 * @return 従業員名
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * 従業員名を設定する。
	 * @param empName 従業員名
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * パスワードを取得する。
	 * @return パスワード
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * パスワードを設定する。
	 * @param password パスワード
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
