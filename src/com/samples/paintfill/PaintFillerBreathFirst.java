package com.samples.paintfill;

import com.samples.core.Matrix;

import java.util.LinkedList;

/**
 * Created by avezra on 7/7/2017.
 */
public class PaintFillerBreathFirst implements PaintFiller {
    @Override
    public void fill(Matrix matrix, int rowIndex, int columnIndex, char target, char replacement) {
        LinkedList<MatrixPoint> queue = new LinkedList<>();

        Boolean[][] visited = PaintFillerTool.createdVisitedMatrix(matrix);

        queue.add(new MatrixPoint(rowIndex, columnIndex));

        while (!queue.isEmpty()) {
            MatrixPoint nextPoint = queue.poll();
            rowIndex = nextPoint.row;
            columnIndex = nextPoint.column;

            // Check range
            if (!matrix.isInRange(rowIndex, columnIndex)) {
                continue;
            }

            // Don't the same node twice
            if (visited[rowIndex][columnIndex]) {
                continue;
            }

            // Check if cell needs replacement
            final Character nextColor = matrix.get(rowIndex, columnIndex);
            if (nextColor != target) {
                continue;
            }
            // Apply color
            matrix.set(rowIndex, columnIndex, replacement);

            // Add next steps to the adjacent nodes (up, down, right, left)
            queue.add(new MatrixPoint(rowIndex + 1, columnIndex));
            queue.add(new MatrixPoint(rowIndex - 1, columnIndex));
            queue.add(new MatrixPoint(rowIndex, columnIndex + 1));
            queue.add(new MatrixPoint(rowIndex, columnIndex - 1));

        }
    }
}
