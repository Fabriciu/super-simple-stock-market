/**
 * 
 */
package com.stockMarket.business.test;

import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.stockMarket.business.TradeManagement;
import com.stockMarket.business.impl.TradeManagementImpl;
import com.stockMarket.domain.Stock;
import com.stockMarket.domain.Trade;

/**
 * @author fabricio.borgatto
 *
 */
public class TradeManagementTests {

	TradeManagement tradeManagement;
	
	@Test
	public void evaluateTradeCalculus() {
		
		Trade trade1 = new Trade();
		Trade trade2 = new Trade();
		Trade trade3 = new Trade();
		
		try {
			
			tradeManagement = new TradeManagementImpl();
			
			ArrayList<Trade> tradeList = new ArrayList<Trade>();
			
			Stock stock = new Stock("TEA", "Common", 8, null, 100, null, null);
			
			tradeManagement.createTrade(trade1, 1527862860000L, 2, true, false, 150);
			tradeList.add(trade1);
			
			tradeManagement.createTrade(trade2, 1527862865000L, 4, true, false, 100);
			tradeList.add(trade2);
			
			tradeManagement.createTrade(trade3, 1527691838000L, 5, true, false, 50);
			tradeList.add(trade3);
			
			stock.setTrades(tradeList);
			
			assertEquals(117, tradeManagement.getVolumeWeightedStockPriceByTime(stock));
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
