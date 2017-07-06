package com.samples.parens;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by avezra on 7/6/2017.
 */
public class ParenthesesBuilderTest {
    private static final boolean USE_BINARY = false;
    @Test
    public void getPairs_oneItem() throws Exception {
        ParenthesesBuilder builder = createBuilder(USE_BINARY);

        final String[] result = builder.getPairs(1);
        printParis(result);

        assertEquals(1, result.length);

        assertEquals("()", result[0]);
    }

    @Test
    public void getPairs_twoItem() throws Exception {
        ParenthesesBuilder builder = createBuilder(USE_BINARY);

        final String[] result = builder.getPairs(2);
        printParis(result);

        assertEquals(2, result.length);

        final String[] expected = {
                "()()",
                "(())",
        };
        compareArraysIgnoreOrder(expected, result);
    }

    @Test
    public void getPairs_threeItem() throws Exception {
        ParenthesesBuilder builder = createBuilder(USE_BINARY);
        final String[] result = builder.getPairs(3);

        printParis(result);
        assertEquals(5, result.length);

        final String[] expected = {
                // Added to beginning of     ()()
                "()()()",
                // Added after first par of  ()()
                "(())()",
                // Added after second par of ()()
                "()(())",
                // Added to beginning of     (()) -- Dup
                // "()(())",
                // Added after first par of  (())
                "(()())",
                // Added after second par of (())
                "((()))",
        };

        compareArraysIgnoreOrder(expected, result);

    }

    @Test
    public void getPairs_binaryVsRecursive() throws Exception {
        ParenthesesBuilder builderBinary = new ParenthesesBuilderBinary();
        ParenthesesBuilder builderRecursive = new ParenthesesBuilderRecursive();


        final String[] resultBinary = builderBinary.getPairs(4);
        final String[] resultRecursive = builderRecursive.getPairs(4);

        System.out.println("Binary");
        printParis(resultBinary);

        System.out.println("Recursive");
        printParis(resultRecursive);

        compareArraysIgnoreOrder(resultBinary, resultRecursive);
    }

    private void printParis(String[] pairs) {
        for (String s: pairs) {
            System.out.println(s);
        }
    }

    private void compareArraysIgnoreOrder(String[] expected, String[] actual) {

        List<String> expectedList = new ArrayList<>(Arrays.asList(expected));

        for (int i = 0; i < actual.length; i++) {
            final String s = actual[i];

            final boolean contains = expectedList.contains(s);
            if (contains)
            {
                expectedList.remove(s);
            }
        }

        if (expectedList.size() == 0)
        {
            return;
        }
        StringBuilder error = new StringBuilder();
        for (String missing: expectedList) {
            error.append(String.format("Can't find %s \n", missing));
        }
        fail(error.toString());

    }

    private ParenthesesBuilder createBuilder(boolean useBinary) {
        if (useBinary) {
            return new ParenthesesBuilderBinary();
        }
        return new ParenthesesBuilderRecursive();
    }
}