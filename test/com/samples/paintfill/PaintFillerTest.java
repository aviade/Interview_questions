package com.samples.paintfill;

import com.samples.core.Matrix;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by avezra on 7/6/2017.
 */
public class PaintFillerTest {
    private static final boolean USE_BREATH_FIRST = false;

    @Test
    public void fill_small() throws Exception {

        Matrix matrix = new Matrix(getSmallMatrix());

        PaintFiller paintFiller = createPaintFiller(USE_BREATH_FIRST);

        paintFiller.fill(matrix, 1, 2, ' ', 'g');

        Matrix expectedMatrix = new Matrix(getExpectedSmallMatrix());
        compareMatrix(matrix, expectedMatrix);
    }

    @Test
    public void fill_big() throws Exception {

        Matrix matrix = new Matrix(getBigMatrix());

        PaintFiller paintFiller = createPaintFiller(USE_BREATH_FIRST);

        paintFiller.fill(matrix, 4, 1, ' ', 'g');

        Matrix expectedMatrix = new Matrix(getExpectedBigMatrix());
        compareMatrix(matrix, expectedMatrix);
    }

    private PaintFiller createPaintFiller(boolean useBreathFirst) {
        if (useBreathFirst) {
            return new PaintFillerBreathFirst();
        }
        return new PaintFillerRecursive();
    }

    private void compareMatrix(Matrix matrix, Matrix expectedMatrix) {
        for (int row = 0; row < matrix.getRows(); row++) {
            for (int column = 0; column < matrix.getColumns(); column++) {
                final Character expected = expectedMatrix.get(row, column);
                final Character actual = matrix.get(row, column);
                final String message = String.format("Mismatch at row: %d, col: %d", row, column);
                assertEquals(message, expected, actual);
            }
        }
    }

    private char[][] getSmallMatrix() {
        char[][] matrix = new char[4][];
        matrix[0] = new char[]{'r', 'r', ' ', 'r'};
        matrix[1] = new char[]{'r', ' ', ' ', 'r'};
        matrix[2] = new char[]{'r', 'r', ' ', 'r'};
        matrix[3] = new char[]{'r', ' ', 'r', 'r'};
        return matrix;
    }

    private char[][] getExpectedSmallMatrix() {
        char[][] matrix = new char[4][];
        matrix[0] = new char[]{'r', 'r', 'g', 'r'};
        matrix[1] = new char[]{'r', 'g', 'g', 'r'};
        matrix[2] = new char[]{'r', 'r', 'g', 'r'};
        matrix[3] = new char[]{'r', ' ', 'r', 'r'};
        return matrix;
    }

    private char[][] getBigMatrix() {
        char[][] matrix = new char[6][];
        matrix[0] = new char[]{'r', ' ', ' ', ' ', ' ', ' '};
        matrix[1] = new char[]{'r', ' ', ' ', ' ', ' ', ' '};
        matrix[2] = new char[]{'r', ' ', ' ', ' ', ' ', ' '};
        matrix[3] = new char[]{'r', 'r', 'r', 'r', ' ', ' '};
        matrix[4] = new char[]{'r', ' ', ' ', 'r', ' ', ' '};
        matrix[5] = new char[]{'r', ' ', 'r', 'r', ' ', ' '};
        return matrix;
    }

    private char[][] getExpectedBigMatrix() {
        char[][] matrix = new char[6][];
        matrix[0] = new char[]{'r', ' ', ' ', ' ', ' ', ' '};
        matrix[1] = new char[]{'r', ' ', ' ', ' ', ' ', ' '};
        matrix[2] = new char[]{'r', ' ', ' ', ' ', ' ', ' '};
        matrix[3] = new char[]{'r', 'r', 'r', 'r', ' ', ' '};
        matrix[4] = new char[]{'r', 'g', 'g', 'r', ' ', ' '};
        matrix[5] = new char[]{'r', 'g', 'r', 'r', ' ', ' '};
        return matrix;
    }
}