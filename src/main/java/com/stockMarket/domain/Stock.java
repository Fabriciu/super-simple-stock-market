/**
 * 
 */
package com.stockMarket.domain;

import java.util.ArrayList;

/**
 * @author fabricio.borgatto
 *
 */
public class Stock {

	private String stockSymbol;
	private String type;
	private Integer lastDividend;
	private Integer fixedDividend;
	private Integer parValue;
	private Integer dividendYield;
	private ArrayList<Trade> trades;

	
	public Stock(String stockSymbol, String type, Integer lastDividend, Integer fixedDividend, Integer parValue,
			Integer dividendYield, ArrayList<Trade> trades) {
		super();
		this.stockSymbol = stockSymbol;
		this.type = type;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
		this.dividendYield = dividendYield;
		this.trades = trades;
	}
	
	public ArrayList<Trade> getTrades() {
		return trades;
	}

	public void setTrades(ArrayList<Trade> trades) {
		this.trades = trades;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(Integer lastDividend) {
		this.lastDividend = lastDividend;
	}

	public Integer getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(Integer fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public Integer getParValue() {
		return parValue;
	}

	public void setParValue(Integer parValue) {
		this.parValue = parValue;
	}

	public Integer getDividendYield() {
		return dividendYield;
	}

	public void setDividendYield(Integer dividendYield) {
		this.dividendYield = dividendYield;
	}







}
