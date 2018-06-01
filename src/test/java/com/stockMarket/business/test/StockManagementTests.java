/**
 * 
 */
package com.stockMarket.business.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import com.stockMarket.business.StockManagement;
import com.stockMarket.business.TradeManagement;
import com.stockMarket.business.impl.StockManagementImpl;
import com.stockMarket.business.impl.TradeManagementImpl;
import com.stockMarket.domain.Stock;
import com.stockMarket.domain.Trade;

/**
 * @author fabricio.borgatto
 *
 */
public class StockManagementTests {

	@Test
	public void evaluateCalculus() {
		StockManagement stockTester = new StockManagementImpl();

		Stock stock1 = new Stock("POP", "Common", 8, null, 100, null, null);
		Stock stock2 = new Stock("GIN", "Preferred", 8, 2, 100, null, null);
		Stock stock3 = new Stock("JOE", "Common", 13, null, 250, 4, null);

		try {
			assertEquals(4, stockTester.getDividend(stock1, 200));
			assertEquals(250, stockTester.getDividend(stock2, 80));

			assertEquals(5, stockTester.getPERatio(stock3, 20));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void evaluatePERatioCalculus() {
		StockManagement stockTester = new StockManagementImpl();

		Stock stock1 = new Stock("GIN", "Preferred", 8, 2, 100, null, null);
		Stock stock2 = new Stock("JOE", "Common", 13, null, 250, 0, null);

		try {
			stockTester.getDividend(stock2, 0);
			stockTester.getPERatio(stock1, 20);
			fail("Expected Exception thrown");
		} catch (Exception e) {
			//System.out.println(e.getMessage());
		}
	}

	@Test
	public void evaluateGBCEAllShareIndexCalculus() {


		TradeManagement tradeManagement = new TradeManagementImpl();
		ArrayList<Trade> tradeList = new ArrayList<Trade>();

		try {

			/*
			 * Creating trades for stock1
			 */
			Trade trade1 = new Trade();
			tradeManagement.createTrade(trade1, 1527806940000L, 2, true, false, 150);
			Trade trade2 = new Trade();
			tradeManagement.createTrade(trade2, 1527806941000L, 4, true, false, 100);
			tradeList.add(trade1);
			tradeList.add(trade2);
			Stock stock1 = new Stock("TEA", "Common", 0, null, 100, null, tradeList);

			Stock stock2 = new Stock("POP", "Common", 8, null, 100, null, null);
			Stock stock3 = new Stock("ALE", "Common", 23, null, 60, null, null);
			Stock stock4 = new Stock("GIN", "Preferred", 8, 2, 100, null, null);

			/*
			 * Creating trades for stock5
			 */
			Trade trade3 = new Trade();
			tradeManagement.createTrade(trade3, 1527806940000L, 2, true, false, 150);
			Trade trade4 = new Trade();
			tradeManagement.createTrade(trade4, 1527806941000L, 4, true, false, 100);
			tradeList.clear();
			tradeList.add(trade3);
			tradeList.add(trade4);
			Stock stock5 = new Stock("JOE", "Common", 13, null, 250, 4, tradeList);

			ArrayList<Stock> stockList = new ArrayList<Stock>();
			stockList.add(stock1);
			stockList.add(stock2);
			stockList.add(stock3);
			stockList.add(stock4);
			stockList.add(stock5);

			StockManagement stockTester = new StockManagementImpl();

			assertEquals(117.0, stockTester.getGBCEAllShareIndex(stockList));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
