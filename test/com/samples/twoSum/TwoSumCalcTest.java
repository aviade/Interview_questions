package com.samples.twoSum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TwoSumCalcTest {

    @Test
    public void twoSumCalc_firstNumbersMatch() throws Exception {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        ITwoSumCalc twoSumCalc = getTwoSumCalc();
        int[] result = twoSumCalc.run(nums, target);
        assertEquals(2, result.length);
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
    }

    @Test
    public void twoSumCalc_midNumbersMatch() throws Exception {
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        ITwoSumCalc twoSumCalc = getTwoSumCalc();
        int[] result = twoSumCalc.run(nums, target);
        assertEquals(2, result.length);
        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
    }

    @Test
    public void twoSumCalc_separateNumbersMatch() throws Exception {
        int[] nums = {2, 7, 11, 15};
        int target = 17;
        ITwoSumCalc twoSumCalc = getTwoSumCalc();
        int[] result = twoSumCalc.run(nums, target);
        assertEquals(2, result.length);
        assertEquals(0, result[0]);
        assertEquals(3, result[1]);
    }

    @Test
    public void twoSumCalc_lastNumbersMatch() throws Exception {
        int[] nums = {3, 2, 5};
        int target = 7;
        ITwoSumCalc twoSumCalc = getTwoSumCalc();
        int[] result = twoSumCalc.run(nums, target);
        assertEquals(2, result.length);
        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
    }

    @Test
    public void twoSumCalc_noMatch() throws Exception {
        int[] nums = {2, 7, 11, 15};
        int target = 3;
        ITwoSumCalc twoSumCalc = getTwoSumCalc();
        int[] result = twoSumCalc.run(nums, target);
        assertEquals(null, result);
    }

    private ITwoSumCalc getTwoSumCalc() {
        return new TwoSumCalcBrute();
    }
}
