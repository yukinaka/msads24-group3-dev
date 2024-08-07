/**
 * @author J08_中井俊（2024/8/7）
 */

package jsys.sales.entity;

import java.io.Serializable;

/**
 * 得意先エンティティ
 */
public class Customer implements Serializable{

	/** 得意先コード */
	private String custCode;

	/** 得意先名 */
	private String custName;

	/** 電話番号1 */
	private String telNo1;

	/** 電話番号2 */
	private String telNo2;

	/** 電話番号3 */
	private String telNo3;

	/** 郵便番号1 */
	private String postalCode1;

	/** 住所1 */
	private String address1;

	/** 郵便番号2 */
	private String postalCode2;

	/** 住所2 */
	private String address2;

	/** 割引率 */
	private int discountRate;

	/** 削除フラグ */
	private boolean deleteFlag;

	/** 最終更新者番号 */
	private String lastUpdateBy;

	/**
	 * コンストラクタ（引数なし）
	 */
	public Customer() {
	}

	/**
	 * コンストラクタ:引数で指定した値を設定する。
	 * @param custCode 得意先コード
	 * @param custName 得意先名
	 * @param telNo1 電話番号1
	 * @param telNo2 電話番号2
	 * @param telNo3 電話番号3
	 * @param postalCode1 郵便番号1
	 * @param address1 住所1
	 * @param postalCode2 郵便番号2
	 * @param address2 住所2
	 * @param discountRate 割引率
	 * @param deleteFlag 削除フラグ
	 * @param lastUpdateBy 最終更新者番号
	 */
	public Customer(String custCode, String custName, String telNo1,
			String telNo2, String telNo3,String postalCode1, String address1,
			String postalCode2, String address2, int discountRate,
			boolean deleteFlag, String lastUpdateBy) {
		this.custCode = custCode;
		this.custName = custName;
		this.telNo1 = telNo1;
		this.telNo2 = telNo2;
		this.telNo3 = telNo3;
		this.postalCode1 = postalCode1;
		this.address1 = address1;
		this.postalCode2 = postalCode2;
		this.address2 = address2;
		this.deleteFlag = deleteFlag;
		this.lastUpdateBy = lastUpdateBy;
		this.discountRate = discountRate;
	}

	/**
	 * 得意先コードを取得する。
	 * @return 得意先コード
	 */
	public String getCustCode() {
		return custCode;
	}
	/**
	 * 得意先コードを設定する。
	 * @param custCode 得意先コード
	 */
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	/**
	 * 得意先名を取得する。
	 * @return 得意先名
	 */
	public String getCustName() {
		return custName;
	}
	/**
	 * 得意先名を設定する。
	 * @param custName 得意先名
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}

	/**
	 * 電話番号1を取得する。
	 * @return 電話番号1
	 */
	public String getTelNo1() {
		return telNo1;
	}
	/**
	 * 電話番号1を設定する。
	 * @param telNo1 電話番号1
	 */
	public void setTelNo1(String telNo1) {
		this.telNo1 = telNo1;
	}

	/**
	 * 電話番号2を取得する。
	 * @return 電話番号2
	 */
	public String getTelNo2() {
		return telNo2;
	}
	/**
	 * 電話番号2を設定する。
	 * @param telNo2 電話番号2
	 */
	public void setTelNo2(String telNo2) {
		this.telNo2 = telNo2;
	}

	/**
	 * 電話番号3を取得する。
	 * @return 電話番号3
	 */
	public String getTelNo3() {
		return telNo3;
	}
	/**
	 * 電話番号3を設定する。
	 * @param telNo3 電話番号3
	 */
	public void setTelNo3(String telNo3) {
		this.telNo3 = telNo3;
	}

	/**
	 * 郵便番号1を取得する。
	 * @return 郵便番号1
	 */
	public String getPostalCode1() {
		return postalCode1;
	}
	/**
	 * 郵便番号1を設定する。
	 * @param postalCode1 郵便番号1
	 */
	public void setPostalCode1(String postalCode1) {
		this.postalCode1 = postalCode1;
	}

	/**
	 * 住所1を取得する。
	 * @return 住所1
	 */
	public String getAddress1() {
		return address1;
	}
	/**
	 * 住所1を設定する。
	 * @param address1 住所1
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * 郵便番号2を取得する。
	 * @return 郵便番号2
	 */
	public String getPostalCode2() {
		return postalCode2;
	}
	/**
	 * 郵便番号2を設定する。
	 * @param postalCode2 郵便番号2
	 */
	public void setPostalCode2(String postalCode2) {
		this.postalCode2 = postalCode2;
	}

	/**
	 * 住所2を取得する。
	 * @return 住所2
	 */
	public String getAddress2() {
		return address2;
	}
	/**
	 * 住所2を設定する。
	 * @param address2 住所2
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * 削除フラグを取得する。
	 * @return deleteFlag
	 */
	public boolean isDeleteFlag() {
		return deleteFlag;
	}
	/**
	 * 削除フラグを設定する。
	 * @param deleteFlag
	 */
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * 最終更新者番号を取得する。
	 * @return lastUpdateBy
	 */
	public String getLastUpdateBy() {
		return lastUpdateBy;
	}
	/**
	 * 最終更新者番号を設定する。
	 * @param lastUpdateBy
	 */
	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	/**
	 * 割引率を取得する。
	 * @return 割引率
	 */
	public int getDiscountRate() {
		return discountRate;
	}
	/**
	 * 割引率を設定する。
	 * @param discountRate 割引率
	 */
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
}