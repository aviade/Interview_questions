package com.samples.stringfinder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by avezra on 6/27/2017.
 */
public class StringListFinderTest {
    @Test
    public void testFind_duplicateStrings() throws CharNotFoundException {
        char[] arr = new char[] { 'a', 'b', 'c' };
        String input = "aMMaDDbFcFD";
        final StringListFinderResult result = StringListFinder.find(input, arr);

        assertEquals(result.minIndex, 3);
        assertEquals(result.maxIndex, 8);
    }

    @Test
    public void testFind_pangram() throws CharNotFoundException {
        char[] arr = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String input = "The quick brown fox jumps over the lazy dog";
        final StringListFinderResult result = StringListFinder.find(input, arr);

        assertEquals(result.minIndex, 4);
        assertEquals(result.maxIndex, 42);
    }

    @Test
    public void testFind_emptyChars() throws CharNotFoundException {
        char[] arr = new char[] {  };
        String input = "";
        final StringListFinderResult result = StringListFinder.find(input, arr);
        assertEquals(result.minIndex, 0);
        assertEquals(result.maxIndex, 0);
    }

    @Test(expected = CharNotFoundException.class)
    public void testFind_emptyString() throws CharNotFoundException {

        char[] arr = new char[] { 'a', 'b', 's' };
        String input = "";
        StringListFinder.find(input, arr);
    }

    @Test(expected = CharNotFoundException.class)
    public void testFind_missingChar() throws CharNotFoundException {
        char[] arr = new char[] { 'a', 'b', 's' };
        String input = "aMMaDDbFcFD";
        StringListFinder.find(input, arr);
    }
}