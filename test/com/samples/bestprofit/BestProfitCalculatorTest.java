package com.samples.bestprofit;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by avezra on 7/1/2017.
 */
public class BestProfitCalculatorTest {
    @Test
    public void getBestProfit_bestBuyTimeChanged() throws Exception {
        final StockInfo[] stockPricesYesterday = new StockInfo[]{
                new StockInfo(0, 10),
                new StockInfo(30, 500),
                new StockInfo(60, 5),
                new StockInfo(90, 6),
                new StockInfo(120, 500),
                new StockInfo(150, 10)
        };
        final SellBuyDetails bestProfit = BestProfitCalculator.getBestProfit(stockPricesYesterday);

        assertEquals(bestProfit.buyTime, 60);
        assertEquals(bestProfit.sellTime, 120);
    }

    @Test
    public void getBestProfit_bestSellTimeChanged() throws Exception {
        final StockInfo[] stockPricesYesterday = new StockInfo[]{
                new StockInfo(0, 10),
                new StockInfo(30, 15),
                new StockInfo(60, 400),
                new StockInfo(90, 500),
        };
        final SellBuyDetails bestProfit = BestProfitCalculator.getBestProfit(stockPricesYesterday);

        assertEquals(bestProfit.buyTime, 0);
        assertEquals(bestProfit.sellTime, 90);
    }

    @Test
    public void getBestProfit_bestBuyTimeChanged_bestSellTimeChanged() throws Exception {
        final StockInfo[] stockPricesYesterday = new StockInfo[]{
                new StockInfo(0, 10),
                new StockInfo(30, 15),
                new StockInfo(60, 400),
                new StockInfo(90, 0),
                new StockInfo(120, 500),
        };
        final SellBuyDetails bestProfit = BestProfitCalculator.getBestProfit(stockPricesYesterday);

        assertEquals(bestProfit.buyTime, 90);
        assertEquals(bestProfit.sellTime, 120);
    }

    @Test
    public void getBestProfit_emptyInput_nulloutput() throws Exception {
        final StockInfo[] stockPricesYesterday = new StockInfo[]{
        };
        final SellBuyDetails bestProfit = BestProfitCalculator.getBestProfit(stockPricesYesterday);

        assertNull(bestProfit);
    }

    @Test
    public void getBestProfit_singleitem() throws Exception {
        final StockInfo[] stockPricesYesterday = new StockInfo[]{
                new StockInfo(0, 10),
        };
        final SellBuyDetails bestProfit = BestProfitCalculator.getBestProfit(stockPricesYesterday);

        assertEquals(bestProfit.buyTime, 0);
        assertEquals(bestProfit.sellTime, 0);
    }
}