/**
 * @author J08_中井俊（2024/8/7）
 */

/**
 * OrderDetails.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package jsys.sales.entity;

import java.io.Serializable;

/**
 * 受注明細エンティティ
 */
public class OrderDetails implements Serializable{

	/** 受注番号 */
	private String orderNo;

	/** 商品コード */
	private String itemCode;

	/** 受注明細件数 */
	private int orderNum;

	/** 受注合計金額 */
	private int orderPrice;

	/**
	 * コンストラクタ（引数なし）
	 */
	public OrderDetails() {
	}

	/**
	 * コンストラクタ:引数で指定した値を設定する。
	 * @param orderNo 受注番号
	 * @param itemCode 商品コード
	 * @param orderNum 受注明細件数
	 * @param orderPrice 受注合計金額
	 */
	public OrderDetails(String orderNo, String itemCode, int orderNum, int orderPrice) {
		orderNo = this.orderNo;
		itemCode = this.itemCode;
		orderNum  = this.orderNum;
		orderPrice = this.orderPrice;
	}

	/**
	 * orderNoを取得する。
	 * @return orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * orderNoを設定する。
	 * @param orderNo
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * itemCodeを取得する。
	 * @return itemCode
	 */
	public String getItemCode() {
		return itemCode;
	}
	/**
	 * itemCodeを設定する。
	 * @param itemCode
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	/**
	 * orderNumを取得する。
	 * @return orderNum
	 */
	public int getOrderNum() {
		return orderNum;
	}
	/**
	 * orderNumを設定する。
	 * @param orderNum
	 */
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * orderPriceを取得する。
	 * @return orderPrice
	 */
	public int getOrderPrice() {
		return orderPrice;
	}
	/**
	 * orderPriceを設定する。
	 * @param orderPrice
	 */
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

}
