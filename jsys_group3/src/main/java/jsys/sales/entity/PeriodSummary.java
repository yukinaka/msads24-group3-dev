/**
 * @author J22_油井（2024/8/7）
 */
package jsys.sales.entity;

import java.io.Serializable;

/**
 * 期間内受注集計テーブルの情報を操作する
 */
public class PeriodSummary implements Serializable{

	/** 得意先コード */
	private String custCode;

	/** 得意先名 */
	private String custName;

	/** 得意先別合計金額 */
	private int totalPricePerCust ;

	/**
	 * コンストラクタ（引数なし）
	 */
	public PeriodSummary() {
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
	 * 得意先別合計金額を取得する。
	 * @return 得意先別合計金額
	 */
	public int getTotalPricePerCust() {
		return totalPricePerCust;
	}

	/**
	 * 得意先別合計金額を設定する。
	 * @param totalPricePerCust 得意先別合計金額
	 */
	public void setTotalPricePerCust(int totalPricePerCust) {
		this.totalPricePerCust = totalPricePerCust;
	}
}
