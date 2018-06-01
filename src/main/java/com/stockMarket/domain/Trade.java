/**
 * 
 */
package com.stockMarket.domain;

/**
 * @author fabricio.borgatto
 *
 */
public class Trade {

	private long timestamp;
	private int quantity;
	private boolean isBuying;
	private boolean isSelling;
	private int price;

	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isBuying() {
		return isBuying;
	}
	public void setBuying(boolean isBuying) {
		this.isBuying = isBuying;
	}
	public boolean isSelling() {
		return isSelling;
	}
	public void setSelling(boolean isSelling) {
		this.isSelling = isSelling;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
