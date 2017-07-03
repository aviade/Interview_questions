package com.samples.triplestep;

/**
 * Created by avezra on 7/2/2017.
 */
public class WaysToClimbCalculatorBruteForce implements WaysToClimbCalculator{

    @Override
    public int calcPossibleWays(int numberOfSteps){
        return calcPossibleWaysRecursive(numberOfSteps);
    }

    private static int calcPossibleWaysRecursive(int stepIndex) {
        // Base case
        if (stepIndex <= 2){
            return stepIndex;
        }

        return calcPossibleWaysRecursive(stepIndex - 1) +
                calcPossibleWaysRecursive(stepIndex - 2) +
                calcPossibleWaysRecursive(stepIndex - 3);
    }
}
