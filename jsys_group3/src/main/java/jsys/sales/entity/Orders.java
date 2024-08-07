/**
 * @author J11_宮澤奈保子（2024/8/7）
 */
package jsys.sales.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 受注エンティティ
 */
public class Orders implements Serializable {

	/* メンバ変数 */
	/** 受注番号 */
	private String orderNo;

	/** 得意先コード */
	private String custCode;

	/** 従業員番号 */
	private String empNo;

	/** 受注合計金額 */
	private int totalPrice;

	/** 受注明細件数 */
	private int detailNum;

	/** 納入日 */
	private Date deliverDate;

	/** 受注日 */
	private Date orderDate;

	/**
	 * コンストラクタ(引数なし)
	 */
	public Orders() {

	}

	/**
	 * 受注番号を取得する。
	 * @return 受注番号
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * 受注番号を設定する。
	 * @param orderNo 受注番号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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
	 * 受注合計金額を取得する。
	 * @return 受注合計金額
	 */
	public int getTotalPrice() {
		return totalPrice;
	}

	/**
	 * 受注合計金額を設定する。
	 * @param totalPrice 受注合計金額
	 */
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * 受注明細件数を取得する。
	 * @return 受注明細件数
	 */
	public int getDetailNum() {
		return detailNum;
	}

	/**
	 * 受注明細件数を設定する。
	 * @param detailNum 受注明細件数
	 */
	public void setDetailNum(int detailNum) {
		this.detailNum = detailNum;
	}

	/**
	 * 納入日を取得する。
	 * @return 納入日
	 */
	public Date getDeliverDate() {
		return deliverDate;
	}

	/**
	 * 納入日を設定する。
	 * @param deliverDate 納入日
	 */
	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
	}

	/**
	 * 受注日を取得する。
	 * @return 受注日
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * 受注日を設定する。
	 * @param 受注日
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

}
