package com.samples.coinChange;

public class CoinChangeCalculator {
    public static int calc(int money, int[] coins) {
        return calcRecursive(money, coins, 0);
    }

    private static int calcRecursive(int money, int[] coins, int index) {
        boolean outOfMoney = money == 0;
        if (outOfMoney){
            return 1;
        }

        boolean outOfConis = index >= coins.length;
        if (outOfConis){
            return 0;
        }

        int moneyWithCoins = 0;
        int ways = 0;
        int remaining = 0;
        while(moneyWithCoins <= money){
            remaining = money - moneyWithCoins;
            ways += calcRecursive(remaining, coins, index+1);
            moneyWithCoins += coins[index];
        }

        return ways;
    }
}
