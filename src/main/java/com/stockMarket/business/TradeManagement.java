package com.stockMarket.business;

import com.stockMarket.domain.Stock;
import com.stockMarket.domain.Trade;

/**
 * @author fabricio.borgatto
 *
 */
public interface TradeManagement {

	public void createTrade(Trade trade, long timestamp, int quantity, boolean isBuying, 
			boolean isSelling, int price) throws Exception;
	public int getVolumeWeightedStockPriceByTime(Stock stock) throws Exception;
	public int getVolumeWeightedStockPrice(Stock stock) throws Exception;
	
}
