package com.samples.powerset;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avezra on 7/2/2017.
 */
public class PowerSetCalculatorRecursive implements PowerSetCalculator{

    @Override
    public List<List<Integer>> calculatePowerSet(int[] set) {
        List<List<Integer>> result = new ArrayList<>();

        calculatePowerSetRecursive(set, 0, result, new ArrayList<Integer>());

        return result;
    }

    private void calculatePowerSetRecursive(
            int[] set,
            int index,
            List<List<Integer>> result,
            ArrayList<Integer> buffer) {

        for (int i = index; i < set.length; i++) {
            ArrayList<Integer> newBuffer = new ArrayList<>(buffer);
            newBuffer.add(set[i]);

            // Add buffer to result
            result.add(newBuffer);

            // Call recursion with next index and updated buffer
            calculatePowerSetRecursive(set, i+1, result, newBuffer);
        }
    }
}
