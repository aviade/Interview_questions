package com.samples.matrixofwords;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by avezra on 6/29/2017.
 */
public class FindWordsTest {
    @Test
    public void findWordsInMatrix_allWordsExist() throws Exception {
        char[][] matrix = getMatrix();

        final String[] lookupList = {"ALL", "LOL"};
        final List<String> results = WordsFinder.findWordsInMatrix(new Matrix(matrix), lookupList);
        assertArrayEquals(lookupList, results.toArray(new String[0]));
    }

    @Test
    public void findWordsInMatrix_someWordsExist() throws Exception {
        char[][] matrix = getMatrix();

        final String[] lookupList = {"ALL", "LOL", "LOAN"};
        final List<String> results = WordsFinder.findWordsInMatrix(new Matrix(matrix), lookupList);

        final String[] expectedList = {"ALL", "LOL"};
        assertArrayEquals(expectedList, results.toArray(new String[0]));
    }

    @Test
    public void findWordsInMatrix_noWordExist() throws Exception {
        char[][] matrix = getMatrix();

        final String[] lookupList = {"MLL", "MOL"};
        final List<String> results = WordsFinder.findWordsInMatrix(new Matrix(matrix), lookupList);

        final String[] expectedList = {};
        assertArrayEquals(expectedList, results.toArray(new String[0]));
    }

    private char[][] getMatrix() {
        char[][] matrix = new char[4][];
        matrix[0] = new char[] {'A', 'G', 'H', 'N'};
        matrix[1] = new char[] { 'U', 'L', 'O', 'A' };
        matrix[2] = new char[] { 'N', 'M', 'L', 'K' };
        matrix[3] = new char[] { 'L', 'B', 'V', 'M' };
        return matrix;
    }
}