package com.stockMarket.business;

import java.util.ArrayList;

import com.stockMarket.domain.Stock;

/**
 * @author fabricio.borgatto
 *
 */
public interface StockManagement {
	
	public int getDividend(Stock stock, int price) throws Exception;
	public int getPERatio(Stock stock, int price) throws Exception;
	public double getGBCEAllShareIndex(ArrayList<Stock> stockList) throws Exception;
	
}
