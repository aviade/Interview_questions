package com.samples.paintfill;

import com.samples.core.Matrix;

/**
 * Created by avezra on 7/6/2017.
 */
public class PaintFillerRecursive implements PaintFiller {

    @Override
    public void fill(Matrix matrix, int rowIndex, int columnIndex, char target, char replacement) {
        Boolean[][] visited = PaintFillerTool.createdVisitedMatrix(matrix);

        fillRecursive(matrix, rowIndex, columnIndex, visited, target, replacement);
    }

    private static void fillRecursive(
            Matrix matrix,
            int rowIndex,
            int columnIndex,
            Boolean[][] visited,
            char target,
            char replacement) {

        if (!matrix.isInRange(rowIndex, columnIndex)) {
            return;
        }

        if (visited[rowIndex][columnIndex]) {
            return;
        }
        visited[rowIndex][columnIndex] = true;

        final Character nextColor = matrix.get(rowIndex, columnIndex);
        if (nextColor != target) {
            return;
        }

        // Apply color
        matrix.set(rowIndex, columnIndex, replacement);

        // Look downward
        fillRecursive(matrix, rowIndex + 1, columnIndex, visited, target, replacement);

        // Look up
        fillRecursive(matrix, rowIndex - 1, columnIndex, visited, target, replacement);

        // Look to the right
        fillRecursive(matrix, rowIndex, columnIndex + 1, visited, target, replacement);

        // Look to the left
        fillRecursive(matrix, rowIndex, columnIndex - 1, visited, target, replacement);
    }
}
