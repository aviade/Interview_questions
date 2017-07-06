package com.samples.permutations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by avezra on 6/28/2017.
 */
public class PermutationsCalculatorTest {
    @Test
    public void calc_twoItems() throws Exception {
        final Integer[] input = {3, 5};
        final List<List<Integer>> list = PermutationsCalculator.Calc(input);

        int expectedCount = getExpectedCount(input);

        assertEquals(expectedCount, list.size());

        assertArrayEquals(new int[] {3, 5}, getArray(list.get(0)));
        assertArrayEquals(new int[] {5, 3}, getArray(list.get(1)));
    }

    @Test
    public void calc_threeItems() throws Exception {
        final Integer[] input = {3, 5, 8};
        final List<List<Integer>> list = PermutationsCalculator.Calc(input);

        int expectedCount = getExpectedCount(input);

        assertEquals(expectedCount, list.size());

        assertArrayEquals(new int[] {3, 5, 8}, getArray(list.get(0)));
        assertArrayEquals(new int[] {3, 8, 5}, getArray(list.get(1)));
        assertArrayEquals(new int[] {5, 3, 8}, getArray(list.get(2)));
        assertArrayEquals(new int[] {5, 8, 3}, getArray(list.get(3)));
        assertArrayEquals(new int[] {8, 3, 5}, getArray(list.get(4)));
        assertArrayEquals(new int[] {8, 5, 3}, getArray(list.get(5)));
    }

    @Test
    public void calc_fiveItems() throws Exception {
        final Integer[] input = {3, 5, 8, 9, 10};
        final List<List<Integer>> list = PermutationsCalculator.Calc(input);

        int expectedCount = getExpectedCount(input);

        assertEquals(expectedCount, list.size());
    }

    @Test
    public void calc_emptyInput() throws Exception {
        final Integer[] input = {};
        final List<List<Integer>> list = PermutationsCalculator.Calc(input);

        int expectedCount = getExpectedCount(input);

        assertEquals(expectedCount, list.size());
    }

    private int getExpectedCount(Integer[] input) {
        if (input.length == 0) {
            return 0;
        }

        int expectedCount = 1;
        for (int i = 0; i < input.length; i++) {
            expectedCount *= i+1;
        }
        return expectedCount;
    }

    private static int[] getArray(List<Integer> buffer) {
        final int[] array = buffer.stream().mapToInt(j -> j).toArray();

        return array;
    }
}