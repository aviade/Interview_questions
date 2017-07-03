package com.samples.triplestep;

/**
 * Created by avezra on 7/2/2017.
 */
public class WaysToClimbCalculatorIterative implements WaysToClimbCalculator {
    @Override
    public int calcPossibleWays(int numberOfSteps) {
        if (numberOfSteps <= 2){
            return numberOfSteps;
        }

        int step0 = 0;
        int step1 = 1;
        int step2 = 2;

        int result = 0;

        for (int i = 2; i < numberOfSteps; i++) {
            result = (step0 + step1 + step2);

            // Shift
            step0 = step1;
            step1 = step2;
            step2 = result;
        }

        return result;
    }
}
