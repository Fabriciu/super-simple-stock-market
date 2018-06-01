/**
 * 
 */
package com.stockMarket.business.impl;

import java.util.ArrayList;
import java.util.Objects;

import com.stockMarket.business.StockManagement;
import com.stockMarket.business.TradeManagement;
import com.stockMarket.domain.Stock;

/**
 * @author fabricio.borgatto
 *
 */
public class StockManagementImpl implements StockManagement {

	public int getDividend(Stock stock, int price) throws Exception {

		if(isValidStockAndPriceForDividend(stock, price)) {
			if(stock.getType().equals("Common"))
				stock.setDividendYield((int)(((double)stock.getLastDividend() / (double)price) * 100f));

			else if(stock.getType().equals("Preferred"))
				stock.setDividendYield( (int)((((double)stock.getFixedDividend() * (double)stock.getParValue()) / (double)price) * 100f) );

		} else
			throw new Exception("The values retrieved to calculate are not valid");

		
		return stock.getDividendYield();
	}

	private boolean isValidStockAndPriceForDividend(Stock stock, int price) {

		if(Objects.nonNull(stock) && Objects.nonNull(stock.getType())) {
			if(stock.getType().equals("Common")) { 
				if (Objects.nonNull(stock.getLastDividend()) && price != 0)
					return true;

			} else if(stock.getType().equals("Preferred")) { 
				if(Objects.nonNull(stock.getFixedDividend()) && 
						Objects.nonNull(stock.getParValue()) && 
						price != 0) {
					return true;
				}
			}

		}

		return false;
	}
	
	private boolean isValidStockForRatio(Stock stock) {
		
		if(Objects.nonNull(stock) && Objects.nonNull(stock.getDividendYield()) && stock.getDividendYield() != 0)
			return true;

		
		return false;
	}

	public int getPERatio(Stock stock, int price) throws Exception {

		if(isValidStockForRatio(stock))
			return ((int)(((double)price / (double)stock.getDividendYield())));
		else
			throw new Exception("The values retrieved to calculate are not valid");

	}
	
	public double getGBCEAllShareIndex(ArrayList<Stock> stockList) throws Exception {
		
		TradeManagement tradeManagement = new TradeManagementImpl();
		
		double volumeWeightedStockPrice = 1;
		double shareIndex = 0;
		int itens = 0;
		
		if(Objects.nonNull(stockList)) {
			for(Stock stock : stockList) {
				try {
					volumeWeightedStockPrice *= tradeManagement.getVolumeWeightedStockPrice(stock);
					itens++;
				} catch(NullPointerException e) {
					System.out.println("Stock not calculated");
				}
			}
			shareIndex = Math.pow(volumeWeightedStockPrice, 1.0/itens);
		}
		else {
			throw new NullPointerException("Stock list cannot be null");
		}
		
		return shareIndex;
	}

}
