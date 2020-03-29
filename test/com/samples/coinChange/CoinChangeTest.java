package com.samples.coinChange;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CoinChangeTest {

    @Test
    public void coinChangeTest_singleValue() throws Exception {
        int money = 50;
        int[] change = {50 };
        int ways = CoinChangeCalculator.calc(money, change);

        assertEquals(1, ways);
    }

    @Test
    public void coinChangeTest_multipleMatches() throws Exception {
        int money = 55;
        int[] change = {50, 5};
        int ways = CoinChangeCalculator.calc(money, change);

        assertEquals(2, ways);
    }

}
