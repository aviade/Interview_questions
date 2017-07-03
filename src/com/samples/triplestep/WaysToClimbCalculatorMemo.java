package com.samples.triplestep;

/**
 * Created by avezra on 7/2/2017.
 */
public class WaysToClimbCalculatorMemo implements WaysToClimbCalculator {
    @Override
    public int calcPossibleWays(int numberOfSteps){
        return calcPossibleWaysRecursive(numberOfSteps, new int[numberOfSteps+1]);
    }

    private static int calcPossibleWaysRecursive(int stepIndex, int[] memo) {
        // Base case
        if (stepIndex <= 2){
            return stepIndex;
        }

        if (memo[stepIndex] == 0)
        {
            memo[stepIndex] = calcPossibleWaysRecursive(stepIndex - 1, memo) +
                    calcPossibleWaysRecursive(stepIndex - 2, memo) +
                    calcPossibleWaysRecursive(stepIndex - 3, memo);
        }

        return memo[stepIndex];
    }
}
