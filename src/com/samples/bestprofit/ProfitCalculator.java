package com.samples.bestprofit;

/**
 * Created by avezra on 7/1/2017.
 */
class BestProfitCalculator {
    public static SellBuyDetails getBestProfit(StockInfo[] stockPricesYesterday)
    {
        if (stockPricesYesterday.length == 0){
            return null;// todo: throw error
        }

        StockInfo candidate = stockPricesYesterday[0];
        int bestProfit = Integer.MIN_VALUE;
        int bestSellTime = candidate.minutesIntoTheDay;
        int bestBuyTIme = candidate.minutesIntoTheDay;

        for (int i = 1; i < stockPricesYesterday.length; i++) {
            StockInfo stockInfo = stockPricesYesterday[i];

            if (stockInfo.stockPrice < candidate.stockPrice)
            {
                candidate = stockInfo;
            }

            int newPossibleProfit = stockInfo.stockPrice - candidate.stockPrice;
            if (newPossibleProfit > bestProfit)
            {
                bestProfit = newPossibleProfit;
                bestBuyTIme = candidate.minutesIntoTheDay;
                bestSellTime = stockInfo.minutesIntoTheDay;
            }
        }

        return new SellBuyDetails(bestBuyTIme, bestSellTime);
    }
}

