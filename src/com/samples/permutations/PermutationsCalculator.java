package com.samples.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by avezra on 6/28/2017.
 */
public class PermutationsCalculator {
    public static List<List<Integer>> Calc(Integer[] input)
    {
        List<List<Integer>> ret = new ArrayList<>();

        CalcRecursive(ret, new ArrayList<>(Arrays.asList(input)), new ArrayList<>());
        return ret;
    }

    private static void CalcRecursive(List<List<Integer>> ret, List<Integer> input, List<Integer> buffer) {
        if (input.size() == 1)
        {
            buffer.add(input.get(0));
            ret.add(buffer);
            return;
        }

        for (int i = 0; i < input.size(); i++) {
            List<Integer> newBuffer = new ArrayList<>(buffer);
            newBuffer.add(input.get(i));

            List<Integer> reducedInput = new ArrayList<>(input);
            reducedInput.remove(i);
            CalcRecursive(ret, reducedInput, newBuffer);
        }
    }
}
