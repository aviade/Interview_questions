package com.samples.triplestep;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by avezra on 7/2/2017.
 */
public class PossibleStepsCalculatorTest {

    private static final Approach APPROACH = Approach.Brute;

    @Test
    public void calcPossibleWays_baseCases() throws Exception {
        WaysToClimbCalculator calculator = createCalculator();
        int possibleWays = calculator.calcPossibleWays(2);
        assertEquals(2, possibleWays);

        possibleWays = calculator.calcPossibleWays(1);
        assertEquals(1, possibleWays);

        possibleWays = calculator.calcPossibleWays(0);
        assertEquals(0, possibleWays);
    }

    @Test
    public void calcPossibleWays_smallInput() throws Exception {
        WaysToClimbCalculator calculator = createCalculator();

        int possibleWays = calculator.calcPossibleWays(4);
        assertEquals(6, possibleWays);

        possibleWays = calculator.calcPossibleWays(5);
        assertEquals(11, possibleWays);
    }

    private WaysToClimbCalculator createCalculator() {
        if (APPROACH == Approach.Brute) {
            return new WaysToClimbCalculatorBruteForce();
        } else if (APPROACH == Approach.Memo) {
            return new WaysToClimbCalculatorMemo();
        }
        return new WaysToClimbCalculatorIterative();
    }

    enum Approach {
        Brute,
        Memo,
        Iterative
    }
}