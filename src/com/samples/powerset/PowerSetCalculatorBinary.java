package com.samples.powerset;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avezra on 7/3/2017.
 */
public class PowerSetCalculatorBinary implements PowerSetCalculator {
    @Override
    public List<List<Integer>> calculatePowerSet(int[] set) {

        List<List<Integer>> result = new ArrayList<>();

        int numberOfCombinations = (int) Math.pow(2, set.length);

        for (int mask = 1; mask < numberOfCombinations; mask++) {
            List<Integer> sequence = getSequence(mask, set);
            result.add(sequence);
        }
        return result;
    }

    private List<Integer> getSequence(int mask, int[] set) {
        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < set.length; index++) {
            int factor = 1 << index;
            if ((factor & mask) > 0){
                result.add(set[index]);
            }
        }
        return result;
    }
}
