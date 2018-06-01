package com.stockMarket.business.impl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Objects;

import com.stockMarket.business.TradeManagement;
import com.stockMarket.domain.Stock;
import com.stockMarket.domain.Trade;

/**
 * @author fabricio.borgatto
 *
 */
public class TradeManagementImpl implements TradeManagement {

	public void createTrade(Trade trade, long timestamp, int quantity, boolean isBuying, 
			boolean isSelling, int price) throws Exception{

		if((true == isBuying && false == isSelling) || (false == isBuying && true == isSelling)) {

			trade.setTimestamp(timestamp);
			trade.setQuantity(quantity);
			trade.setBuying(isBuying);
			trade.setSelling(isSelling);
			trade.setPrice(price);

			return;

		} else
			throw new Exception("The values for isBuying and isSelling cannot be the same");

	}

	public int getVolumeWeightedStockPriceByTime(Stock stock) throws Exception {

		Instant instant = Instant.now().minusMillis(300000);
		long minimumTimestamp = instant.toEpochMilli();

		int volumeWeightedStockPrice = 0;

		float dividend = 0;
		float divisor = 0;

		if(Objects.nonNull(stock)) {
			ArrayList<Trade> tradeList = stock.getTrades();

			for(Trade trade : tradeList) {

				if(trade.getTimestamp() >= minimumTimestamp ) {
					dividend += (float)trade.getPrice() * (float)trade.getQuantity();
					divisor += (float)trade.getQuantity(); 
				}

			}

			if(divisor != 0)
				volumeWeightedStockPrice = (int) Math.ceil(dividend / divisor);
			else
				throw new Exception("Error calculating stock price");
		} else
			throw new NullPointerException("Stock cannot be null");


		return volumeWeightedStockPrice;
	}

	public int getVolumeWeightedStockPrice(Stock stock) throws Exception {

		int volumeWeightedStockPrice = 0;

		float dividend = 0;
		float divisor = 0;

		if(Objects.nonNull(stock)) {

			ArrayList<Trade> tradeList = stock.getTrades();

			for(Trade trade : tradeList) {

				dividend += (float)trade.getPrice() * (float)trade.getQuantity();
				divisor += (float)trade.getQuantity(); 

			}

			if(divisor != 0)
				volumeWeightedStockPrice = (int) Math.ceil(dividend / divisor);
			else
				throw new Exception("Error calculating stock price");

		} else
			throw new NullPointerException("Stock cannot be null");


		return volumeWeightedStockPrice;
	}


}
