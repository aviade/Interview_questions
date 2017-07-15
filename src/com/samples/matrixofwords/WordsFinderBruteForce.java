package com.samples.matrixofwords;

import com.samples.core.Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avezra on 6/29/2017.
 */
public class WordsFinderBruteForce implements WordsFinder{
    @Override
    public List<String> findWordsInMatrix(Matrix matrix, String[] lookupList){
        final int rows = matrix.getRows();
        final int columns = matrix.getColumns();

        if (rows == 0 || columns == 0)
        {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                StringBuilder buffer = new StringBuilder();
                findWordRecursive(matrix, lookupList, row, column, buffer, result);
            }
        }

        return result;
    }

    private static void findWordRecursive(
            Matrix matrix,
            String[] lookupList,
            int row,
            int column,
            StringBuilder buffer,
            List<String> result) {

        // Base case - check if point is out of range
        Boolean inRange = matrix.isInRange(row, column);
        if (!inRange){
            return;
        }

        StringBuilder newBuffer = new StringBuilder();
        newBuffer.append(buffer);
        newBuffer.append(matrix.get(row, column));

        // Check if we found the word
        final String newWord = newBuffer.toString();
        Boolean wordFound = checkIfWordInList(newWord, lookupList);
        if (wordFound){
            result.add(newWord);
        }

        // Look down
        findWordRecursive(matrix, lookupList, row+1, column, newBuffer, result);

        // Look right
        findWordRecursive(matrix, lookupList, row, column+1, newBuffer, result);

        // Look diagonal
        findWordRecursive(matrix, lookupList, row+1, column+1, newBuffer, result);
    }

    private static Boolean checkIfWordInList(String s, String[] lookupList) {
        for (String lookupItem : lookupList) {
            if (lookupItem.equals(s)) {
                return true;
            }
        }
        return false;
    }
}
