package com.samples.twoSum;

import java.util.HashMap;
import java.util.Map;

public class TwoSumCalcMem implements ITwoSumCalc{

    public int[] run(int[] nums, int target) {
        // Given nums = [2, 7, 11, 15], target = 9,
        // Because nums[0] + nums[1] = 2 + 7 = 9,
        // return [0, 1].

        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i < nums.length; i++){
            int currentNubmer = nums[i];

            int remaining = target - currentNubmer;
            if (map.containsKey(remaining)){
                return new int[] {map.get(remaining), i};
            }

            map.put(currentNubmer, i);
        }

        return null;
    }
}
