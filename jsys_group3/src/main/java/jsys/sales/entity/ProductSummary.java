/**
 * @author J11_宮澤奈保子（2024/8/7）
 */
package jsys.sales.entity;

import java.io.Serializable;

/**
 * 商品別受注集計エンティティ
 */
public class ProductSummary implements Serializable {

	/* メンバ変数 */
	/** 商品コード */
	private String itemCode;

	/** 商品名 */
	private String itemName;

	/** 合計数量 */
	private int totalNum;

	/** 単価 */
	private int itemPrice;

	/** 商品別合計金額 */
	private int totalPricePerItem;

	/**
	 * コンストラクタ(引数なし)
	 */
	public ProductSummary() {

	}

	/**
	 * 商品コードを取得する。
	 * @return 商品コード
	 */
	public String getItemCode() {
		return itemCode;
	}

	/**
	 * 商品コードを設定する。
	 * @param itemCode 商品コード
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	/**
	 * 商品名を取得する。
	 * @return 商品名
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * 商品名を設定する。
	 * @param itemName 商品名
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * 合計数量を取得する。
	 * @return 合計数量
	 */
	public int getTotalNum() {
		return totalNum;
	}

	/**
	 * 合計数量を設定する。
	 * @param totalNum 合計数量
	 */
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	/**
	 * 単価を取得する。
	 * @return 単価
	 */
	public int getItemPrice() {
		return itemPrice;
	}

	/**
	 * 単価を設定する。
	 * @param itemPrice 単価
	 */
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	/**
	 * 商品別合計金額を取得する。
	 * @return 商品別合計金額
	 */
	public int getTotalPricePerItem() {
		return totalPricePerItem;
	}

	/**
	 * 商品別合計金額を設定する。
	 * @param totalPricePerItem 商品別合計金額
	 */
	public void setTotalPricePerItem(int totalPricePerItem) {
		this.totalPricePerItem = totalPricePerItem;
	}

}
