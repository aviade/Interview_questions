package com.samples.powerset;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by avezra on 7/2/2017.
 */
public class PowerSetCalculatorTest {
    private static final Boolean USE_BINARY = true;

    @Test
    public void calculatePowerSet_threeItems() throws Exception {
        final PowerSetCalculator calculator = createCalculator();
        final List<List<Integer>> result = calculator.calculatePowerSet(new int[]{0, 1, 2});

        printResult(result);

        List<int[]> expected = new ArrayList<>();
        expected.add(new int[]{0});
        expected.add(new int[]{0, 1});
        expected.add(new int[]{0, 1, 2});
        expected.add(new int[]{0, 2});
        expected.add(new int[]{1});
        expected.add(new int[]{1, 2});
        expected.add(new int[]{2});

        assertEquals(expected.size(), result.size());
        compareArrays(expected, result);
    }

    @Test
    public void calculatePowerSet_twoItems() throws Exception {
        final PowerSetCalculator calculator = createCalculator();
        final List<List<Integer>> result = calculator.calculatePowerSet(new int[]{0, 1});

        printResult(result);

        List<int[]> expected = new ArrayList<>();
        expected.add(new int[]{0});
        expected.add(new int[]{0, 1});
        expected.add(new int[]{1});

        assertEquals(expected.size(), result.size());
        compareArrays(expected, result);
    }

    private void printResult(List<List<Integer>> lists) {
        for (List<Integer> result: lists ){
            for (Integer item: result) {
                System.out.print(item + ",");
            }
            System.out.println();
        }
    }

    private PowerSetCalculator createCalculator() {
        if (USE_BINARY) {
            return new PowerSetCalculatorBinary();
        }
        return new PowerSetCalculatorRecursive();
    }

    private void compareArrays(List<int[]> expected, List<List<Integer>> result) {
        Boolean[] valid = new Boolean[result.size()];

        for (int[] expArray : expected) {
            for (int i = 0; i < result.size(); i++) {
                List<Integer> res = result.get(i);
                final int[] resArray = getArray(res);

                if (Arrays.equals(expArray, resArray)) {
                    valid[i] = true;
                    continue;
                }
            }
        }

        for (int i = 0; i < valid.length; i++) {
            assertEquals("No match at index " + i, true, valid[i]);
        }
    }

    private static int[] getArray(List<Integer> buffer) {
        final int[] array = buffer.stream().mapToInt(j -> j).toArray();

        return array;
    }
}