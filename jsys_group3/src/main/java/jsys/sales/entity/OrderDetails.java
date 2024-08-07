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
	public OrderDetails(String orderNo, String itemCode) {

	}
}
