package com.samples.twoSum;

public class TwoSumCalcBrute implements ITwoSumCalc{

    public int[] run(int[] nums, int target) {
        // Given nums = [2, 7, 11, 15], target = 9,
        // Because nums[0] + nums[1] = 2 + 7 = 9,
        // return [0, 1].
        return run(nums, target, 0);
    }

    public static int[] run(int[] nums, int target, int curPosition) {
        // base case
        if (curPosition >= nums.length){
            return null;
        }
        for (int index = curPosition; index < nums.length; index++){
            if (nums[curPosition] + nums[index] == target){
                return new int[] {curPosition, index};
            }
        }

        return run(nums, target, curPosition+1);
    }
}

