package com.samples.intmultiplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by avezra on 7/4/2017.
 */
public class IntMultiplyTest {
    @Test
    public void multiply_even() throws Exception {
        final int n1 = 2;
        final int n2 = 4;
        final int result1 = IntMultiply.multiply(n1, n2);
        assertEquals(n1 * n2, result1);
    }

    @Test
    public void multiply_odd() throws Exception {
        final int n1 = 2;
        final int n2 = 3;
        final int result1 = IntMultiply.multiply(n1, n2);
        assertEquals(n1 * n2, result1);
    }

    @Test
    public void multiply_smallerAfterBigger() throws Exception {
        final int n1 = 6;
        final int n2 = 4;
        final int result1 = IntMultiply.multiply(n1, n2);
        assertEquals(n1 * n2, result1);
    }

    @Test
    public void multiply_evenBig() throws Exception {
        final int n1 = 12;
        final int n2 = 10;
        final int result1 = IntMultiply.multiply(n1, n2);
        assertEquals(n1 * n2, result1);
    }

    @Test
    public void multiply_oddBig() throws Exception {
        final int n1 = 30;
        final int n2 = 25;
        final int result1 = IntMultiply.multiply(n1, n2);
        assertEquals(n1 * n2, result1);
    }

    @Test
    public void multiply_rangeOfSmallers() throws Exception {
        int n1 = 0;
        final int n2 = 25;

        for (int i = 0; i < 100; i++) {
            final int result1 = IntMultiply.multiply(n1, n2);
            assertEquals(n1 * n2, result1);

            n1++;
        }
    }

    @Test
    public void multiply_zero() throws Exception {
        final int n1 = 0;
        final int n2 = 25;
        final int result1 = IntMultiply.multiply(n1, n2);
        assertEquals(n1 * n2, result1);
    }
}